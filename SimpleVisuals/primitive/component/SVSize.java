package primitive.component;

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
		return (float)width.getValue();
	}
	public void setWidth(float width) {
		try {
			this.width.setValue(width);
		} catch (Exception e) {
		}
	}
	public float getHeight() {
		return (float)height.getValue();
	}
	public void setHeight(float height) {
		try {
			this.height.setValue(height);
		} catch (Exception e) {
		}
	}
	public float getDepth() {
		return (float)depth.getValue();
	}
	public void setDepth(float depth) {
		try {
			this.depth.setValue(depth);
		} catch (Exception e) {
		}
	}
}
