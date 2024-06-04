package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
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
        frame.setBackground(Constantes.GRIS_CLAIR);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));
        
        JPanel panel = new JPanel();
		panel.setBackground(Constantes.NOIR);
		panel.setForeground(Constantes.NOIR);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel titre = new JLabel("Imprimer");
		titre.setHorizontalAlignment(SwingConstants.CENTER);
		titre.setForeground(Color.WHITE);
		titre.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 36));
		titre.setBorder(new EmptyBorder(11, 0, 15, 0));
		panel.add(titre);
		
		
		
		JPanel panel_footer = new JPanel();
		panel_footer.setBackground(Constantes.NOIR);
		frame.getContentPane().add(panel_footer, BorderLayout.SOUTH);
		panel_footer.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panel_empty = new JPanel();
		panel_empty.setBackground(Constantes.NOIR);
		panel_footer.add(panel_empty);
		
		JPanel panel_imprim_quit = new JPanel();
		panel_imprim_quit.setBackground(Constantes.NOIR);
		panel_footer.add(panel_imprim_quit);
		
		JButton btn_print = new JButton("Imprimer");
		btn_print.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_print.setBackground(Constantes.VERT);
		btn_print.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_imprim_quit.add(btn_print);
		
		JButton btn_quit = new JButton("Quitter");
		btn_quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btn_quit.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn_quit.setBackground(Constantes.ROUGE);
		panel_imprim_quit.add(btn_quit);
	}

}
