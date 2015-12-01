package ProcessingJava;

import processing.core.PVector;

public class VisualContainer extends VisualComponent{
  protected VisualComponent visual_component;
  protected PVector visual_component_position;
  
  VisualContainer(PVector position, PVector colour) {
    super(position, colour);
    visual_component_position = new PVector();
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
    if (visual_component != null) {
      visual_component.update(d);
    }
  }
  public void draw() {
    PVector pos = new PVector();
    pos.add(position);
    pos.add(visual_component_position);
    sketch.fill(colour.x,colour.y,colour.z);
    if (visual_component != null) {
      visual_component.draw(pos);
    }
    else {
      sketch.ellipse(pos.x, pos.y, 2, 2);
    }
  }
}
