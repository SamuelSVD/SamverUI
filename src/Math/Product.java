package Math;

import java.util.ArrayList;

public class Product extends Function{
  ArrayList<Function> functions = new ArrayList<Function>();
  public Product() {
    name = "Product";
  }
  @Override
  public double evaluateDefaultAt(double t) {
    double product = 1;
    for (int i = 0; i < functions.size(); i++) {
      product *= functions.get(i).evaluateAt(t);
    }
    return product;
  }
  public void appendFunction(Function f) {
//    System.out.println("Adding function:" + f.toString());
    functions.add(f);
  }
  public void update(float d) {
    //System.out.println("Update Product");
    for (int i = 0; i < functions.size(); i++) {
      if (functions.get(i).name.equals("Sum")) ((Sum)functions.get(i)).update(d);
      else if (functions.get(i).name.equals("Product")) ((Product)functions.get(i)).update(d);
      else functions.get(i).update(d);
    }
  }
  @Override
  public String getMathString() {
    String s = "PRODUCT(";
    for (int i = 0; i < functions.size(); i++) {
      s += "(" + functions.get(i).getMathString() + ")";
      if (i != functions.size()-1) {
        s += "*";
      }
    }
    s += ")";
    return s;
  }
}
