import ProcessingJava.*;
import processing.core.*;
import Math.*;

public class MathSketch2 extends Sketch{
  public MathSketch2(PVector size) {
    super(size);
  }
  public MathSketch2(PVector position, PVector size) {
    super(position, size);
  }
  public void setup() {
    record = true;
    frame_limit = 550;
    size((int)size.x, (int)size.y); //Always needed. Looking for a fix.
    setSpeed(0.033f);
    //noStroke();
    Square s = new Square(new PVector(255,255,0), new PVector(500,500));
    addVisualComponent(s);
    double length = 400;
    Line line = new Line(new PVector((float)(500-length)/2,250), new PVector(0,0,0), length);
    for (double i = 0; i < 1; i++) {
      line.addFunction(new Sin(0,0,Math.pow(-0.9, i)*-2*PI/length*20*(i+1),100/(i+1)));
    }
    addVisualComponent(line);
    line = new Line(new PVector(0,250), new PVector(0,0,0), (500-length)/2);
    addVisualComponent(line);
    line = new Line(new PVector((float)(length+(500-length)/2),250), new PVector(0,0,0), 500-length/2);
    addVisualComponent(line);
  }
  public void draw() {
    super.draw();
  }
}
