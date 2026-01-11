package Exo2;

public class Personne {
    /*
     * Définir une classe Personne ayant comme variables d’instance le nom, le
     * prénom et l’adresse de la personne. Prévoir le constructeur, dont les valeurs
     * initiales sont
     * passées en paramètres, les accesseurs et la méthode toString().
     */
    private String nom;
    private String prenom;
    private String adresse;

    public Personne(String nom, String prenom, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String toString() {
        return "Nom : " + this.nom + " Prenom : " + this.prenom + " Adresse : " + this.adresse;
    }
}
