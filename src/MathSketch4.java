import ProcessingJava.*;
import processing.core.*;
import Math.*;

public class MathSketch4 extends Sketch{
  public MathSketch4(PVector size) {
    super(size);
  }
  public MathSketch4(PVector position, PVector size) {
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
    int num_frequencies = 1;
    for (int j = -1; j < N+1; j++) {
      PVector line_pos = new PVector((float)(500-length)/2,500/(N+1)*(j+1));
      PVector line_colour = new PVector((float)(99+(53.0-99.0)/(N+1)*(j+1)),0.9f*(float)(254),0.9f*(float)(95+(243.0-95.0)/(N+1)*(j+1)));
      
      Line line = new Line(line_pos, line_colour, length);
      for (int i = 0; i < num_frequencies; i++) {
/*        double omega = PI/length;
        Product prod = new Product();
        Sin sin = new Sin(10*omega*(i+1));
        Constant c = new Constant(sin);
        prod.appendFunction(c);
        prod.appendFunction(new Sin((1+i)*omega));
        line.addProductFunction(prod); */
        line.addProductFunction(new Wave(length, i));
      }
      line.addFunction(new Constant(100));
      line.setSpeed(10);
      addVisualComponent(line);
      line = new Line(new PVector(0,line_pos.y), line_colour, (500-length)/2);
      addVisualComponent(line);
      line = new Line(new PVector((float)(length+(500-length)/2),line_pos.y), line_colour, 500-length/2);
      addVisualComponent(line);
    }
    System.out.println(new Constant().getMathString());
    System.out.println(new Cos().getMathString());
    System.out.println(new Ellipse_X(1,1).getMathString());
    System.out.println(new Ellipse_Y(1,1).getMathString());
    System.out.println(new Exponential().getMathString());
    System.out.println(new Impulse().getMathString());
    System.out.println(new Noise().getMathString());
    System.out.println(new PeriodicStep().getMathString());
    System.out.println(new Product().getMathString());
    System.out.println(new Quadratic().getMathString());
    System.out.println(new Sin().getMathString());
    System.out.println(new Step().getMathString());
    System.out.println(new Sum().getMathString());
  }
  public void draw() {
    super.draw();
  }
}
