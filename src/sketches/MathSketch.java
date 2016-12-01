package sketches;
import Math.*;
import ProcessingJava.*;
import processing.core.*;

public class MathSketch extends Sketch{
  public MathSketch(PVector size) {
    super(size);
  }
  public MathSketch(PVector position, PVector size) {
    super(position, size);
  }
  public void setup() {
    record = true;
    frame_limit = 364;
    setSpeed(0.033f);
    noStroke();
    background(0);
    Square s = new Square(new PVector(), size);
    addVisualComponent(s);
    for (int i = 0; i <= 10; i++) {
      float omega = 2*PI/12;
      Sin x = new Sin(2*PI/omega*i, 250, omega,100);
      Cos y = new Cos(2*PI/omega*i, 250, omega,100);
      Sin c1 = new Sin(2*PI/omega*i, 255/2.0f, 2*PI/3,255/2.0f);
      Cos c2 = new Cos(2*PI/omega*i, 255/2.0f, 2*PI/6,255/2.0f);
      c1 = new Sin(2*PI/omega*i, 255/2.0f, -omega*4,255/2.0f);
      c2 = new Cos(2*PI/omega*i, 255/2.0f, -omega*2,255/2.0f);
      Constant c3 = new Constant(150);
      
      Circle circle = new Circle(new PVector(), new PVector(255,255,255), 30);
      circle.setPositionFun(0, x);
      circle.setPositionFun(1, y);
      circle.setColourFun(0, c1);
      circle.setColourFun(1, c2);
      circle.setColourFun(2, c3);
      addVisualComponent(circle);
    }
  }
}
