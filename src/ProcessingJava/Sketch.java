package ProcessingJava;
import processing.core.*;
import java.util.ArrayList;

public abstract class Sketch extends PApplet{
  public ArrayList<VisualComponent> components;
  public PVector size;
  static int MIN_SIZE = 150;

  public Sketch(int x, int y) {
    setLayout(null);
    components = new ArrayList<VisualComponent>();
    if (x < MIN_SIZE) x = MIN_SIZE;
    if (y < MIN_SIZE) y = MIN_SIZE;
    size = new PVector(x,y);
  }
  public void addVisualComponent(VisualComponent vc) {
    components.add(vc); 
    vc.setBounds(0,0,(int)size.x, (int)size.y);
    vc.setSketch(this);
  }
	public abstract void setup();
	public void draw() {
	  float d = (float)0.1;
	  for (int i = 0; i < components.size(); i++) {
	    (components.get(i)).update(d);
	    (components.get(i)).draw();
	  }
	}
}
