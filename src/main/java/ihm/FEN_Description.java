package ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import modele.Article;
import modele.Fromage;
import modele.Panier;
import modele.ArticleEtQuantite;

public class FEN_Description {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					FEN_Description window = new FEN_Description(new Fromage("test"), new Panier(), new JButton());
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FEN_Description(Fromage fromage, Panier panier, JButton boutonPanier) {
		initialize(fromage, panier, boutonPanier);
	}

	public JFrame getFrame() {
		return this.frame;
	}

	private void initialize(Fromage fromage, Panier panier, JButton boutonPanier) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int hauteur = (int) (screenSize.height * 0.7); // 70% de la hauteur de l'écran
		int largueur = (int) (screenSize.width * 0.7); // 70% de la largueur de l'écran

		frame = new JFrame();
		frame.setBounds(100, 100, 685, 407);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setSize(815, 421);
		frame.setLocationRelativeTo(null);
		frame.setBackground(Constantes.NOIR);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(Constantes.NOIR);
		panel.setForeground(Constantes.NOIR);
		frame.getContentPane().add(panel, BorderLayout.NORTH);

		JLabel frommage_logo = new JLabel("");

		ImageIcon icon1 = new ImageIcon("src\\main\\resources\\images\\icons\\Cheese.png");
		Image img1 = icon1.getImage();
		Image resizedImage1 = img1.getScaledInstance(largueur / 20, hauteur / 10, java.awt.Image.SCALE_SMOOTH);
		icon1 = new ImageIcon(resizedImage1);

		frommage_logo.setIcon(icon1);
		panel.add(frommage_logo);

		JLabel titre = new JLabel(fromage.getDésignation());
		titre.setHorizontalAlignment(SwingConstants.CENTER);
		titre.setForeground(Constantes.BLANC);
		titre.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 36));
		titre.setBorder(new EmptyBorder(11, 0, 15, 0));
		panel.add(titre);

		JPanel panel_fromage = new JPanel();
		panel_fromage.setBackground(Constantes.GRIS_CLAIR);
		frame.getContentPane().add(panel_fromage, BorderLayout.CENTER);
		panel_fromage.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel photo = new JLabel("");
		photo.setIcon(
				new ImageIcon("src\\main\\resources\\images\\fromages\\hauteur200\\" + fromage.getNomImage() + ".jpg"));
		photo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		photo.setHorizontalAlignment(SwingConstants.CENTER);
		panel_fromage.add(photo);

		JPanel panel_description = new JPanel();
		panel_description.setBackground(Constantes.JAUNE);
		panel_fromage.add(panel_description);
		panel_description.setLayout(new BoxLayout(panel_description, BoxLayout.Y_AXIS));

		JTextArea description = new JTextArea();
		description.setSelectionColor(Constantes.NOIR);
		description.setText(fromage.getDescription());
		description.setLineWrap(true);
		description.setWrapStyleWord(true);
		description.setEditable(false);
		description.setBackground(Constantes.BLANC);
		description.setForeground(Constantes.NOIR);

		JScrollPane scrollPane = new JScrollPane(description);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension(200, 100));
		panel_description.add(scrollPane);

		JLabel titre_description = new JLabel("Description");
		scrollPane.setColumnHeaderView(titre_description);
		titre_description.setHorizontalAlignment(SwingConstants.CENTER);
		titre_description.setFont(new Font("Tahoma", Font.PLAIN, 25));

		JPanel panel_footer = new JPanel();
		panel_footer.setBackground(Constantes.NOIR);
		frame.getContentPane().add(panel_footer, BorderLayout.SOUTH);
		panel_footer.setLayout(new GridLayout(1, 2, 0, 0));

		JPanel panel_prix = new JPanel();
		panel_prix.setBackground(Constantes.NOIR);
		panel_footer.add(panel_prix);

		JLabel euro_logo_1 = new JLabel("");
		int h2 = (int) (screenSize.height * 0.2); // 70% de la hauteur de l'écran
		int l2 = (int) (screenSize.width * 0.2); // 70% de la largueur de l'écran

		ImageIcon icon2 = new ImageIcon("src\\main\\resources\\images\\icons\\Euro.png");
		Image img2 = icon2.getImage();
		Image resizedImage2 = img2.getScaledInstance(l2 / 8, h2 / 6, java.awt.Image.SCALE_SMOOTH);
		icon2 = new ImageIcon(resizedImage2);

		euro_logo_1.setIcon(icon2);
		euro_logo_1.setForeground(Constantes.BLANC);
		euro_logo_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		panel_prix.add(euro_logo_1);

		List<Article> articles = fromage.getArticles();
		ArrayList<String> listeaffichageprix = new ArrayList<>();
		for (Article article : articles) {
			listeaffichageprix.add(article.getClé() + " - Prix TTC : " + article.getPrixTTC() + " €");
		}

		JComboBox prix = new JComboBox();
		prix.setBorder(new LineBorder(Constantes.JAUNE, 3));
		prix.setFont(new Font("Tahoma", Font.PLAIN, 15));
		prix.setModel(new DefaultComboBoxModel(listeaffichageprix.toArray(new String[0])));
		panel_prix.add(prix);

		Integer[] listequantité = new Integer[listeaffichageprix.size()];
		int i = 0;
		for (Article article : articles) {
			listequantité[i] = article.getQuantitéEnStock();
			i++;
		}
		JSpinner quantite = new JSpinner();
		quantite.setModel(new SpinnerNumberModel(0, 0, (int) listequantité[prix.getSelectedIndex()], 1));
		panel_prix.add(quantite);

		JPanel panel_validation_annulation = new JPanel();
		panel_validation_annulation.setBackground(Constantes.NOIR);
		panel_footer.add(panel_validation_annulation);

		JButton btn_add = new JButton("Ajouter au panier");
		btn_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				articles.get(prix.getSelectedIndex()).retirerQuantité((int) quantite.getValue());
				boolean b = false;

				for (int i = 0; i < panier.getSize(); i++) {
					if (panier.getPanier().get(i).getArticle().getFromage().getDésignation() == articles
							.get(prix.getSelectedIndex()).getFromage().getDésignation()) {
						panier.getPanier().get(i)
								.changerQuantite(panier.getPanier().get(i).getQuantite() + (int) quantite.getValue());
						b = true;
					}
				}
				if (!b) {
					ArticleEtQuantite article = new ArticleEtQuantite(articles.get(prix.getSelectedIndex()),
							(int) quantite.getValue());
					panier.ajouterArticle(article);
				}
				boutonPanier.setText(panier.prixPanier() + " €");
				frame.dispose();
			}
		});
		btn_add.setBackground(Constantes.VERT);
		btn_add.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_validation_annulation.add(btn_add);

		JButton btn_cancel = new JButton("Annuler");
		btn_cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btn_cancel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn_cancel.setBackground(Constantes.ROUGE);
		panel_validation_annulation.add(btn_cancel);

	}
}