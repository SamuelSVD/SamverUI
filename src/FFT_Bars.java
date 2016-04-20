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
  @Override
  public void setup() {
    String filename = "Data/CSV/music.csv";
    PVector COLOUR = new PVector(10+random(100),100+random(155),100+random(155));
    boolean different_colours = false;    //Only applies if COLOUR null
    boolean normalize_all = true;        //normalizes all by largest value
    boolean normalize_individual = false; //only applies if normalize_all false;
    boolean plot_square_root = false;     //only applies if normalize true;
    boolean smoothen = true;             //used to smoothen the curves. Mean of +-1 entries;
    boolean isLoop = false;               //adds the first points to the end
    boolean exponential_fix = false;     //Used to make the average for each frequency more normalized
    int BAR_WIDTH = 5;
    int NUM_BARS = (460/BAR_WIDTH);
    int MAX_BAR_HEIGHT = (int)300;
    int MIN_BAR_HEIGHT = (int) 10;
    int VERTICAL_OFFSET = 50;
    int HORIZONTAL_OFFSET = 20;
    double transition_period = 3;
    
    boolean DEBUG = false;
    
    
    record = false;
    size((int)size.x, (int)size.y); //Always needed. Looking for a fix.
    setSpeed(0.033333f);
    Background back = new Background(new PVector());
    addVisualComponent(back);
    ArrayList<ArrayList<Double>> lists = SystemUtils.readDoubleCSV(filename);
    frame_limit = 3 * lists.get(0).size();
    
    if (normalize_all) {
      if (DEBUG) System.out.println("-- Normalizing All --");
      double max = 0;
      for(int i = 0; i < lists.size(); i++) {
        ArrayList<Double> list = lists.get(i);
        if (DEBUG) System.out.println(SystemUtils.ArrayListToString(list));
        for(Double element: list) {
          if (element > max) max = element;
        }
      }
      if (DEBUG) System.out.printf("Max: %f\n", max);
      for(int i = 0; i < NUM_BARS+1; i++) {
        ArrayList<Double> list = lists.get(i);
        for(int j = 0; j < list.size(); j++) {
          double t = plot_square_root ? Math.sqrt(list.get(j)/max)*(MAX_BAR_HEIGHT-MIN_BAR_HEIGHT) : (list.get(j)/max)*(MAX_BAR_HEIGHT-MIN_BAR_HEIGHT);
          if (DEBUG) System.out.print(t);
          t = t+MIN_BAR_HEIGHT;
          if (t < MIN_BAR_HEIGHT) t = MIN_BAR_HEIGHT;
          list.set(j, t);
        }
        if (DEBUG) System.out.println(SystemUtils.ArrayListToString(list));
      }
    }
    else if (normalize_individual) {
      if (DEBUG) System.out.println("-- Normalizing Individual --");
      for(int i = 0; i < NUM_BARS+1; i++) {
        ArrayList<Double> list = lists.get(i);
        if (DEBUG) System.out.println(SystemUtils.ArrayListToString(list));
        double max = 0;
        for(Double element: list) {
          if (element > max) max = element;
        }
        if (DEBUG) System.out.printf("Max: %f\n", max);
        for(int j = 0; j < list.size(); j++) {
          double t = plot_square_root? Math.sqrt(list.get(j)/max)*(MAX_BAR_HEIGHT-MIN_BAR_HEIGHT) : (list.get(j)/max)*(MAX_BAR_HEIGHT-MIN_BAR_HEIGHT);
          t += MIN_BAR_HEIGHT;
          if (t < MIN_BAR_HEIGHT) t = MIN_BAR_HEIGHT;
          list.set(j, t);
          if (DEBUG) System.out.println(SystemUtils.ArrayListToString(list));
        }
      }
    }
    if (DEBUG) System.out.println("-- Done Normalizing --");
    
    if (COLOUR == null) {
      COLOUR = new PVector(random(255), random(255),random(255));
    }
    
    for (int j = 0; j < NUM_BARS; j++) {
      if (DEBUG) System.out.println(SystemUtils.ArrayListToString(lists.get(j)));    
      ArrayList<Double> a = new ArrayList<Double>();
      for (int i = 0; i < lists.get(j).size(); i++) {
        double total = 0;
        int count = 0;
        if (smoothen) {
          if (j != 0) {
            total += lists.get(j-1).get(i);
            count++;
          }
          if (i != NUM_BARS-1) {
            total += lists.get(j+1).get(i);
          }
        }
        total += lists.get(j).get(i);
        count++;
//        System.out.printf("%f\t%d\t%f\n", lists.get(j).get(i), count, total/count);
        a.add(total/count);
      }
      if (isLoop) a.add(a.get(0));
      PVector position = new PVector(j*BAR_WIDTH+HORIZONTAL_OFFSET ,size.y-VERTICAL_OFFSET);
      PVector colour;
      if (different_colours) colour = new PVector(random(255),random(255),random(255));
      else colour = COLOUR;
      TransitionBar b = new TransitionBar(position, colour, a,transition_period,BAR_WIDTH);
      b.setRorationAfterTranslate(-PI/2);
      addVisualComponent(b);
    }
  }
}
