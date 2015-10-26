package ProcessingJava;

import processing.core.PVector;

public class Square extends VisualComponent{
  PVector size;
  
  public Square(PVector colour, PVector size) {
    this(colour, new PVector(0,0), size);
  }
  public Square(PVector colour, PVector position, PVector size) {
    super(position, colour);
    this.position = position;
    this.size = size;
  }
  
  public void draw() {
    sketch.noStroke();
    sketch.fill(colour.x,colour.y,colour.z, alpha);
    sketch.rect(position.x-1,position.y-1,size.x+1,size.y+1);
  }

}
