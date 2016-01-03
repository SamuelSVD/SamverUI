package ProcessingJava;

import processing.core.PVector;

public class Sphere extends VisualComponent{

  Sphere(PVector position, PVector colour) {
    super(position, colour);
  }
  public void draw() {
    sketch.sphere(10);
  }

}
