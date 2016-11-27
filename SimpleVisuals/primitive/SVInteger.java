package primitive;

public class SVInteger extends SVProperty {
	public void setValue(Object value) throws Exception {
		if ( value instanceof Integer ) {
			super.setValue(value);
		} else {
			throw new Exception("Invalid value. Expecting Integer, received " + value.getClass().getName());
		}
	}
	public SVInteger(String name) {
		super(name);
	  value = new Integer(0);
	}
}
