package sketches;
import Math.*;
import ProcessingJava.*;
import processing.core.*;

public class HandSketch extends Sketch{
  public HandSketch(PVector size) {
    super(size);
  }
  public HandSketch(PVector position, PVector size) {
    super(position, size);
  }
  public void setup() {
    setSpeed(0.033f);

    noStroke();
    background(0);
    PVector col = new PVector(random(255),random(255),random(255));
    Square s = new Square(col, size);
    addVisualComponent(s);

    double angle;
    VisualContainer c, temp_c;
    Picture p;
    float mult[] = {0.9f,1,1.1f,1};
    float spacing[] = {0.9f, 0.9f, 0.9f, 0.9f};
    for (int i = 0; i < 4; i++) {
      c = new VisualContainer(new PVector(40*mult[i],0));
      angle = PI/4;
      c.setRotationAfterTranslateFun(new Sin(0,angle,1,angle));
      p = new Picture(new PVector(0,0), "Data/Images/finger_segment_tip.png");
      p.resize((int)(p.getWidth()*mult[i]), (int)(p.getHeight()*0.8));
      c.addVisualComponent(p);
      temp_c = new VisualContainer(new PVector(70*mult[i],0));
      temp_c.addVisualComponent(c);
      c = temp_c;
      angle = PI/4+0.2;
      c.setRotationAfterTranslateFun(new Sin(0,angle,1,angle));
      p = new Picture(new PVector(0,0), "Data/Images/finger_segment_mid.png");
      p.resize((int)(p.getWidth()*mult[i]), (int)(p.getHeight()*0.9));
      c.addVisualComponent(p);
      temp_c = new VisualContainer(new PVector(250+ 25 * i * spacing[i],250));
      temp_c.addVisualComponent(c);
      c = temp_c;
      angle = PI/4-0.1;
      c.setRotationAfterTranslateFun(new Sin(0,angle,1,angle));
      p = new Picture(new PVector(0,0), "Data/Images/finger_segment_base.png");
      p.resize((int)(p.getWidth()*mult[i]), (int)(p.getHeight()*1));
      c.addVisualComponent(p);
      addVisualComponent(c);
//      addVisualComponent(new Rectangle())
    }
  }
}
