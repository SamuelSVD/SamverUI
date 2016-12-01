package panels;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.*;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import Utils.SVPropertyList;
import javax.swing.JScrollPane;

public class SVObjectPropertiesPanel extends JPanel {
	private JTable table;
  private PropertyTableModel model;
	/**
	 * Create the panel.
	 */
	public SVObjectPropertiesPanel() {
		setLayout(new BorderLayout(0, 0));
		model = new PropertyTableModel();
		table = new JTable(model);
		String [][] data = {{"A", "B"}};
		String [] columns = {"Column1", "Column2"};
		
//		table = new JTable(data, columns);
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);
		resizeColumnWidth(table);
		scrollPane.setPreferredSize(new Dimension(120,120));;
		scrollPane.setMinimumSize(new Dimension(50,50));
		setMinimumSize(new Dimension(50, 50));
	}
	public void resizeColumnWidth(JTable table) {
    final TableColumnModel columnModel = table.getColumnModel();
    for (int column = 0; column < table.getColumnCount(); column++) {
        int width = 15; // Min width
        for (int row = 0; row < table.getRowCount(); row++) {
            TableCellRenderer renderer = table.getCellRenderer(row, column);
            Component comp = table.prepareRenderer(renderer, row, column);
            width = Math.max(comp.getPreferredSize().width +1 , width);
        }
        if(width > 30)
            width=30;
        columnModel.getColumn(column).setPreferredWidth(width);
    }
	}
  public void SetProperties(SVPropertyList list) {
  	model.setPropertyList(list);
  }
  
  class PropertyTableModel extends AbstractTableModel {
  	private String[] columnNames = {"Property","Value"};
  	private Object[][] data = {{}};
  	private SVPropertyList list;
  	private boolean DEBUG = false;
  	public PropertyTableModel() {
  		list = new SVPropertyList("Temp");
  		for (int i = 0; i < columnNames.length; i++) {
  			
  		}
  	}
  	public int getColumnCount() {
  		return columnNames.length;
  	}
  	public int getRowCount() {
  		return list.getList().size();
  	}
  	public String getColumnName(int col) {
  		return columnNames[col];
  	}
  	public Object getValueAt(int row, int col) {
  		if (col == 0) {
  			System.out.println(row);
  			return list.getList().get(row).getName();
  		} else {
  			return list.getList().get(row).getValue();
  		}
  	}
  	public void setPropertyList(SVPropertyList list) {
  		emptyData();
  		this.list = list;
  	}
  	public void emptyData() {
  		Object [][] new_data = {{}};
  		data = new_data;
  	}
  	public Class getColumnClass(int c) {
  		return getValueAt(0, c).getClass();
  	}
  	public boolean isCellEditable(int row, int col) {
  		return col != 0;
  	}
  	public void setValueAt(Object value, int row, int col) {
  		if (DEBUG) {
  			System.out.println("Setting value at " + row + "," + col
  					+ " to " + value
  					+ " (an instance of "
  					+ value.getClass() + ")");
  		}
  		data[row][col] = value;
  		fireTableCellUpdated(row, col);
  		if (DEBUG) {
  			System.out.println("New value of data:");
  			printDebugData();
  		}
  	}
  	private void printDebugData() {
  		int numRows = getRowCount();
  		int numCols = getColumnCount();
  		for (int i=0; i < numRows; i++) {
  			System.out.print(" row " + i + ":");
  			for (int j=0; j < numCols; j++) {
  				System.out.print(" " + data[i][j]);
  			}
  			System.out.println();
  		}
  		System.out.println("--------------------------");
  	}
  }
}
