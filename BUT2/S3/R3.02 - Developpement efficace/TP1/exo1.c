#include <stdio.h>
#include <stdlib.h>

int main() {
    // Question 1
    int x = 100;
    int *pt = &x;

    *pt += 10;

    printf("Question 1:\n");
    printf("Valeur pointée: %d\n", *pt);
    printf("Valeur de x: %d\n", x);
    printf("Conclusion: La modification via le pointeur affecte directement la variable x.\n\n");

    // Question 2
    int *pt_dyn = (int *)malloc(sizeof(int));
    if (pt_dyn == NULL) {
        fprintf(stderr, "Erreur d'allocation mémoire\n");
        return 1;
    }

    *pt_dyn = 100;

    printf("Question 2:\n");
    printf("Valeur pointée (allocation dynamique): %d\n", *pt_dyn);

    free(pt_dyn);

    return 0;
}