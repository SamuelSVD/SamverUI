package ProcessingJava;

import processing.core.PVector;

import java.util.ArrayList;
public class Field3D extends VisualComponent{
  int sectionsX, sectionsY;
  PVector size;
  float t = 0;
  ArrayList <ArrayList<Double>> grid;
  public Field3D(PVector position, PVector colour, PVector size, int sectionsX, int sectionsY) {
    super(position, colour);
    this.size = size;
    this.sectionsX = sectionsX;
    this.sectionsY = sectionsY;
//    for (int i = 0; i < sectionsX+1; i++) {
//      ArrayList<Double> row = new ArrayList<Double>();
//      for (int j =0; j < sectionsY+1; j++) {
//        row.add((double)j);
//      }
//      grid.add(row);
//    }
  }
  public void draw() {
    double x0 = -size.x/2;
    double y0 = -size.y/2;
    double dx = size.x/sectionsX;
    double dy = size.y/sectionsY;
    for(int i = 0; i < sectionsX; i++) {
      ArrayList<Float> row1 = new ArrayList<Float>();
      ArrayList<Float> row2 = new ArrayList<Float>();
      for (int j = 0; j < sectionsY+1; j++) {
        double x_0 = x0 + dx*i;
        double y_0 = y0 + dy*j;
        double z_0 = fun(x_0, y_0, t);
        double x_1 = x0 + dx*i;
        double y_1 = y0 + dy*(j+1);
        double z_1 = fun(x_1, y_1, t);
        double x_2 = x0 + dx*(i+1);
        double y_2 = y0 + dy*j;
        double z_2 = fun(x_2, y_2, t);
        double x_3 = x0 + dx*(i+1);
        double y_3 = y0 + dy*(j+1);
        double z_3 = fun(x_3, y_3);
        row1.add((float)x_0);
        row1.add((float)y_0);
        row1.add((float)z_0);
        row1.add((float)x_1);
        row1.add((float)y_1);
        row1.add((float)z_1);
        row2.add((float)x_2);
        row2.add((float)y_2);
        row2.add((float)z_2);
        row2.add((float)x_3);
        row2.add((float)y_3);
        row2.add((float)z_3);
      }
      Utils.draw_rect_mesh_3D(row1, row2, sketch);
    }
  }
  public void update(float d) {
    super.update(d);
    t = t + 1;
  }
  double fun(double x, double y) {
    return fun(x, y, 0);
  }
  double fun(double x, double y, double t) {
    double r = Math.sqrt(x*x+y*y)/5;
    double a = 10;
    return r!=0?a*Math.cos(r+2*PI/50*t)/r:2.5*a*Math.cos(2*PI/50*t);
  }

}
