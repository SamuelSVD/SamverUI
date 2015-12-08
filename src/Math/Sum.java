package Math;
import java.util.ArrayList;
public class Sum extends Function{
  ArrayList<Function> functions = new ArrayList<Function>();
  public Sum() {
    name = "Sum";
  }
  @Override
  public double evaluateDefaultAt(double t) {
    double sum = 0;
    for (int i = 0; i < functions.size(); i++) {
      sum += functions.get(i).evaluateAt(t);
    }
    return sum;
  }
  public void appendFunction(Function f) {
    functions.add(f);
  }
  public void update(float d) {
//    System.out.println("Update Sum");
    for (int i = 0; i < functions.size(); i++) {
      if (functions.get(i).name.equals("Sum")) ((Sum)functions.get(i)).update(d);
      else if (functions.get(i).name.equals("Product")) ((Product)functions.get(i)).update(d);
      else functions.get(i).update(d);
    }
  }
}
