package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import modele.Fromages;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import java.awt.Component;
import javax.swing.ImageIcon;

public class FEN_Accueil {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
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

	/**
	 * Create the application.
	 */
	public FEN_Accueil() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel Footer = new JPanel();
		Footer.setBackground(Color.BLACK);
		frame.getContentPane().add(Footer, BorderLayout.SOUTH);
		Footer.setLayout(new BorderLayout(0, 0));
		
		JPanel Boite_choix_lait = new JPanel();
		Boite_choix_lait.setBackground(Color.BLACK);
		Footer.add(Boite_choix_lait, BorderLayout.WEST);
		Boite_choix_lait.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel Logo_vache = new JLabel("");
		Boite_choix_lait.add(Logo_vache);
		
		JComboBox Choix_lait = new JComboBox();
		Choix_lait.setForeground(Color.WHITE);
		Choix_lait.setBackground(Color.BLACK);
		Choix_lait.setBorder(new LineBorder(new Color(239, 224, 46)));
		Choix_lait.setModel(new DefaultComboBoxModel(new String[] {"Tous les laits", "Lait de vache", "Lait de chèvre", "Lait de brebis"}));
		Boite_choix_lait.add(Choix_lait);
		
		JButton Est_Button = new JButton("Quitter");
		Est_Button.setBackground(new Color(255, 128, 128));
		Footer.add(Est_Button, BorderLayout.EAST);
		
		JList Centre_liste = new JList();
		Centre_liste.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(Centre_liste, BorderLayout.CENTER);
		
		JPanel Header = new JPanel();
		Header.setBackground(Color.BLACK);
		frame.getContentPane().add(Header, BorderLayout.NORTH);
		Header.setLayout(new BorderLayout(0, 0));
		
		JPanel Titre_page = new JPanel();
		Titre_page.setBackground(new Color(0, 0, 0));
		Header.add(Titre_page, BorderLayout.WEST);
		
		JLabel Logo_fromage = new JLabel("");
		Logo_fromage.setIcon(new ImageIcon("src\\main\\resources\\images\\icons\\Cheese.png"));
		Titre_page.add(Logo_fromage);
		
		JLabel Titre = new JLabel("Nos fromages");
		Titre.setOpaque(true);
		Titre.setHorizontalAlignment(SwingConstants.CENTER);
		Titre.setForeground(Color.WHITE);
		Titre.setFont(new Font("Alef", Font.PLAIN, 25));
		Titre.setBackground(Color.BLACK);
		Titre_page.add(Titre);
		
		JPanel Bouton_panier = new JPanel();
		Bouton_panier.setBackground(new Color(0, 0, 0));
		Header.add(Bouton_panier, BorderLayout.EAST);
		
		JButton Panier = new JButton("XX,XX€");
		Panier.setHorizontalTextPosition(SwingConstants.RIGHT);
		Panier.setHorizontalAlignment(SwingConstants.RIGHT);
		Panier.setBackground(new Color(239, 224, 46));
		Panier.setAlignmentX(1.0f);
		Bouton_panier.add(Panier);
	}

}
