import processing.core.PVector;
import processing.opengl.PShader;
import processing.*;
import Math.Cos;
import Math.Function;
import Math.Line;
import Math.Sin;
import ProcessingJava.Background;
import ProcessingJava.Band;
import ProcessingJava.Camera;
import ProcessingJava.Sketch;
import ProcessingJava.SpiralStairs;
import ProcessingJava.camera_mode;

public class Utils_test5 extends Sketch{
  float t;
  PShader light_shader;
  public Utils_test5(PVector size) {
    super(size);
    is_3D = true;
  }
  public Utils_test5(PVector position, PVector size) {
    super(position, size);
    is_3D = true;
  }
  public void setup() {
    record = false;
    frame_limit = 200;
    setSpeed(0.033f);
    camera = new Camera(camera_mode.third_person);
    this.setCamera(camera);
    camera.setTarget(0, 0, 0);
    camera.setAngles(PI/4,PI/4);
    camera.setRadius(200);
    camera.angle_accuracy = PI/8;
    camera.position_accuracy = 10;
    camera.DEBUG = false;
    camera.activateControl();
    
    Background b = new Background(new PVector());
    b = new Background(new PVector(255,255,255));
    addVisualComponent(b);
    
    Function x0 = new Sin(0,0,-2*PI/10,2);
    Function y0 = new Cos(0,0,2*PI/10,2);
    Function z0 = new Line(10,0,1,2);
    Function x1 = new Sin(0,0,-2*PI/10,40);
    Function y1 = new Cos(0,0,2*PI/10,40);
    //Function x1 = new Constant(100);
    //Function y1 = new Constant(100);
    Function z1 = new Line(10,0,1,2);
    PVector colour = new PVector(255,150,250);
    double start= 0;
    double end=40;
    int sections=1000;
    Band band = new Band(colour, x0, y0, z0, x1, y1, z1, start, end, sections);
    band.noStroke();
    addVisualComponent(band);
    SpiralStairs s = new SpiralStairs(new PVector(0,0,0), colour, PI/4, 100, 10, 100);
    s.noStroke();
    addVisualComponent(s);
    
    light_shader = loadShader("C:/Programming/ProcessingJava/src/lightfrag.glsl", "C:/Programming/ProcessingJava/src/lightvert.glsl");

  
  }
  public void draw() {
    if (record) {
      t = t+1;
      PVector location = camera.getLocation();
      PVector target = camera.getTarget();
      PVector shift = new PVector(0,0,80/200.0f);
      camera.shift(shift);
      camera.setAngles(3*Math.PI/8,t*Math.PI/100.0);
    }
    lights();
    directionalLight(255,255,255,-1.0f,-1.01f,-1);
    shader(light_shader);
//    directionalLight(150,150,150,1,1,1);
    super.draw();
    //ortho(-width/2, width/2, height/2, -height/2, 0, 200);
    //ortho(0f,0f,0f,0f,0,200f);
//    Utils.drawAxes(this,100);
  }
}
