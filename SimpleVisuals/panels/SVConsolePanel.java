package panels;

import javax.swing.JPanel;
import javax.swing.JEditorPane;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class SVConsolePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public SVConsolePanel() {
		setLayout(new BorderLayout(0, 0));
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		add(editorPane);
		setMinimumSize(new Dimension(100,50));
	}

}
