package sketches;
import java.util.ArrayList;

import Math.*;
import processing.core.PVector;
import ProcessingJava.*;
import SystemUtils.SystemUtils;

public class MathUtilsTest extends Sketch{
  public MathUtilsTest(PVector size) {
    super(size);
  }
  public MathUtilsTest(PVector position, PVector size) {
    super(position, size);
  }
  public static void main(String[] args) {
    double x0 = 0.1;
    double x1 = 0.2;
    double y0 = 1000;
    double y1 = 20;
    double v0 = 10000;
    Power f = (Power)MathUtils.makeParabola(x0, y0, x1, y1, v0);
    System.out.println(f.name);
    System.out.printf("f(%f) = %f\n", x0, f.evaluateAt(x0));
    System.out.printf("f(%f) = %f\n", x1, f.evaluateAt(x1));
    System.out.println(f);
    
    f = (Power)MathUtils.makeParabola(1, 1000, 2, 5, 30);
    System.out.println(f.name);
    System.out.printf("f(%f) = %f\n", 0.0, f.evaluateAt(0));
    System.out.printf("f(%f) = %f\n", 1.0, f.evaluateAt(1));
    System.out.printf("f(%f) = %f\n", 2.0, f.evaluateAt(2));
    System.out.printf("df(%f) = %f\n", 0.0, f.evaluateDerivativeAt(0));
    System.out.printf("df(%f) = %f\n", 1.0, f.evaluateDerivativeAt(1));
    System.out.printf("df(%f) = %f\n", 2.0, f.evaluateDerivativeAt(2));
    System.out.println(f);
    
  }

  @Override
  public void setup() {
    record = true;
    frame_limit = 17*16;
    setSpeed(0.033f);
    Background back = new Background(new PVector());
    addVisualComponent(back);
    ArrayList<ArrayList<Double>> lists = new ArrayList<ArrayList<Double>>();
    for (int j = 0; j < 51; j++) {
      ArrayList<Double> a = new ArrayList<Double>();
      lists.add(a);
      for (int i = 0; i < 16; i++) {
        double total = (double)random(size.x);
        int count = 1;
        for(int k = j-1; k >= 0; k--) {
          if (count == 1) break;
          total += lists.get(k).get(i);
          count++;
        }
        a.add(total/count);
      }
      a.add(a.get(0));
      PVector position = new PVector(j*10,0);
      PVector colour = new PVector(random(255),random(255),random(255));
      TransitionBar b = new TransitionBar(position, colour, a,17,10);
      b.setRorationAfterTranslate(PI/2);
      addVisualComponent(b);
    }
  }
}
