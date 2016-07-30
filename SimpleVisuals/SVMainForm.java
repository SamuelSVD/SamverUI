import panels.SVMainPanel;
import processing.core.*;

public class SVMainForm {

	public SVMainForm() {
	}

	public static void main(String[] args) {
		SVMainPanel mainPanel = new SVMainPanel();
	  String[] strings = {"Option1", "This is the class name", "arg1"};
	  PApplet.runSketch(strings, mainPanel);
	  mainPanel.getSurface().setTitle("Simple Visuals");
	  mainPanel.getSurface().setResizable(true);
	}
}
