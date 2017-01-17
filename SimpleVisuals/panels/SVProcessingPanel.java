package panels;

import java.awt.Dimension;

import javax.swing.JPanel;
import ProcessingJava.Sketch;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.ScrollPaneConstants;

public class SVProcessingPanel extends JPanel {
	private Sketch sketch;
	private boolean hasInit = false;
	private JScrollPane scrollPane;
	private JPanel panel;
	/**
	 * Create the panel.
	 */
	public SVProcessingPanel() {
		setPreferredSize(new Dimension(550, 550));
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(500,500));
		scrollPane = new JScrollPane( panel );
		add(scrollPane);
	}
	
	public void setSketch(Sketch s) {
		if (hasInit) {
			panel.remove(sketch.getCanvas());
		}
		sketch = s;
		panel.add(sketch.getCanvas());
		panel.setSize(new Dimension((int)sketch.size.x, (int)sketch.size.y));
		sketch.getSurface().startThread();
		hasInit = true;
	}
	
	public Sketch getSketch() {
		return sketch;
	}
}
