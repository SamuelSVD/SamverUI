package gui;

import primitive.SVString;
import processing.core.PGraphics;

public class SVEditBox extends SVComponent {
	protected SVText caption;
	public SVEditBox() {
		caption = new SVText();
		caption.setSize(size.getWidth(), size.getHeight());
	}

	@Override
	public void draw(PGraphics graphics) {
		graphics.fill(255);
		graphics.rect(0, 0, size.getWidth(), size.getHeight());
		graphics.fill(0);
		caption.draw(graphics);
	}

}
