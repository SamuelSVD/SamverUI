package Math;

abstract public class Function {
  Function fun;
  String name = "Function";
  public double cumulative = 0;
  double x_offset = 0;
  double x_multiple = 1;
  double y_offset = 0;
  double y_multiple = 1;
  public Function() {
  }
  public Function(double omega) {
    this(0, 0, omega);
  }
  public Function(double x_offset, double y_offset) {
    this(x_offset, y_offset, 1);
  }
  public Function(double x_offset, double y_offset, double omega) {
    this(x_offset, y_offset, omega, 1);
  }
  public Function(double x_offset, double y_offset, double x_multiple, double y_multiple) {
    this.x_offset = x_offset;
    this.y_offset = y_offset;
    this.x_multiple = x_multiple;
    this.y_multiple = y_multiple;
  }
  public void update(double d) {
    this.cumulative += d;
    if (fun != null) {
      fun.update(d);
    }
  }
  //Prototype. Not too sure if this will work
  public double evaluateAt(Function f) {
    return evaluateAt(f.evaluateAt(cumulative));
  }
  public double evaluateAt(double t) {
    return y_multiple * evaluateDefaultAt(x_multiple * t - x_offset) + y_offset;
  }
  public double getValue() {
    return evaluateAt(cumulative);
  }
  public String toString() {
    return String.format("%s:[%f,%f,%f,%f]", name, x_offset, y_offset, x_multiple, y_multiple);
  }
  public abstract double evaluateDefaultAt(double t);
}
