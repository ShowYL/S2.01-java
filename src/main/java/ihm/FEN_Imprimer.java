package ihm;

import java.awt.BorderLayout;
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
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;

public class FEN_Imprimer {

	private JFrame frame;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;

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

	public JFrame getFrame(){
		return this.frame;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		titre.setForeground(Constantes.BLANC);
		titre.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 36));
		titre.setBorder(new EmptyBorder(11, 0, 15, 0));
		panel.add(titre);
		
		JPanel panel_center = new JPanel();
		frame.getContentPane().add(panel_center, BorderLayout.CENTER);
		panel_center.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_service = new JPanel();
		panel_center.add(panel_service);
		panel_service.setLayout(new GridLayout(5, 2, 0, 0));
		
		JLabel lblService = new JLabel("Service d'impression");
		lblService.setHorizontalAlignment(SwingConstants.LEFT);
		lblService.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_service.add(lblService);
		
		JPanel panel_1 = new JPanel();
		panel_service.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Nom :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Imprimante 1");
		comboBox.addItem("Imprimante 2");
		comboBox.addItem("Imprimante 3");
		panel_1.add(comboBox);
		
		JButton btnNewButton = new JButton("Propriétés");
		btnNewButton.setBackground(new Color(240, 240, 240));
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Statut : Acception des tâches");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_service.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Type :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_service.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Infos : ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_service.add(lblNewLabel_3);
		
		JPanel panel_center_footer = new JPanel();
		panel_center.add(panel_center_footer);
		panel_center_footer.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_plage = new JPanel();
		panel_center_footer.add(panel_plage);
		panel_plage.setLayout(new GridLayout(3, 0, 0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("Plage d'imporession");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_plage.add(lblNewLabel_4);
		
		rdbtnNewRadioButton = new JRadioButton("Tout");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnNewRadioButton.isSelected()) {
					rdbtnNewRadioButton_1.setSelected(false);
				}
			}
		});
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_plage.add(rdbtnNewRadioButton);
		
		JPanel panel_2 = new JPanel();
		panel_plage.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		rdbtnNewRadioButton_1 = new JRadioButton("Pages :");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnNewRadioButton_1.isSelected()) {
					rdbtnNewRadioButton.setSelected(false);
				}
			}
		});
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(rdbtnNewRadioButton_1);
		

		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(spinner);
		
		JLabel lblNewLabel_5 = new JLabel("A");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(lblNewLabel_5);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(spinner_1);
		
		JPanel panel_copies = new JPanel();
		panel_center_footer.add(panel_copies);
		panel_copies.setLayout(new GridLayout(3, 0, 0, 0));
		
		JLabel lblNewLabel_6 = new JLabel("Copies");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_copies.add(lblNewLabel_6);
		
		JPanel panel_4 = new JPanel();
		panel_copies.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_7 = new JLabel("Nombre de copies :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_4.add(lblNewLabel_7);
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_5.add(spinner_2);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Collationner");
		panel_copies.add(chckbxNewCheckBox);
		
		JPanel panel_footer = new JPanel();
		panel_footer.setBackground(Constantes.NOIR);
		frame.getContentPane().add(panel_footer, BorderLayout.SOUTH);
		panel_footer.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panel_empty = new JPanel();
		panel_empty.setBackground(Constantes.NOIR);
		panel_footer.add(panel_empty);
		
		JButton btn_general = new JButton("Général");
		btn_general.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_general.setBackground(new Color(255, 255, 255));
		panel_empty.add(btn_general);
		
		JButton btn_page = new JButton("Mise en page");
		btn_page.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_page.setBackground(new Color(255, 255, 255));
		panel_empty.add(btn_page);
		
		JButton btn_font = new JButton("Apparence");
		btn_font.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_font.setBackground(new Color(255, 255, 255));
		panel_empty.add(btn_font);
		
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
