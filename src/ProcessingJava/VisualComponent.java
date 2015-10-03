package ProcessingJava;
import processing.core.*;
abstract class VisualComponent extends PApplet{
  Sketch sketch;
  PVector position;
  PVector colour;
  float alpha;
  VisualComponent(PVector position, PVector colour) {
    this.position = position;
    this.colour = colour;
    this.alpha = 255;
  }
  public void setSketch(Sketch s) {
    this.sketch = s;
  }
  public void setAlpha(float a) {
    this.alpha = a;
  }
  public void draw(PVector shift) {
    PVector neg = new PVector(-shift.x, -shift.y);
    this.position.add(shift);
    this.draw();
    this.position.add(neg);
  }
  public void update(float d) {};
}
