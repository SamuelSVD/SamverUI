package ProcessingJava;

import processing.core.PVector;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Shape extends VisualComponent{
  ArrayList<Double> points;
  PVector size;
  public Shape(PVector position, PVector colour) {
    this(position, colour, new PVector(1,1));
  }
  public Shape(PVector position, PVector colour, PVector size) {
    this(position, colour, size, 0);
  }
  public Shape(PVector position, PVector colour, PVector size, double rotation) {
    super(position, colour);
    points = new ArrayList<Double>();
    this.size = size;
    this.rotation = rotation;
  }
  public void init(String filename) throws Exception{
    File file = new File(filename);
    Scanner in = new Scanner(file);
    while (in.hasNext()) {
      double a = in.nextDouble();
      System.out.println(a);
      points.add(a);
    }
    in.close();
  }
  public void draw() {
    sketch.fill(colour.x, colour.y, colour.z);
    sketch.pushMatrix();
    sketch.translate(position.x, position.y);
    sketch.rotate((float)rotation);
    sketch.beginShape();
    for (int i = 0; i < points.size()/2; i++) {
      sketch.vertex((float)(points.get((i*2))*size.x),(float)(points.get((i*2)+1)*size.y));
    }
    sketch.endShape();
    sketch.popMatrix();
  }
  
}
