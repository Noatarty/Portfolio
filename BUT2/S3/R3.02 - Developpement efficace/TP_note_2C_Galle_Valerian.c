#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <time.h>

#define nbElem 10

typedef int tab[nbElem];

/************************ Question 1 ************************/

typedef struct Elem{
    int num;
    struct Elem* svt;
} ensemble;

typedef ensemble *tliste;

//////////////////////////////////////////////////////////////

void affTablo(tab T){
    int i = 0;

    for(i=0; i<nbElem; i++){
       printf("%d ",T[i]);
    }
    printf("\n");
}

void initTablo(tab T){
int j;
int valeur;
for(j=0; j<nbElem; j++){
             valeur=rand();
             T[j]=(valeur%20);
             }

}

void tri_selectionDecroissant(tab T){
 int I,J,M;

  for (I=0;I<nbElem;I++){
      for (J=I+1;J<nbElem;J++){
	      if (T[J]>T[I]) {
	    		M=T[I];
	    		T[I]=T[J];
	    		T[J]=M;
	       }
      }
   }
}

/************************ Question 2 ************************/

void init_liste(tliste *l){
    (*l)=NULL;
}

/************************ Question 3 ************************/

void insertion_en_tete(tliste *l, int a) {
    ensemble *e = (ensemble *)malloc(sizeof(ensemble));

    e->num=a;
    e->svt=*l;
    *l=e;
}

bool existe(tliste l, int nombre){
    int res=0;
    ensemble *i=l;
    while ((res==0) && (i!=NULL)){
        if(i->num==nombre){
            res=1;
        }
        i=i->svt;
    }
    if (res==1){
        return true;
    } else {
        return false;
    }
}

void ajoutElem(ensemble * e, int x){
    if(!existe(e,x)){
        insertion_en_tete(&e,x);
    }
}

void ajoutTab(tliste *l, tab tablo) {
    ensemble *e=*l;
    for(int i=0;i<nbElem;i++){
        ajoutElem(&*e,tablo[i]);
    }
}

/************************ Question 4 ************************/

void aff_num(int nb){
    printf("%d ;\n", nb);
}

void afficher_liste(tliste l){
    printf("Le contenu de la liste:\n");
    if (l==NULL){
        printf("liste vide.\n");
    } else {
        tliste p;
        p=l;
        while (p!=NULL){
            aff_num(p->num);
            p=p->svt;
        }
    }
}

/************************ Question 5 ************************/

float moyenneListe(tliste l){
    tliste aux;
    aux=l;
    float res=0;
    int somme=0;
    int compteur=0;
    while (aux!=NULL){
        somme+=aux->num;
        compteur++;
        aux=aux->svt;
    }
    if (compteur!=0){
        res=somme/compteur;
    } else {
        printf("La tliste est vide\n");
    }
    return res;
}


int main(){

    tab monTab;

    srand(time(NULL));
    initTablo(monTab);
    printf("\n \n Affichage avant tri : \n\n");
    affTablo(monTab);
    tri_selectionDecroissant(monTab);
    printf("\n \n Affichage apres tri dec : \n\n");
    affTablo(monTab);

    ////////////////////////////////////////////

    tliste maliste;
    init_liste(&maliste);
    ajoutTab(&maliste,monTab);
    afficher_liste(maliste);
    printf("%.2f ;\n", moyenneListe(maliste));

    return 0;
}