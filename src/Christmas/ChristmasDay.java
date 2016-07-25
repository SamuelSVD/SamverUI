package Christmas;
import processing.core.PVector;
import Math.*;
import ProcessingJava.*;
public class ChristmasDay extends Sketch{
  Tree t;
  double x,y,z,dx,dy,dz;
  float mX, mY;
  int section = 0;
  public ChristmasDay() {
	  this(new PVector(500,500));
  }
  public ChristmasDay(PVector size) {
    this(new PVector(0,0), size);
  }
  public ChristmasDay(PVector position, PVector size) {
    super(position,size);
    record = false;
    frame_limit = 250;
    camera = new Camera(camera_mode.first_person);
//    camera = new Camera(camera_mode.third_person);
    this.setCamera(camera);
    camera.setTarget(0, 0, 0);
    camera.setAngles(PI/4,PI/2);
    camera.setRadius(200);
    camera.angle_accuracy = PI/8;
    camera.position_accuracy = 10;
    camera.DEBUG = false;
    camera.activateControl();
    addVisualComponent(new Background(new PVector(255,255,255)));
    
    PVector pos = new PVector(0,0,0);
    PVector colour = new PVector(0,0,0);
    t = new Tree(pos, 0, colour, 200.0f, 1050.0f, 3*PI/2, 0.3f, 10, 3); // dandelion
//    t.setRotationBeforeTranslate3D(new PVector(0,-PI/2,0));
//    t.setRotationAfterTranslate3D(new PVector(0,-PI/2,0));
//    t.setRotationAfterTranslate3D(new PVector(PI/2-PI/3,-PI/3,0));
    //Aligned with XZ plane
    x = PI/2;
    y = -PI;
    z = PI/2;
    
    //Aligned with YZ plane
    x = 0;
    y = -PI/2;
    z = 0;
    
    //Aligned diagonally between XZ YZ plane
    x = PI/2;
    y = PI/4;
    z = PI/2;
    
//    addVisualComponent(t);
    
    addVisualComponent(new Circle(new PVector(0,0,0), new PVector(158,150,255), 100));
    addVisualComponent(new Circle(new PVector(0,0,1), new PVector(255,150,150), 50));
    
    
    
    
    int num = 0;
    colour = new PVector(139,69,19);
    PVector new_colour = new PVector(49,150 + random(100),49);
    for (int j = num; j > 0; j--) {
      pos = new PVector(0,0, 3);
      int N = 5;
      for (int i = N; i > 1; i--) {
        float h = 10;
        FadingTree t2 = new FadingTree(pos, 0, colour, new_colour, h*i, 100*(h/2.0f)*i, PI/2, 0.8f - 0.5f*i/N, 4, 4); // pine tree
//        t2.setRotationBeforeTranslate3D(new PVector(0,-PI/2,0));
        t2.setRotationAfterTranslate3D(new PVector(PI/2,PI/num*j,PI/2));
        addVisualComponent(t2);
      }
    }
    
    
    FadingTree t2;
    num = 5;
    colour = new PVector(139,69,19);
    new_colour = new PVector(49,150 + random(100),49);
    for (int j = 0; j < num; j++) {
      int h = 10;
      float cumulative = 0;
      float N = 10;
      for( int i = 0; i < N; i++) {
        pos = new PVector(0,0, 3+cumulative);
        cumulative += h*(1-i/N);
        t2 = new FadingTree(pos, 0, colour, new_colour, h*(1-i/N), 1000, PI/2, 0.8f, 4, 4); // pine tree
    //    t2.setDelay(i*1);
        t2.setRotationAfterTranslate3D(new PVector(PI/2,PI/num*j,PI/2));
        addVisualComponent(t2);
      }
    }
  }

  public void draw() {
    t.setRotationAfterTranslate3D(new PVector((float)(x + dx),(float)(y+dy),(float)(z+dz)));

//    camera.setAngles(camera.getAngle1(), camera.getAngle2()+0.02);
    super.draw();
    if (true) {
      //Red X
      strokeWeight(1);
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
    }
  }
  @Override
  public void setup() {
    size((int)size.x, (int)size.y, P3D);
    is_3D = true;
    setSpeed(0.01f);

  }
  
  public void keyPressed() {
    System.out.println((int)key);
    super.keyPressed();
    switch(key){
      case 32:
        System.out.printf("%f %f %f\n", x, y, z);
        break;
    }
  }
  
  public void mousePressed() {
    if (mouseX > 0 && mouseX < width/3) section = 0;
    if (mouseX > width/3 && mouseX < 2*width/3) section = 1;
    if (mouseX > 2*width/3 && mouseX < width) section = 2;
    mX = mouseX;
    mY = mouseY;
  }
  public void mouseDragged() {
    float dM = (mY - mouseY);
    switch(section) {
      case 0:
        dx = dM/100.0*PI/2;
        break;
      case 1:
        dy = dM/100.0*PI/2;
        break;
      case 2:
        dz = dM/100.0*PI/2;
        break;
    }
  }
  public void mouseReleased() {
    x = x+dx;
    y = y+dy;
    z = z+dz;
    dx = 0;
    dy = 0;
    dz = 0;
  }
  public static void main(String[] args) {
    int size = 500;
    PVector p = new PVector(size, size);
    MainDisplay mainDisplay = new MainDisplay(size,size+6);
    Sketch s;
    s = new ChristmasDay(p);
    mainDisplay.addSketch(s);
    mainDisplay.setVisible(true);
  }
  
}
