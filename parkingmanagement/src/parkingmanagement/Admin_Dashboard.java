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
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Admin_Dashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField space1;
	private JTextField space2;
	private JTextField location;
	private JTextField fare1;
	private JTable table;
	private JTextField fare2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField FullnameTB;
	private JTextField usernameTB;
	private JTextField passwordTB;
	private JTextField contactTB;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Dashboard frame = new Admin_Dashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Admin_Dashboard() {
		setFont(new Font("Segoe UI", Font.PLAIN, 17));
		setTitle("Admin Dashboard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1075, 683);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1119, 703);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Add spaces", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Enter fare for 2-wheeler");
		lblNewLabel_5.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(76, 333, 214, 25);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_4 = new JLabel("space for 4-Wheeler");
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(76, 255, 214, 25);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("space for 2-Wheeler");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(76, 171, 214, 25);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Location");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(76, 90, 142, 25);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Add the Space ");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		lblNewLabel.setBounds(48, 17, 224, 43);
		panel_1.add(lblNewLabel);
		
		space1 = new JTextField();
		space1.setBounds(300, 171, 96, 26);
		panel_1.add(space1);
		space1.setColumns(10);
		
		space2 = new JTextField();
		space2.setBounds(300, 255, 96, 26);
		panel_1.add(space2);
		space2.setColumns(10);
		
		location = new JTextField();
		location.setBounds(300, 94, 201, 26);
		panel_1.add(location);
		location.setColumns(10);
		
		fare1 = new JTextField();
		fare1.setBounds(300, 333, 96, 26);
		panel_1.add(fare1);
		fare1.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(562, 74, 417, 455);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_6 = new JLabel("Enter Fare for 4-Wheeler");
		lblNewLabel_6.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(76, 404, 214, 31);
		panel_1.add(lblNewLabel_6);
		
		fare2 = new JTextField();
		fare2.setBounds(300, 404, 96, 29);
		panel_1.add(fare2);
		fare2.setColumns(10);
		
		JButton btnNewButton = new JButton("Clear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				location.setText("");
				space1.setText("");
				space2.setText("");
				fare1.setText("");
				fare2.setText("");
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnNewButton.setBounds(109, 513, 109, 43);
		panel_1.add(btnNewButton);
		
		JButton submitbtn = new JButton("Submit");
		submitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/instapark","root","Pass@123");
					String query = "insert into parkingspaces values(?,?,?,?,?)";
					PreparedStatement ps = con.prepareStatement(query);  
					ps.setString(1,  location.getText());
					ps.setString(2,  space1.getText());
					ps.setString(3,  fare1.getText());
					ps.setString(4,  space2.getText());
					ps.setString(5,  fare2.getText());
					JOptionPane.showMessageDialog(submitbtn,"succeed ");
					ps.executeUpdate();
					con.close();
					}
					catch(Exception e1) {
						e1.printStackTrace();
					}
			}
				
		});
		submitbtn.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		submitbtn.setBounds(271, 513, 108, 43);
		panel_1.add(submitbtn);
		
		JButton btnNewButton_2 = new JButton("Remove Space");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				if(table.getSelectedRowCount()==1) {
				model.removeRow(table.getSelectedRow());
				}}
		});
		btnNewButton_2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnNewButton_2.setBounds(803, 541, 176, 59);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_5 = new JButton("Refresh Table");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/instapark","root","Pass@123");
					Statement st = con.createStatement();
					String query = "select * from parkingspaces";
					ResultSet rs = st.executeQuery(query);
					ResultSetMetaData rsmd = rs.getMetaData();
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					//for column			
					int cols = rsmd.getColumnCount();
					String[] colName = new String[cols];
					for(int i=0;i<cols;i++) 
						colName[i] = rsmd.getColumnName(i+1);
						model.setColumnIdentifiers(colName);
					
						//for row
						String location,twowheeler,fourwheeler,twowheelerfare,fourwheelerfare ;
						while(rs.next()) {
							mainframe m = new mainframe();
							//String UN = rs.getString(1);
						
							location=rs.getString(1);
							twowheeler=rs.getString(2);
							twowheelerfare=rs.getString(3);
							fourwheeler= rs.getString(4);
							fourwheelerfare = rs.getString(5);
							String[] row = {location,twowheeler,fourwheeler,twowheelerfare,fourwheelerfare,null};
							model.addRow(row);
							System.out.print("succeed......");
						}
				} catch (SQLException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_5.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnNewButton_5.setBounds(562, 541, 156, 59);
		panel_1.add(btnNewButton_5);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("New Parking manager", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Full Name  ");
		lblNewLabel_8.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_8.setBounds(484, 67, 118, 25);
		panel_3.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Username");
		lblNewLabel_9.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_9.setBounds(484, 153, 118, 25);
		panel_3.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Password");
		lblNewLabel_10.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_10.setBounds(484, 334, 118, 25);
		panel_3.add(lblNewLabel_10);
		
		FullnameTB = new JTextField();
		FullnameTB.setBorder(null);
		FullnameTB.setForeground(new Color(0, 0, 0));
		FullnameTB.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		FullnameTB.setBounds(662, 66, 250, 26);
		panel_3.add(FullnameTB);
		FullnameTB.setColumns(10);
		
		usernameTB = new JTextField();
		usernameTB.setForeground(new Color(0, 0, 0));
		usernameTB.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		usernameTB.setBounds(662, 152, 250, 26);
		usernameTB.setBorder(null);
		panel_3.add(usernameTB);
		usernameTB.setColumns(10);
		
		passwordTB = new JTextField();
		passwordTB.setForeground(new Color(0, 0, 0));
		passwordTB.setBackground(new Color(255, 255, 255));
		passwordTB.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		passwordTB.setBorder(null);
		passwordTB.setBounds(662, 334, 250, 25);
		panel_3.add(passwordTB);
		passwordTB.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(178, 34, 34));
		panel_4.setBounds(0, 0, 354, 676);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		contactTB = new JTextField();
		contactTB.setForeground(new Color(0, 0, 0));
		contactTB.setBounds(663, 240, 249, 26);
		contactTB.setBorder(null);
		panel_3.add(contactTB);
		contactTB.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Add New Parking Manager");
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setBounds(26, 39, 395, 66);
		panel_4.add(lblNewLabel_7);
		lblNewLabel_7.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		
		
		
		
		
		JButton btnNewButton_3 = new JButton("Clear");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FullnameTB.setText("");
				usernameTB.setText("");
				passwordTB.setText("");
				buttonGroup.clearSelection();
				
			}
		});
		btnNewButton_3.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnNewButton_3.setBounds(543, 465, 118, 42);
		panel_3.add(btnNewButton_3);
		
		JButton signinbtn = new JButton("SignIn");
		signinbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/instapark","root","Pass@123");
					String query = "insert into parkingmanager values(?,?,?,?,?)";
					PreparedStatement ps = con.prepareStatement(query);  
					ps.setString(1, FullnameTB.getText());
					ps.setString(2, usernameTB.getText());
					ps.setString(3, "PARKING MANAGER");
					ps.setString(4, contactTB.getText());
					ps.setString(5, passwordTB.getText());
					JOptionPane.showMessageDialog(signinbtn,"succeed");
					ps.executeUpdate();
					con.close();
					}
				catch(Exception e1){
					e1.printStackTrace();
					}
			}
		});
		signinbtn.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		signinbtn.setBounds(774, 465, 111, 42);
		panel_3.add(signinbtn);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(662, 103, 253, 2);
		panel_3.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(665, 189, 250, 2);
		panel_3.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(662, 309, 250, 0);
		panel_3.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(662, 369, 250, 2);
		panel_3.add(separator_3);
		
		JLabel lblNewLabel_12 = new JLabel("Contact Number");
		lblNewLabel_12.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_12.setBounds(484, 241, 150, 25);
		panel_3.add(lblNewLabel_12);
		
	
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(665, 276, 247, 2);
		panel_3.add(separator_4);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Records", null, panel_2, null);
		panel_2.setLayout(null);
		
		table_1 = new JTable();
		table_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table_1.setBounds(58, 136, 826, 387);
		panel_2.add(table_1);
		
		JLabel lblNewLabel_2 = new JLabel("Records");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(58, 22, 151, 19);
		panel_2.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Refresh");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(167, 19, 97, 32);
		panel_2.add(btnNewButton_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//to show the location in jcombobox of record panel 
				
				
				
			}
		});
		comboBox.setBounds(167, 75, 179, 32);
		panel_2.add(comboBox);
		
		JLabel lblNewLabel_11 = new JLabel("location ");
		lblNewLabel_11.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel_11.setBounds(58, 72, 88, 32);
		panel_2.add(lblNewLabel_11);
	}
}
