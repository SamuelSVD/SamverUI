package primitive;

public class SVString extends SVProperty {
	protected String value;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public SVString(String name) {
		super(name);
	}

}
