import java.util.ArrayList;

import Math.*;
import processing.core.*;
import ProcessingJava.*;
import ProcessingComponents.*;

public class SunAndMoon extends Sketch{
  private SmilingSun s;
  public SunAndMoon(PVector size) {
    this(new PVector(), size);
  }
  public SunAndMoon(PVector position, PVector size) {
    super(position, size);
  }
  public void setup() {
    record = false;
    frame_limit = 408;
    setSpeed(0.033f);
    
    Background b = new Background(new PVector(150,230,255));
    addVisualComponent(b);
    
    s = new SmilingSun();
    s.setPosition(new PVector(250,250));
    addVisualComponent(s);
  }
  
  public void draw() {
    super.draw();
  }
  public void mousePressed() {
  }
  public void mouseDragged() {
  }
  public void mouseReleased() {
  }
}
