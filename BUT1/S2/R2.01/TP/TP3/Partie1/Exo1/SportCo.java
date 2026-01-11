package Exo1;

public class SportCo extends Sport {
    private int nbJoueurs;

    public SportCo(String libelle, int nbJoueurs) {
        super(libelle);
        this.nbJoueurs = nbJoueurs;
    }

    // méthode pour afficher les informations d'une instance de SportCo
    public void afficher() {
        super.affiche();
        System.out.println("Nombre de joueurs : " + this.nbJoueurs);
    }

    public static void main(String[] args) {
        SportCo football = new SportCo("Football", 11);
        football.afficher();
    }
}
