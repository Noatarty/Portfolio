public class Maximier {
    private int valeur;
    private Maximier gauche;
    private Maximier droite;
    private boolean estVide;
    
    // Constructeur pour créer un maximier vide
    public Maximier() {
        this.estVide = true;
        this.gauche = null;
        this.droite = null;
    }
    
    // Constructeur avec valeur
    private Maximier(int valeur) {
        this.valeur = valeur;
        this.estVide = false;
        this.gauche = new Maximier();
        this.droite = new Maximier();
    }
    
    // Retourne le poids (nombre de noeuds)
    public int poids() {
        if (estVide) return 0;
        return 1 + gauche.poids() + droite.poids();
    }
    
    // Vérifie si l'arbre est vide
    public boolean estVide() {
        return estVide;
    }
    
    // Insertion d'un élément
    public void inserer(int x) {
        if (estVide) {
            this.valeur = x;
            this.estVide = false;
            this.gauche = new Maximier();
            this.droite = new Maximier();
        } else {
            if (x > this.valeur) {
                int temp = this.valeur;
                this.valeur = x;
                insererDansMin(temp);
            } else {
                insererDansMin(x);
            }
        }
    }
    
    // Aide pour l'insertion dans le sous-arbre de poids minimal
    private void insererDansMin(int x) {
        if (gauche.poids() <= droite.poids()) {
            gauche.inserer(x);
        } else {
            droite.inserer(x);
        }
    }
    
    // Affichage infixé
    public void afficherInfixe() {
        if (!estVide) {
            gauche.afficherInfixe();
            System.out.print(valeur + " ");
            droite.afficherInfixe();
        }
    }
    
    // Test de présence d'un élément
    public boolean contient(int x) {
        if (estVide) return false;
        return valeur == x || gauche.contient(x) || droite.contient(x);
    }
    
    // Obtenir le plus grand élément
    public int maximum() {
        if (estVide) return -1;
        return valeur;
    }
    
    // Suppression de la racine
    public void supprimerRacine() {
        if (!estVide) {
            if (gauche.estVide() && droite.estVide()) {
                estVide = true;
            } else {
                if (gauche.maximum() > droite.maximum()) {
                    this.valeur = gauche.maximum();
                    gauche.supprimerRacine();
                } else {
                    this.valeur = droite.maximum();
                    droite.supprimerRacine();
                }
            }
        }
    }
}


//tests
class TestMaximier {
    public static void main(String[] args) {
        Maximier arbre = new Maximier();
        arbre.inserer(5);
        arbre.inserer(3);
        arbre.inserer(7);
        arbre.inserer(2);
        arbre.inserer(4);
        arbre.inserer(6);
        arbre.inserer(8);
        System.out.println("Poids de l'arbre : " + arbre.poids());
        System.out.println("Contient 4 : " + arbre.contient(4));
        System.out.println("Contient 9 : " + arbre.contient(9));
        System.out.println("Plus grand élément : " + arbre.maximum());
        arbre.supprimerRacine();
        System.out.println("Après suppression de la racine : ");
        arbre.afficherInfixe();
    }
}