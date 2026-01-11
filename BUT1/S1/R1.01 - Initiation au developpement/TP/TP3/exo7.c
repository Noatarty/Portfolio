/**
 *@brief programme qui affiche trois choix, lit le choix de l'utilisateur et effectue l'action correspondante jusqu'à ce que l'utilisateur tape 0 pour quitter
*/
#include <stdio.h>
#include <stdlib.h>

int main() {
    int choix;

    do {
        printf("Choix disponibles :\n");
        printf("(1) Faire action 1\n");
        printf("(2) Faire action 2\n");
        printf("(0) Quitter\n");

        printf("Entrez votre choix : ");
        scanf("%d", &choix);

        switch (choix) {
            case 1:
                printf("Action 1\n");
                break;
            case 2:
                printf("Action 2\n");
                break;
            case 0:
                printf("Au revoir\n");
                break;
            default:
                printf("Erreur : vous devez saisir 1, 2, ou 0\n");
                break;
        }
    } while (choix != 0);

    return EXIT_SUCCESS;
}