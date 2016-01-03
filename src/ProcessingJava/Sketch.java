package ProcessingJava;
import processing.core.*;

import java.util.ArrayList;

public abstract class Sketch extends PApplet{
  public ArrayList<VisualComponent> components;
  public PVector position;
  public PVector size;
  public boolean record = false;
  protected boolean is_3D = false;
  protected Camera camera;
  public int frame_limit = 350;
  static int MIN_SIZE = 150;
  private float speed = 0.1f;
  public Sketch() {
    this(new PVector(0,0), new PVector(100,100));
  }
  public Sketch(PVector size) {
    this(new PVector(0,0), size);
  }
  public Sketch(PVector position, PVector size) {
    setLayout(null);
    components = new ArrayList<VisualComponent>();
    if (size.x < MIN_SIZE) size.x = MIN_SIZE;
    if (size.y < MIN_SIZE) size.y = MIN_SIZE;
    this.position = position;
    this.size = size;
  }
  public void addVisualComponent(VisualComponent vc) {
    components.add(vc); 
    vc.setBounds(0,0,(int)size.x, (int)size.y);
    vc.setSketch(this);
  }
  public void setSpeed(float s) {
    this.speed = s;
  }
	public void draw() {
	  if (camera != null) {
	    camera.use();
	  }
	  float d = (float)0.1;
	  for (int i = 0; i < components.size(); i++) {
	    (components.get(i)).update(speed);
	    (components.get(i)).doDraw();
	  }
	  if (record) {
	    saveFrame("Images/frame-#####.tif");
      if (this.frameCount > frame_limit) {
        this.stop();
      }
	  }
	}
	public void line(double x1, double y1, double x2, double y2) {
	  this.line((float)x1, (float)y1, (float)x2, (float)y2);
	}
	public boolean is3D() {
	  return is_3D;
	}
	public void setCamera(Camera c) {
	  this.camera = c;
	  c.setSketch(this);
	}
	public Camera getCamera() {
	  return camera;
	}
  public void keyPressed() {
    if (camera != null) {
      camera.keyPressed(key);
    }
  }

  public abstract void setup();
}
