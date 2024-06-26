package ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import modele.Fromage;
import modele.Fromages;
import modele.GenerationFromages;
import modele.Panier;
import modele.TypeLait;

public class FEN_Accueil {

	private JFrame frame;
	private Panier panier;
	private JButton boutonPanier;
	private ArrayList<String> listefromage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					FEN_Accueil window = new FEN_Accueil();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JFrame getFrame() {
		return this.frame;
	}

	/**
	 * Create the application.
	 */
	public FEN_Accueil() {
		this.listefromage = new ArrayList<>();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int hauteur = (int) (screenSize.height * 0.7); // 70% de la hauteur de l'écran
		int largueur = (int) (screenSize.width * 0.7); // 70% de la largueur de l'écran

		panier = new Panier();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setSize(largueur, hauteur);
		frame.setLocationRelativeTo(null);

		JPanel Footer = new JPanel();
		Footer.setBackground(Constantes.NOIR);
		frame.getContentPane().add(Footer, BorderLayout.SOUTH);
		Footer.setLayout(new BorderLayout(0, 0));

		JPanel Boite_choix_lait = new JPanel();
		Boite_choix_lait.setBackground(Constantes.NOIR);
		Footer.add(Boite_choix_lait, BorderLayout.CENTER);
		Boite_choix_lait.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel Logo_vache = new JLabel("");
		ImageIcon icon = new ImageIcon("src\\main\\resources\\images\\icons\\Tetedevache.png");
		Image img = icon.getImage();
		Image resizedImage = img.getScaledInstance(largueur / 30, hauteur / 15, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(resizedImage);
		Logo_vache.setIcon(icon);
		Boite_choix_lait.add(Logo_vache);

		JComboBox Choix_lait = new JComboBox();
		Choix_lait.setForeground(Constantes.BLANC);
		Choix_lait.setBackground(Constantes.NOIR);
		Choix_lait.setBorder(new LineBorder(Constantes.JAUNE));
		Choix_lait.setModel(new DefaultComboBoxModel(
				new String[] { "Tous les laits", "Lait de vache", "Lait de chèvre", "Lait de brebis" }));
		Boite_choix_lait.add(Choix_lait);

		JPanel Bouton_quitter_boite = new JPanel();
		Bouton_quitter_boite.setBackground(Constantes.NOIR);
		Footer.add(Bouton_quitter_boite, BorderLayout.EAST);

		JButton Quitter_Button = new JButton("Quitter");
		Quitter_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		Quitter_Button.setBackground(Constantes.ROUGE);
		Bouton_quitter_boite.add(Quitter_Button);

		GenerationFromages generation = new GenerationFromages();
		@SuppressWarnings("static-access")
		Fromages tousfromages = generation.générationBaseFromages();
		for (Fromage f : tousfromages.getFromages()) {
			this.listefromage.add(f.getDésignation());
		}

		JList Centre_liste = new JList(listefromage.toArray(new String[0]));
		Centre_liste.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int index = Centre_liste.locationToIndex(e.getPoint());
					String selectedItem = listefromage.get(index);
					FEN_Description fenDescription = new FEN_Description(tousfromages.getFromage(selectedItem), panier,
							boutonPanier);
					fenDescription.getFrame().setVisible(true);
				}
			}
		});
		Centre_liste.setBackground(Constantes.GRIS_CLAIR);
		frame.getContentPane().add(new JScrollPane(Centre_liste), BorderLayout.CENTER);
		JPanel Header = new JPanel();
		Header.setBackground(Constantes.NOIR);
		frame.getContentPane().add(Header, BorderLayout.NORTH);
		Header.setLayout(new BorderLayout(0, 0));

		JPanel Titre_page = new JPanel();
		Titre_page.setBackground(Constantes.NOIR);
		Header.add(Titre_page, BorderLayout.CENTER);

		JLabel Logo_fromage = new JLabel("");
		icon = new ImageIcon("src\\main\\resources\\images\\icons\\Cheese.png");
		img = icon.getImage();
		resizedImage = img.getScaledInstance(largueur / 20, hauteur / 10, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(resizedImage);
		Logo_fromage.setIcon(icon);
		Titre_page.add(Logo_fromage);

		JLabel Titre = new JLabel("Nos fromages");
		Titre.setOpaque(true);
		Titre.setHorizontalAlignment(SwingConstants.CENTER);
		Titre.setForeground(Constantes.BLANC);
		Titre.setFont(new Font("Alef", Font.PLAIN, 25));
		Titre.setBackground(Constantes.NOIR);
		Titre_page.add(Titre);

		JPanel Bouton_panier = new JPanel();
		Bouton_panier.setBackground(Constantes.NOIR);
		Header.add(Bouton_panier, BorderLayout.EAST);

		boutonPanier = new JButton("00,00 €");
		icon = new ImageIcon("src\\main\\resources\\images\\icons\\Caddie.png");
		img = icon.getImage();
		resizedImage = img.getScaledInstance(largueur / 30, hauteur / 15, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(resizedImage);
		boutonPanier.setIcon(icon);
		boutonPanier.setHorizontalAlignment(SwingConstants.RIGHT);
		boutonPanier.setBackground(Constantes.JAUNE);
		boutonPanier.setAlignmentX(1.0f);
		boutonPanier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FEN_Panier window = new FEN_Panier(panier, boutonPanier);
				if (panier.estVide()) {
					FEN_pop_up_panier_vide panierVide = new FEN_pop_up_panier_vide();
					panierVide.getFrame().setVisible(true);
				} else {
					window.getFrame().setVisible(true);
				}
			}
		});
		Bouton_panier.add(boutonPanier);

		Choix_lait.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				int i = Choix_lait.getSelectedIndex();
				GenerationFromages generation = new GenerationFromages();
				@SuppressWarnings("static-access")
				Fromages tousfromages = generation.générationBaseFromages();
				List<Fromage> listefromages = new LinkedList<Fromage>();
				switch (i) {
					case 0:
						listefromages = tousfromages.getFromages();
						break;
					case 1:
						listefromages = tousfromages.fromagesAuLaitDe(TypeLait.getTypeLait("Vache"));
						break;
					case 2:
						listefromages = tousfromages.fromagesAuLaitDe(TypeLait.getTypeLait("Chèvre"));
						break;
					case 3:
						listefromages = tousfromages.fromagesAuLaitDe(TypeLait.getTypeLait("Brebis"));
						break;
				}
				ArrayList<String> tabfromage = new ArrayList<>();
				for (Fromage f : listefromages) {
					tabfromage.add(f.getDésignation());
				}

				Centre_liste.setListData(tabfromage.toArray(new String[0]));
				listefromage = tabfromage;
			}
		});
	}

}