import java.util.Scanner;
public class Ex4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String choix;
        do {
            System.out.println("C : calcul d'un cosinus");
            System.out.println("S : calcul d'un sinus");
            System.out.println("T : calcul d'une tangente");
            System.out.println("Q : quitter le programme");
            choix = scan.nextLine();
            switch (choix) {
                case "C":
                    System.out.println("Entrez un angle en radians : ");
                    double angle = scan.nextDouble();
                    scan.nextLine();
                    System.out.println("Cosinus de " + angle + " est " + Math.cos(angle));
                    break;
                case "S":
                    System.out.println("Entrez un angle en radians : ");
                    angle = scan.nextDouble();
                    scan.nextLine();
                    System.out.println("Sinus de " + angle + " est " + Math.sin(angle));
                    break;
                case "T":
                    System.out.println("Entrez un angle en radians : ");
                    angle = scan.nextDouble();
                    scan.nextLine();
                    System.out.println("Tangente de " + angle + " est " + Math.tan(angle));
                    break;
                case "Q":
                    System.out.println("Au revoir!");
                    break;
                default:
                    System.out.println("Choix invalide!");
                    break;
            }
        } while (!choix.equals("Q"));
        scan.close();
    }
}
