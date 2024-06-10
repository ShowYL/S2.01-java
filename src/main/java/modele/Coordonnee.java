package modele;

public class Coordonnee {

    private String prenom;
    private String nom;
    private String adresse1;
    private String adresse2;
    private String codePostal;
    private String ville;
    private String email;
    private String payementMethode;
    private String telephone;

    public Coordonnee(String prenom, String nom, String adresse1, String adresse2, String codePostal, String ville, String email, String payementMethode, String telephone){
        this.prenom = prenom;
        this.nom = nom;
        this.adresse1 = adresse1;
        this.adresse2 = adresse2;
        this.codePostal = codePostal;
        this.ville = ville;
        this.email = email;
        this.payementMethode = payementMethode;
        this.telephone = telephone;
    }

    public String getPrenom(){
        return this.prenom;
    }

    public String getNom(){
        return this.nom;
    }

    public String getadresse1(){
        return this.adresse1;
    }

    public String getAdresse2(){
        return this.adresse2;
    }

    public String getCodePostal(){
        return this.codePostal;
    }

    public String getVille(){
        return this.ville;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPayementMethode(){
        return this.payementMethode;
    }

    public String getTelephone(){
        return this.telephone;
    }
}
