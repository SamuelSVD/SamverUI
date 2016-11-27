package primitive;

public class SVObject {
	protected String name;
	protected Object value;
	public SVObject(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) throws Exception {
		this.value = value;
	}
}
