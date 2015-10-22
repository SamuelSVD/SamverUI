import ProcessingJava.*;
import processing.core.*;
public class Main {
  public static void main(String[] args) {
    int size = 500;
    PVector p = new PVector(size, size);
    MainDisplay mainDisplay = new MainDisplay(size,size+6);
//    mainDisplay.addSketch(new RainbowEllipsesSketch(p));
//    mainDisplay.addSketch(new TestingSketch(p));
//    mainDisplay.addSketch(new OscillatingCircleThingSketch(p));
    mainDisplay.addSketch(new Tree_Sketch(p));
    mainDisplay.setVisible(true);
  }
}
