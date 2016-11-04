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
    double max = 100;
    for (int i = 0; i < 4; i++) {
    	double temp = (i % 2 == 0)? 0 : 100;
    	temp = Math.random() * 100;
    	if (max < temp) max = temp;
    	functions.add(new Constant(-temp));
    }

    functions.add(new Constant(100));
    functions.add(new Constant(75));
    functions.add(new Constant(0));
    functions.add(new Constant(100));
	  wave = new FFTWave(new PVector(50,size.y*1.50f/3), Utils.randomPVector());
		wave.init(functions, max);
		wave.setWidth(400);
		wave.setHeight(100);
		wave.horizontal_vertex = false;
		addVisualComponent(new Background(new PVector(255,255,255)));
		addVisualComponent(wave);
	}

}
