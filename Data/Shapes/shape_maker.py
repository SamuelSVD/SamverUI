import math

shape = 1;
if shape == 0:
  file = open("circle.pts", "w")
  for i in range(200):
    file.write(repr((math.cos(math.pi/100.0*i)+1)/2.0))
    file.write(" ")
    file.write(repr((math.sin(math.pi/100.0*i)+1)/2.0))
    file.write(" ")
  file.close()

if shape == 1:
  file = open("tear.pts", "w")
  #large semi-circle
  for i in range(0,100):
    x = (math.cos(math.pi/100.0*i)+1)/2.0
    file.write(repr(x))
    file.write(" ")
    y = (math.sin(math.pi/100.0*i)+1)/2.0
    file.write(repr(y))
    file.write(" ")
  #small semi-circle 1
  for i in range(0,50):
    x = (math.cos(math.pi-math.pi/50.0*i)+1)/4.0
    file.write(repr(x))
    file.write(" ")
    y = -(math.sin(math.pi/50.0*i)+1)/4.0+0.75
    file.write(repr(y))
    file.write(" ")
  #small semi-circle 2
  for i in range(0,50):
    x = (math.cos(math.pi-math.pi/50.0*i)+1)/4.0+0.5
    file.write(repr(x))
    file.write(" ")
    y = (math.sin(math.pi/50.0*i)+1)/4.0+0.25
    file.write(repr(y))
    file.write(" ")
  file.close()
