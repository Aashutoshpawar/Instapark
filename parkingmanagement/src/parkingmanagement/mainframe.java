package parkingmanagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class mainframe extends JFrame {

	private static final long serialVersionUID = 1L;
	protected static final String userTest = null;
	private JPanel contentPane;
	private JTextField edtUsername;
	private JPasswordField edtPassword;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainframe frame = new mainframe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public mainframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 471, 408);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("InstaPark");

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Instapark ");
		lblNewLabel.setBounds(180, 10, 92, 39);
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(65, 89, 92, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(65, 139, 92, 22);
		contentPane.add(lblNewLabel_2);
		
		edtUsername = new JTextField();
		edtUsername.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		edtUsername.setBounds(180, 90, 207, 19);
		contentPane.add(edtUsername);
		edtUsername.setColumns(10);
		edtUsername.setBorder(null);
		
		JComboBox usertype = new JComboBox();
		usertype.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		usertype.setModel(new DefaultComboBoxModel(new String[] {"none", "USER", "ADMIN", "PARKING MANAGER"}));
		usertype.setSelectedIndex(0);
		usertype.setBounds(180, 197, 207, 21);
		contentPane.add(usertype);
		
		edtPassword = new JPasswordField();
		edtPassword.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		edtPassword.setBounds(180, 140, 207, 19);
		contentPane.add(edtPassword);
		edtPassword.setBorder(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(180, 118, 207, 19);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(180, 168, 207, 19);
		contentPane.add(separator_1);
		
		JButton clearbtn = new JButton("Clear");
		clearbtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				edtUsername.setText("");
				edtPassword.setText("");
				usertype.setSelectedIndex(0);
			
					
			}
		});
		clearbtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		clearbtn.setBounds(93, 263, 102, 29);
		clearbtn.setBorder(null);
		contentPane.add(clearbtn);
		
		JButton Loginbtn = new JButton("Login");
		Loginbtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
								Class.forName("com.mysql.cj.jdbc.Driver");
								Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/instapark","root","Pass@123");
								System.out.print("connection established");
								
								String username = edtUsername.getText();
								String userTest = username;
								String Password = edtPassword.getText();
								String Usertype = usertype.getSelectedItem().toString();
								System.out.println();
								System.out.print(Usertype);
								Statement stm = con.createStatement();
								String sql = "select * from register where username = '"+username+"'and Password = '"+Password+"'";
								ResultSet rs = stm.executeQuery(sql);
								
						
									if(username.equals("")||Password.equals("")||Usertype.equals(""))
									{
										JOptionPane.showMessageDialog(Loginbtn,"wrong credentials please try again");
										
										edtUsername.setText("");
										edtPassword.setText("");
										usertype.setSelectedIndex(0);	
						
									}else{
										
										if(rs.next())
										{
											String s1 = rs.getString("UserType");
											
												if(Usertype.equalsIgnoreCase("USER") && s1.equalsIgnoreCase("USER"))
												{
														Dashboard D = new Dashboard();
														D.setVisible(true);
														setVisible(false);
												}
									
												if(Usertype.equalsIgnoreCase("ADMIN")&& s1.equalsIgnoreCase("ADMIN"))
												{
														Admin_Dashboard AD = new Admin_Dashboard();
														AD.setVisible(true);
														setVisible(false);
														
												}
												
												if(Usertype.equalsIgnoreCase("PARKING MANAGER")&& s1.equalsIgnoreCase("PARKING MANAGER"))
												{
														ParkingManager_Dashboard PD = new ParkingManager_Dashboard();
														PD.setVisible(true);
														setVisible(false);
														
									
												}}
										else
										{
											JOptionPane.showMessageDialog(rootPane,"entered credentials wrong please try again","Error",1);
										}
									
											con.close();
										}
				
						}
				
				catch(Exception e1) {
					System.out.print(e1.getMessage());
					
				}
				
				
			
			}
		});
		Loginbtn.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		Loginbtn.setBounds(272, 262, 115, 29);
		contentPane.add(Loginbtn);
		
	
		
		
		JLabel lblNewLabel_3 = new JLabel("User type");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(65, 193, 85, 22);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("dont have an account here signin");
		lblNewLabel_4.setForeground(new Color(0, 0, 255));
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(41, 339, 222, 22);
		contentPane.add(lblNewLabel_4);
		
		JButton signinbtn = new JButton("signin");
		signinbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==signinbtn) {
					signup s = new signup();
					s.setVisible(true);
					setVisible(false);
				}
			}
		});
		signinbtn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		signinbtn.setBounds(272, 339, 86, 22);
		contentPane.add(signinbtn);
		
	}
	
}
