package modele;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestVérificationPanier {

    private Panier Paniertest;

    @Before
    public void setUp() throws Exception {
        this.Paniertest = new Panier();
    }

    @After
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

    @SuppressWarnings("unchecked")
    @Test
    public void testCalculPrixTotal() {
        Fromage fromagetest = new Fromage("Fromage de brebis");
        Article articletest = new Article(fromagetest, "250g", 2.5F);
        ArticleEtQuantite testarticleqt = new ArticleEtQuantite(articletest, 5);
        this.Paniertest.ajouterArticle(testarticleqt);
        JComboBox testcombobox = new JComboBox<ImageIcon>();
        ImageIcon colissimo = new ImageIcon("src\\main\\resources\\images\\icons\\Colissimo.png");
        colissimo = new ImageIcon();
        testcombobox.setModel(
                new DefaultComboBoxModel<ImageIcon>(new ImageIcon[] { colissimo }));
        testcombobox.setSelectedIndex(0);
        assertEquals(27.4F, this.Paniertest.recalculerPanier(testcombobox), 0.0001);
    }
}