#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct elem { 
    struct elem* prec; 
    int val; 
    struct elem* svt; 
} telement; 

typedef telement* tlisteDC;

// 2. Initialiser une tlisteDC
void initialiser(tlisteDC *lDC) {
    *lDC = NULL;
}

// 3. Insérer un entier en tête d'une tlisteDC
void insererEnTete(tlisteDC *lDC, int valeur) {
    telement *nouvelElement = (telement *)malloc(sizeof(telement));
    if (nouvelElement == NULL) {
        fprintf(stderr, "Erreur d'allocation mémoire\n");
        exit(1);
    }
    nouvelElement->val = valeur;
    nouvelElement->prec = NULL;
    nouvelElement->svt = *lDC;
    
    if (*lDC != NULL) {
        (*lDC)->prec = nouvelElement;
    }
    *lDC = nouvelElement;
}

// 4. Afficher une tlisteDC
void afficher(tlisteDC lDC) {
    telement *courant = lDC;
    printf("Liste : ");
    while (courant != NULL) {
        printf("%d ", courant->val);
        courant = courant->svt;
    }
    printf("\n");
}

// 5. Insérer un entier après le Iième élément
void insererApresI(tlisteDC *lDC, int I, int valeur) {
    if (*lDC == NULL || I < 1) {
        return;
    }
    
    telement *courant = *lDC;
    int position = 1;
    
    while (courant != NULL && position < I) {
        courant = courant->svt;
        position++;
    }
    
    if (courant == NULL) {
        return;
    }
    
    telement *nouvelElement = (telement *)malloc(sizeof(telement));
    if (nouvelElement == NULL) {
        fprintf(stderr, "Erreur d'allocation mémoire\n");
        exit(1);
    }
    nouvelElement->val = valeur;
    nouvelElement->prec = courant;
    nouvelElement->svt = courant->svt;
    
    if (courant->svt != NULL) {
        courant->svt->prec = nouvelElement;
    }
    courant->svt = nouvelElement;
}

int main() {
    tlisteDC maListe;
    initialiser(&maListe);
    
    insererEnTete(&maListe, 3);
    insererEnTete(&maListe, 2);
    insererEnTete(&maListe, 1);
    
    printf("Liste initiale :\n");
    afficher(maListe);
    
    insererApresI(&maListe, 2, 4);
    
    printf("Liste après insertion :\n");
    afficher(maListe);
    
    return 0;
}
