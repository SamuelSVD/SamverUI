package ProcessingJava;

import processing.core.PVector;

public class Rectangle extends VisualComponent {
	PVector size;
	public Rectangle() {
		this(new PVector(), new PVector());
	}

	public Rectangle(PVector position, PVector colour) {
		this(position, new PVector(10, 10), colour);
		// TODO Auto-generated constructor stub
	}
	
	public Rectangle(PVector position, PVector size, PVector colour) {
		super(position, colour);
		this.size = size;
		// TODO Auto-generated constructor stub
	}
	
	
	public void draw() {
		sketch.fill(colour);
		sketch.rect(0, 0, size.x, size.y);
	}
	

}
