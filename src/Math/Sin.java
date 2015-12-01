package Math;

public class Sin extends Function{
  private float omega = 1;
  private float amplitude = 1;
  public Sin() {
  }
  public Sin(float x_offset, float y_offset) {
    super(x_offset, y_offset);
  }
  public Sin(float x_offset, float y_offset, float omega) {
    this.x_offset = x_offset;
    this.y_offset = y_offset;
    this.omega = omega;
  }
  public Sin(float x_offset, float y_offset, float omega, float amplitude) {
    this.x_offset = x_offset;
    this.y_offset = y_offset;
    this.omega = omega;
    this.amplitude = amplitude;
  }
  
  @Override
  public float evaluateAt(float t) {
    return (float) Math.sin(omega * t - x_offset) + y_offset;
  }
  
  @Override
  public float getValue() {
    return (float) (amplitude * Math.sin(omega * cumulative - x_offset) + y_offset);
  }
}
