package com.eddie.test3;

import java.awt.*;

import javax.swing.*;

public class StepPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String step1 = "��� 1 : ������ ����� �������� ������� �� �����";
	
	public StepPanel() {
		JLabel label = new JLabel(step1);
		add(label, BorderLayout.CENTER);
	}

}
