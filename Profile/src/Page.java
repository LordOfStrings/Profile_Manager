import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Page extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() { 
				try {
					Page frame = new Page();
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
	public Page() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane); 
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\profileface1.jpg"));
		lblNewLabel.setBounds(10, 21, 98, 86);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(216, 21, 143, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setFont(new Font("Stencil", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(226, 54, 143, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("Tekton Pro", Font.BOLD, 13));
		lblNewLabel_3.setBounds(216, 79, 143, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblName = new JLabel("NAME:-");
		lblName.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 11));
		lblName.setBounds(118, 30, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblAge = new JLabel("AGE:-");
		lblAge.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 11));
		lblAge.setBounds(118, 54, 46, 14);
		contentPane.add(lblAge);
		
		JLabel lblPhonenumber = new JLabel("Phonenumber");
		lblPhonenumber.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 11));
		lblPhonenumber.setBounds(118, 79, 90, 14);
		contentPane.add(lblPhonenumber);
		java.sql.PreparedStatement name,age,phoneno;
		ResultSet rs,rs1,rs2;
		try {
			String named=Login.username;
		Class.forName("java.sql.Driver");
		String connURL="jdbc:mysql://localhost/profile"; 
		String login="root"; //if you don't have login name and password for the database, empty string ("") works 
		String password=""; 
		Connection conn =DriverManager.getConnection(connURL,login,password);
		Statement command = conn.createStatement();
		 name=conn.prepareStatement("select name,age,Phonenumber from regi where username = '"+ named + "'");
		// age=conn.prepareStatement("select age from regi where username = '"+ named + "'");
		// phoneno=conn.prepareStatement("select Phonenumber from regi where username = '"+ named + "'");
		rs=name.executeQuery();
		//rs1=age.executeQuery();
		//rs2=age.executeQuery();
		if(rs.next())
		 { 
			 lblNewLabel_1.setText(rs.getString(1));
			 lblNewLabel_2.setText(rs.getString(2));
			 lblNewLabel_3.setText(rs.getString(3));
		 }
	
		 
		}
		catch(Exception e)
			{
			JOptionPane.showMessageDialog(null,e);
			}
		}

}
