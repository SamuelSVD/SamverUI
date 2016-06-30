package Math;

abstract public class PeriodicFunction extends Function{
  public PeriodicFunction() {
  }
  public PeriodicFunction(double omega) {
    this(0, 0, omega);
  }
  public PeriodicFunction(double omega, double amplitude) {
    this(0, 0, omega, amplitude);
  }
  public PeriodicFunction(double angular_offset, double DC_offset, double omega) {
    this(angular_offset, DC_offset, omega, 1);
  }
  public PeriodicFunction(double angular_offset, double DC_offset, double omega, double amplitude) {
    this.x_offset = angular_offset;
    this.y_offset = DC_offset;
    this.x_multiple = omega;
    this.y_multiple = amplitude;
  }
  public double getAngularOffset() {
    return x_offset;
  }
  public void setAngularOffset(double angular_offset) {
    this.x_offset = angular_offset;
  }
  public double getOmega() {
    return x_multiple;
  }
  public void setOmega(double omega) {
    this.x_multiple = omega;
  }
  public double getDCOffset() {
    return y_offset;
  }
  public void setDCOffset(double DC_offset) {
    this.y_offset = DC_offset;
  }
  public double getAmplitude() {
    return y_multiple;
  }
  public void setAmplitude(double amplitude) {
    this.y_multiple = amplitude;
  }
  
}
