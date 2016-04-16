package Math;

public class Power extends Function{
  double power;
  public Power(double power) {
  }
  public Power(double x_offset, double y_offset, double power) {
    this(x_offset, y_offset, 1, 1, power);
  }
  public Power(double x_offset, double y_offset, double x_multiple, double y_multiple, double power) {
    this.x_offset = x_offset;
    this.y_offset = y_offset;
    this.x_multiple = x_multiple;
    this.y_multiple = y_multiple;
    this.power = power;
    this.name = "Power";
  }
  public Power(Function fun) {
    this.fun = fun;
  }
  @Override
  public double evaluateDefaultAt(double t) {
    return Math.pow(t,power);
  }
  @Override
  public double evaluateDerivativeAt(double t) {
    return y_multiple*power*Math.pow(x_multiple*t-x_offset, power-1)*x_multiple;
  }
}
