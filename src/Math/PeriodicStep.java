package Math;

public class PeriodicStep extends Step {
  protected double period_low = 1;
  protected double period_high = 1;
  public PeriodicStep() {
    this(0);
  }
  public PeriodicStep(double x_offset) {
    this(x_offset, 0, 1, 1);
  }
  public PeriodicStep(double x_offset, double y_offset) {
    this(x_offset, y_offset, 1);
  }
  public PeriodicStep(double x_offset, double y_offset, double x_multiple) {
    this(x_offset, y_offset, x_multiple, 1);
  }
  public PeriodicStep(double x_offset, double y_offset, double x_multiple, double y_multiple) {
    this.x_offset = x_offset;
    this.y_offset = y_offset;
    this.x_multiple = x_multiple;
    this.y_multiple = y_multiple;
    name = "PeriodicStep";
  }
  @Override
  public double evaluateDefaultAt(double t) {
    if (t < 0) return 0;
    double v = t%(period_low+period_high);
    if (! is_slewed) {
        if (v > period_high) {
          return 0;
        }
        return 1;
    }
    if (v > period_high) {
      v = v-period_high;
      v = 1-v*slew;
      if (v < 0) return 0;
      return v;
    }
    v = v*slew;
    if (v > 1) return 1;
    return v;
  }
  public double getPeriod_low() {
    return period_low;
  }
  public void setPeriod_low(double period_low) {
    this.period_low = period_low;
  }
  public double getPeriod_high() {
    return period_high;
  }
  public void setPeriod_high(double period_high) {
    this.period_high = period_high;
  }
  public void setPeriods(double period_low, double period_high) {
    this.period_low = period_low;
    this.period_high = period_high;
  }

}
