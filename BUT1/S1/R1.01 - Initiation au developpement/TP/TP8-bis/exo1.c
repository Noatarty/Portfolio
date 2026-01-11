#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#define N 5
typedef char chaine20[21] ;
typedef chaine20 tabnoms[N] ;

void affiche(tabnoms t, int n);
void maintientTrie (tabnoms t , int i);
void triParInsertion ( tabnoms t, int n);

int main(){
    tabnoms t = {"Raphael","Thomas","Evan","Noa","Baptiste"};
    affiche(t,N);
    triParInsertion (t , N-1);
    printf("\n");
    affiche(t,N);
    return EXIT_SUCCESS;
}

void affiche(tabnoms t, int n){
    for (int i = 0; i<n;i++){
        printf("%s\n",t[i]);
    }
}
void maintientTrie (tabnoms t , int i){   
    if (i == 0) {
        return;
    } else {
        while (i > 0 && strcmp(t[i],t[i-1]) < 0){
            chaine20 temp;
            strcpy(temp,t[i]);
            strcpy(t[i],t[i-1]);
            strcpy(t[i-1],temp);
            i--;
        }
    }
}

void triParInsertion ( tabnoms t, int n) {
    //trie le tableau t rempli de n valeurs, en faisant appel à la procédure maintientTrie 
    /*Principe : on applique le raisonnement par récurrence 
        i=0 : le sous-tableau t[0..0] est trié !
        i quelconque :  le sous-tableau t[0..i-1] étant trié, on passe à t[0..i] trié en appliquant la
        procédure maintient_Trie .
        Quand i a atteint n-1, le tableau rempli jusqu’au rang n-1 est trié*/
    for (int i = 0; i < n; i++) {
        maintientTrie(t, i);
    }
}