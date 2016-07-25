package ProcessingJava;

import processing.core.PVector;

import java.util.ArrayList;

import Math.*;
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
    super.draw();
    ArrayList<Float> a = new ArrayList<Float>();
    ArrayList<Float> b = new ArrayList<Float>();
    //Rectangles
    for (int i = 0 ; i < row1.size()/6; i++) {
      for(int j = 0; j < 6; j++) {
        a.add(row1.get(6*i+j));
        b.add(row0.get(6*i+j));
      }
      Utils.draw_rect_mesh_3D(a, b, sketch);
      a.clear();
      b.clear();
    }
    //Curved section
    //sketch.fill(255,255,255);
    for (int i = 0 ; i < row1.size()/6; i++) {
      sketch.translate(0,0,(float)step_height*(1+i));
      sketch.arc(0,0,2*(float)step_length,2*(float)step_length,(float)(starting_angle + i*step_angle),(float)(starting_angle + (i+1)*step_angle));
      //sketch.arc(0,0,(float)200,(float)200,(float)(starting_angle + i*step_angle),(float)(starting_angle + (i+1)*step_angle));
      sketch.translate(0,0,(float)-step_height*(1+i));
    }
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
        if (j == 0) {
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
        }
        time = time + step_angle/accuracy;
      }
    }
  }
}
