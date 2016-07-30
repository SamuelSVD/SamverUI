package gui;

import primitive.*;
import processing.core.*;

public class SVButton extends SVComponent {
	protected SVText caption;
	public SVButton() {
		setSize(50,20);
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
