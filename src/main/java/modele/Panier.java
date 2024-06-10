package modele;
import java.util.ArrayList;

public class Panier {
	
	private ArrayList<Article> liste_P;
	
	
	public Panier() {
		this.liste_P = new ArrayList<>();
	}
	
	public ArrayList<Article> getPanier() {
		return this.liste_P;
	}
	
	public int getSize() {
		return this.liste_P.size();
	}
	
	public boolean estVide() {
		return this.liste_P.size() == 0;
	}
	
	public void ajouterArticle(Article article) {
		this.liste_P.add(article);
	}

}
