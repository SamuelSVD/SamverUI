package component;

import primitive.SVPropertyList;

public class SVArea extends SVPropertyList {
	public SVPosition position;
	public SVSize size;
	public SVArea(String name) {
		super(name);
		list.add(position = new SVPosition());
		list.add(size = new SVSize());
	}
}
