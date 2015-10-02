import ProcessingJava.*;
public class Main {
	public static void main(String[] args) {
	  int size = 500;
		MainDisplay mainDisplay = new MainDisplay(size,size);
		mainDisplay.addSketch(new SimpleSketch(size, size));
		mainDisplay.setVisible(true);
	}
}
