/**
 *@brief programme qui lit au clavier une suite de valeurs entières terminée par -1 (marqueur de fin) et qui affiche la moyenne de ces valeurs
*/
#include <stdio.h>
#include <stdlib.h>

int main() {
    int valeur, somme = 0, count = 0;

    printf("Entrez une suite de valeurs entières, terminez avec -1 :\n");

    while (1) {
        scanf("%d", &valeur);

        if (valeur == -1) {
            break; // Sort de la boucle lorsque -1 est saisi
        }

        somme += valeur;
        count++;
    }

    if (count > 0) {
        double moyenne = (double)somme / count;
        printf("Moyenne des valeurs : %.2lf\n", moyenne);
    } else {
        printf("La suite est vide, impossible de calculer la moyenne.\n");
    }

    return EXIT_SUCCESS;
}