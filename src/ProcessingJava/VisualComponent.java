package ProcessingJava;
import processing.core.*;
import Math.*;

abstract class VisualComponent extends PApplet{
  protected Sketch sketch;
  protected PVector position;
  protected PVector rotation_before_translate_3D;
  protected PVector rotation_after_translate_3D;
  protected Function[] position_fun = new Function[3];
  protected Function[] colour_fun = new Function[3];
  protected Function rotation_before_translate_fun;
  protected Function rotation_after_translate_fun;
  protected Function[] rotation_before_translate_fun_3D = new Function[3];
  protected Function[] rotation_after_translate_fun_3D = new Function[3];
  protected PVector colour;
  protected float alpha;
  protected boolean active;
  protected float delay;
  protected double rotation_before_translate;
  protected double rotation_after_translate;
  VisualComponent(PVector position, PVector colour) {
    this.position = position;
    this.colour = colour;
    this.rotation_before_translate_3D = new PVector();
    this.rotation_after_translate_3D = new PVector();
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
  public void setRotationBeforeTranslateFun(Function fun) {
    rotation_before_translate_fun = fun;
  }
  public void setRotationAfterTranslateFun(Function fun) {
    rotation_after_translate_fun = fun;
  }
  public void setRotationBeforeTranslateFun3D(int index, Function fun) {
    rotation_before_translate_fun_3D[index] = fun;
  }
  public void setRotationAfterTranslateFun3D(int index, Function fun) {
    rotation_after_translate_fun_3D[index] = fun;
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
  public void doDraw() {
    if (sketch.is3D()) {
      sketch.pushMatrix();
      sketch.rotateX(rotation_before_translate_3D.x);
      sketch.rotateY(rotation_before_translate_3D.y);
      sketch.rotateZ(rotation_before_translate_3D.z);
      sketch.translate(position.x,position.y,position.z);
      sketch.rotateX(rotation_after_translate_3D.x);
      sketch.rotateY(rotation_after_translate_3D.y);
      sketch.rotateZ(rotation_after_translate_3D.z);
      this.draw();
      sketch.popMatrix();
    }
    else {
      sketch.pushMatrix();
      sketch.rotate((float)rotation_before_translate);
      sketch.translate(position.x, position.y);
      sketch.rotate((float)rotation_after_translate);
      this.draw();
      sketch.popMatrix();
    }
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
      position.x = (float)position_fun[0].getValue();
    }
    if (position_fun[1] != null) {
      position_fun[1].update(d);
      position.y = (float)position_fun[1].getValue();
    }
    if (position_fun[2] != null) {
      position_fun[2].update(d);
      position.z = (float)position_fun[2].getValue();
    }
    
    //If the colour is a function, change value in colour vector.
    if (colour_fun[0] != null) {
      colour_fun[0].update(d);
      colour.x = (float)colour_fun[0].getValue();
    }
    if (colour_fun[1] != null) {
      colour_fun[1].update(d);
      colour.y = (float)colour_fun[1].getValue();
    }
    if (colour_fun[2] != null) {
      colour_fun[2].update(d);
      colour.z = (float)colour_fun[2].getValue();
    }
    
    //If the rotation is a function, change rotation value
    if (rotation_before_translate_fun != null) {
      rotation_before_translate_fun.update(d);
      rotation_before_translate = rotation_before_translate_fun.getValue();
    }
    if (rotation_after_translate_fun != null) {
      rotation_after_translate_fun.update(d);
      rotation_after_translate = rotation_after_translate_fun.getValue();
    }
    
    //If the 3D rotation is a function, change value in rotation vector.
    if (rotation_after_translate_fun_3D[0] != null) {
      rotation_after_translate_fun_3D[0].update(d);
      rotation_after_translate_3D.x = (float)rotation_after_translate_fun_3D[0].getValue();
    }
    if (rotation_after_translate_fun_3D[1] != null) {
      rotation_after_translate_fun_3D[1].update(d);
      rotation_after_translate_3D.y = (float)rotation_after_translate_fun_3D[1].getValue();
    }
    if (rotation_after_translate_fun_3D[2] != null) {
      rotation_after_translate_fun_3D[2].update(d);
      rotation_after_translate_3D.z = (float)rotation_after_translate_fun_3D[2].getValue();
    }
    if (rotation_after_translate_fun_3D[0] != null) {
      rotation_before_translate_fun_3D[0].update(d);
      rotation_before_translate_3D.x = (float)rotation_before_translate_fun_3D[0].getValue();
    }
    if (rotation_before_translate_fun_3D[1] != null) {
      rotation_before_translate_fun_3D[1].update(d);
      rotation_before_translate_3D.y = (float)rotation_before_translate_fun_3D[1].getValue();
    }
    if (rotation_before_translate_fun_3D[2] != null) {
      rotation_before_translate_fun_3D[2].update(d);
      rotation_before_translate_3D.z = (float)rotation_before_translate_fun_3D[2].getValue();
    }
  }
}
