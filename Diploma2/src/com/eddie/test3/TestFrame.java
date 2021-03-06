package com.eddie.test3;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import java.io.File;
import java.util.*;

public class TestFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton btnNewButton ;
	private JButton btnNewButton_1 ;
	private JButton btnNewButton_2 ;
	private JButton btnNewButton_3;
	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;

	private JMenuItem mntmOpen;

	private JMenuItem mntmExit;
	private static MyTableModel model;
	private static ArrayList<Double[]> firstData;
	private static ArrayList<Double[]> evaluateData;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestFrame frame = new TestFrame();
					frame.setVisible(true);
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					SwingUtilities.updateComponentTreeUI(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, Toolkit.getDefaultToolkit().getScreenSize().width*2/3, Toolkit.getDefaultToolkit().getScreenSize().height*2/3);
		setResizable(true);
		
		//menuBar
		JMenuBar menuBar = new JMenuBar();
		
		
		JMenu mnFile = new JMenu("File");
		mnFile.setIcon(new ImageIcon(TestFrame2.class.getResource("/com/sun/java/swing/plaf/windows/icons/File.gif")));
		menuBar.add(mnFile);
		
		mntmOpen = new JMenuItem("Open");
		mntmOpen.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				 JFileChooser fc = new JFileChooser();
				  int returnVal = fc.showOpenDialog(TestFrame.this);
				  if(returnVal == JFileChooser.APPROVE_OPTION){
					  File file = fc.getSelectedFile();
					  System.out.println("Opening " + file.getName());
				  }
			}
		});
		mntmOpen.setIcon(new ImageIcon(TestFrame2.class.getResource("/com/sun/java/swing/plaf/windows/icons/TreeClosed.gif")));
		mnFile.add(mntmOpen);
		
		mntmExit = new JMenuItem("Exit");
		mntmExit.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		mntmExit.setIcon(new ImageIcon(TestFrame2.class.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
		mnFile.add(mntmExit);
		
		JMenu mnView = new JMenu("View");
		mnView.setIcon(new ImageIcon(TestFrame2.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		menuBar.add(mnView);
		
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setIcon(new ImageIcon(TestFrame2.class.getResource("/com/sun/java/swing/plaf/motif/icons/Question.gif")));
		menuBar.add(mnHelp);
		
		setJMenuBar(menuBar);
		
		
		//general Panel
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 255));
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		//initialization Data Model of Table
		model = new MyTableModel();
		model.testData2(3);
		//model.testData(10);
		
		
//		final StepPanel stepPanel = new StepPanel();
//		contentPane.add(stepPanel, BorderLayout.SOUTH);
		
		//create ControlPanel	
		final JPanel panel = new ControlPanel();
		panel.setToolTipText("This is Control Panel");
		contentPane.add(panel, BorderLayout.NORTH);
		
	
		//add Button "Load" to ControlPanel
		btnNewButton_1 = new JButton("Test Random");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 15;
		gbc_btnNewButton_1.gridy = 1;
		panel.add(btnNewButton_1, gbc_btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.testData(12);
//				firstData = model.getData();
//				evaluateData = cloneArray(firstData);
//				btnNewButton_2.setEnabled(true);
				btnNewButton.setEnabled(true);
//				btnNewButton_1.setEnabled(false);
//				model.getMaxOperation();
				SwingUtilities.updateComponentTreeUI(scrollPane);
				
				panel.setToolTipText(Arrays.toString(ControlPanel.getEnable()));
			}
		});
		
		//add Button "Run" to Control Panel
		btnNewButton = new JButton("RUN");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 15;
		gbc_btnNewButton.gridy = 2;
		panel.add(btnNewButton, gbc_btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				firstData = model.getData();
				evaluateData = cloneArray(firstData);
				btnNewButton_2.setEnabled(true);
				btnNewButton.setEnabled(false);
				btnNewButton_1.setEnabled(false);
				model.getMaxOperation();
				
				//create new view table
				scrollPane.setVisible(false);
				Double[][]    data =  model.getEvaluateData(ControlPanel.getEnable());
				String[] colName =  model.getEnabledColumn(ControlPanel.getEnable());
				table = new JTable(new MyTableModel(data, colName));
				scrollPane = new JScrollPane(table);
				SwingUtilities.updateComponentTreeUI(contentPane);
				contentPane.add(scrollPane, BorderLayout.CENTER);
				
				
			}
		});
		
		
		//add Button "Return" to ControlPanel
		btnNewButton_2 = new JButton("Return");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_2.gridx = 15;
		gbc_btnNewButton_2.gridy = 3;
		panel.add(btnNewButton_2, gbc_btnNewButton_2);
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnNewButton.setEnabled(true);
				btnNewButton_1.setEnabled(true);
				btnNewButton_2.setEnabled(false);
				model.setData(evaluateData);
				//return firstModel
				scrollPane.setVisible(false);
				table = new JTable(model);
				scrollPane = new JScrollPane(table);
				SwingUtilities.updateComponentTreeUI(contentPane);
				contentPane.add(scrollPane, BorderLayout.CENTER);
				
			}
		});
		
		btnNewButton_3 = new JButton("NEW RUN");
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_3.gridx = 16;
		gbc_btnNewButton_3.gridy = 3;
		panel.add(btnNewButton_3, gbc_btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		
		scrollPane = new JScrollPane();
		scrollPane.setToolTipText("This is Scroll!");
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		Component verticalStrut_1 = Box.createVerticalStrut(0);
		scrollPane.setColumnHeaderView(verticalStrut_1);
		
		
		
		table = new JTable(model);
		table.setFont(new Font("Serif", Font.ROMAN_BASELINE, 14));
		
		
		
		
		
		scrollPane.setViewportView(table);
		
	}
	
	
	
	public static ArrayList<Double[]> cloneArray(Collection<?> collection){
		ArrayList<Double[]> copy = new ArrayList<Double[]>();
		for(Object x : collection){
			 Double[] s = (Double[]) x;
			 Double[] z = new Double[s.length];
			 for(int i = 0 ; i < z.length; i++){
				 z[i] = s[i];
			 }
			 copy.add(z);
		}
		
		return copy;
	}
	
	public static ArrayList<Double[]> getEvaluateData(){
		return firstData;
	}
	
}
