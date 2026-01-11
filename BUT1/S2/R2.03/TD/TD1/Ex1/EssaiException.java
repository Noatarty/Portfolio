package Ex1;

import java.util.Scanner;

public class EssaiException {
    public static void main(String[] args) {
        int a, b, res;
        Scanner clavier = new Scanner(System.in);
        a = clavier.nextInt();
        b = clavier.nextInt();

        try {
            res = a / b;
            System.out.println("le resultat de " + a + " divise par " + b + " est " + res);
        } catch (ArithmeticException e) {
            System.out.println("Alerte, c'est une division par zero !!");
        } finally {
            System.out.println("Fin du programme");
        }

        clavier.close();
    }
}
