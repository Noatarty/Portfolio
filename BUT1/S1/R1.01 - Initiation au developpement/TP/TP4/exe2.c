/**
 *@brief programme puissance
*/
#include <stdio.h>
#include <stdlib.h>

void menu() {
    printf("0 pour arreter\n");
    printf("1 pour l'action n°1\n");
    printf("2 pour l'action n°2\n");
}

int main() {
    int choix;
    do {
        menu();
        scanf("%d", &choix);
        switch (choix) {
            case 0:
                printf("Peace\n");
                break;
            case 1:
                printf("Action 1\n");
                break;
            case 2:
                printf("Action 2\n");
                break;
            default:
                printf("Choix errone\n");
        }
    } while (choix != 0);
    return EXIT_SUCCESS;
}
