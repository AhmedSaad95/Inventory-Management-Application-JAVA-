import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Admins extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	
	Connection cnx=null;
	PreparedStatement prepared=null; 
	ResultSet resultat=null;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Admins() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		cnx = ConnexionMysql.connexionDB();
		
		
		JLabel lblNewLabel = new JLabel("Shoes");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 27));
		lblNewLabel.setBounds(281, 25, 130, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Login :");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(70, 202, 65, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password :");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(33, 256, 100, 20);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				String sql="select password from user where (username=? ) and ( role=1 ) ";
				
				try {
					prepared = cnx.prepareStatement(sql);
					prepared.setString(1, textField.getText().toString());
					resultat = prepared.executeQuery();
					
					if (resultat.next()) {
						String password=resultat.getString("password");
						textField_1.setText(password);
					}
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		});
		textField.setBounds(145, 199, 121, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(145, 258, 121, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String sql = "insert into user (login, password, username,role) values ( ? , ? , ? , ? )";
				
				try {
					prepared = cnx.prepareStatement(sql);
					prepared.setString(1, textField.getText().toString());
					prepared.setString(2, textField_1.getText().toString());
					prepared.setString(3, textField.getText().toString());
					prepared.setInt(4, 1);
					
					if (!textField.getText().toString().equals("") && !textField_1.getText().toString().equals("")) {	
					prepared.execute();
					
				     JOptionPane.showMessageDialog(null, textField.getText().toString()+" ajouté comme Admin");
				     MenuAdmin obj = new MenuAdmin();
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
		btnNewButton.setBounds(327, 165, 104, 39);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Supprimer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String sql="delete from user where username=? and password=?";
				
				try {
					prepared=cnx.prepareStatement(sql);
					prepared.setString(1, textField.getText().toString());
					prepared.setString(2, textField_1.getText().toString());
					prepared.execute();
					JOptionPane.showMessageDialog(null, "Admin supprimé");
					MenuAdmin obj = new MenuAdmin();
					 obj.setVisible(true);
					 obj.setLocationRelativeTo(null);
					 setVisible(false);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(30, 144, 255));
		btnNewButton_1.setBounds(330, 215, 101, 41);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Annuler");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuAdmin obj = new MenuAdmin();
				 obj.setVisible(true);
				 obj.setLocationRelativeTo(null);
				 setVisible(false);
			}
		});
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(255, 69, 0));
		btnNewButton_2.setBounds(330, 267, 101, 41);
		contentPane.add(btnNewButton_2);
		
		JLabel lblGestionDesAdmins = new JLabel("Gestion des Admins");
		lblGestionDesAdmins.setForeground(new Color(255, 255, 255));
		lblGestionDesAdmins.setFont(new Font("Bahnschrift", Font.BOLD | Font.ITALIC, 20));
		lblGestionDesAdmins.setBounds(45, 88, 221, 41);
		contentPane.add(lblGestionDesAdmins);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Ahmed\\Desktop\\Projects\\App_JAVA\\images\\second.png"));
		lblNewLabel_3.setBounds(10, 140, 516, 192);
		contentPane.add(lblNewLabel_3);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Ahmed\\Desktop\\Projects\\App_JAVA\\images\\a.jpg"));
		label.setBounds(0, 0, 734, 464);
		contentPane.add(label);
	}
}
