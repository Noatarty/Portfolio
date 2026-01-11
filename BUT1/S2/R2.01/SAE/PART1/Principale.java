package SAE.PART1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Principale {
    public static void main(String[] args) {
        Film bis = new Film("BIS", 102, "Français",
                "Éric et Patrice sont amis depuis le lycée. Au fil des années, chacun a pris un chemin très différent : d'un côté Éric, hédoniste sans attaches aux multiples conquêtes, et de l'autre Patrice, père de famille «monogame» à la vie bien rangée.");
        Acteur franckDubosc = new Acteur("Franck", "Dubosc");
        bis.ajouterRole(franckDubosc, "Éric");
        Acteur kadMerad = new Acteur("Kad", "Merad");
        bis.ajouterRole(kadMerad, "Patrice");
        Acteur alexandraLamy = new Acteur("Alexandra", "Lamy");
        bis.ajouterRole(alexandraLamy, "Ariane");

        Film papaOuMaman = new Film("PAPA OU MAMAN", 104, "Français",
                "Florence et Vincent Leroy ont tout réussi. Leurs métiers, leur mariage, leurs enfants. Et aujourd'hui, c'est leur divorce qu'ils veulent réussir.");
        papaOuMaman.ajouterActeur(new Acteur("Marina", "Foïs"));
        papaOuMaman.ajouterActeur(new Acteur("Laurent", "Lafitte"));

        ArrayList<Seance> seances = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.FRENCH);
        try {
            Date date = formatter.parse("18/03/2017");
            seances.add(new Seance(date, "matinée"));
            seances.add(new Seance(date, "début après-midi"));
            seances.add(new Seance(date, "fin après-midi"));
            seances.add(new Seance(date, "soirée"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        seances.get(0).affecterFilm(bis);
        seances.get(3).affecterFilm(bis);

        seances.get(1).affecterFilm(papaOuMaman);

        System.out.println("Programme du 18 mars 2017 :");
        for (Seance seance : seances) {
            seance.afficher();
        }
    }
}
