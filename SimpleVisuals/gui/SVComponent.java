package gui;

import component.*;
import primitive.*;
import ProcessingJava.*;
import Utils.SVPropertyList;
import processing.core.*;

public abstract class SVComponent {
	protected SVPropertyList list;
	protected SVString name;
	protected SVPosition position;
	protected SVSize size;
	protected Sketch sketch;
	
	public SVComponent() {
		list = new SVPropertyList("Properties");
		position = new SVPosition();
		size = new SVSize();
		list.add(name);
		list.add(position);
		list.add(size);
	}
	public void setPosition(float x, float y)  {
		setPosition(x, y, 0);
	}
	public void setPosition(float x, float y, float z) {
		position.setX(x);
		position.setY(y);
		position.setZ(z);
	}
	public void setSize(float w, float h) {
		setSize(w, h, 0);
	}
	public void setSize(float w, float h, float d) {
		size.setWidth(w);
		size.setHeight(h);
		size.setDepth(d);
	}
	public void setSketch(Sketch sketch) {
		this.sketch = sketch;
	}
	public String getName() {
		return name.getValue();
	}
	public void setName(String name) {
		this.name.setValue(name);
	}
	public void doDraw(PGraphics graphics) {
		graphics.pushMatrix();
		graphics.translate(position.getX(), position.getY());
		draw(graphics);
		graphics.popMatrix();
	}
	public abstract void draw(PGraphics graphics);
}
