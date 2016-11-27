package gui;

import java.awt.Component;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;
import component.SVTool;

public class ToolCellRenderer implements TreeCellRenderer {
	SVToolPanel toolPanel;
	DefaultTreeCellRenderer defaultPanel;
	public ToolCellRenderer() {
		toolPanel = new SVToolPanel();
		defaultPanel = new DefaultTreeCellRenderer();
	}

	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
		// TODO Auto-generated method stub
		Component returnValue = null;
		if ((value != null) && (value instanceof DefaultMutableTreeNode)) {
			Object userObject = ((DefaultMutableTreeNode) value).getUserObject();
			if (userObject instanceof SVTool) {
				SVTool tool = (SVTool) userObject;
				toolPanel.setEnabled(tree.isEnabled());
				toolPanel.label.setText(tool.name);
				returnValue = toolPanel;
			}
		}
		if (returnValue == null) {
			returnValue = defaultPanel.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
		}
		return returnValue;
	}
}
