import ProcessingJava.*;
import processing.core.*;

import java.util.ArrayList;

import Math.*;

public class Utils_test2 extends Sketch{
  ArrayList<Float> points,points1,points2;
  public Utils_test2(PVector size) {
    super(size);
    is_3D = true;
  }
  public Utils_test2(PVector position, PVector size) {
    super(position, size);
    is_3D = true;
  }
  public void setup() {
    record = false;
    frame_limit = 364;
    setSpeed(0.033f);
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

    float l=100;
    float n=10;
    float p = 40;
    points1 = new ArrayList<Float>();
    for (float i = 0; i < n; i++) {
      float x = (i*l/n);
      points1.add(x);
      points1.add(0f);
      points1.add((float)(20*Math.sin(Math.PI*2*x/p)));
    }
    points2 = new ArrayList<Float>();
    for (float i = 0; i < n; i++) {
      float x = (i*l/n);
      points2.add(x);
      points2.add(100f);
      points2.add((float)(20*Math.cos(Math.PI*2*x/p)));
    }
  }
  public void draw() {
    super.draw();
    background(0,0,0);
    Utils.drawAxes(this, 100);
//    noStroke();
    stroke(255);
    fill(0);
//    Utils.draw_shape_3D(points, this);
    fill(0,0,0);
    Utils.draw_rect_mesh_3D(points1, points2, this);
  }
}
