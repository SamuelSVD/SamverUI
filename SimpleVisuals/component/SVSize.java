package component;

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
	public SVFloat getWidth() {
		return width;
	}
	public void setWidth(SVFloat width) {
		this.width = width;
	}
	public SVFloat getHeight() {
		return height;
	}
	public void setHeight(SVFloat height) {
		this.height = height;
	}
	public SVFloat getDepth() {
		return depth;
	}
	public void setDepth(SVFloat depth) {
		this.depth = depth;
	}
}
