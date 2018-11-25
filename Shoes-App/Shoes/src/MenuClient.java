import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuClient extends JFrame {

	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public MenuClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 866, 568);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Homme obj = new Homme();
				 obj.setVisible(true);
				 obj.setLocationRelativeTo(null);
				 setVisible(false);
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Ahmed\\Desktop\\Projects\\App_JAVA\\images\\h.jpg"));
		btnNewButton.setBounds(88, 205, 250, 199);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("D\u00E9connexion");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Authentification wind = new Authentification();
				wind.frame.setVisible(true);
				setVisible(false);
			}
		});
		
		
		btnNewButton_2.setBackground(Color.RED);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBounds(717, 11, 123, 36);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 Femme obj = new Femme();
				 obj.setVisible(true);
				 obj.setLocationRelativeTo(null);
				 setVisible(false);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Ahmed\\Desktop\\Projects\\App_JAVA\\images\\f.jpg"));
		btnNewButton_1.setBounds(503, 205, 250, 199);
		contentPane.add(btnNewButton_1);
		
		JLabel lblHomme = new JLabel("Homme");
		lblHomme.setFont(new Font("Harlow Solid Italic", Font.BOLD | Font.ITALIC, 22));
		lblHomme.setForeground(Color.WHITE);
		lblHomme.setBounds(161, 110, 94, 42);
		contentPane.add(lblHomme);
		
		JLabel lblFemme = new JLabel("Femme");
		lblFemme.setForeground(Color.WHITE);
		lblFemme.setFont(new Font("Harlow Solid Italic", Font.BOLD | Font.ITALIC, 22));
		lblFemme.setBounds(588, 110, 94, 42);
		contentPane.add(lblFemme);
		
		
		
		JLabel lblNewLabel = new JLabel("Catalogue");
		lblNewLabel.setBackground(UIManager.getColor("Button.background"));
		lblNewLabel.setForeground(UIManager.getColor("Button.background"));
		lblNewLabel.setFont(new Font("Minion Pro Cond", Font.BOLD | Font.ITALIC, 34));
		lblNewLabel.setBounds(356, 21, 168, 42);
		contentPane.add(lblNewLabel);
		
		
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Ahmed\\Desktop\\Projects\\App_JAVA\\images\\c.jpg"));
		label.setBounds(0, 0, 850, 529);
		contentPane.add(label);
	}
}
