package Exo1;

public class ProgSports {
    /*
     * écrivez un main() qui crée une instance de
     * LesSports comportant MAX sports, ajoute 5 sports, dont 3 sports collectifs,
     * et les affiche.
     */
    public static void main(String[] args) {
        LesSports lesSports = new LesSports();
        for (int i = 0; i < 5; i++) {
            Sport sport = new Sport("sport " + i);
            lesSports.ajouterSport(sport);
        }
        lesSports.ajouterSport(new SportCo("football", 11));
        lesSports.ajouterSport(new SportCo("basketball", 5));
        lesSports.ajouterSport(new SportCo("tennis", 2));
        lesSports.afficherListeSports();
    }
}
