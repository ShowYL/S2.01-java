package ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import modele.Coordonnee;
import modele.Panier;

public class FEN_Facture {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Panier panier = new Panier();
					float calculPrixTotal = 0.0F;
					int expediteur = 0;
					Coordonnee coordonnee = new Coordonnee(null, null, null, null, null, null, null, null, null);
					FEN_Facture window = new FEN_Facture(panier, coordonnee, calculPrixTotal, expediteur);
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
	public FEN_Facture(Panier panier, Coordonnee coordonnee, float calculPrixTotal, int expediteur) {
		this.initialize(panier, coordonnee, calculPrixTotal, expediteur);
	}

	public JFrame getFrame() {
		return this.frame;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Panier panier, Coordonnee coordonnee, float calculPrixTotal, int expediteur) {
		this.frame = new JFrame();
		this.frame.setBounds(100, 100, 450, 300);
		this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panelNord = new JPanel();
		panelNord.setBackground(Constantes.NOIR);
		this.frame.getContentPane().add(panelNord, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Facture");

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		int hauteur = (int) (screenSize.height * 0.7); // 70% de la hauteur de l'écran
		int largueur = (int) (screenSize.width * 0.7); // 70% de la largueur de l'écran
		this.frame.setSize((int) (largueur / 0.7 * 0.5), hauteur);
		this.frame.setLocationRelativeTo(null);

		ImageIcon icon = new ImageIcon("src\\main\\resources\\images\\icons\\Facture.png");
		Image img = icon.getImage();
		Image resizedImage = img.getScaledInstance(largueur / 10, hauteur / 10, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(resizedImage);
		lblNewLabel.setIcon(icon);
		lblNewLabel.setForeground(Constantes.BLANC);
		panelNord.add(lblNewLabel);

		JPanel panelSud = new JPanel();
		panelSud.setBackground(Constantes.NOIR);
		this.frame.getContentPane().add(panelSud, BorderLayout.SOUTH);
		panelSud.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(Constantes.NOIR);
		panelSud.add(panel, BorderLayout.EAST);

		JButton btn_print = new JButton("Imprimer");
		btn_print.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FEN_Imprimer window = new FEN_Imprimer();
				window.getFrame().setVisible(true);
			}
		});
		btn_print.setBackground(Constantes.JAUNE);
		btn_print.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel.add(btn_print);

		JButton btn_quit = new JButton("Quitter");
		btn_quit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FEN_Facture.this.frame.dispose();
			}
		});
		btn_quit.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn_quit.setBackground(Constantes.ROUGE);
		panel.add(btn_quit);

		JPanel panelCentre = new JPanel();
		panelCentre.setLayout(new BorderLayout(0, 0));

		// Create a panel to hold all the components of the invoice
		JPanel invoicePanel = new JPanel();
		invoicePanel.setLayout(new BorderLayout(0, 0));

		// JTextArea for coordinates and payment details at the top
		JTextArea textArea1 = new JTextArea();
		textArea1.setEditable(false);
		textArea1.append(coordonnee.getPrenom() + " " + coordonnee.getNom().toUpperCase() + "\n");
		textArea1.append("Adresse 1 : " + coordonnee.getadresse1() + " " + coordonnee.getCodePostal() + " "
				+ coordonnee.getVille() + "\n");
		textArea1.append("Téléphone : " + coordonnee.getTelephone() + "\n");
		textArea1.append("Mail : " + coordonnee.getEmail() + "\n\n");
		textArea1.append("Produits :\n");

		invoicePanel.add(textArea1, BorderLayout.NORTH);

		// JTable for panier items in the center
		JTable panierJTable = new JTable();
		panierJTable.setFont(new Font("Alef", Font.PLAIN, 10));
		panierJTable.setModel(new DefaultTableModel(new Object[][] {}, new String[] {}));

		DefaultTableModel model = (DefaultTableModel) panierJTable.getModel();
		model.setColumnIdentifiers(new String[] { "Image", "Produit", "Prix", "Quantit\u00E9", "Total" });
		for (int i = 0; i < panier.getSize(); i++) {
			model.addRow(new Object[] { panier.getPanier().get(i).getArticle().getFromage().getNomImage(),
					panier.getPanier().get(i).getArticle().getFromage().getDésignation(),
					panier.getPanier().get(i).getArticle().getPrixTTC() + "€", panier.getPanier().get(i).getQuantite(),
					new DecimalFormat("#.00").format(panier.getPanier().get(i).getArticle().getPrixTTC()
							* panier.getPanier().get(i).getQuantite()) + "€" });
		}

		invoicePanel.add(panierJTable, BorderLayout.CENTER);

		JTextArea textArea2 = new JTextArea();
		textArea2.setEditable(false);
		String expediteurString;
		System.out.println(expediteur);
		switch (expediteur) {
		case 0:
			expediteurString = "Colissimo";
			break;
		case 1:
			expediteurString = "Chronofresh";
			break;
		case 2:
			expediteurString = "Chronorelais";
			break;
		default:
			expediteurString = "Pere Noel";
			break;
		}
		textArea2.append("\n\nTOTAL TTC Commande : " + new DecimalFormat("#.00").format(panier.prixPanier()) + "€ \n");
		float fraisTransport = calculPrixTotal - panier.prixPanier();
		if (fraisTransport == 0.0F) {
			textArea2.append("FRAIS DE TRANSPORT : 00.00€ par" + expediteurString + "\n");
		} else {
			textArea2.append("FRAIS DE TRANSPORT : " + new DecimalFormat("#.00").format(fraisTransport) + "€ par "
					+ expediteurString + "\n");
		}
		textArea2.append("PRIX TOTAL TTC : " + new DecimalFormat("#.00").format(calculPrixTotal) + "€ par "
				+ coordonnee.getPayementMethode());

		invoicePanel.add(textArea2, BorderLayout.SOUTH);

		JScrollPane scrollPane = new JScrollPane(invoicePanel);
		panelCentre.add(scrollPane, BorderLayout.CENTER);

		this.frame.getContentPane().add(panelCentre, BorderLayout.CENTER);
	}
}
