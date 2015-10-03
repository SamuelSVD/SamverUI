import ProcessingJava.*;
import processing.core.*;
public class Main {
  public static void main(String[] args) {
    int size = 500;
    MainDisplay mainDisplay = new MainDisplay(size,size+6);
//    mainDisplay.addSketch(new RainbowEllipsesSketch(new PVector(size, size)));
//    mainDisplay.addSketch(new TestingSketch(new PVector(size, size)));
//    mainDisplay.addSketch(new OscillatingCircleThingSketch(new PVector(size, size)));
    mainDisplay.setVisible(true);
  }
}
