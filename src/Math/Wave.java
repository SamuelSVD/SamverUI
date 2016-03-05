package Math;

public class Wave extends Function{
  Product prod;
  Sin sin;
  Constant constant;
  double length;
  double harmonic;
  
  public Wave(double length, int harmonic, double wave_speed) {
    this.length = length;
    this.harmonic = harmonic;
    double omega = 3.1415926535/length;
    prod = new Product();
    sin = new Sin(wave_speed);
    constant = new Constant(sin);
    prod.appendFunction(constant);
    prod.appendFunction(new Sin((1+harmonic)*omega));
    name = "Wave";
    fun = prod;
  }
  @Override
  public double evaluateDefaultAt(double t) {
//    System.out.print(t);
//    System.out.print(" ");
//    System.out.println(prod.evaluateAt(t));
    return prod.evaluateAt(t);
  }
  public void update(double d) {
    super.update(d);
    constant.update(d);
  }
  @Override
  public String getMathString() {
    String s = String.format("Wave(%f,%f)", length, harmonic);
    return s;
  }

}
