package Ex2;

public class Exercice2 {

    static int moyenne(String[] valeurs) throws MonException {
        int somme = 0;
        int nbNotes = 0;

        for (String valeur : valeurs) {
            try {
                somme += Integer.parseInt(valeur);
                nbNotes++;
            } catch (NumberFormatException e) {
                System.out.println("L'argument " + valeur + " n'est pas un nombre entier");
            }
        }

        if (nbNotes == 0) {
            throw new MonException("Aucune note valide passée en argument");
        }

        return somme / nbNotes;
    }

    public static void main(String[] args) {
        try {
            System.out.println(moyenne(args));
        } catch (MonException e) {
            System.out.println(e);
        }
    }

}