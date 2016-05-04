import ProcessingJava.*;
import processing.core.*;

public class TestingSketch extends Sketch{
  public TestingSketch(PVector size) {
    super(size);
  }
  public TestingSketch(PVector position, PVector size) {
    super(position, size);
  }
  public void setup() {
    setSpeed(0.033f);

    noStroke();
    background(0);
    PVector c = new PVector(random(255),random(255),random(255));
    Square s = new Square(new PVector(), size);
    addVisualComponent(s);
    addVisualComponent(new Donut(new PVector(325,150), c, 5, 30));
    addVisualComponent(new Donut(new PVector(175,150), c, 5, 30));
    addVisualComponent(new Donut(new PVector(250,200), c, 170, 200, 0, PI));
    addVisualComponent(new OscillatingDonut(new PVector(250,100), c,100,50,1,0));
    addVisualComponent(new Donut(new PVector(250,250), c, 170, 250, 0, PI));
  }
}
