package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class FEN_Imprimer {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FEN_Imprimer window = new FEN_Imprimer();
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
	public FEN_Imprimer() {
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
		frame.setSize(696,420);
        frame.setLocationRelativeTo(null);
        frame.setBackground(new Color(0, 0, 0));
        frame.getContentPane().setLayout(new BorderLayout(0, 0));
        
        JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setForeground(new Color(0, 0, 0));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel titre = new JLabel("Imprimer");
		titre.setHorizontalAlignment(SwingConstants.CENTER);
		titre.setForeground(Color.WHITE);
		titre.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 36));
		titre.setBorder(new EmptyBorder(11, 0, 15, 0));
		panel.add(titre);
		
	}

}
