/**
 *@brief programme qui vérifie si un entier naturel saisi au clavier a d'autres diviseurs que 1 et lui-même, indiquant ainsi s'il s'agit d'un nombre premier ou non
*/
#include <stdio.h>
#include <stdlib.h>

int main() {
    int nombre, i;
    int estPremier = 1; // Supposons que le nombre est premier par défaut

    printf("Entrez un entier naturel : ");
    scanf("%d", &nombre);

    if (nombre <= 1) {
        printf("Ce nombre n'est pas premier.\n");
    } else {
        for (i = 2; i <= nombre / 2; i++) {
            if (nombre % i == 0) {
                estPremier = 0; // Le nombre n'est pas premier s'il a un diviseur autre que 1 et lui-même
                break;
            }
        }

        if (estPremier) {
            printf("%d est un nombre premier.\n", nombre);
        } else {
            printf("%d n'est pas un nombre premier.\n", nombre);
        }
    }

    return EXIT_SUCCESS;
}