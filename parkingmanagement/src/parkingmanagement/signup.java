package parkingmanagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class signup extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField FullName;
	private static JTextField UserName;
	private static JTextField EmailId;
	private static JPasswordField PASS;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private String UserType;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public signup() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 879, 573);
		setTitle("InstaPark - signup");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(50, 154, 231));
		panel_1.setBounds(0, 0, 363, 632);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("InstaPark ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(70, 24, 220, 50);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
		
		JLabel lblNewLabel_4 = new JLabel("Already have an account");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_4.setBounds(43, 189, 245, 29);
		panel_1.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainframe m = new mainframe();
				m.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 24));
		btnNewButton.setBounds(112, 260, 120, 43);
		panel_1.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(298, 0, 567, 536);
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Full Name");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(130, 130, 109, 22);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("User Name");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(130, 186, 109, 22);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("User Type");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(130, 293, 109, 22);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_6 = new JLabel("Email Id");
		lblNewLabel_6.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(130, 242, 109, 22);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_8 = new JLabel("Password");
		lblNewLabel_8.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel_8.setBounds(130, 337, 109, 22);
		panel.add(lblNewLabel_8);
		
		FullName = new JTextField();
		FullName.setBounds(285, 135, 228, 19);
		panel.add(FullName);
		FullName.setColumns(10);
		
		UserName = new JTextField();
		UserName.setBounds(285, 191, 228, 19);
		panel.add(UserName);
		UserName.setColumns(10);
		
		EmailId = new JTextField();
		EmailId.setBounds(285, 247, 228, 19);
		panel.add(EmailId);
		EmailId.setColumns(10);
		
		PASS = new JPasswordField();
		PASS.setBounds(285, 342, 228, 19);
		panel.add(PASS);
		
		JButton CLEARbtn = new JButton("clear");
		
		CLEARbtn.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		CLEARbtn.setBounds(132, 429, 149, 32);
		panel.add(CLEARbtn);
		
		JLabel lblSignUp = new JLabel("Sign up..");
		lblSignUp.setForeground(new Color(0, 0, 0));
		lblSignUp.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblSignUp.setBounds(226, 20, 220, 50);
		panel.add(lblSignUp);
		
		JRadioButton rb = new JRadioButton("USER");
		buttonGroup.add(rb);
		rb.setBounds(311, 297, 57, 21);
		panel.add(rb);
		
		JRadioButton rb2 = new JRadioButton("ADMIN");
		buttonGroup.add(rb2);
		rb2.setBounds(416, 297, 66, 21);
		panel.add(rb2);
		
		
		JButton SubmitBtn = new JButton("Submit");
		SubmitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//esultSet rs =ps.executeQuery(query);
					
				
						try {
							Class.forName("com.mysql.cj.jdbc.Driver");
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/instapark","root","Pass@123");
							String query = "insert into register values(?,?,?,?,?)";
							PreparedStatement ps = con.prepareStatement(query);  
							ps.setString(1,FullName.getText());
							ps.setString(2, UserName.getText());
							if(rb.isSelected())
								ps.setString(3,rb.getText());
							else if(rb2.isSelected())
								ps.setString(3,rb2.getText());
							ps.setString(4, EmailId.getText());
							ps.setString(5, PASS.getText());
							JOptionPane.showMessageDialog(SubmitBtn,"succeed ");
							ps.executeUpdate();
							con.close();
							
							FullName.setText("");
							UserName.setText("");
							EmailId.setText("");
							PASS.setText("");
							rb.setSelected(false);
							rb2.setSelected(false);
							//rb3.setSelected(false);
							buttonGroup.clearSelection();
						}
							catch(Exception e1) {
								e1.printStackTrace();
							}
			}
		});
		SubmitBtn.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		SubmitBtn.setBounds(333, 429, 149, 32);
		panel.add(SubmitBtn);
		
		
		
		
		
		CLEARbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FullName.setText("");
				UserName.setText("");
				EmailId.setText("");
				PASS.setText("");
				rb.setSelected(false);
				rb2.setSelected(false);
				//rb3.setSelected(false);
				buttonGroup.clearSelection();
				
			}
		});
		
		
	
	}
	public static void main(String[] args) {
		signup frame = new signup();
		frame.setVisible(true);
		
		
	}
}
