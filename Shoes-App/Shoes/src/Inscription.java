import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Inscription extends JFrame {

	private JPanel contentPane;
	private JTextField usernameField;
	private JTextField loginField;
	private JPasswordField passwordField;
	
	Connection cnx=null;
	PreparedStatement prepared=null; 
	ResultSet resultat=null;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Inscription() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 506, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		cnx = ConnexionMysql.connexionDB();
		
		JLabel lblInscription = new JLabel("Inscription");
		lblInscription.setForeground(new Color(255, 255, 255));
		lblInscription.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 23));
		lblInscription.setBounds(179, 23, 127, 26);
		contentPane.add(lblInscription);
		
		JLabel lblNewLabel = new JLabel("Username : ");
		lblNewLabel.setFont(new Font("Arial Unicode MS", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(50, 142, 92, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Password :");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Arial Unicode MS", Font.BOLD, 15));
		lblNewLabel_2.setBounds(50, 222, 92, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblLogin = new JLabel("Login :");
		lblLogin.setForeground(new Color(255, 255, 255));
		lblLogin.setFont(new Font("Arial Unicode MS", Font.BOLD, 15));
		lblLogin.setBounds(87, 180, 55, 19);
		contentPane.add(lblLogin);
		
		usernameField = new JTextField();
		usernameField.setBounds(179, 141, 154, 20);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		loginField = new JTextField();
		loginField.setBounds(179, 181, 154, 20);
		contentPane.add(loginField);
		loginField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(179, 221, 154, 20);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("S'inscrire");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String sql="insert into user (login, password, username) values ( ? , ? , ? )";
				
				try {
					prepared = cnx.prepareStatement(sql);
					prepared.setString(1, loginField.getText().toString());
					prepared.setString(2, passwordField.getText().toString());
					prepared.setString(3, usernameField.getText().toString());
					
					if (!loginField.getText().toString().equals("") && !passwordField.getText().toString().equals("") && !usernameField.getText().toString().equals("")) {	
					prepared.execute();
					
				     JOptionPane.showMessageDialog(null,"Bienvenue "+usernameField.getText().toString());
				     MenuClient obj = new MenuClient();
					 obj.setVisible(true);
					 obj.setLocationRelativeTo(null);
					 setVisible(false);
					 }
					
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(196, 301, 127, 34);
		contentPane.add(btnNewButton);
		
		JButton Annuler = new JButton("Annuler");
		Annuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Authentification window = new Authentification();
				window.frame.setVisible(true);
				setVisible(false);
			}
		});
		Annuler.setForeground(new Color(255, 255, 255));
		Annuler.setBackground(new Color(255, 0, 0));
		Annuler.setFont(new Font("Tahoma", Font.BOLD, 12));
		Annuler.setBounds(214, 366, 100, 26);
		contentPane.add(Annuler);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Ahmed\\Desktop\\Projects\\App_JAVA\\images\\second.png"));
		lblNewLabel_1.setBounds(36, 88, 414, 336);
		contentPane.add(lblNewLabel_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Ahmed\\Desktop\\Projects\\App_JAVA\\images\\a.jpg"));
		label.setBounds(0, 0, 490, 451);
		contentPane.add(label);
	}
}
