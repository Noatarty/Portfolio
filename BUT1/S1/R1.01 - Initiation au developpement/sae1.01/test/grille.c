#include <stdio.h>
#include <stdlib.h>


// Définition de la taille de la grille (9x9 pour le Sudoku classique)
#define TAILLE 9

//types
typedef int tGrille[TAILLE][TAILLE];

//prototypes
void afficherGrille(tGrille g);

int main(){
    //initialisation de la grille
    tGrille sudoku = {0};
    //remplissage de la grille
    for(int i=0;i<TAILLE;i++){
        for(int j=0;j<TAILLE;j++)
            if((i+j)%2==1){
                sudoku[i][j]=1;
            }
        }
        //affichage de la grille
        printf("grille avant remplissage:\n");
        afficherGrille(sudoku);
        return 0;
}

void afficherGrille(tGrille g) {
    int i, j;
    // Affichage des numéros des colonnes
    printf("   ");
    for (j = 0; j < TAILLE; j++) {
        if ((j + 1 == 3) || (j + 1 == 6)) {
            printf(" %d  ", j + 1);
            j++;
        }
        printf(" %d", j + 1);
    }
    printf("\n");
    // Affichage de la ligne supérieure
    printf("  +-------+-------+-------+\n");
    // Boucle pour parcourir chaque ligne de la grille
    for (i = 0; i < TAILLE; i++) {
        // Affichage du numéro de la ligne
        printf("%d | ", i + 1);
        // Boucle pour parcourir chaque colonne de la grille
        for (j = 0; j < TAILLE; j++) {
            // Affichage de la valeur de la case ou d'un point si la case est vide
            if (g[i][j] == 0) {
                printf(". ");
            } else {
                printf("%d ", g[i][j]);
            }
            // Affichage d'une barre verticale tous les 3 chiffres
            if ((j + 1) % 3 == 0 && j < TAILLE - 1) {
                printf("| ");
            }
        }
        printf("|");
        // Passage à la ligne suivante
        printf("\n");
        // Affichage d'une ligne horizontale tous les 3 lignes
        if ((i + 1) % 3 == 0 && i < TAILLE - 1) {
            printf("  +-------+-------+-------+\n");
        }
    }
    // Affichage de la ligne inférieure
    printf("  +-------+-------+-------+\n");
}