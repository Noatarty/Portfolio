/**
 *@brief Que fait ce programme ? là est la question …
*/
#include <stdio.h>
#include <stdlib.h>
int main (){
int i, n , somme;
printf(" entrez un entier naturel : \n") ;
scanf("%d",&n) ;
i=1;
somme=0 ;
while ( i<= n ) {
somme=somme+i ;
i=i+1;
}
printf("résultat : %d\n",somme) ;
return EXIT_SUCCESS ;
}
/**
Exercice 1

1)
Pour n=0, le résultat est 0.
Pour n=1, le résultat est 1.
Pour n=2, le résultat est 3.
Pour n=5, le résultat est 15.

2) Ce programme calcule la somme des entiers naturels de 1 à n, où n est un entier naturel saisi par l'utilisateur
*/