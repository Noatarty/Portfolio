
/*Exercice 2 : Simulation de la gestion d’un stock
Dans cet exercice, on souhaite gerer un stock de produits frais*/
import java.util.Scanner;

// Q1 : classe de test
class TestStock {
    public static void main(String[] args) {
        // test Produit
        Produit p1 = new Produit(1);
        System.out.println(p1);
        // test Stock
        Stock s1 = new Stock();
        s1.ajouterProduit(p1);
        s1.ajouterProduit(p1);
        s1.ajouterProduit(p1);
        System.out.println(s1);
    }
}

// Q2 : creation de la classe produit
class Produit {
    private String reference;
    private int dateEntree;

    public Produit(int dateJour) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez la reference du produit : ");
        reference = sc.nextLine();
        dateEntree = dateJour;
        sc.close();
    }

    public String getReference() {
        return reference;
    }

    public int getDateEntree() {
        return dateEntree;
    }

    public String toString() {
        return "Reference : " + reference + "\nDate d'entree : " + dateEntree;
    }
}

// Q3 : creation de la classe Pile
class Pile {
    private Produit[] stock;
    private int indice;

    public Pile(int max) {
        stock = new Produit[max];
        indice = 0;
    }

    public boolean pileVide() {
        if (indice == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean pilePleine() {
        if (indice == stock.length) {
            return true;
        } else {
            return false;
        }
    }

    public void empiler(Produit p) {
        stock[indice] = p;
        indice++;
    }

    public void depiler() {
        indice--;
        stock[indice] = null;
    }

    public Produit sommet() {
        return stock[indice - 1];
    }

    public void afficherStock() {
        for (int i = 0; i < indice; i++) {
            System.out.println(stock[i]);
        }
    }
}

// Q4 : creation de la classe Stock
class Stock {
    private Pile stock;
    private int dateJour;

    public Stock(int taille) {
        stock = new Pile(taille);
        dateJour = 1;
    }

    public void entrer(Produit p) {
        stock.empiler(p);
        dateJour++;
    }

    public void sortir(int dateJ) {
        while (!stock.pileVide()) {
            Produit p = stock.sommet();
            if (p.getDateEntree() + 5 < dateJ) {
                stock.depiler();
            } else {
                break;
            }
        }
    }

    // Q5: menu
    public void afficheMenu() {
        Scanner sc = new Scanner(System.in);
        String choix = "";
        while (!choix.equals("q")) {
            System.out.println("Menu :");
            System.out.println("e : entree d'un produit dans le stock");
            System.out.println("s : sortie d'un produit du stock");
            System.out.println("i : incrementer la date du jour");
            System.out.println("q : quitter");
            choix = sc.nextLine();
            if (choix.equals("e")) {
                Produit p = new Produit(dateJour);
                entrer(p);
            } else if (choix.equals("s")) {
                sortir(dateJour);
            } else if (choix.equals("i")) {
                dateJour++;
            }
        }
        sc.close();
    }
}