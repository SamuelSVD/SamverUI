package ProcessingJava;

import processing.core.PVector;

import java.util.ArrayList;

import Math.*;
public class Band extends VisualComponent{
  Function x0, y0, z0, x1, y1, z1;
  ArrayList <Float> row0, row1;
  double begin, end;
  int sections;
  public Band(PVector colour, Function x0, Function y0, Function z0, Function x1, Function y1, Function z1, double begin_time, double end_time, int sections) {
    this(new PVector(), colour, x0, y0, z0, x1, y1, z1, begin_time, end_time, sections);
  }
  public Band(PVector position, PVector colour, Function x0, Function y0, Function z0, Function x1, Function y1, Function z1, double begin_time, double end_time, int sections) {
    super(position, colour);
    this.x0 = x0;
    this.x1 = x1;
    this.y0 = y0;
    this.y1 = y1;
    this.z0 = z0;
    this.z1 = z1;
    this.begin = begin_time;
    this.end = end_time;
    this.sections = sections;
    makeBand();
  }
  public void draw() {
//    System.out.println(row0.size());
//    System.out.println(row1.size());
    Utils.draw_rect_mesh_3D(row1, row0, sketch);
  }
  public void update(float d) {
    super.update(d);
    //Maybe update the functions?
  }
  private void makeBand() {
    row0 = new ArrayList<Float>();
    row1 = new ArrayList<Float>();
    double delta_time = (end - begin)/sections;
    for(int i = 0; i < sections+1; i++) {
      double time = begin + i*delta_time;
      row0.add((float)x0.evaluateAt(time));
      row0.add((float)y0.evaluateAt(time));
      row0.add((float)z0.evaluateAt(time));
//      System.out.printf("0%10.3f %10.3f %10.3f\n", x0.evaluateAt(time), y0.evaluateAt(time), z0.evaluateAt(time));
      row1.add((float)x1.evaluateAt(time));
      row1.add((float)y1.evaluateAt(time));
      row1.add((float)z1.evaluateAt(time));
//      System.out.printf("1%10.3f %10.3f %10.3f\n", x1.evaluateAt(time), y1.evaluateAt(time), z1.evaluateAt(time));
    }
  }
}
