
// Question 3
import java.util.Scanner;

public class Jeu {

    public static void main(String[] args) {
        Table table = new Table(28);
        table.initTable();
        table.affTable();

        Scanner sc = new Scanner(System.in);
        String reponse = "non";
        while (reponse.compareTo("oui") != 0) {
            if (reponse.compareTo("non") == 0) {
                // lire les valeurs pour le prochain domino
                System.out.print("Entrez la valeur gauche du domino : ");
                int g = sc.nextInt();
                System.out.print("Entrez la valeur droite du domino : ");
                int d = sc.nextInt();
                // déterminer si on peut le poser à gauche ou à droite
                int cote = table.recherche(g, d);
                if (cote == -1) {
                    table.poserAgauche(g, d);
                } else if (cote == 1) {
                    table.poserAdroite(g, d);
                } else {
                    System.out.println("Impossible de poser ce domino.");
                }
                // afficher l'état du jeu
                table.affTable();
                sc.nextLine();
                System.out.println();
                System.out.print("Voulez-vous arreter ? (oui/non) : ");
                reponse = sc.nextLine();
            }
        }
        sc.close();
    }

}
