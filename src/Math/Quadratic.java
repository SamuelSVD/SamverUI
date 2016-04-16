package Math;

public class Quadratic extends Function{
  public Quadratic() {
  }
  public Quadratic(double x_offset, double y_offset) {
    this(x_offset, y_offset, 1);
  }
  //ax²+bx+c = a(x + b/2a)2 + c - b/4a
  public Quadratic(double a, double b, double c) {
    this(-b/2/a, c-(b*b)/(4*a), 1, a);
  }
  public Quadratic(double x_offset, double y_offset, double x_multiple, double y_multiple) {
    super(x_offset, y_offset, x_multiple, y_multiple);
    name = "Quadratic";
  }
  @Override
  public double evaluateDefaultAt(double t) {
    return t*t;
  }
  @Override
  public double evaluateDerivativeAt(double t) {
    return 0;
  }
}
