package ProcessingJava;

import processing.core.PVector;
import Math.*;

import java.util.ArrayList;
public class SpiralStairs extends VisualComponent{
  ArrayList <Float> row0, row1;
  double step_angle, step_length, step_height, starting_angle;
  int num_steps;
  int accuracy = 10;
  public SpiralStairs (PVector colour, double step_angle, double step_length, double step_height, int num_steps) {
    this(new PVector(), colour, step_angle, step_length, step_height, 0, num_steps);
  }
  public SpiralStairs (PVector position, PVector colour, double step_angle, double step_length, double step_height, int num_steps) {
    this(position, colour, step_angle, step_length, step_height, 0, num_steps);
  }
  public SpiralStairs (PVector colour, double step_angle, double step_length, double step_height, double starting_angle, int num_steps) {
    this(new PVector(), colour, step_angle, step_length, step_height, starting_angle, num_steps);
  }
  public SpiralStairs (PVector position, PVector colour, double step_angle, double step_length, double step_height, double starting_angle, int num_steps) {
    super(position, colour);
    this.step_angle = step_angle;
    this.step_length = step_length;
    this.step_height = step_height;
    this.starting_angle = starting_angle;
    this.num_steps = num_steps;
    makeStairs();
  }
  public void draw() {
    Utils.draw_rect_mesh_3D(row1, row0, sketch);
  }
  public void update(float d) {
    super.update(d);
  }
  private void makeStairs() {
    row0 = new ArrayList<Float>();
    row1 = new ArrayList<Float>();
    double time = (float)starting_angle;
    for(int i = 0; i < num_steps+1; i++) {
      //make vertical section
      double x0 = step_length * Math.cos(time);
      double y0 = step_length * Math.sin(time);
      double z0 = step_height * i;
      double x1 = 0;
      double y1 = 0;
      double z1 = step_height * i;
      row0.add((float)x0);
      row0.add((float)y0);
      row0.add((float)z0);
      row1.add((float)x1);
      row1.add((float)y1);
      row1.add((float)z1);
      //make horizontal section
      for (int j = 0; j < accuracy; j++) {
        println(time);
        x0 = step_length * Math.cos(time);
        y0 = step_length * Math.sin(time);
        z0 = step_height * (i+1);
        x1 = 0;
        y1 = 0;
        z1 = step_height * (i+1);
        row0.add((float)x0);
        row0.add((float)y0);
        row0.add((float)z0);
        row1.add((float)x1);
        row1.add((float)y1);
        row1.add((float)z1);
        time = time + step_angle/accuracy;
      }
    }
  }
}
