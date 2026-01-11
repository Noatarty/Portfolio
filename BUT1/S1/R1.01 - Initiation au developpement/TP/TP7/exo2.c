#include <stdio.h>
#include <stdlib.h>

//Exercice 2

#define N 5

typedef int vecteur[N] ;

void remplirVecteur (vecteur v);
void afficherVecteur (vecteur v);
void sommeVecteur (vecteur v1, vecteur v2, vecteur vSomme);

int main() {
    vecteur v1, v2, vSomme;

    printf("Remplissage du premier vecteur :\n");
    remplirVecteur(v1);

    printf("Remplissage du second vecteur :\n");
    remplirVecteur(v2);

    sommeVecteur(v1, v2, vSomme);

    printf("La somme des deux vecteurs est :\n");
    afficherVecteur(vSomme);

    return EXIT_SUCCESS;
}

void remplirVecteur (vecteur v) {
    // initialise v avec les valeurs fournies au clavier .
    for(int i=0; i<N; i++) {
        printf("Entrez la valeur %d : ", i);
        scanf("%d", &v[i]);
    }
}

void afficherVecteur (vecteur v)  {
    //affiche à l’écran les N coefficients du vecteur v.
    for(int i=0;i<N;i++) {
        printf("\n%d\t: \t%d",i+1,v[i]);
    }
}  
void sommeVecteur (vecteur v1, vecteur v2, vecteur vSomme) {
    // met dans vs la somme des vecteurs v1 et v2
    for(int i=0;i<N;i++){
        vSomme[i]=v1[i]+v2[i];
    }
}