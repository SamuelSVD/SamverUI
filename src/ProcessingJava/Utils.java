package ProcessingJava;
import processing.core.*;
import java.util.ArrayList;

public class Utils {
  public static void draw_shape(ArrayList<Float> points, Sketch sketch) {
    sketch.beginShape();
    System.out.print("Start shape:");
    for (int i = 0; i < points.size()/2; i++) {
      sketch.vertex(points.get(i*2),points.get(i*2+1));
      System.out.print("("+Float.toString(points.get(i*2))+","+Float.toString(points.get(i*2+1))+") ");
    }
    System.out.println();
    sketch.endShape();
  }
  public static void draw_rect_mesh(ArrayList<Float> points, ArrayList<Float> points2, Sketch sketch) {
    for (int i = 0; i < points.size()/2-1; i++) {
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
}
