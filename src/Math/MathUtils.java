package Math;

public class MathUtils {
  public static Function makeLine(double x0, double y0, double x1, double y1) {
    double dy = y1-y0;
    double dx = x1-x0;
    double m = dy/dx;
    return new Line(x0,y0,1,m);
  }
  public static Function makeParabola(double x0, double y0, double x1, double y1, double v0) {
    double dy = y1-y0;
    double dx = x1-x0;
    double a = (dy/dx - v0) / dx ;
    if (Math.abs(a) < 0.01) {
      double m = (y1-y0)/(x1-x0);
      double b = y0- m*x0;
      return new Line(0,b,1,m);
    }
    //f(x) = ax^2+ v0x + y0;
    //f(x) = a(x + (b/2a)) + (c - b*b/4/a);
    //b = v0;
    //c = y0;
//    System.out.printf("a = %f b = %f c = %f\n", a, v0, y0);
    Power fun = new Power(-v0/2/a+x0,y0-v0*v0/4/a,1,a,2);
    return fun;
  }
  public static Function makeExponential(double x0, double y0, double x1, double y1) {
    double y_multiple = (y1-y0)/Math.pow(Math.E, (x1-x0));
    Exponential fun = new Exponential(0,y0,1,y_multiple,Math.E);
    return fun;
  }
}
