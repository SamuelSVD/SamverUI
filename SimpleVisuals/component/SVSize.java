package component;

import Utils.SVPropertyList;
import primitive.*;

public class SVSize extends SVPropertyList {
	protected SVFloat width;
	protected SVFloat height;
	protected SVFloat depth;
	public SVSize() {
		super("Size");
		width = new SVFloat("Width");
		height = new SVFloat("Height");
		depth = new SVFloat("Depth");
		list.add(width);
		list.add(height);
		list.add(depth);
	}
	public float getWidth() {
		return width.getValue();
	}
	public void setWidth(float width) {
		this.width.setValue(width);
	}
	public float getHeight() {
		return height.getValue();
	}
	public void setHeight(float height) {
		this.height.setValue(height);
	}
	public float getDepth() {
		return depth.getValue();
	}
	public void setDepth(float depth) {
		this.depth.setValue(depth);
	}
}
