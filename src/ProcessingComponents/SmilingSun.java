package ProcessingComponents;

import ProcessingJava.*;

public class SmilingSun extends VisualComponent{
  public SmilingSun () {
    
  }
  public void draw() {
    super.draw();
    sketch.pushMatrix();
    float length = 175;
    float width = 46;
    float radius = 75;
    float percent = 0.57f;
    sketch.rotate(PI/8);
//    sketch.noStroke();
    sketch.fill(255,201,14);
    for (int i = 0; i < 8; i++) {
      sketch.beginShape();
      sketch.vertex(-(2*width-2*width*(1-percent)),(1-percent) * length);
      sketch.vertex(0,length);
      sketch.vertex((2*width-2*width*(1-percent)),(1-percent) * length);
      sketch.endShape();
      sketch.rotate((float)(PI*2.0/8));
    }
    sketch.popMatrix();
    sketch.pushMatrix();
    sketch.fill(255,255,121);
    for (int i = 0; i < 8; i++) {
      sketch.beginShape();
      sketch.vertex(-width,0);
      sketch.vertex(0,175);
      sketch.vertex(width,0);
      sketch.endShape();
      sketch.rotate((float)(PI*2.0/8));
    }
    sketch.popMatrix();
    
    sketch.stroke(83,63,26);
    sketch.ellipse(0, 0, 2 * radius, 2 * radius);
    sketch.arc(-30, -20, 50, 30, PI/10, PI-PI/10);
    sketch.arc(30, -20, 50, 30, PI/10, PI-PI/10);
    sketch.arc(0, 30, 60, 30, PI/10, PI-PI/10);
  }
}
