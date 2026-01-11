package Partie1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.Set;
import Partie2.Annuaire;

public class Abonne {

    private String nom;
    private String adresse;
    private Collection<NumTel> numeros;
    private Set<Annuaire> annuaires;

    public Abonne(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
        this.numeros = new ArrayList<>();
    }

    public Abonne() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le nom : ");
        this.nom = scanner.nextLine();

        System.out.print("Entrez l'adresse : ");
        this.adresse = scanner.nextLine();

        this.numeros = new ArrayList<>();

    }

    public Collection<NumTel> getNumeros() {
        return numeros;
    }

    public void ajouterNumero(Scanner scanner) {

        System.out.print("Entrez le numéro à ajouter : ");
        String numero = scanner.nextLine();

        try {
            NumTel numTel = new NumTel(numero);

            // Vérifier que le numéro n'existe pas déjà
            if (this.numeros.contains(numTel)) {
                System.out.println("Ce numéro existe déjà pour cet abonné");
                return;
            }

            this.numeros.add(numTel);

        } catch (NumeroIncorrectException e) {
            System.out.println("Numéro incorrect : " + e.getMessage());
        }

    }

    public String toString() {
        return "Abonné : " + nom + ", " + adresse;
    }

    public void afficherNumeros() {
        System.out.println("Numéros de téléphone :");
        for (NumTel num : this.numeros) {
            System.out.println(num);
        }
    }

    public void supprimerNumero(Scanner scanner) {

        System.out.print("Entrez le numéro à supprimer : ");
        String numeroASupprimer = scanner.nextLine();

        for (NumTel num : this.numeros) {
            if (num.toString().equals(numeroASupprimer)) {
                this.numeros.remove(num);
                return;
            }
        }

        System.out.println("Numéro introuvable");

    }

    public void ajouterAnnuaire(Annuaire annuaire) {
        annuaires.add(annuaire);
        annuaire.inscrire(this);
    }

    public void retirerAnnuaire(Annuaire annuaire) {
        annuaires.remove(annuaire);
        annuaire.desinscrire(this);
    }

    private void mettreAJourAnnuaires() {
        for (Annuaire annuaire : annuaires) {
            annuaire.desinscrire(this);
            annuaire.inscrire(this);
        }
    }

}
