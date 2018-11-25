import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuAdmin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public MenuAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 751, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Shoes");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 27));
		lblNewLabel.setBounds(298, 60, 103, 41);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admins obj = new Admins();
				 obj.setVisible(true);
				 obj.setLocationRelativeTo(null);
				 setVisible(false);
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Ahmed\\Desktop\\Projects\\App_JAVA\\images\\admin.png"));
		btnNewButton.setBounds(49, 160, 134, 140);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GestionProd obj = new GestionProd();
				 obj.setVisible(true);
				 obj.setLocationRelativeTo(null);
				 setVisible(false);
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Ahmed\\Desktop\\Projects\\App_JAVA\\images\\ch.png"));
		btnNewButton_1.setBounds(290, 160, 134, 140);
		contentPane.add(btnNewButton_1);
		
		JLabel lblAdmins = new JLabel("ADMINS");
		lblAdmins.setForeground(new Color(255, 255, 255));
		lblAdmins.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblAdmins.setBounds(77, 329, 80, 14);
		contentPane.add(lblAdmins);
		
		JLabel lblNewLabel_1 = new JLabel("Produits");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1.setBounds(328, 329, 73, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("D\u00E9connexion");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Authentification window = new Authentification();
				window.frame.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setBackground(new Color(255, 0, 0));
		btnNewButton_2.setBounds(569, 24, 156, 35);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				panier obj = new panier();
				 obj.setVisible(true);
				 obj.setLocationRelativeTo(null);
				 setVisible(false);
			}
		});
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\Ahmed\\Desktop\\Projects\\App_JAVA\\images\\pa.jpg"));
		btnNewButton_3.setBounds(530, 160, 134, 140);
		contentPane.add(btnNewButton_3);
		
		JLabel lblCommande = new JLabel("Commande");
		lblCommande.setForeground(Color.WHITE);
		lblCommande.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblCommande.setBounds(547, 331, 103, 20);
		contentPane.add(lblCommande);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Ahmed\\Desktop\\Projects\\App_JAVA\\images\\a.jpg"));
		label.setBounds(0, 0, 735, 471);
		contentPane.add(label);
	}
}
