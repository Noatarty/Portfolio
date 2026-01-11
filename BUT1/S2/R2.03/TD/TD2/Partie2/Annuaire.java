package Partie2;

import Partie1.Abonne;
import Partie1.NumTel;
import java.util.HashMap;

public class Annuaire {

    private String nom;
    private HashMap<String, Abonne> annuaireInverse;

    public Annuaire(String nom) {
        this.nom = nom;
        this.annuaireInverse = new HashMap<>();
    }

    public void inscrire(Abonne abonne) {
        for (NumTel numTel : abonne.getNumeros()) {
            annuaireInverse.put(numTel.getNumero(), abonne);
        }
    }

    public Abonne qui(String numero) {
        return annuaireInverse.get(numero);
    }

    public void desinscrire(Abonne abonne) {
        for (NumTel numTel : abonne.getNumeros()) {
            annuaireInverse.remove(numTel.getNumero());
        }
    }

    public void afficher() {
        System.out.println("Annuaire : " + nom);
        for (String numero : annuaireInverse.keySet()) {
            Abonne abonne = annuaireInverse.get(numero);
            System.out.println(numero + " -> " + abonne);
        }
    }

}
