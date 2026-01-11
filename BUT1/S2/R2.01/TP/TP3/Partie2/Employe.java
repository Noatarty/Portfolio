/*
 * Pour chaque classe, écrivez un constructeur qui reçoit en paramètres toutes
 * les données
 * nécessaires.
 * Question 1 /
 * Écrivez une classe abstraite Employe. Un employé est caractérisé par son nom,
 * son
 * âge, le nombre d’année d’expérience (Nb_A) et un numéro généré
 * automatiquement avec un compteur
 * lors de chaque création.
 */
public abstract class Employe {
    protected String nom;
    protected int age;
    protected int nb_A;
    protected int numero;
    protected static int compteur = 0;

    public Employe(String nom, int age, int nb_A) {
        this.nom = nom;
        this.age = age;
        this.nb_A = nb_A;
        this.numero = compteur;
        compteur++;
    }

    public String getNom() {
        return nom;
    }

    public int getAge() {
        return age;
    }

    public int getNb_A() {
        return nb_A;
    }

    public int getNumero() {
        return numero;
    }

    public static int getCompteur() {
        return compteur;
    }

    /*
     * Question 5/
     * On souhaite afficher pour chaque employé sa catégorie (Gérant ou Ouvrier) et
     * toutes les
     * autres informations (numéro, nom, âge, salaire).
     */

    public void affiche() {
        System.out.println("Nom: " + nom + " Age: " + age + " Nb_A: " + nb_A + " Numero: " + numero);
        System.out.println("Salaire: " + calculerSalaire());
        System.out.println("Catégorie: " + getClass().getSimpleName());
    }

    public String toString() {
        return "Nom: " + nom + " Age: " + age + " Nb_A: " + nb_A + " Numero: " + numero;
    }

    /*
     * Question 4/
     * On souhaite calculer le salaire de chaque employé, salaire qui se calcule de
     * la façon
     * suivante :
     * - pour un ouvrier: 4 * Nb_H_O * (10 + Nb_A/2),
     * - pour un gérant : 5 * Nb_H_G * (20 + Nb_A/2)
     * Pensez à la notion de méthode abstraite
     */
    public abstract double calculerSalaire();

}