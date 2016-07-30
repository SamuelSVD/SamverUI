package panels;

import ProcessingJava.*;
import processing.core.*;
import gui.*;
import Utils.*;

public class SVMainPanel extends Sketch{
	public static Sketch activeSketch;
	NonVisualComponentManager nvcManager;
	VisualComponentManager vcManager;
	SVComponent c;
	public SVMainPanel() {
		super(new PVector(), new PVector(500,500));
		activeSketch = this;
		nvcManager = new NonVisualComponentManager();
		vcManager = new VisualComponentManager();
		
		vcManager.add(new SVButton());
		
		c = new SVEditBox();
		c.setPosition(10, 50);
		vcManager.add(c);
	}
	@Override
	public void setup() {
	}
	
	public void draw() {
		super.draw();
		vcManager.draw(this.getGraphics());
	}
}
