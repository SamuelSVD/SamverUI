import java.util.ArrayList;
import processing.core.PVector;
import Math.*;
import ProcessingJava.*;
import SystemUtils.SystemUtils;

public class MathUtilsTest2 extends Sketch{
  public MathUtilsTest2(PVector size) {
    super(size);
  }
  public MathUtilsTest2(PVector position, PVector size) {
    super(position, size);
  }
  public static void main(String[] args) {
    
  }

  @Override
  public void setup() {
    record = true;
    size((int)size.x, (int)size.y); //Always needed. Looking for a fix.
    setSpeed(0.003f);
    Background back = new Background(new PVector());
    addVisualComponent(back);
    ArrayList<ArrayList<Double>> lists = SystemUtils.readDoubleCSV("Data/CSV/music.csv");
    frame_limit = 3 * lists.get(0).size();
    double max = 0;
    
    for(ArrayList<Double> list: lists) {
      for(Double element: list) {
        if (element > max) max = element;
      }
    }
    for(ArrayList<Double> list: lists) {
      for(int i = 0; i < list.size(); i++) {
        list.set(i, Math.sqrt(list.get(i)/max)*size.y);
      }
    }
    
    
    for (int j = 0; j < size.x/6.0; j++) {
      ArrayList<Double> a = lists.get(j);
      for (int i = 0; i < lists.get(j).size(); i++) {
//        System.out.print(lists.get(j).get(i));
//        System.out.print(",");
      }
//      System.out.println();
      a.add(a.get(0));
      PVector position = new PVector(j*6,size.y);
      PVector colour = new PVector(random(255),random(255),random(255));
      TransitionBar b = new TransitionBar(position, colour, a,3,6);
      b.setRorationAfterTranslate(-PI/2);
      addVisualComponent(b);
    }
  }
}
