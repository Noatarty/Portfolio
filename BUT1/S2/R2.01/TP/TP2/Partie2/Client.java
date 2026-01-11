public class Client {

    private static int compteur = 0;
    private int num;
    private String nom;
    private String domicile;

    public Client(String nom, String domicile) {
        this.num = ++compteur;
        this.nom = nom;
        this.domicile = domicile;
    }

    public int getNum() {
        return num;
    }

    public String getNom() {
        return nom;
    }

    public String getDomicile() {
        return domicile;
    }

    public void afficher() {
        System.out.println("Client n°" + this.num + " : " + this.nom + ", " + this.domicile);
    }

    public static void main(String[] args) {

        Client c1 = new Client("Dupont", "Paris");
        Client c2 = new Client("Durand", "Marseille");

        c1.afficher();
        c2.afficher();

    }

}
