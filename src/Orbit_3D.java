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
    addVisualComponent(new Background(new PVector(5,10,25)));
    
    double a = 125;
    double b = 150;
    double size[] = {10, 15, 20, 15, 35, 30, 20, 15};
    double inc[] =  {65, 65, 85, 85, 85, 85, 85, 65};
    float freq[] = {16*PI/15, 16*PI/15, 8*PI/15, 8*PI/15, 4*PI/15, 4*PI/15, 2*PI/15, 2*PI/15};
    PVector colours[] = {new PVector(147,121,106),
                         new PVector(207,138,15), 
                         new PVector(), 
                         new PVector(140,80,60), 
                         new PVector(170,160,150), 
                         new PVector(100,100,75), 
                         new PVector(130,150,160), 
                         new PVector(40,130,210)};
    
    Sphere sphere;
    for (int i = 0; i < 8; i++) {
      if (i == 2) {
      //Planet 3
        VisualContainer vc = new VisualContainer(new PVector(), new PVector());
        vc.setPositionFun(0, new Ellipse_X(0,0,freq[i],1,a,b,0));
        vc.setPositionFun(1, new Ellipse_Y(0,0,freq[i],1,a,b,0));
//        vc.setRotationBeforeTranslateFun3D(0, new Constant(PI));
        
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
        sphere.setPositionFun(0, new Ellipse_X(0,0,-2*freq[i],1,30,30,0));
        sphere.setPositionFun(1, new Ellipse_Y(0,0,-2*freq[i],1,30,30,0));
        sphere.setSize(10);
        sphere.setDetail(50);
        sphere.noStroke();
        vc.addVisualComponent(sphere);
        addVisualComponent(vc);
      }
      else {
        float offset_x = random(2*PI/freq[i]);
        sphere = new Sphere(new PVector(), colours[i]);
        sphere.setPositionFun(0, new Ellipse_X(offset_x,0,freq[i],1,a,b,0));
        sphere.setPositionFun(1, new Ellipse_Y(offset_x,0,freq[i],1,a,b,0));
  //      sphere.setRotationBeforeTranslateFun3D(0, new Constant(PI));
        sphere.setSize(size[i]);
        sphere.setDetail(50);
        sphere.noStroke();
        addVisualComponent(sphere);
      }
      a += inc[i];
      b += inc[i];
    }
    
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
