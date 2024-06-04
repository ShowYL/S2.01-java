package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;
import javax.swing.BoxLayout;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import modele.*;

public class FEN_Description {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FEN_Description window = new FEN_Description(new Fromage("test"));
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
	public FEN_Description(Fromage fromage) {
		initialize(fromage);
	}
	
	public JFrame getFrame() {
		return this.frame;
	}
	
	private void initialize(Fromage fromage) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int hauteur = (int) (screenSize.height * 0.7);  // 70% de la hauteur de l'écran	    
		int largueur = (int) (screenSize.width * 0.7);  // 70% de la largueur de l'écran
		
		frame = new JFrame();
		frame.setBounds(100, 100, 685, 407);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setSize(663,397);
        frame.setLocationRelativeTo(null);
        frame.setBackground(new Color(0, 0, 0));
        frame.getContentPane().setLayout(new BorderLayout(0, 0));
        
        JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setForeground(new Color(0, 0, 0));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel frommage_logo = new JLabel("");
		
		ImageIcon icon1 = new ImageIcon("src\\main\\resources\\images\\icons\\Cheese.png");
		Image img1 = icon1.getImage();
		Image resizedImage1 = img1.getScaledInstance(largueur/20, hauteur/10,  java.awt.Image.SCALE_SMOOTH);  
		icon1 = new ImageIcon(resizedImage1);
		
		frommage_logo.setIcon(icon1);
		panel.add(frommage_logo);
		
		JLabel titre = new JLabel(fromage.getDésignation());
		titre.setHorizontalAlignment(SwingConstants.CENTER);
		titre.setForeground(Color.WHITE);
		titre.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 36));
		titre.setBorder(new EmptyBorder(11, 0, 15, 0));
		panel.add(titre);
		
		JPanel panel_fromage = new JPanel();
		panel_fromage.setBackground(new Color(192, 192, 192));
		frame.getContentPane().add(panel_fromage, BorderLayout.CENTER);
		panel_fromage.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel photo = new JLabel("");
		photo.setIcon(new ImageIcon("src\\main\\resources\\images\\fromages\\hauteur200\\"+ fromage.getNomImage() +".jpg"));
		photo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		photo.setHorizontalAlignment(SwingConstants.CENTER);
		panel_fromage.add(photo);
		
		JPanel panel_description = new JPanel();
		panel_description.setBackground(new Color(192, 192, 192));
		panel_fromage.add(panel_description);
		panel_description.setLayout(new BoxLayout(panel_description, BoxLayout.Y_AXIS));
		
		JTextArea description = new JTextArea();
		description.setSelectionColor(new Color(0, 0, 0));
		description.setText(fromage.getDescription());
		description.setLineWrap(true);
		description.setWrapStyleWord(true);
		description.setEditable(false);
		description.setBackground(Color.WHITE);
	    description.setForeground(Color.BLACK);
		
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
		panel_footer.setBackground(new Color(0, 0, 0));
		frame.getContentPane().add(panel_footer, BorderLayout.SOUTH);
		panel_footer.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panel_prix = new JPanel();
		panel_prix.setBackground(new Color(0, 0, 0));
		panel_footer.add(panel_prix);
		
		JLabel euro_logo_1 = new JLabel("");
		int h2 = (int) (screenSize.height * 0.2);  // 70% de la hauteur de l'écran
		int l2 = (int) (screenSize.width * 0.2);  // 70% de la largueur de l'écran
		
		ImageIcon icon2 = new ImageIcon("src\\main\\resources\\images\\icons\\Euro.png");
		Image img2 = icon2.getImage();
		Image resizedImage2 = img2.getScaledInstance(l2/8, h2/6,  java.awt.Image.SCALE_SMOOTH);  
		icon2 = new ImageIcon(resizedImage2);
		
		euro_logo_1.setIcon(icon2);
		euro_logo_1.setForeground(Color.WHITE);
		euro_logo_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		panel_prix.add(euro_logo_1);
		
		JComboBox prix = new JComboBox();
		prix.setBorder(new LineBorder(new Color(251, 220, 4), 3));
		prix.setFont(new Font("Tahoma", Font.PLAIN, 15));
		List<Article> articles = fromage.getArticles();
		prix.setModel(new DefaultComboBoxModel(new String[] {"Prix TTC : 3.99 €", "Prix HT : 1.99 €"}));
		panel_prix.add(prix);
		
		JComboBox quantite = new JComboBox();
		quantite.setBorder(new LineBorder(new Color(251, 220, 4), 3));
		quantite.setFont(new Font("Tahoma", Font.PLAIN, 15));
		quantite.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		panel_prix.add(quantite);
		
		JPanel panel_validation_annulation = new JPanel();
		panel_validation_annulation.setBackground(new Color(0, 0, 0));
		panel_footer.add(panel_validation_annulation);
		
		JButton btn_add = new JButton("Ajouter au panier");
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_add.setBackground(new Color(0, 128, 0));
		btn_add.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_validation_annulation.add(btn_add);
		
		JButton btn_cancel = new JButton("Annuler");
		btn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btn_cancel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_cancel.setBackground(new Color(255, 0, 0));
		panel_validation_annulation.add(btn_cancel);
		
	}
}
