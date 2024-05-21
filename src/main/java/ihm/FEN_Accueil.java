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
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

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
		
		JPanel Sud_Border = new JPanel();
		Sud_Border.setBackground(Color.BLACK);
		frame.getContentPane().add(Sud_Border, BorderLayout.SOUTH);
		Sud_Border.setLayout(new BorderLayout(0, 0));
		
		JPanel Ouest_Flow = new JPanel();
		Ouest_Flow.setBackground(Color.BLACK);
		Sud_Border.add(Ouest_Flow, BorderLayout.WEST);
		
		JLabel Logo_vache = new JLabel("");
		Ouest_Flow.add(Logo_vache);
		
		JComboBox Choix_lait = new JComboBox();
		Choix_lait.setModel(new DefaultComboBoxModel(new String[] {"Tous les laits", "Lait de vache", "Lait de chèvre", "Lait de brebis"}));
		Ouest_Flow.add(Choix_lait);
		
		JButton Est_Button = new JButton("Quitter");
		Est_Button.setBackground(new Color(255, 128, 128));
		Sud_Border.add(Est_Button, BorderLayout.EAST);
		
		JList Centre_liste = new JList();
		Centre_liste.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(Centre_liste, BorderLayout.CENTER);
		
		JPanel Nord_Flow = new JPanel();
		Nord_Flow.setBackground(Color.BLACK);
		frame.getContentPane().add(Nord_Flow, BorderLayout.NORTH);
		Nord_Flow.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel Logo_fromage = new JLabel("");
		Nord_Flow.add(Logo_fromage);
		
		JLabel Titre = new JLabel("Nos fromages");
		Titre.setOpaque(true);
		Titre.setHorizontalAlignment(SwingConstants.CENTER);
		Titre.setForeground(Color.WHITE);
		Titre.setFont(new Font("Alef", Font.PLAIN, 25));
		Titre.setBackground(Color.BLACK);
		Nord_Flow.add(Titre);
	}

}
