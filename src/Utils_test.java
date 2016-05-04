import ProcessingJava.*;
import processing.core.*;
import Math.*;
import java.util.ArrayList;

public class Utils_test extends Sketch{
  ArrayList<Float> points,points1,points2;
  public Utils_test(PVector size) {
    super(size);
  }
  public Utils_test(PVector position, PVector size) {
    super(position, size);
  }
  public void setup() {
    record = false;
    frame_limit = 364;
    setSpeed(0.033f);
    noStroke();
    background(0);
    Square s = new Square(new PVector(), size);
    addVisualComponent(s);
    points = new ArrayList<Float>();
    points.add(0f);
    points.add(0f);
    points.add(100f);
    points.add(0f);
    points.add(100f);
    points.add(100f);
    points.add(0f);
    points.add(100f);

    points1 = new ArrayList<Float>();
    points1.add(0f);
    points1.add(0f);
    points1.add(100f);
    points1.add(0f);
    points1.add(200f);
    points1.add(0f);
    points1.add(300f);
    points1.add(0f);
    points2 = new ArrayList<Float>();
    points2.add(0f);
    points2.add(0f+100);
    points2.add(100f);
    points2.add(0f+100);
    points2.add(200f);
    points2.add(100f+100);
    points2.add(300f);
    points2.add(100f+100);
  }
  public void draw() {
    background(200,200,200);
    fill(0,0,0);
    Utils.draw_shape(points, this);
    Utils.draw_rect_mesh(points1, points2, this);
  }
}
