//http://tutorial.math.lamar.edu/Classes/CalcIII/SphericalCoords.aspx
package ProcessingJava;
import processing.core.*;

public class Camera {
//  private double camera.x, camera.y, camera.z, target.x, target.y, target.z;
  private double angle1, angle2= Math.PI/2, radius = 100;
  private PVector camera = new PVector();
  private PVector target = new PVector();
  private PVector delta = new PVector(1,0,0);
  double upX, upY, upZ;
  public double angle_accuracy = 0.01;
  public double position_accuracy = 10;
  public boolean DEBUG = false;
  private boolean camera_control = false;
  camera_mode cm;
  Sketch sketch;
  public Camera(camera_mode cm) {
    this.cm = cm;
  }
  public void activateControl() {
    camera_control = true;
  }
  public void deactivateControl() {
    camera_control = false;
  }
  public void keyPressed(char key, int keyCode) {
    if (!camera_control) return;
    if (DEBUG) {
      System.out.print(key + ":");
      System.out.println((int)key);
    }
    System.out.printf("Coded: %d %d", (int)key, PConstants.CODED);
    if (key == PConstants.CODED) {
      if (keyCode == PConstants.UP) {
        tiltUp();
      }
      if (keyCode == PConstants.DOWN) {
        tiltDown();
      }
      if (keyCode == PConstants.LEFT) {
        turnCW();
      }
      if (keyCode == PConstants.RIGHT) {
        turnCCW();
      }
    }
    
    else switch(key) {
      case 'q': case 'Q':
        break;
      case 'a': case 'A':
        moveLeft();
        break;
      case 'w': case 'W':
        moveForward();
        break;
      case 's': case 'S':
        moveBackward();
        break;
      case 'e': case 'E':
        break;
      case 'd': case 'D':
        moveRight();
        break;
      case '7':
        break;
      case '4':
        break;
      case '8':
        break;
      case '5':
        break;
      case '9':
        break;
      case '6':
        break;
    }
    if (DEBUG) System.out.printf("K: %f %f %f : %f %f %f\n", target.x, target.y, target.z, angle1, angle2, radius);
    
    calculateCameraPosition();
    calculateDelta();
    updateUpZ();
  }
  public void use() {
    if (sketch != null) {
      if (this.cm == camera_mode.third_person) sketch.camera((float)camera.x, (float)camera.y, (float)camera.z, (float)target.x, (float)target.y, (float)target.z, (float)upX, (float)upY, (float)upZ);
      if (this.cm == camera_mode.first_person) sketch.camera((float)target.x, (float)target.y, (float)target.z, (float)camera.x, (float)camera.y, (float)camera.z, (float)upX, (float)upY, (float)upZ);
    }
  }
  public void setTarget(float x, float y, float z) {
    this.target.x = x;
    this.target.y = y;
    this.target.z = z;
    calculateAngles();
    calculateDelta();
    updateUpZ();
  }
  public void setLocation(float x, float y, float z) {
    this.camera.x = x;
    this.camera.y = y;
    this.camera.z = z;
    calculateAngles();
    calculateDelta();
    updateUpZ();
  }
  public void setRadius(double rad) {
    radius = rad;
    calculateCameraPosition();
    calculateDelta();
    updateUpZ();
  }
  public void setAngles(double angle1, double angle2) {
    this.angle1 = angle1;
    this.angle2 = angle2;
    calculateCameraPosition();
    calculateDelta();
    updateUpZ();
  }
  private void updateUpZ() {
    while(angle1 > Math.PI) angle1 -= 2*Math.PI;
    while(angle1 < -Math.PI) angle1 += 2*Math.PI;
    if (DEBUG) {
      System.out.print(angle1);
      System.out.print(":");
      System.out.println(angle1 % (2*Math.PI));
    }
    if (Math.abs(angle1) < Math.PI/4-0.78539) {
      upX = Math.cos(angle2);
      upY = Math.sin(angle2);
      upZ = 0;
    }
    else if (Math.abs((angle1)-Math.PI) < Math.abs(Math.PI/4-0.78539)) {
      upX = -Math.cos(angle2);
      upY = -Math.sin(angle2);
      upZ = 0;
    }
    else if (angle1 < 0){
      upX = 0;
      upY = 0;
      upZ = 1;
    }
    else {
      upX = 0;
      upY = 0;
      upZ = -1;
    }
    if (DEBUG) System.out.printf("UP: %f %f %f\n", upX, upY, upZ);
  }
  private void calculateAngles() {
    double dx = camera.x - target.x;
    double dy = camera.y - target.y;
    double dz = camera.z - target.z;
    radius = Math.sqrt(dx*dx+dy*dy+dz*dz);
    if (radius == 0) return;
    angle1 = Math.acos(dz/radius);
    angle2 = Math.atan2(dy/radius/Math.sin(angle1),dx/radius/Math.sin(angle1));
  }
  private void calculateCameraPosition() {
    camera.x = (float)(target.x + radius * Math.sin(angle1) * Math.cos(angle2));
    camera.y = (float)(target.y + radius * Math.sin(angle1) * Math.sin(angle2));
    camera.z = (float)(target.z + radius * Math.cos(angle1));
  }
  private void calculateDelta() {
    PVector p = new PVector(camera.x,camera.y,camera.z);
    p.mult(-1);
    p.add(target);
    if (p.mag() > 0){
      delta = p;
      delta.normalize();
    }
  }
  public void init() {
    updateUpZ();
  }
  public String toString() {
   return String.format("%f %f %f : %f %f %f : %f %f %f : %f %f %f\n",camera.x, camera.y, camera.z, target.x, target.y, target.z, angle1, angle2, radius, upX, upY, upZ);
  }
  public double getAngle1() {
    return angle1;
  }
  public double getAngle2() {
    return angle2;
  }
  public void setSketch(Sketch s) {
    this.sketch = s;
  }
  public void tiltUp() {
    moveAngle(PConstants.UP);
  }
  public void tiltDown() {
    moveAngle(PConstants.DOWN);
  }
  public void turnCW() {
    moveAngle(PConstants.LEFT);
  }
  public void turnCCW() {
    moveAngle(PConstants.RIGHT);
  }
  public void moveForward() {
    moveDirection(PConstants.ADD);
  }
  public void moveBackward() {
    moveDirection(PConstants.SUBTRACT);
  }
  public void moveUp() {
    moveDirection(PConstants.UP);
  }
  public void moveDown() {
    moveDirection(PConstants.DOWN);
  }
  public void moveLeft() {
    moveDirection(PConstants.LEFT);
  }
  public void moveRight() {
    moveDirection(PConstants.RIGHT);
  }
  protected void moveDirection(int direction) {
    switch(direction){
    case PConstants.UP:
      break;
    case PConstants.DOWN:
      break;
    case PConstants.LEFT:
      break;
    case PConstants.RIGHT:
      break;
    case PConstants.ADD: //move forward
      PVector p = new PVector(delta.x, delta.y, delta.z);
      p.mult((float)position_accuracy);
      camera.add(p);
      target.add(p);
      break;
    case PConstants.SUBTRACT: //move backward
      p = new PVector(delta.x, delta.y, delta.z);
      p.mult((float)-position_accuracy);
      camera.add(p);
      target.add(p);
      break;
    }
  }
  protected void moveAngle(int direction) {
    System.out.println("MOVE");
    System.out.println(direction);
    switch(direction){
    case PConstants.UP:
      angle1 += angle_accuracy;
      if (angle1 > Math.PI) angle1 = Math.PI;
      break;
    case PConstants.DOWN:
      angle1 -= angle_accuracy;
      if (angle1 < 0) angle1 = 0;
      break;
    case PConstants.LEFT:
      angle2 += angle_accuracy;
      break;
    case PConstants.RIGHT:
      angle2 -= angle_accuracy;
      break;
    }
    calculateCameraPosition();
    updateUpZ();
  }
  public void shift(PVector p) {
    camera.add(p);
    target.add(p);
  }
}
