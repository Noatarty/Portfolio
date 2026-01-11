#include <stdio.h>
#include <stdlib.h>
#include <time.h>

/*La fonction aleaInfBorne génère un nombre entier aléatoire compris entre 0 et
une borne supérieure donnée en paramètre.*/

int aleaInfBorne(int borne);

int main() {
    int borne =20000;//Borne supérieure de l'intervalle de nombres aléatoires
    int nbAleatoire = aleaInfBorne(borne);
    printf("Le nombre aleatoire genere est : %d\n", nbAleatoire);
    return EXIT_SUCCESS;
}

int aleaInfBorne(int borne){
    srand(time(NULL));
    return rand() % borne;
}