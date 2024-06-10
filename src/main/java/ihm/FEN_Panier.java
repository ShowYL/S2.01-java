package ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class FEN_Panier {

	private JFrame frame;
	private JTable Tableau_Panier;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
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
		this.initialize();
	}

	public JFrame getFrame() {
		return this.frame;
	}

	public JTable getTableau() {
		return this.Tableau_Panier;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		int hauteur = (int) (screenSize.height * 0.7); // 70% de la hauteur de l'écran
		int largueur = (int) (screenSize.width * 0.7); // 70% de la largueur de l'écran
		this.frame = new JFrame();
		this.frame.setBounds(100, 100, 450, 300);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.getContentPane().setLayout(new BoxLayout(this.frame.getContentPane(), BoxLayout.Y_AXIS));
		this.frame.setSize(largueur, hauteur);
		this.frame.setLocationRelativeTo(null);

		JPanel Entete = new JPanel();
		Entete.setBackground(Constantes.NOIR);
		this.frame.getContentPane().add(Entete);
		Entete.setLayout(new BorderLayout(0, 0));

		JPanel titreEtImage = new JPanel();
		titreEtImage.setBackground(Constantes.NOIR);
		Entete.add(titreEtImage, BorderLayout.CENTER);

		JLabel ImagePanier = new JLabel("");
		ImageIcon icon = new ImageIcon("src\\main\\resources\\images\\icons\\Panier.png");
		Image img = icon.getImage();
		Image resizedImage = img.getScaledInstance(largueur / 32, hauteur / 20, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(resizedImage);
		ImagePanier.setIcon(icon);
		titreEtImage.add(ImagePanier);

		JLabel TitrePanier = new JLabel("Votre Panier");
		TitrePanier.setForeground(Constantes.BLANC);
		TitrePanier.setFont(new Font("Alef", Font.PLAIN, 22));
		titreEtImage.add(TitrePanier);

		JPanel panel_BntCalcul = new JPanel();
		panel_BntCalcul.setBackground(Constantes.NOIR);
		Entete.add(panel_BntCalcul, BorderLayout.EAST);
		JLabel PrixSousTot = new JLabel("");
		JLabel prixExpedition = new JLabel("");
		JLabel prixTotal = new JLabel("");
		JComboBox<ImageIcon> comboBoxTranporteur = new JComboBox<ImageIcon>();
		JButton Bnt_rec_panier = new JButton("Recalculer mon panier");
		Bnt_rec_panier.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				float prixsousTotal = 0.0F;
				float prixTotalCalcul = 0.0F;
				for (int i = 0; i < FEN_Panier.this.Tableau_Panier.getRowCount(); i++) {
					prixsousTotal +=  Float.parseFloat(FEN_Panier.this.Tableau_Panier.getValueAt(i, 4).toString());
				}
				String result = new DecimalFormat("#.00").format(prixsousTotal);
				PrixSousTot.setText(result + "€");
				calculerExpedition(comboBoxTranporteur, prixsousTotal  , prixExpedition);
				prixTotalCalcul = prixsousTotal + Float.parseFloat(prixExpedition.getText());
				String result2 = new DecimalFormat("#.00").format(prixTotalCalcul);
				prixExpedition.setText(prixExpedition.getText() + "€");
				prixTotal.setText(result2 + "€");
			}
		});
		Bnt_rec_panier.setHorizontalTextPosition(SwingConstants.CENTER);
		Bnt_rec_panier.setFont(new Font("Alef", Font.PLAIN, 10));
		Bnt_rec_panier.setBackground(Constantes.JAUNE);
		Bnt_rec_panier.setAlignmentY(0.0f);
		panel_BntCalcul.add(Bnt_rec_panier);

		this.Tableau_Panier = new JTable();
		this.Tableau_Panier.setFont(new Font("Alef", Font.PLAIN, 10));
		this.Tableau_Panier = new JTable();
		this.Tableau_Panier.setFont(new Font("Alef", Font.PLAIN, 10));
		DefaultTableModel model = (DefaultTableModel) this.Tableau_Panier.getModel();
		model.setColumnIdentifiers(new String[] { "Image", "Produit", "Prix", "Quantit\u00E9", "Total" });
		this.Tableau_Panier.getColumnModel().getColumn(0).setResizable(false);
		this.Tableau_Panier.getColumnModel().getColumn(1).setResizable(false);
		this.Tableau_Panier.getColumnModel().getColumn(2).setResizable(false);
		this.Tableau_Panier.getColumnModel().getColumn(3).setResizable(false);
		this.Tableau_Panier.getColumnModel().getColumn(4).setResizable(false);
		this.frame.getContentPane().add(new JScrollPane(this.Tableau_Panier));
		for (int i = 0; i < 20; i++) {
			this.ajouterLigne(icon, "Fromage", 1.2F, 2);
		}
		JPanel TrasporteurEtTotal = new JPanel();
		TrasporteurEtTotal.setBackground(Constantes.GRIS_CLAIR);
		this.frame.getContentPane().add(TrasporteurEtTotal);
		TrasporteurEtTotal.setLayout(new BorderLayout(0, 0));

		JPanel Transporteurs = new JPanel();
		Transporteurs.setBackground(Constantes.BLANC);
		Transporteurs.setBorder(new LineBorder(Constantes.JAUNE, 2));
		TrasporteurEtTotal.add(Transporteurs, BorderLayout.WEST);
		Transporteurs.setLayout(new GridLayout(3, 1, 0, 0));

		JLabel TitreTransporteur = new JLabel("Transporteur");
		TitreTransporteur.setBackground(Constantes.BLANC);
		TitreTransporteur.setAlignmentY(0.0f);
		TitreTransporteur.setFont(new Font("Alef", Font.PLAIN, 16));
		Transporteurs.add(TitreTransporteur);

		JLabel TextFraiddePorts = new JLabel("Frais de port offert à partir de 120€");
		TextFraiddePorts.setAlignmentY(0.0f);
		TextFraiddePorts.setFont(new Font("Alef", Font.PLAIN, 10));
		Transporteurs.add(TextFraiddePorts);

		JPanel ImageetChoix = new JPanel();
		ImageetChoix.setBackground(Constantes.BLANC);
		Transporteurs.add(ImageetChoix);

		JLabel ImageCamion = new JLabel("");
		;
		ImageIcon icon2 = new ImageIcon("src\\main\\resources\\images\\icons\\Camion.png");
		Image img2 = icon2.getImage();
		Image resizedImage2 = img2.getScaledInstance(largueur / 32, hauteur / 20, java.awt.Image.SCALE_SMOOTH);
		icon2 = new ImageIcon(resizedImage2);
		ImageCamion.setIcon(icon2);
		ImageetChoix.add(ImageCamion);

		JPanel TotalPanier = new JPanel();

		float prix_Panier = 0.0F;
		

		JLabel lblExpedition = new JLabel("Expédition :");
		
		ImageIcon colissimo = new ImageIcon("src\\main\\resources\\images\\icons\\Colissimo.png");
		ImageIcon chronofresh = new ImageIcon("src\\main\\resources\\images\\icons\\Chronofresh.png");
		ImageIcon chronorelais = new ImageIcon("src\\main\\resources\\images\\icons\\Chronorelais.png");
		Image imgcol = colissimo.getImage();
		Image imgchr = chronorelais.getImage();
		Image imgchf = chronofresh.getImage();
		Image resizedImagecol = imgcol.getScaledInstance(largueur / 15, hauteur / 25, java.awt.Image.SCALE_SMOOTH);
		Image resizedImagechr = imgchr.getScaledInstance(largueur / 15, hauteur / 25, java.awt.Image.SCALE_SMOOTH);
		Image resizedImagechf = imgchf.getScaledInstance(largueur / 15, hauteur / 25, java.awt.Image.SCALE_SMOOTH);
		colissimo = new ImageIcon(resizedImagecol);
		chronofresh = new ImageIcon(resizedImagechf);
		chronorelais = new ImageIcon(resizedImagechr);
		comboBoxTranporteur.setModel(
				new DefaultComboBoxModel<ImageIcon>(new ImageIcon[] { colissimo, chronofresh, chronorelais }));
		ImageetChoix.add(comboBoxTranporteur);

		JLabel lblSousTot = new JLabel("Sous-total :");
		lblSousTot.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSousTot.setFont(new Font("Alef", Font.PLAIN, 10));
		TotalPanier.add(lblSousTot);

		PrixSousTot.setHorizontalAlignment(SwingConstants.RIGHT);
		PrixSousTot.setOpaque(true);
		PrixSousTot.setBackground(Constantes.VERT_CLAIR);
		TotalPanier.add(PrixSousTot);

		lblExpedition.setHorizontalAlignment(SwingConstants.RIGHT);
		lblExpedition.setFont(new Font("Alef", Font.PLAIN, 10));
		TotalPanier.add(lblExpedition);

		prixExpedition.setOpaque(true);
		prixExpedition.setHorizontalAlignment(SwingConstants.RIGHT);
		prixExpedition.setBackground(Constantes.VERT_CLAIR);
		TotalPanier.add(prixExpedition);

		JLabel lblTotal = new JLabel("TOTAL :");
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblTotal.setFont(new Font("Alef", Font.PLAIN, 10));
		TotalPanier.add(lblTotal);

	
		prixTotal.setOpaque(true);
		prixTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		prixTotal.setBackground(Constantes.ORANGE);
		TotalPanier.add(prixTotal);

		TotalPanier.setBorder(new LineBorder(Constantes.JAUNE, 2));
		TrasporteurEtTotal.add(TotalPanier, BorderLayout.EAST);
		TotalPanier.setLayout(new GridLayout(3, 2, 0, 0));

		JPanel PiedDePage = new JPanel();
		PiedDePage.setBackground(Constantes.NOIR);
		this.frame.getContentPane().add(PiedDePage);
		PiedDePage.setLayout(new BorderLayout(0, 0));

		JPanel panel_BntVA = new JPanel();
		panel_BntVA.setBackground(Constantes.NOIR);
		PiedDePage.add(panel_BntVA, BorderLayout.EAST);
		panel_BntVA.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton Button_ValiderPanier = new JButton("Valider mon panier");
		Button_ValiderPanier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FEN_Coordonnee window = new FEN_Coordonnee();
				FEN_Panier.this.frame.setVisible(false);
				window.getFrame().setVisible(true);
			}
		});
		Button_ValiderPanier.setBackground(Constantes.VERT);
		panel_BntVA.add(Button_ValiderPanier);

		JButton Button_AnullerPanier = new JButton("Annuler");
		Button_AnullerPanier.setBackground(Constantes.ROUGE);
		panel_BntVA.add(Button_AnullerPanier);

		JPanel panel_BntCont = new JPanel();
		panel_BntCont.setBackground(Constantes.NOIR);
		PiedDePage.add(panel_BntCont, BorderLayout.WEST);

		JButton btnContinuerLesAchats = new JButton("Continuer les achats");
		btnContinuerLesAchats.setBackground(Constantes.JAUNE);
		panel_BntCont.add(btnContinuerLesAchats);

		JButton btnViderPanier = new JButton("Vider le panier");
		btnViderPanier.setBackground(Constantes.ORANGE);
		btnViderPanier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				FEN_pop_up_supprimer window = new FEN_pop_up_supprimer(Tableau_Panier);
				window.getFrame().setVisible(true);
			}
		});
		panel_BntCont.add(btnViderPanier);

		FEN_Panier.this.calculerExpedition(comboBoxTranporteur, prix_Panier, prixExpedition);

	}

	public void calculerExpedition(JComboBox<ImageIcon> comboBoxTranporteur, float prix_Panier, JLabel prixExpedition) {
		float prix_expedition = 0.0F;
		if (comboBoxTranporteur.getSelectedIndex() == 0 || comboBoxTranporteur.getSelectedIndex() == 1) {
			if (prix_Panier < 60.0F) {
				prix_expedition = 14.90F;
			} else if (prix_Panier < 90.0F) {
				prix_expedition = 9.90F;
			} else if (prix_Panier < 120.0F) {
				prix_expedition = 4.90F;
			} else {
				prix_expedition = 0.0F;
			}
		}
		if (comboBoxTranporteur.getSelectedIndex() == 2) {
			if (prix_Panier < 60.0F) {
				prix_expedition = 23.90F;
			} else if (prix_Panier < 90.0F) {
				prix_expedition = 17.90F;
			} else if (prix_Panier < 120.0F) {
				prix_expedition = 9.90F;
			} else {
				prix_expedition = 0.0F;
			}
		}

		prixExpedition.setText(String.valueOf(prix_expedition));
	}

	public void ajouterLigne(ImageIcon image, String produit, float prix, int quantité) {
		DefaultTableModel model = (DefaultTableModel) this.Tableau_Panier.getModel();
		model.addRow(new Object[] { image, produit, prix, quantité, prix * quantité });
	}
}