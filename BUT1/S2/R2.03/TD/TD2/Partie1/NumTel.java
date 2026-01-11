package Partie1;

public class NumTel {

    private String valeur;

    public NumTel(String valeur) throws NumeroIncorrectException {
        if (valeur == null || valeur.length() != 10 || !valeur.matches("[0-9]+")) {
            throw new NumeroIncorrectException("Le numéro doit contenir 10 chiffres");
        }
        this.valeur = valeur;
    }

    public String getNumero() {
        return valeur;
    }

    public String toString() {
        return valeur;
    }

}

class NumeroIncorrectException extends Exception {
    public NumeroIncorrectException(String message) {
        super(message);
    }
}
