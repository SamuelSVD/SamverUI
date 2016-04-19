package ProcessingJava;

import javax.swing.*;
public class MainDisplay extends JFrame{
	JPanel panel;
	Sketch sketch;
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
	  if(sketch == null) {
	    System.out.println('a');
	    sketch = s;
	    panel.add(s);
	    s.init();
	  }
	  else {
	    System.out.printf("b: %d", s.getVisualComponents().size());
	    for(VisualComponent component: s.getVisualComponents()) {
	      System.out.println('c');
	      sketch.addVisualComponent(component);
	    }
	  }
	}

}
