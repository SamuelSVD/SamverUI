package ProcessingJava;

import processing.core.PVector;

public class Donut extends VisualComponent{
  protected float starting_angle, ending_angle, inner_radius, outer_radius;
  public Donut(PVector position, PVector colour, float inner_radius, float outer_radius) {
    super(position, colour);
    this.inner_radius = inner_radius;
    this.outer_radius = outer_radius;
    this.starting_angle = 0;
    this.starting_angle = 2*PI;
  }
  public Donut(PVector position, PVector colour, float inner_radius, float outer_radius, float starting_angle, float ending_angle) {
    super(position, colour);
    this.inner_radius = inner_radius;
    this.outer_radius = outer_radius;
    this.starting_angle = starting_angle;
    this.ending_angle = ending_angle;
  }
  public void setStartingAngle(float starting_angle) {
    this.starting_angle = starting_angle;
  }
  public void setEndingAngle(float ending_angle) {
    this.ending_angle = ending_angle;
  }
  public void setInnerRadius(float inner_radius) {
    this.inner_radius=inner_radius;
  }
  public void setOuterRadius(float outer_radius) {
    this.outer_radius = outer_radius;
  }
  public void draw() {
    sketch.fill(colour.x,colour.y,colour.z, this.alpha);
    drawDonut(sketch, 0, 0, inner_radius, outer_radius, starting_angle, ending_angle);
  }
  static void drawDonut(Sketch sketch, float x, float y, float inner_r, float outer_r) {
    drawDonut(sketch, x,y,inner_r,outer_r,0,2*PI); 
   }
  static void drawDonut(Sketch sketch, float x, float y, float inner_r, float outer_r, float start, float end){
     sketch.beginShape(TRIANGLE_STRIP);
     float N = 50;
     float d = (end - start);
     for(int i = 0; i < N+1; i++) {
       sketch.vertex(x + inner_r*cos(start + d/N*i), y + inner_r*sin(start + d/N*i));
       sketch.vertex(x + outer_r*cos(start + d/N*i), y + outer_r*sin(start + d/N*i));
     }
     for(float i = N-1; i > -1; i--) {
       sketch.vertex(x + outer_r*cos(start + d/N*i), y + outer_r*sin(start + d/N*i));
       sketch.vertex(x + inner_r*cos(start + d/N*i), y + inner_r*sin(start + d/N*i));
     }
     sketch.endShape(CLOSE);
   }
}
