package Math;

public class Exponential extends Function{
  double base = 1;
  public Exponential() {
  }
  public Exponential(double base) {
    this.base = base;
  }
  public Exponential(double x_offset, double y_offset) {
    this(x_offset, y_offset, 1);
  }
  public Exponential(double x_offset, double y_offset, double base) {
    this(x_offset, y_offset, 1, 1);
    this.base = base;
  }
  public Exponential(double x_offset, double y_offset, double x_multiple, double y_multiple) {
    this.x_offset = x_offset;
    this.y_offset = y_offset;
    this.x_multiple = x_multiple;
    this.y_multiple = y_multiple;
  }
  @Override
  public double evaluateDefaultAt(double t) {
    return Math.pow(base, t);
  }
  public void setBase(double base) {
    this.base = base;
  }
}
