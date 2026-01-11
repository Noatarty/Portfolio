package Ex3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercice3 {

    public static int saisieCorrecte(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Entrez un entier > 10 : ");
                int valeur = scanner.nextInt();

                if (valeur <= 10) {
                    // Version 1
                    // throw new IllegalArgumentException("La valeur doit être supérieure à 10");
                    throw new ValeurIncorrecteException("La valeur doit être supérieure à 10");
                }

                return valeur;

            } catch (InputMismatchException e) {
                System.out.println("Erreur de saisie, veuillez saisir un entier");
                scanner.nextLine(); // pour vider le buffer
                // Version 1
                // } catch (IllegalArgumentException e) {
                // System.out.println(e.getMessage());
            } catch (ValeurIncorrecteException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Test avec une valeur correcte :");
        int valeur = saisieCorrecte(scanner);
        System.out.println("Valeur saisie : " + valeur);

        System.out.println("\nTest avec une valeur incorrecte :");
        valeur = saisieCorrecte(scanner);
        System.out.println("Valeur saisie : " + valeur);

        scanner.close();
    }

}
