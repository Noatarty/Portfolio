#include <stdio.h>
#include <stdlib.h>

//Exercice 1

#define N 5
typedef int unTableau[N];

int somme(unTableau tablo);

int main() {
    unTableau monTableau = {5,8,2,3,4}; 
    int resultat = somme(monTableau);
    printf("Somme attendue: %d\n", 5+8+2+3+4);
    printf("Somme obtenue: %d\n", resultat);
    return 0;
}

int somme(unTableau tablo) {
    int i, somme = 0;
    for(i = 0; i < N; i++) {
        somme += tablo[i];
    }
    return somme;
}