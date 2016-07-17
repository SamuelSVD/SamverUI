package Primitives;

public class SVInteger extends SVProperty {
	protected int value = 0;
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public SVInteger(String name) {
		super(name);
	}
}
