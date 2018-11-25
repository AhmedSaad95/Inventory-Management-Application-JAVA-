import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;

public class panier extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	Connection cnx=null;
	PreparedStatement prepared=null; 
	ResultSet resultat=null;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public panier() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 751, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cnx = ConnexionMysql.connexionDB();
		
		JButton btnNewButton_2 = new JButton("Menu");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuAdmin obj = new MenuAdmin();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setBackground(new Color(255, 0, 0));
		btnNewButton_2.setBounds(10, 11, 105, 27);
		contentPane.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.BLUE));
		scrollPane.setEnabled(false);
		scrollPane.setBounds(155, 104, 415, 356);
		contentPane.add(scrollPane);
		
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, new Color(184, 134, 11)));
		table.setBackground(new Color(205, 133, 63));
		
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"id_produit","Quantité"
				}
			));
			scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Panier");
		lblNewLabel.setFont(new Font("Perpetua Titling MT", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(317, 45, 105, 37);
		contentPane.add(lblNewLabel);
		
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Ahmed\\Desktop\\Projects\\App_JAVA\\images\\a.jpg"));
		label.setBounds(0, 0, 735, 471);
		contentPane.add(label);
		
		
		String sql= "SELECT * from panier " ;
		try {
			prepared = cnx.prepareStatement(sql);
			resultat=prepared.executeQuery(sql);
			
			while(resultat.next()) {
				
				int id0=resultat.getInt("id_prod");
				String id1=Integer.toString(id0);
				int qte0=resultat.getInt("quantite");
				String qte1=Integer.toString(qte0);
				
				
				
				
				DefaultTableModel md = (DefaultTableModel)table.getModel();
				md.addRow(new Object[]{id1,qte1});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
