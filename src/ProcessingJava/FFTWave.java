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
		sketch.noFill();
		sketch.stroke(colour.x, colour.y, colour.z);
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
			double beforeX = -1.0/(functions.size()-1)*width;;
			double beforeY = functions.get(0).getValue()/max*height;
			double nextX = 0;
			double nextY = 0;
			double angleAfter = 0;

			double bezierControlStartX = 0;
			double bezierControlStartY = 0;
			double bezierControlEndX = 0;
			double bezierControlEndY = 0;
			
			for(int i = 0; i < functions.size() ; i++) {
				double currentX = i*1.0/(functions.size()-1)*width;
				double currentY = functions.get(i).getValue()/max*height;
				if (i == functions.size() - 1) {
					nextX = (i+1)*1.0/(functions.size()-1)*width;
					nextY = functions.get(i).getValue()/max*height;
				} else {
					nextX = (i+1)*1.0/(functions.size()-1)*width;
					nextY = functions.get(i+1).getValue()/max*height;
				}
				
				PVector v1 = new PVector ((float)(currentX - beforeX), (float)(currentY - beforeY));
				PVector v2 = new PVector ((float)(currentX - nextX), (float)(currentY - nextY));
				PVector v3 = v2.copy();
				v3.mult(-1);
				v3.normalize();
				angleAfter = PI/2 - Utils.angleBetween(v1, v2)/2;
				if (currentY >= nextY) {
					v3.rotate((float)angleAfter);
				}	else {
					v3.rotate(-(float)angleAfter);
				}
				v3.mult((float)(currentX - beforeX)/2);
				bezierControlEndX = currentX - v3.x;
				bezierControlEndY = currentY - v3.y;
//				sketch.bezierVertex((float)(bezierControlStartX), (float)(bezierControlStartY), (float)(bezierControlEndX), (float)(bezierControlEndY), (float)currentX, (float)currentY);
				if (i != 0)sketch.bezier((float)beforeX, (float)beforeY, (float)(bezierControlStartX), (float)(bezierControlStartY), (float)(bezierControlEndX), (float)(bezierControlEndY), (float)currentX, (float)currentY);
//				sketch.line(beforeX, beforeY, currentX, currentY);
//				sketch.line(nextX, nextY, currentX, currentY);
				beforeX = currentX;
//				sketch.stroke(0,255,0);
	//			sketch.line(bezierControlEndX, bezierControlEndY, currentX, currentY);
				bezierControlStartX = currentX + v3.x;
				bezierControlStartY = currentY + v3.y;
				beforeY = currentY;
				//sketch.stroke(255,0,0);
				//sketch.line(bezierControlStartX, bezierControlStartY, currentX, currentY);
				sketch.stroke(colour.x, colour.y, colour.z);
				
			}
			double currentX = beforeX + 2;
			double currentY = 0;
			double midpoint = beforeX + (currentX-beforeX)/2;
//			sketch.bezierVertex((float)(midpoint), (float)(beforeY), (float)(midpoint), (float)(currentY), (float)currentX, (float)currentY);
			
		}
		sketch.vertex((float)width,0);
		sketch.endShape();
		for(int i = 0; i < functions.size(); i++) {
			double currentX = i*1.0/(functions.size()-1)*width;
			double currentY = functions.get(i).getValue()/max*height;
//			sketch.ellipse((float)currentX, (float)currentY, 4, 4);
		}
	}
	

}
