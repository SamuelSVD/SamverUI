package ProcessingJava;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import ProcessingJava.ShapeUtils.Vertex;

public class ShapeUtils {
	public ShapeUtils() {}
	public static class Vertex {
		public double x, y, z;
		public Vertex() {
			this(0,0,0);
		}
		public Vertex(double x, double y) {
			this(x, y, 0);
		}
		public Vertex(double x, double y, double z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	public static ArrayList<Vertex> loadVerticesFromFile(String filename) throws Exception{
		ArrayList<Vertex> vertices = new ArrayList<Vertex>();
		File file = new File(filename);
    Scanner in = new Scanner(file);
    Vertex v = new Vertex();
    boolean isX = true;
    while (in.hasNext()) {
      double a = in.nextDouble();
      System.out.println(a);
      if (isX) {
    		v.x = a;
    	} else {
    		v.y = a;
    		vertices.add(v);
    		v = new Vertex();
    	}
  		isX = !isX;
    }
    in.close();
    return vertices;
	}
	public static ArrayList<Double> loadPointsFromFile(String filename) throws Exception{
		return toPoints(loadVerticesFromFile(filename));
	}
  public static ArrayList<Vertex> getCicle(double x, double y, double radius, double starting_angle, double ending_angle, int num_points) {
    ArrayList<Vertex> points = new ArrayList<Vertex>();
    double dT = (ending_angle - starting_angle)/(num_points-1);
    for (int i = 0; i < num_points; i++) {
    	Vertex v = new Vertex();
    	v.x = x + radius * Math.cos(starting_angle + i * dT);
    	v.y = y + radius * Math.sin(starting_angle + i * dT);
    	points.add(v);
    }
    return points;
  }
  public static ArrayList<Double> toPoints(ArrayList<Vertex> vertices) {
  	ArrayList<Double> points = new ArrayList<Double>();
  	for (int i = 0; i < vertices.size(); i++) {
  		points.add(vertices.get(i).x);
  		points.add(vertices.get(i).y);
  	}
  	return points;
  }
  public static ArrayList<Vertex> fromPoints(ArrayList<Double> points) {
  	ArrayList<Vertex> vertices = new ArrayList<Vertex>();
  	for (int i = 0; i < points.size()/2; i++) {
  		Vertex v = new Vertex();
  		v.x = points.get(i*2);
  		v.y = points.get((i*2)+1);
  	}
  	return vertices;
  }
}
