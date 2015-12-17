import ProcessingJava.*;
import processing.core.*;
import Math.*;

public class Sketch_3D extends Sketch{
  float camera_x = 250;
  float camera_y = 250;
  float camera_z = 250;
  float camera_x2 = 250;
  float camera_y2 = 250;
  float camera_z2 = 0;
  
  public Sketch_3D(PVector size) {
    super(size);
  }
  public Sketch_3D(PVector position, PVector size) {
    super(position, size);
  }
  public void setup() {
    record = false;
    frame_limit = 80;
    size((int)size.x, (int)size.y, P3D); //Always needed. Looking for a fix.
    is_3D = true;
    setSpeed(0.01f);
    addVisualComponent(new Background(new PVector(255,255,255)));
    int N = 3;
    for (int i = 0; i < N; i++){
      PVector colour = new PVector(255.0f/N*i,255,255);
      float offset = random(2*PI);
      float theta = (PI)/((float)(N))*i;
      float speed_multiplier = 3;
      float a =  random(115);
      float b =  random(115);
      float alpha = 1;
      float X = width/2;
      float Y = height/2;
      offset=0;
      theta = 2*PI/N*i;
      alpha = 1;
      a = 140;
      b = i;
      EllipseParticle e = new EllipseParticle(colour, offset+PI/2, speed_multiplier,theta, alpha, a, b, new PVector(X, Y));
      e.addVisualComponent(new Tear(new PVector(0,0), new PVector(50,50), PI/2, new PVector(255,255,255)));
      addVisualComponent(e);
     }
  }
  public void draw() {
    camera(camera_x, camera_y, camera_z, camera_x2, camera_y2, camera_z2, 1, 1, 1);
//    camera(, , , width/2.0f, height/2.0f, 0, 0, 1, 0);
    super.draw();
    box(45);
  }
  public void keyPressed() {
    switch(key) {
      case 'r':
        camera_x += 10;
        break;
      case 'f':
        camera_x -= 10;
        break;
      case 't':
        camera_y += 10;
        break;
      case 'g':
        camera_y -= 10;
        break;
      case 'y':
        camera_z += 10;
        break;
      case 'h':
        camera_z -= 10;
        break;
      case 'u':
        camera_x2 += 10;
        break;
      case 'j':
        camera_x2 -= 10;
        break;
      case 'i':
        camera_y2 += 10;
        break;
      case 'k':
        camera_y2 -= 10;
        break;
      case 'o':
        camera_z2 += 10;
        break;
      case 'l':
        camera_z2 -= 10;
        break;
    }
    System.out.printf("%f %f %f : %f %f %f\n", camera_x, camera_y, camera_z, camera_x2, camera_y2, camera_z2);
  }
}
