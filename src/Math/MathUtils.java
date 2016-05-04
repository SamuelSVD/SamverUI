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
  public static double[] getCircleCoeffs(double x0, double y0, double dx0, double dy0, double x1, double y1, double dx1, double dy1) {
    SVector d0 = new SVector(dx0, dy0);
    SVector d1 = new SVector(dx1, dy1);
    d0.normalize();
    System.out.println(d0);
    d1.normalize();
    System.out.println(d1);
    d0.rotate(Math.PI/2);
    System.out.println(d0);
    d1.rotate(Math.PI/2);
    System.out.println(d1);
    double t = (x0-x1)/(d1.x-d0.x);
    double a = x0+d0.x*t;
    double b = y0+d0.y*t;
    double r = Math.sqrt((x0-a)*(x0-a)+(y0-b)*(y0-b));
    System.out.print(a);
    System.out.print(',');
    System.out.print(b);
    System.out.print(',');
    System.out.println(r);
    double [] coeffs = {a, b, r};
    return coeffs;
  }
  public static Function getCirlceX(double x0, double y0, double dx0, double dy0, double x1, double y1, double dx1, double dy1) {
    double [] coeffs = getCircleCoeffs(x0,y0,dx0,dy0,x1,y1,dx1,dy1);
    return new Cos(0,coeffs[0],1,coeffs[2]);
  }
  public static Function getCirlceY(double x0, double y0, double dx0, double dy0, double x1, double y1, double dx1, double dy1) {
    double [] coeffs = getCircleCoeffs(x0,y0,dx0,dy0,x1,y1,dx1,dy1);
    return new Sin(0,coeffs[1],1,coeffs[2]);
  }
}
