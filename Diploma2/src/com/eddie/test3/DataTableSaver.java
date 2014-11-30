package com.eddie.test3;

import java.io.Serializable;

public class DataTableSaver implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String[] colName;
	private Double[][] data;
	
	public DataTableSaver(MyTableModel model) {
		this.colName = model.getColumn();
		this.data = model.toDoubleData();
	}
	
	public String[] getColName(){
		return colName;
	}
	
	public Double[][] getData(){
		return data;
	}

}
