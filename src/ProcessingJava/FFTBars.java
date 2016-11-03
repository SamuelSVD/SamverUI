package ProcessingJava;

import processing.core.PVector;
import java.util.ArrayList;
import Math.*;

public class FFTBars extends VisualComponent {
	private double width;
	private double height;
	private double max;
	
	private ArrayList<Function> functions;
	
	public FFTBars() {
		this(new PVector(), new PVector());
	}

	public FFTBars(PVector position, PVector colour) {
		super(position, colour);
	}
	
	public void init(ArrayList<Function> functions, double max_value) {
		this.functions = functions;
		max = max_value;
	}
	
	public void update(float d) {
		for (int i = 0; i < functions.size(); i++) {
			functions.get(i).update(d);
		}
	}
	
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public void draw() {
		double beforeX = 0;
		double beforeY = 0;
		for(int i = 0; i < functions.size(); i++) {
			double currentX = i*1.0/functions.size()*width;
			double currentY = functions.get(i).getValue()/max*height;
			sketch.rect((float)beforeX,  0, (float) (currentX - beforeX), (float)currentY);
			beforeX = currentX;
			beforeY = currentY;
		}
		double currentX = beforeX + 2;
		double currentY = 0;
		double midpoint = beforeX + (currentX-beforeX)/2;
		
		sketch.endShape();
	}
	

}
