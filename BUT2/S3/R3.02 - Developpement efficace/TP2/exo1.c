#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Definition du type personne
typedef struct {
    char nom[50];
    int age;
} tpersonne;

// Definition du type element
typedef struct telement {
    tpersonne personne;
    struct telement* suivant;
} telement;

// Definition du type liste
typedef telement* tliste;

// 2. Procedure d'initialisation d'une tliste
void initialiser_liste(tliste* l) {
    *l = NULL;
}

// 3. Procedure d'insertion d'une nouvelle personne en tete d'une tliste
void inserer_tete(tliste* l, char* nom, int age) {
    telement* nouvel_element = (telement*)malloc(sizeof(telement));
    strcpy(nouvel_element->personne.nom, nom);
    nouvel_element->personne.age = age;
    nouvel_element->suivant = *l;
    *l = nouvel_element;
}

// Procedure pour afficher une tpersonne
void afficher_personne(tpersonne p) {
    printf("Nom: %s, Age: %d\n", p.nom, p.age);
}

// 4. Procedure d'affichage des elements d'une tliste
void afficher_liste(tliste l) {
    telement* courant = l;
    while (courant != NULL) {
        afficher_personne(courant->personne);
        courant = courant->suivant;
    }
}

// 5. Fonction de recherche d'une personne a partir de son nom
telement* rechercher_personne(tliste l, char* nom) {
    telement* courant = l;
    while (courant != NULL) {
        if (strcmp(courant->personne.nom, nom) == 0) {
            return courant;
        }
        courant = courant->suivant;
    }
    return NULL;
}

// 6. Fonction supprimant le telement en tete d'une tliste
void supprimer_tete(tliste* l) {
    if (*l != NULL) {
        telement* temp = *l;
        *l = (*l)->suivant;
        free(temp);
    }
}

// 7. Fonction pour compter le nombre de personnes d'un meme nom
int compter_personnes_meme_nom(tliste l, char* nom) {
    int count = 0;
    telement* courant = l;
    while (courant != NULL) {
        if (strcmp(courant->personne.nom, nom) == 0) {
            count++;
        }
        courant = courant->suivant;
    }
    return count;
}

// 8. Fonction pour rechercher le ieme telement
telement* rechercher_ieme_element(tliste l, int i) {
    telement* courant = l;
    int position = 1;
    while (courant != NULL && position < i) {
        courant = courant->suivant;
        position++;
    }
    return courant;
}

// 9. Fonction pour inserer une personne en fin de liste
void inserer_fin(tliste* l, char* nom, int age) {
    telement* nouvel_element = (telement*)malloc(sizeof(telement));
    strcpy(nouvel_element->personne.nom, nom);
    nouvel_element->personne.age = age;
    nouvel_element->suivant = NULL;

    if (*l == NULL) {
        *l = nouvel_element;
    } else {
        telement* courant = *l;
        while (courant->suivant != NULL) {
            courant = courant->suivant;
        }
        courant->suivant = nouvel_element;
    }
}

// 10. Procedure pour inserer une personne apres le Iieme element
void inserer_apres_ieme(tliste* l, char* nom, int age, int i) {
    telement* ieme_element = rechercher_ieme_element(*l, i);
    if (ieme_element != NULL) {
        telement* nouvel_element = (telement*)malloc(sizeof(telement));
        strcpy(nouvel_element->personne.nom, nom);
        nouvel_element->personne.age = age;
        nouvel_element->suivant = ieme_element->suivant;
        ieme_element->suivant = nouvel_element;
    }
}

int main() {
    tliste ma_liste;
    initialiser_liste(&ma_liste);

    char nom[50];
    int age;

    // Saisie des personnes
    while (1) {
        printf("Entrez le nom de la personne (-1 pour arreter) : ");
        scanf("%s", nom);
        if (strcmp(nom, "-1") == 0) break;
        printf("Entrez l'age de la personne : ");
        scanf("%d", &age);
        inserer_tete(&ma_liste, nom, age);
    }

    printf("\nListe des personnes :\n");
    afficher_liste(ma_liste);

    // Test des autres fonctions
    printf("\nRecherche d'une personne :\n");
    printf("Entrez le nom a rechercher : ");
    scanf("%s", nom);
    telement* resultat = rechercher_personne(ma_liste, nom);
    if (resultat != NULL) {
        printf("Personne trouvee : ");
        afficher_personne(resultat->personne);
    } else {
        printf("Personne non trouvee.\n");
    }

    printf("\nSuppression de la premiere personne :\n");
    supprimer_tete(&ma_liste);
    afficher_liste(ma_liste);

    printf("\nCompter les personnes avec le meme nom :\n");
    printf("Entrez le nom a compter : ");
    scanf("%s", nom);
    int count = compter_personnes_meme_nom(ma_liste, nom);
    printf("Nombre de personnes avec le nom %s : %d\n", nom, count);

    printf("\nRecherche du ieme element :\n");
    printf("Entrez la position i : ");
    int i;
    scanf("%d", &i);
    telement* ieme = rechercher_ieme_element(ma_liste, i);
    if (ieme != NULL) {
        printf("Personne a la position %d : ", i);
        afficher_personne(ieme->personne);
    } else {
        printf("Pas d'element a la position %d.\n", i);
    }

    printf("\nInsertion en fin de liste :\n");
    printf("Entrez le nom : ");
    scanf("%s", nom);
    printf("Entrez l'age : ");
    scanf("%d", &age);
    inserer_fin(&ma_liste, nom, age);
    afficher_liste(ma_liste);

    printf("\nInsertion apres le ieme element :\n");
    printf("Entrez la position i : ");
    scanf("%d", &i);
    printf("Entrez le nom : ");
    scanf("%s", nom);
    printf("Entrez l'age : ");
    scanf("%d", &age);
    inserer_apres_ieme(&ma_liste, nom, age, i);
    afficher_liste(ma_liste);

    // Liberation de la memoire
    while (ma_liste != NULL) {
        supprimer_tete(&ma_liste);
    }

    return EXIT_SUCCESS;
}
