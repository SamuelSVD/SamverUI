package ProcessingJava;
import processing.core.*;
import java.util.ArrayList;

public class Utils {
  public static void draw_shape(ArrayList<Float> points, Sketch sketch) {
    sketch.beginShape();
//    System.out.print("Start shape:");
    for (int i = 0; i < points.size()/2; i++) {
      sketch.vertex(points.get(i*2),points.get(i*2+1));
//      System.out.print("("+Float.toString(points.get(i*2))+","+Float.toString(points.get(i*2+1))+") ");
    }
//    System.out.println();
    sketch.endShape();
  }
  public static void draw_rect_mesh(ArrayList<Float> points, ArrayList<Float> points2, Sketch sketch) {
    for (int i = 0; i < points.size()/3-2; i++) {
      ArrayList<Float> temp_rect = new ArrayList<Float>();
      temp_rect.add(points.get(i*2));
      temp_rect.add(points.get(i*2+1));
      temp_rect.add(points.get((i+1)*2));
      temp_rect.add(points.get((i+1)*2+1));
      temp_rect.add(points2.get((i+1)*2));
      temp_rect.add(points2.get((i+1)*2+1));
      temp_rect.add(points2.get(i*2));
      temp_rect.add(points2.get(i*2+1));
      draw_shape(temp_rect, sketch);
    }
  }
  
  public static void draw_shape_3D(ArrayList<Float> points, Sketch sketch) {
    draw_shape_3D(points, sketch.TRIANGLE_STRIP, sketch);
  }
  public static void draw_shape_3D(ArrayList<Float> points, int mode, Sketch sketch) {
//    sketch.beginShape(sketch.TRIANGLE_STRIP);
    sketch.beginShape(mode);
    for (int i = 0; i < points.size()/3; i++) {
      float x = points.get(i*3);
      float y = points.get(i*3+1);
      float z = points.get(i*3+2);
      sketch.vertex((int)x,(int)y,(int)z);
    }
    sketch.endShape(sketch.CLOSE);
  }
  public static void draw_rect_mesh_3D(ArrayList<Float> points, ArrayList<Float> points2, Sketch sketch) {
    for (int i = 0; i < points.size()/3-1; i++) {
      ArrayList<Float> temp_rect = new ArrayList<Float>();
      temp_rect.add(points.get(i*3));
      temp_rect.add(points.get(i*3+1));
      temp_rect.add(points.get(i*3+2));
      temp_rect.add(points2.get(i*3));
      temp_rect.add(points2.get(i*3+1));
      temp_rect.add(points2.get(i*3+2));
      temp_rect.add(points.get((i+1)*3));
      temp_rect.add(points.get((i+1)*3+1));
      temp_rect.add(points.get((i+1)*3+2));
      temp_rect.add(points2.get((i+1)*3));
      temp_rect.add(points2.get((i+1)*3+1));
      temp_rect.add(points2.get((i+1)*3+2));
      draw_shape_3D(temp_rect, sketch);
//      System.out.println("Drawing");
    }
  }
  public static void drawAxes(Sketch sketch, int length) {
    //Red X
    sketch.stroke(255,0,0);
    sketch.line(0,0,0,length,0,0);
    sketch.translate(length,0,0);
    sketch.box(10);
    sketch.translate(-length,0,0);
    //Green Y
    sketch.stroke(0,255,0);
    sketch.line(0,0,0,0,length,0);
    sketch.translate(0,length,0);
    sketch.box(10);
    sketch.translate(0,-length,0);
    //Blue Z
    sketch.stroke(0,0,255);
    sketch.line(0,0,0,0,0,length);
    sketch.translate(0,0,length);
    sketch.box(10);
    sketch.translate(0,0,-length);
  }
  public static ArrayList<Float> doubleToFloat(ArrayList<Double> p) {
    ArrayList<Float> points = new ArrayList<Float>();
    for (int i = 0; i < p.size(); i++) {
      points.add(new Float(p.get(i)));
    }
    return points;
  }
  public static PVector randomPVector() {
    return new PVector((float)Math.random()*255, (float)Math.random()*255, (float)Math.random()*255);
  }
  
  public static double angleBetween(PVector v1, PVector v2) {
  	double dot = v1.x*v2.x+v1.y*v2.y+v2.z*v2.z;
  	double cross = new PVector(v1.y*v2.z-v1.z*v2.y, v1.z*v2.x-v1.x*v2.z,v1.x*v2.y-v1.y*v2.x).mag();
  	double mag = v1.mag() * v2.mag();
  	double cosAngle = Math.acos(dot/mag);
  	return cosAngle;
  }
}
