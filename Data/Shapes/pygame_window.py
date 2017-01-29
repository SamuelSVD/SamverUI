import pygame
from pygame.locals import *
import time
from abc import ABCMeta, abstractmethod
import math
import datetime
import easygui
import os
import json

FILE_DIR = os.path.dirname(__file__)
FILE_PATH = __file__
SCROLL_UP = 4
SCROLL_DOWN = 5
print FILE_DIR
print FILE_PATH
#Program States
psNone = 0
psInsertBefore = 1
psInsertAfter = 2
psMove = 3
program_states = ['NONE', 'INSERT BEFORE', 'INSERT AFTER', 'MOVE']

#Mouse States
msNone = 0
msLeft = 1
msRight = 2
msMiddle = 3
mouse_states = ['NONE', 'LEFT', 'RIGHT', 'MIDDLE']

class Options:
	version = '1.0.0.0'
	options = {'version': version}
	options_path = FILE_DIR + '\config.json'
	def __init__(self):
		print 
		self.Load()
	def Load(self):
		self.options = json.load(open(self.options_path,'r'))
	def Save(self):
		json.dump(self.options, open(self.options_path, 'w'))
options = Options()
options.Save()
print FILE_PATH
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
	@abstractmethod
	def OnMouseClick(self, event): pass
	@abstractmethod
	def OnMouseDrag(self, event): pass
	@abstractmethod
	def OnMouseRelease(self, event): pass
	@abstractmethod
	def OnKeyPress(self, event): pass
	@abstractmethod
	def OnKeyRelease(self, event): pass
	
class Point:
	x = 0
	y = 0
	def __init__(self, x, y):
		self.x = x
		self.y = y

class PointManager:
	pointsList = []
	screen = 0
	offset = (0,0)
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
			current_point = self.toScreenPos(self.pointsList[i])
			if i != (len(self.pointsList) - 1):
				next_point = self.toScreenPos(self.pointsList[i+1])
				pygame.draw.line(self.screen, (0,0,0), current_point, next_point)
			pygame.draw.ellipse(self.screen, (0, 0, 0), (current_point[0]-5, current_point[1]-5,10,10))
	def drawSelected(self, selected):
		if selected != 0:
			selected = self.toScreenPos(selected)
			pygame.draw.ellipse(self.screen, (200, 0, 0), (selected[0]-5, selected[1]-5,10,10))
	def toScreenPos(self, point):
		x = point.x * self.scale + self.offset[0]
		y = (-point.y) * self.scale + self.offset[1]
		return (x, y)
	def toPoint(self, mousePos):
		x = ( mousePos[0] - self.offset[0] ) / (1.0 * self.scale)
		y = -( mousePos[1] - self.offset[1] ) / (1.0 * self.scale)
		return Point(x, y)
	def remove(self, point):
		if point in self.pointsList:
			self.pointsList.remove(point)
	def clear(self):
		self.pointsList = []
	def save(self, filename):
		print 'Saving to: ', filename
		file = open(filename, 'w')
		for point in self.pointsList:
			file.write(str(point.x))
			file.write(' ')
			file.write(str(point.y))
			file.write(' ')
		file.close()
		print 'Finished saving'
	def open(self, filename):
		print 'Opening: ', filename
		self.pointsList = []
		file = open(filename, 'r')
		numbers = file.read()
		numbers = numbers.split()
		x = None
		y = None
		for number in numbers:
			print number
			if x == None:
				x = float(number)
			else:
				y = float(number)
				self.pointsList.append(Point(x, y))
				x = None
				y = None
class ShapeMaker(Component):
	state = psNone
	mouse_state = msNone
	points = 0
	font = 0
	selectedPoint = 0
	image = 0
	offset = (0, 0)
	scale = 100
	image_offset = (0,0)
	def __init__(self, position):
		pygame.font.init()
		self.font = pygame.font.SysFont("Comic Sans MS", 16)
	def setScreen(self, screen):
		self.screen = screen
		self.points = PointManager(screen, self.scale)
		self.offset = (self.screen.get_width()/ 2, self.screen.get_height() / 2)
		self.image_offset = self.offset
		self.points.offset = self.offset
	def update(self, delta): pass
	def draw(self):
		origin = self.offset
		pygame.draw.rect(self.screen, (255,255,255), [0, 0, self.screen.get_width(), self.screen.get_height()	])
		if self.image != 0:
			self.screen.blit(self.image, self.image_offset)
		num_lines = self.screen.get_width() / self.scale
		for i in range(-num_lines, num_lines):
			x = self.offset[0] % self.screen.get_width() + self.scale * i
			pygame.draw.line(self.screen, (150, 150, 150), (x, 0), (x, self.screen.get_height()))
		pygame.draw.line(self.screen, (0, 0, 0), (self.offset[0], 0), (self.offset[0], self.screen.get_height()), 2)
		num_lines = self.screen.get_height() / self.scale
		for i in range(-num_lines, num_lines):
			y = self.offset[1] % self.screen.get_height() + self.scale * i
			pygame.draw.line(self.screen, (150, 150, 150), (0, y), (self.screen.get_width(), y))
		pygame.draw.line(self.screen, (0, 0, 0), (0, self.offset[1]), (self.screen.get_width(), self.offset[1]), 2)
		
		self.screen.blit(self.font.render(options.version, False, (0,0,0)) ,(0,0))
		self.screen.blit(self.font.render(program_states[self.state], False, (0,0,0)) ,(0,20))
		self.screen.blit(self.font.render(mouse_states[self.mouse_state], False, (0,0,0)) ,(0,40))
		self.points.draw()
		self.points.drawSelected(self.selectedPoint)
	def handleEvent(self, event): pass
	def OnMouseClick(self, event):
		if self.mouse_state == msNone:
			if event.button == SCROLL_UP:
				self.scale += 1
			elif event.button == SCROLL_DOWN:
				if self.scale > 1:
					self.scale -= 1
			self.points.scale = self.scale
			if pygame.mouse.get_pressed()[0]:
				self.mouse_state = msLeft
				mouse_pos = pygame.mouse.get_pos()
				point = self.points.createPoint(mouse_pos)
				if self.state == psInsertAfter:
					self.points.insertAfter(self.selectedPoint, point)
					self.selectedPoint = point
				if self.state == psInsertBefore:
					self.points.insertBefore(self.selectedPoint, point)
					self.selectedPoint = point
				if self.state == psNone:
					self.selectedPoint = self.points.select(mouse_pos, 0.1)
				if self.state == psNone:
					if self.selectedPoint != 0:
						self.selectedPoint.x = point.x
						self.selectedPoint.y = point.y
			elif pygame.mouse.get_pressed()[2]:
				self.mouse_state = msRight
			elif pygame.mouse.get_pressed()[1]:
				self.mouse_state = msMiddle
	def OnMouseDrag(self, event):
		mouse_pos = pygame.mouse.get_pos()
		rel = pygame.mouse.get_rel()
		if self.mouse_state == msLeft:
			point = self.points.createPoint(mouse_pos)
			if self.selectedPoint != 0 and event.buttons[0]:
				self.selectedPoint.x = point.x;
				self.selectedPoint.y = point.y;
		elif self.mouse_state == msRight:
			self.image_offset = (self.image_offset[0] + rel[0], self.image_offset[1] + rel[1])
		elif self.mouse_state == msMiddle:
			self.offset = (self.offset[0] + rel[0], self.offset[1] + rel[1])
			self.points.offset = self.offset
	def OnMouseRelease(self, event):
		pressed = pygame.mouse.get_pressed()
		if self.mouse_state == msLeft:
			if not pressed[0]:
				self.mouse_state = msNone
		elif self.mouse_state == msRight:
			if not pressed[2]:
				self.mouse_state = msNone
		elif self.mouse_state == msMiddle:
			if not pressed[1]:
				self.mouse_state = msNone
	def OnKeyPress(self, event):
		if event.key == K_c:
			self.points.clear()
			self.selectedPoint = 0
		if event.key == K_o:
			filename = easygui.fileopenbox(filetypes = ['*.pts'])
			self.points.open( filename )
		if event.key == K_i:
			#try:
				self.image = pygame.image.load(easygui.fileopenbox(filetypes = ['*.jpg']))
			#except:
				pass
		if event.key == K_SPACE:
			filename = easygui.filesavebox(default = datetime.datetime.now().strftime('%Y%m%d_%H%M%S')+'.pts', filetypes = ['*.pts'])
			if filename: 
				self.points.save( filename )
		if event.key == K_INSERT:
			if self.state == psInsertAfter:
				self.state = psInsertBefore
			elif self.state == psInsertBefore:
				self.state = psNone
			else:
				self.state = psInsertAfter
		if event.key == K_DELETE:
			if self.selectedPoint != 0:
				self.points.remove(self.selectedPoint)
				self.selectedPoint = 0
		if event.key == K_ESCAPE:
			if self.state != psNone:
				self.state = psNone
			else:
				CRASH;
	def OnKeyRelease(self, event): pass
	
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
					if event.type == pygame.MOUSEBUTTONDOWN:
						c.OnMouseClick(event)
					elif event.type == pygame.MOUSEMOTION:
						c.OnMouseDrag(event)
					elif event.type == pygame.MOUSEBUTTONUP:
						c.OnMouseRelease(event)
					elif event.type == pygame.KEYDOWN:
						c.OnKeyPress(event)
					elif event.type == pygame.KEYUP:
						c.OnKeyRelease(event)
			if not running: break
			delta = self.clock.tick()/1000.			
			for c in self.components:
				c.update(delta)
				c.draw()
			pygame.display.flip()

win = Window((500,500),'Pygame Window')
win.addComponent(ShapeMaker((0,0)))
win.run()