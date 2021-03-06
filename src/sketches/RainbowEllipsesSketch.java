package sketches;
import Math.*;
import ProcessingJava.*;
import processing.core.*;

public class RainbowEllipsesSketch extends Sketch{
  public RainbowEllipsesSketch(PVector size) {
    super(size);
  }
  public RainbowEllipsesSketch(PVector position, PVector size) {
    super(position,size);
  }
  public void setup() {
    setSpeed(0.01f);
    background(0);
    if (true) {
      Square s = new Square(new PVector(), new PVector(0,0), size);
      s.setAlpha(10f);
      addVisualComponent(s);
      int N = 1000;
      for (int i = 0; i < N; i++){
        PVector colour = new PVector(255.0f/N*i,255,255);
        float offset = random(2*PI);
        float starting_angle = (2*PI)/((float)(N))*i;
        float speed_multiplier = 1;
        float a =  random(115);
        float b =  random(115);
        float angle_speed = 0;
        float X = width/2;
        float Y = height/2;
        offset=0;
        starting_angle = 2*PI/N*i;
        a = 100;
        b = 0;
//        colour = new PVector(255,255,255);
        EllipseParticle e = new EllipseParticle(colour, offset, speed_multiplier,starting_angle, angle_speed, a, b, new PVector(X, Y));
//        e.setVisualComponent(new Counter(new PVector(), new PVector(200,200,200)));
        addVisualComponent(e);
//        addVisualComponent(vc);
      }
    }
    
    noStroke();
    size(500,500);
    colorMode(HSB, 256);
  }
}
