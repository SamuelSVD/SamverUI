package Math;

public class Impulse extends Function{
  public float ERROR = 0.01f;
  @Override
  public float evaluateDefaultAt(float t) {
    if (Math.abs(t) < ERROR) return 1;
    return 0;
  }
}
