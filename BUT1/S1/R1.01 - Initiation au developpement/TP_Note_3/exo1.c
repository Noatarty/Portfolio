#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>
#include <time.h>

#define MAX 9
typedef int tMatrice[MAX][MAX];
tMatrice laMatrice;

void init(tMatrice laMatrice){
    //initialise chaque element de laMatrice avec une valeur aléatoire entre 0 et 9
    for(int i=0; i<MAX; i++){
        for(int j=0; j<MAX; j++){
            laMatrice[i][j] = rand()%10;
        }
    }
}

bool ligneSymetrique(tMatrice laMatrice, int ligne){
    //retourne true si dans laMatrice ,la ligne en paramètre est symetrique par rapport au milieu de la ligne
    int milieu = MAX/2;
    for(int i=0; i<MAX; i++){
        if(laMatrice[ligne][i]!= laMatrice[milieu][i]){
            return false;
        }
    }
    return true;
}

int main(){
    tMatrice laMatrice;
    //initialise laMatrice avec des valeurs aléatoires
    init(laMatrice);
    //affiche laMatrice
    for(int i=0; i<MAX; i++){
        for(int j=0; j<MAX; j++){
            printf("%d ", laMatrice[i][j]);
        }
        printf("\n");
    }
    //recherche les lignes symetriques
    for(int i=0; i<MAX; i++){
        if(ligneSymetrique(laMatrice, i)){
            printf("La ligne %d est symetrique par rapport au milieu de la ligne\n", i+1);
        }
    }
    return EXIT_SUCCESS;
}