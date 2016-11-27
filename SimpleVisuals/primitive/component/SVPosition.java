package primitive.component;

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
		return (float)x.getValue();
	}
	public void setX(float x) {
		try {
			this.x.setValue(x);
		} catch (Exception e) {
		}
	}
	public float getY() {
		return (float)y.getValue();
	}
	public void setY(float y) {
		try {
			this.y.setValue(y);
		} catch (Exception e) {
		}
	}
	public float getZ() {
		return (float)z.getValue();
	}
	public void setZ(float z) {
	  try {
		this.z.setValue(z);
	  } catch (Exception e) {
	  }
	}
}
