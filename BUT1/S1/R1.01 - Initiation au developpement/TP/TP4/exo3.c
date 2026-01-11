/**
 *@brief programme puissance
*/
#include <stdio.h>
#include <stdlib.h>

void min(int a, int b) {
  if (a < b) {
    printf("%d", a);
  } else {
    printf("%d", b);
  }
}

int main() {
  int a, b;
  printf("Donner deux nombres séparé par un espace");
  scanf("%d %d", &a, &b);
  min(a, b);
  return 0;
}