import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
	static String username;
	private JPanel contentPane;
	static JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("CheckBox.light"));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		 
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Sitka Text", Font.ITALIC, 11));
		lblNewLabel.setBounds(10, 41, 82, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.ITALIC, 11));
		lblNewLabel_1.setBounds(10, 171, 68, 14);
		contentPane.add(lblNewLabel_1); 
		
		textField = new JTextField();
		textField.setBackground(UIManager.getColor("Button.light"));
		textField.setBounds(185, 38, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBackground(UIManager.getColor("Button.light"));
		textField_1.setBounds(185, 168, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String pass;
				username=textField.getText();
				pass=textField_1.getText();
				try
				{
					java.sql.PreparedStatement query;
					ResultSet rs;
					
					Class.forName("java.sql.Driver");
					String connURL="jdbc:mysql://localhost/profile";
					String login="root"; //if you don't have login name and password for the database, empty string ("") works 
					String password=""; 
					Connection conn =DriverManager.getConnection(connURL,login,password);
					Statement command = conn.createStatement();
					 query=conn.prepareStatement("select * from regi where username = ? and password =?");
					query.setString(1, username);
					query.setString(2, pass);
				rs=query.executeQuery();
				if(rs.next())
					{
					JOptionPane.showMessageDialog(null, "Login sucessfull");
					Login log=new Login();
					Page pag=new Page();
					log.setVisible(false);
					pag.setVisible(true);
					}
				else
					{
						JOptionPane.showMessageDialog(null,"The username or password is incorrect");
					}
			
				}
				catch(Exception e)
				{
			JOptionPane.showMessageDialog(null,e);
				}
			}
		});
		btnLogin.setForeground(new Color(255, 51, 0));
		btnLogin.setBackground(SystemColor.windowBorder);
		btnLogin.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 11));
		btnLogin.setBounds(320, 37, 89, 23);
		contentPane.add(btnLogin);
		 
		JButton btnGoBack = new JButton("Go back");
		btnGoBack.setForeground(new Color(255, 51, 0));
		btnGoBack.setBackground(SystemColor.windowBorder);
		btnGoBack.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 11));
		btnGoBack.setBounds(320, 167, 89, 23);
		contentPane.add(btnGoBack);
	}
}
