public class Date {

    private int jour;
    private int mois;
    private int annee;

    public Date(int jour, int mois, int annee) {

        this.jour = jour;
        this.mois = mois;
        this.annee = annee;

    }

    public int getJour() {
        return jour;
    }

    public int getMois() {
        return mois;
    }

    public int getAnnee() {
        return annee;
    }

    public void setJour(int jour) {
        this.jour = jour;
    }

    public void afficher() {
        System.out.println(this.jour + "/" + this.mois + "/" + this.annee);
    }

    public static void main(String[] args) {

        Date d1 = new Date(25, 10, 2022);
        Date d2 = new Date(12, 12, 2022);

        d1.afficher();
        d2.afficher();

        d1.setJour(28);
        d1.afficher();

    }
}
