import ProcessingJava.*;
import processing.core.*;
import Math.*;

public class MathSketch3 extends Sketch{
  public MathSketch3(PVector size) {
    super(size);
  }
  public MathSketch3(PVector position, PVector size) {
    super(position, size);
  }
  public void setup() {
    record = false;
    frame_limit = 80;
    size((int)size.x, (int)size.y); //Always needed. Looking for a fix.
    setSpeed(0.04f);
    //noStroke();
    Square s = new Square(new PVector(0,0,0), new PVector(500,500));
    addVisualComponent(s);

    strokeWeight(2);
    double length = 400;    
    int N = 1;
    int num_sums = 1;
    for (int j = -1; j < N+1; j++) {
      PVector line_pos = new PVector((float)(500-length)/2,500/(N+1)*(j+1));
      PVector line_colour = new PVector((float)(99+(53.0-99.0)/(N+1)*(j+1)),0.9f*(float)(254),0.9f*(float)(95+(243.0-95.0)/(N+1)*(j+1)));
      
      Line line = new Line(line_pos, line_colour, length);
      double offset = length*Math.random();
      double omega = -2*PI/length*10;
      Product p = new Product();
      p.appendFunction(new Sin((length/N*(j+1))*omega,0,omega,40));
      PeriodicStep step = new PeriodicStep(length/2,0,1,1);
      step.setPeriods(length/5, length/10);
      //step.setSlew(0.01);
      p.appendFunction(step);
      line.addFunction(p);
      line.setSpeed(10);
      line.addFunction(new Noise(0));
      addVisualComponent(line);
      line = new Line(new PVector(0,line_pos.y), line_colour, (500-length)/2);
      addVisualComponent(line);
      line = new Line(new PVector((float)(length+(500-length)/2),line_pos.y), line_colour, 500-length/2);
      addVisualComponent(line);
    }
  }
  public void draw() {
    super.draw();
  }
}
