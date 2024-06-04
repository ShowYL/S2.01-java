package ihm;
import modele.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class FEN_Panier{

	private JFrame frame;
	private JTable Tableau_Panier;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FEN_Panier window = new FEN_Panier();
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
	public FEN_Panier() {
		initialize();
	}
	
	public JFrame getFrame() {
		return this.frame;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		int hauteur = (int) (screenSize.height * 0.7);  // 70% de la hauteur de l'écran	    
		int largueur = (int) (screenSize.width * 0.7);  // 70% de la largueur de l'écran
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.setSize(largueur,hauteur);
        frame.setLocationRelativeTo(null);
		
		JPanel Entete = new JPanel();
		Entete.setBackground(new Color(0, 0, 0));
		frame.getContentPane().add(Entete);
		Entete.setLayout(new BorderLayout(0, 0));
		
		JPanel titreEtImage = new JPanel();
		titreEtImage.setBackground(new Color(0, 0, 0));
		Entete.add(titreEtImage, BorderLayout.CENTER);
		
		JLabel ImagePanier = new JLabel("");
		ImageIcon icon = new ImageIcon("src\\main\\resources\\images\\icons\\Panier.png");
		Image img = icon.getImage();
		Image resizedImage = img.getScaledInstance(largueur/32, hauteur/20,  java.awt.Image.SCALE_SMOOTH);  
		icon = new ImageIcon(resizedImage);
		ImagePanier.setIcon(icon);
		titreEtImage.add(ImagePanier);
		
		JLabel TitrePanier = new JLabel("Votre Panier");
		TitrePanier.setForeground(new Color(255, 255, 255));
		TitrePanier.setFont(new Font("Alef", Font.PLAIN, 22));
		titreEtImage.add(TitrePanier);
		
		JPanel panel_BntCalcul = new JPanel();
		panel_BntCalcul.setBackground(new Color(0, 0, 0));
		Entete.add(panel_BntCalcul, BorderLayout.EAST);
		
		JButton Bnt_rec_panier = new JButton("Recalculer mon panier");
		Bnt_rec_panier.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				float prixTotal = 0.0F;
				for (int i = 0 ; i < Tableau_Panier.getRowCount();i++) {
					prixTotal += (float) Tableau_Panier.getValueAt(i, 3) * (float) Tableau_Panier.getValueAt(i, 4);
				}
				
			}
		});
		Bnt_rec_panier.setHorizontalTextPosition(SwingConstants.CENTER);
		Bnt_rec_panier.setFont(new Font("Alef", Font.PLAIN, 10));
		Bnt_rec_panier.setBackground(new Color(254, 246, 127));
		Bnt_rec_panier.setAlignmentY(0.0f);
		panel_BntCalcul.add(Bnt_rec_panier);
		
		Tableau_Panier = new JTable();
		Tableau_Panier.setFont(new Font("Alef", Font.PLAIN, 10));
		Tableau_Panier.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Image", "Produit", "Prix", "Quantit\u00E9", "Total"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		Tableau_Panier.getColumnModel().getColumn(0).setResizable(false);
		Tableau_Panier.getColumnModel().getColumn(1).setResizable(false);
		Tableau_Panier.getColumnModel().getColumn(2).setResizable(false);
		Tableau_Panier.getColumnModel().getColumn(3).setResizable(false);
		Tableau_Panier.getColumnModel().getColumn(4).setResizable(false);
		frame.getContentPane().add(new JScrollPane(Tableau_Panier));
		
		JPanel TrasporteurEtTotal = new JPanel();
		TrasporteurEtTotal.setBackground(Constantes.GRIS_CLAIR);
		frame.getContentPane().add(TrasporteurEtTotal);
		TrasporteurEtTotal.setLayout(new BorderLayout(0, 0));
		
		JPanel Transporteurs = new JPanel();
		Transporteurs.setBackground(new Color(225, 225, 225));
		Transporteurs.setBorder(new LineBorder(new Color(255, 255, 128), 2));
		TrasporteurEtTotal.add(Transporteurs, BorderLayout.WEST);
		Transporteurs.setLayout(new GridLayout(3, 1, 0, 0));
		
		JLabel TitreTransporteur = new JLabel("Transporteur");
		TitreTransporteur.setBackground(new Color(223, 223, 223));
		TitreTransporteur.setAlignmentY(0.0f);
		TitreTransporteur.setFont(new Font("Alef", Font.PLAIN, 16));
		Transporteurs.add(TitreTransporteur);
		
		JLabel TextFraiddePorts = new JLabel("Frais de port offert à partir de 120€");
		TextFraiddePorts.setAlignmentY(0.0f);
		TextFraiddePorts.setFont(new Font("Alef", Font.PLAIN, 10));
		Transporteurs.add(TextFraiddePorts);
		
		JPanel ImageetChoix = new JPanel();
		ImageetChoix.setBackground(new Color(240, 240, 240));
		Transporteurs.add(ImageetChoix);
		
		JLabel ImageCamion = new JLabel("");;
		ImageIcon icon2 = new ImageIcon("src\\main\\resources\\images\\icons\\Camion.png");
		Image img2 = icon2.getImage();
		Image resizedImage2 = img2.getScaledInstance(largueur/32, hauteur/20,  java.awt.Image.SCALE_SMOOTH);  
		icon2 = new ImageIcon(resizedImage2);
		ImageCamion.setIcon(icon2);
		ImageetChoix.add(ImageCamion);
		
		JComboBox<ImageIcon> comboBoxTranporteur = new JComboBox<ImageIcon>();
		ImageIcon colissimo = new ImageIcon("src\\main\\resources\\images\\icons\\Colissimo.png");
		ImageIcon chronofresh = new ImageIcon("src\\main\\resources\\images\\icons\\Chronofresh.png");
		ImageIcon chronorelais = new ImageIcon("src\\main\\resources\\images\\icons\\Chronorelais.png");
		Image imgcol = colissimo.getImage();
		Image imgchr = chronorelais.getImage();
		Image imgchf = chronofresh.getImage();
		Image resizedImagecol = imgcol.getScaledInstance(largueur/15, hauteur/25,  java.awt.Image.SCALE_SMOOTH);
		Image resizedImagechr = imgchr.getScaledInstance(largueur/15, hauteur/25,  java.awt.Image.SCALE_SMOOTH);
		Image resizedImagechf = imgchf.getScaledInstance(largueur/15, hauteur/25,  java.awt.Image.SCALE_SMOOTH);
		colissimo = new ImageIcon(resizedImagecol);
		chronofresh = new ImageIcon(resizedImagechf);
		chronorelais = new ImageIcon(resizedImagechr);
		comboBoxTranporteur.setModel(new DefaultComboBoxModel<ImageIcon>(new ImageIcon[] {colissimo, chronofresh, chronorelais}));
		ImageetChoix.add(comboBoxTranporteur);
		
		JPanel TotalPanier = new JPanel();
		TotalPanier.setBorder(new LineBorder(new Color(255, 255, 128), 2));
		TrasporteurEtTotal.add(TotalPanier, BorderLayout.EAST);
		TotalPanier.setLayout(new GridLayout(3, 2, 0, 0));
		
		JLabel lblSousTot = new JLabel("Sous-total :");
		lblSousTot.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSousTot.setFont(new Font("Alef", Font.PLAIN, 10));
		TotalPanier.add(lblSousTot);
		
		JLabel PrixSousTot = new JLabel("");
		PrixSousTot.setHorizontalAlignment(SwingConstants.RIGHT);
		PrixSousTot.setOpaque(true);
		PrixSousTot.setBackground(new Color(204, 228, 152));
		TotalPanier.add(PrixSousTot);
		
		JLabel lblExpedition = new JLabel("Expédition :");
		lblExpedition.setHorizontalAlignment(SwingConstants.RIGHT);
		lblExpedition.setFont(new Font("Alef", Font.PLAIN, 10));
		TotalPanier.add(lblExpedition);
		
		JLabel PrixSousTot_1 = new JLabel("50,2€");
		PrixSousTot_1.setOpaque(true);
		PrixSousTot_1.setHorizontalAlignment(SwingConstants.RIGHT);
		PrixSousTot_1.setBackground(new Color(204, 228, 152));
		TotalPanier.add(PrixSousTot_1);
		
		JLabel lblTotal = new JLabel("TOTAL :");
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblTotal.setFont(new Font("Alef", Font.PLAIN, 10));
		TotalPanier.add(lblTotal);
		
		JLabel PrixSousTot_2 = new JLabel("50,2€");
		PrixSousTot_2.setOpaque(true);
		PrixSousTot_2.setHorizontalAlignment(SwingConstants.RIGHT);
		PrixSousTot_2.setBackground(new Color(204, 228, 152));
		TotalPanier.add(PrixSousTot_2);
		
		JPanel PiedDePage = new JPanel();
		PiedDePage.setBackground(new Color(0, 0, 0));
		frame.getContentPane().add(PiedDePage);
		PiedDePage.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_BntVA = new JPanel();
		panel_BntVA.setBackground(new Color(0, 0, 0));
		PiedDePage.add(panel_BntVA, BorderLayout.EAST);
		panel_BntVA.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton Button_ValiderPanier = new JButton("Valider mon panier");
		Button_ValiderPanier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FEN_Coordonnee window = new FEN_Coordonnee();
				frame.setVisible(false);
				window.getFrame().setVisible(true);
			}
		});
		Button_ValiderPanier.setBackground(Constantes.VERT);
		panel_BntVA.add(Button_ValiderPanier);
		
		JButton Button_AnullerPanier = new JButton("Annuler");
		Button_AnullerPanier.setBackground(Constantes.ROUGE);
		panel_BntVA.add(Button_AnullerPanier);
		
		JPanel panel_BntCont = new JPanel();
		panel_BntCont.setBackground(new Color(0, 0, 0));
		PiedDePage.add(panel_BntCont, BorderLayout.WEST);
		
		JButton btnContinuerLesAchats = new JButton("Continuer les achats");
		btnContinuerLesAchats.setBackground(new Color(254, 246, 126));
		panel_BntCont.add(btnContinuerLesAchats);
	}

}
