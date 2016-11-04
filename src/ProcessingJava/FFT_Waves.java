package ProcessingJava;

import java.util.ArrayList;

import SystemUtils.SystemUtils;
import processing.core.PVector;
import ProcessingJava.*;
import Math.*;
import SystemUtils.OpenDialog;

public class FFT_Waves extends Sketch {
	FFTWave wave;
	FFTBars bars;
	public FFT_Waves(PVector size) {
    this(new PVector(), size);
  }
	
  public FFT_Waves(PVector position, PVector size) {
    super(position, size);
  }
	
  @Override
	public void setup() {
/*  	OpenDialog fd = new OpenDialog("C:\\");
  	String[] filters = {".csv"};
  	String[] descriptions = {"CommaSeparatedValues"};
  	fd.SetFilter(filters, descriptions);
  	fd.setVisible(true);
  	String filename = fd.getSelectedFile().getAbsolutePath();
  	if (filename == null)
  	  System.out.println("You cancelled the choice");
  	else
  	  System.out.println("You chose " + filename);
    */
    String filename = "Data/CSV/Summer Was Fun - Hold On (feat. Q'AILA).mp3.csv";
    record = false;
    ArrayList<ArrayList<Double>> lists = SystemUtils.readDoubleCSV(filename);
    lists = SystemUtils.transpose(lists);
    this.frame_limit = 3 * lists.get(0).size();
    DEBUG = false;
    setSpeed(1f);
    System.out.println(frame_limit);
//    lists = new ArrayList<ArrayList<Double>>(lists.subList(0, 500));
    ArrayList<Function> functions = new ArrayList<Function>();
    
    
    int rect_width = 10;
    ArrayList<ArrayList<Double>> new_list = new ArrayList<ArrayList<Double>>();
    for (int i = 0; i < lists.size() - rect_width ; i += 10) {
    	ArrayList<Double> temp = SystemUtils.sumAcross(new ArrayList<ArrayList<Double>>(lists.subList(i, i+10)));
    	temp = SystemUtils.multByConst(temp, 1/10.0);
    	new_list.add(temp);
    }
    lists = new_list;
    
    lists = SystemUtils.multArrayByConst(lists, 1/SystemUtils.max(SystemUtils.maxEach(lists))); //divide all by max
    //lists = SystemUtils.powEach(lists, 2); //power of 2
    lists = SystemUtils.smoothAcross(lists);
    //lists = SystemUtils.smoothAcross(lists);
    
    for (int i = 0; i < lists.size(); i++) {
    	functions.add(new LinearTransition(SystemUtils.multByConst(lists.get(i), -1), 3));
    }
    
    wave = new FFTWave(new PVector(0,size.y/2), Utils.randomPVector());
		wave.init(functions, SystemUtils.max(SystemUtils.maxEach(lists)));
		wave.setWidth(size.x+1);
		wave.setHeight(size.y/2);
		wave.horizontal_vertex = false;
		
		bars = new FFTBars(new PVector(0,size.y/2), Utils.randomPVector());
		bars.init(functions, SystemUtils.max(SystemUtils.maxEach(lists)));
		bars.setWidth(size.x+1);
		bars.setHeight(size.y/2);
		
		this.addVisualComponent(new Background(new PVector(255,255,255)));
    this.addVisualComponent(wave);
//    this.addVisualComponent(bars);
	}
}
