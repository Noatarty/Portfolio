#include <stdio.h>
#include <stdlib.h>

#define N 10
typedef int tabEntiers[N+1];

int recherche_sequentielle (int valeur,  tabEntiers tablo );

int main() {
    tabEntiers  leTablo = {23, 54, 65, 12, 43, 78, 68, 93, 18, 31} ;
    int i;
    for(i=0; i<N; i++){
        printf("%d ",leTablo[i]);
    } 
    printf("\n");
    int valRecherchee = 18;
    if (recherche_sequentielle(valRecherchee, leTablo)==-1){
        printf("La valeur %d n'est pas dans le tableau.\n",valRecherchee);
        }
        else{
            printf("La valeur %d est a l'indice %d du tableau.\n",valRecherchee,recherche_sequentielle(valRecherchee, leTablo));
        }
        return EXIT_SUCCESS;

}

int recherche_sequentielle (int valeur,  tabEntiers tablo ) {
    // recherche   de   manière  séquentielle  si    valeur    est   présent   dans   le   tableau  tablo ;   
    // si   oui,   la fonction délivre l’indice auquel se trouve   valeur   dans  tablo, et délivre -1 sinon
    // N.B.  Quand on commence la recherche, on ne sait pas combien de fois on va effectuer une comparaison, 
    // donc il n’est pas question d’utiliser une boucle for. utilisez une boucle while ou do while à deux conditions
    //       donc il est préférable d'initialiser le résultat à -1 pour éviter tout risque de confusion.
    int indice =-1;
    int i = 0;
    while ((tablo[i] != valeur) && (i <= N)){
        i++;
    }
    if (tablo[i] == valeur ){
        indice = i;
    }
    return indice;
            
}