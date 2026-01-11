/*
 * Pour chaque classe, écrivez un constructeur qui reçoit en paramètres toutes
 * les données
 * nécessaires.
 * Question 2 /
 * Écrivez une classe Ouvrier qui hérite de la classe Employé. Un Ouvrier est un
 * Employé caractérisé en plus par un nombre d’heure fixe (Nb_H_O= 35).
 */

public class Ouvrier extends Employe {
    private int nb_H_O;

    public Ouvrier(String nom, int age, int nb_A) {
        super(nom, age, nb_A);
        this.nb_H_O = 35;
    }

    public int getNb_H_O() {
        return nb_H_O;
    }

    public void affiche() {
        super.affiche();
        System.out.println("Nombre d'heure O: " + nb_H_O);
    }

    public String toString() {
        return super.toString() + " Nombre d'heure O: " + nb_H_O + "\n";
    }

    /*
     * On souhaite calculer le salaire de chaque employé, salaire qui se calcule
     * de
     * la façon
     * suivante :
     * - pour un ouvrier: 4 * Nb_H_O * (10 + Nb_A/2)
     */
    public double calculerSalaire() {
        return 4 * nb_H_O * (10 + nb_A / 2);
    }
}