package Exo1;

/*
 * Question 3/ La classe Groupe permet de gérer les étudiants d’un groupe. Les
 * attributs de la
 * classe Groupe sont :
 * 
 * • Nom du groupe ;
 * • Une Collection d’étudiants (un HashSet);
 * 
 * Ces attributs sont également encapsulés. Prévoir les méthodes suivantes :
 * elles utiliseront
 * l’interface Collection :
 * 
 * • Un constructeur ;
 * • Une méthode pour ajouter un étudiant (l’étudiant étant passé en paramètre)
 * ;
 * • Une méthode pour supprimer un étudiant (le matricule est passé en
 * paramètre) ;
 * • Une méthode affiche tous les étudiants du groupe ;
 * • Une méthode pour connaitre le nombre d’étudiants d’un groupe ;
 * • Une méthode pour calculer la moyenne du groupe ;
 * • Une méthode pour afficher les noms du premier et dernier du groupe.
 */
import java.util.HashSet;

public class Groupe {
    private String nom;
    private HashSet<Etudiant> etudiants;

    public Groupe(String nom) {
        this.nom = nom;
        this.etudiants = new HashSet<>();
    }

    public void ajouterEtudiant(Etudiant etudiant) {
        this.etudiants.add(etudiant);
    }

    public void supprimerEtudiant(int matricule) {
        for (Etudiant etudiant : etudiants) {
            if (etudiant.getMatricule() == matricule) {
                etudiants.remove(etudiant);
                break;
            }
        }
    }

    public void afficheEtudiants() {
        for (Etudiant etudiant : etudiants) {
            System.out.println(etudiant);
        }
    }

    public int getNombreEtudiants() {
        return etudiants.size();
    }

    public int getMoyenneGenerale() {
        int somme = 0;
        for (Etudiant etudiant : etudiants) {
            somme += etudiant.getMoyenneGenerale();
        }
        return somme / etudiants.size();
    }

    public String getPremierEtudiant() {
        return etudiants.iterator().next().getNom();
    }

    public String getDernierEtudiant() {
        return etudiants.iterator().next().getNom();
    }

    /*
     * Question 4/ Prévoir un jeu d’essai complet pour tester toutes les méthodes
     * précédemment
     * écrites.
     * Question 5/ Créez un menu complet dans le programme
     * principal pour
     * la gestion des étudiants d’un groupe. Affichez les statistiques des étudiants
     * et du groupe.
     */

    public static void main(String[] args) {
        Groupe groupe = new Groupe("Groupe 1");
        groupe.ajouterEtudiant(new Etudiant(1, "Dupont", "Jean"));
        groupe.ajouterEtudiant(new Etudiant(2, "Durand", "Jeanne"));
        groupe.ajouterEtudiant(new Etudiant(3, "Durand", "Paul"));
        groupe.afficheEtudiants();
        System.out.println("Nombre d'étudiants : " + groupe.getNombreEtudiants());
        System.out.println("Moyenne générale : " + groupe.getMoyenneGenerale());
        System.out.println("Premier étudiant : " + groupe.getPremierEtudiant());
        System.out.println("Dernier étudiant : " + groupe.getDernierEtudiant());
        System.out.println("Suppression de l'étudiant 2");
        groupe.supprimerEtudiant(2);
        groupe.afficheEtudiants();
        System.out.println("Nombre d'étudiants : " + groupe.getNombreEtudiants());
    }
}