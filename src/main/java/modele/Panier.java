package modele;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class Panier {
	
	private ArrayList<ArticleEtQuantite> liste_P;
	
	
	public Panier() {
		this.liste_P = new ArrayList<>();
	}
	
	public ArrayList<ArticleEtQuantite> getPanier() {
		return this.liste_P;
	}
	
	public int getSize() {
		return this.liste_P.size();
	}
	
	public boolean estVide() {
		return this.liste_P.size() == 0;
	}
	
	public void ajouterArticle(ArticleEtQuantite article) {
		this.liste_P.add(article);
	}
	
	public float prixPanier() {
		float somme = 0.0F;
		for (ArticleEtQuantite articleEtQuantite : this.liste_P) {
			somme += articleEtQuantite.getArticle().getPrixTTC() * articleEtQuantite.getQuantite();
		}
		return somme;
	}

	public float calculerExpedition(JComboBox<ImageIcon> comboBoxTranporteur) {
		float prix_expedition = 0.0F;
		float prix_Panier = prixPanier();
		if (comboBoxTranporteur.getSelectedIndex() == 0 || comboBoxTranporteur.getSelectedIndex() == 1) {
			if (prix_Panier < 60.0F) {
				prix_expedition = 14.90F;
			} else if (prix_Panier < 90.0F) {
				prix_expedition = 9.90F;
			} else if (prix_Panier < 120.0F) {
				prix_expedition = 4.90F;
			} else {
				prix_expedition = 0.0F;
			}
		}
		if (comboBoxTranporteur.getSelectedIndex() == 2) {
			if (prix_Panier < 60.0F) {
				prix_expedition = 23.90F;
			} else if (prix_Panier < 90.0F) {
				prix_expedition = 17.90F;
			} else if (prix_Panier < 120.0F) {
				prix_expedition = 9.90F;
			} else {
				prix_expedition = 0.0F;
			}
		}
		return prix_expedition;
	}

		public float recalculerPanier(JComboBox<ImageIcon> comboBoxTranporteur) {
			return prixPanier() + calculerExpedition(comboBoxTranporteur);
			
		};
	
}
