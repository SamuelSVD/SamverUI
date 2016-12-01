package sketches;
import Math.*;
import ProcessingJava.*;
import processing.core.*;

public class MathSketch2 extends Sketch{
  public MathSketch2(PVector size) {
    super(size);
  }
  public MathSketch2(PVector position, PVector size) {
    super(position, size);
  }
  public void setup() {
    record = false;
    frame_limit = 80;
    setSpeed(0.1f);
    //noStroke();
    Square s = new Square(new PVector(0,0,0), new PVector(500,500));
    addVisualComponent(s);

    strokeWeight(2);
    double length = 400;
    int N = 15;
    int num_sums = 100;
    for (int j = -1; j < N+1; j++) {
      PVector line_pos = new PVector((float)(500-length)/2,500/(N+1)*(j+1));
//    PVector line_colour = new PVector(50+100/N*(j+1),50+100/N*(j+1),50+205/N*(j+1));
//    PVector line_colour = new PVector((float)Math.random()*255,(float)Math.random()*255,(float)Math.random()*255);
      PVector line_colour = new PVector((float)(99+(53.0-99.0)/(N+1)*(j+1)),0.9f*(float)(254),0.9f*(float)(95+(243.0-95.0)/(N+1)*(j+1)));
      
      Function_Line line = new Function_Line(line_pos, line_colour, length);
      line.setSpeed(100);
      double offset = length*Math.random();
      for (double i = 0; i < num_sums; i++) {
        double omega = Math.pow(-1, i)*-2*PI/length*(i+1);
        line.addFunction(new Sin((length/N*(j+1))*omega,0,omega,40/(i+1)));
      }
      line.addFunction(new Noise(0));
      line.addProductFunction(new Sin(0,0,PI/length,1));
      addVisualComponent(line);
      line = new Function_Line(new PVector(0,line_pos.y), line_colour, (500-length)/2);
      addVisualComponent(line);
      line = new Function_Line(new PVector((float)(length+(500-length)/2),line_pos.y), line_colour, (500-length)/2);
      addVisualComponent(line);
    }
  }
  public void draw() {
    super.draw();
  }
}
