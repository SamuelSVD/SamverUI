package panels;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTree;
import gui.ToolCellRenderer;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
public class SVToolsPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public SVToolsPanel() {
		setLayout(new BorderLayout(0, 0));
		JTree tree = new JTree();
		tree.setEditable(true);
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Simple") {
				{
					add(new DefaultMutableTreeNode("Line"));
					add(new DefaultMutableTreeNode("Ellipse"));
					add(new DefaultMutableTreeNode("Triangle"));
				}
			}
		));
		tree.setShowsRootHandles(true);
		tree.setCellRenderer(new ToolCellRenderer());
		add(tree);

	}

}
