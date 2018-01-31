import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.JLabel;

public class Profile extends JFrame {
 

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				
					Profile frame = new Profile();
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
	public Profile() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\java image.jpg"));
		setBackground(new Color(204, 204, 153));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 304);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(new Color(255, 255, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED),"Login",TitledBorder.CENTER,TitledBorder.TOP,new Font("SANS_SERIF",Font.BOLD,14)));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login log=new Login();
				Profile pro=new Profile();
				log.setVisible(true);
				pro.setVisible(false);
			}
		});
		btnLogin.setForeground(SystemColor.desktop);
		btnLogin.setBackground(SystemColor.activeCaption);
		btnLogin.setFont(new Font("Tekton Pro", Font.PLAIN, 13));
		btnLogin.setBounds(149, 50, 115, 23);
		contentPane.add(btnLogin);
		
		JButton btnCreateAAccount = new JButton("Create a account");
		btnCreateAAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Create cre=new Create();
				Profile pre=new Profile();
				cre.setVisible(true);
				pre.setVisible(false);
			}
		});
		btnCreateAAccount.setForeground(SystemColor.desktop);
		btnCreateAAccount.setBackground(SystemColor.activeCaption);
		btnCreateAAccount.setFont(new Font("Tekton Pro Ext", Font.PLAIN, 10));
		btnCreateAAccount.setBounds(149, 217, 130, 23);
		contentPane.add(btnCreateAAccount);
	}
}
