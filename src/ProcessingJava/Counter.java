package ProcessingJava;

import processing.core.*;

public class Counter extends VisualComponent{
  PFont font;
  float count = 0;
  public Counter(PVector position, PVector colour) {
    super(position, colour);
    font = createFont("Arial",16,true);
  }
  public void update(float d ) {
    count += d;
  }
  public void draw() {
    sketch.textFont(font);
//    sketch.textAlign(CENTER);
    sketch.fill(colour.x, colour.y, colour.z);
    sketch.text(String.format("%f", count), 0, 0);
  }

}
