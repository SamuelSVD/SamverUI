package Math;

public class Impulse extends Function{
  public double ERROR = 0.01f;
  public Impulse() {
    this(1);
  }
  public Impulse(double y_multiple) {
    this(0, 0, y_multiple);
  }
  public Impulse(double x_offset, double y_offset) {
    this(x_offset, y_offset, 1);
  }
  public Impulse(double x_offset, double y_offset, double y_multiple) {
    this(x_offset, y_offset, 1, y_multiple);
  }
  public Impulse(double x_offset, double y_offset, double x_multiple, double y_multiple) {
    super(x_offset, y_offset, x_multiple, y_multiple);
    name = "Impulse";
  }
  @Override
  public double evaluateDefaultAt(double t) {
    if (Math.abs(t) < ERROR) return 1;
    return 0;
  }
}
