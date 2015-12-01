/*
 * offset - starting position. f(time + offset)
 * theta - starting angle around circle.
 * alpha - speed of changing theta
 * 
 */

package ProcessingJava;
import processing.core.*;
public class EllipseParticle extends VisualContainer {
  float  offset, speed_multiplier, theta, alpha, ellipse_width, ellipse_height, X, Y, x, y;
  float x_x,x_y,y_x,y_y;
  float rad;
  public EllipseParticle(PVector colour, float offset, float speed_multiplier, float theta, float alpha, float ellipse_width, float ellipse_height, PVector position, float rad){
    super(position, colour);
    this.rad = rad;
    this.offset = offset;
    this.speed_multiplier = speed_multiplier;
    this.theta = theta;
    this.alpha = alpha;
    this.ellipse_width = ellipse_width;
    this.ellipse_height = ellipse_height;
    x_x = cos(theta);
    x_y = sin(theta);
    y_x = cos(theta+PI/2);
    y_y = sin(theta+PI/2);
  }
  public void update(float d) {
    super.update(d);
    float r = x*x+y*y;
    if (r == 0){
      r = 1;
    }
    r = sqrt(r);
    offset += d*speed_multiplier;
    if (alpha != 0){
      theta = theta + alpha * d;
      theta = theta % (2*PI);
      x_x = cos(theta);
      x_y = sin(theta);
      y_x = cos(theta+PI/2);
      y_y = sin(theta+PI/2);
    }
  }
  public void draw(){
    x = ellipse_width*cos(offset)*cos(theta)-ellipse_height*sin(offset)*sin(theta);
    y = ellipse_width*cos(offset)*sin(theta)+ellipse_height*sin(offset)*cos(theta);
    visual_component_position.x = x*x_x + y*y_x;
    visual_component_position.y = x*x_y + y*y_y;
    super.draw();
  }

}
