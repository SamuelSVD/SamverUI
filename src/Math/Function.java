package Math;

abstract public class Function {
  float cumulative = 0;
  float x_offset = 0;
  float y_offset = 0;
  public Function() {
  }
  public Function(float x_offset, float y_offset) {
    this.x_offset = x_offset;
    this.y_offset = y_offset;
  }
  public void update(float d) {
    this.cumulative += d;
  }
  //Prototype. Not too sure if this will work
  public float evaluateAt(Function f) {
    return evaluateAt(f.evaluateAt(cumulative));
  }
  public abstract float evaluateAt(float t);
  public abstract float getValue();
}
