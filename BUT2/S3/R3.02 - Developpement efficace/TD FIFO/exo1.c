#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct { 
    char nom[50]; 
    int age; 
} tpersonne ; 
 
typedef struct elem{ 
    tpersonne pers; 
    struct elem* svt; 
} telement; 
 
typedef struct{ 
    telement* queue; 
    telement* tete; 
} tfile;

typedef struct { 
    tfile urgent; 
    tfile important; 
    tfile standard; 
}tfilePrio ;

// Création d'une file vide
tfile* creerFile() {
    tfile* f = (tfile*)malloc(sizeof(tfile));
    if (f != NULL) {
        f->tete = NULL;
        f->queue = NULL;
    }
    return f;
}

// Test de vacuité d'une file
int estVide(tfile* f) {
    return (f->tete == NULL); 
}

// Obtention de la tête d'une file
tpersonne* obtenirTete(tfile* f) {
    if (!estVide(f)) {
        return &(f->tete->pers);
    }
    return NULL;
}

// Ajout dans une file
void ajouterFile(tfile* f, char* nom, int age) {
    telement* nouvel_elem = (telement*)malloc(sizeof(telement));
    if (nouvel_elem != NULL) {
        strcpy(nouvel_elem->pers.nom, nom);
        nouvel_elem->pers.age = age;
        nouvel_elem->svt = NULL;

        if (estVide(f)) {
            f->tete = nouvel_elem;
        } else {
            f->queue->svt = nouvel_elem;
        }
        f->queue = nouvel_elem;
    }
}

// Suppression dans une file
void supprimerFile(tfile* f) {
    if (!estVide(f)) {
        telement* temp = f->tete;
        f->tete = f->tete->svt;
        free(temp);

        if (f->tete == NULL) {
            f->queue = NULL;
        }
    }
}

// Procédure pour initialiser une tfilePrio
void creationPrio(tfilePrio *fp) {
    if (fp != NULL) {
        fp->urgent = *creerFile();
        fp->important = *creerFile();
        fp->standard = *creerFile();
    }
}

void ajoutePrio(tfilePrio *fp, tpersonne p, int priorite){
    switch(priorite){
        case 1:
            ajouterFile(&fp->urgent, p.nom, p.age);
            break;
        case 2:
            ajouterFile(&fp->important, p.nom, p.age);
            break;
        case 3:
            ajouterFile(&fp->standard, p.nom, p.age);
            break;
        default:
            printf("Priorité invalide\n");
    }
}

void affichePrio(tfilePrio *fp) {
    if (!estVide(&fp->urgent)) {
        printf("Urgent: %s, %d\n", obtenirTete(&fp->urgent)->nom, obtenirTete(&fp->urgent)->age);
        supprimerFile(&fp->urgent);
    } else if (!estVide(&fp->important)) {
        printf("Important: %s, %d\n", obtenirTete(&fp->important)->nom, obtenirTete(&fp->important)->age);
        supprimerFile(&fp->important);
    } else if (!estVide(&fp->standard)) {
        printf("Standard: %s, %d\n", obtenirTete(&fp->standard)->nom, obtenirTete(&fp->standard)->age);
        supprimerFile(&fp->standard);
    } else {
        printf("Toutes les files sont vides.\n");
    }
}

//tests

int main() {
    tfilePrio fp;
    creationPrio(&fp);
    tpersonne p1 = {"Alice", 25};
    tpersonne p2 = {"Bob", 30};
    tpersonne p3 = {"Charlie", 35};
    ajoutePrio(&fp, p1, 1);
    ajoutePrio(&fp, p2, 2);
    ajoutePrio(&fp, p3, 3);
    affichePrio(&fp);
    affichePrio(&fp);
    affichePrio(&fp);
    affichePrio(&fp);
    return EXIT_SUCCESS;
}