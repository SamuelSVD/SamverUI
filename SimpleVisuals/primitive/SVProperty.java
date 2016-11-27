package primitive;

public class SVProperty extends SVObject {
	protected boolean isNumeric = false;
	public boolean isNumeric() {
		return isNumeric;
	}
	public void setNumeric(boolean isNumeric) {
		this.isNumeric = isNumeric;
	}
	public SVProperty(String name) {
		super(name);
	}
	public String strValue() {
		return "";
	}
}
