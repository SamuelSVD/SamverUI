import ProcessingJava.*;
import processing.core.*;
import Math.*;

public class Utils_test3 extends Sketch{
  float t;
  public Utils_test3(PVector size) {
    super(size);
  }
  public Utils_test3(PVector position, PVector size) {
    super(position, size);
  }
  public void setup() {
    record = true;
    frame_limit =200;
    size((int)size.x, (int)size.y, P3D); //Always needed. Looking for a fix.
    setSpeed(0.033f);
    is_3D = true;
    camera = new Camera(camera_mode.third_person);
    this.setCamera(camera);
    camera.setTarget(0, 0, 0);
    camera.setAngles(0,0);
    camera.setRadius(35);
    camera.angle_accuracy = PI/8;
    camera.position_accuracy = 10;
    camera.DEBUG = false;
    camera.activateControl();
    
    Background b = new Background(new PVector(255,255,255));
    addVisualComponent(b);
    
    Field3D f = new Field3D(new PVector(), new PVector(100,230,255), new PVector(100,100), 100, 50);
    f.setStrokeColor(new PVector(100,100,240));
    f.noStroke();
    addVisualComponent(f);
    
  }
  public void draw() {
    if (record) {
      t = t+1;
//      camera.setAngles(Math.PI/4,t*Math.PI/100.0);
    }
    directionalLight(255,255,255,1,1,-1);
    directionalLight(0,200,0,-1,1,-1);
    directionalLight(50,50,150,1,-1,-1);
    directionalLight(250,50,150,-1,-1,-1);
//    directionalLight(255,150,150,-1,-1,0);
    noStroke();
    super.draw();
//    Utils.drawAxes(this, 100);
//    noStroke();
//    stroke(255);
    fill(0);
//    Utils.draw_shape_3D(points, this);
    fill(0,0,0);
    directionalLight(255,255,255,-1,-1,0);
  }
}
