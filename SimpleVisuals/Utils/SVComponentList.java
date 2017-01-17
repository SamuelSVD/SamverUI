package Utils;

import java.util.ArrayList;
import processing.core.*;
import gui.SVComponent;
import primitive.SVProperty;

public class SVComponentList extends SVComponent {
  SVContainer container;
	protected ArrayList<SVComponent> list;
	public SVComponentList() {
		super();
		list = new ArrayList<SVComponent>();
	}
	public ArrayList<SVComponent> getList() {
		return list;
	}
	public void setList(ArrayList<SVComponent> list) {
		this.list = list;
	}
	public void add(SVComponent component) {
		this.list.add(component);
		container.
	}
	@Override
	public void draw(PGraphics graphics) {
		for(int i = 0; i < list.size(); i++) {
			list.get(i).doDraw(graphics);
		}
	}
	
	public void setContainer(SVContainer container) {
		this.container = container;
	}
}
