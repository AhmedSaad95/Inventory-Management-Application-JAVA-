import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class GestionProd extends JFrame {

	private JPanel contentPane;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;
	private String s ;
	
	Connection cnx=null;
	PreparedStatement prepared=null; 
	ResultSet resultat=null;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public GestionProd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cnx = ConnexionMysql.connexionDB();
		
		JLabel lblNewLabel = new JLabel("Gestion des produits ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 21));
		lblNewLabel.setBounds(281, 11, 222, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Genre :");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(39, 105, 73, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Marque :");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(29, 158, 73, 32);
		contentPane.add(lblNewLabel_2);
		
		
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\Ahmed\\Desktop\\Projects\\App_JAVA\\images\\a.png"));
		lblNewLabel_7.setForeground(SystemColor.textHighlight);
		lblNewLabel_7.setBackground(SystemColor.textHighlight);
		lblNewLabel_7.setBounds(254, 78, 210, 178);
		contentPane.add(lblNewLabel_7);
		
		
		JLabel lblNewLabel_3 = new JLabel("Couleur :");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(23, 217, 79, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Pointure :");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(20, 257, 92, 32);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Prix :");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(54, 312, 63, 28);
		contentPane.add(lblNewLabel_5);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(122, 215, 111, 28);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(122, 261, 111, 28);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(122, 314, 80, 28);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(SystemColor.desktop);
		comboBox.setBackground(new Color(169, 169, 169));
		comboBox.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Adidas", "Nike", "Puma", "Reebok"}));
		comboBox.setBounds(122, 166, 99, 20);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setForeground(SystemColor.controlText);
		comboBox_1.setBackground(new Color(169, 169, 169));
		comboBox_1.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 13));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Homme", "Femme"}));
		comboBox_1.setBounds(122, 113, 99, 20);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel_6 = new JLabel("(Dinars)");
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(205, 328, 63, 14);
		contentPane.add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String genre = comboBox_1.getSelectedItem().toString();
				String marque = comboBox.getSelectedItem().toString();
				String couleur = textField_2.getText().toString();
				String pointure = textField_3.getText().toString();
				float prix = Float.parseFloat(textField_4.getText());
				
				try { 
					
					if (!couleur.equals("") && !pointure.equals("") && !String.valueOf(prix).equals("")) 
					{	
						String sql="insert into produit (genre, marque, couleur, pointure, prix, image) values ( ? , ? , ? , ? , ? , ?)";
						InputStream imgg = new FileInputStream(new File(s));
						prepared = cnx.prepareStatement(sql);
						prepared.setString(1, genre);
						prepared.setString(2, marque);
						prepared.setString(3, couleur);
						prepared.setString(4, pointure);
						prepared.setFloat(5, prix);	
						prepared.setBlob(6, imgg);
					    prepared.execute();
					
				     JOptionPane.showMessageDialog(null,"Produit Ajouté :D ");
				     MenuAdmin obj = new MenuAdmin();
				     obj.setLocationRelativeTo(null);
					 obj.setVisible(true);
					 setVisible(false);
					 
					 }
					
					
				} catch (SQLException | FileNotFoundException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(23, 406, 99, 39);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Supprimer");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int ligne = table.getSelectedRow();
				
				if(ligne == -1 )
				{
					JOptionPane.showMessageDialog(null, "Sélectionnez un Produit !");
				}
				
				else {
					
					String id4=table.getModel().getValueAt(ligne, 0).toString();
					
					String sql = "delete from produit where id = '"+id4+"'    ";
					
					try {
						
						prepared = cnx.prepareStatement(sql);
					    prepared.execute();
					    JOptionPane.showMessageDialog(null, "Produit Supprimé !");
					    
					    MenuAdmin obj = new MenuAdmin();
						 obj.setVisible(true);
						 obj.setLocationRelativeTo(null);
						 setVisible(false);
					    
					    
					    
						
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				}}
		});
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(288, 406, 105, 39);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Modifier");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int ligne = table.getSelectedRow();
				
				if(ligne == -1 )
				{
					JOptionPane.showMessageDialog(null, "Sélectionnez un Produit !");
				}
				
				else {
					
					String id4=table.getModel().getValueAt(ligne, 0).toString();
					
					String sql = "Update produit set genre = ? , marque = ? , couleur = ? , pointure = ? , prix = ? , image = ? where id = '"+id4+"'    ";
					
					try {
						InputStream in = new FileInputStream(new File(s));
						prepared = cnx.prepareStatement(sql);
			
						prepared.setString(1, comboBox_1.getSelectedItem().toString());
						prepared.setString(2, comboBox.getSelectedItem().toString());
						prepared.setString(3, textField_2.getText().toString());
						prepared.setString(4, textField_3.getText().toString());
						prepared.setFloat(5, Float.parseFloat(textField_4.getText()));	
						prepared.setBlob(6, in);
						
					    prepared.execute();
					    JOptionPane.showMessageDialog(null, "Produit Modifié !");
					    
					    
					    
						
						
					} catch (SQLException | FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					
					
					
					
				}
			}
		});
		btnNewButton_2.setBackground(new Color(30, 144, 255));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBounds(156, 406, 99, 39);
		contentPane.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.BLUE));
		scrollPane.setEnabled(false);
		scrollPane.setBounds(474, 78, 350, 422);
		contentPane.add(scrollPane);
		
		table = new JTable();
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
						comboBox_1.setSelectedItem(resultat.getString("genre"));
						comboBox.setSelectedItem(resultat.getString("marque"));
						textField_2.setText(resultat.getString("couleur"));
						textField_3.setText(resultat.getString("pointure"));
						textField_4.setText(String.valueOf(resultat.getFloat("prix")));
						
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
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id_prod","Genre", "Marque", "Couleur", "Pointure", "Prix"
			}
		));
		scrollPane.setViewportView(table);
		
		
		
		
		
		
		
		
		JButton btnNewButton_3 = new JButton("Parcourir");
		btnNewButton_3.setBackground(new Color(135, 206, 235));
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File("D:"));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("IMAGE", "jpg","png","gif");
				fileChooser.addChoosableFileFilter(filter);
				int result = fileChooser.showSaveDialog(null);
				
				if(result == JFileChooser.APPROVE_OPTION)
				{
					File selectedfile = fileChooser.getSelectedFile();
					String path = selectedfile.getAbsolutePath();
					ImageIcon myImage = new ImageIcon(path);
					java.awt.Image img = myImage.getImage();
					java.awt.Image newImage = img.getScaledInstance(lblNewLabel_7.getWidth(), 
							lblNewLabel_7.getHeight(), java.awt.Image.SCALE_SMOOTH);
					ImageIcon finalImg = new ImageIcon(newImage);
					lblNewLabel_7.setIcon(finalImg);
					s = path ;
				}else
				{
					if(result == JFileChooser.CANCEL_OPTION)
						JOptionPane.showMessageDialog(null, "t'as Rien choisi");
				}
				
			}
		});
		
		JButton btnNewButton_4 = new JButton("Menu");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuAdmin obj = new MenuAdmin();
				 obj.setVisible(true);
				 obj.setLocationRelativeTo(null);
				 setVisible(false);
			}
		});
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBackground(new Color(255, 0, 0));
		btnNewButton_4.setBounds(0, 23, 89, 23);
		contentPane.add(btnNewButton_4);
		btnNewButton_3.setBounds(254, 256, 210, 39);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_8 = new JLabel("Table des produits");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		lblNewLabel_8.setBounds(612, 48, 135, 20);
		contentPane.add(lblNewLabel_8);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Ahmed\\Desktop\\Projects\\App_JAVA\\images\\c.jpg"));
		label.setBounds(0, 0, 834, 511);
		contentPane.add(label);
		
		
		
		String sql= "SELECT * from produit" ;
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
		
		
		
			
			
		
	}
}
