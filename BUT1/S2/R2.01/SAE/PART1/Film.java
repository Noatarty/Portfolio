package SAE.PART1;

import java.util.ArrayList;
import java.util.HashMap;

public class Film {
    private String titre;
    private int duree;
    private String nationalite;
    private String resume;
    private ArrayList<Acteur> mesActeurs;
    private ArrayList<Seance> mesSeances;
    private HashMap<Acteur, String> roles;

    public Film(String titre, int duree, String nationalite, String resume) {
        this.titre = titre;
        this.duree = duree;
        this.nationalite = nationalite;
        this.resume = resume;
        this.mesActeurs = new ArrayList<>();
        this.mesSeances = new ArrayList<>();
        this.roles = new HashMap<>();
    }

    public String getTitre() {
        return titre;
    }

    public int getDuree() {
        return duree;
    }

    public String getNationalite() {
        return nationalite;
    }

    public String getResume() {
        return resume;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String toString() {
        return this.titre + "       Film" + this.nationalite + "de" + this.duree + "min" + "\n" + "Resume:"
                + this.resume;
    }

    public boolean equals(Film f) {
        if (f == null) {
            return false;
        }
        if (this.titre.compareTo(f.getTitre()) == 0) {
            return true;
        }
        return false;
    }

    public boolean contientActeur(Acteur a) {
        return mesActeurs.contains(a);
    }

    public void ajouterActeur(Acteur a) {
        if (!contientActeur(a)) {
            mesActeurs.add(a);
            a.ajouterFilm(this);
        }
    }

    public void ajouterJouer(Acteur a) {
        if (a != null && !contientActeur(a)) {
            ajouterActeur(a);
        } else {
            System.out.println("L'acteur est déjà associé au film ou est null.");
        }
    }

    public void listerActeurs() {
        System.out.println("Acteurs du film " + titre + " :");
        for (Acteur acteur : mesActeurs) {
            System.out.println("- " + acteur.getNom() + " " + acteur.getPrenom());
        }
    }

    public void Affiche() {
        System.out.println(this.toString());
        listerActeurs();
    }

    public void enleverJouer(Acteur a) {
        if (a != null && contientActeur(a)) {
            enleverActeur(a);
        } else {
            System.out.println("L'acteur n'est pas associé au film ou est null.");
        }
    }

    public void enleverActeur(Acteur a) {
        mesActeurs.remove(a);
        a.enleverFilm(this);
    }

    public void ajouterSeance(Seance s) {
        mesSeances.add(s);
    }

    public void enleverSeance(Seance s) {
        mesSeances.remove(s);
    }

    public void ajouterRole(Acteur acteur, String nomRole) {
        roles.put(acteur, nomRole);
        if (!mesActeurs.contains(acteur)) {
            mesActeurs.add(acteur);
        }
    }

    public void listerActeursEtRoles() {
        System.out.println("Acteurs du film " + titre + " :");
        for (Acteur acteur : mesActeurs) {
            String nomRole = roles.get(acteur);
            System.out.println("- " + acteur.getNom() + " " + acteur.getPrenom() + " (Rôle : " + nomRole + ")");
        }
    }

}
