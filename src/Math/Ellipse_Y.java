package Math;
//x' = a*cos(t)*cos(theta) - b*sin(t)*sin(theta) 
//y' = a*cos(t)*sin(theta) + b*sin(t)*cos(theta)

public class Ellipse_Y extends Function{
  double a,b,theta;
  public Ellipse_Y(double a, double b) {
    this(a, b, 0);
  }
  public Ellipse_Y(double a, double b, double theta) {
    this(0,0,1,1,a,b,theta);
  }
  public Ellipse_Y(double x_offset, double y_offset, double x_multiple, double y_multiple, double a, double b, double theta) {
    super(x_offset,y_offset,x_multiple,y_multiple);
    this.a = a;
    this.b = b;
    this.theta = theta;
    name = "Ellipse_Y";
  }
  @Override
  public double evaluateDefaultAt(double t) {
    return a*Math.cos(t)*Math.sin(theta) + b*Math.sin(t)*Math.cos(theta);
  }
}
