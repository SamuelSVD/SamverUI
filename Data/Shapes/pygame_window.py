import pygame
from pygame.locals import *
import time
from abc import ABCMeta, abstractmethod
import math
import datetime

class Component:
	__metaclass__= ABCMeta
	positon = [0,0]
	screen = None
	@abstractmethod
	def __init__(self, position): pass
	@abstractmethod
	def setScreen(self, screen): pass
	@abstractmethod
	def update(self, delta): pass
	@abstractmethod
	def draw(self): pass
	@abstractmethod
	def handleEvent(self, event): pass
	
class Point:
	x = 0
	y = 0
	def __init__(self, x, y):
		self.x = x
		self.y = y

class PointManager:
	pointsList = []
	screen = 0
	scale = 1
	def __init__(self, screen, scale):
		self.screen = screen
		self.scale = scale
	def createPoint(self, mousePos):
		return self.toPoint(mousePos);
	def appendPoint(self, point):
		self.pointsList.append(point)
	def insert(self, index, point):
		self.pointsList.insert(index, point)
	def insertBefore(self, reference, point):
		if reference in self.pointsList:
			index = self.pointsList.index(reference)
			self.pointsList.insert( index, point)
		else:
			self.appendPoint(point)
	def insertAfter(self, reference, point):
		if reference in self.pointsList:
			index = self.pointsList.index(reference) + 1
			self.pointsList.insert( index , point)
		else:
			self.appendPoint(point)
	def select(self, mousePos, distance):
		point = self.toPoint(mousePos)
		for i in range(len(self.pointsList)):
			x = point.x - self.pointsList[i].x
			y = point.y - self.pointsList[i].y
			if math.sqrt(x*x+y*y) < distance:
				return self.pointsList[i]
		return 0
	def draw(self):
		for i in range(len(self.pointsList)):
			current_point = self.toMousePos(self.pointsList[i])
			if i != (len(self.pointsList) - 1):
				next_point = self.toMousePos(self.pointsList[i+1])
				pygame.draw.line(self.screen, (0,0,0), current_point, next_point)
			pygame.draw.ellipse(self.screen, (0, 0, 0), (current_point[0]-5, current_point[1]-5,10,10))
	def drawSelected(self, selected):
		if selected != 0:
			selected = self.toMousePos(selected)
			pygame.draw.ellipse(self.screen, (200, 0, 0), (selected[0]-5, selected[1]-5,10,10))
	def toMousePos(self, point):
		offset = self.screen.get_size()
		x = point.x * self.scale + offset[0]
		y = point.y * self.scale + offset[1]
		return (x, y)
	def toPoint(self, mousePos):
		offset = self.screen.get_size()
		x = ( mousePos[0] - offset[0] ) / (1.0 * self.scale)
		y = ( mousePos[1] - offset[1] ) / (1.0 * self.scale)
		return Point(x, y)
	def remove(self, point):
		if point in self.pointsList:
			self.pointsList.remove(point)
	def clear(self):
		self.pointsList = []
	def save(self, filename):
		file = open(filename, 'w')
		for point in self.pointsList:
			print point
			file.write(str(point.x))
			file.write(' ')
			file.write(str(point.y))
			file.write(' ')
		file.close()
class ShapeMaker(Component):
	NONE = 0
	INSERT_BEFORE = 1
	INSERT_AFTER = 2
	MOVE = 3
	states = ['NONE', 'INSERT BEFORE', 'INSERT AFTER', 'MOVE']
	state = NONE
	points = 0
	font = 0
	selectedPoint = 0
	def __init__(self, position):
		pygame.font.init()
		self.font = pygame.font.SysFont("Comic Sans MS", 16)
	def setScreen(self, screen):
		self.screen = screen
		self.points = PointManager(screen, 100)
	def update(self, delta): pass
	def draw(self):
		pygame.draw.rect(self.screen, (255,255,255), [0, 0, self.screen.get_width(), self.screen.get_height()	])
		for i in range(self.screen.get_width()/2 - 500, self.screen.get_width()/2 + 500, 100):
			pygame.draw.line(self.screen, (150, 150, 150), (i, 0), (i, self.screen.get_height()))
		pygame.draw.line(self.screen, (0, 0, 0), (self.screen.get_width()/2, 0), (self.screen.get_width()/2, self.screen.get_height()), 2)
		for i in range(self.screen.get_height()/2 - 500, self.screen.get_height()/2 + 500, 100):
			pygame.draw.line(self.screen, (150, 150, 150), (0, i), (self.screen.get_width(), i))
		pygame.draw.line(self.screen, (0, 0, 0), (0, self.screen.get_height()/2), (self.screen.get_width(), self.screen.get_height()/2), 2)
		
		self.screen.blit(self.font.render(str(self.states[self.state]), False, (0,0,0)) ,(0,0))
		self.screen.blit(self.font.render(str(self.selectedPoint), False, (0,0,0)) ,(0,20))
		self.points.draw()
		self.points.drawSelected(self.selectedPoint)
	def handleEvent(self, event):
		if event.type == pygame.MOUSEBUTTONDOWN:
			mouse_pos = pygame.mouse.get_pos()
			point = self.points.createPoint(mouse_pos)
			if self.state == self.INSERT_AFTER:
				self.points.insertAfter(self.selectedPoint, point)
				self.selectedPoint = point
			if self.state == self.INSERT_BEFORE:
				self.points.insertBefore(self.selectedPoint, point)
				self.selectedPoint = point
			if self.state == self.NONE:
				self.selectedPoint = self.points.select(mouse_pos, 0.1)
			if self.state == self.MOVE:
				if self.selectedPoint != 0:
					self.selectedPoint.x = pygame.mouse.get_pos()[0]
					self.selectedPoint.y = pygame.mouse.get_pos()[1]
		if event.type == pygame.MOUSEBUTTONUP:
			pass
		if event.type == pygame.KEYUP:
			pass
		if event.type == pygame.KEYDOWN:
			if event.key == K_c:
				self.points.clear()
				self.selectedPoint = 0
			if event.key == K_SPACE:
				self.points.save( datetime.datetime.now().strftime('%Y%m%d_%H%M%S')+'.pts')
			if event.key == K_INSERT:
				if self.state == self.INSERT_AFTER:
					self.state = self.INSERT_BEFORE
				elif self.state == self.INSERT_BEFORE:
					self.state = self.NONE
				else:
					self.state = self.INSERT_AFTER
			if event.key == K_DELETE:
				if self.selectedPoint != 0:
					self.points.remove(self.selectedPoint)
					self.selectedPoint = 0
			if event.key == K_ESCAPE:
				if self.state != self.NONE:
					self.state = self.NONE
				else:
					CRASH;

class Window:
	def __init__(self, size, caption):
		self.screen = pygame.display.set_mode(size)
		pygame.display.set_caption(caption)
		self.components = []
		self.clock = pygame.time.Clock()
	def addComponent(self, component):
		self.components.append(component)
		component.setScreen(self.screen)
	def run(self):
		running = True
		previous_time = time.time()
		self.clock.tick(33)
		while running:
			for event in pygame.event.get():
				if event.type == pygame.QUIT:
					running = False
					pygame.quit()
				for c in self.components:
					c.handleEvent(event)
			if not running: break
			delta = self.clock.tick()/1000.			
			for c in self.components:
				c.update(delta)
				c.draw()
			pygame.display.flip()

win = Window((500,500),'Pygame Window')
win.addComponent(ShapeMaker((0,0)))
win.run()