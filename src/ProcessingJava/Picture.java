package ProcessingJava;

import processing.core.*;

public class Picture extends VisualComponent{
  PImage image;
  public Picture(PVector position, String file_location) {
    super(position, new PVector());
    image = loadImage(file_location);
    // TODO Auto-generated constructor stub
  }
  public void resize(int width, int height) {
    image.resize(width, height);
  }
  public int getWidth() {
    return image.width;
  }
  public int getHeight() {
    return image.height;
  }
  public void draw() {
    sketch.image(image, -image.width/2, -image.height/2);
  }

}
