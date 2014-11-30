package com.eddie.test3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;

import java.util.*;

enum Variant{
	MIN, MAX, NOT_ENABLE;
}

public class ControlPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private boolean columnEnable[] = new boolean[10];
	
	private static Variant minMax[] = new Variant[]{ Variant.NOT_ENABLE, Variant.NOT_ENABLE, Variant.NOT_ENABLE,
													 Variant.NOT_ENABLE, Variant.NOT_ENABLE, Variant.NOT_ENABLE,
													 Variant.NOT_ENABLE, Variant.NOT_ENABLE, Variant.NOT_ENABLE,
													 Variant.NOT_ENABLE };
	
	private static ArrayList<ButtonGroup>	buttonGroup 	= new ArrayList<ButtonGroup>();
	private static ArrayList<JRadioButton>  radioButtonMax 	= new ArrayList<JRadioButton>();
	private static ArrayList<JRadioButton>  radioButtonMin 	= new ArrayList<JRadioButton>();
	
	public ControlPanel() {
		
		setBorder(new TitledBorder(new LineBorder(new Color(255, 0, 255)), "Control", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 11};
		gbl_panel.rowHeights = new int[] {0, 0, 0, 0, 3};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gbl_panel);
		
		//creating labels, radioButtons and checkBoxes
		createLabelsPanelColumnNames();
		createLabelsPanelRowNames();
		createRadioButtons();
		createCheckBoxes();

	} //constructor
	
	private void createLabelsPanelRowNames() {
		String[] rowsName = {"Max", "Min", "Enabled"};
		for(int i = 1; i <= 3; i++){
			final JLabel label = new JLabel(rowsName[i-1]);
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.EAST;
			gbc.insets = new Insets(0, 0, 5, 5);
			gbc.gridx = 0;
			gbc.gridy = i;
			add(label, gbc); 
		}
		
	}

	private void createLabelsPanelColumnNames(){
		for(int i = 1; i <= 10; i++){
			JLabel label = new JLabel("K" + i);
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.insets = new Insets(0, 0, 5, 5);
			gbc_label.gridx = i;
			gbc_label.gridy = 0;
			add(label, gbc_label);
		}
	}
	
	public  boolean[] getEnable(){
		return columnEnable;
	}
	
	public Variant[] getVariant(){
		this.initDefaultMinMax();
		return minMax;
	}
	
	private void initDefaultMinMax(){
		int index = 0;
		for(boolean s : columnEnable){
			if(s){
				if(radioButtonMax.get(index).isSelected()) minMax[index++] = Variant.MAX;
				else minMax[index++] = Variant.MIN;
			} else {
				minMax[index++] = Variant.NOT_ENABLE;
			}
		}
	}
	
	private void createRadioButtons(){
		for(int row = 0; row < 2; row++)
			for(int col = 0; col < 10; col++){
				JRadioButton radio = new JRadioButton("");
				radio.setEnabled(false);
				if(row == 0) buttonGroup.add(new ButtonGroup());
				buttonGroup.get(col).add(radio);
				GridBagConstraints gbc_radioButton = new GridBagConstraints();
				gbc_radioButton.insets = new Insets(0, 0, 5, 5);
				gbc_radioButton.gridx = col+1;
				gbc_radioButton.gridy = row +1;
				add(radio, gbc_radioButton);
				if(row == 1) radioButtonMax.add(radio);
				else radioButtonMin.add(radio);
			}
	}
	
	private void createCheckBoxes(){
		for(int i = 0; i < 10; i++){
			final int j = i;	
			final JCheckBox checkBox = new JCheckBox("");
			GridBagConstraints gbc_checkBox_9 = new GridBagConstraints();
			gbc_checkBox_9.insets = new Insets(0, 0, 0, 5);
			gbc_checkBox_9.gridx = i+1;
			gbc_checkBox_9.gridy = 3;
			add(checkBox, gbc_checkBox_9);
			checkBox.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
				
					setColumnEnable( j ,checkBox.isSelected());
					if(getColumnEnable(j)){
						radioButtonMax.get(j).setEnabled(true);
						radioButtonMin.get(j).setEnabled(true);
					} else {
						radioButtonMax.get(j).setEnabled(false);
						radioButtonMin.get(j).setEnabled(false);
						minMax[j] = Variant.NOT_ENABLE;
					}
			    } 	// method
			});		// annanymus class
		}
	}

	
	public void setColumnEnable(int index, boolean bool){
		columnEnable[index] = bool;
	}
	
	public boolean getColumnEnable(int index){
		return columnEnable[index];
	}

}
