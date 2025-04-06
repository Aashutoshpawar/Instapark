package parkingmanagement;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Timer;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Dashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField date;
	private JTextField intime;
	private JTextField vehiclenumber;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	protected Object usernameLabel; 
	DefaultTableModel model;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Dashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1067, 726);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Dashboard");
		setVisible(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1264, 700);
		contentPane.add(tabbedPane);
		
		JPanel twowheelerRB = new JPanel();
		tabbedPane.addTab("Dashboard", null, twowheelerRB, null);
		twowheelerRB.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Choose Location");
		lblNewLabel.setBounds(43, 80, 144, 33);
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		twowheelerRB.add(lblNewLabel);
		
		JComboBox<String> chooselocationcb = new JComboBox();
		chooselocationcb.setBounds(228, 82, 219, 31);
		chooselocationcb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
		chooselocationcb.setModel(new DefaultComboBoxModel(new String[] {"select"}));
		chooselocationcb.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		twowheelerRB.add(chooselocationcb);
		
		JComboBox<String> parkingspacecb = new JComboBox();
		parkingspacecb.setBounds(228, 151, 211, 31);
		parkingspacecb.setModel(new DefaultComboBoxModel(new String[] {"Select", ""}));
		parkingspacecb.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		twowheelerRB.add(parkingspacecb);
		
		
		JLabel lblNewLabel_1 = new JLabel("Check parking spaces");
		lblNewLabel_1.setBounds(43, 154, 179, 22);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		twowheelerRB.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Date");
		lblNewLabel_2.setBounds(43, 219, 56, 22);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		twowheelerRB.add(lblNewLabel_2);
		
		date = new JTextField();
		date.setBounds(228, 215, 211, 33);
		date.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		twowheelerRB.add(date);
		date.setColumns(10);
		
		JButton btnNewButton = new JButton("Get Date");
		btnNewButton.setBounds(449, 215, 98, 33);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Date d = new Date();
				SimpleDateFormat dtf = new SimpleDateFormat("dd/MMM/YYYY");
				String dd = dtf.format(d);
				date.setText(dd);
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		twowheelerRB.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("In-Time");
		lblNewLabel_3.setBounds(43, 281, 69, 22);
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		twowheelerRB.add(lblNewLabel_3);
		
		intime = new JTextField();
		intime.setBounds(228, 278, 121, 31);
		intime.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		twowheelerRB.add(intime);
		intime.setColumns(10);
		
		JButton gettimebtn = new JButton("Get Time");
		gettimebtn.setBounds(359, 277, 106, 32);
		gettimebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Timer t;
				SimpleDateFormat st;
				Date dt = new Date();
				st = new SimpleDateFormat("hh:mm:ss a");
				String tt = st.format(dt);
				intime.setText(tt);
			}
		});
		gettimebtn.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		twowheelerRB.add(gettimebtn);
		
		JLabel lblNewLabel_4 = new JLabel("Vehicle Type");
		lblNewLabel_4.setBounds(43, 410, 106, 33);
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		twowheelerRB.add(lblNewLabel_4);
		
		JRadioButton TWOrb = new JRadioButton("2 - Wheeler");
		TWOrb.setBounds(222, 417, 127, 21);
		buttonGroup.add(TWOrb);
		TWOrb.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		twowheelerRB.add(TWOrb);
		
		JRadioButton FOURrb = new JRadioButton("4-Wheeler");
		FOURrb.setBounds(360, 417, 136, 21);
		buttonGroup.add(FOURrb);
		FOURrb.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		twowheelerRB.add(FOURrb);
		
		JLabel lblNewLabel_5 = new JLabel("Vehicle Number");
		lblNewLabel_5.setBounds(43, 480, 144, 22);
		lblNewLabel_5.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		twowheelerRB.add(lblNewLabel_5);
		
		vehiclenumber = new JTextField();
		vehiclenumber.setBounds(228, 477, 186, 31);
		vehiclenumber.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		twowheelerRB.add(vehiclenumber);
		vehiclenumber.setColumns(10);
		
		JButton bookParkingBTN = new JButton("Book Parking");
		bookParkingBTN.setBounds(44, 585, 219, 33);
		bookParkingBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/instapark","root","Pass@123");
					String query = "insert into records values(?,?,?,?,?,?,?)";
					PreparedStatement ps = con.prepareStatement(query);  
					
					
					String location = chooselocationcb.getSelectedItem().toString();
					ps.setString(1, location);
					String space = parkingspacecb.getSelectedItem().toString();
					ps.setString(2, space);
					ps.setString(3, date.getText());
					ps.setString(4, intime.getText());
					ps.setString(5, "");
					if(TWOrb.isSelected())
						ps.setString(6,TWOrb.getText());
					else if(FOURrb.isSelected())
						ps.setString(6,FOURrb.getText());
					
					ps.setString(7, vehiclenumber.getText());
					JOptionPane.showMessageDialog(bookParkingBTN,"Your parking Is booked");
					
					JOptionPane.showMessageDialog(bookParkingBTN,"pay the amount to the respective parking manager at parking ");
					ps.executeUpdate();
					con.close();
					}
				catch(Exception e1){
					e1.printStackTrace();
					}}
		});
		bookParkingBTN.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		twowheelerRB.add(bookParkingBTN);
		
		
		
		
		JButton clearBTN = new JButton("Clear");
		clearBTN.setBounds(311, 585, 236, 33);
		clearBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(e.getSource()==clearBTN) 
				{
				chooselocationcb.setSelectedIndex(0);
				parkingspacecb.setSelectedIndex(0);
				date.setText("");
				intime.setText("");
				buttonGroup.clearSelection();
				vehiclenumber.setText("");
				}
			}
		});
		clearBTN.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		twowheelerRB.add(clearBTN);
		
		JLabel lblNewLabel_6 = new JLabel("Welcome To Instapark");
		lblNewLabel_6.setBounds(28, 10, 277, 43);
		lblNewLabel_6.setFont(new Font("Segoe UI", Font.BOLD, 24));
		twowheelerRB.add(lblNewLabel_6);
		
		JButton btnNewButton_2 = new JButton("refresh");
		btnNewButton_2.setBounds(449, 81, 98, 33);
		btnNewButton_2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/instapark","root","Pass@123");
					Statement st = con.createStatement();
					String query = "select * from parkingspaces";
					ResultSet rs = st.executeQuery(query);
					while(rs.next()) {
						String name = rs.getString("location");
						chooselocationcb.addItem(name);
						String query1 = "select * from parkingspaces WHERE row_id = ? ";
						String space = rs.getString("2-Wheeler Space");
						parkingspacecb.addItem(space);
						}
					con.close();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		twowheelerRB.add(btnNewButton_2);
		
		JButton DRbtn = new JButton("Display Records");
		DRbtn.setBounds(602, 606, 193, 38);
		DRbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/instapark","root","Pass@123");
					Statement st = con.createStatement();
					String query = "select * from records";
					ResultSet rs = st.executeQuery(query);
					ResultSetMetaData rsmd = rs.getMetaData();
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					//for column			
					int cols = rsmd.getColumnCount();
					String[] colName = new String[cols];
					String elocation = "";
					String elocNumber = "";
					String edate = "";
					String eintime = "";
					String etimeduration = "";
					String evehicletype = "";
					String evehiclenumber = "";
					
					String[] erow = {elocation,edate,eintime,etimeduration,evehicletype,evehiclenumber,null};
					model.addRow(erow);
					for(int i=0;i<cols;i++) 
						colName[i] = rsmd.getColumnName(i+1);
						model.setColumnIdentifiers(colName);
					
					
						//for row
						//String  srno,username,location,date,intime,outtime,vehicletype,vehiclenumber;
						String  location,locNumber,date,intime,timeduration,vehicletype,vehiclenumber;
					//	String esrno = "";
						//String eusername = "";
					
						while(rs.next()) {
							mainframe m = new mainframe();
							String UN = rs.getString(1);
						
						//	srno=rs.getString(1);
						//  username=rs.getString(2);
							location      = rs.getString(1);
							locNumber     = rs.getString(2);
							date          = rs.getString(3);
							intime        = rs.getString(4);
							timeduration  = rs.getString(5);
							vehicletype   = rs.getString(6);
							vehiclenumber = rs.getString(7);
						//  String[] row = {srno,username,location,date,intime,outtime,vehicletype,vehiclenumber,null};
							String[] row = {location,locNumber,date,intime,timeduration,vehicletype,vehiclenumber,null};
							
						//  String[] erow = {esrno,eusername,elocation,edate,eintime,eouttime,evehicletype,evehiclenumber,null};
							
							
							
						   
							model.addRow(row);
							System.out.print("succeed");
						}
				} catch (SQLException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		twowheelerRB.add(DRbtn);
		
		JButton btnNewButton_1 = new JButton("Delete Row");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			if(table.getSelectedRowCount()==1) {
			model.removeRow(table.getSelectedRow());
			}
			}
			
		});
		btnNewButton_1.setBounds(815, 606, 193, 38);
		twowheelerRB.add(btnNewButton_1);
		
		JScrollPane jtable1 = new JScrollPane();
		jtable1.setBounds(602, 64, 402, 493);
		twowheelerRB.add(jtable1);
		
		table = new JTable();
		jtable1.setViewportView(table);
		
		JLabel lblNewLabel_8 = new JLabel("Time Duration");
		lblNewLabel_8.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel_8.setBounds(43, 354, 121, 22);
		twowheelerRB.add(lblNewLabel_8);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "1hr", "2hr", "3hr", "4hr", "5hr", "6hr", "7hr", "8hr", "9hr"}));
		comboBox.setBounds(230, 350, 75, 31);
		twowheelerRB.add(comboBox);
		
		
		
	
		
		
		
	}
}
