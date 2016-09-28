package ProcessingJava;

import processing.core.PVector;
import java.util.ArrayList;
import Math.*;

public class FFTWave extends VisualComponent {
	private int num_points;
	private ArrayList<Function> functions;
	
	public FFTWave() {
	}

	public FFTWave(PVector position, PVector colour) {
		super(position, colour);
	}
	public void init(ArrayList<Function> functions) {
		this.functions = functions;
	}
	
	public void update(float d) {
		for (int i = 0; i < functions.size(); i++) {
			functions.get(i).update(d);
		}
	}
	public void draw() {
		sketch.beginShape();
		sketch.vertex(0,0);
		double beforeX = 0;
		double beforeY = 0;
		for(int i = 0; i < functions.size(); i++) {
			double currentX = beforeX + 2;
			double currentY = functions.get(i).getValue();
			double midpoint = beforeX + (currentX-beforeX)/2;
			sketch.bezierVertex((float)(midpoint), (float)(beforeY), (float)(midpoint), (float)(currentY), (float)currentX, (float)currentY);
			beforeX = currentX;
			beforeY = currentY;
		}
		double currentX = beforeX + 2;
		double currentY = 0;
		double midpoint = beforeX + (currentX-beforeX)/2;
		sketch.bezierVertex((float)(midpoint), (float)(beforeY), (float)(midpoint), (float)(currentY), (float)currentX, (float)currentY);
		
		sketch.endShape();
	}
	

}
