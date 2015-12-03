/* offset - starting position. f(time + offset)
 * theta - starting angle around circle.
 * alpha - speed of changing theta
 * 
 */

package ProcessingJava;
import processing.core.*;
import Math.*;

public class EllipseParticle extends VisualContainer {
  float  alpha;
  public EllipseParticle(PVector colour, float offset, float speed, float rotation, float alpha, float a, float b, PVector position, float rad){
    super(position, colour);
    this.rotation = rotation;
    this.alpha = alpha;
    
    visual_component_position_fun[0] = new Ellipse_X(offset,0,speed,1,a,b,rotation);
    visual_component_position_fun[1] = new Ellipse_Y(offset,0,speed,1,a,b,rotation);
  }
  public void update(float d) {
    if (alpha != 0){
      rotation = rotation + alpha * d;
      rotation = rotation % (2*PI);
      ((Ellipse_X)visual_component_position_fun[0]).setTheta(rotation);
      ((Ellipse_Y)visual_component_position_fun[1]).setTheta(rotation);
    }
    super.update(d);
  }
  public void draw(){
    super.draw();
  }

}
