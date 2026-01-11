#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define INDICE1 10
#define INDICE2 20
//types
typedef int tab2dim[INDICE1][INDICE2];

// initialisation du tableau
void initialiser(tab2dim *tab) {
    for(int i=0; i<INDICE1; i++) {
        for(int j=0; j<INDICE2; j++) {
            (*tab)[i][j] = i + j;
        }
    }
}

// affichage du tableau
void afficher(tab2dim *tab) {
    for(int i=0; i<INDICE1; i++) {
        for(int j=0; j<INDICE2; j++) {
            printf("%3d ", (*tab)[i][j]);
        }
        printf("\n");
    }
}

// recherche d'une valeur dans le tableau
bool existe(tab2dim *tab, int valeur) {
    for(int i=0; i<INDICE1; i++) {
        for(int j=0; j<INDICE2; j++) {
            if((*tab)[i][j] == valeur) {
                return true;
            }
        }
    }
    return false;
}

int main() {
    tab2dim leTablo;
    initialiser(&leTablo);
    afficher(&leTablo);

    int valeur = 29;
    if(existe(&leTablo, valeur) == true) {
        printf("La valeur %d existe dans le tableau.\n", valeur);
    } else {
        printf("La valeur %d n'existe pas dans le tableau.\n", valeur);
    }

    return EXIT_SUCCESS;
}