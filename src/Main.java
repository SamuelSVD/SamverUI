import ProcessingJava.*;
import processing.core.*;
public class Main {
  public static void main(String[] args) {
    int size = 500;
    PVector p = new PVector(size, size);
    MainDisplay mainDisplay = new MainDisplay(size,size+6);
    Sketch s;
//    s = new RainbowEllipsesSketch(p);
//    s = new TestingSketch(p);
//    s = new OscillatingCircleThingSketch(p);
//    s = new Tree_Sketch(p);
//    s = new ComponentEllipseSketch(p);
//    s = new MathSketch(p);
//    s = new MathSketch2(p);
//    s = new MathSketch3(p);
//    s = new MathSketch4(p);
//    s = new ShapeSketch(p);
//    s = new HandSketch(p);
//    s = new Sketch_3D(p);
//    s = new Orbit_3D(p);
//    s = new Utils_test(p);
//    s = new Utils_test2(p);
    s = new Utils_test3(p);
    mainDisplay.addSketch(s);
    mainDisplay.setVisible(true);
  }
}
