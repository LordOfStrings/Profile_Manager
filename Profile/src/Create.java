import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class Create extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton btnGoBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Create frame = new Create();
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
	public Create() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("CheckBox.light"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Stencil Std", Font.PLAIN, 11));
		lblName.setBackground(Color.YELLOW);
		lblName.setBounds(10, 11, 58, 14);
		contentPane.add(lblName);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Stencil Std", Font.PLAIN, 11));
		lblAge.setBounds(10, 68, 58, 14);
		contentPane.add(lblAge);
		
		JLabel lblPhoneNo = new JLabel("Phone number");
		lblPhoneNo.setFont(new Font("Stencil Std", Font.PLAIN, 11));
		lblPhoneNo.setBounds(10, 122, 116, 14);
		contentPane.add(lblPhoneNo);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Stencil Std", Font.PLAIN, 11));
		lblUsername.setBounds(10, 170, 86, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Stencil Std", Font.PLAIN, 11));
		lblPassword.setBounds(10, 225, 72, 14);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 11));
		textField.setBackground(Color.GRAY);
		textField.setBounds(158, 8, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 11));
		textField_1.setBackground(Color.GRAY);
		textField_1.setBounds(158, 65, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 11));
		textField_2.setBackground(Color.GRAY);
		textField_2.setBounds(158, 119, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 11));
		textField_3.setBackground(Color.GRAY);
		textField_3.setBounds(158, 167, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 11));
		textField_4.setBackground(Color.GRAY);
		textField_4.setBounds(158, 222, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBackground(SystemColor.activeCaption);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String pass,name,age,phoneno,user;
				name=textField.getText();
			
				age=textField_1.getText();
				phoneno=textField_2.getText();
				user=textField_3.getText();
				pass=textField_4.getText();
				
				
				if (age.matches("[a-zA-Z]+"))
				{
					JOptionPane.showMessageDialog(null,"Please enter name in characters");
					textField_1.setText("");
					return;
				}
				if (!name.matches("[a-zA-Z]+"))
				{
					JOptionPane.showMessageDialog(null,"Please enter name in characters");
					textField.setText("");
					return;
				}
				if (phoneno.matches("[a-zA-Z]+"))
				{
					JOptionPane.showMessageDialog(null,"Please enter phone no in numbers");
					textField_2.setText("");
					return;
				} 
				
				
				try {
					Class.forName("java.sql.Driver");
					String connURL="jdbc:mysql://localhost/profile";
					String login="root"; //if you don't have login name and password for the database, empty string ("") works 
					String password=""; 
					Connection conn =DriverManager.getConnection(connURL,login,password);
					Statement command = conn.createStatement();
					
				command.execute("insert into regi values('" +name+ "','" + age +"','" + phoneno+"','" + user +"','" + age +"')");
				JOptionPane.showMessageDialog(null, "Records entered");
				}
			
				catch(SQLIntegrityConstraintViolationException e)
					{
					JOptionPane.showMessageDialog(null,"User name already exists");
					textField_3.setText("");
					}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,"Some error occured" +e);
				}  
			}
		});
		btnRegister.setFont(new Font("Tekton Pro Cond", Font.PLAIN, 12));
		btnRegister.setForeground(new Color(153, 51, 153));
		btnRegister.setBounds(290, 65, 89, 23);
		contentPane.add(btnRegister);
		
		btnGoBack = new JButton("Go back");
		btnGoBack.setBackground(SystemColor.activeCaption);
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Profile pro=new Profile();
				Create cr=new Create();
				pro.setVisible(true);
				cr.setVisible(false);
			}
		});
		btnGoBack.setFont(new Font("Tekton Pro", Font.PLAIN, 12));
		btnGoBack.setForeground(new Color(255, 51, 51));
		btnGoBack.setBounds(290, 167, 89, 23);
		contentPane.add(btnGoBack);
	}
}
