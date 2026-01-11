package SAE.PART1;

import java.util.ArrayList;

public class Acteur {
    private String nom;
    private String prenom;
    private ArrayList<Film> mesFilms = new ArrayList<>();

    public Acteur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String toString() {
        return prenom + " " + nom;
    }

    public void Affiche() {
        System.out.println(this.toString());
    }

    public boolean equals(Acteur a) {
        if (a == null) {
            return false;
        }
        if (this.nom.compareTo(a.getNom()) == 0 && this.prenom.compareTo(a.getPrenom()) == 0) {
            return true;
        }
        return false;
    }

    public boolean contientFilm(Film f) {
        return mesFilms.contains(f);
    }

    public void ajouterFilm(Film f) {
        mesFilms.add(f);
    }

    public void enleverFilm(Film f) {
        mesFilms.remove(f);
    }
}