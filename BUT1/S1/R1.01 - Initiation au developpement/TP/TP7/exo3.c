#include <stdio.h>
#include <stdlib.h>
/*Exercice 3
On veut connaître la répartition des notes du DS d’algorithmique et programmation, c’est–à-dire le
nombre de 0, le nombre de 1,  ..., le nombre de 20, ayant été attribués à ce DS. 
Question / Écrivez un programme en C , utilisant les procédures demandées ci-dessous, lisant au clavier une
suite de notes ( une note est un entier compris entre 0 et 20 ) terminée par –1, et affichant le nombre
d’occurrences de chacune des 21 notes possibles (pour améliorer la lisibilité du résultat, on ne fera un
affichage que pour les notes ayant au moins une occurrence).
N.B. Les données ne sont pas stockées dans un tableau, mais traitées au fur et à mesure de leur lecture. 
On utilisera un tableau nb tel que nb[note] sera le nombre d’occurrences de la note note.
Le programme devra utiliser des procédures :
- pour initialiser le tableau nb 
- pour mettre à jour le tableau nb
- pour afficher les résultats*/

//Exercice 3
typedef int tableau;

void init_nb(tableau nb[]);
void update_nb(tableau nb[], int note);
void afficherResult(tableau nb[]);

int main() {
    tableau nb[21];
    init_nb(nb);
    int note;
    printf("Entrez les notes du DS d'algorithmique et programmation, une a la fois. Finissez par entrer -1.\n");
    do {
        scanf("%d", &note);
        update_nb(nb, note);
    } while (note == -1);
    
    afficherResult(nb);
    return EXIT_SUCCESS;
}

void init_nb(tableau nb[]) {
    for (int i = 0; i <= 20; i++) {
        nb[i] = 0;
    }
}

void update_nb(tableau nb[], int note) {
    nb[note]++;
}

void afficherResult(tableau nb[]) {
    for (int i = 0; i <= 20; i++) {
        if (nb[i] > 0) {
            printf("Note %d : %d occurrence(s)\n", i, nb[i]);
        }
    }
}