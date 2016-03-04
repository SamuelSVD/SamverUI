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
    sketch.beginShape(sketch.TRIANGLE_STRIP);
//    System.out.print("Start shape:");
    for (int i = 0; i < points.size()/3; i++) {
      sketch.vertex(points.get(i*3),points.get(i*3+1),points.get(i*3+2));
//      System.out.print("("+Float.toString(points.get(i*3))+","+Float.toString(points.get(i*3+1))+","+Float.toString(points.get(i*3+2))+") ");
    }
//    System.out.println();
    sketch.endShape();
  }
  public static void draw_rect_mesh_3D(ArrayList<Float> points, ArrayList<Float> points2, Sketch sketch) {
    for (int i = 0; i < points.size()/3-2; i++) {
      ArrayList<Float> temp_rect = new ArrayList<Float>();
      temp_rect.add(points.get(i*3));
      temp_rect.add(points.get(i*3+1));
      temp_rect.add(points.get(i*3+2));
      temp_rect.add(points.get((i+1)*3));
      temp_rect.add(points.get((i+1)*3+1));
      temp_rect.add(points.get((i+1)*3+2));
      temp_rect.add(points2.get(i*3));
      temp_rect.add(points2.get(i*3+1));
      temp_rect.add(points2.get(i*3+2));
      temp_rect.add(points2.get((i+1)*3));
      temp_rect.add(points2.get((i+1)*3+1));
      temp_rect.add(points2.get((i+1)*3+2));
      draw_shape_3D(temp_rect, sketch);
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
}
