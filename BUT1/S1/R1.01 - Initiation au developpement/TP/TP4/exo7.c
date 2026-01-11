#include <stdio.h>
#include <stdlib.h>

void usage();
void calcul(int op1, char operateur, int op2);

int main() {
    usage();

    int op1, op2;
    char operateur;

    do {
        printf("Entrez une operation : ");
        scanf("%d %c %d", &op1, &operateur, &op2);

        if (operateur != ':') {
            calcul(op1, operateur, op2);
        }
    } while (operateur != ':');
    printf("Au revoir...\n");
    return EXIT_SUCCESS;
}


void usage() {
  printf("Cette calculatrice permet d'effectuer des opérations arithmétiques simples sur des entiers.\n");
  printf("Pour l'utiliser, entrez une suite d'opérations sous la forme :\n");
  printf("<operande> <operateur> <operande>\n");
  printf("Pour terminer, utilisez \":\" comme opérateur.\n");
  printf("Par exemple, \"0 : 0\" arrête le programme.\n");
}

void calcul(int op1, char operateur, int op2) {
  switch (operateur) {
    case '+':
      printf("%d + %d = %d\n", op1, op2, op1 + op2);
      break;
    case '-':
      printf("%d - %d = %d\n", op1, op2, op1 - op2);
      break;
    case '*':
      printf("%d * %d = %d\n", op1, op2, op1 * op2);
      break;
    case '/':
      if (op2 == 0) {
        printf("Erreur : division par zéro.\n");
      } else {
        printf("%d / %d = %d\n", op1, op2, op1 / op2);
      }
      break;
    default:
      printf("Opérateur inconnu : %c\n", operateur);
  }
}