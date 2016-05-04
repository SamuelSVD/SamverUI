import processing.core.*;
import Math.*;
import ProcessingJava.*;

public class RussianDolls extends Sketch{
  float t;
  public RussianDolls(PVector size) {
    super(size);
  }
  public RussianDolls(PVector position, PVector size) {
    super(position, size);
  }
  public void setup() {
    record = false;
    frame_limit = 200;
    setSpeed(0.033f);
    
    Background b = new Background(new PVector());
    b = new Background(new PVector(255,255,255));
    addVisualComponent(b);
    
  }
  public void draw() {
    super.draw();
  }
}
