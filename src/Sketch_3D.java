import ProcessingJava.*;
import processing.core.*;
import Math.*;

public class Sketch_3D extends Sketch{
  Camera camera;
  
  public Sketch_3D(PVector size) {
    super(size);
  }
  public Sketch_3D(PVector position, PVector size) {
    super(position, size);
  }
  public void setup() {
    record = true;
    frame_limit = 200;
    size((int)size.x, (int)size.y, P3D); //Always needed. Looking for a fix.
    is_3D = true;
    setSpeed(0.01f);
    camera = new Camera(camera_mode.radial, this);
    camera.setTarget(0, 0, 0);
    camera.setAngles(PI/4, PI/4);
    camera.setRadius(400);
    camera.angle_accuracy = PI/8;
    camera.position_accuracy = 100;
    System.out.println(camera);
//    camera.keyPressed((char)0);
//    addVisualComponent(new Background(new PVector(255,255,255)));
  }
  public void draw() {
    int FRAMES = 100;
    if (frameCount < FRAMES + 1) camera.setAngles(camera.getAngle1(), camera.getAngle2() + 2*PI/FRAMES);
    else camera.setAngles(camera.getAngle1() + 2*PI/FRAMES, camera.getAngle2());
    camera.use();
    
    background(255,255,255);
    directionalLight(200, 200, 200, -1, -1, -1);
   // ambientLight(250,250,0);
    //Red X
    stroke(255,0,0);
    line(0,0,0,100,0,0);
    translate(100,0,0);
    box(10);
    translate(-100,0,0);
    //Green Y
    stroke(0,255,0);
    line(0,0,0,0,100,0);
    translate(0,100,0);
    box(10);
    translate(0,-100,0);
    //Blue Z
    stroke(0,0,255);
    line(0,0,0,0,0,100);
    translate(0,0,100);
    box(10);
    translate(0,0,-100);
    //Magenta diagonal
    stroke(255,0,255);
    line(0,0,0,100,100,100);
    translate(100,100,100);
    box(10);
    translate(-100,-100,-100);
    super.draw();
  }
  public void keyPressed() {
    camera.keyPressed(key);
    System.out.println(camera);
  }
}
