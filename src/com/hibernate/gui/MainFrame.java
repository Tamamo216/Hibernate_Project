package com.hibernate.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.hibernate.dao.GiaovuAccountDAO;
import com.hibernate.dao.SemesterDAO;
import com.hibernate.pojo.GiaovuAccountEntity;
import com.hibernate.pojo.SemesterEntity;

public class MainFrame extends JFrame {
	private GiaovuAccountEntity logged_account = null;
	private SemesterEntity setSemester = null;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField nameField;
	private JTextField facultyField;
	private JTextField phoneField;
	private JTextField emailField;
	private JRadioButton male;
	private JRadioButton female;
	private JTable giaovuAccountTable;
	private JTextField textField;
	private JTable semesterTable;
	private JTextField semesterSearchField;
	private JTable table_1;
	private JTextField textField_1;
	/**
	 * Launch the application.
	 */
	
	/**male
	 * Create the frame.
	 */
	public MainFrame(GiaovuAccountEntity logged_account) {
		this.logged_account = logged_account;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 735);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		
		//Giaovu tab
		JPanel giaovu = new JPanel();
		tabbedPane.addTab("Gi\u00E1o V\u1EE5", null, giaovu, null);
		giaovu.setLayout(new BorderLayout(0, 0));
		
		JPanel giaovu_CenterPane = new JPanel();
		giaovu.add(giaovu_CenterPane, BorderLayout.CENTER);
		GridBagLayout gbl_giaovu_CenterPane = new GridBagLayout();
		gbl_giaovu_CenterPane.columnWidths = new int[]{0, 0};
		gbl_giaovu_CenterPane.rowHeights = new int[]{0, 0, 0};
		gbl_giaovu_CenterPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_giaovu_CenterPane.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		giaovu_CenterPane.setLayout(gbl_giaovu_CenterPane);
		
		JPanel giaovu_TopPane = new JPanel();
		GridBagConstraints gbc_giaovu_TopPane = new GridBagConstraints();
		gbc_giaovu_TopPane.insets = new Insets(0, 0, 5, 0);
		gbc_giaovu_TopPane.fill = GridBagConstraints.BOTH;
		gbc_giaovu_TopPane.gridx = 0;
		gbc_giaovu_TopPane.gridy = 0;
		giaovu_CenterPane.add(giaovu_TopPane, gbc_giaovu_TopPane);
		giaovu_TopPane.setLayout(new BorderLayout(0, 0));
		
		JPanel giaovuFunctions = new JPanel();
		giaovu_TopPane.add(giaovuFunctions, BorderLayout.SOUTH);
		GridBagLayout gbl_giaovuFunctions = new GridBagLayout();
		gbl_giaovuFunctions.columnWidths = new int[]{42, 232, 48, 65, 62, 0};
		gbl_giaovuFunctions.rowHeights = new int[]{29, 0};
		gbl_giaovuFunctions.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_giaovuFunctions.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		giaovuFunctions.setLayout(gbl_giaovuFunctions);
		
		JLabel giaovuSearch = new JLabel("Search");
		giaovuSearch.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GridBagConstraints gbc_giaovuSearch = new GridBagConstraints();
		gbc_giaovuSearch.anchor = GridBagConstraints.WEST;
		gbc_giaovuSearch.insets = new Insets(0, 5, 5, 5);
		gbc_giaovuSearch.gridx = 0;
		gbc_giaovuSearch.gridy = 0;
		giaovuFunctions.add(giaovuSearch, gbc_giaovuSearch);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.NORTHWEST;
		gbc_textField.insets = new Insets(0, 5, 5, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		giaovuFunctions.add(textField, gbc_textField);
		textField.setColumns(20);
				
		JButton giaovuAddButton = new JButton("Add");
		GridBagConstraints gbc_giaovuAddButton = new GridBagConstraints();
		gbc_giaovuAddButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_giaovuAddButton.insets = new Insets(0, 5, 5, 5);
		gbc_giaovuAddButton.gridx = 2;
		gbc_giaovuAddButton.gridy = 0;
		giaovuFunctions.add(giaovuAddButton, gbc_giaovuAddButton);
		giaovuAddButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) giaovuAccountTable.getModel();
				Register frame = new Register(model,null,-1);
				frame.setVisible(true);
			}
		});
		
		JButton giaovuUpdateButton = new JButton("Update");
		GridBagConstraints gbc_giaovuUpdateButton = new GridBagConstraints();
		gbc_giaovuUpdateButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_giaovuUpdateButton.insets = new Insets(0, 5, 5, 5);
		gbc_giaovuUpdateButton.gridx = 3;
		gbc_giaovuUpdateButton.gridy = 0;
		giaovuFunctions.add(giaovuUpdateButton, gbc_giaovuUpdateButton);
		giaovuUpdateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = giaovuAccountTable.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) giaovuAccountTable.getModel();
				Object[] selectedAccount = new Object[8];
				for (int i = 0; i < 8; ++i) {
					selectedAccount[i] = model.getValueAt(selectedRow,i);
				}
				Register frame = new Register(model,selectedAccount,selectedRow);
				frame.setVisible(true);
			}
		});

		JButton giaovuDeleteButton = new JButton("Delete");
		GridBagConstraints gbc_giaovuDeleteButton = new GridBagConstraints();
		gbc_giaovuDeleteButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_giaovuDeleteButton.insets = new Insets(0, 5, 5, 5);
		gbc_giaovuDeleteButton.gridx = 4;
		gbc_giaovuDeleteButton.gridy = 0;
		giaovuFunctions.add(giaovuDeleteButton, gbc_giaovuDeleteButton);
		giaovuDeleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = giaovuAccountTable.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) giaovuAccountTable.getModel();
				Object[] rowData = new Object[8];
				for (int i = 0; i < 8; ++i) {
					rowData[i] = model.getValueAt(row,i);
				}
				GiaovuAccountEntity account = new GiaovuAccountEntity(rowData);
				GiaovuAccountDAO.Delete(account);
				model.removeRow(row);
			}
		});
		
		//Giao vu table data
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		giaovu_CenterPane.add(scrollPane, gbc_scrollPane);
		
		giaovuAccountTable = new JTable();
		LoadDataIntoTable(new GiaovuAccountEntity(), giaovuAccountTable);
		scrollPane.setViewportView(giaovuAccountTable);

		


		//Semester tab
		JPanel semester = new JPanel();
		tabbedPane.addTab("H\u1ECDc k\u00EC", null, semester, null);
		semester.setLayout(new BorderLayout(0, 0));
		
		JPanel semester_CenterPane = new JPanel();
		semester.add(semester_CenterPane, BorderLayout.CENTER);
		GridBagLayout gbl_semester_CenterPane = new GridBagLayout();
		gbl_semester_CenterPane.columnWidths = new int[]{0, 0};
		gbl_semester_CenterPane.rowHeights = new int[]{0, 0, 0};
		gbl_semester_CenterPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_semester_CenterPane.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		semester_CenterPane.setLayout(gbl_semester_CenterPane);
		
		JPanel semester_TopPane = new JPanel();
		GridBagConstraints gbc_semester_TopPane = new GridBagConstraints();
		gbc_semester_TopPane.insets = new Insets(0, 0, 5, 0);
		gbc_semester_TopPane.fill = GridBagConstraints.BOTH;
		gbc_semester_TopPane.gridx = 0;
		gbc_semester_TopPane.gridy = 0;
		semester_CenterPane.add(semester_TopPane, gbc_semester_TopPane);
		semester_TopPane.setLayout(new BorderLayout(0, 0));
		
		JPanel semesterFunction = new JPanel();
		semester_TopPane.add(semesterFunction, BorderLayout.SOUTH);
		GridBagLayout gbl_semesterFunction = new GridBagLayout();
		gbl_semesterFunction.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_semesterFunction.rowHeights = new int[]{0, 0};
		gbl_semesterFunction.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_semesterFunction.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		semesterFunction.setLayout(gbl_semesterFunction);
		
		JLabel semesterSearch = new JLabel("Search");
		semesterSearch.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GridBagConstraints gbc_semesterSearch = new GridBagConstraints();
		gbc_semesterSearch.insets = new Insets(0, 5, 0, 5);
		gbc_semesterSearch.anchor = GridBagConstraints.EAST;
		gbc_semesterSearch.gridx = 0;
		gbc_semesterSearch.gridy = 0;
		semesterFunction.add(semesterSearch, gbc_semesterSearch);
		
		semesterSearchField = new JTextField();
		semesterSearchField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_semesterSearchField = new GridBagConstraints();
		gbc_semesterSearchField.insets = new Insets(0, 5, 5, 5);
		gbc_semesterSearchField.gridx = 1;
		gbc_semesterSearchField.gridy = 0;
		semesterFunction.add(semesterSearchField, gbc_semesterSearchField);
		semesterSearchField.setColumns(20);
		
		JButton semesterAddButton = new JButton("Add");
		semesterAddButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) semesterTable.getModel();
				AddSemester frame = new AddSemester(model);
				frame.setVisible(true);
			}
		});
		semesterAddButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
		GridBagConstraints gbc_semesterAddButton = new GridBagConstraints();
		gbc_semesterAddButton.insets = new Insets(0, 5, 0, 5);
		gbc_semesterAddButton.gridx = 2;
		gbc_semesterAddButton.gridy = 0;
		semesterFunction.add(semesterAddButton, gbc_semesterAddButton);
		
		JButton semesterSetButton = new JButton("Set");
		semesterSetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = semesterTable.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(null, "You need to select a row first",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					DefaultTableModel model = (DefaultTableModel) semesterTable.getModel();
					Object[] rowData = new Object[5];
					for (int i = 0; i < 5; ++i) {
						rowData[i] = model.getValueAt(selectedRow, i);
					}
					setSemester = new SemesterEntity(rowData);
					JOptionPane.showMessageDialog(null, "Set semester successfully",
							null, JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		semesterSetButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
		GridBagConstraints gbc_semesterSetButton = new GridBagConstraints();
		gbc_semesterSetButton.insets = new Insets(0, 5, 0, 5);
		gbc_semesterSetButton.gridx = 3;
		gbc_semesterSetButton.gridy = 0;
		semesterFunction.add(semesterSetButton, gbc_semesterSetButton);
		
		JButton semesterDeleteButton = new JButton("Delete");
		semesterDeleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = semesterTable.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) semesterTable.getModel();
				Object[] rowData = new Object[5];
				for (int i = 0; i < 5; ++i)
					rowData[i] = model.getValueAt(selectedRow,i);
				SemesterEntity semester = new SemesterEntity(rowData);
				SemesterDAO.Delete(semester);
				model.removeRow(selectedRow);
			}
		});

		semesterDeleteButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
		GridBagConstraints gbc_semesterDeleteButton = new GridBagConstraints();
		gbc_semesterDeleteButton.insets = new Insets(0, 5, 0, 0);
		gbc_semesterDeleteButton.gridx = 4;
		gbc_semesterDeleteButton.gridy = 0;
		semesterFunction.add(semesterDeleteButton, gbc_semesterDeleteButton);
		
		JScrollPane semesterScrollPane = new JScrollPane();
		GridBagConstraints gbc_semesterScrollPane = new GridBagConstraints();
		gbc_semesterScrollPane.fill = GridBagConstraints.BOTH;
		gbc_semesterScrollPane.gridx = 0;
		gbc_semesterScrollPane.gridy = 1;
		semester_CenterPane.add(semesterScrollPane, gbc_semesterScrollPane);


		//Semester data table
		semesterTable = new JTable();
		LoadDataIntoTable(new SemesterEntity(), semesterTable);
		semesterScrollPane.setViewportView(semesterTable);
		
		
		
		
		
		//subject tab
		JPanel subject = new JPanel();
		tabbedPane.addTab("M\u00F4n h\u1ECDc", null, subject, null);
		subject.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		subject.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblNewLabel = new JLabel("Search");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_2.add(lblNewLabel, gbc_lblNewLabel);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 0, 5);
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 0;
		panel_2.add(textField_1, gbc_textField_1);
		textField_1.setColumns(20);
		
		JButton btnNewButton = new JButton("Add");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 0;
		panel_2.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 0;
		panel_2.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.gridx = 4;
		gbc_btnNewButton_2.gridy = 0;
		panel_2.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 1;
		panel.add(scrollPane_1, gbc_scrollPane_1);
		
		
		
		//subject table data
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		
		
		
		JPanel westPanel = new JPanel();
		getContentPane().add(westPanel, BorderLayout.WEST);
		westPanel.setLayout(new BorderLayout(0, 0));
		
		
		
		//Giao vu info pane
		JPanel giaovuInfo = new JPanel();
		giaovuInfo.setBorder(new TitledBorder(null, "Th\u00F4ng tin Gi\u00E1o V\u1EE5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		westPanel.add(giaovuInfo);
		GridBagLayout gbl_giaovuInfo = new GridBagLayout();
		gbl_giaovuInfo.columnWidths = new int[]{0, 0, 0, 0};
		gbl_giaovuInfo.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_giaovuInfo.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_giaovuInfo.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		giaovuInfo.setLayout(gbl_giaovuInfo);
		
		JLabel nameLable = new JLabel("H\u1ECD v\u00E0 T\u00EAn");
		GridBagConstraints gbc_nameLable = new GridBagConstraints();
		gbc_nameLable.insets = new Insets(20, 0, 5, 5);
		gbc_nameLable.gridx = 0;
		gbc_nameLable.gridy = 0;
		giaovuInfo.add(nameLable, gbc_nameLable);
		
		nameField = new JTextField();
		nameField.setText(logged_account.getName());
		GridBagConstraints gbc_nameField = new GridBagConstraints();
		gbc_nameField.insets = new Insets(20, 30, 10, 5);
		gbc_nameField.anchor = GridBagConstraints.WEST;
		gbc_nameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameField.gridx = 1;
		gbc_nameField.gridy = 0;
		giaovuInfo.add(nameField, gbc_nameField);
		nameField.setColumns(20);
		
		JLabel facultyLabel = new JLabel("Khoa");
		GridBagConstraints gbc_facultyLabel = new GridBagConstraints();
		gbc_facultyLabel.insets = new Insets(5, 0, 5, 5);
		gbc_facultyLabel.gridx = 0;
		gbc_facultyLabel.gridy = 1;
		giaovuInfo.add(facultyLabel, gbc_facultyLabel);
		
		facultyField = new JTextField(logged_account.getFaculty());
		GridBagConstraints gbc_facultyField = new GridBagConstraints();
		gbc_facultyField.insets = new Insets(10, 30, 10, 5);
		gbc_facultyField.anchor = GridBagConstraints.WEST;
		gbc_facultyField.fill = GridBagConstraints.HORIZONTAL;
		gbc_facultyField.gridx = 1;
		gbc_facultyField.gridy = 1;
		giaovuInfo.add(facultyField, gbc_facultyField);
		facultyField.setColumns(20);
		
		JLabel phoneLabel = new JLabel("\u0110i\u1EC7n Tho\u1EA1i");
		GridBagConstraints gbc_phoneLabel = new GridBagConstraints();
		gbc_phoneLabel.insets = new Insets(0, 0, 5, 5);
		gbc_phoneLabel.gridx = 0;
		gbc_phoneLabel.gridy = 2;
		giaovuInfo.add(phoneLabel, gbc_phoneLabel);
		
		phoneField = new JTextField(logged_account.getPhonenumber());
		GridBagConstraints gbc_phoneField = new GridBagConstraints();
		gbc_phoneField.insets = new Insets(10, 30, 10, 5);
		gbc_phoneField.fill = GridBagConstraints.HORIZONTAL;
		gbc_phoneField.gridx = 1;
		gbc_phoneField.gridy = 2;
		giaovuInfo.add(phoneField, gbc_phoneField);
		phoneField.setColumns(20);
		
		JLabel emailLabel = new JLabel("Email");
		GridBagConstraints gbc_emailLabel = new GridBagConstraints();
		gbc_emailLabel.insets = new Insets(0, 0, 5, 5);
		gbc_emailLabel.gridx = 0;
		gbc_emailLabel.gridy = 3;
		giaovuInfo.add(emailLabel, gbc_emailLabel);
		
		emailField = new JTextField(logged_account.getEmail());
		GridBagConstraints gbc_emailField = new GridBagConstraints();
		gbc_emailField.insets = new Insets(10, 30, 10, 5);
		gbc_emailField.fill = GridBagConstraints.HORIZONTAL;
		gbc_emailField.gridx = 1;
		gbc_emailField.gridy = 3;
		giaovuInfo.add(emailField, gbc_emailField);
		emailField.setColumns(20);
		
		male = new JRadioButton("Male");
		male.setActionCommand(male.getText());
		buttonGroup.add(male);
		GridBagConstraints gbc_maleRadioButoon = new GridBagConstraints();
		gbc_maleRadioButoon.insets = new Insets(0, 0, 5, 5);
		gbc_maleRadioButoon.gridx = 0;
		gbc_maleRadioButoon.gridy = 5;
		giaovuInfo.add(male, gbc_maleRadioButoon);
		
		female = new JRadioButton("Female");
		female.setActionCommand(female.getText());
		buttonGroup.add(female);
		GridBagConstraints gbc_femaleRadioButton = new GridBagConstraints();
		gbc_femaleRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_femaleRadioButton.gridx = 1;
		gbc_femaleRadioButton.gridy = 5;
		giaovuInfo.add(female, gbc_femaleRadioButton);

		SetSelectedButton(logged_account.getSex());

		JPanel buttonFunctionsPane = new JPanel();
		GridBagConstraints gbc_buttonFunctionsPane = new GridBagConstraints();
		gbc_buttonFunctionsPane.gridwidth = 2;
		gbc_buttonFunctionsPane.insets = new Insets(0, 0, 5, 5);
		gbc_buttonFunctionsPane.fill = GridBagConstraints.BOTH;
		gbc_buttonFunctionsPane.gridx = 0;
		gbc_buttonFunctionsPane.gridy = 6;
		giaovuInfo.add(buttonFunctionsPane, gbc_buttonFunctionsPane);
		buttonFunctionsPane.setLayout(new BoxLayout(buttonFunctionsPane, BoxLayout.X_AXIS));
		
		JButton edit = new JButton("Edit");
		edit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				logged_account.setName(nameField.getText());
				logged_account.setFaculty(facultyField.getText());
				logged_account.setSex(buttonGroup.getSelection().getActionCommand());
				logged_account.setPhonenumber(phoneField.getText());
				logged_account.setEmail(emailField.getText());
				GiaovuAccountDAO.Update(logged_account);
				LoadDataIntoTable(new GiaovuAccountEntity(), giaovuAccountTable);
				JOptionPane.showMessageDialog(null,"New information has been updated"
				,"Successfully",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		buttonFunctionsPane.add(edit);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		buttonFunctionsPane.add(horizontalGlue_1);
		
		JButton change_password = new JButton("Change password");
		change_password.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePassword frame = new ChangePassword(logged_account,giaovuAccountTable);
				frame.setVisible(true);
			}
		});
		buttonFunctionsPane.add(change_password);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		buttonFunctionsPane.add(horizontalGlue);
		
		JButton logout = new JButton("Logout");
		logout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		buttonFunctionsPane.add(logout);
	}

	private void SetSelectedButton(String sex) {
		if (sex.equals("Male")) {
			buttonGroup.setSelected(male.getModel(),true);
		}
		else {
			buttonGroup.setSelected(female.getModel(), true);
		}
	}

	private void LoadDataIntoTable(Object obj , JTable table) {
		DefaultTableModel model = new DefaultTableModel() {
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				Class columnClass = Object.class;
				if (getRowCount() > 0)
					columnClass = getValueAt(0,columnIndex).getClass();
				return columnClass;
			}
		};
		if (obj instanceof GiaovuAccountEntity) {
			List<GiaovuAccountEntity> list = GiaovuAccountDAO.GetAll();
			model.setColumnIdentifiers(new Object[]{
					"id", "Username", "Password", "Name",
					"Faculty", "Gender", "Phone number", "Email"});
			for (GiaovuAccountEntity acc : list) {
				model.addRow(new Object[]{
						acc.getGiaovuid(), acc.getUsername(),
						acc.getPassword(), acc.getName(),
						acc.getFaculty(), acc.getSex(),
						acc.getPhonenumber(), acc.getEmail()
				});
			}
		}
		else if (obj instanceof SemesterEntity) {
			List<SemesterEntity> list = SemesterDAO.GetAll();
			model.setColumnIdentifiers(new Object[] {
					"id", "Semester name", "Years", "Start date", "End date"
			});
			for (SemesterEntity semester : list) {
				model.addRow(new Object[]{
						semester.getHk_id(), semester.getTenhk(),
						semester.getNamhoc(), semester.getNgaybatdau(),
						semester.getNgayketthuc()
				});
			}
		}
		table.setModel(model);
	}
}

