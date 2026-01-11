#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

// Définition de la structure pour un nœud de la liste chaînée
typedef struct Node {
    int data;
    struct Node* next;
} Node;

// Définition du type ensemble
typedef Node* Ensemble;

// Fonction pour initialiser un ensemble vide
Ensemble initialiser() {
    return NULL;
}

// Fonction pour tester l'appartenance d'un entier à un ensemble
bool appartient(Ensemble e, int x) {
    Node* current = e;
    while (current != NULL) {
        if (current->data == x) {
            return true;
        }
        current = current->next;
    }
    return false;
}

// Fonction pour ajouter un entier à un ensemble
Ensemble ajouter(Ensemble e, int x) {
    if (!appartient(e, x)) {
        Node* nouveau = (Node*)malloc(sizeof(Node));
        nouveau->data = x;
        nouveau->next = e;
        return nouveau;
    }
    return e;
}

// Procédure pour afficher l'ensemble
void afficher(Ensemble e) {
    printf("Ensemble: ");
    Node* current = e;
    while (current != NULL) {
        printf("%d ", current->data);
        current = current->next;
    }
    printf("\n");
}

// Procédure pour ajouter les éléments d'un tableau à un ensemble
void ajouterTableau(Ensemble* e, int* tab, int taille) {
    for (int i = 0; i < taille; i++) {
        *e = ajouter(*e, tab[i]);
    }
}

// Fonction pour retourner le cardinal d'un ensemble
int cardinal(Ensemble e) {
    int count = 0;
    Node* current = e;
    while (current != NULL) {
        count++;
        current = current->next;
    }
    return count;
}

// Procédure pour faire l'union de deux ensembles
void union_ensembles(Ensemble e1, Ensemble e2, Ensemble* e3) {
    *e3 = initialiser();
    Node* current = e1;
    while (current != NULL) {
        *e3 = ajouter(*e3, current->data);
        current = current->next;
    }
    current = e2;
    while (current != NULL) {
        *e3 = ajouter(*e3, current->data);
        current = current->next;
    }
}

// Procédure pour faire l'intersection de deux ensembles
void intersection_ensembles(Ensemble e1, Ensemble e2, Ensemble* e3) {
    *e3 = initialiser();
    Node* current = e1;
    while (current != NULL) {
        if (appartient(e2, current->data)) {
            *e3 = ajouter(*e3, current->data);
        }
        current = current->next;
    }
}

// Fonction principale pour tester les fonctions
int main() {
    Ensemble e1 = initialiser();
    Ensemble e2 = initialiser();
    Ensemble e3;

    e1 = ajouter(e1, 1);
    e1 = ajouter(e1, 2);
    e1 = ajouter(e1, 3);

    e2 = ajouter(e2, 2);
    e2 = ajouter(e2, 3);
    e2 = ajouter(e2, 4);

    printf("Ensemble e1: ");
    afficher(e1);

    printf("Ensemble e2: ");
    afficher(e2);

    printf("Cardinal de e1: %d\n", cardinal(e1));

    int tab[] = {5, 6, 7};
    ajouterTableau(&e1, tab, 3);
    printf("e1 après ajout du tableau: ");
    afficher(e1);

    union_ensembles(e1, e2, &e3);
    printf("Union de e1 et e2: ");
    afficher(e3);

    intersection_ensembles(e1, e2, &e3);
    printf("Intersection de e1 et e2: ");
    afficher(e3);

    return EXIT_SUCCESS;
}
