package Math;

public class Step extends Function{
  protected double slew = 0;
  protected boolean is_slewed = false;
  public Step() {
    this(0);
  }
  public Step(double x_offset) {
    this(x_offset, 0, 1, 1);
  }
  public Step(double x_offset, double y_offset) {
    this(x_offset, y_offset, 1);
  }
  public Step(double x_offset, double y_offset, double x_multiple) {
    this(x_offset, y_offset, x_multiple, 1);
  }
  public Step(double x_offset, double y_offset, double x_multiple, double y_multiple) {
    this.x_offset = x_offset;
    this.y_offset = y_offset;
    this.x_multiple = x_multiple;
    this.y_multiple = y_multiple;
    name = "Step";
  }
  public Step(Function fun) {
    this.fun = fun;
    name = "Step";
  }
  public void setSlew(double slew) {
    this.slew = Math.abs(slew);
    this.is_slewed = true;
  }
  public void removeSlew() {
    this.is_slewed = false;
  }
  @Override
  public double evaluateDefaultAt(double t) {
    if (t < 0) return 0;
    if (! is_slewed && t > 0) {
        return 1;
    }
    double v = t * slew;
    if (v > 1) return 1;
    return v;
  }
}
