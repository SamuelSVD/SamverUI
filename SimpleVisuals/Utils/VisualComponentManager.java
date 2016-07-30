package Utils;

import gui.SVComponent;
import processing.core.*;

public class VisualComponentManager {
	SVComponentList list;
	public VisualComponentManager() {
		list = new SVComponentList();
	}
	
	public void add(SVComponent component) {
		list.add(component);
	}
	public void draw(PGraphics graphics) {
		list.doDraw(graphics);
	}
}
