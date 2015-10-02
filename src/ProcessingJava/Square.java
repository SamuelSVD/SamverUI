package ProcessingJava;

import processing.core.PVector;

public class Square extends VisualComponent{
  PVector size;
  
  public Square(PVector colour, PVector position, PVector size) {
    super(colour);
    this.position = position;
    this.size = size;
  }
  
  public void draw() {
    sketch.fill(colour.x,colour.y,colour.z, 10f);
    sketch.rect(position.x,position.y,size.x,size.y);
  }

}
