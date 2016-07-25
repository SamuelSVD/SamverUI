package ProcessingComponents;

import java.util.ArrayList;

import Math.*;
import ProcessingJava.*;
import processing.core.*;
public class RussianDoll extends VisualComponent{
  private PVector decoration_color;
  private PVector hair_color;
  private PVector skin_color;
  private PVector background_color;
  private PVector size;
  private Exponential top;
  private Exponential bot;
  public boolean init = false;
  public RussianDoll() {
    decoration_color = new PVector();
    hair_color = new PVector();
    skin_color = new PVector();
    background_color = new PVector();
    size = new PVector();
    reset();
  }
  public void setSize(PVector size) {
    this.size = size;
  }
  public void setPosition(PVector position) {
    this.position = position;
  }
  public void setDecorationColor(PVector color) {
    this.decoration_color = color;
  }
  public void setHairColor(PVector color) {
    this.hair_color = color;
  }
  public void setSkinColor(PVector color) {
    this.skin_color = color;
  }
  public void setBackgroundColor(PVector color) {
    this.background_color = color;
  }
  public void update(float d) {
    super.update(d);
    if (init) {
      top.update(d);
      bot.update(d);
    }
  }
  public void draw() {
    super.draw();
    sketch.pushMatrix();
    sketch.translate(0, (float)top.getValue());
    sketch.fill(255);
    sketch.noStroke();
    
    sketch.fill(background_color);
    //Top half
    sketch.ellipse(size.x*0.5f,size.y*0.3f,size.x*0.6f,size.y*0.6f);
    sketch.arc(size.x*0.5f, size.y*1, size.x, size.y, 0, -PI);
    ArrayList<Double> a = new ArrayList<Double>();
    a.addAll(Shape.getCicle(size.x*0.125, size.y*0.5, size.x*0.125, -PI/4+0.3, PI/3-0.2, 10));
    a.addAll(Shape.getCicle(size.x*(1-0.125), size.y*0.5, size.x*0.125, PI-PI/3+0.2, PI+PI/4-0.3 , 10));
    Utils.draw_shape(Utils.doubleToFloat(a), sketch);
    
    //Shirt decorations
    sketch.fill(decoration_color);
    sketch.ellipse(size.x*0.5f, size.y*0.3f, size.x*0.52f, size.y*0.52f);
    
    //Anything skin related
    sketch.fill(skin_color);
    sketch.ellipse(size.x * 0.5f, size.y * 0.3f, size.x * 0.5f, size.y * 0.5f);
    
    //Decorations
    sketch.fill(decoration_color);
    sketch.rect(size.x * 0.3f, size.y * 0.7f, size.x*0.4f, size.y*0.02f, size.x*0.02f,size.x*0.02f,size.x*0.02f,size.x*0.02f);
    sketch.rect(size.x * 0.3f, size.y * 0.74f, size.x*0.4f, size.y*0.02f, size.x*0.02f,size.x*0.02f,size.x*0.02f,size.x*0.02f);
    sketch.rect(size.x * 0.3f, size.y * 0.78f, size.x*0.4f, size.y*0.02f, size.x*0.02f,size.x*0.02f,size.x*0.02f,size.x*0.02f);
    sketch.rect(size.x * 0.5f, size.y * 0.86f, size.x*0.02f, size.y*0.14f, size.x*0.02f,size.x*0.02f,0,0);
    
    //any hair/features
    sketch.fill(hair_color);
    sketch.arc(size.x*0.2f, 0, size.x * 0.6f, size.y*0.6f, 0.17f, 1.39f, CHORD);
    sketch.arc(size.x*0.5f, size.y * 0.3f, size.x * 0.5f, size.y*0.5f, PI, PI+PI/2, CHORD);
    
    sketch.arc(size.x*(1-0.2f), 0, size.x * 0.6f, size.y*0.6f, PI/2+0.17f, PI/2+1.39f, CHORD);
    sketch.arc(size.x*0.5f, size.y * 0.3f, size.x * 0.5f, size.y*0.5f, -PI/2, 0, CHORD);
    
    sketch.arc(size.x*0.45f, size.y * 0.3f, size.x*0.05f, size.y * 0.05f, 0, -PI, PIE);
    sketch.arc(size.x*0.55f, size.y * 0.3f, size.x*0.05f, size.y * 0.05f, 0, -PI, PIE);
    sketch.arc(size.x*0.5f, size.y * 0.4f, size.x*0.10f, size.y * 0.05f, 0, PI, PIE);
    
    sketch.popMatrix();
    
    //sketch.stroke(0);
    //sketch.line(0, size.y, size.x, size.y);
    //sketch.noStroke();
    
    sketch.pushMatrix();
    sketch.translate(0, (float)bot.getValue());
    //Pants
    float angle = PI/4;
    sketch.fill(background_color);
    sketch.rect(size.x*(1-cos(angle))*0.5f, size.y*1, size.x*cos(angle), size.y*sin(angle)/2);
    sketch.arc(size.x*0.5f, size.y*1, size.x, size.y, 0, angle);
    sketch.arc(size.x*0.5f, size.y*1, size.x, size.y, PI, PI-angle);
    
    //pants decoration
    sketch.fill(decoration_color);
    sketch.rect(size.x * 0.5f, size.y , size.x*0.02f, size.y*0.14f,0,0,size.x*0.02f,size.x*0.02f);
    
    sketch.popMatrix();
  }
  public void reset() {
    top = new Exponential(1,0,1,-1,30);
    bot = new Exponential(2,0,1,1,30);
  }
  public String toString() {
    String s = String.format("%f %f %f %f", size.x, size.y, position.x, position.y);
    return s;
  }
  
  
}
