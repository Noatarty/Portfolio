public class Location {

    private static int compteur = 0;
    private int num;
    private Voiture voiture;
    private Client client;
    private Date dateLocation;
    private Date dateRetour;
    private int km;

    public Location(Voiture voiture, Client client, Date dateLocation) {
        this.num = ++compteur;
        this.voiture = voiture;
        this.client = client;
        this.dateLocation = dateLocation;
        this.dateRetour = null;
        this.km = voiture.getKm();
    }

    public int getNum() {
        return num;
    }

    public Voiture getVoiture() {
        return voiture;
    }

    public Client getClient() {
        return client;
    }

    public Date getDateLocation() {
        return dateLocation;
    }

    public Date getDateRetour() {
        return dateRetour;
    }

    public int getKm() {
        return km;
    }

    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }

    public void afficher() {
        System.out.println("Location n°" + num);
        System.out.println("Voiture :");
        voiture.afficher();
        System.out.println("Client :");
        client.afficher();
        System.out.println("Date de location :");
        dateLocation.afficher();
        if (dateRetour == null) {
            System.out.println("En cours");
        } else {
            System.out.println("Date de retour :");
            dateRetour.afficher();
        }
        System.out.println("Kilométrage : " + km + " km");
    }

    public static void main(String[] args) {

        // Création des objets
        Voiture v = new Voiture("AA-001", "Clio", 10000, 10);
        Client c = new Client("Dupont", "Paris");
        Date d1 = new Date(10, 3, 2022);

        Location loc = new Location(v, c, d1);

        // Affichage
        loc.afficher();

        // Modification date de retour
        Date d2 = new Date(15, 3, 2022);
        loc.setDateRetour(d2);

        // Réaffichage
        loc.afficher();

    }
}
