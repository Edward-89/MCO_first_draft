package com.eddie.test3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;
import java.util.*;

public class ControlPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final ButtonGroup buttonGroup_0 = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private final ButtonGroup buttonGroup_3 = new ButtonGroup();
	private final ButtonGroup buttonGroup_4 = new ButtonGroup();
	private final ButtonGroup buttonGroup_5 = new ButtonGroup();
	private final ButtonGroup buttonGroup_6 = new ButtonGroup();
	private final ButtonGroup buttonGroup_7 = new ButtonGroup();
	private final ButtonGroup buttonGroup_8 = new ButtonGroup();
	private final ButtonGroup buttonGroup_9 = new ButtonGroup();
	
	private static boolean columEnable[] = new boolean[10];
	public enum Variant{
		MIN, MAX, NOT_ENABLE;
	}
	private static Variant minMax[] = new Variant[]{Variant.NOT_ENABLE,Variant.NOT_ENABLE,Variant.NOT_ENABLE,
													Variant.NOT_ENABLE,Variant.NOT_ENABLE,Variant.NOT_ENABLE,
													Variant.NOT_ENABLE,Variant.NOT_ENABLE,Variant.NOT_ENABLE,
													Variant.NOT_ENABLE};
	private static ArrayList<JRadioButton> radioButtonMax = new ArrayList<JRadioButton>();
	private static ArrayList<JRadioButton> radioButtonMin = new ArrayList<JRadioButton>();
	
	
	
	public ControlPanel() {
		
		setBorder(new TitledBorder(new LineBorder(new Color(255, 0, 255)), "Control", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 11};
		gbl_panel.rowHeights = new int[] {0, 0, 0, 0, 3};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gbl_panel);
		
		//rows JLabel
		
		JLabel label = new JLabel("K1");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 0;
		add(label, gbc_label);
		
		JLabel label_1 = new JLabel("K2");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 2;
		gbc_label_1.gridy = 0;
		add(label_1, gbc_label_1);
		
		JLabel label_2 = new JLabel("K3");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 3;
		gbc_label_2.gridy = 0;
		add(label_2, gbc_label_2);
		
		JLabel label_3 = new JLabel("K4");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 4;
		gbc_label_3.gridy = 0;
		add(label_3, gbc_label_3);
		
		JLabel label_4 = new JLabel("K5");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 5;
		gbc_label_4.gridy = 0;
		add(label_4, gbc_label_4);
		
		JLabel label_5 = new JLabel("K6");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 6;
		gbc_label_5.gridy = 0;
		add(label_5, gbc_label_5);
		
		JLabel label_6 = new JLabel("K7");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 7;
		gbc_label_6.gridy = 0;
		add(label_6, gbc_label_6);
		
		JLabel label_7 = new JLabel("K8");
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.insets = new Insets(0, 0, 5, 5);
		gbc_label_7.gridx = 8;
		gbc_label_7.gridy = 0;
		add(label_7, gbc_label_7);
		
		JLabel label_8 = new JLabel("K9");
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.insets = new Insets(0, 0, 5, 5);
		gbc_label_8.gridx = 9;
		gbc_label_8.gridy = 0;
		add(label_8, gbc_label_8);
		
		JLabel label_9 = new JLabel("K10");
		GridBagConstraints gbc_label_9 = new GridBagConstraints();
		gbc_label_9.insets = new Insets(0, 0, 5, 5);
		gbc_label_9.gridx = 10;
		gbc_label_9.gridy = 0;
		add(label_9, gbc_label_9);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 11;
		gbc_verticalStrut.gridy = 0;
		add(verticalStrut, gbc_verticalStrut);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 12;
		gbc_horizontalStrut.gridy = 0;
		add(horizontalStrut, gbc_horizontalStrut);
		
		JLabel lblNewLabel = new JLabel("Max");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		lblNewLabel.setToolTipText("Это максимум");
		
		final JRadioButton radioMax_1 = new JRadioButton("");
		radioMax_1.setEnabled(false);
		buttonGroup_0.add(radioMax_1);
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton.gridx = 1;
		gbc_rdbtnNewRadioButton.gridy = 1;
		add(radioMax_1, gbc_rdbtnNewRadioButton);
		radioButtonMax.add(radioMax_1);
		
		final JRadioButton radioMax_2 = new JRadioButton("");
		radioMax_2.setEnabled(false);
		buttonGroup_1.add(radioMax_2);
		GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_1.gridx = 2;
		gbc_rdbtnNewRadioButton_1.gridy = 1;
		add(radioMax_2, gbc_rdbtnNewRadioButton_1);
		radioButtonMax.add(radioMax_2);
		
		final JRadioButton radioMax_3 = new JRadioButton("");
		radioMax_3.setEnabled(false);
		buttonGroup_2.add(radioMax_3);
		GridBagConstraints gbc_rdbtnNewRadioButton_2 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_2.gridx = 3;
		gbc_rdbtnNewRadioButton_2.gridy = 1;
		add(radioMax_3, gbc_rdbtnNewRadioButton_2);
		radioButtonMax.add(radioMax_3);
		
		final JRadioButton radioMax_4 = new JRadioButton("");
		radioMax_4.setEnabled(false);
		buttonGroup_3.add(radioMax_4);
		GridBagConstraints gbc_rdbtnNewRadioButton_3 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_3.gridx = 4;
		gbc_rdbtnNewRadioButton_3.gridy = 1;
		add(radioMax_4, gbc_rdbtnNewRadioButton_3);
		radioButtonMax.add(radioMax_4);
		
		final JRadioButton radioMax_5 = new JRadioButton("");
		radioMax_5.setEnabled(false);
		buttonGroup_4.add(radioMax_5);
		GridBagConstraints gbc_rdbtnNewRadioButton_4 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_4.gridx = 5;
		gbc_rdbtnNewRadioButton_4.gridy = 1;
		add(radioMax_5, gbc_rdbtnNewRadioButton_4);
		radioButtonMax.add(radioMax_5);
		
		final JRadioButton radioMax_6 = new JRadioButton("");
		radioMax_6.setEnabled(false);
		buttonGroup_5.add(radioMax_6);
		GridBagConstraints gbc_rdbtnNewRadioButton_5 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_5.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_5.gridx = 6;
		gbc_rdbtnNewRadioButton_5.gridy = 1;
		add(radioMax_6, gbc_rdbtnNewRadioButton_5);
		radioButtonMax.add(radioMax_6);
		
		final JRadioButton radioMax_7 = new JRadioButton("");
		radioMax_7.setEnabled(false);
		buttonGroup_6.add(radioMax_7);
		GridBagConstraints gbc_rdbtnNewRadioButton_6 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_6.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_6.gridx = 7;
		gbc_rdbtnNewRadioButton_6.gridy = 1;
		add(radioMax_7, gbc_rdbtnNewRadioButton_6);
		radioButtonMax.add(radioMax_7);
		
		final JRadioButton radioMax_8 = new JRadioButton("");
		radioMax_8.setEnabled(false);
		buttonGroup_7.add(radioMax_8);
		GridBagConstraints gbc_radioButton = new GridBagConstraints();
		gbc_radioButton.insets = new Insets(0, 0, 5, 5);
		gbc_radioButton.gridx = 8;
		gbc_radioButton.gridy = 1;
		add(radioMax_8, gbc_radioButton);
		radioButtonMax.add(radioMax_8);
		
		final JRadioButton radioMax_9 = new JRadioButton("");
		radioMax_9.setEnabled(false);
		buttonGroup_8.add(radioMax_9);
		GridBagConstraints gbc_radioButton_1 = new GridBagConstraints();
		gbc_radioButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_radioButton_1.gridx = 9;
		gbc_radioButton_1.gridy = 1;
		add(radioMax_9, gbc_radioButton_1);
		radioButtonMax.add(radioMax_9);
		
		final JRadioButton radioMax_10 = new JRadioButton("");
		radioMax_10.setEnabled(false);
		buttonGroup_9.add(radioMax_10);
		GridBagConstraints gbc_radioButton_2 = new GridBagConstraints();
		gbc_radioButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_radioButton_2.gridx = 10;
		gbc_radioButton_2.gridy = 1;
		add(radioMax_10, gbc_radioButton_2);
		radioButtonMax.add(radioMax_10);
		
		final JLabel lblMin = new JLabel("Min");
		GridBagConstraints gbc_lblMin = new GridBagConstraints();
		gbc_lblMin.anchor = GridBagConstraints.EAST;
		gbc_lblMin.insets = new Insets(0, 0, 5, 5);
		gbc_lblMin.gridx = 0;
		gbc_lblMin.gridy = 2;
		add(lblMin, gbc_lblMin);
		
		final JRadioButton radioMin_1 = new JRadioButton("");
		radioMin_1.setEnabled(false);
		buttonGroup_0.add(radioMin_1);
		GridBagConstraints gbc_radioButton_3 = new GridBagConstraints();
		gbc_radioButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_radioButton_3.gridx = 1;
		gbc_radioButton_3.gridy = 2;
		add(radioMin_1, gbc_radioButton_3);
		radioButtonMin.add(radioMin_1);
		
		final JRadioButton radioMin_2 = new JRadioButton("");
		radioMin_2.setEnabled(false);
		buttonGroup_1.add(radioMin_2);
		GridBagConstraints gbc_radioButton_4 = new GridBagConstraints();
		gbc_radioButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_radioButton_4.gridx = 2;
		gbc_radioButton_4.gridy = 2;
		add(radioMin_2, gbc_radioButton_4);
		radioButtonMin.add(radioMin_2);
		
		final JRadioButton radioMin_3 = new JRadioButton("");
		radioMin_3.setEnabled(false);
		buttonGroup_2.add(radioMin_3);
		GridBagConstraints gbc_radioButton_5 = new GridBagConstraints();
		gbc_radioButton_5.insets = new Insets(0, 0, 5, 5);
		gbc_radioButton_5.gridx = 3;
		gbc_radioButton_5.gridy = 2;
		add(radioMin_3, gbc_radioButton_5);
		radioButtonMin.add(radioMin_3);
		
		final JRadioButton radioMin_4 = new JRadioButton("");
		radioMin_4.setEnabled(false);
		buttonGroup_3.add(radioMin_4);
		GridBagConstraints gbc_radioButton_6 = new GridBagConstraints();
		gbc_radioButton_6.insets = new Insets(0, 0, 5, 5);
		gbc_radioButton_6.gridx = 4;
		gbc_radioButton_6.gridy = 2;
		add(radioMin_4, gbc_radioButton_6);
		radioButtonMin.add(radioMin_4);
		
		final JRadioButton radioMin_5 = new JRadioButton("");
		radioMin_5.setEnabled(false);
		buttonGroup_4.add(radioMin_5);
		GridBagConstraints gbc_radioButton_7 = new GridBagConstraints();
		gbc_radioButton_7.insets = new Insets(0, 0, 5, 5);
		gbc_radioButton_7.gridx = 5;
		gbc_radioButton_7.gridy = 2;
		add(radioMin_5, gbc_radioButton_7);
		radioButtonMin.add(radioMin_5);
		
		final JRadioButton radioMin_6 = new JRadioButton("");
		radioMin_6.setEnabled(false);
		buttonGroup_5.add(radioMin_6);
		GridBagConstraints gbc_radioButton_8 = new GridBagConstraints();
		gbc_radioButton_8.insets = new Insets(0, 0, 5, 5);
		gbc_radioButton_8.gridx = 6;
		gbc_radioButton_8.gridy = 2;
		add(radioMin_6, gbc_radioButton_8);
		radioButtonMin.add(radioMin_6);
		
		final JRadioButton radioMin_7 = new JRadioButton("");
		radioMin_7.setEnabled(false);
		buttonGroup_6.add(radioMin_7);
		GridBagConstraints gbc_radioButton_9 = new GridBagConstraints();
		gbc_radioButton_9.insets = new Insets(0, 0, 5, 5);
		gbc_radioButton_9.gridx = 7;
		gbc_radioButton_9.gridy = 2;
		add(radioMin_7, gbc_radioButton_9);
		radioButtonMin.add(radioMin_7);
		
		final JRadioButton radioMin_8 = new JRadioButton("");
		radioMin_8.setEnabled(false);
		buttonGroup_7.add(radioMin_8);
		GridBagConstraints gbc_radioButton_10 = new GridBagConstraints();
		gbc_radioButton_10.insets = new Insets(0, 0, 5, 5);
		gbc_radioButton_10.gridx = 8;
		gbc_radioButton_10.gridy = 2;
		add(radioMin_8, gbc_radioButton_10);
		radioButtonMin.add(radioMin_8);
		
		final JRadioButton radioMin_9 = new JRadioButton("");
		radioMin_9.setEnabled(false);
		buttonGroup_8.add(radioMin_9);
		GridBagConstraints gbc_radioButton_11 = new GridBagConstraints();
		gbc_radioButton_11.insets = new Insets(0, 0, 5, 5);
		gbc_radioButton_11.gridx = 9;
		gbc_radioButton_11.gridy = 2;
		add(radioMin_9, gbc_radioButton_11);
		radioButtonMin.add(radioMin_9);
		
		final JRadioButton radioMin_10 = new JRadioButton("");
		radioMin_10.setEnabled(false);
		buttonGroup_9.add(radioMin_10);
		GridBagConstraints gbc_radioButton_12 = new GridBagConstraints();
		gbc_radioButton_12.insets = new Insets(0, 0, 5, 5);
		gbc_radioButton_12.gridx = 10;
		gbc_radioButton_12.gridy = 2;
		add(radioMin_10, gbc_radioButton_12);
		radioButtonMin.add(radioMin_10);
		
		final JLabel lblEnabled = new JLabel("Enabled");
		GridBagConstraints gbc_lblEnabled = new GridBagConstraints();
		gbc_lblEnabled.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblEnabled.insets = new Insets(0, 0, 0, 5);
		gbc_lblEnabled.gridx = 0;
		gbc_lblEnabled.gridy = 3;
		add(lblEnabled, gbc_lblEnabled);
		
		final JCheckBox checkBox_0 = new JCheckBox("");
		GridBagConstraints gbc_checkBox = new GridBagConstraints();
		gbc_checkBox.insets = new Insets(0, 0, 0, 5);
		gbc_checkBox.gridx = 1;
		gbc_checkBox.gridy = 3;
		add(checkBox_0, gbc_checkBox);
		checkBox_0.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				columEnable[0] = checkBox_0.isSelected();
				if(columEnable[0]){
					radioMax_1.setEnabled(true);
					radioMin_1.setEnabled(true);
				} else {
					radioMax_1.setEnabled(false);
					radioMin_1.setEnabled(false);
					minMax[0] = Variant.NOT_ENABLE;
				}
				
			}
		});
		
		final JCheckBox checkBox_1 = new JCheckBox("");
		GridBagConstraints gbc_checkBox_1 = new GridBagConstraints();
		gbc_checkBox_1.insets = new Insets(0, 0, 0, 5);
		gbc_checkBox_1.gridx = 2;
		gbc_checkBox_1.gridy = 3;
		add(checkBox_1, gbc_checkBox_1);
		checkBox_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				columEnable[1] = checkBox_1.isSelected();
				if(columEnable[1]){
					radioMax_2.setEnabled(true);
					radioMin_2.setEnabled(true);
				} else {
					radioMax_2.setEnabled(false);
					radioMin_2.setEnabled(false);
					minMax[1] = Variant.NOT_ENABLE;
				}
				
			}
		});
		
		final JCheckBox checkBox_2 = new JCheckBox("");
		GridBagConstraints gbc_checkBox_2 = new GridBagConstraints();
		gbc_checkBox_2.insets = new Insets(0, 0, 0, 5);
		gbc_checkBox_2.gridx = 3;
		gbc_checkBox_2.gridy = 3;
		add(checkBox_2, gbc_checkBox_2);
		checkBox_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				columEnable[2] = checkBox_2.isSelected();
				if(columEnable[2]){
					radioMax_3.setEnabled(true);
					radioMin_3.setEnabled(true);
				} else {
					radioMax_3.setEnabled(false);
					radioMin_3.setEnabled(false);
					minMax[2] = Variant.NOT_ENABLE;
				}
				
			}
		});
		
		final JCheckBox checkBox_3 = new JCheckBox("");
		GridBagConstraints gbc_checkBox_3 = new GridBagConstraints();
		gbc_checkBox_3.insets = new Insets(0, 0, 0, 5);
		gbc_checkBox_3.gridx = 4;
		gbc_checkBox_3.gridy = 3;
		add(checkBox_3, gbc_checkBox_3);
		checkBox_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				columEnable[3] = checkBox_3.isSelected();
				if(columEnable[3]){
					radioMax_4.setEnabled(true);
					radioMin_4.setEnabled(true);
				} else {
					radioMax_4.setEnabled(false);
					radioMin_4.setEnabled(false);
					minMax[3] = Variant.NOT_ENABLE;
				}
				
			}
		});
		
		final JCheckBox checkBox_4 = new JCheckBox("");
		GridBagConstraints gbc_checkBox_4 = new GridBagConstraints();
		gbc_checkBox_4.insets = new Insets(0, 0, 0, 5);
		gbc_checkBox_4.gridx = 5;
		gbc_checkBox_4.gridy = 3;
		add(checkBox_4, gbc_checkBox_4);
		checkBox_4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				columEnable[4] = checkBox_4.isSelected();
				if(columEnable[4]){
					radioMax_5.setEnabled(true);
					radioMin_5.setEnabled(true);
				} else {
					radioMax_5.setEnabled(false);
					radioMin_5.setEnabled(false);
					minMax[4] = Variant.NOT_ENABLE;
				}
				
			}
		});
		
		final JCheckBox checkBox_5 = new JCheckBox("");
		GridBagConstraints gbc_checkBox_5 = new GridBagConstraints();
		gbc_checkBox_5.insets = new Insets(0, 0, 0, 5);
		gbc_checkBox_5.gridx = 6;
		gbc_checkBox_5.gridy = 3;
		add(checkBox_5, gbc_checkBox_5);
		checkBox_5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				columEnable[5] = checkBox_5.isSelected();
				if(columEnable[5]){
					radioMax_6.setEnabled(true);
					radioMin_6.setEnabled(true);
				} else {
					radioMax_6.setEnabled(false);
					radioMin_6.setEnabled(false);
					minMax[5] = Variant.NOT_ENABLE;
				}
				
			}
		});
		
		final JCheckBox checkBox_6 = new JCheckBox("");
		GridBagConstraints gbc_checkBox_6 = new GridBagConstraints();
		gbc_checkBox_6.insets = new Insets(0, 0, 0, 5);
		gbc_checkBox_6.gridx = 7;
		gbc_checkBox_6.gridy = 3;
		add(checkBox_6, gbc_checkBox_6);
		checkBox_6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				columEnable[6] = checkBox_6.isSelected();
				if(columEnable[6]){
					radioMax_7.setEnabled(true);
					radioMin_7.setEnabled(true);
				} else {
					radioMax_7.setEnabled(false);
					radioMin_7.setEnabled(false);
					minMax[6] = Variant.NOT_ENABLE;
				}
				
			}
		});
		
		final JCheckBox checkBox_7 = new JCheckBox("");
		GridBagConstraints gbc_checkBox_7 = new GridBagConstraints();
		gbc_checkBox_7.insets = new Insets(0, 0, 0, 5);
		gbc_checkBox_7.gridx = 8;
		gbc_checkBox_7.gridy = 3;
		add(checkBox_7, gbc_checkBox_7);
		checkBox_7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				columEnable[7] = checkBox_7.isSelected();
				if(columEnable[7]){
					radioMax_8.setEnabled(true);
					radioMin_8.setEnabled(true);
				} else {
					radioMax_8.setEnabled(false);
					radioMin_8.setEnabled(false);
					minMax[7] = Variant.NOT_ENABLE;
				}
				
			}
		});
		
		final JCheckBox checkBox_8 = new JCheckBox("");
		GridBagConstraints gbc_checkBox_8 = new GridBagConstraints();
		gbc_checkBox_8.insets = new Insets(0, 0, 0, 5);
		gbc_checkBox_8.gridx = 9;
		gbc_checkBox_8.gridy = 3;
		add(checkBox_8, gbc_checkBox_8);
		checkBox_8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				columEnable[8] = checkBox_8.isSelected();
				if(columEnable[8]){
					radioMax_9.setEnabled(true);
					radioMin_9.setEnabled(true);
				} else {
					radioMax_9.setEnabled(false);
					radioMin_9.setEnabled(false);
					minMax[8] = Variant.NOT_ENABLE;
				}
				
			}
		});
		
		final JCheckBox checkBox_9 = new JCheckBox("");
		GridBagConstraints gbc_checkBox_9 = new GridBagConstraints();
		gbc_checkBox_9.insets = new Insets(0, 0, 0, 5);
		gbc_checkBox_9.gridx = 10;
		gbc_checkBox_9.gridy = 3;
		add(checkBox_9, gbc_checkBox_9);
		checkBox_9.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				columEnable[9] = checkBox_9.isSelected();
				if(columEnable[9]){
					radioMax_10.setEnabled(true);
					radioMin_10.setEnabled(true);
				} else {
					radioMax_10.setEnabled(false);
					radioMin_10.setEnabled(false);
					minMax[9] = Variant.NOT_ENABLE;
				}
				
			}
		});
		
		

	}
	
	
	public static  boolean[] getEnable(){
		return columEnable;
	}
	
	public static Variant[] getVariant(){
		initDefaultMinMax();
		return minMax;
	}
	
	public static void initDefaultMinMax(){
		int index = 0;
		for(boolean s : columEnable){
			if(s){
				if(radioButtonMax.get(index).isSelected()) minMax[index++] = Variant.MAX;
				else minMax[index++] = Variant.MIN;
			} else {
				minMax[index++] = Variant.NOT_ENABLE;
			}
		}
	}

}
