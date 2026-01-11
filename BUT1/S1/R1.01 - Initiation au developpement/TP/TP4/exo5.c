#include <stdio.h>
#include <stdlib.h>

void ligneTirets(int n);
void ligneCourante(int n);
void corps(int n, int larg);

int main() {
  int hauteur, largeur;
  printf("Entrez la hauteur du rectangle : ");
  scanf("%d", &hauteur);
  printf("Entrez la largeur du rectangle : ");
  scanf("%d", &largeur);

  ligneTirets(largeur);
  corps(hauteur, largeur);
  ligneTirets(largeur);

  return EXIT_SUCCESS;
}

void ligneTirets(int n) {
  for (int i = 0; i < n; i++) {
    printf("-");
  }
  printf("\n");
}

void ligneCourante(int n) {
  printf("I");
  for (int i = 0; i < n - 2; i++) {
    printf(" ");
  }
  printf("I\n");
}

void corps(int n, int larg) {
  for (int i = 0; i < n; i++) {
    ligneCourante(larg);
  }
}