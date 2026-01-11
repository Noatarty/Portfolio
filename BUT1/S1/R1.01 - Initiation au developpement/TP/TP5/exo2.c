#include <stdio.h>
#include <stdlib.h>

void minMax(int *adr_min, int *adr_max);

int main() {
    int min, max;
    minMax(&min, &max);
    printf("Min: %d, Max: %d", min, max);
    return EXIT_SUCCESS;
}

void minMax(int *adr_min, int *adr_max){
    int n;
    scanf("%d", &n);
    *adr_max = n;
    *adr_min = n;
    while (n != 0) {
        if (n < *adr_min) {
            *adr_min = n;
        }
        if ( n > *adr_max) {
            *adr_max = n;
        }
        scanf("%d", &n);
    }
}