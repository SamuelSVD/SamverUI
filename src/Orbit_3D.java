import ProcessingJava.*;
import processing.core.*;
import Math.*;

public class Orbit_3D extends Sketch{
  Camera camera;
  
  public Orbit_3D(PVector size) {
    super(size);
  }
  public Orbit_3D(PVector position, PVector size) {
    super(position, size);
  }
  public void setup() {
    record = true;
    frame_limit = 25*15;
    size((int)size.x, (int)size.y, P3D); //Always needed. Looking for a fix.
    is_3D = true;
    setSpeed(0.04f);
    camera = new Camera(camera_mode.third_person);
    this.setCamera(camera);
    camera.setTarget(0, 0, 0);
    float l = 1000;
    camera.setLocation(l,l,l);
//    camera.setAngles(PI/4,PI/2);
//    camera.setRadius(300);
    camera.angle_accuracy = PI/8;
    camera.position_accuracy = 10;
    camera.DEBUG = false;
    camera.activateControl();
    System.out.println(camera);
    addVisualComponent(new Background(new PVector(5,25,10)));
    
    double a = 125;
    double b = 150;
    
    //Planet 1
    Sphere sphere = new Sphere(new PVector(), new PVector(147,121,106));
    sphere.setPositionFun(0, new Ellipse_X(0,0,PI/2,1,a,b,0));
    sphere.setPositionFun(1, new Ellipse_Y(0,0,PI/2,1,a,b,0));
    sphere.setRotationBeforeTranslateFun3D(0, new Constant(PI));
//    sphere.setRotationAfterTranslateFun3D(1, new Line(-1));
//    sphere.setRotationAfterTranslateFun3D(0, new Constant(PI/2));
//    sphere.setRotationAfterTranslateFun3D(2, new Constant(PI/2));
    sphere.setSize(10);
    sphere.setDetail(50);
    sphere.noStroke();
    addVisualComponent(sphere);
    a += 65;
    b += 65;

    //Planet 2
    sphere = new Sphere(new PVector(), new PVector(207,138,15));
    sphere.setPositionFun(0, new Ellipse_X(0,0,2*PI/15*64,1,a,b,0));
    sphere.setPositionFun(1, new Ellipse_Y(0,0,2*PI/15*64,1,a,b,0));
    sphere.setRotationBeforeTranslateFun3D(0, new Constant(PI));
//    sphere.setRotationAfterTranslateFun3D(1, new Line(-1));
//    sphere.setRotationAfterTranslateFun3D(0, new Constant(PI/2));
//    sphere.setRotationAfterTranslateFun3D(2, new Constant(PI/2));
    sphere.setSize(15);
    sphere.setDetail(50);
    sphere.noStroke();
    addVisualComponent(sphere);
    a += 65;
    b += 65;

    //Planet 3
    VisualContainer vc = new VisualContainer(new PVector(), new PVector());
    vc.setPositionFun(0, new Ellipse_X(0,0,2*PI/15*32,1,a,b,0));
    vc.setPositionFun(1, new Ellipse_Y(0,0,2*PI/15*32,1,a,b,0));
    vc.setRotationBeforeTranslateFun3D(0, new Constant(PI));
    
    sphere = new Sphere(new PVector(), new PVector(98,113,162));
//  sphere.setRotationAfterTranslateFun3D(1, new Line(-1));
//  sphere.setRotationAfterTranslateFun3D(0, new Constant(PI/2));
//  sphere.setRotationAfterTranslateFun3D(2, new Constant(PI/2));
    sphere.setSize(20);
    sphere.setDetail(50);
    sphere.noStroke();
    vc.addVisualComponent(sphere);
    
    //Moon
    sphere = new Sphere(new PVector(), new PVector(255,255,255));
    //sphere.setRotationAfterTranslateFun3D(1, new Line(-1));
    //sphere.setRotationAfterTranslateFun3D(0, new Constant(PI/2));
    //sphere.setRotationAfterTranslateFun3D(2, new Constant(PI/2));
    sphere.setPositionFun(0, new Ellipse_X(0,0,-PI/2,1,30,30,0));
    sphere.setPositionFun(1, new Ellipse_Y(0,0,-PI/2,1,30,30,0));
    sphere.setSize(10);
    sphere.setDetail(50);
    sphere.noStroke();
    vc.addVisualComponent(sphere);
    addVisualComponent(vc);
    
    a += 85;
    b += 85;

    //Planet 4
    sphere = new Sphere(new PVector(), new PVector(140,80,60));
    sphere.setPositionFun(0, new Ellipse_X(0,0,2*PI/15*16,1,a,b,0));
    sphere.setPositionFun(1, new Ellipse_Y(0,0,2*PI/15*16,1,a,b,0));
    sphere.setRotationBeforeTranslateFun3D(0, new Constant(PI));
//    sphere.setRotationAfterTranslateFun3D(1, new Line(-1));
//    sphere.setRotationAfterTranslateFun3D(0, new Constant(PI/2));
//    sphere.setRotationAfterTranslateFun3D(2, new Constant(PI/2));
    sphere.setSize(15);
    sphere.setDetail(50);
    sphere.noStroke();
    addVisualComponent(sphere);
    a += 85;
    b += 85;

    //Planet 5
    sphere = new Sphere(new PVector(), new PVector(170,160,150));
    sphere.setPositionFun(0, new Ellipse_X(0,0,2*PI/15*8,1,a,b,0));
    sphere.setPositionFun(1, new Ellipse_Y(0,0,2*PI/15*8,1,a,b,0));
    sphere.setRotationBeforeTranslateFun3D(0, new Constant(PI));
//    sphere.setRotationAfterTranslateFun3D(1, new Line(-1));
//    sphere.setRotationAfterTranslateFun3D(0, new Constant(PI/2));
//    sphere.setRotationAfterTranslateFun3D(2, new Constant(PI/2));
    sphere.setSize(35);
    sphere.setDetail(50);
    sphere.noStroke();
    addVisualComponent(sphere);
    a += 85;
    b += 85;

    //Planet 6
    sphere = new Sphere(new PVector(), new PVector(100,100,75));
    sphere.setPositionFun(0, new Ellipse_X(0,0,2*PI/15*4,1,a,b,0));
    sphere.setPositionFun(1, new Ellipse_Y(0,0,2*PI/15*4,1,a,b,0));
    sphere.setRotationBeforeTranslateFun3D(0, new Constant(PI));
//    sphere.setRotationAfterTranslateFun3D(1, new Line(-1));
//    sphere.setRotationAfterTranslateFun3D(0, new Constant(PI/2));
//    sphere.setRotationAfterTranslateFun3D(2, new Constant(PI/2));
    sphere.setSize(30);
    sphere.setDetail(50);
    sphere.noStroke();
    addVisualComponent(sphere);
    a += 85;
    b += 85;

    //Planet 7
    sphere = new Sphere(new PVector(), new PVector(130,150,160));
    sphere.setPositionFun(0, new Ellipse_X(0,0,2*PI/15*2,1,a,b,0));
    sphere.setPositionFun(1, new Ellipse_Y(0,0,2*PI/15*2,1,a,b,0));
    sphere.setRotationBeforeTranslateFun3D(0, new Constant(PI));
//    sphere.setRotationAfterTranslateFun3D(1, new Line(-1));
//    sphere.setRotationAfterTranslateFun3D(0, new Constant(PI/2));
//    sphere.setRotationAfterTranslateFun3D(2, new Constant(PI/2));
    sphere.setSize(20);
    sphere.setDetail(50);
    sphere.noStroke();
    addVisualComponent(sphere);
    a += 85;
    b += 85;

    //Planet 8
    sphere = new Sphere(new PVector(), new PVector(40,130,210));
    sphere.setPositionFun(0, new Ellipse_X(0,0,2*PI/15,1,a,b,0));
    sphere.setPositionFun(1, new Ellipse_Y(0,0,2*PI/15,1,a,b,0));
    sphere.setRotationBeforeTranslateFun3D(0, new Constant(PI));
//    sphere.setRotationAfterTranslateFun3D(1, new Line(-1));
//    sphere.setRotationAfterTranslateFun3D(0, new Constant(PI/2));
//    sphere.setRotationAfterTranslateFun3D(2, new Constant(PI/2));
    sphere.setSize(15);
    sphere.setDetail(50);
    sphere.noStroke();
    addVisualComponent(sphere);

    //SUN
    sphere = new Sphere(new PVector(), new PVector(253,193,55));
    sphere.setRotationBeforeTranslateFun3D(0,new Constant(PI/2));
    sphere.setRotationBeforeTranslateFun3D(1,new Line(2*PI/4));
    sphere.setDetail(100);
    sphere.noStroke();
    sphere.setSize(100);
    addVisualComponent(sphere);
  }
  public void draw() {
    directionalLight(200, 200, 200, -1, -1, -1);
    if (false) {
      background(255,255,255);
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
    }
    super.draw();
  }
}
