package ProcessingJava;
import processing.core.*;
import Math.*;

abstract class VisualComponent extends PApplet{
  protected Sketch sketch;
  protected PVector position;
  protected Function[] position_fun = new Function[3];
  protected Function[] colour_fun = new Function[3];
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
  public void setPositionFun(int index, Function fun) {
    position_fun[index] = fun;
  }
  public void setColourFun(int index, Function fun) {
    colour_fun[index] = fun;
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
    if (!active) {
      if (delay > 0) delay -= d;
      else active = true;
    }
    //If the position is a function, change value in position vector.
    if (position_fun[0] != null) {
      position_fun[0].update(d);
      position.x = position_fun[0].getValue();
    }
    if (position_fun[1] != null) {
      position_fun[1].update(d);
      position.y = position_fun[1].getValue();
    }
    if (position_fun[2] != null) {
      position_fun[2].update(d);
      position.z = position_fun[2].getValue();
    }
    
    //If the colour is a function, change value in colour vector.
    if (colour_fun[0] != null) {
      colour_fun[0].update(d);
      colour.x = colour_fun[0].getValue();
    }
    if (colour_fun[1] != null) {
      colour_fun[1].update(d);
      colour.y = colour_fun[1].getValue();
    }
    if (colour_fun[2] != null) {
      colour_fun[2].update(d);
      colour.z = colour_fun[2].getValue();
    }
  }
}
