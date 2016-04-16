package ProcessingJava;

import java.util.ArrayList;
import processing.core.PVector;
import Math.*;

public class TransitionBar extends VisualComponent{
  ArrayList<Double> points;
  int transition_period;
  int frame_count;
  int index;
  Function f;
  
  public TransitionBar(ArrayList<Double> points, int transition_period, int width) {
    this(new PVector(), new PVector(), points, transition_period, width);
  }
  public TransitionBar(PVector position, PVector colour, ArrayList<Double> points, int transition_period, int width) {
    super(position, colour);
    this.points = points;
    this.transition_period = transition_period;
    frame_count = 0;
    index = 0;
    nextTransition();
  }
  @Override
  public void update(float d) {
    frame_count++;
    if (frame_count == transition_period) {
      frame_count = 0;
      nextTransition();
    }
  }
  public void draw() {
    sketch.fill(colour.x,colour.y,colour.z);
    sketch.rect(0,0,abs((float)f.evaluateAt(frame_count)),10);
  }
  private void nextTransition() {
    index = index+1;
    double v0 = (f == null) ? 0 : f.evaluateDerivativeAt(frame_count);
    f = (index < points.size()) ? MathUtils.makeParabola(0, points.get(index-1), transition_period, points.get(index), v0) : new Constant(f.evaluateAt(transition_period));
  }
}
