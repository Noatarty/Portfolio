#include <stdio.h>
#include <stdlib.h>

void ligneTirets(int n);
void ligneCourante(int nl);
void corps(int n);

int main() {
    int h;
    printf("Entrez la hauteur du triangle : ");
    scanf("%d", &h);
    corps(h);
    ligneTirets(h + 1);
    return 0;
}

void ligneTirets(int n) {
    while (n > 0) {
        printf("-");
        n--;
    }
    printf("\n");
}

void ligneCourante(int nl) {
    printf("I");
    while (nl > 1) {
        printf(" ");
        nl--;
    }
    printf("\\\n");
}

void corps(int n) {
    int nl = 1;
    while (nl <= n) {
        ligneCourante(nl);
        nl++;
    }
}