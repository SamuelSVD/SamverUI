package gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;

public class SVToolPanel extends JPanel {
	JLabel label;
	/**
	 * Create the panel.
	 */
	public SVToolPanel() {
		setLayout(new BorderLayout(0, 0));
		
		label = new JLabel("Label");
		add(label, BorderLayout.CENTER);

	}

}
