package com.eddie.test3;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.io.File;
import java.util.*;

public class TestFrame2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton btnRun ;
	private JButton btnTestRandom ;
	private JButton btnReturn ;
	private JButton btnNewRun;
	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;

	private JMenuItem mntmOpen;
	private JMenuItem mntmSave;
	private JMenuItem mntmExit;
	private static MyTableModel model;
	private static ArrayList<Double[]> firstData;
	private static ArrayList<Double[]> evaluateData;
	private JSlider slider;
	private JTextField textField;
	private JButton btnCreateTable;
	private JButton btnSave;
	private JButton btnOpen;

	private ControlPanel panel;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestFrame2 frame = new TestFrame2();
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
	public TestFrame2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, (Toolkit.getDefaultToolkit().getScreenSize().width*2/3+50), Toolkit.getDefaultToolkit().getScreenSize().height*2/3);
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
				  int returnVal = fc.showOpenDialog(TestFrame2.this);
				  if(returnVal == JFileChooser.APPROVE_OPTION){
					  File file = fc.getSelectedFile();
					  System.out.println("Opening " + file.getName());
				  }
			}
		});
		mntmOpen.setIcon(new ImageIcon(TestFrame2.class.getResource("/com/sun/java/swing/plaf/windows/icons/TreeClosed.gif")));
		mnFile.add(mntmOpen);
		
		mntmSave = new JMenuItem("Save");
		mntmSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
		mntmSave.setIcon(new ImageIcon(TestFrame2.class.getResource("/com/sun/java/swing/plaf/windows/icons/FloppyDrive.gif")));
		mnFile.add(mntmSave);
		
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
		
		//create ControlPanel	
		panel = new ControlPanel();
		GridBagLayout gridBagLayout = (GridBagLayout) panel.getLayout();
		gridBagLayout.columnWidths = new int[] {30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		panel.setToolTipText("This is Control Panel");
		contentPane.add(panel, BorderLayout.NORTH);
		
		//add Slider to Control Panel
		slider = new JSlider(0,100, 0);
		addComponentToControlPanel(slider, 12, 0);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setPaintTrack(true);
		slider.setMinorTickSpacing(1);
		slider.setMajorTickSpacing(10);
		slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				textField.setText(String.valueOf(slider.getValue()));
				
			}
		});
		
		//add TextField to Control Panel
		textField = new JTextField("0");
		addComponentToControlPanel(textField, 18, 0);
		textField.setColumns(4);
		
	
		//add Button "Load" to ControlPanel
		btnTestRandom = new JButton("Test Random");
		addComponentToControlPanel(btnTestRandom, 12, 1);
		btnTestRandom.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.testData2(6);
				btnRun.setEnabled(true);
				SwingUtilities.updateComponentTreeUI(scrollPane);
				
			}
		});
		
		//add Button "Create table"
		btnCreateTable = new JButton("Create table");
		addComponentToControlPanel(btnCreateTable, 14, 1);
		
		//add Button "Open" to Control Panel
		btnOpen = new JButton("Open");
		addComponentToControlPanel(btnOpen, 16, 1);
		
		//add Button "Run" to Control Panel
		btnRun = new JButton("RUN");
		addComponentToControlPanel(btnRun, 12, 2);
		btnRun.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				firstData = model.getData();
				evaluateData = cloneArray(firstData);
				btnReturn.setEnabled(true);
				btnRun.setEnabled(false);
				btnTestRandom.setEnabled(false);
				model.getMaxOperation((ControlPanel) panel);
				System.out.println(btnRun.equals(e.getSource()));
				//create new view table
				scrollPane.setVisible(false);
				boolean[] enabled = ((ControlPanel) panel).getEnable();
				Double[][]  data =  model.getEvaluateData(enabled);
				data = SortedMan.sortedData(data);
				String[] colName =  model.getEnabledColumn(enabled);
				table = new JTable(new MyTableModel(data, colName));
				scrollPane = new JScrollPane(table);
				SwingUtilities.updateComponentTreeUI(contentPane);
				contentPane.add(scrollPane, BorderLayout.CENTER);
				
				
			}
		});
		//add Button "Save" to 
		btnSave = new JButton("Save");
		addComponentToControlPanel(btnSave, 14, 2);
		
		//add Button "Return" to ControlPanel
		btnReturn = new JButton("Return");
		addComponentToControlPanel(btnReturn, 12, 3);
		btnReturn.setEnabled(false);
		btnReturn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnRun.setEnabled(true);
				btnTestRandom.setEnabled(true);
				btnReturn.setEnabled(false);
				model.setData(evaluateData);
				//return firstModel
				scrollPane.setVisible(false);
				table = new JTable(model);
				scrollPane = new JScrollPane(table);
				SwingUtilities.updateComponentTreeUI(contentPane);
				contentPane.add(scrollPane, BorderLayout.CENTER);
				
			}
		});
		
		//add Button "New RUN" to Control Panel
		btnNewRun = new JButton("NEW RUN");
		addComponentToControlPanel(btnNewRun, 14, 3);
		btnNewRun.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
//		Component verticalStrut_1 = Box.createVerticalStrut(0);
//		scrollPane.setColumnHeaderView(verticalStrut_1);
		
		
		table = new JTable(model);
		scrollPane.setViewportView(table);
		
	}
	
	
	
	private static ArrayList<Double[]> cloneArray(Collection<?> collection){
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
	
	private void addComponentToControlPanel(JComponent component, int x, int y){
		GridBagConstraints gbc_btnOpen = new GridBagConstraints();
		gbc_btnOpen.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnOpen.insets = new Insets(0, 0, 5, 5);
		if(component.getClass().equals(JSlider.class)) gbc_btnOpen.gridwidth = 6;
		gbc_btnOpen.gridx = x;
		gbc_btnOpen.gridy = y;
		panel.add(component, gbc_btnOpen);
	}
	
	
}
