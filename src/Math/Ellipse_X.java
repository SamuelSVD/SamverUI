//Credit: http://www.uwgb.edu/dutchs/Geometry/HTMLCanvas/ObliqueEllipses5.HTM
//x' = a*cos(t)*cos(theta) - b*sin(t)*sin(theta) 
//y' = a*cos(t)*sin(theta) + b*sin(t)*cos(theta)
package Math;

public class Ellipse_X extends Function{
  double a, b, theta;
  public Ellipse_X(double a, double b) {
    this(a, b, 0);
  }
  public Ellipse_X(double a, double b, double theta) {
    this(0,0,1,1,a,b,theta);
  }
  public Ellipse_X(double x_offset, double y_offset, double x_multiple, double y_multiple, double a, double b, double theta) {
    super(x_offset,y_offset,x_multiple,y_multiple);
    this.a = a;
    this.b = b;
    this.theta = theta;
    name = "ellipse_X";
  }
  @Override
  public double evaluateDefaultAt(double t) {
    return a*Math.cos(t)*Math.cos(theta) - b*Math.sin(t)*Math.sin(theta);
  }
  public void setTheta(double theta) {
    this.theta = theta;
  }
  @Override
  public double evaluateDerivativeAt(double t) {
    return 0;
  }
}
