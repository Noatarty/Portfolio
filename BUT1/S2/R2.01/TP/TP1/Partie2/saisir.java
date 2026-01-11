import java.util.Scanner;

public class saisir {

    static public int entier() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisissez un entier :");
        String ligne = scanner.nextLine();
        return Integer.parseInt(ligne);
    }

    static public double reel() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisissez un nombre réel :");
        String ligne = scanner.nextLine();
        return Double.valueOf(ligne).doubleValue();
    }

    static public float reelf() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisissez un float :");
        String ligne = scanner.nextLine();
        return Float.valueOf(ligne).floatValue();
    }

    static public String chaine() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisissez une chaîne de caractères :");
        return scanner.nextLine();
    }

    static public char car() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisissez un caractère :");
        String ligne = scanner.nextLine();
        return ligne.charAt(0);
    }
}