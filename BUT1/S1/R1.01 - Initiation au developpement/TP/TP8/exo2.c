#include <stdio.h>
#include <stdlib.h>

#define N 10
typedef int tabEntiers[N] ; 

int recherche_dicho_iteratif(int valeur,  tabEntiers tablo);
int recherche_dicho_recursif(int valeur, tabEntiers tablo, int debut, int fin);

int main() {
    tabEntiers  leTabloTrie = {13, 24, 35, 42, 53, 68, 77, 83, 88, 91} ;
    int valeur = 83;
    int debut = 0;
    int fin = N-1;
    int resultat = recherche_dicho_iteratif(valeur, leTabloTrie);
    printf("La valeur %d est a l'indice %d\n",valeur, resultat);
    int resultat2 = recherche_dicho_recursif(valeur, leTabloTrie,debut,fin);
    printf("La valeur %d est a l'indice %d\n",valeur, resultat2);
    return EXIT_SUCCESS;
}

int recherche_dicho_iteratif(int valeur,  tabEntiers tablo) {
    int debut = 0;
    int fin = N-1;
    while (debut <= fin) {
        int milieu = (debut + fin) / 2;
        if (tablo[milieu] == valeur) {
            return milieu;
        }
        if (tablo[milieu] < valeur){
            debut = milieu + 1 ;
        } 
        else { fin = milieu - 1;
        }
    }
    return -1;
}
int recherche_dicho_recursif(int valeur, tabEntiers tablo, int debut, int fin) {
    if (debut > fin) {
        return -1;
    }
    int milieu = (debut + fin) / 2;
    if (tablo[milieu] == valeur) {
        return milieu;
    }
    if (tablo[milieu] < valeur){
        return recherche_dicho_recursif(valeur, tablo,milieu+1 ,fin );
    }
    else{
        return recherche_dicho_recursif(valeur, tablo, debut, milieu-1);
    }
    return -1;
}