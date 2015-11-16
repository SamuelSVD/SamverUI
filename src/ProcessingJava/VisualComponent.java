package ProcessingJava;
import processing.core.*;
abstract class VisualComponent extends PApplet{
  protected Sketch sketch;
  protected PVector position;
  protected PVector colour;
  protected float alpha;
  protected boolean active;
  protected float delay;
  VisualComponent(PVector position, PVector colour) {
    this.position = position;
    this.colour = colour;
    this.alpha = 255;
    this.active = false;
  }
  public void setSketch(Sketch s) {
    this.sketch = s;
  }
  public void setAlpha(float a) {
    this.alpha = a;
  }
  public boolean isActive() { 
    return active;
  }
  public void draw(PVector shift) {
    PVector neg = new PVector(-shift.x, -shift.y);
    this.position.add(shift);
    this.draw();
    this.position.add(neg);
  }
  public void setDelay(float d) {
    this.delay = d;
  }
  public void update(float d) {
    if (!active && delay > 0) delay -= d;
    else if (!active) active = true;
  }
}
