package ProcessingJava;

import java.util.ArrayList;

import Math.*;
import SystemUtils.SystemUtils;
import processing.core.PVector;

public class WaveTest extends Sketch {
	FFTWave wave;
	public WaveTest() {
		// TODO Auto-generated constructor stub
	}

	public WaveTest(PVector size) {
		super(size);
	}

	public WaveTest(PVector position, PVector size) {
		super(position, size);
	}

	@Override
	public void setup() {
    ArrayList<Function> functions = new ArrayList<Function>();
    double max = 0;
    for (int i = 0; i < 10; i++) {
    	double temp = Math.random() * 100;
    	if (max < temp) max = temp;
    	functions.add(new Constant(-temp));
    }
	  wave = new FFTWave(new PVector(50,size.y*1.50f/3), Utils.randomPVector());
		wave.init(functions, max);
		wave.setWidth(size.x+2-100);
		wave.setHeight(size.y/3);
		wave.horizontal_vertex = false;
		addVisualComponent(new Background(new PVector(255,255,255)));
		addVisualComponent(wave);
	}

}
