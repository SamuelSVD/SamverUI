package ProcessingJava;

import processing.core.PVector;
import ProcessingJava.ShapeUtils.*;
import java.util.ArrayList;
import java.util.Scanner;
import Math.*;
import java.io.File;
import ProcessingJava.ShapeUtils;

public class Shape extends VisualComponent{
	
  public static int RESOLUTION = 100; 
  ArrayList<Vertex> vertices;
  ArrayList<Double> points;
  PVector size;
  boolean extrude = false;
  double fromZ = 0;
  double toZ = 0;
  public Shape(PVector position, PVector colour) {
    this(position, colour, new PVector(1,1));
  }
  public Shape(PVector position, PVector colour, PVector size) {
    this(position, colour, size, 0);
  }
  public Shape(PVector position, PVector colour, PVector size, double rotation) {
    super(position, colour);
    points = new ArrayList<Double>();
    vertices = new ArrayList<Vertex>();
    this.size = size;
    this.rotation_after_translate = rotation;
  }
  public void init(String filename) throws Exception{
  	vertices = ShapeUtils.loadVerticesFromFile(filename);
  }
  public void set3D(double fromZ, double toZ) {
  	extrude = true;
  	this.fromZ = fromZ;
  	this.toZ = toZ;
  }
  public void init(ArrayList<Double> points) {
    this.points = points;
  }
  public void draw() {
    super.draw();
    if (extrude) {
    	draw3D();
    } else {
    	draw2D();
    }
    System.out.println(sketch.screenX(100, 100, 100));
  }
  private void draw2D() {
    sketch.fill(colour.x, colour.y, colour.z);
    sketch.beginShape();
    for (int i = 0; i < vertices.size(); i++) {
      sketch.vertex((float)(vertices.get(i).x*size.x),(float)(vertices.get(i).y*size.y));
    }
    sketch.endShape();
  }
  private void draw3D() {
    sketch.fill(colour.x, colour.y, colour.z);
    sketch.beginShape();
    for (int i = 0; i < vertices.size(); i++) {
      sketch.vertex((float)(vertices.get(i).x*size.x),(float)(vertices.get(i).y*size.y), (float)fromZ);
    }
    sketch.endShape();

    sketch.beginShape();
    for (int i = 0; i < vertices.size(); i++) {
      sketch.vertex((float)(vertices.get(i).x*size.x),(float)(vertices.get(i).y*size.y), (float)toZ);
    }
    sketch.endShape();
    for (int i = 0; i < vertices.size() - 1; i++) {
    	sketch.beginShape();
      sketch.vertex((float)(vertices.get(i).x*size.x),(float)(vertices.get(i).y*size.y), (float)fromZ);
      sketch.vertex((float)(vertices.get(i+1).x*size.x),(float)(vertices.get(i+1).y*size.y), (float)fromZ);
      sketch.vertex((float)(vertices.get(i+1).x*size.x),(float)(vertices.get(i+1).y*size.y), (float)toZ);
      sketch.vertex((float)(vertices.get(i).x*size.x),(float)(vertices.get(i).y*size.y), (float)toZ);
      sketch.endShape();
    }
  }
}
