package panels;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class SVMainPanel extends JPanel {
	private SVObjectPropertiesPanel objectProperties;
	private SVProjectTreeListPanel projectTreeList;
  private SVProcessingPanel processingPanel;
  private SVToolsPanel toolsPanel;
  private SVConsolePanel consolePanel;
  /**
	 * Create the panel.
	 */
	public SVMainPanel() {
		
		objectProperties = new SVObjectPropertiesPanel();
		setLayout(new BorderLayout(0, 0));
		projectTreeList = new SVProjectTreeListPanel();
		processingPanel = new SVProcessingPanel();
		JSplitPane leftPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, projectTreeList, objectProperties);
		
		toolsPanel = new SVToolsPanel();
		consolePanel = new SVConsolePanel();
		JSplitPane centerPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPane, processingPanel);
		JSplitPane lastPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, centerPane, toolsPanel);
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.add("Console",  consolePanel);
		JSplitPane oneMorePane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, lastPane, tabbedPane);
		add(oneMorePane);
		
		JMenuBar menuBar = new JMenuBar();
		add(menuBar, BorderLayout.NORTH);
		
		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("New menu");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("New menu item");
		mnNewMenu_1.add(mntmNewMenuItem_2);
	}

}
