package primitive;

public class SVFloat extends SVProperty {
	protected float value = 0;
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	public SVFloat(String name) {
		super(name);
	}
	
}
