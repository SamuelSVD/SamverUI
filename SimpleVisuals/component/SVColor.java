package component;

import Utils.SVPropertyList;
import primitive.SVFloat;

public class SVColor extends SVPropertyList {
	protected SVFloat first;
	protected SVFloat second;
	protected SVFloat third;
	protected SVFloat alpha;
	public SVColor() {
		super("Color");
		first = new SVFloat("First");
		second = new SVFloat("Second");
		third = new SVFloat("Third");
		alpha = new SVFloat("Alpha");
		list.add(first);
		list.add(second);
		list.add(third);
		list.add(alpha);
	}
}
