#include <stdio.h>
#include <stdlib.h>

int main() {
    int x = 10;
    int y = 30;
    int *ptr1;
    int *ptr2;

    // Faire pointer le pointeur ptr1 sur la variable x
    ptr1 = &x;

    // Affecter à la variable y le contenu de x référencée par le pointeur ptr1
    y = (*ptr1);

    // Affecter à la variable x référencée par ptr1 la valeur 50
    (*ptr1) = 50;

    // Affecter à ptr2 la valeur de ptr1
    ptr2 = ptr1;
};