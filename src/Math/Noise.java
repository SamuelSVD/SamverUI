package Math;

public class Noise extends Function{
  public Noise() {
  }
  public Noise(double amplitude) {
    y_multiple=amplitude;
    name = "Noise";
  }
  @Override
  public double evaluateDefaultAt(double t) {
    return 2*(Math.random()-0.5);
  }

}
