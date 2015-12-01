package Math;

public class Constant extends Function{
  public Constant(float value) {
    y_offset = value;
  }
  
  public float evaluateAt(float t) {
    return y_offset;
  }
  
  public float getValue() {
    return y_offset;
  }
}
