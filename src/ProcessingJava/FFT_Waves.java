package ProcessingJava;

import java.util.ArrayList;

import SystemUtils.SystemUtils;
import processing.core.PVector;
import ProcessingJava.*;
import Math.*;

public class FFT_Waves extends Sketch {
	FFTWave wave;
	
	public FFT_Waves(PVector size) {
    this(new PVector(), size);
  }
	
  public FFT_Waves(PVector position, PVector size) {
    super(position, size);
  }
	
  @Override
	public void setup() {
    String filename = "Data/CSV/Televisor_Alliance.csv";
    ArrayList<ArrayList<Double>> lists = SystemUtils.readDoubleCSV(filename);
    ArrayList<Function> functions = new ArrayList<Function>();
    double max = 0;
    for (int i = 0; i < lists.size(); i++) {
    	for (int j = 0; j < lists.get(i).size(); j++) {
    		if (lists.get(i).get(j) > max) max = lists.get(i).get(j);
    	}
    }
    lists = SystemUtils.multArrayByConst(lists, 100/max);
    for (int i = 0; i < lists.size(); i++) {
    	functions.add(new LinearTransition(lists.get(i), 4));
    }
		wave = new FFTWave(new PVector(10,100), new PVector());
		wave.init(functions);
		this.addVisualComponent(new Background(new PVector(255,255,255)));
    this.addVisualComponent(wave);
	}
}