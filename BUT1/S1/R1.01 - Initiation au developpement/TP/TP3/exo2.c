/**
 *@brief programme qui calcule et affiche la factorielle d'un entier positif ou nul entré au clavier
*/
#include <stdio.h>
#include <stdlib.h>

int main() {
    int n, i;
    unsigned long long fact = 1; // Utilisation d'un long long pour stocker de grandes factorielles

    printf("Entrez un entier positif ou nul : ");
    scanf("%d", &n);

    for (i = 1; i <= n; i++) {
        fact *= i;
    }

    printf("%d! = %llu\n", n, fact);

    return EXIT_SUCCESS;
}