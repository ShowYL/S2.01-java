package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import javax.swing.border.CompoundBorder;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class FEN_Coordonnee {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FEN_Coordonnee window = new FEN_Coordonnee();
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
	public FEN_Coordonnee() {
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
	    
	    JPanel panelNord = new JPanel();
	    panelNord.setBackground(new Color(0, 0, 0));
	    frame.getContentPane().add(panelNord, BorderLayout.NORTH);
	    
	    JLabel lblNewLabel = new JLabel("Vos Coordonnées");


	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	    int hauteur = (int) (screenSize.height * 0.7);  // 70% de la hauteur de l'écran
	    int largueur = (int) (screenSize.width * 0.7);  // 70% de la largueur de l'écran
	    frame.setSize(largueur,hauteur);
        frame.setLocationRelativeTo(null);
	    
	    ImageIcon icon = new ImageIcon("src\\main\\resources\\images\\icons\\Coordonnee.png");
	    Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(largueur/8, hauteur/8,  java.awt.Image.SCALE_SMOOTH);  
        icon = new ImageIcon(resizedImage);
	    lblNewLabel.setIcon(icon);
	    lblNewLabel.setForeground(new Color(255, 255, 255));
	    panelNord.add(lblNewLabel);
	    
	    JPanel panelCentre = new JPanel();
	    frame.getContentPane().add(panelCentre, BorderLayout.CENTER);
	    panelCentre.setLayout(new BorderLayout(0, 0));
	    
	    JPanel panelCentreOuest = new JPanel(new GridLayout(8,2));
	    panelCentre.add(panelCentreOuest, BorderLayout.WEST);

	    String[] labels = {"Nom : ", "Prénom : ", "Adresse 1 : ", "Adresse 2 : ", "Code Postal : ", "Ville ; ", "Téléphone : ", "Mail : "};

	    for (int i = 0; i < 8; i++) {
	        JLabel label = new JLabel(labels[i]);
	        label.setHorizontalAlignment(JLabel.RIGHT);
	        JTextField textField = new JTextField();
	        textField.setPreferredSize(new Dimension(150,0));
	        panelCentreOuest.add(label);
	        panelCentreOuest.add(textField);
	    }

	    
	    JPanel panelCentreEst = new JPanel();
	    panelCentre.add(panelCentreEst, BorderLayout.EAST);
	    panelCentreEst.setLayout(new BorderLayout(0, 0));
	    
	    JPanel panelCentreEstNord = new JPanel();
	    panelCentreEst.add(panelCentreEstNord, BorderLayout.NORTH);
	    panelCentreEstNord.setBorder(BorderFactory.createLineBorder(Color.yellow, 5));
	    panelCentreEstNord.setLayout(new BorderLayout(0, 0));
	    
	    JLabel lblNewLabel_1 = new JLabel("Moyen de paiement");
	    panelCentreEstNord.add(lblNewLabel_1, BorderLayout.NORTH);
	    
	    JPanel panelCentreEstNordSud = new JPanel();
	    panelCentreEstNord.add(panelCentreEstNordSud, BorderLayout.SOUTH);
	    
	    
	    panelCentreEstNordSud.setLayout(new GridLayout(3,2));
	    JPanel panelCB = new JPanel();
	    ImageIcon icon2 = new ImageIcon("src\\main\\resources\\images\\icons\\CB.png");
	    Image img2 = icon2.getImage();
        Image resizedImage2 = img2.getScaledInstance(largueur/9, hauteur/9,  java.awt.Image.SCALE_SMOOTH);  
        icon2 = new ImageIcon(resizedImage2);
	    JRadioButton rdbtnNewRadioButton = new JRadioButton("Carte de crédit");
	    JLabel imageCB = new JLabel(icon2);
	    panelCB.add(rdbtnNewRadioButton);
	    panelCB.add(imageCB);
	    panelCentreEstNordSud.add(panelCB);
	    JPanel panelPaypal = new JPanel();
	    ImageIcon icon3 = new ImageIcon("src\\main\\resources\\images\\icons\\Paypal.png");
	    Image img3 = icon3.getImage();
        Image resizedImage3 = img3.getScaledInstance(largueur/9, hauteur/9,  java.awt.Image.SCALE_SMOOTH);  
        icon3 = new ImageIcon(resizedImage3);
	    JRadioButton rdbtnNewRadioButton2 = new JRadioButton("Carte de crédit");
	    JLabel imagePaypal = new JLabel(icon3);
	    panelPaypal.add(rdbtnNewRadioButton2);
	    panelPaypal.add(imagePaypal);
	    panelCentreEstNordSud.add(panelPaypal);
	    JPanel panelCheque = new JPanel();
	    ImageIcon icon4 = new ImageIcon("src\\main\\resources\\images\\icons\\Cheque.png");
	    Image img4 = icon4.getImage();
        Image resizedImage4 = img4.getScaledInstance(largueur/9, hauteur/9,  java.awt.Image.SCALE_SMOOTH);  
        icon4 = new ImageIcon(resizedImage4);
	    JRadioButton rdbtnNewRadioButton3 = new JRadioButton("Carte de crédit");
	    JLabel imageCheque = new JLabel(icon4);
	    panelCheque.add(rdbtnNewRadioButton3);
	    panelCheque.add(imageCheque);
	    panelCentreEstNordSud.add(panelCheque);
	    ButtonGroup payementGroup = new ButtonGroup();
	    payementGroup.add(rdbtnNewRadioButton);
	    payementGroup.add(rdbtnNewRadioButton2);
	    payementGroup.add(rdbtnNewRadioButton3);
	    
	    JPanel panelCentreEstSud = new JPanel();
	    panelCentreEst.add(panelCentreEstSud, BorderLayout.SOUTH);
	    panelCentreEstSud.setBorder(BorderFactory.createLineBorder(Color.yellow, 5));
	    panelCentreEstSud.setLayout(new BorderLayout(0, 0));
	    
	    JLabel lblNewLabel_2 = new JLabel("Abonnement à notre NewsLetter");
	    panelCentreEstSud.add(lblNewLabel_2, BorderLayout.NORTH);
	    
	    JPanel panelCentreEstSudSud = new JPanel();
	    panelCentreEstSud.add(panelCentreEstSudSud, BorderLayout.SOUTH);
	    
	    final ButtonGroup newsLetter = new ButtonGroup();
	    JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Oui");
	    panelCentreEstSudSud.add(rdbtnNewRadioButton_1);
	    JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Non");
	    panelCentreEstSudSud.add(rdbtnNewRadioButton_2);
	    newsLetter.add(rdbtnNewRadioButton_1);
	    newsLetter.add(rdbtnNewRadioButton_2);
	    
	    
	    JPanel panelSud = new JPanel();
	    panelSud.setBackground(new Color(0, 0, 0));
	    frame.getContentPane().add(panelSud, BorderLayout.SOUTH);
	    panelSud.setLayout(new BorderLayout(0, 0));
	    
	    JPanel panel = new JPanel();
	    panel.setBackground(new Color(0, 0, 0));
	    panelSud.add(panel, BorderLayout.EAST);
	    
	    JButton btnNewButton = new JButton("Valider");
	    btnNewButton.setBackground(new Color(128, 255, 0));
	    panel.add(btnNewButton);
	    
	    JButton btnNewButton_1 = new JButton("Annuler");
	    btnNewButton_1.setBackground(new Color(255, 0, 0));
	    panel.add(btnNewButton_1);
	    
	}


}
