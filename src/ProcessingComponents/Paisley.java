package ProcessingComponents;

import ProcessingJava.*;
public class Paisley extends VisualContainer{
  double size;
  int reps;
  public Paisley(int repetitions, double size) {
    reps = repetitions;
    this.size = size;
  }
  
  public void draw() {
    for (int i = 0; i < reps; i++) {
      for (int j = 0; j < reps; j++) {
        sketch.pushMatrix();
        sketch.translate((float)size*i, (float)size*j);
        super.draw();
        sketch.popMatrix();
      }
    }
  }
}
