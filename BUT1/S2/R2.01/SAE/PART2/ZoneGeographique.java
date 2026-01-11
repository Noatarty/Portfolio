package SAE.PART2;

public class ZoneGeographique {
    private String nom;

    public ZoneGeographique(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String toString() {
        return nom;
    }

    public void affiche() {
        System.out.println(this.toString());
    }

    public boolean equals(ZoneGeographique z) {
        if (z == null) {
            return false;
        }
        if (this.nom.compareTo(z.getNom()) == 0) {
            return true;
        }
        return false;
    }
}