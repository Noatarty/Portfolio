// Question 1
public class Domino {

  private int valeurGauche;
  private int valeurDroite;

  public Domino(int g, int d) {
    valeurGauche = g;
    valeurDroite = d;
  }

  public void afficher() {
    System.out.print(valeurGauche + "-" + valeurDroite);
  }

  public void inverser() {
    int temp = valeurGauche;
    valeurGauche = valeurDroite;
    valeurDroite = temp;
  }

  public int laGauche() {
    return valeurGauche;
  }

  public int laDroite() {
    return valeurDroite;
  }

}