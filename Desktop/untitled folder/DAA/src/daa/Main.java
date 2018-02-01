package daa;

import java.math.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;
import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.BreakIterator;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;

public class Main implements ActionListener {

	JList list;
	DefaultListModel listModel;
	public JFrame frame;
	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_2;
	public JComboBox comboBox, comboBox_1, comboBox_2;
	JButton btnNewButton;
	JCheckBox chckbxDelhi, chckbxAlwar, chckbxPushkar, chckbxJaipur, chckbxMountAbu, chckbxAjmer;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 639);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblTripMeter = new JLabel("<html><center>TRAVEL TRACKER</center></html>");
		lblTripMeter.setFont(new Font("Sitka Banner", Font.BOLD, 23));
		lblTripMeter.setBounds(190, 11, 181, 57);
		frame.getContentPane().add(lblTripMeter);

		JSeparator separator = new JSeparator();
		separator.setBounds(224, 66, 1, 2);
		frame.getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLUE);
		separator_1.setBackground(UIManager.getColor("CheckBox.focus"));
		separator_1.setBounds(10, 66, 564, 2);
		frame.getContentPane().add(separator_1);

		JLabel lblBudget = new JLabel("<html><center>BUDGET</center></html>");
		lblBudget.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBudget.setBounds(50, 152, 56, 25);
		frame.getContentPane().add(lblBudget);

		JLabel lblStayType = new JLabel("<html><center>STAY TYPE</center></html>");
		lblStayType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStayType.setBounds(50, 188, 115, 49);
		frame.getContentPane().add(lblStayType);

		JLabel lblTransportationType = new JLabel("TRANSPORTATION TYPE");
		lblTransportationType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTransportationType.setBounds(26, 248, 160, 31);
		frame.getContentPane().add(lblTransportationType);

		JLabel lblFoodType = new JLabel("<html><center>FOOD COST</center></html>");
		lblFoodType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFoodType.setBounds(50, 308, 88, 25);
		frame.getContentPane().add(lblFoodType);

		JLabel lblMiscellaneous = new JLabel("<html><center>MISCELLANEOUS</center></html>");
		lblMiscellaneous.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMiscellaneous.setBounds(50, 360, 115, 31);
		frame.getContentPane().add(lblMiscellaneous);

		textField = new JTextField();
		textField.setBounds(252, 156, 149, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(252, 312, 149, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(252, 367, 149, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		comboBox = new JComboBox();
		comboBox.setBounds(253, 255, 148, 20);
		comboBox.addItem("Airway");
		comboBox.addItem("Roadway");
		comboBox.addItem("Railway");
		comboBox.addActionListener(this);
		frame.getContentPane().add(comboBox);

		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(252, 199, 149, 20);
		comboBox_1.addItem("Luxury");
		comboBox_1.addItem("Economy");
		comboBox_1.addItem("Business");
		comboBox_1.addActionListener(this);
		frame.getContentPane().add(comboBox_1);

		JLabel lblSourceCity = new JLabel("<html><center>SOURCE CITY</center></html>");
		lblSourceCity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSourceCity.setBounds(50, 104, 116, 25);
		frame.getContentPane().add(lblSourceCity);

		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(252, 106, 149, 20);
		comboBox_2.addItem("Delhi");
		comboBox_2.addItem("Jaipur");
		comboBox_2.addItem("Ajmer");
		comboBox_2.addItem("MountAbu");
		comboBox_2.addItem("Pushkar");
		comboBox_2.addItem("Alwar");
		comboBox_2.addActionListener(this);
		frame.getContentPane().add(comboBox_2);

		JLabel lblCityToVisit = new JLabel("<html><center>CITIES TO VISIT</center></html>");
		lblCityToVisit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCityToVisit.setBounds(50, 419, 103, 25);
		frame.getContentPane().add(lblCityToVisit);

		btnNewButton = new JButton("<html><center>CALCULATE\r\n</center></html>");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(190, 521, 226, 36);
		frame.getContentPane().add(btnNewButton);

		chckbxDelhi = new JCheckBox("Delhi");
		chckbxDelhi.setBounds(184, 420, 97, 23);
		chckbxDelhi.addActionListener(this);
		frame.getContentPane().add(chckbxDelhi);

		chckbxJaipur = new JCheckBox("Jaipur");
		chckbxJaipur.setBounds(286, 420, 115, 23);
		chckbxJaipur.addActionListener(this);
		frame.getContentPane().add(chckbxJaipur);

		chckbxAjmer = new JCheckBox("Ajmer");
		chckbxAjmer.setBounds(402, 420, 97, 23);
		chckbxAjmer.addActionListener(this);
		frame.getContentPane().add(chckbxAjmer);

		chckbxPushkar = new JCheckBox("Pushkar");
		chckbxPushkar.setBounds(184, 467, 97, 23);
		chckbxPushkar.addActionListener(this);
		frame.getContentPane().add(chckbxPushkar);

		chckbxMountAbu = new JCheckBox("MountAbu");
		chckbxMountAbu.setBounds(286, 467, 97, 23);
		chckbxMountAbu.addActionListener(this);
		frame.getContentPane().add(chckbxMountAbu);

		chckbxAlwar = new JCheckBox("Alwar");
		chckbxAlwar.setBounds(402, 467, 97, 23);
		chckbxAlwar.addActionListener(this);
		frame.getContentPane().add(chckbxAlwar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ae = e.getSource();
		if (ae == btnNewButton && !textField.getText().equals("")) {
			int budget;
			int fcost;
			int misc;
			String source = (String) comboBox_2.getItemAt(comboBox_2.getSelectedIndex());
			budget = Math.abs( Integer.parseInt(textField.getText()));
			if(textField_1.getText().equals(""))
			{
				fcost=0;
			}
			else
			{
				fcost = Math.abs(Integer.parseInt(textField_1.getText()));
			}
			
			if(textField_2.getText().equals(""))
			{
				misc=0;
			}
			else
			{
				misc = Math.abs(Integer.parseInt(textField_2.getText()));
			}
			String stay = (String) comboBox_1.getItemAt(comboBox_1.getSelectedIndex());
			int staycost = 0;
			if (stay.equals("Luxury")) {
				staycost = 1000;
			} else if (stay.equals("Business")) {
				staycost = 600;
			} else {
				staycost = 200;
			}

			String transport = (String) comboBox.getItemAt(comboBox.getSelectedIndex());
			int tcost = 0;
			if (transport.equals("Airway")) {
				tcost = 1000;
			} else if (transport.equals("Railway")) {
				tcost = 600;
			} else {
				tcost = 200;
			}
			int totalcost=budget-fcost-misc-staycost-tcost;
			int[] city = new int[7];
			if (!chckbxDelhi.isSelected()) {
				city[1] = 1;
			}
			if (!chckbxJaipur.isSelected()) {
				city[2] = 1;
			}
			if (!chckbxAjmer.isSelected()) {
				city[3] = 1;
			}
			if (!chckbxPushkar.isSelected()) {
				city[4] = 1;
			}
			if (!chckbxMountAbu.isSelected()) {
				city[5] = 1;
			}
			if (!chckbxAlwar.isSelected()) {
				city[6] = 1;
			}
			switch (source) {
			case "Delhi":
				city[1] = 0;
				break;
			case "Jaipur":
				city[2] = 0;
				break;
			case "Ajmer":
				city[3] = 0;
				break;
			case "Pushkar":
				city[4] = 0;
				break;
			case "MountAbu":
				city[5] = 0;
				break;
			case "Alwar":
				city[6] = 0;
				break;
			}
			int sindex=comboBox_2.getSelectedIndex();
			sindex++;
			TSP tsp=new TSP(frame,totalcost,city,sindex);
			tsp.calculate();
		}
		if (ae == btnNewButton && textField.getText().equals(""))
		{
			JOptionPane.showMessageDialog(frame,"Enter Budget","Error",JOptionPane.ERROR_MESSAGE);
		}

	}
}
