// Question 2
public class Table {
    private Domino[] dominos;
    private int nbDominos;

    public Table(int n) {
        dominos = new Domino[n];
        nbDominos = 0;
    }

    public void initTable() {
        dominos[0] = new Domino(0, 0);
        nbDominos = 1;
    }

    public void affTable() {
        for (int i = nbDominos - 1; i >= 0; i--) {
            dominos[i].afficher();
            System.out.print(" ");
        }
    }

    public int recherche(int g, int d) {
        if (nbDominos > 0 && dominos[0].laDroite() == g) {
            return -1;
        }
        if (nbDominos < dominos.length && dominos[nbDominos - 1].laGauche() == d) {
            return 1;
        }
        return 0;
    }

    public void poserAgauche(int g, int d) {
        if (recherche(g, d) == -1) {
            Domino domino = new Domino(g, d);
            decalerTableau(0);
            dominos[0] = domino;
            nbDominos++;
        }
    }

    public void poserAdroite(int g, int d) {
        if (recherche(g, d) == 1) {
            Domino domino = new Domino(g, d);
            dominos[nbDominos + 1] = domino;
            nbDominos++;
        }
    }

    private void decalerTableau(int debut) {
        for (int i = nbDominos - 1; i >= debut; i--) {
            dominos[i + 1] = dominos[i];
        }
    }
}
