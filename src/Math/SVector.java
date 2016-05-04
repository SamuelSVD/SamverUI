package Math;

public class SVector {
  double x, y;
  public SVector(double x, double y) {
    this.x = x;
    this.y = y;
  }
  public void rotate(double angle) {
    double current_angle = Math.atan2(y, x);
    double magnitude = getMagnitude();
    angle += current_angle;
    this.x = magnitude * Math.cos(angle);
    this.y = magnitude * Math.sin(angle);
  }
  public String toString() {
    return String.format("[%f,%f]", x, y);
  }
  public double getMagnitude() {
    return Math.sqrt(x*x+y*y);
  }
  public SVector copy() {
    return new SVector(this.x, this.y);
  }
  public void normalize() {
    double magnitude = getMagnitude();
    this.x = this.x/magnitude;
    this.y = this.y/magnitude;
  }
}
