import java.util.ArrayList;
import java.util.Scanner;

public class Agence {

    private String nom;
    private ArrayList<Voiture> voitures;
    private ArrayList<Client> clients;
    private ArrayList<Location> locations;

    public Agence(String nom) {
        this.nom = nom;
        this.voitures = new ArrayList<Voiture>(100);
        this.clients = new ArrayList<Client>(100);
        this.locations = new ArrayList<Location>(100);

        // Initialisation
        this.voitures.add(new Voiture("AA-001", "Clio", 10000, 10));
        this.voitures.add(new Voiture("BB-002", "208", 5000, 12));

        this.clients.add(new Client("Dupont", "Paris"));
        this.clients.add(new Client("Durand", "Lille"));

        Date d1 = new Date(10, 3, 2022);
        this.locations.add(new Location(this.voitures.get(0), this.clients.get(0), d1));
    }

    public void afficherVoitures() {

        System.out.println("Nombre de voitures : " + this.voitures.size());

        if (this.voitures.isEmpty()) {
            System.out.println("Aucune voiture");
        } else {
            System.out.println("Liste des voitures :");
            for (Voiture v : this.voitures) {
                v.afficher();
            }
        }

    }

    public void afficherClients() {

        System.out.println("Nombre de clients : " + this.clients.size());

        if (this.clients.isEmpty()) {
            System.out.println("Aucun client");
        } else {
            System.out.println("Liste des clients :");
            for (Client c : this.clients) {
                c.afficher();
            }
        }

    }

    public void afficherLocations() {

        System.out.println("Nombre de locations : " + this.locations.size());

        if (this.locations.isEmpty()) {
            System.out.println("Aucune location");
        } else {
            System.out.println("Liste des locations :");
            for (Location loc : this.locations) {
                loc.afficher();
            }
        }

    }

    public static void main(String[] args) {

        Agence agence = new Agence("Ma super agence");

        // Afficher les voitures
        System.out.println("Liste des voitures :");
        agence.afficherVoitures();

        // Afficher les clients
        System.out.println("\nListe des clients :");
        agence.afficherClients();

        // Afficher les locations
        System.out.println("\nListe des locations :");
        agence.afficherLocations();

        // Ajouter une voiture
        System.out.println("\nAjout d'une voiture :");
        Scanner sc = new Scanner(System.in);
        System.out.println("Immatriculation : ");
        String immat = sc.nextLine();
        System.out.println("Modèle : ");
        String mod = sc.nextLine();
        System.out.println("Kilométrage : ");
        int kms = sc.nextInt();
        System.out.println("Tarif : ");
        float tar = sc.nextFloat();
        sc.nextLine();
        Voiture v = new Voiture(immat, mod, kms, tar);
        agence.voitures.add(v);
        agence.afficherVoitures();

        // Ajouter un client
        System.out.println("\nAjout d'un client :");
        System.out.println("Nom : ");
        String nom = sc.nextLine();
        System.out.println("Adresse : ");
        String adr = sc.nextLine();
        sc.nextLine();
        Client c = new Client(nom, adr);
        agence.clients.add(c);
        agence.afficherClients();

        // Ajouter une location
        System.out.println("\nAjout d'une location :");
        System.out.println("Voiture : ");
        int numVoiture = sc.nextInt();
        sc.nextLine();
        System.out.println("Client : ");
        int numClient = sc.nextInt();
        sc.nextLine();
        System.out.println("Date de location : ");
        Date d1 = new Date(sc.nextInt(), sc.nextInt(), sc.nextInt());
        sc.nextLine();
        Location loc = new Location(agence.voitures.get(numVoiture - 1), agence.clients.get(numClient - 1), d1);
        agence.locations.add(loc);
        agence.afficherLocations();

        // Retirer une location
        System.out.println("\nRetirer une location :");
        System.out.println("Location : ");
        int numLoc = sc.nextInt();
        sc.nextLine();
        agence.locations.remove(numLoc - 1);

        sc.close();

    }

}