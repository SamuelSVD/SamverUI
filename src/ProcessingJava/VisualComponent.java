package ProcessingJava;
import processing.core.*;
import Math.*;

public abstract class VisualComponent extends PApplet{
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
  protected PVector colour, stroke_colour;
  protected boolean hasStroke = true;
  protected boolean isFilled = true;
  protected float alpha;
  protected boolean isActive;
  protected float delay;
  protected double rotation_before_translate;
  protected double rotation_after_translate;
  public VisualComponent() {
    this(new PVector(), new PVector());
  }
  public VisualComponent(PVector position, PVector colour) {
    this.position = position;
    this.colour = colour;
    this.stroke_colour = new PVector();
    this.rotation_before_translate_3D = new PVector();
    this.rotation_after_translate_3D = new PVector();
    this.alpha = 255;
    this.isActive = true;
  }
  public void setSketch(Sketch s) {
    this.sketch = s;
  }
  public void setAlpha(float a) {
    this.alpha = a;
  }
  public void setPosition(PVector pos) {
    this.position = pos;
  }
  public void setPositionFun(int index, Function fun) {
    position_fun[index] = fun;
  }
  public void setColour(PVector col) {
    this.colour = col;
  }
  public void setColourFun(int index, Function fun) {
    colour_fun[index] = fun;
  }
  public void setRotationBeforeTranslate(float f) {
    rotation_before_translate = f;
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
  public void setRorationAfterTranslate(float f) {
    rotation_after_translate = f;
  }
  public void setRotationAfterTranslateFun3D(int index, Function fun) {
    rotation_after_translate_fun_3D[index] = fun;
  }
  public void setRotationBeforeTranslate3D(PVector rot) {
    rotation_before_translate_3D = rot;
  }
  public void setRotationAfterTranslate3D(PVector rot) {
    rotation_after_translate_3D = rot;
  }
  public boolean isActive() { 
    return isActive;
  }
  public void draw(PVector shift) {
    PVector neg = new PVector(-shift.x, -shift.y);
    this.position.add(shift);
    this.draw();
    this.position.add(neg);
  }
  public void doDraw() {
    if (!isActive) return;
    if (sketch.is3D()) {
      sketch.pushMatrix();
      sketch.rotateX(rotation_before_translate_3D.x);
      sketch.rotateY(rotation_before_translate_3D.y);
      sketch.rotateZ(rotation_before_translate_3D.z);
      sketch.translate(position.x,position.y,position.z);
      sketch.rotateX(rotation_after_translate_3D.x);
      sketch.rotateY(rotation_after_translate_3D.y);
      sketch.rotateZ(rotation_after_translate_3D.z);
      //Temporary fix
      sketch.rotate((float)rotation_after_translate);
      sketch.fill(colour.x,colour.y,colour.z);
      if (this.hasStroke) sketch.stroke(stroke_colour.x, stroke_colour.y, stroke_colour.z);
      else sketch.noStroke();
      if (this.isFilled) sketch.fill(colour.x, colour.y, colour.z);
      else sketch.noFill();
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
    this.isActive = false;
  }
  public void update(float d) {
    if (!isActive) {
      if (delay > 0) delay -= d;
      else isActive = true;
      System.out.print("VisComp.delay: ");
      System.out.println(delay);
      return;
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
    if (rotation_before_translate_fun_3D[0] != null) {
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
  public void noStroke() {
    this.hasStroke = false;
  }
  public void stroke() {
    this.hasStroke = true;
  }
  public void noFill() {
    this.isFilled = false;
  }
  public void setFillColour(PVector colour) {
    this.isFilled = true;
    this.colour = colour;
  }
  public void setStrokeColor(PVector colour) {
    this.stroke_colour = colour;
  }
}
