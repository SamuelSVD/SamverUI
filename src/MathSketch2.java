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
    frame_limit = 80;
    size((int)size.x, (int)size.y); //Always needed. Looking for a fix.
    setSpeed(0.1f);
    //noStroke();
    Square s = new Square(new PVector(0,0,0), new PVector(500,500));
    addVisualComponent(s);

    strokeWeight(2);
    double length = 400;    
    int N = 15;
    int num_sums = 1000;
    for (int j = -1; j < N+1; j++) {
      PVector line_pos = new PVector((float)(500-length)/2,500/(N+1)*(j+1));
//    PVector line_colour = new PVector(50+100/N*(j+1),50+100/N*(j+1),50+205/N*(j+1));
//    PVector line_colour = new PVector((float)Math.random()*255,(float)Math.random()*255,(float)Math.random()*255);
    PVector line_colour = new PVector((float)(99+(53.0-99.0)/(N+1)*(j+1)),0.9f*(float)(254),0.9f*(float)(95+(243.0-95.0)/(N+1)*(j+1)));
      
      Line line = new Line(line_pos, line_colour, length);
      double offset = length*Math.random();
      for (double i = 0; i < num_sums; i++) {
        double omega = Math.pow(-1, i)*-2*PI/length*(i+1);
        line.addFunction(new Sin((length/N*(j+1))*omega,0,omega,40/(i+1)));
      }
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
