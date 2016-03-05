package ProcessingJava;

import processing.core.PVector;

public class Sphere extends VisualComponent{
  private float size = 10;
  private int detail = 10;
  public Sphere(PVector position, PVector colour) {
    super(position, colour);
  }
  public void draw() {
    sketch.sphereDetail(detail);
    sketch.sphere(size);
  }
  public void setSize(double size) {
    this.size = (float)size;
  }
  public void setDetail(int detail) {
    this.detail = detail;
  }

}
