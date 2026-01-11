#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int generer(int max);
int comparer(int num1, int num2);
int jeu(int max);
void afficherResultat(int compter);

int main() {
    int max = 100;
    int compter = jeu(max);
    afficherResultat(compter);
    return 0;
}

// Generer un nombre secret
int generer(int max) {
    srand(time(NULL));
    return rand() % max;
}

// Comparer deux nombres
int comparer(int num1, int num2) {
    if (num1 == num2) {
        return 0;
    } else if (num1 > num2) {
        return 1;
    } else {
        return -1;
    }
}

// Jeu de devinette
int jeu(int max) {
    int secret = generer(max);
    int num;
    int compter = 0;
    int res;
    do {
        printf("Devinez le nombre secret (entre 0 et %d) : ", max - 1);
        scanf("%d", &num);
        compter++;
        
        res = comparer(num, secret);
        if (res == 1) {
            printf("Le nombre est superieur au nombre secret.\n");
        } else if (res == -1) {
            printf("Le nombre est inferieur au nombre secret.\n");
        }
    } while (res != 0);

    return compter;
}

// Afficher le resultat
void afficherResultat(int compter) {
    if (compter > 10) {
        printf("Perdu.\n");
    } else {
        printf("Gagne en %d coups.\n", compter);
    }
}