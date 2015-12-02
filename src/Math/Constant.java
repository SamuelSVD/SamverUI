package Math;

public class Constant extends Function{
  public Constant() {
  }
  public Constant(double value) {
    this(0,value);
  }
  public Constant(double x_offset, double y_offset) {
    this(x_offset, y_offset, 1, 1);
  }
  public Constant(double x_offset, double y_offset, double x_multiple, double y_multiple) {
    super(x_offset, y_offset, x_multiple, y_multiple);
    name = "Constant";
  }
  public Constant(Function fun) {
    this(0,0,1,1);
    this.fun = fun;
  }
  public double evaluateDefaultAt(double t) {
    if (fun != null) return fun.getValue();
    return 0;
  }
}
