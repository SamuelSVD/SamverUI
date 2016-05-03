import ProcessingJava.*;
import processing.core.*;
import Math.*;

public class ShapeSketch extends Sketch{
  public ShapeSketch(PVector size) {
    super(size);
  }
  public ShapeSketch(PVector position, PVector size) {
    super(position, size);
  }
  public void setup() {
    record = true;
    frame_limit = 250;
    size((int)size.x, (int)size.y); //Always needed. Looking for a fix.
    setSpeed(0.04f);
    //noStroke();
    Square s = new Square(new PVector(0,0,0), new PVector(500,500));
    addVisualComponent(s);
    PVector position = new PVector(100,100);
    PVector colour = new PVector(100,100,0);
    PVector size = new PVector(100,100);
    Shape square= new Shape(position, colour, size);
    position = new PVector(250,250);
    colour = new PVector(255,21,150);
    size = new PVector(100,100);
    Shape circle= new Shape(position, colour, size);
    position = new PVector(300,10);
    colour = new PVector(55,21,250);
    size = new PVector(100,100);
    Shape tear= new Shape(position, colour, size);
    position = new PVector(250,250);
    colour = new PVector(55,21,250);
    size = new PVector(100,100);
    ShapeAnimation all= new ShapeAnimation(position, colour, size);
    all.setRotationAfterTranslateFun(new Sin(0,0,1,PI));
    try {
      square.init("Data/Shapes/square.pts");
      circle.init("Data/Shapes/Circle.pts");
      tear.init("Data/Shapes/tear.pts");
      all.init("Data/Animation/all.pts");
    }
    catch (Exception e) {
      e.printStackTrace();
    }
//    addVisualComponent(square);
//    addVisualComponent(circle);
//    addVisualComponent(tear);
    addVisualComponent(all);
  }
}
