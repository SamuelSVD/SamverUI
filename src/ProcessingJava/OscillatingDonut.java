package ProcessingJava;
import processing.core.*;

public class OscillatingDonut extends Donut{
  protected float frequency, offset, inner_amplitude, outer_amplitude, time, oscillating_inner_radius, oscillating_outer_radius;
  
  public OscillatingDonut(PVector position, PVector colour, float radius, float amplitude, float frequency) {
    this(position, colour, radius, amplitude, frequency, 0);
  }
  public OscillatingDonut(PVector position, PVector colour, float radius, float amplitude, PVector angles, float frequency) {
    this(position, colour, radius, amplitude, angles, frequency, 0);
  }
  public OscillatingDonut(PVector position, PVector colour, float radius, float amplitude, float frequency, float offset) {
    this(position, colour, new PVector(0, radius), amplitude, frequency, offset);
  }
  public OscillatingDonut(PVector position, PVector colour, float radius, float amplitude, PVector angles, float frequency, float offset) {
    this(position, colour, new PVector(0, radius), amplitude, angles, frequency, offset);
  }
  public OscillatingDonut(PVector position, PVector colour, PVector radius, float amplitude, float frequency, float offset) {
    this(position, colour, radius, new PVector(0, amplitude), frequency, offset);
  }
  public OscillatingDonut(PVector position, PVector colour, PVector radius, float amplitude, PVector angles, float frequency, float offset) {
    this(position, colour, radius, new PVector(0, amplitude), angles, frequency, offset);
  }
  public OscillatingDonut(PVector position, PVector colour, PVector radius, PVector amplitude, float frequency, float offset) {
    this(position, colour, radius, amplitude, new PVector(0,2*PI), frequency, offset);
  }
  public OscillatingDonut(PVector position, PVector colour, PVector radius, PVector amplitude, PVector angles, float frequency, float offset) {
    super(position, colour, radius.x, radius.y, angles.x, angles.y);
    this.offset = offset;
    this.frequency = frequency;
    this.inner_amplitude = amplitude.x;
    this.outer_amplitude = amplitude.y;
  }
  
  public void update(float d) {
    super.update(d);
    time += d;
    oscillating_inner_radius = inner_radius + inner_amplitude * cos(2 * PI * time * frequency + offset);
    oscillating_outer_radius = outer_radius + outer_amplitude * cos(2 * PI * time * frequency + offset);
    if (oscillating_inner_radius < 0) oscillating_inner_radius = 0;
    if (oscillating_outer_radius < 0) oscillating_outer_radius = 0;
  }
  public void draw() {
    sketch.fill(colour.x,colour.y, colour.z, this.alpha);
    drawDonut(sketch, 0, 0, oscillating_inner_radius, oscillating_outer_radius, starting_angle, ending_angle);
  }
}
