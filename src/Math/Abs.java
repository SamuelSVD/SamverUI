package Math;

public class Abs extends Function {

	public Abs() {
		// TODO Auto-generated constructor stub
	}

	public Abs(double x_multiple) {
		super(x_multiple);
		// TODO Auto-generated constructor stub
	}

	public Abs(double x_offset, double y_offset) {
		super(x_offset, y_offset);
		// TODO Auto-generated constructor stub
	}

	public Abs(double x_offset, double y_offset, double x_multiple) {
		super(x_offset, y_offset, x_multiple);
		// TODO Auto-generated constructor stub
	}

	public Abs(double x_offset, double y_offset, double x_multiple, double y_multiple) {
		super(x_offset, y_offset, x_multiple, y_multiple);
		// TODO Auto-generated constructor stub
	}

	public Abs(Function fun) {
		super(fun);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double evaluateDefaultAt(double t) {
		if (t < 0) return t;
		else return -t;
	}

	@Override
	public double evaluateDerivativeAt(double t) {
		// TODO Auto-generated method stub
		return 0;
	}

}
