package Math;

public class Wave extends Function{
  Product prod;
  double length;
  double harmonic;
  
  public Wave(double length, int harmonic) {
    this.length = length;
    this.harmonic = harmonic;
    double omega = 3.1415926535/length;
    prod = new Product();
    Sin sin = new Sin(10*omega*(harmonic+1));
    Constant c = new Constant(sin);
    prod.appendFunction(c);
    prod.appendFunction(new Sin((1+harmonic)*omega));
    name = "Wave";
  }
  @Override
  public double evaluateDefaultAt(double t) {
    System.out.print(t);
    System.out.print(" ");
    System.out.println(prod.evaluateAt(t));
    return prod.evaluateAt(t);
  }
  @Override
  public String getMathString() {
    String s = String.format("Wave(%f,%f)", length, harmonic);
    return s;
  }

}
