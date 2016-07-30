package Utils;
import java.util.ArrayList;

import primitive.SVProperty;

public class SVPropertyList extends SVProperty {
	protected ArrayList<SVProperty> list;
	public SVPropertyList(String name) {
		super(name);
		list = new ArrayList<SVProperty>();
	}
	public ArrayList<SVProperty> getList() {
		return list;
	}
	public void setList(ArrayList<SVProperty> list) {
		this.list = list;
	}
	public void add(SVProperty property) {
		this.list.add(property);
	}
}
