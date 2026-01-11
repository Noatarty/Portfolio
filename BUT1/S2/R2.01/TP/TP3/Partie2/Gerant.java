/*
 * Pour chaque classe, écrivez un constructeur qui reçoit en paramètres toutes
 * les données
 * nécessaires.
 * Question 3/
 * Écrivez une classe Gerant qui hérite de la classe Employé. Un Gérant est un
 * Employé
 * caractérisé en plus par un nombre d’heure fixe (Nb_H_G= 30).
 */

public class Gerant extends Employe {
    private int nb_H_G;

    public Gerant(String nom, int age, int nb_A) {
        super(nom, age, nb_A);
        this.nb_H_G = 30;
    }

    public int getNb_H_G() {
        return nb_H_G;
    }

    public void affiche() {
        super.affiche();
        System.out.println("Nombre d'heure G: " + nb_H_G);
    }

    public String toString() {
        return super.toString() + " Nombre d'heure G: " + nb_H_G + "\n";
    }

    /*
     * On souhaite calculer le salaire de chaque employé, salaire qui se calcule de
     * la façon
     * suivante :
     * - pour un gérant : 5 * Nb_H_G * (20 + Nb_A/2)
     */

    public double calculerSalaire() {
        return 5 * nb_H_G * (20 + nb_A / 2);
    }
}