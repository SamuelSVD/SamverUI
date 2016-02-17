import ProcessingJava.*;
import processing.core.*;
import Math.*;

import java.util.ArrayList;

public class Utils_test2 extends Sketch{
  ArrayList<Float> points,points1,points2;
  public Utils_test2(PVector size) {
    super(size);
  }
  public Utils_test2(PVector position, PVector size) {
    super(position, size);
  }
  public void setup() {
    record = false;
    frame_limit = 364;
    size((int)size.x, (int)size.y, P3D); //Always needed. Looking for a fix.
    setSpeed(0.033f);
    is_3D = true;
//    camera = new Camera(camera_mode.first_person);
    camera = new Camera(camera_mode.third_person);
    this.setCamera(camera);
    camera.setTarget(0, 0, 0);
    camera.setAngles(PI/4,PI/2);
    camera.setRadius(200);
    camera.angle_accuracy = PI/8;
    camera.position_accuracy = 10;
    camera.DEBUG = false;
    camera.activateControl();
    
    Background b = new Background(new PVector(255,255,255));
    addVisualComponent(b);
    
    points = new ArrayList<Float>();
    points.add(0f);
    points.add(0f);
    points.add(0f);
    points.add(100f);
    points.add(0f);
    points.add(0f);
    points.add(100f);
    points.add(100f);
    points.add(0f);
    points.add(0f);
    points.add(100f);

    points1 = new ArrayList<Float>();
    points1.add(0f);
    points1.add(0f);
    points1.add(0f);
    points1.add(100f);
    points1.add(100f);
    points1.add(0f);
    points1.add(200f);
    points1.add(0f);
    points1.add(100f);
    points1.add(300f);
    points1.add(100f);
    points1.add(0f);
    points2 = new ArrayList<Float>();
    points2.add(0f);
    points2.add(0f+100);
    points2.add(0f+100);
    points2.add(100f);
    points2.add(0f+100);
    points2.add(200f);
    points2.add(100f+100);
    points2.add(100f+100);
    points2.add(300f);
    points2.add(100f+100);
    points2.add(100f+100);
  }
  public void draw() {
    super.draw();
    background(200,200,200);
    fill(0,0,0);
    Utils.drawAxes(this, 100);
    Utils.draw_shape_3D(points, this);
//    Utils.draw_rect_mesh_3D(points1, points2, this);
  }
}
