package sketches;
import processing.core.PVector;
import ProcessingJava.*;
public class OscillatingCircleThingSketch extends Sketch{
  
  public OscillatingCircleThingSketch(PVector position, PVector size) {
    super(position, size);
  }
  public OscillatingCircleThingSketch(PVector size) {
    super(new PVector(), size);
  }
  public void setup() {
    addVisualComponent(new Square(new PVector(), size));
    setSpeed(0.01f);
    noStroke();
    float N = 20;
    PVector center = new PVector(size.x/2,size.y/2);
    for (int i = 0; i < N; i++) {
      PVector colour = new PVector(random(255), random(255), random(255));
      float starting_angle = 2*i*PI/N;
      float ending_angle = 2*(i+1)*PI/N;
      float outer_radius = 200;
      float outer_amplitude = 50;
      float frequency = 0.5f*(-N/2+i);
      addVisualComponent(new OscillatingDonut(center, colour, outer_radius, outer_amplitude, new PVector(starting_angle, ending_angle), frequency));
    }
  }

}
