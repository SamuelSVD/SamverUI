package Math;

public class Line extends Function{
  public Line() {
  }
  public Line(double omega) {
    this(0, 0, omega);
  }
  public Line(double x_offset, double y_offset) {
    this(x_offset, y_offset, 1);
  }
  public Line(double x_offset, double y_offset, double omega) {
    this(x_offset, y_offset, omega, 1);
  }
  public Line(double x_offset, double y_offset, double x_multiple, double y_multiple) {
    this.x_offset = x_offset;
    this.y_offset = y_offset;
    this.x_multiple = x_multiple;
    this.y_multiple = y_multiple;
    this.name = "Line";
  }
  public Line(Line fun) {
    this.fun = fun;
  }
  @Override
  public double evaluateDefaultAt(double t) {
    return t;
  }
  @Override
  public double evaluateDerivativeAt(double t) {
    return x_multiple*y_multiple;
  }
}
