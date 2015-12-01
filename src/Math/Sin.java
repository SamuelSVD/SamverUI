package Math;

public class Sin extends Function{
  public Sin() {
  }
  public Sin(float omega) {
    this(0, 0, omega);
  }
  public Sin(float x_offset, float y_offset) {
    this(x_offset, y_offset, 1);
  }
  public Sin(float x_offset, float y_offset, float omega) {
    this(x_offset, y_offset, omega, 1);
  }
  public Sin(float x_offset, float y_offset, float omega, float amplitude) {
    this.x_offset = x_offset;
    this.y_offset = y_offset;
    this.x_multiple = omega;
    this.y_multiple = amplitude;
  }
  
  public float evaluateDefaultAt(float t) {
    return (float) Math.sin(t);
  }
}
