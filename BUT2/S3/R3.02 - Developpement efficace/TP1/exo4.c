#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef char chaine20[21];

typedef struct {
    chaine20 nom;
    int population;
    int superficie;
} t_capitale;

typedef struct {
    chaine20 nom;
    t_capitale * capitale;
} t_pays;

void init_pays(t_pays * t) {
    printf("Entrez le nom du pays : ");
    scanf("%20s", t->nom);
    
    t->capitale = (t_capitale *)malloc(sizeof(t_capitale));
    if (t->capitale == NULL) {
        fprintf(stderr, "Erreur d'allocation mémoire\n");
        exit(1);
    }
    
    printf("Entrez le nom de la capitale : ");
    scanf("%20s", t->capitale->nom);
    
    printf("Entrez la population de la capitale : ");
    scanf("%d", &(t->capitale->population));
    
    printf("Entrez la superficie de la capitale : ");
    scanf("%d", &(t->capitale->superficie));
}

void affiche_pays(t_pays t) {
    printf("Pays : %s\n", t.nom);
    printf("Capitale : %s\n", t.capitale->nom);
    printf("Population de la capitale : %d\n", t.capitale->population);
    printf("Superficie de la capitale : %d\n", t.capitale->superficie);
}

int main() {
    t_pays *mon_pays = (t_pays *)malloc(sizeof(t_pays));
    if (mon_pays == NULL) {
        fprintf(stderr, "Erreur d'allocation mémoire\n");
        return 1;
    }

    init_pays(mon_pays);
    printf("\nInformations du pays :\n");
    affiche_pays(*mon_pays);

    free(mon_pays->capitale);
    free(mon_pays);

    return 0;
}
