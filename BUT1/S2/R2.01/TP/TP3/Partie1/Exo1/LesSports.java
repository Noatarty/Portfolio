package Exo1;

import java.util.ArrayList;

public class LesSports {
    private ArrayList<Sport> listeSports;

    public void ajouterSport(Sport sport) {
        listeSports.add(sport);
    }

    public void afficherListeSports() {
        for (Sport sport : listeSports) {
            sport.affiche();
        }
    }
}
