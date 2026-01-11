/**
 *@brief programme qui lit au clavier le nombre de valeurs d'une suite de valeurs entières, puis les valeurs de la suite, et qui affiche la plus grande de ces valeurs
*/
#include <stdio.h>
#include <stdlib.h>

int main() {
    int n, i, valeur, plusGrande = 0;

    printf("Entrez le nombre de valeurs : ");
    scanf("%d", &n);

    if (n <= 0) {
        printf("Nombre de valeurs invalide.\n");
        return EXIT_FAILURE;
    }

    for (i = 0; i < n; i++) {
        printf("Entrez la valeur %d : ", i + 1);
        scanf("%d", &valeur);

        if (i == 0 || valeur > plusGrande) {
            plusGrande = valeur;
        }
    }

    printf("La plus grande valeur est : %d\n", plusGrande);

    return EXIT_SUCCESS;
}