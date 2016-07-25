package ProcessingJava;

import Math.*;
import processing.core.PVector;

public class Function_Line extends VisualContainer{
  int RESOLUTION = 1;
  double length;
  double cumulative;
  double speed = 1;
  Product prod = new Product();
  Sum sum = new Sum();
  public Function_Line(PVector position, PVector colour, double length) {
    super(position, colour);
    this.length = length;
//    prod.appendFunction(new Sin(1*PI/length));
/*    Exponential exp = new Exponential(0.4f);
    Constant c = new Constant(exp);
    prod.appendFunction(c);
    c = new Constant(0);
    prod.appendFunction(c);
    */
  }
  public void addFunction(Function f) {
    sum.appendFunction(f);
  }
  public void addProductFunction(Function f) {
    prod.appendFunction(f);
  }
  public void setSpeed(double speed) {
    this.speed = speed;
//    sum.setX_multiple(speed);
  }
  public void draw() {
    sketch.stroke(colour.x, colour.y, colour.z);
    double x, y;
    x = 0;
    y = prod.evaluateAt(0)*sum.evaluateAt(0);
    double delta = 1.0/RESOLUTION;
    for (int i = 0; i <= RESOLUTION*length; i++) {
      double next_x =(float)(i*delta);
      double next_y = prod.evaluateAt(next_x)*sum.evaluateAt(next_x+speed*cumulative);
      sketch.line(x, y, next_x, next_y);
      x = next_x;
      y = next_y;
    }
    sketch.line(x, y, length, 0);
  }
  public void update(float d) {
    cumulative += d;
    prod.update(d);
  }
}
