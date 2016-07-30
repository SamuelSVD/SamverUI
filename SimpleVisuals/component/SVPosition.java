package component;

import Utils.SVPropertyList;
import primitive.*;

public class SVPosition extends SVPropertyList {
	protected SVFloat x;
	protected SVFloat y;
	protected SVFloat z;
	public SVPosition() {
		super("Position");
		x = new SVFloat("x");
		y = new SVFloat("y");
		z = new SVFloat("z");
		list.add(x);
		list.add(y);
		list.add(z);
	}
	public float getX() {
		return x.getValue();
	}
	public void setX(float x) {
		this.x.setValue(x);
	}
	public float getY() {
		return y.getValue();
	}
	public void setY(float y) {
		this.y.setValue(y);;
	}
	public float getZ() {
		return z.getValue();
	}
	public void setZ(float z) {
		this.z.setValue(z);
	}
}
