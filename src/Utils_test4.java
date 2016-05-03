import ProcessingJava.*;
import processing.core.*;
import Math.*;

public class Utils_test4 extends Sketch{
  float t;
  public Utils_test4(PVector size) {
    super(size);
  }
  public Utils_test4(PVector position, PVector size) {
    super(position, size);
  }
  public void setup() {
    record = false;
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
    
    Background b = new Background(new PVector(0,0,0));
    addVisualComponent(b);
    
    Field3D f = new Field3D(new PVector(), new PVector(100,230,255), new PVector(100,100), 100, 50);
    f.setStrokeColor(new PVector(255,255,255));
//    f.noStroke();
    f.setFillColour(new PVector(0,0,0));
    addVisualComponent(f);
    
  }
  public void draw() {
    if (record) {
      t = t+1;
//      camera.setAngles(Math.PI/4,t*Math.PI/100.0);
    }
    super.draw();
    directionalLight(255,255,255,-1,-1,0);
  }
}