# S2.01-java

## Lien vers la maquette
https://app.moqups.com/D5ddMTIfXpe5TqiqhHcIFn0Gbk1RFUqt/view/page/a9df99145

## Nomenclature
Nos fenêtres seront nommées de la manière suivante :
FEN_Nom

## Temporaire qui fait quoi
Clément page acceuil 1/7
Martin page description 2/7
Zyah page panier 3/7
Yann page coordonnée 5/7

## Redimensionner les images
    import java.awt.Image;
    import java.awt.Toolkit;
    import java.awt.Dimension;
    
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    int hauteur = (int) (screenSize.height * 0.7);  // 70% de la hauteur de l'écran	    
    int largueur = (int) (screenSize.width * 0.7);  // 70% de la largueur de l'écran
	
    ImageIcon icon = new ImageIcon("src\\main\\resources\\images\\icons\\Coordonnee.png");
    Image img = icon.getImage();
    Image resizedImage = img.getScaledInstance(largueur/8, hauteur/8,  java.awt.Image.SCALE_SMOOTH);  
    icon = new ImageIcon(resizedImage);
    lblNewLabel.setIcon(icon);