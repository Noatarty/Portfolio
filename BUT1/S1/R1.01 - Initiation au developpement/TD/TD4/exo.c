#include <stdio.h>

int main() {
    //Declaration des variables
    int nbLig, nbCol, l, c;

    //Initialisation des variables
    l = 0;
    c = 0;

    //Saisie des donnees
    do {
        printf("Entrez le nombre de lignes : ");
        scanf("%d", &nbLig);
    } while (nbLig < 0);

    do {
        printf("Entrez le nombre de colonnes : ");
        scanf("%d", &nbCol);
    } while (nbCol < 0);
    //Traitement
    while (l <= nbLig) {
        while  (c <= nbCol) {
            printf("*");
            l=l+1;
        }
        printf("\n");
        c=c+1;

    }

    return 0;
}