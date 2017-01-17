package panels;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import processing.core.*;
import sketches.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SVMainPanel extends JPanel {
	private SVObjectPropertiesPanel objectProperties;
	private SVProjectTreeListPanel projectTreeList;
  private SVProcessingPanel processingPanel;
  private SVToolsPanel toolsPanel;
  private SVConsolePanel consolePanel;
  
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
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("New action");
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Open");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Open action");
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Save");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Save action");
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Save As..");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Save As... action");
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
}
}
