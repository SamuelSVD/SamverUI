package Math;

public class Cos extends PeriodicFunction{
  public Cos() {
    this(1);
  }
  public Cos(double omega) {
    this(0, 0, omega);
  }
  public Cos(double x_offset, double y_offset) {
    this(x_offset, y_offset, 1);
  }
  public Cos(double x_offset, double y_offset, double omega) {
    this(x_offset, y_offset, omega, 1);
  }
  public Cos(double x_offset, double y_offset, double omega, double amplitude) {
    super(x_offset, y_offset, omega, amplitude);
    name = "cos";
  }

  public double evaluateDefaultAt(double t) {
    return Math.cos(t);
  }
  @Override
  public double evaluateDerivativeAt(double t) {
    return 0;
  }
}
