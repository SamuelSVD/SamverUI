package ProcessingJava;

import processing.core.PVector;
import java.util.ArrayList;
import Math.*;

public class FFTWave extends VisualComponent {
	private double width;
	private double height;
	private double max;
	public boolean horizontal_vertex = true;
	
	private ArrayList<Function> functions;
	
	public FFTWave() {
		this(new PVector(), new PVector());
	}

	public FFTWave(PVector position, PVector colour) {
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
		sketch.fill(colour.x, colour.y, colour.z);
		sketch.beginShape();
		sketch.vertex(0,0);
		if (horizontal_vertex) {
			double beforeX = 0;
			double beforeY = functions.get(0).getValue()/max*height;
			sketch.vertex((float)beforeX, (float)beforeY);
			for(int i = 1; i < functions.size(); i++) {
				double currentX = i*1.0/(functions.size()-1)*width;
				double currentY = functions.get(i).getValue()/max*height;
				double midpoint = beforeX + (currentX-beforeX)/2;
				sketch.bezierVertex((float)(midpoint), (float)(beforeY), (float)(midpoint), (float)(currentY), (float)currentX, (float)currentY);
				beforeX = currentX;
				beforeY = currentY;
			}
		} else {
			double beforeX = 0;
			double beforeY = functions.get(0).getValue()/max*height;
			double beforeMiddleX = 0;
			double beforeMiddleY = 0;
			double beforeAngle = 0;
			double nextX = 0;
			double nextY = 0;
			double afterMiddleX = 0;
			double afterMiddleY = 0;
			
			for(int i = 1; i < functions.size(); i++) {
				double currentX = i*1.0/(functions.size()-1)*width;
				double currentY = functions.get(i).getValue()/max*height;
				if (i != functions.size() - 1) {
					nextX = (i+1)*1.0/(functions.size()-1)*width;
					nextY = functions.get(i+1).getValue()/max*height;
				}
				
				beforeMiddleX = (currentX + beforeX) / 2;
				afterMiddleX = (currentX + nextX + 1) / 2;
				PVector v1 = new PVector ((float)(currentX - beforeX), (float)(currentY - beforeY));
				sketch.line(currentX, currentY, currentX + v1.x, currentY + v1.y);
				PVector v2 = new PVector ((float)(currentX - nextX), (float)(currentY - nextY));
				sketch.line(currentX, currentY, currentX + v2.x, currentY + v2.y);
				PVector v3 = new PVector ((float)(0), (float)(currentY));
				double angle1 = Utils.angleBetween(v1, v3);
				double angle2 = Utils.angleBetween(v2, v3);
				beforeMiddleY = currentY - Math.cos(beforeAngle) * (currentX - beforeMiddleX);
				afterMiddleY = currentY - Math.cos(angle2) * (currentX - beforeMiddleX);
				sketch.bezierVertex((float)(beforeMiddleX), (float)(beforeMiddleY), (float)(afterMiddleX), (float)(afterMiddleY), (float)currentX, (float)currentY);
//				sketch.line(beforeMiddleX, beforeMiddleY, currentX, currentY);
//				sketch.line(afterMiddleX, afterMiddleY, currentX, currentY);
				beforeX = currentX;
				beforeY = currentY;
				beforeAngle = Utils.angleBetween(v2, v3);
				
			}
			double currentX = beforeX + 2;
			double currentY = 0;
			double midpoint = beforeX + (currentX-beforeX)/2;
			sketch.bezierVertex((float)(midpoint), (float)(beforeY), (float)(midpoint), (float)(currentY), (float)currentX, (float)currentY);
			
		}
		sketch.vertex((float)width,0);
		sketch.endShape();
		for(int i = 0; i < functions.size(); i++) {
			double currentX = i*1.0/(functions.size()-1)*width;
			double currentY = functions.get(i).getValue()/max*height;
			sketch.ellipse((float)currentX, (float)currentY, 4, 4);
		}
	}
	

}
