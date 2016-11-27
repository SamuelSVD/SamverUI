package panels;

import javax.swing.JPanel;
import javax.swing.JTree;
import java.awt.BorderLayout;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;

public class SVProjectTreeListPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public SVProjectTreeListPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JTree tree = new JTree();
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Project") {
				{
					add(new DefaultMutableTreeNode("Background"));
					add(new DefaultMutableTreeNode("RussianDoll"));
				}
			}
		));
		add(tree, BorderLayout.CENTER);

	}

}
