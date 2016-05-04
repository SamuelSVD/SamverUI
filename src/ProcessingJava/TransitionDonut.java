package ProcessingJava;

import java.util.ArrayList;
import processing.core.PVector;
import Math.*;

public class TransitionDonut extends VisualComponent{
  ArrayList<Double> points;
  double frame_count, starting_angle, ending_angle;
  int index;
  Function f;
  Donut d;
  public TransitionDonut(PVector position, PVector colour, ArrayList<Double> points, double transition_period, float starting_angle, float ending_angle) {
    super(position, colour);
    this.points = points;
    this.starting_angle = starting_angle;
    this.ending_angle = ending_angle;
    frame_count = 0;
    index = 0;
//    d = new Donut(position, colour, 0, 0, starting_angle, ending_angle);
    f = new LinearTransition(points,transition_period);
//    f = new ParabolicTransition(points,transition_period);
//    f = new ExponentialTransition(points,transition_period);
  }
  @Override
  public void update(float d) {
    frame_count++;
  }
  public void draw() {
//    if (d.sketch == null) d.setSketch(this.sketch);
//    d.setOuterRadius((float)f.evaluateAt(frame_count));
//    d.draw();
    sketch.fill(colour.x, colour.y, colour.z);
    sketch.noStroke();
    sketch.arc(0, 0, (float)f.evaluateAt(frame_count), (float)f.evaluateAt(frame_count), (float)starting_angle, (float)ending_angle);
  }
}
