package ProcessingJava;
import processing.core.*;
public class Circle extends VisualComponent{
  int radius;
  public Circle(PVector position, PVector colour, int radius) {
    super(position, colour);
    this.radius = radius;
  }
  public void draw() {
    sketch.noStroke();
    sketch.fill(colour.x, colour.y,  colour.z);
    sketch.ellipse(0, 0, (float)radius, (float)radius);
  }
}
