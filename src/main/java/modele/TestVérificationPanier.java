package modele;

import static org.junit.Assert.assertTrue;

import javax.swing.JButton;

import org.junit.Test;

import ihm.FEN_Panier;

public class TestVérificationPanier {

    private FEN_Panier Paniertest;

    public void setUp() throws Exception {
        this.Paniertest = new FEN_Panier(new Panier(), new JButton());
    }

    public void tearDown() throws Exception {
        this.Paniertest = null;
    }

    @Test
    public void testAjoutElement() {
        Fromage fromagetest = new Fromage("Fromage de brebis");
        Article articletest = new Article(fromagetest, "250g", 2.5F);
        ArticleEtQuantite testarticleqt = new ArticleEtQuantite(articletest, 5);
        this.Paniertest.ajouterLigne(testarticleqt);
        assertTrue(this.Paniertest.getTableau().getRowCount() == 1);
    }

    @Test
    public void testSupprimerPanier() {

    }
}