package ProcessingJava;
import processing.core.*;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.Date;

public abstract class Sketch extends PApplet{
  public ArrayList<VisualComponent> components;
  public PVector position;
  public PVector size;
  public boolean record = false;
  protected boolean is_3D = false;
  protected boolean DEBUG = false;
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
    components = new ArrayList<VisualComponent>();
    if (size.x < MIN_SIZE) size.x = MIN_SIZE;
    if (size.y < MIN_SIZE) size.y = MIN_SIZE;
    this.position = position;
    this.size = size;
  }
  public void addVisualComponent(VisualComponent vc) {
    components.add(vc); 
    vc.setSketch(this);
  }
  public ArrayList<VisualComponent> getVisualComponents() {
    return components;
  }
  public void setSpeed(float s) {
    this.speed = s;
  }
	public void draw() {
	  if (DEBUG) System.out.println(frameCount);
	  if (camera != null) {
	    if (camera.hasControl()) camera.use(speed);
	    else camera.use();
	  }
	  for (int i = 0; i < components.size(); i++) {
	    (components.get(i)).update(speed);
	    (components.get(i)).doDraw();
	  }
	  if (record) {
      if (this.frameCount < frame_limit+1) {
        saveFrame("Images/frame-#####.tif");
        fill(255,0,0);
        this.ellipse(10,10,10,10);
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
    if (key == '`') {
      String timeStamp = new java.text.SimpleDateFormat("yyMMdd_HHmmss").format(new Date());
      saveFrame("Images/Screenshots/Screenshot_" + timeStamp + ".tif");
    }
    if (camera != null) {
      camera.keyPressed(key, keyCode);
    }
  }
  public void keyReleased() {
    if (camera != null) {
      camera.keyReleased(key, keyCode);
    }
  }
  public void mouseDragged() {
    if (camera != null) {
      camera.mouseDragged();
    }
  }
  public void mouseWheel(processing.event.MouseEvent me) {
    if (camera != null) {
      camera.mouseWheel(me);
    }
  }
  public void settings() {
    if (is_3D) size((int)size.x, (int)size.y, P3D);
    else size((int)size.x, (int)size.y);
  }
  public void arc(float a, float b, float c, float d, float start, float stop) {
    if (start > stop) {
      start = start % (2*PI);
      stop = stop % (2*PI);
      if (stop > start) start = start + 2*PI;
      super.arc(a, b, c, d, stop, start);
    }
    else super.arc(a,b,c,d,start, stop);
  }

  public void arc(float a, float b, float c, float d, float start, float stop, int mode) {
    if (start > stop) {
      start = start % (2*PI);
      stop = stop % (2*PI);
      if (stop > start) start = start + 2*PI;
      super.arc(a, b, c, d, stop, start, mode);
    }
    else super.arc(a,b,c,d,start, stop, mode);
  }
  public void fill(PVector color) {
    super.fill(color.x, color.y, color.z);
  }
  public abstract void setup();
}
