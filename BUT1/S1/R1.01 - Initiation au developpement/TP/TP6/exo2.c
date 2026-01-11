#include <stdlib.h>
#include <stdio.h>

int factorielle(int n);
void test();

int main() {
    int n;

    test();
    printf("Saisissez un entier : ");
    scanf("%d", &n);

    if (n < 0)
        printf("Le nombre entier naturel doit être supérieur ou égal à 0.\n");
    else
        printf("Factorielle de %d = %i\n", n, factorielle(n));

    return 0;
}

int factorielle(int n) {
    if (n == 0)
        return 1;
    else
        return n * factorielle(n - 1);
}

void test(){
    printf("valeur attendue : %d     valeur obtenue : %d\n",1,factorielle(0));
    printf("valeur attendue : %d     valeur obtenue : %d\n",1,factorielle(1));
    printf("valeur attendue : %d     valeur obtenue : %d\n",2,factorielle(2));
    printf("valeur attendue : %d     valeur obtenue : %d\n",6,factorielle(3));
    printf("valeur attendue : %d     valeur obtenue : %d\n",5040,factorielle(7));
}