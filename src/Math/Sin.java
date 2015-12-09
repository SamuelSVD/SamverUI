package Math;

public class Sin extends Function{
  public Sin() {
    this(1);
  }
  public Sin(double omega) {
    this(0, 0, omega);
  }
  public Sin(double x_offset, double y_offset) {
    this(x_offset, y_offset, 1);
  }
  public Sin(double x_offset, double y_offset, double omega) {
    this(x_offset, y_offset, omega, 1);
  }
  public Sin(double x_offset, double y_offset, double omega, double amplitude) {
    super(x_offset, y_offset, omega, amplitude);
    name = "sin";
  }
  
  public double evaluateDefaultAt(double t) {
    return Math.sin(t);
  }
}
