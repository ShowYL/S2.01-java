package modele;

public class ArticleEtQuantite {
	
	private Article article;
	private int quantite;
	
	public ArticleEtQuantite(Article article, int quantite) throws IllegalArgumentException {
		if (quantite < 1) {
			throw new IllegalArgumentException("quantite inférieur à 1...");
		}
		this.article = article;
		this.quantite = quantite;
	}
	
	public Article getArticle() {
		return this.article;
	}
	
	public int getQuantite() {
		return this.quantite;
	}
	
	public void changerQuantite(int q) throws IllegalArgumentException {
		if (q < 1) {
			throw new IllegalArgumentException("quantite inférieur à 1...");
		}
		this.quantite = q;
	}
}
