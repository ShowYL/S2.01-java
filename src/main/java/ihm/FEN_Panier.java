package ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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

import modele.Panier;

public class FEN_Panier {

	private JFrame frame;
	private JTable Tableau_Panier;
	private float calculPrixTotal;
	private int expediteur;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					FEN_Panier window = new FEN_Panier(new Panier(), new JButton());
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
	public FEN_Panier(Panier panier, JButton boutonPanier) {
		this.initialize(panier, boutonPanier);
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
	private void initialize(Panier panier, JButton boutonPanier) {

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		int hauteur = (int) (screenSize.height * 0.7); // 70% de la hauteur de l'écran
		int largueur = (int) (screenSize.width * 0.7); // 70% de la largueur de l'écran
		this.frame = new JFrame();
		this.frame.setBounds(100, 100, 450, 300);
		this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		comboBoxTranporteur.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				FEN_Panier.this.expediteur = comboBoxTranporteur.getSelectedIndex();
				float calculPrixSousTotal = panier.prixPanier();
				String paternPrixSousTotal = new DecimalFormat("#.00").format(calculPrixSousTotal);
				PrixSousTot.setText(paternPrixSousTotal + "€");
				if (calculPrixSousTotal == 0.0F) {
					PrixSousTot.setText("00,00€");
				}
				float calculPrixExpedition = panier.calculerExpedition(comboBoxTranporteur);
				String paternPrixExpedition = new DecimalFormat("#.00").format(calculPrixExpedition);
				prixExpedition.setText(paternPrixExpedition + "€");
				if (calculPrixExpedition == 0.0F) {
					prixExpedition.setText("00,00€");
				}
				FEN_Panier.this.calculPrixTotal = panier.recalculerPanier(comboBoxTranporteur);
				String paternPrixTotal = new DecimalFormat("#.00").format(FEN_Panier.this.calculPrixTotal);
				prixTotal.setText(paternPrixTotal + "€");
			}
		});
		JButton Bnt_rec_panier = new JButton("Recalculer mon panier");
		Bnt_rec_panier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				float calculPrixSousTotal = panier.prixPanier();
				String paternPrixSousTotal = new DecimalFormat("#.00").format(calculPrixSousTotal);
				PrixSousTot.setText(paternPrixSousTotal + "€");
				if (calculPrixSousTotal == 0.0F) {
					PrixSousTot.setText("00,00€");
				}
				float calculPrixExpedition = panier.calculerExpedition(comboBoxTranporteur);
				String paternPrixExpedition = new DecimalFormat("#.00").format(calculPrixExpedition);
				prixExpedition.setText(paternPrixExpedition + "€");
				if (calculPrixExpedition == 0.0F) {
					prixExpedition.setText("00,00€");
				}
				FEN_Panier.this.calculPrixTotal = panier.recalculerPanier(comboBoxTranporteur);
				String paternPrixTotal = new DecimalFormat("#.00").format(FEN_Panier.this.calculPrixTotal);
				prixTotal.setText(paternPrixTotal + "€");
			}
		});

		Bnt_rec_panier.setHorizontalTextPosition(SwingConstants.CENTER);
		Bnt_rec_panier.setFont(new Font("Alef", Font.PLAIN, 10));
		Bnt_rec_panier.setBackground(Constantes.JAUNE);
		Bnt_rec_panier.setAlignmentY(0.0f);
		panel_BntCalcul.add(Bnt_rec_panier);

		this.Tableau_Panier = new JTable();
		this.Tableau_Panier.setFont(new Font("Alef", Font.PLAIN, 50));
		this.Tableau_Panier = new JTable();
		this.Tableau_Panier.setModel(new DefaultTableModel(new Object[][] {}, new String[] {}));
		this.Tableau_Panier.setFont(new Font("Alef", Font.PLAIN, 10));
		DefaultTableModel model = (DefaultTableModel) this.Tableau_Panier.getModel();
		model.setColumnIdentifiers(new String[] { "Image", "Produit", "Prix", "Quantit\u00E9", "Total" });
		this.frame.getContentPane().add(new JScrollPane(this.Tableau_Panier));
		for (int i = 0; i < panier.getSize(); i++) {
			DefaultTableModel modele = (DefaultTableModel) this.Tableau_Panier.getModel();
			modele.addRow(new Object[] { panier.getPanier().get(i).getArticle().getFromage().getNomImage(),
					panier.getPanier().get(i).getArticle().getClé()
							+ "-" + panier.getPanier().get(i).getArticle().getFromage().getDésignation(),
					panier.getPanier().get(i).getArticle().getPrixTTC(), panier.getPanier().get(i).getQuantite(),
					new DecimalFormat("#.00").format(panier.getPanier().get(i).getArticle().getPrixTTC()
							* panier.getPanier().get(i).getQuantite()) });
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
				if (FEN_Panier.this.Tableau_Panier.getRowCount() > 0) {
					FEN_Coordonnee window = new FEN_Coordonnee(panier, FEN_Panier.this.calculPrixTotal,
							FEN_Panier.this.expediteur);
					window.getFrame().setVisible(true);
				} else {
					FEN_pop_up_panier_vide window = new FEN_pop_up_panier_vide();
					window.getFrame().setVisible(true);
				}
			}
		});
		Button_ValiderPanier.setBackground(Constantes.VERT);
		panel_BntVA.add(Button_ValiderPanier);

		JPanel panel_BntCont = new JPanel();
		panel_BntCont.setBackground(Constantes.NOIR);
		PiedDePage.add(panel_BntCont, BorderLayout.WEST);

		JButton btnContinuerLesAchats = new JButton("Continuer les achats");
		btnContinuerLesAchats.setBackground(Constantes.JAUNE);
		btnContinuerLesAchats.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FEN_Panier.this.frame.setVisible(false);
			}
		});
		panel_BntCont.add(btnContinuerLesAchats);

		JButton btnViderPanier = new JButton("Vider le panier");
		btnViderPanier.setBackground(Constantes.ORANGE);
		btnViderPanier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FEN_pop_up_supprimer window = new FEN_pop_up_supprimer(FEN_Panier.this.Tableau_Panier, panier,
						boutonPanier);
				window.getFrame().setVisible(true);
			}
		});
		panel_BntCont.add(btnViderPanier);

		float calculPrixSousTotal = panier.prixPanier();
		String paternPrixSousTotal = new DecimalFormat("#.00").format(calculPrixSousTotal);
		PrixSousTot.setText(paternPrixSousTotal + "€");
		if (calculPrixSousTotal == 0.0F) {
			PrixSousTot.setText("00,00€");
		}
		float calculPrixExpedition = panier.calculerExpedition(comboBoxTranporteur);
		String paternPrixExpedition = new DecimalFormat("#.00").format(calculPrixExpedition);
		prixExpedition.setText(paternPrixExpedition + "€");
		if (calculPrixExpedition == 0.0F) {
			prixExpedition.setText("00,00€");
		}
		this.calculPrixTotal = panier.recalculerPanier(comboBoxTranporteur);
		String paternPrixTotal = new DecimalFormat("#.00").format(this.calculPrixTotal);
		prixTotal.setText(paternPrixTotal + "€");
	}
}