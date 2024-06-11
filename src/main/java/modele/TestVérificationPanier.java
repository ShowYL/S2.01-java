package modele;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.swing.JButton;

import org.junit.Test;

import ihm.FEN_Panier;

public class TestVérificationPanier {

    private Panier Paniertest;

    public void setUp() throws Exception {
        this.Paniertest = new Panier();
    }

    public void tearDown() throws Exception {
        this.Paniertest = null;
    }

    @Test
    public void testAjoutElement() {
        Fromage fromagetest = new Fromage("Fromage de brebis");
        Article articletest = new Article(fromagetest, "250g", 2.5F);
        ArticleEtQuantite testarticleqt = new ArticleEtQuantite(articletest, 5);
        this.Paniertest.ajouterArticle(testarticleqt);
        assertFalse(this.Paniertest.estVide());
    }
}