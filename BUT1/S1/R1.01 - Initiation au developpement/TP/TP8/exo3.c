#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define N 8 
typedef char mot8lettres[N] ;

void init(mot8lettres mot);
void saisir(mot8lettres mot);
void afficher(mot8lettres mot);
bool contient(mot8lettres mot,char c);

int main(){
    mot8lettres mot;
    init(mot);
    saisir(mot);
    printf("Le mot saisi est : ");
    afficher(mot);
    if (contient(mot,'x')){
        printf("\nLe mot contient la lettre x");
    }else{
        printf("\nLe mot ne contient pas la lettre x");
    }
}

void init(mot8lettres mot) {
    int i;
    for (i = 0; i < N; i++) {
        mot[i] = '*';
    }
}

void saisir(mot8lettres mot){
    printf("Saisissez un mot de %d lettres : ", N);
    scanf("%s", mot);
}

void afficher(mot8lettres mot) {
    int i;
    for (i = 0; i < N; i++) {
        printf(" %c", mot[i]);
    }
}

bool contient(mot8lettres mot,char c){
    int i;
    for (i = 0; i < N; i++) {
        if (mot[i] == c) {
            return true;
        }
    }
    return false;
}