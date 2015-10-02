package ProcessingJava;
import processing.core.*;
public class EllipseParticle extends VisualComponent {
  float  t, s, theta, alpha, a, b, X, Y, x, y;
  float x_x,x_y,y_x,y_y;
  float rad;
  public EllipseParticle(PVector c, float t, float s, float theta, float alpha, float a, float b, float x, float y){
    super(c);
    this.t = t;
    this.s = s;
    this.theta = theta;
    this.alpha = alpha;
    this.a = a;
    this.b = b;
    this.X = x;
    this.Y = y;
    x_x = cos(theta);
    x_y = sin(theta);
    y_x = cos(theta+PI/2);
    y_y = sin(theta+PI/2);
  }
  public void update(float d) {
    float r = x*x+y*y;
    if (r == 0){
      r = 1;
    }
    r = sqrt(r);
    t += d*s;
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
    x = a*cos(t)*cos(theta)-b*sin(t)*sin(theta);
    y = a*cos(t)*sin(theta)+b*sin(t)*cos(theta);
    float x_f = x*x_x + y*y_x;
    float y_f = x*x_y + y*y_y;
    sketch.fill(colour.x,colour.y,colour.z);
    sketch.ellipse(X+x_f, Y+y_f, rad, rad);
//    ellipse(X,Y,2,2);
  }

}
