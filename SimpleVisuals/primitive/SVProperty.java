package primitive;

public class SVProperty extends SVObject {
	protected boolean isNumberic = false;
	public boolean isNumberic() {
		return isNumberic;
	}
	public void setNumberic(boolean isNumberic) {
		this.isNumberic = isNumberic;
	}
	public SVProperty(String name) {
		super(name);
	}
	public String strValue() {
		return "";
	}
}
