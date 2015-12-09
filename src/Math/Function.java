package Math;

abstract public class Function {
  Function fun;
  String name = "Function";
  public double cumulative = 0;
  protected double x_offset = 0;
  protected double x_multiple = 1;
  protected double y_offset = 0;
  protected double y_multiple = 1;
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
  public Function(Function fun) {
    this.fun = fun;
  }
  public void update(double d) {
//    String s = String.format("%s:%f", name, d);
//    System.out.println(s);
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
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public double getX_offset() {
    return x_offset;
  }
  public void setX_offset(double x_offset) {
    this.x_offset = x_offset;
  }
  public double getX_multiple() {
    return x_multiple;
  }
  public void setX_multiple(double x_multiple) {
    this.x_multiple = x_multiple;
  }
  public double getY_offset() {
    return y_offset;
  }
  public void setY_offset(double y_offset) {
    this.y_offset = y_offset;
  }
  public double getY_multiple() {
    return y_multiple;
  }
  public void setY_multiple(double y_multiple) {
    this.y_multiple = y_multiple;
  }
  public abstract double evaluateDefaultAt(double t);
  public String getMathString() {
    String s;
    if (fun != null) s = String.format("%f*%s(%f*(%s)-%f)+%f",y_multiple ,name , x_multiple , fun.getMathString(), x_offset, y_offset);
    else  s = String.format("%f*%s(%f*t-%f)+%f",y_multiple ,name , x_multiple , x_offset, y_offset);
    return s;
  }
}
