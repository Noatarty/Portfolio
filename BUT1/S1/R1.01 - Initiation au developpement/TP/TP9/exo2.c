#include <stdio.h>
#include <stdlib.h>

typedef float t_vecteur[10];
typedef float t_matrice[10][10];
typedef char chaine20[21];
typedef chaine20 t_sport[4];

void afficherVecteur(t_vecteur vect, t_sport sports, int nb) {
    for (int i = 0; i < nb; i++) {
        printf("%s %.0f ",sports[i], vect[i]);
    }
    printf("\n");
}

void afficherMatrice(t_matrice mEvolution, t_sport sports, int nb) {
    for (int lig = 0; lig < nb; lig++) {
        for (int col = 0; col < nb; col++) {
            printf("%.2f ", mEvolution[lig][col]);
        }
        printf("\n");
    }
}

void produitVectMat(t_vecteur vInitial, t_matrice mEvolution, t_vecteur vResultat, int nb) {
    for (int i = 0; i < nb; i++) {
        vResultat[i] = 0;
        for (int j = 0; j < nb; j++) {
            vResultat[i] += vInitial[j] * mEvolution[i][j];
        }
    }
}

void copiervecteur(t_vecteur vResultat, t_vecteur vInitial, int nb) {
    for (int i = 0; i < nb; i++) {
        vResultat[i] = vInitial[i];
    }
}

int main() {
    int nbSports = 4;
    t_vecteur vInitial = {35, 25, 20, 20};
    t_matrice mEvolution = {{0.9, 0.03, 0.02, 0.05},
                            {0.06, 0.8, 0.03, 0.11},
                            {0.08, 0.02, 0.75, 0.15},
                            {0.05, 0.03, 0.04, 0.88}};
    t_vecteur vResultat;
    t_sport sports = {"cyclisme","foot","voile","inactifs"};

    for (int i = 1; i < 31; i++) {
        produitVectMat(vInitial, mEvolution, vResultat, nbSports);
        copiervecteur(vInitial, vResultat, nbSports);
    }

    printf("Nombre de pratiquants au bout de 30 ans:\n");
    afficherVecteur(vResultat,sports, nbSports);

    return EXIT_SUCCESS;
}