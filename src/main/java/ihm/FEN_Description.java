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
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class FEN_Description extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FEN_Description frame = new FEN_Description();
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
	public FEN_Description() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 722, 407);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel titre = new JLabel("[Nom du fromage]");
		titre.setBorder(new EmptyBorder(11, 0, 15, 0));
		titre.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 36));
		titre.setHorizontalAlignment(SwingConstants.CENTER);
		titre.setForeground(new Color(255, 255, 255));
		contentPane.add(titre, BorderLayout.NORTH);
		
		JPanel panel_fromage = new JPanel();
		panel_fromage.setBackground(new Color(192, 192, 192));
		contentPane.add(panel_fromage, BorderLayout.CENTER);
		panel_fromage.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel photo = new JLabel("PHOTO");
		photo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		photo.setHorizontalAlignment(SwingConstants.CENTER);
		panel_fromage.add(photo);
		
		JPanel panel_description = new JPanel();
		panel_description.setBackground(new Color(192, 192, 192));
		panel_fromage.add(panel_description);
		panel_description.setLayout(new BoxLayout(panel_description, BoxLayout.Y_AXIS));
		
		JLabel titre_description = new JLabel("Description");
		titre_description.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_description.add(titre_description);
		
		JTextArea description = new JTextArea();
		description.setBackground(new Color(255, 255, 255));
		description.setLineWrap(false);
		description.setText("Lorem ipsum dolor sit amet, consectetur adipiscing eli\r\nLorem ipsum dolor sit amet, consectetur adipiscing eli\r\nLorem ipsum dolor sit amet, consectetur adipiscing eli\r\nLorem ipsum dolor sit amet, consectetur adipiscing eli\r\nLorem ipsum dolor sit amet, consectetur adipiscing eli");
		panel_description.add(description);
		
		JPanel panel_footer = new JPanel();
		panel_footer.setBackground(new Color(0, 0, 0));
		contentPane.add(panel_footer, BorderLayout.SOUTH);
		panel_footer.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panel_prix = new JPanel();
		panel_prix.setBackground(new Color(0, 0, 0));
		panel_footer.add(panel_prix);
		
		JLabel euro_logo_1 = new JLabel("E");
		euro_logo_1.setForeground(Color.WHITE);
		euro_logo_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		panel_prix.add(euro_logo_1);
		
		JComboBox prix = new JComboBox();
		prix.setBorder(new LineBorder(new Color(251, 220, 4), 3));
		prix.setFont(new Font("Tahoma", Font.PLAIN, 15));
		prix.setModel(new DefaultComboBoxModel(new String[] {"Prix TTC : 3.99 €"}));
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
		btn_add.setBackground(new Color(0, 128, 0));
		btn_add.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_validation_annulation.add(btn_add);
		
		JButton btn_cancel = new JButton("Annuler");
		btn_cancel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn_cancel.setBackground(new Color(255, 0, 0));
		panel_validation_annulation.add(btn_cancel);
	}

}
