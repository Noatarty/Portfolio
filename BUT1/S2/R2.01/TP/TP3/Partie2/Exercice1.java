/*
 * Question 8/
 * Dans une classe Exercice1, écrivez un programme qui :
 * - crée 3 ouvriers et 1 gérant,
 * - affiche le nombre des employés crées,
 * - crée une instance de ListeEmploye et y insère les 3 ouvriers et le gérant,
 * - affiche les informations pour tous les employés de la liste,
 * - trie les employés de la liste selon le salaire,
 * - ré-affiche les informations pour tous les employés de la liste,
 * - sélectionne et affiche les employés dont l’âge est compris entre 20 et 30
 * ans
 */

public class Exercice1 {
    public static void main(String[] args) {
        // Création des employés
        Gerant g = new Gerant("Gérant", 25, 10);
        Ouvrier o1 = new Ouvrier("Ouvrier1", 20, 5);
        Ouvrier o2 = new Ouvrier("Ouvrier2", 22, 10);
        Ouvrier o3 = new Ouvrier("Ouvrier3", 24, 15);
        // Affiche le nombre des employés crées
        System.out.println("Nombre d'employés: " + Employe.getCompteur());
        // Création de la liste d'employés
        ListeEmployes le = new ListeEmployes();
        // Ajout des employés à la liste
        le.ajouterEmploye(g);
        le.ajouterEmploye(o1);
        le.ajouterEmploye(o2);
        le.ajouterEmploye(o3);
        // Affiche les informations pour tous les employés de la liste
        le.afficherListeEmployes();
        // Trie les employés de la liste selon le salaire
        le.trierSalaire();
        // Ré-affiche les informations pour tous les employés de la liste
        le.afficherListeEmployes();
        // Sélectionne et affiche les employés dont l’âge est compris entre 20 et 30 ans
        le.selectionner(20, 30).afficherListeEmployes();
    }
}