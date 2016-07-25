package component;

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
	public SVFloat getX() {
		return x;
	}
	public void setX(SVFloat x) {
		this.x = x;
	}
	public SVFloat getY() {
		return y;
	}
	public void setY(SVFloat y) {
		this.y = y;
	}
	public SVFloat getZ() {
		return z;
	}
	public void setZ(SVFloat z) {
		this.z = z;
	}
}
