import Math.*;
import ProcessingJava.*;
import processing.core.*;

public class Utils_test3 extends Sketch{
  float t;
  public Utils_test3(PVector size) {
    super(size);
    is_3D = true;
  }
  public Utils_test3(PVector position, PVector size) {
    super(position, size);
    is_3D = true;
  }
  public void setup() {
    record = false;
    frame_limit =200;
    setSpeed(0.033f);
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
    noStroke();
    super.draw();
    fill(0);
    fill(0,0,0);
    directionalLight(255,255,255,-1,-1,0);
  }
}
