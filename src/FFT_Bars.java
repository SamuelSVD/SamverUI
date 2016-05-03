import java.util.ArrayList;
import processing.core.PVector;
import Math.*;
import ProcessingJava.*;
import SystemUtils.SystemUtils;

public class FFT_Bars extends Sketch{
  public FFT_Bars(PVector size) {
    super(size);
  }
  public FFT_Bars(PVector position, PVector size) {
    super(position, size);
  }
  public static void main(String[] args) {
    
  }

  @Override
  public void setup() {
    String filename = "Data/CSV/music.csv";
    PVector COLOUR = null;
    boolean different_colours = false; //Only applies if COLOUR null
    int BAR_WIDTH = 15;
    
    
    
    record = false;
    size((int)size.x, (int)size.y); //Always needed. Looking for a fix.
    setSpeed(0.003f);
    Background back = new Background(new PVector());
    addVisualComponent(back);
    ArrayList<ArrayList<Double>> lists = SystemUtils.readDoubleCSV(filename);
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
    
    if (COLOUR == null) {
      COLOUR = new PVector(random(255), random(255),random(255));
    }
    
    for (int j = 0; j < size.x/BAR_WIDTH ; j++) {
      ArrayList<Double> a = new ArrayList<Double>();
      for (int i = 0; i < lists.get(j).size(); i++) {
        double total = 0;
        int count = 0;
        if (j != 0) {
          total += lists.get(j-1).get(i);
          count++;
        }
        if (i != lists.size()-1) {
          total += lists.get(j+1).get(i);
        }
        total += lists.get(j).get(i);
        count++;
        a.add(total/count);
      }
      for (int i = 0; i < lists.get(j).size(); i++) {
//        System.out.print(lists.get(j).get(i));
//        System.out.print(",");
      }
//      System.out.println();
      a.add(a.get(0));
      PVector position = new PVector(j*BAR_WIDTH ,size.y);
      PVector colour;
      if (different_colours) colour = new PVector(random(255),random(255),random(255));
      else colour = COLOUR;
      TransitionBar b = new TransitionBar(position, colour, a,3,BAR_WIDTH);
      b.setRorationAfterTranslate(-PI/2);
      addVisualComponent(b);
    }
  }
}
