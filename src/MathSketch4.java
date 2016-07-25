import Math.*;
import ProcessingJava.*;
import processing.core.*;

public class MathSketch4 extends Sketch{
  public MathSketch4(PVector size) {
    super(size);
  }
  public MathSketch4(PVector position, PVector size) {
    super(position, size);
  }
  public void setup() {
    record = true;
    frame_limit = 80;
    setSpeed(0.04f);
    //noStroke();
    Square s = new Square(new PVector(0,0,0), new PVector(500,500));
    addVisualComponent(s);

    strokeWeight(2);
    double length = 400;    
    int N = 1;
    int num_frequencies = 10;
    for (int j = -1; j < N+1; j++) {
      PVector line_pos = new PVector((float)(500-length)/2,500/(N+1)*(j+1));
      PVector line_colour = new PVector((float)(99+(53.0-99.0)/(N+1)*(j+1)),0.9f*(float)(254),0.9f*(float)(95+(243.0-95.0)/(N+1)*(j+1)));
      
      Function_Line line = new Function_Line(line_pos, line_colour, length);
      for (int i = 0; i < num_frequencies; i++) {
        Wave w = new Wave(length, i, 4);
        w.setY_multiple(2.5);
        line.addProductFunction(w);
      }
      line.addFunction(new Constant(1));
      line.setSpeed(0);
      addVisualComponent(line);
      line = new Function_Line(new PVector(0,line_pos.y), line_colour, (500-length)/2);
      addVisualComponent(line);
      line = new Function_Line(new PVector((float)(length+(500-length)/2),line_pos.y), line_colour, 500-length/2);
      addVisualComponent(line);
    }
  }
  public void draw() {
    super.draw();
  }
}
