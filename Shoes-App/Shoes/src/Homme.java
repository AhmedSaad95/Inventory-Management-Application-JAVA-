import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
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
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Homme extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	Connection cnx=null;
	PreparedStatement prepared=null; 
	ResultSet resultat=null;
	private JTextField qte;
	private JTextField idField;
	

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Homme() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 866, 568);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cnx = ConnexionMysql.connexionDB();
		
		JLabel lblNewLabel = new JLabel("Homme");
		lblNewLabel.setBackground(UIManager.getColor("Button.background"));
		lblNewLabel.setForeground(UIManager.getColor("Button.background"));
		lblNewLabel.setFont(new Font("Minion Pro Cond", Font.BOLD | Font.ITALIC, 34));
		lblNewLabel.setBounds(356, 21, 168, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\Ahmed\\Desktop\\Projects\\App_JAVA\\images\\a.png"));
		lblNewLabel_7.setForeground(SystemColor.textHighlight);
		lblNewLabel_7.setBackground(SystemColor.textHighlight);
		lblNewLabel_7.setBounds(0, 78, 210, 178);
		contentPane.add(lblNewLabel_7);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.BLUE));
		scrollPane.setEnabled(false);
		scrollPane.setBounds(213, 78, 637, 451);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, new Color(184, 134, 11)));
		table.setBackground(new Color(205, 133, 63));
		
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"id_prod","Genre", "Marque", "Couleur", "Pointure", "Prix"
				}
			));
			scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Ajouter au panier");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sql = "insert into panier (id_prod, quantite) values ( ? , ? )";
				
				try {
					prepared = cnx.prepareStatement(sql);
					prepared.setString(1, idField.getText().toString());
					prepared.setString(2, qte.getText().toString());
					
					
					if (!idField.getText().toString().equals("") && !qte.getText().toString().equals("")) {	
						
					 prepared.execute();
				     JOptionPane.showMessageDialog(null, "Produit ajouté au panier");
				     idField.setText("");
				     qte.setText("");
					 }
					
			
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(0, 128, 0));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(10, 436, 193, 68);
		contentPane.add(btnNewButton);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 MenuClient obj = new MenuClient();
				 obj.setVisible(true);
				 obj.setLocationRelativeTo(null);
				 setVisible(false);
			}
		});
		btnMenu.setForeground(Color.WHITE);
		btnMenu.setBackground(Color.RED);
		btnMenu.setBounds(0, 11, 89, 23);
		contentPane.add(btnMenu);
		
		qte = new JTextField();
		qte.setBounds(117, 308, 86, 20);
		contentPane.add(qte);
		qte.setColumns(10);
		
		JLabel lblQuantit = new JLabel("Quantit\u00E9 :");
		lblQuantit.setForeground(Color.WHITE);
		lblQuantit.setBackground(Color.WHITE);
		lblQuantit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblQuantit.setBounds(28, 306, 79, 20);
		contentPane.add(lblQuantit);
		
		JLabel lblIdpr = new JLabel("id Produit :");
		lblIdpr.setForeground(Color.WHITE);
		lblIdpr.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblIdpr.setBackground(Color.WHITE);
		lblIdpr.setBounds(18, 368, 89, 20);
		contentPane.add(lblIdpr);
		
		idField = new JTextField();
		idField.setColumns(10);
		idField.setBounds(117, 370, 86, 20);
		contentPane.add(idField);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Ahmed\\Desktop\\Projects\\App_JAVA\\images\\c.jpg"));
		label.setBounds(0, 0, 850, 529);
		contentPane.add(label);
		
		String sql= "SELECT * from produit where genre='Homme' " ;
		try {
			prepared = cnx.prepareStatement(sql);
			resultat=prepared.executeQuery(sql);
			
			while(resultat.next()) {
				
				int id0=resultat.getInt("id");
				String id1=Integer.toString(id0);
				String Genre1=resultat.getString("genre");
				String Marque1=resultat.getString("marque");
				String Couleur1=resultat.getString("couleur");
				String Pointure1=resultat.getString("pointure");
				float Prix1=resultat.getFloat("prix");
				String pr=Float.toString(Prix1);
				
				
				
				
				DefaultTableModel md = (DefaultTableModel)table.getModel();
				md.addRow(new Object[]{id1,Genre1,Marque1,Couleur1,Pointure1,pr});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
				int ligne=table.getSelectedRow();
				String id2=table.getModel().getValueAt(ligne, 0).toString();
				String sql= "SELECT * from produit where id = '"+id2+"'";
				
				try {
					prepared = cnx.prepareStatement(sql);
					resultat = prepared.executeQuery();
					
					if(resultat.next()) {
						
						idField.setText(String.valueOf(resultat.getInt("id")));
						byte[] img = resultat.getBytes("image");
						ImageIcon image = new ImageIcon(img);
						java.awt.Image im = image.getImage();
						java.awt.Image myImg = im.getScaledInstance(lblNewLabel_7.getWidth(), lblNewLabel_7.getHeight(), java.awt.Image.SCALE_SMOOTH);
						ImageIcon imggg = new ImageIcon(myImg);
						lblNewLabel_7.setIcon(imggg);
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
	}
	}


