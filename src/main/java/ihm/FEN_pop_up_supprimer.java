package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class FEN_pop_up_supprimer extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FEN_pop_up_supprimer frame = new FEN_pop_up_supprimer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FEN_pop_up_supprimer() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 153);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		
		JLabel lbl1 = new JLabel("");
		
		int hauteur = (int) (screenSize.height * 0.7);  // 70% de la hauteur de l'écran	    
		int largueur = (int) (screenSize.width * 0.7);  // 70% de la largueur de l'écran
		
		ImageIcon icon = new ImageIcon("src\\main\\resources\\images\\icons\\Interrogation.png");
		Image img = icon.getImage();
		Image resizedImage = img.getScaledInstance(largueur/16, hauteur/16,  java.awt.Image.SCALE_SMOOTH);  
		icon = new ImageIcon(resizedImage);
		
		lbl1.setIcon(icon);
		panel.add(lbl1);
		
		JLabel lbl2 = new JLabel("Voulez-vous vraiment supprimer votre panier ?");
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lbl2);
		
		JPanel panel1 = new JPanel();
		contentPane.add(panel1, BorderLayout.SOUTH);
		
		JButton btn1 = new JButton("Oui");
		btn1.setBackground(new Color(0, 255, 128));
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel1.add(btn1);
		
		JButton btn2 = new JButton("Non");
		btn2.setBackground(new Color(255, 128, 0));
		btn2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel1.add(btn2);
		
		JButton btn3 = new JButton("Annuler");
		btn3.setBackground(new Color(255, 0, 0));
		btn3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel1.add(btn3);
	}

}
