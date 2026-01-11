package Exo1;

public class Sport {
    // variables d'instance
    private static int compteur = 0;
    private int code;
    private String libelle;

    // constructeur
    public Sport(String libelle) {
        this.libelle = libelle;
        code = compteur++;
        compteur++;
    }

    // accesseurs
    int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    // méthode toString()
    public String toString() {
        return "Sport [code=" + code + ", libelle=" + libelle + "]";
    }

    // méthode affiche()
    public void affiche() {
        System.out.println(toString());
    }
}