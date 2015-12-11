package ProcessingJava;

import Math.Function;
import processing.core.PVector;

public class VisualContainer extends VisualComponent{
  protected VisualComponent visual_component;
  
  public VisualContainer() {
    super(new PVector(), new PVector());
  }
  public VisualContainer(PVector position, PVector colour) {
    super(position, colour);
  }
  public void setVisualComponent(VisualComponent visual_component) {
    this.visual_component = visual_component;
    visual_component.sketch = this.sketch;
  }
  public void setSketch(Sketch s) {
    super.setSketch(s);
    if (visual_component != null) {
      visual_component.setSketch(s);
    }
  }
  public void update(float d) {
    super.update(d);
    if (visual_component != null) {
      visual_component.update(d);
    }
  }
  public void draw() {
    if (visual_component != null) {
      visual_component.doDraw();
    }
    else {
      sketch.fill(colour.x, colour.y, colour.z);
      sketch.ellipse(0, 0, 2, 2);
    }
  }
}
