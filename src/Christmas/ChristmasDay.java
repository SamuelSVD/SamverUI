package Christmas;
import processing.core.PVector;
import ProcessingJava.*;
import Math.*;
public class ChristmasDay extends Sketch{
  Camera camera;
  public ChristmasDay(PVector size) {
    this(new PVector(0,0), size);
  }
  public ChristmasDay(PVector position, PVector size) {
    super(position,size);
    camera = new Camera(camera_mode.radial, this);
    camera.setTarget(0, 0, 0);
    camera.setAngles(PI/2,PI/2);
    camera.setRadius(400);
//  camera.setLocation(250,250, 300);
  camera.setLocation(0,10, 300);
    camera.angle_accuracy = PI/8;
    camera.position_accuracy = 100;
    
    addVisualComponent(new Background(new PVector(255,255,255)));
    
    PVector pos = new PVector(0,0,0);
    PVector colour = new PVector(0,0,0);
    Tree t = new Tree(pos, 0, colour, 200.0f, 50.0f, 3*PI/2, 0.3f, 10, 3); // dandelion
    t.setRotationBeforeTranslate3D(new PVector(0,-PI/2,0));
    t.setRotationAfterTranslate3D(new PVector(PI/2,0,0));
    addVisualComponent(t);
    
    addVisualComponent(new Circle(new PVector(0,0,0), new PVector(158,150,255), 100));
    addVisualComponent(new Circle(new PVector(0,0,1), new PVector(255,150,150), 50));
    
    for (int j = 1; j > 0; j--) {
      pos = new PVector(100,100, 3);
      colour = new PVector(139,69,19);
      PVector new_colour = new PVector(49,100 + random(100),49);
      int N = 5;
      for (int i = N; i > 1; i--) {
        float h = 10;
        FadingTree t2 = new FadingTree(pos, 0, colour, new_colour, h*i+3*j, (h/2.0f)*i+3*j/2.0f, PI/2, 0.8f - 0.5f*i/N, 4, 5); // pine tree
//        t.setRotationBeforeTranslate3D(new PVector(0,-PI/2,0));
        t.setRotationAfterTranslate3D(new PVector(PI/2,PI/2,0));
        addVisualComponent(t2);
      }
    }
    
  }
  public void draw() {
    camera.use();
    super.draw();
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
    
  }
  @Override
  public void setup() {
    size((int)size.x, (int)size.y, P3D);
    is_3D = true;
    setSpeed(0.01f);

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
  
  public void keyPressed() {
    camera.keyPressed(key);
    System.out.println(camera);
  }

}
