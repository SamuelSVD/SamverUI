package ProcessingJava;

import processing.core.PVector;
import Math.*;

public class Line extends VisualContainer{
  int RESOLUTION = 1;
  double length;
  double cumulative;
  Product prod = new Product();
  Sum sum = new Sum();
  public Line(PVector position, PVector colour, double length) {
    super(position, colour);
    this.length = length;
    prod.appendFunction(new Sin(1*PI/length));
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
  public void draw() {
    sketch.stroke(colour.x, colour.y, colour.z);
    double x, y;
    x = 0;
    y = prod.evaluateAt(0)*sum.evaluateAt(0);
    double delta = 1.0/RESOLUTION;
    for (int i = 0; i <= RESOLUTION*length; i++) {
      double next_x =(float)(i*delta);
      double next_y = prod.evaluateAt(next_x)*sum.evaluateAt(next_x+cumulative);
      sketch.line(x+position.x, y+position.y, next_x+position.x, next_y+position.y);
      x = next_x;
      y = next_y;
    }
  }
  public void update(float d) {
    cumulative += d*100;
    prod.update(d);
  }
}
