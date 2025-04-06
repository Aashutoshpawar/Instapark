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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;

public class ParkingManager_Dashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable table1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	
	

	/**
	 * Create the frame.
	 */
	public ParkingManager_Dashboard() {
		setTitle("Parking Manager Dashboard\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1020, 606);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 0, 0);
		//panel.setBounds(213, 10, 10, 10);
		contentPane.add(panel);
		

		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1221, 676);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Slot Allotment", null, panel_1, null);
		panel_1.setLayout(null);
		
		JRadioButton deallocateRB = new JRadioButton("DeAllocate");
		deallocateRB.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		deallocateRB.setBounds(813, 242, 135, 51);
		panel_1.add(deallocateRB);
		buttonGroup.add(deallocateRB);
		
		JRadioButton allocateRB = new JRadioButton("Allocate");
		allocateRB.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		allocateRB.setBounds(638, 242, 135, 51);
		panel_1.add(allocateRB);
		buttonGroup.add(allocateRB);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Records", null, panel_2, null);
		panel_2.setLayout(null);
		
		JComboBox Location = new JComboBox();
		
		Location.setModel(new DefaultComboBoxModel(new String[] {"select"}));
		Location.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		Location.setBounds(638, 51, 292, 51);
		panel_1.add(Location);
		
		JButton submitbtn = new JButton("Submit");
		submitbtn.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		
		submitbtn.setBounds(638, 350, 165, 60);
		panel_1.add(submitbtn);
		
		JComboBox number = new JComboBox();
		number.setModel(new DefaultComboBoxModel(new String[] {"select", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"}));
		number.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		number.setBounds(638, 151, 103, 42);
		panel_1.add(number);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 38, 577, 403);
		panel_1.add(scrollPane);
		
		table1 = new JTable();
		scrollPane.setViewportView(table1);
		table1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		JButton btnNewButton_2 = new JButton("Load Table");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//load data button action 
				
					
					// to display the records of the parking 
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/instapark","root","Pass@123");
						Statement st = con.createStatement();
						String query = "select * from records";
						ResultSet rs = st.executeQuery(query);
						ResultSetMetaData rsmd = rs.getMetaData();
						DefaultTableModel model = (DefaultTableModel) table1.getModel();
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
	
		btnNewButton_2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
				btnNewButton_2.setBounds(183, 451, 228, 51);
		panel_1.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// code for refresh label 
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/instapark","root","Pass@123");
					Statement st = con.createStatement();
					String query = "select * from parkingspaces";
					ResultSet rs = st.executeQuery(query);
					while(rs.next()) {
						String name = rs.getString("location");
						Location.addItem(name);
						String query1 = "select * from parkingspaces WHERE row_id = ? ";
						String space = rs.getString("2-Wheeler Space");
						number.addItem(space);
						}
					con.close();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\aashu\\OneDrive\\Desktop\\project\\assets\\icons\\icons8-refresh-24.png"));
		lblNewLabel_1.setBounds(950, 63, 63, 29);
		panel_1.add(lblNewLabel_1);
		
	
		JButton btnNewButton = new JButton("refresh");
		btnNewButton.addActionListener(new ActionListener() {
			
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
							String UN = rs.getString(1);
						
							location=rs.getString(1);
							twowheeler=rs.getString(2);
							twowheelerfare=rs.getString(3);
							fourwheeler= rs.getString(4);
							fourwheelerfare = rs.getString(5);
							String[] row = {location,twowheeler,twowheelerfare,fourwheeler,fourwheelerfare,null};
							model.addRow(row);
							System.out.print("succeed......");
						}
				} catch (SQLException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
			
				}
			}
		});
		
		btnNewButton.setBounds(348, 464, 241, 49);
		panel_2.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Parking History");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNewLabel.setBounds(37, 10, 160, 41);
		panel_2.add(lblNewLabel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(105, 78, 749, 348);
		panel_2.add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
	}

public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				ParkingManager_Dashboard frame = new ParkingManager_Dashboard();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}	
}
