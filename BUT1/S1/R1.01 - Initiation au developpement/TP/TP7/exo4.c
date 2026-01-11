#include <stdio.h>
#include <stdlib.h>

/*Exercice 4*/
void initialiser_total(int total[], int n);
void decomposer_somme(int somme, int total[], int n);
void afficher_recapitulatif(int total[], int n);

const int VALEURS[] = {1, 2, 5, 10, 20, 50, 100, 200, 500};

int main() {
    int somme;
    char nom[20];
    int total[sizeof(VALEURS) / sizeof(VALEURS[0])];
    int n = sizeof(VALEURS) / sizeof(VALEURS[0]);

    initialiser_total(total, n);
    do
    {
        printf("Nom ? : ");
        scanf("%s", nom);
        if (nom[0] != '*')
        {
            printf("Somme ? : ");
            scanf("%d", &somme);
        }

        printf("%s :\n", nom);
        decomposer_somme(somme, total, n);
        printf("\n");
    } while (nom[0] != '*');
    
    printf("Total pour l ensemble des clients :\n");
    afficher_recapitulatif(total, n);
    return EXIT_SUCCESS;
}

void initialiser_total(int total[], int n) {
    for (int i = 0; i < n; i++) {
        total[i] = 0;
    }
}

void decomposer_somme(int somme, int total[], int n) {
    for (int i = n - 1; i >= 0; i--) {
        int tmp = 0;
        while (somme >= VALEURS[i]) {
            somme -= VALEURS[i];
            tmp++;
        }
        total[i]+=tmp;
        if (tmp != 0){
            printf("%dx%d, ", tmp, VALEURS[i]);
        }
    }
}

void afficher_recapitulatif(int total[], int n) {
    for (int i = 0; i < n; i++) {
        if (total[i] > 0) {
            printf("%d x %d\n", total[i], VALEURS[i]);
        }
    }
}