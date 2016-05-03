package ProcessingJava;

import processing.core.PVector;

public class Background extends VisualComponent{

  public Background(PVector colour) {
    super(new PVector(), colour);
  }
  public void draw() {
    sketch.background(colour.x, colour.y, colour.z);
  }
}
