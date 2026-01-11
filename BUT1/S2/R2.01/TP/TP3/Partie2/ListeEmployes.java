/*
 * Question 6/
 * Écrivez une classe ListeEmployes ayant en variable d'instance une ArrayList
 * d'Employe et comportant des méthodes pour y ajouter un employé, la trier
 * selon le
 * salaire (utilisez l'algorithme de votre choix), l'afficher, etc.
 */

import java.util.ArrayList;

public class ListeEmployes {
    private ArrayList<Employe> listeEmployes;

    public void ajouterEmploye(Employe employe) {
        listeEmployes.add(employe);
    }

    public void trierSalaire() {
        for (int i = 0; i < listeEmployes.size(); i++) {
            for (int j = i + 1; j < listeEmployes.size(); j++) {
                if (listeEmployes.get(i).calculerSalaire() > listeEmployes.get(j).calculerSalaire()) {
                    Employe temp = listeEmployes.get(i);
                    listeEmployes.set(i, listeEmployes.get(j));
                    listeEmployes.set(j, temp);
                }
            }
        }
    }

    public void afficherListeEmployes() {
        for (Employe employe : listeEmployes) {
            employe.affiche();
        }
    }

    public void afficherListeEmployesString() {
        for (Employe employe : listeEmployes) {
            System.out.println(employe.toString());
        }
    }

    public ListeEmployes() {
        listeEmployes = new ArrayList<Employe>();
    }

    /*
     * Question 7/
     * Écrivez une méthode selectionner acceptant 2 arguments (min et max) et
     * permettant de retourner une instance de ListeEmployes composés des employés
     * ayant un âge compris strictement entre min et max.
     */

    public ListeEmployes selectionner(int min, int max) {
        ListeEmployes listeEmployesSelectionne = new ListeEmployes();
        for (Employe employe : listeEmployes) {
            if (employe.getAge() >= min && employe.getAge() <= max) {
                listeEmployesSelectionne.ajouterEmploye(employe);
            }
        }
        return listeEmployesSelectionne;
    }

}