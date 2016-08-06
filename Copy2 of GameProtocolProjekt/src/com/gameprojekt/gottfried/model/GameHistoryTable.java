package com.gameprojekt.gottfried.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class GameHistoryTable extends AbstractTableModel {
	public static final long serialVersionUID = 1001;
	// String array with table headers.
	private String[] headers = Name.ENTRIES;

	// The table is a List of Lists.
	private List<List<String>> data;

	// Construct a new table by creating a List (table) which can contain other
	// Lists (rows) which
	// contains five Strings (cells) each.
	public GameHistoryTable() {
		data = new ArrayList<List<String>>();
	}

	// Clear the table
	public void clear() {
		data = new ArrayList<List<String>>();
	}

	// This method takes a list of strings (compiled bet data from the API) and
	// adds it as a row in the table.
	public int addData(List<String> row) {
		if (row.size() == headers.length) {
			data.add(row);
		}
		return data.size() - 1;
	}

	// Required when inheriting the AbstractTableModel
	public int getRowCount() {
		return data.size();
	}

	public String getColumnName(int col) {
		return headers[col];
	}

	// Required when inheriting the AbstractTableModel
	public int getColumnCount() {
		return headers.length;
	}

	// Required when inheriting the AbstractTableModel
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data.get(rowIndex).get(columnIndex);
	}

}
