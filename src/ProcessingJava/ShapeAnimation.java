package ProcessingJava;

import processing.core.PVector;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class ShapeAnimation extends VisualComponent{
  ArrayList<ArrayList<Double>> points;
  PVector size;
  private int current_frame = -1;
  private double frame_period = 1;
  private double cumulative = 0;
  public ShapeAnimation(PVector position, PVector colour) {
    this(position, colour, new PVector(1,1));
  }
  public ShapeAnimation(PVector position, PVector colour, PVector size) {
    this(position, colour, size, 0);
  }
  public ShapeAnimation(PVector position, PVector colour, PVector size, double rotation) {
    super(position, colour);
    points = new ArrayList<ArrayList<Double>>();
    this.size = size;
    this.rotation = rotation;
  }
  public void init(String filename) throws Exception{
    File file = new File(filename);
    Scanner file_in = new Scanner(file);
    file_in.useDelimiter("\r\n");
    while (file_in.hasNext()) {
      String string_line = file_in.next();
      Scanner line = new Scanner(string_line);
      ArrayList<Double> shape = new ArrayList<Double>();
      while (line.hasNext()) {
        shape.add(line.nextDouble());
      }
      points.add(shape);
    }
    if (points.size() > 0) current_frame = 0;
    file_in.close();
  }
  public void update(float d) {
    super.update(d);
    if (current_frame != -1) {
      cumulative += d;
      int f = (int)(cumulative/frame_period);
      current_frame = f % points.size();
    }
  }
  public void draw() {
    sketch.fill(colour.x, colour.y, colour.z);
    sketch.pushMatrix();
    sketch.translate(position.x, position.y);
    sketch.rotate((float)rotation);
    sketch.beginShape();
    for (int i = 0; i < points.get(current_frame).size()/2; i++) {
      sketch.vertex((float)(points.get(current_frame).get((i*2))*size.x),(float)(points.get(current_frame).get((i*2)+1)*size.y));
    }
    sketch.endShape();
    sketch.popMatrix();
  }
}
