package ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import modele.Coordonnee;
import modele.Panier;

public class FEN_Facture {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Panier panier = new Panier();
                    float calculPrixTotal = 0.0F;
                    Coordonnee coordonnee = new Coordonnee(null, null, null, null, null, null, null, null, null);
                    FEN_Facture window = new FEN_Facture(panier, coordonnee, calculPrixTotal);
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
    public FEN_Facture(Panier panier, Coordonnee coordonnee, float calculPrixTotal) {
        initialize(panier, coordonnee, calculPrixTotal);
    }

    public JFrame getFrame() {
        return this.frame;
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize(Panier panier, Coordonnee coordonnee, float calculPrixTotal) {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel panelNord = new JPanel();
        panelNord.setBackground(Constantes.NOIR);
        frame.getContentPane().add(panelNord, BorderLayout.NORTH);

        JLabel lblNewLabel = new JLabel("Facture");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int hauteur = (int) (screenSize.height * 0.7); // 70% de la hauteur de l'écran
        int largueur = (int) (screenSize.width * 0.7); // 70% de la largueur de l'écran
        frame.setSize((int) (largueur / 0.7 * 0.5), hauteur);
        frame.setLocationRelativeTo(null);

        ImageIcon icon = new ImageIcon("src\\main\\resources\\images\\icons\\Facture.png");
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(largueur / 10, hauteur / 10, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(resizedImage);
        lblNewLabel.setIcon(icon);
        lblNewLabel.setForeground(Constantes.BLANC);
        panelNord.add(lblNewLabel);

        JPanel panelSud = new JPanel();
        panelSud.setBackground(Constantes.NOIR);
        frame.getContentPane().add(panelSud, BorderLayout.SOUTH);
        panelSud.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        panel.setBackground(Constantes.NOIR);
        panelSud.add(panel, BorderLayout.EAST);

        JButton btn_print = new JButton("Imprimer");
        btn_print.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Print logic here
            }
        });
        btn_print.setBackground(Constantes.JAUNE);
        btn_print.setFont(new Font("Tahoma", Font.PLAIN, 17));
        panel.add(btn_print);

        JButton btn_quit = new JButton("Quitter");
        btn_quit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
            }
        });
        btn_quit.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btn_quit.setBackground(Constantes.ROUGE);
        panel.add(btn_quit);

        JPanel panelCentre = new JPanel();
        panelCentre.setLayout(new BorderLayout(0, 0));

        // Create a panel to hold all the components of the invoice
        JPanel invoicePanel = new JPanel();
        invoicePanel.setLayout(new BorderLayout(0, 0));

        // JTextArea for coordinates and payment details at the top
        JTextArea textArea1 = new JTextArea();
        textArea1.setEditable(false);
        textArea1.append(coordonnee.getPrenom() + " " + coordonnee.getNom().toUpperCase() + "\n");
        textArea1.append("Adresse 1 : " + coordonnee.getadresse1() + " " + coordonnee.getCodePostal() + " " + coordonnee.getVille() + "\n");
        textArea1.append("Téléphone : " + coordonnee.getTelephone() + "\n");
        textArea1.append("Mail : " + coordonnee.getEmail() + "\n\n");
        textArea1.append("Produits :\n");

        invoicePanel.add(textArea1, BorderLayout.NORTH);

        // JTable for panier items in the center
        JTable panierJTable = new JTable();
        panierJTable.setFont(new Font("Alef", Font.PLAIN, 10));
        panierJTable.setModel(new DefaultTableModel(new Object[][] {}, new String[] {}));

        DefaultTableModel model = (DefaultTableModel) panierJTable.getModel();
        model.setColumnIdentifiers(new String[] { "Image", "Produit", "Prix", "Quantit\u00E9", "Total" });
        for (int i = 0; i < panier.getSize(); i++) {
            model.addRow(new Object[] {
                panier.getPanier().get(i).getArticle().getFromage().getNomImage(),
                panier.getPanier().get(i).getArticle().getFromage().getDésignation(),
                panier.getPanier().get(i).getArticle().getPrixTTC()+"€",
                panier.getPanier().get(i).getQuantite(),
                panier.getPanier().get(i).getArticle().getPrixTTC() * panier.getPanier().get(i).getQuantite()+"€"
            });
        }

        invoicePanel.add(panierJTable, BorderLayout.CENTER);

        JTextArea textArea2 = new JTextArea();
        textArea2.setEditable(false);
        textArea2.append("\n\nTOTAL TTC Commande : " + panier.prixPanier() + "€ par " + coordonnee.getPayementMethode() + "\n");
        float fraisTransport = calculPrixTotal - panier.prixPanier();
        textArea2.append("FRAIS DE TRANSPORT : " + fraisTransport + "€ par " + coordonnee.getPayementMethode() + "\n");
        textArea2.append("PRIX TOTAL TTC : "+calculPrixTotal+"€");

        invoicePanel.add(textArea2, BorderLayout.SOUTH);

        JScrollPane scrollPane = new JScrollPane(invoicePanel);
        panelCentre.add(scrollPane, BorderLayout.CENTER);

        frame.getContentPane().add(panelCentre, BorderLayout.CENTER);
    }
}
