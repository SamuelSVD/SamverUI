package ProcessingJava;

import Math.Function;
import processing.core.PVector;

public class VisualContainer extends VisualComponent{
  protected VisualComponent visual_component;
  protected Function[] visual_component_position_fun = new Function[3];
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
    super.update(d);
    if (visual_component != null) {
      visual_component.update(d);
    }
    if (visual_component_position_fun[0] != null) {
      visual_component_position_fun[0].update(d);
      visual_component_position.x = (float)visual_component_position_fun[0].getValue();
    }
    if (visual_component_position_fun[1] != null) {
      visual_component_position_fun[1].update(d);
      visual_component_position.y = (float)visual_component_position_fun[1].getValue();
    }
    if (visual_component_position_fun[2] != null) {
      visual_component_position_fun[2].update(d);
      visual_component_position.z = (float)visual_component_position_fun[2].getValue();
    }
  }
  public void draw() {
    PVector pos = new PVector();
    pos.add(position);
    pos.add(visual_component_position);
    if (visual_component != null) {
      visual_component.draw(pos);
    }
    else {
      sketch.fill(colour.x, colour.y, colour.z);
      sketch.ellipse(pos.x, pos.y, 2, 2);
    }
  }
}
