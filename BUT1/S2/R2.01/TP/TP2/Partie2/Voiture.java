import java.util.ArrayList;

public class Voiture {

    private String immatriculation;
    private String modele;
    private int km;
    private float tarif;

    public Voiture(String immat, String mod, int kms, float tar) {
        this.immatriculation = immat;
        this.modele = mod;
        this.km = kms;
        this.tarif = tar;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public String getModele() {
        return modele;
    }

    public int getKm() {
        return km;
    }

    public float getTarif() {
        return tarif;
    }

    public void afficher() {
        System.out.println("Voiture : " + this.immatriculation + " " + this.modele + " " + this.km + " km " + this.tarif
                + " €/km");
    }

    public static void main(String[] args) {

        ArrayList<Voiture> voitures = new ArrayList<Voiture>();

        // Création de Voiture avec les nouveaux paramètres
        voitures.add(new Voiture("AA-001", "Clio", 10000, 10));
        voitures.add(new Voiture("BB-002", "208", 5000, 12));

        // Affichage
        for (Voiture v : voitures) {
            v.afficher();
        }

        // Suppression d'une voiture
        voitures.remove(1);

        // Réaffichage
        System.out.println("Après suppression :");
        for (Voiture v : voitures) {
            v.afficher();
        }

    }
}