package Exo1;

/* Question  2/  On  souhaite  gérer  un  ensemble  d’étudiants.  Chaque  étudiant sera  défini  par  une 
classe Etudiant caractérisée par les informations suivantes :  
  
• Un matricule (numéro d’inscription) qui est entier, identifiant unique de chaque étudiant ;  
• Un nom ;  
• Un prénom ;  
• Une instance de HashMap conserve pour chaque cours, la note obtenue par l’étudiant : une 
seule note est associée à matière.   
 Les attributs de la classe Etudiant sont encapsulés. */
import java.util.HashMap;

public class Etudiant {
    private int matricule;
    private String nom;
    private String prenom;
    private HashMap<Cours, Integer> notes;

    public Etudiant(int matricule, String nom, String prenom) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.notes = new HashMap<>();
    }

    /*
     * Prévoir les méthodes suivantes :
     * 
     * • Une méthode affiche les notes des candidats pour toutes les matières ;
     * • Une méthode supprime une note étant donné le libellé du cours ;
     * • Une méthode calcule la moyenne générale d’un étudiant ;
     * • Une méthode délivre la note d’une matière (l’identifiant de la matière est
     * passé en paramètre)
     * ;
     * • Une méthode retourne sa meilleure note ;
     * • Une méthode retourne sa moins bonne note.
     */

    @Override
    public String toString() {
        return "Etudiant [matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom + ", notes=" + notes + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        return obj instanceof Etudiant && matricule == ((Etudiant) obj).matricule;
    }

    public int getMatricule() {
        return matricule;
    }

    public String getNom() {
        return nom;
    }

    public void ajouterNote(Cours cours, int note) {
        notes.put(cours, note);
    }

    public void modifierNote(Cours cours, int note) {
        notes.put(cours, note);
    }

    public int getNote(Cours cours) {
        return notes.get(cours);
    }

    public void supprimerNote(Cours cours) {
        notes.remove(cours);
    }

    public int getMoyenneGenerale() {
        int somme = 0;
        for (int note : notes.values()) {
            somme += note;
        }
        return somme / notes.size();
    }

    public int getMeilleureNote() {
        int meilleureNote = 0;
        for (int note : notes.values()) {
            if (note > meilleureNote) {
                meilleureNote = note;
            }
        }
        return meilleureNote;
    }

    public int getMoinsBonneNote() {
        int meilleureNote = 0;
        for (int note : notes.values()) {
            if (note < meilleureNote) {
                meilleureNote = note;
            }
        }
        return meilleureNote;
    }

    /*
     * Question 4/ Prévoir un jeu d’essai complet pour tester toutes les méthodes
     * précédemment
     * écrites.
     */
    public static void main(String[] args) {
        Etudiant etudiant1 = new Etudiant(1, "Dupont", "Jean");
        Cours cours1 = new Cours("Maths");
        Cours cours2 = new Cours("Physique");
        etudiant1.ajouterNote(cours1, 10);
        etudiant1.ajouterNote(cours2, 10);
        etudiant1.modifierNote(cours1, 12);
        etudiant1.modifierNote(cours2, 12);
        System.out.println(etudiant1);
        System.out.println(etudiant1.getMoyenneGenerale());
        System.out.println(etudiant1.getMeilleureNote());
        System.out.println(etudiant1.getMoinsBonneNote());
        System.out.println(etudiant1.getNote(cours1));
        System.out.println(etudiant1.getNote(cours2));
        etudiant1.supprimerNote(cours1);
        System.out.println(etudiant1);
    }
}
