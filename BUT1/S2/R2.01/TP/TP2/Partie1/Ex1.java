class Voiture {
    static private int nbVoitures = 0;
    private int id;
    private String marque;
    private float vitesse;
    private float puissance;

    // constructeur : de même nom que la classe
    public Voiture(String laMarque, float laVitesse, float laPuissance) {
        marque = laMarque;
        vitesse = laVitesse;
        puissance = laPuissance;
        id = Voiture.getNbVoitures();
        nbVoitures++;
    }

    public Voiture() {
        marque = "";
        vitesse = 0;
        puissance = 0;
        id = Voiture.getNbVoitures();
        nbVoitures++;
    }

    public static int getNbVoitures() {
        return nbVoitures;
    }

    public String getMarque() {
        return this.marque;
    }

    public float getVitesse() {
        return this.vitesse;
    }

    public float getPuissance() {
        return this.puissance;
    }

    public void setMarque(String newMarque) {
        marque = newMarque;
    }

    public void setVitesse(float newVitesse) {
        vitesse = newVitesse;
    }

    public void setPuissance(float newPuissance) {
        puissance = newPuissance;
    }

    // Méthode de classe
    public int obtenirId() {
        return id;
    }

    public String toString() {
        return "ID : " + id + "\nMarque : " + marque + "\nVitesse : " + vitesse + "\nPuissance : " + puissance;
    }
}

class TestVoiture {
    public static void main(String[] args) {
        Voiture v1 = new Voiture("Peugeot", 250, 100);
        System.out.println(v1);
        Voiture v2 = new Voiture();
        System.out.println(v2);
    }
}
