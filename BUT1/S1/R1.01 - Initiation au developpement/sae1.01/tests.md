# Tests

## Cas 1

```c
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

// Définition de la taille de la grille (9x9 pour le Sudoku classique)
#define N 3
#define TAILLE (N*N)

//types
typedef int tGrille[TAILLE][TAILLE];

typedef struct {
    int valeur;
    int candidats[TAILLE];
    int nbCandidats;
} tCase1;

procédure ajouterCandidat( entF/sortF laCase : tCase1, entF val:entier) c'est '
//ajoute la valeur val à la liste des candidats de la case passée en paramètre d’entrée/sortie debut
debut
    
fin
procédure retirerCandidat( entF/sortF laCase : tCase1,entF val : entier) c'est '
//supprime la valeur val de la liste des candidats de la case passée en paramètred’entrée/sortie
debut
    
fin
fonction estCandidat( entF laCase : tCase1,entF val : entier) délivre booléen c'est '
//retourne vrai si val est l’un des candidats de la case passée en paramètre d’entréeet faux sinon
debut
    
fin
fonction nbCandidats(entF laCase : tCase1) délivre entier c'est '
// retourne le nombre de candidats de la case passée en paramètre d’entrée.
debut
    retourne laCase.nbCandidats;
fin

programme deduction
debut
    g : tGrille;
    progression : booléen;
    nbCasesVides : entier;
    nbCasesVides = chargerGrille(g);
    initialiserCandidats(g);
    progression = true;
    tant que (nbCaseVides <> 0 ET progression) faire
        progression = false;
    // technique du singleton nu
    pour chaque case libre de la grille faire
        si la case n'a qu'un seul candidat alors
            • affecter ce candidat à la case
            • nbCasesVides = nbCasesVides – 1;
            • retirer ce candidat de toutes les cases de la
            même ligne, de la même colonne et du même bloc
            • progression = true;
        finsi
    finfaire
    // technique du singleton caché
    ...
    // autres techniques…
    ...
    finfaire
fin

procédure afficherStats() c'est '
debut
    
fin
```

## Cas 2

```c
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

// Définition de la taille de la grille (9x9 pour le Sudoku classique)
#define N 3
#define TAILLE (N*N)

//types
typedef int tGrille[TAILLE][TAILLE];

typedef struct {
    int valeur;
    bool candidats[TAILLE+1]; // la case d’indice 0 est neutralisée
    int nbCandidats;
} tCase2;

procédure ajouterCandidat( entF/sortF laCase : tCase2, entF val:entier) c'est '
//ajoute la valeur val à la liste des candidats de la case passée en paramètre d’entrée/sortie debut
debut
    
fin
procédure retirerCandidat( entF/sortF laCase : tCase2,entF val : entier) c'est '
//supprime la valeur val de la liste des candidats de la case passée en paramètred’entrée/sortie
debut
    
fin
fonction estCandidat( entF laCase : tCase2,entF val : entier) délivre booléen c'est '
//retourne vrai si val est l’un des candidats de la case passée en paramètre d’entréeet faux sinon
debut
    
fin
fonction nbCandidats(entF laCase : tCase2) délivre entier c'est '
// retourne le nombre de candidats de la case passée en paramètre d’entrée.
debut
    retourne laCase.nbCandidats;
fin
```
