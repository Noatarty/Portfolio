package SAE.PART1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Seance {
    private Date date;
    private String type;
    private Film film = null;

    public Seance(Date date, String type) {
        this.date = date;
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void affecterFilm(Film f) {
        this.film = f;
    }

    public void enleverFilm() {
        this.film = null;
    }

    public void ajouterProgrammer(Film f) {
        if (f == null) {
            System.out.println("Erreur : le film n'est pas défini");
        } else {
            affecterFilm(f);
            f.ajouterSeance(this);
        }
    }

    public void enleverProgrammer(Film f) {
        if (film.equals(f)) {
            System.out.println("Erreur : le film n'est pas défini");
        } else {
            enleverFilm();
            f.enleverSeance(this);
        }
    }

    public Film getFilm() {
        return this.film;
    }

    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    public String toString() {
        return formatter.format(this.date) + " " + this.type + " " + this.film.getTitre();
    }

    public void afficher() {
        System.out.println(this.toString());
    }

    public boolean equals(Seance s) {
        if (s == null) {
            return false;
        }
        if (this.date.compareTo(s.getDate()) == 0 && this.type.compareTo(s.getType()) == 0) {
            return true;
        }
        return false;
    }
}
