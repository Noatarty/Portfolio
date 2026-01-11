
import java.util.HashMap;

import java.util.Map;

import java.util.Objects;

public class Etudiant {

    static int compt = 0;

    private int matr;

    private String nom;

    private String prenom;

    private HashMap<Cours, Double> notes;

    public Etudiant(String nom, String prenom) {

        super();

        this.matr = compt;

        this.nom = nom;

        this.prenom = prenom;

        this.notes = new HashMap<Cours, Double>();

        compt++;

    }

    public String toString() {

        return "Etudiant [matr=" + matr + ", nom=" + nom + ", prenom=" + prenom + ", notes=" + notes + "]";

    }

    public boolean equals(Object obj) {

        if (this == obj)

            return true;

        if (obj == null)

            return false;

        if (getClass() != obj.getClass())

            return false;

        Etudiant other = (Etudiant) obj;

        return matr == other.matr;

    }

    public static int getCompt() {

        return compt;

    }

    public int getMatr() {

        return matr;

    }

    public String getNom() {

        return nom;

    }

    public String getPrenom() {

        return prenom;

    }

    public HashMap getNotes() {

        return notes;

    }

    public void ajouter_note(Cours cours, Double note) {

        if (notes.containsKey(cours)) {

            System.out.println("note déjja présente !!!");

        } else {

            notes.put(cours, note);

            System.out.println("note ajouté !!!");

        }

    }

    public void modifier_note(Cours cours, Double note) {

        if (notes.containsKey(cours)) {

            notes.put(cours, note);

            System.out.println("note modfié!!!");

        } else {

            System.out.println("note non présente!!!");

        }

    }

    public void affiche() {

        for (Cours cour : notes.keySet()) {

            System.out.println("cours : " + cour + "| note: " + notes.get(cour));

        }

    }

    public double moyenne() {

        double sum = 0.0;

        if (notes.size() != 0) {

            for (Map.Entry<Cours, Double> m : notes.entrySet()) {

                sum = sum + m.getValue();

            }

            return sum / notes.size() + 1;

        } else {

            return 0.0;

        }

    }

}
