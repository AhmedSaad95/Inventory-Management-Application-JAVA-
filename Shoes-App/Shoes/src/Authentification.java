import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Authentification {

	JFrame frame;
	private JTextField loginfield;
	private JPasswordField passwordfield;
	
	Connection cnx=null;
	PreparedStatement prepared=null; 
	ResultSet resultat=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Authentification window = new Authentification();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Authentification() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(0, 0, 255));
		frame.setBounds(300, 100, 663, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		cnx = ConnexionMysql.connexionDB();
		
		
		JLabel lblBienvenue = new JLabel("Bienvenue");
		lblBienvenue.setBackground(Color.LIGHT_GRAY);
		lblBienvenue.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenue.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 30));
		lblBienvenue.setForeground(Color.WHITE);
		lblBienvenue.setBounds(229, 69, 175, 53);
		frame.getContentPane().add(lblBienvenue);
		
		JLabel lblNewLabel = new JLabel("Login :");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		lblNewLabel.setBounds(156, 151, 49, 19);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password :");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(156, 202, 87, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		loginfield = new JTextField();
		loginfield.setBounds(253, 152, 204, 20);
		frame.getContentPane().add(loginfield);
		loginfield.setColumns(10);
		
		passwordfield = new JPasswordField();
		passwordfield.setBounds(253, 201, 204, 20);
		frame.getContentPane().add(passwordfield);
		
		JButton btnNewButton = new JButton("Se connecter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String login =loginfield.getText().toString();
				String password =passwordfield.getText().toString();
				
				String sql="select login , password , role from user";
				try {
					
					prepared = cnx.prepareStatement(sql);
					resultat = prepared.executeQuery();
					
						int i=0;
						while(resultat.next()) {
						
							String login1 = resultat.getString("login");
							String password1 = resultat.getString("password");
							int role1=resultat.getInt("role");
						
							if(login1.equals(login) && password1.equals(password) && role1==1)
							{
								MenuAdmin obj = new MenuAdmin();
								obj.setVisible(true);
								obj.setLocationRelativeTo(null);
								frame.setVisible(false);
								i = 1;
								
							}
							else if(login1.equals(login) && password1.equals(password) && role1==0) {
								MenuClient obj = new MenuClient();
								obj.setVisible(true);
								obj.setLocationRelativeTo(null);
								frame.setVisible(false);
								i = 1;
							}
							
							
						
						}
						
						
						if(i==0) JOptionPane.showMessageDialog(null, "Connexion Echouée ! (information incorrecte)");
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
		
				}
				
			}
		});
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(126, 266, 135, 32);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginfield.setText(null);
				passwordfield.setText(null);
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(30, 144, 255));
		btnNewButton_1.setBounds(329, 266, 75, 32);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(255, 0, 0));
		btnNewButton_2.setBounds(461, 266, 75, 32);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Nouveau sur Shoes ? S'inscrire maintenant");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Inscription obj1 = new Inscription();
				obj1.setVisible(true);
				obj1.setLocationRelativeTo(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(0, 128, 0));
		btnNewButton_3.setBounds(186, 371, 271, 32);
		frame.getContentPane().add(btnNewButton_3);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Ahmed\\Desktop\\Projects\\App_JAVA\\images\\second.png"));
		label.setBounds(101, 69, 457, 249);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Ahmed\\Desktop\\Projects\\App_JAVA\\images\\a.jpg"));
		lblNewLabel_2.setBounds(0, 0, 647, 421);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
