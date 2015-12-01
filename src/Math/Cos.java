package Math;

public class Cos extends Function{
  private float omega = 1;
  private float amplitude = 1;
  public Cos() {
  }
  public Cos(float x_offset, float y_offset) {
    super(x_offset, y_offset);
  }
  public Cos(float x_offset, float y_offset, float omega) {
    this.x_offset = x_offset;
    this.y_offset = y_offset;
    this.omega = omega;
  }
  
  public Cos(float x_offset, float y_offset, float omega, float amplitude) {
    this.x_offset = x_offset;
    this.y_offset = y_offset;
    this.omega = omega;
    this.amplitude = amplitude;
  }

  @Override
  public float evaluateAt(float t) {
    return (float) Math.cos(omega * t - x_offset) + y_offset;
  }
  
  @Override
  public float getValue() {
    return (float) (amplitude * Math.cos(omega * cumulative - x_offset) + y_offset);
  }
}
