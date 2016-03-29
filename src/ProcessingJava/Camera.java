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
  
  private boolean tilt_up, tilt_down, turn_cw, turn_ccw, move_left, move_forward, move_right, move_backward = false;
  
  public Camera(camera_mode cm) {
    this.cm = cm;
  }
  public void activateControl() {
    camera_control = true;
  }
  public void deactivateControl() {
    camera_control = false;
  }
  public boolean hasControl() {
    return camera_control;
  }
  private void setKeyValue(char key, int keyCode, boolean value) {
    if (!camera_control) return;
    if (DEBUG) {
      System.out.print(key + ":");
      System.out.println((int)key);
    }
    System.out.printf("Coded: %d %d\n", (int)key, PConstants.CODED);
    if (key == PConstants.CODED) {
      if (keyCode == PConstants.UP) {
        tilt_up = value;
      }
      if (keyCode == PConstants.DOWN) {
        tilt_down = value;
      }
      if (keyCode == PConstants.LEFT) {
        turn_cw = value;
      }
      if (keyCode == PConstants.RIGHT) {
        turn_ccw = value;
      }
    }
    
    else switch(key) {
      case 'q': case 'Q':
        break;
      case 'a': case 'A':
        move_left = value;
        break;
      case 'w': case 'W':
        move_forward = value;
        break;
      case 's': case 'S':
        move_backward = value;
        break;
      case 'e': case 'E':
        break;
      case 'd': case 'D':
        move_right = value;
        break;
    }
    if (DEBUG) System.out.printf("K: %f %f %f : %f %f %f\n", target.x, target.y, target.z, angle1, angle2, radius);
    calculateCameraPosition();
    calculateDelta();
    updateUpZ();
  }
  public void keyPressed(char key, int keyCode) {
    setKeyValue(key, keyCode, true);
  }
  public void keyReleased(char key, int keyCode) {
    setKeyValue(key, keyCode, false);
  }
  public void use() {
    if (sketch != null) {
      if (this.cm == camera_mode.third_person) sketch.camera((float)camera.x, (float)camera.y, (float)camera.z, (float)target.x, (float)target.y, (float)target.z, (float)upX, (float)upY, (float)upZ);
      if (this.cm == camera_mode.first_person) sketch.camera((float)target.x, (float)target.y, (float)target.z, (float)camera.x, (float)camera.y, (float)camera.z, (float)upX, (float)upY, (float)upZ);
    }
  }
  public void use(float delta) {
    if (sketch != null) {
      if (tilt_up) tiltUp(delta);
      if (tilt_down) tiltDown(delta);
      if (turn_cw) turnCW(delta);
      if (turn_ccw) turnCCW(delta);
      if (move_left) moveLeft(delta);
      if (move_forward) moveForward(delta);
      if (move_backward) moveBackward(delta);
      if (move_right) moveRight(delta);
      if (this.cm == camera_mode.third_person) sketch.camera((float)camera.x, (float)camera.y, (float)camera.z, (float)target.x, (float)target.y, (float)target.z, (float)upX, (float)upY, (float)upZ);
      if (this.cm == camera_mode.first_person) sketch.camera((float)target.x, (float)target.y, (float)target.z, (float)camera.x, (float)camera.y, (float)camera.z, (float)upX, (float)upY, (float)upZ);
    }
  }
  public void setTarget(float x, float y, float z) {
    if (cm == camera_mode.first_person) {
      camera.x = x;
      camera.y = y;
      camera.z = z;
    }
    else {
      target.x = x;
      target.y = y;
      target.z = z;
    }
    calculateAngles();
    calculateDelta();
    updateUpZ();
  }
  public PVector getTarget() {
    return new PVector(target.x, target.y, target.z);
  }
  public void setLocation(float x, float y, float z) {
    if (cm == camera_mode.first_person) {
      target.x = x;
      target.y = y;
      target.z = z;
    }
    else {
      camera.x = x;
      camera.y = y;
      camera.z = z;
    }
    calculateAngles();
    calculateDelta();
    updateUpZ();
  }
  public PVector getLocation() {
    return new PVector(camera.x, camera.y, camera.z);
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
  public void tiltUp(float delta) {
    moveAngle(PConstants.UP, delta);
  }
  public void tiltDown(float delta) {
    moveAngle(PConstants.DOWN, delta);
  }
  public void turnCW(float delta) {
    moveAngle(PConstants.LEFT, delta);
  }
  public void turnCCW(float delta) {
    moveAngle(PConstants.RIGHT, delta);
  }
  public void moveForward(float delta) {
    moveDirection(PConstants.ADD, delta);
  }
  public void moveBackward(float delta) {
    moveDirection(PConstants.SUBTRACT, delta);
  }
  public void moveUp(float delta) {
    moveDirection(PConstants.UP, delta);
  }
  public void moveDown(float delta) {
    moveDirection(PConstants.DOWN, delta);
  }
  public void moveLeft(float delta) {
    moveDirection(PConstants.LEFT, delta);
  }
  public void moveRight(float delta) {
    moveDirection(PConstants.RIGHT, delta);
  }
  protected void moveDirection(int direction, float delta) {
    PVector p = new PVector(this.delta.x, this.delta.y, this.delta.z);
    if (cm == camera_mode.first_person) p.mult(-1);
    switch(direction){
    case PConstants.UP:
      break;
    case PConstants.DOWN:
      break;
    case PConstants.LEFT:
      p = new PVector(p.x, p.y);
      p.rotate((float)Math.PI/2);
      p.mult(-(float)position_accuracy*delta);
      break;
    case PConstants.RIGHT:
      p = new PVector(p.x, p.y);
      p.rotate((float)Math.PI/2);
      p.mult((float)position_accuracy*delta);
      break;
    case PConstants.ADD: //move forward
      p.mult((float)position_accuracy*delta);
      break;
    case PConstants.SUBTRACT: //move backward
      p.mult((float)-position_accuracy*delta);
      break;
    }
    camera.add(p);
    target.add(p);
  }
  protected void moveAngle(int direction, float delta) {
    System.out.println("MOVE");
    System.out.println(direction);
    switch(direction){
    case PConstants.UP:
      if (cm == camera_mode.first_person) angle1 -= angle_accuracy*delta;
      else angle1 += angle_accuracy*delta;
      break;
    case PConstants.DOWN:
      if (cm == camera_mode.first_person) angle1 += angle_accuracy*delta;
      else angle1 -= angle_accuracy*delta;
      break;
    case PConstants.LEFT:
      if (cm == camera_mode.first_person) angle2 -= angle_accuracy*delta;
      else angle2 += angle_accuracy*delta;
      break;
    case PConstants.RIGHT:
      if (cm == camera_mode.first_person) angle2 += angle_accuracy*delta;
      else angle2 -= angle_accuracy*delta;
      break;
    }
    if (angle1 > Math.PI) angle1 = Math.PI;
    if (angle1 < 0) angle1 = 0;
    calculateCameraPosition();
    updateUpZ();
  }
  public void shift(PVector p) {
    camera.add(p);
    target.add(p);
  }
  public void mouseDragged() {
    if (!camera_control) return;
    float pi = 400;
    float dx = sketch.mouseX-sketch.pmouseX;
    float dy = sketch.mouseY-sketch.pmouseY;
    
    if (cm == camera_mode.first_person) angle1 += Math.PI*dy/pi;
    else angle1 -= Math.PI*dy/pi;
    
    if (cm == camera_mode.first_person) angle2 -= Math.PI*dx/pi;
    else angle2 += Math.PI*dx/pi;
    
    if (angle1 > Math.PI) angle1 = Math.PI;
    if (angle1 < 0) angle1 = 0;
    calculateCameraPosition();
    updateUpZ();
  }
  public void mouseWheel(processing.event.MouseEvent me) {
    int count = me.getCount();
    if (count < 0) zoomIn();
    else zoomOut();
  }
  public void zoomIn() {
    radius = radius-radius/10;
    calculateCameraPosition();
  }
  public void zoomOut() {
    radius = radius+radius/10;
    calculateCameraPosition();
  }
}
