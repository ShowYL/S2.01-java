package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import java.awt.Font;
import modele.Panier;

public class FEN_pop_up_supprimer {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTable Tableau_Panier = new JTable(); // Define the JTable here
					FEN_pop_up_supprimer window = new FEN_pop_up_supprimer(Tableau_Panier, new Panier(), new JButton());
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
	 * Create the frame.
	 */
	public FEN_pop_up_supprimer(JTable Tableau_Panier, Panier panier, JButton boutonPanier) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		frame = new JFrame();
		frame.setBounds(100, 100, 537, 153);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(499, 141);
		frame.setLocationRelativeTo(null);
		frame.setBackground(Constantes.GRIS_CLAIR);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);

		JLabel lbl1 = new JLabel("");

		int hauteur = (int) (screenSize.height * 0.7); // 70% de la hauteur de l'écran
		int largueur = (int) (screenSize.width * 0.7); // 70% de la largueur de l'écran

		ImageIcon icon = new ImageIcon("src\\main\\resources\\images\\icons\\Interrogation.png");
		Image img = icon.getImage();
		Image resizedImage = img.getScaledInstance(largueur / 16, hauteur / 16, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(resizedImage);

		lbl1.setIcon(icon);
		panel.add(lbl1);

		JLabel lbl2 = new JLabel("Voulez-vous vraiment supprimer votre panier ?");
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lbl2);

		JPanel panel1 = new JPanel();
		frame.getContentPane().add(panel1, BorderLayout.SOUTH);

		JButton btn1 = new JButton("Oui");
		btn1.setBackground(Constantes.VERT);
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel) Tableau_Panier.getModel();
				for (int i = model.getRowCount() - 1; i >= 0; i--) {
					model.removeRow(i);
					panier.getPanier().get(i).getArticle()
							.setQuantitéEnStock(panier.getPanier().get(i).getArticle().getQuantitéEnStock()
									+ panier.getPanier().get(i).getQuantite());
				}
				panier.getPanier().clear();
				boutonPanier.setText("00,00 €");
				frame.setVisible(false);
			}
		});
		panel1.add(btn1);

		JButton btn2 = new JButton("Non");
		btn2.setBackground(Constantes.ROUGE);
		btn2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
			}
		});
		panel1.add(btn2);
	}
}
