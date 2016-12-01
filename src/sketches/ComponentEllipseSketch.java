package sketches;
import ProcessingJava.*;
import processing.core.*;

public class ComponentEllipseSketch extends Sketch{
  public ComponentEllipseSketch(PVector size) {
    super(size);
  }
  public ComponentEllipseSketch(PVector position, PVector size) {
    super(position,size);
  }
  public void setup() {
    setSpeed(0.01f);
    record = true;
    background(0);
    Square s = new Square(new PVector(), new PVector(0,0), size);
    //s = new Square(new PVector(), new PVector(0,0), new PVector(500, 50));
    s.setAlpha(50f);
    addVisualComponent(s);      
    int N = 3;
    for (int i = 0; i < N; i++){
      PVector colour = new PVector(255.0f/N*i,255,255);
      float offset = random(2*PI);
      float theta = (PI)/((float)(N))*i;
      float speed_multiplier = 3;
      float a =  random(115);
      float b =  random(115);
      float alpha = 1;
      float X = width/2;
      float Y = height/2;
      offset=0;
      theta = 2*PI/N*i;
      alpha = 1;
      a = 140;
      b = i;
      EllipseParticle e = new EllipseParticle(colour, offset+PI/2, speed_multiplier,theta, alpha, a, b, new PVector(X, Y));
      e.addVisualComponent(new Tear(new PVector(0,0), new PVector(50,50), PI/2, new PVector(255,255,255)));
      addVisualComponent(e);
     }
    //addVisualComponent(new Counter(new PVector(width/2, 30), new PVector(255,255,255)));
    noStroke();
    colorMode(HSB, 256);
  }
}
