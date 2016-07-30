package gui;

import primitive.SVString;
import processing.core.*;
import java.awt.Font;
public class SVText extends SVComponent {
	SVString caption;
	PFont font;
	public SVText() {
		caption = new SVString("Caption");
		caption.setValue("Caption");
		//font = new PFont(new Font("Arial",Font.PLAIN, 16), true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(PGraphics graphics) {
		graphics.textAlign(PApplet.CENTER, PApplet.CENTER);
		graphics.text(caption.getValue(), 0, 0, size.getWidth(), size.getHeight());
	}

}
