#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

typedef struct elem {
    int val;
    struct elem* svt;
} telement;

typedef struct {
    telement* queue;
    telement* tete;
    telement* max;
    telement* min;
} tfileD;

void initialisation(tfileD *f) {
    f->queue = NULL;
    f->tete = NULL;
    f->max = NULL;
    f->min = NULL;
}

bool estvide(tfileD f) {
    return f.tete == NULL;
}

void afficheInfosFile(tfileD f) {
    if (estvide(f)) {
        printf("La file est vide.\n");
        return;
    }
    printf("Tete: %d\n", f.tete->val);
    printf("Queue: %d\n", f.queue->val);
    printf("Maximum: %d\n", f.max->val);
    printf("Minimum: %d\n", f.min->val);
}

void ajouteEnQueue(tfileD *f, int v) {
    telement* nouv = malloc(sizeof(telement));
    nouv->val = v;
    nouv->svt = NULL;

    if (estvide(*f)) {
        f->tete = nouv;
        f->queue = nouv;
        f->max = nouv;
        f->min = nouv;
    } else {
        f->queue->svt = nouv;
        f->queue = nouv;
        if (v > f->max->val) {
            f->max = nouv;
        }
        if (v < f->min->val) {
            f->min = nouv;
        }
    }
}

void supprime(tfileD *f) {
    if (estvide(*f)) {
        printf("La file est déjà vide.\n");
        return;
    }

    telement* temp = f->tete;
    f->tete = f->tete->svt;

    if (f->tete == NULL) {
        f->queue = NULL;
        f->max = NULL;
        f->min = NULL;
    } else {
        if (temp == f->max) {
            telement* current = f->tete;
            f->max = current;
            while (current != NULL) {
                if (current->val > f->max->val) {
                    f->max = current;
                }
                current = current->svt;
            }
        }
        if (temp == f->min) {
            telement* current = f->tete;
            f->min = current;
            while (current != NULL) {
                if (current->val < f->min->val) {
                    f->min = current;
                }
                current = current->svt;
            }
        }
    }

    free(temp);
}
