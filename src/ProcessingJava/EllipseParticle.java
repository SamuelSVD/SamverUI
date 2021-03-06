/* offset - starting position. f(time + offset)
 * theta - starting angle around circle.
 * alpha - speed of changing theta
 * 
 */

package ProcessingJava;
import Math.*;
import processing.core.*;

public class EllipseParticle extends VisualContainer {
  float alpha;
  float rotation;
  public EllipseParticle(PVector colour, float offset, float speed, float starting_angle, float alpha, float a, float b, PVector position){
    super(position, colour);
    this.rotation = starting_angle;
    this.alpha = alpha;
    setPositionFun(0, new Ellipse_X(offset,position.x,speed,1,a,b,rotation));
    setPositionFun(1, new Ellipse_Y(offset,position.y,speed,1,a,b,rotation));
  }
  public void update(float d) {
    if (alpha != 0) {
      rotation = rotation + alpha * d;
      ((Ellipse_X)position_fun[0]).setTheta(rotation);
      ((Ellipse_Y)position_fun[1]).setTheta(rotation);
    }
    super.update(d);
  }
  public void draw(){
    super.draw();
  }
}
