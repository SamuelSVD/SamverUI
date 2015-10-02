import ProcessingJava.*;
import processing.core.*;

public class SimpleSketch extends Sketch{
  public SimpleSketch(int x, int y) {
    super(x,y);
  }
  public void setup() {
    size((int)size.x,(int)size.y);
    Circle c = new Circle(new PVector(50,50), new PVector(), 100);
    addVisualComponent(c);
    Tear t = new Tear(new PVector(150,150), new PVector(100,100), 0, new PVector(255,255,150));
    addVisualComponent(t);
    noStroke();
    size(500,500);
  }
}
