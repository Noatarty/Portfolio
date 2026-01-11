#include <stdio.h>
#include <stdlib.h>

/*
Elément a implémenter pour afficherGrille
les barres d'adresses
Les + dans les coins
la barre latérale a droite
régler les problèmes d'espaces
les différentes vérification du copntenu de la grille
*/
// Définition de la taille de la grille (9x9 pour le Sudoku classique)
#define TAILLE 9

//prototypes
void afficherGrille(int grille[TAILLE][TAILLE]);

int main() {
    /*programme sudoku c’est
        type tGrille = tableau[1..TAILLE, 1..TAILLE] de entier1;
        var grille1 : tGrille;
        numLigne, numColonne, valeur : entier;
    début
        chargerGrille(grille1);
        tant que la grille n’est pas pleine2 faire
            afficherGrille(grille1);
             ecrireEcran("Indices de la case ? ");
            saisir(numLigne);
            saisir(numColonne);
            si (grille1[numLigne][numColonne]!=0)alors
                ecrireEcran("IMPOSSIBLE, la case n'est pas libre.");
            sinon
                ecrireEcran("Valeur à insérer ? ");
                saisir(valeur);
                si (possible(grille1, numLigne, numColonne, valeur)) alors
                    grille1[numLigne][numColonne] = valeur;
                finsi
            finsi
        finfaire
        ecrireEcran("Grille pleine, fin de partie");
    fin*/
    // Exemple d'utilisation avec une grille de test
    int grilleTest[TAILLE][TAILLE] = {
        {5, 3, 0, 0, 7, 0, 0, 0, 0},
        {6, 0, 0, 1, 9, 5, 0, 0, 0},
        {0, 9, 8, 0, 0, 0, 0, 6, 0},
        {8, 0, 0, 0, 6, 0, 0, 0, 3},
        {4, 0, 0, 8, 0, 3, 0, 0, 1},
        {7, 0, 0, 0, 2, 0,    0, 6},
        {0, 6, 0, 0, 0, 0, 2, 8, 0},
        {0, 0, 0, 4, 1, 9, 0, 0, 5},
        {0, 0, 0, 0, 8, 0, 0, 7, 9}
    };

    // Appel de la procédure pour afficher la grille de test
    afficherGrille(grilleTest);

    return EXIT_SUCCESS;
}

// Procédure pour afficher la grille
void afficherGrille(int grille[TAILLE][TAILLE]) {
    int i, j;

    // Affichage de la ligne supérieure
    printf("+-------+-------+-------+\n");

    // Boucle pour parcourir chaque ligne de la grille
    for (i = 0; i < TAILLE; i++) {
        // Affichage du numéro de la ligne
        printf("| %d ", i + 1);

        // Boucle pour parcourir chaque colonne de la grille
        for (j = 0; j < TAILLE; j++) {
            // Affichage de la valeur de la case ou d'un point si la case est vide
            if (grille[i][j] == 0) {
                printf(". ");
            } else {
                printf("%d ", grille[i][j]);
            }

            // Affichage d'une barre verticale tous les 3 chiffres
            if ((j + 1) % 3 == 0 && j < TAILLE - 1) {
                printf("| ");
            }
        }

        // Passage à la ligne suivante
        printf("\n");

        // Affichage d'une ligne horizontale tous les 3 lignes
        if ((i + 1) % 3 == 0 && i < TAILLE - 1) {
            printf("+-------+-------+-------+\n");
        }
    }

    // Affichage de la ligne inférieure
    printf("+-------+-------+-------+\n");
}