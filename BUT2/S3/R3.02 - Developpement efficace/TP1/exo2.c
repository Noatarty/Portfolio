#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef char chaine20[21];

typedef struct {
    chaine20 nom;
    int population;
    chaine20 capitale;
} t_region;

typedef t_region* pt_region;

void afficher_region(t_region r) {
    printf("Nom: %s\n", r.nom);
    printf("Population: %d\n", r.population);
    printf("Capitale: %s\n", r.capitale);
}

int main() {
    // Question 1
    t_region P1;
    
    printf("Entrez le nom de la région: ");
    scanf("%20s", P1.nom);
    printf("Entrez la population: ");
    scanf("%d", &P1.population);
    printf("Entrez la capitale: ");
    scanf("%20s", P1.capitale);
    
    printf("\nInformations de la région P1:\n");
    afficher_region(P1);

    // Question 2
    pt_region ptr = (pt_region)malloc(sizeof(t_region));
    if (ptr == NULL) {
        fprintf(stderr, "Erreur d'allocation mémoire\n");
        return 1;
    }

    strcpy(ptr->nom, "Bretagne");
    ptr->population = 600000;
    strcpy(ptr->capitale, "Rennes");

    printf("\nInformations de la région pointée (initialisée):\n");
    afficher_region(*ptr);

    // Question 3
    printf("\nEntrez les informations pour la région pointée:\n");
    printf("Nom: ");
    scanf("%20s", ptr->nom);
    printf("Population: ");
    scanf("%d", &ptr->population);
    printf("Capitale: ");
    scanf("%20s", ptr->capitale);

    printf("\nInformations de la région pointée (saisie utilisateur):\n");
    afficher_region(*ptr);

    free(ptr);
    return 0;
}
