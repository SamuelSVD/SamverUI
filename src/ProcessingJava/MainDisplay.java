package ProcessingJava;

import javax.swing.*;
public class MainDisplay extends JFrame{
	JPanel panel;
	static int MIN_SIZE = 150;
	public MainDisplay(int x, int y) {
	  if (x < MIN_SIZE) x = MIN_SIZE;
	  if (y < MIN_SIZE) y = MIN_SIZE;
		this.setSize(x+28,y+50);
		this.setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setBounds(5,0,x,y);
		this.add(panel);
	}
	public void addSketch(Sketch s) {
		panel.add(s);
		s.init();
	}

}
