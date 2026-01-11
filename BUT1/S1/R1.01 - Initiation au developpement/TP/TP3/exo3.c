/**
 *@brief programme qui lit au clavier le nombre de valeurs d'une suite de valeurs entières, puis les valeurs de la suite, et affiche leur moyenne
*/
#include <stdio.h>
#include <stdlib.h>

int main() {
    int n, i, valeur;
    double somme = 0.0;

    printf("Entrez le nombre de valeurs : ");
    scanf("%d", &n);

    if (n <= 0) {
        printf("Nombre de valeurs invalide.\n");
        return EXIT_FAILURE;
    }

    for (i = 0; i < n; i++) {
        printf("Entrez la valeur %d : ", i + 1);
        scanf("%d", &valeur);
        somme += valeur;
    }

    if (n > 0) {
        double moyenne = somme / n;
        printf("Moyenne des valeurs : %.2lf\n", moyenne);
    } else {
        printf("La suite est vide, impossible de calculer la moyenne.\n");
    }

    return EXIT_SUCCESS;
}