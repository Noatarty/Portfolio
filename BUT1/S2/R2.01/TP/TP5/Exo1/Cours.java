package Exo1;

/*
 * Question 1/ Proposez une classe pour représenter un cours (une seule variable
 * d'instance, une
 * instance de String pour son intitulé). Prévoir un constructeur,
 * l’encapsulation des variables
 * d’instance et la redéfinition des méthodes equals() et toString().
*/

public class Cours {
    private String intitule;

    public Cours(String intitule) {
        this.intitule = intitule;
    }

    public String getIntitule() {
        return intitule;
    }

    @Override
    public String toString() {
        return "Cours [intitule=" + intitule + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        return obj instanceof Cours && intitule.equals(((Cours) obj).intitule);
    }
}
