package SAE.PART2;

public class Personne {
    private String nom;
    private String prenom;
    private String numPasseport;

    public Personne(String nom, String prenom, String numPasseport) {
        this.nom = nom;
        this.prenom = prenom;
        this.numPasseport = numPasseport;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNumPasseport() {
        return numPasseport;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNumPasseport(String numPasseport) {
        this.numPasseport = numPasseport;
    }

    public String toString() {
        return prenom + " " + nom + " " + numPasseport;
    }

    public void affiche() {
        System.out.println(this.toString());
    }
}