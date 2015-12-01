package Math;

abstract public class Function {
  float cumulative = 0;
  float x_offset = 0;
  float y_offset = 0;
  public Function() {
  }
  public Function(float delay) {
    cumulative = -delay;
  }
  public Function(float x_offset, float y_offset) {
    this.x_offset = x_offset;
    this.y_offset = y_offset;
  }
  public Function(float x_offset, float y_offset, float delay) {
    this.x_offset = x_offset;
    this.y_offset = y_offset;
    this.cumulative = -delay;
  }
  public void update(float d) {
    this.cumulative += d;
  }
  public abstract float evaluateAt(float x, float y);
  public abstract float getValue();
}
