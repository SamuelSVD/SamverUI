package ProcessingJava;
import processing.core.*;
abstract class VisualComponent extends PApplet{
  Sketch sketch;
  PVector position;
  PVector colour;
  VisualComponent(PVector colour) {
    this.colour = colour;
  }
  public void setSketch(Sketch s) {
    this.sketch = s;
  }
  public void draw(PVector shift) {
    PVector neg = new PVector(-shift.x, -shift.y);
    this.position.add(shift);
    this.draw();
    this.position.add(neg);
  }
  public void update(float d) {};
}
