package Math;

import java.util.ArrayList;

public class LinearTransition extends Function{
  ArrayList<Function> f;
  double transition_period;
  public LinearTransition(ArrayList<Double> points, double transition_period) {
    f = new ArrayList<Function>();
    this.transition_period = transition_period;
//    System.out.println(SystemUtils.SystemUtils.ArrayListToString(points));
    for (int i = 1; i < points.size(); i++) {
//      System.out.printf("i:%d\n",i);
      double x0=(i != 0)?points.get(i-1):0;
      Function fun = MathUtils.makeLine(0, x0, transition_period, points.get(i));
      f.add(fun);
      System.out.println(f.size());
    }
    f.add(new Constant(points.get(points.size()-1)));
//    System.out.println(points.size());
//    System.out.println(f.size());
  }
  @Override
  public double evaluateDefaultAt(double t) {
    if (t < 0) return f.get(0).evaluateAt(0);
    int i = (int)(t / transition_period);
    t = t%transition_period;
    if (i > f.size()-1) i = f.size()-1;
//    System.out.printf("%d\t(%f):\t%f\t%f\n", i, t, f.get(i).evaluateAt(t),f.get(i).evaluateAt(transition_period));
    return f.get(i).evaluateAt(t);
  }
  
  @Override
  public double evaluateDerivativeAt(double t) {
    int i = (int)(t / transition_period);
    t = t/transition_period;
    if (i > f.size()-1) i = f.size()-1;
    return f.get(i).evaluateDerivativeAt(t);
  }
}
