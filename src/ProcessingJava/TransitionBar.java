package ProcessingJava;

import java.util.ArrayList;
import processing.core.PVector;
import Math.*;

public class TransitionBar extends VisualComponent{
  ArrayList<Double> points;
  int transition_period;
  double frame_count;
  int index;
  int width;
  Function f;
  
  public TransitionBar(ArrayList<Double> points, int transition_period, int width) {
    this(new PVector(), new PVector(), points, transition_period, width);
  }
  public TransitionBar(PVector position, PVector colour, ArrayList<Double> points, double transition_period, int width) {
    super(position, colour);
    this.points = points;
//    this.transition_period = transition_period;
    frame_count = 0;
    index = 0;
    this.width = width;
    f = new LinearTransition(points,transition_period);
//    f = new ParabolicTransition(points,transition_period);
//    f = new ExponentialTransition(points,transition_period);
//    nextTransition();
  }
  @Override
  public void update(float d) {
    frame_count++;
  }
  public void draw() {
    sketch.fill(colour.x,colour.y,colour.z);
    sketch.rect(0,0,abs((float)f.evaluateAt(frame_count)),width);
  }
  private void nextTransition() {
    index = index+1;
//    System.out.println(index);
    double v0 = (f == null) ? 0 : f.evaluateDerivativeAt(frame_count);
    f = (index < points.size()) ? MathUtils.makeParabola(0, points.get(index-1), transition_period, points.get(index), v0) : new Constant(f.evaluateAt(transition_period));
  }
}
