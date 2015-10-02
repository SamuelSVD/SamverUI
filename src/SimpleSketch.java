import ProcessingJava.*;
import processing.core.*;

public class SimpleSketch extends Sketch{
  public SimpleSketch(int x, int y) {
    super(x,y);
  }
  public void setup() {
    size((int)size.x,(int)size.y);
    setSpeed(0.01f);
    //addVisualComponent(new Circle(new PVector(50,50), new PVector(), 100));
    //addVisualComponent(new Tear(new PVector(150,150), new PVector(100,100), 0, new PVector(255,255,150)));

    
    if (true) {
      addVisualComponent(new Square(new PVector(), new PVector(0,0), size));
      int N = 1000;
      for (int i = 0; i < N; i++){
        PVector colour = new PVector(255.0f/N*i,255,255);
        float offset = random(2*PI);
        float theta = (PI)/((float)(N))*i;
        float speed_multiplier = 1;
        float a =  random(115);
        float b =  random(115);
        float alpha = 0;
        float X = width/2;
        float Y = height/2;
        offset=1;
        theta = PI/N*i;
        a = 140;
        b = 0;
        addVisualComponent(new EllipseParticle(colour, offset+PI/2, speed_multiplier,theta, alpha, a, b, new PVector(X, Y), 1));
      }
    }
    
    noStroke();
    size(500,500);
    colorMode(HSB, 256);
  }
  public static void main(String [] args) {
    Main.main(args);
  }
}
