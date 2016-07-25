package ProcessingJava;

import processing.core.PVector;
import java.util.ArrayList;

import Math.Function;

public class VisualContainer extends VisualComponent{
  protected ArrayList<VisualComponent> visual_components;
  
  public VisualContainer() {
    this(new PVector(), new PVector());
  }
  public VisualContainer(PVector position) {
    this(position, new PVector());
  }
  public VisualContainer(PVector position, PVector colour) {
    super(position, colour);
    visual_components = new ArrayList<VisualComponent>();
  }
  public void addVisualComponent(VisualComponent visual_component) {
    this.visual_components.add(visual_component);
    visual_component.sketch = this.sketch;
  }
  public void setSketch(Sketch s) {
    super.setSketch(s);
    for (int i = 0; i < visual_components.size(); i++) {
      visual_components.get(i).setSketch(s);
    }
  }
  public void update(float d) {
    super.update(d);
    for (int i = 0; i < visual_components.size(); i++) {
      visual_components.get(i).update(d);
    }
  }
  public void draw() {
    for (int i = 0; i < visual_components.size(); i++) {
      visual_components.get(i).doDraw();
    }
    if (visual_components.size() == 0) {
      sketch.fill(colour.x, colour.y, colour.z);
      sketch.ellipse(0, 0, 2, 2);
    }
  }
}
