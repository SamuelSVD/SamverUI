package primitive;

public class SVFloat extends SVProperty {
	protected float value = 0;
	public void setValue(Object value) throws Exception{
		if ( value instanceof Float ) {
			super.setValue(value);
		} else if ( value instanceof Integer ) {
			super.setValue(new Float((Integer)value));
		} else {
			throw new Exception("Invalid value. Expecting Float, received " + value.getClass().getName());
		}
	}
	public SVFloat(String name) {
		super(name);
		value = new Float(0);
	}
	
}
