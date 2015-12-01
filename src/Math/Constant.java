package Math;

public class Constant extends Function{
  public Constant(float value) {
    y_offset = value;
  }
  
  public float evaluateDefaultAt(float t) {
    return 0;
  }
  
  public float getValue() {
    return y_offset;
  }
}
