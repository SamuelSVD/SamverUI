//http://tutorial.math.lamar.edu/Classes/CalcIII/SphericalCoords.aspx
package ProcessingJava;

public class Camera {
  double camera_x, camera_y, camera_z, camera_x2, camera_y2, camera_z2;
  double angle1, angle2= Math.PI/2, radius = 100;
  double upX, upY, upZ;
  public double angle_accuracy = 0.01;
  public double position_accuracy = 10;
  camera_mode cm;
  Sketch sketch;
  public Camera(camera_mode cm, Sketch sketch) {
    this.cm = cm;
    this.sketch = sketch;
    camera_x = camera_x2 + radius * Math.sin(angle1) * Math.cos(angle2);
    camera_y = camera_y2 + radius * Math.sin(angle1) * Math.sin(angle2);
    camera_z = camera_z2 + radius * Math.cos(angle1);
  }
  public void keyPressed(char key) {
    System.out.print(key + ":");
    System.out.println((int)key);
    if (cm == camera_mode.rectangle) {
      switch(key) {
        case 'q': case 'Q':
          camera_x += position_accuracy;
          break;
        case 'a': case 'A':
          camera_x -= position_accuracy;
          break;
        case 'w': case 'W':
          camera_y += position_accuracy;
          break;
        case 's': case 'S':
          camera_y -= position_accuracy;
          break;
        case 'e': case 'E':
          camera_z += position_accuracy;
          break;
        case 'd': case 'D':
          camera_z -= position_accuracy;
          break;
        case '7':
          camera_x2 += position_accuracy;
          break;
        case '4':
          camera_x2 -= position_accuracy;
          break;
        case '8':
          camera_y2 += position_accuracy;
          break;
        case '5':
          camera_y2 -= position_accuracy;
          break;
        case '9':
          camera_z2 += position_accuracy;
          break;
        case '6':
          camera_z2 -= position_accuracy;
          break;
      }
      System.out.printf("%f %f %f : %f %f %f\n", camera_x, camera_y, camera_z, camera_x2, camera_y2, camera_z2);
    }
    else if (cm == camera_mode.radial) {
      switch (key) {
        case 'q': case 'Q':
          angle1 += angle_accuracy;
          break;
        case 'a': case 'A':
          angle1 -= angle_accuracy;
          break;
        case 'w': case 'W':
          angle2 += angle_accuracy;
          break;
        case 's': case 'S':
          angle2 -= angle_accuracy;
          break;
        case 'e': case 'E':
          radius += position_accuracy;
          break;
        case 'd': case 'D':
          radius -= position_accuracy;
          break;
        case '7':
          camera_x2 += position_accuracy;
          break;
        case '4':
          camera_x2 -= position_accuracy;
          break;
        case '8':
          camera_y2 += position_accuracy;
          break;
        case '5':
          camera_y2 -= position_accuracy;
          break;
        case '9':
          camera_z2 += position_accuracy;
          break;
        case '6':
          camera_z2 -= position_accuracy;
          break;
      }
      calculateCameraPosition();
      System.out.printf("%f %f %f : %f %f %f\n", camera_x2, camera_y2, camera_z2, angle1, angle2, radius);
    }
    switch( key) {
      case '1':
        upX += 1;
        upX += 0.1;
        upX = upX %2.1;
        upX = upX - 1;
        break;
      case '2':
        upY += 1;
        upY += 0.1;
        upY = upY %2.1;
        upY = upY - 1;
        break;
      case '3':
        upZ += 1;
        upZ += 0.1;
        upZ = upZ %2.1;
        upZ = upZ - 1;
        break;
    }
    updateUpZ();
    System.out.printf("%f %f %f\n", upX, upY, upZ);
  }
  public void use() {
    sketch.camera((float)camera_x, (float)camera_y, (float)camera_z, (float)camera_x2, (float)camera_y2, (float)camera_z2, (float)upX, (float)upY, (float)upZ);
  }
  public void setTarget(double x, double y, double z) {
    this.camera_x2 = x;
    this.camera_y2 = y;
    this.camera_z2 = z;
    calculateAngles();
    updateUpZ();
  }
  public void setLocation(double x, double y, double z) {
    this.camera_x = x;
    this.camera_y = y;
    this.camera_z = z;
    calculateAngles();
    updateUpZ();
  }
  public void setRadius(double rad) {
    radius = rad;
    calculateCameraPosition();
  }
  public void setAngles(double angle1, double angle2) {
    this.angle1 = angle1;
    this.angle2 = angle2;
    calculateCameraPosition();
    updateUpZ();
  }
  private void updateUpZ() {
    while(angle1 > Math.PI) angle1 -= 2*Math.PI;
    while(angle1 < -Math.PI) angle1 += 2*Math.PI;
    
    System.out.print(angle1);
    System.out.print(":");
    System.out.println(angle1 % (2*Math.PI));
    if (angle1 < 0) upZ = 1;
    else upZ = -1;
  }
  private void calculateAngles() {
    double dx = camera_x - camera_x2;
    double dy = camera_y - camera_y2;
    double dz = camera_z - camera_z2;
    radius = Math.sqrt(dx*dx+dy*dy+dz*dz);
    if (radius == 0) return;
    angle1 = Math.acos(dz/radius);
    angle2 = Math.atan2(dy/radius/Math.sin(angle1),dx/radius/Math.sin(angle1));
  }
  private void calculateCameraPosition() {
    camera_x = camera_x2 + radius * Math.sin(angle1) * Math.cos(angle2);
    camera_y = camera_y2 + radius * Math.sin(angle1) * Math.sin(angle2);
    camera_z = camera_z2 + radius * Math.cos(angle1);
  }
  public void init() {
    updateUpZ();
  }
  public String toString() {
   return String.format("%f %f %f : %f %f %f : %f %f %f : %f %f %f\n",camera_x, camera_y, camera_z, camera_x2, camera_y2, camera_z2, angle1, angle2, radius, upX, upY, upZ);
  }
}
