#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
/*Dans cet exercice, on souhaite simuler la gestion d'un stock de produits frais. Chaque produit est décrit 
par sa référence et sa date d'entrée en stock.*/
//Soit le type produit et les procédures permettant de saisir ou d'afficher un produit (saisir,afficher):
typedef char chaine10[11] ;
typedef struct{
    chaine10 reference;
    int dateEntStock;
} produit;

#define MAX 100
typedef struct  {
    produit tab[MAX];
    int sommet;
} Pile;

typedef Pile stock ;

void saisir(produit *adr_prod, int dateJ);
void afficher(produit prod);
void modifdate(int* adr_datej);
bool estVide(Pile *p);
bool estPleine(Pile *p);
void empiler(Pile *p , produit x );
produit depiler(Pile *p);
produit sommet(const Pile* p, produit *x);
void init(stock* adr_st);
void entree(produit pr, stock* adr_st);
void sortie(stock* adr_st, int dateJ);

int main(){
    produit prod;
    int choix, dateJ=time(NULL)/86400;
    char reponse='y';
    stock stck;
    init(&stck);
    while ((choix!='0') && (reponse=='y')){
        printf("\n\n");
        printf("Menu Stock \n");
        printf("1: Entrer un Produit\n");
        printf("2: Vente d'un Produit sorti du stock\n");
        printf("3: Le Temps Passe\n");
        printf("0: Quitter\n");
        scanf("%i",&choix);
        switch(choix){
            case '1':
                printf("Entrer la reference du produit : ");
                scanf("%i", &prod.reference);
                printf("Date d'entree : %d\n",dateJ);
                entree(prod, &stck);
                break;
        }
    }
}

void saisir(produit *adr_prod, int dateJ){
    // met dans *adr_prod un produit saisi au clavier à la date dateJ
    printf("référence ?\n");
    scanf("%s",adr_prod->reference);
    adr_prod->dateEntStock=dateJ;
}
void afficher(produit prod){
    // affiche à l'écran le produit prod
    printf("%s %d\n",prod.reference,prod.dateEntStock);
}

void modifdate(int* adr_datej){
    //tourne la page de l'éphéméride
    (*adr_datej)++;
}

bool estVide(Pile *p) {
    return p->sommet==-1;
}
bool estPleine(Pile *p) {
    return p->sommet == MAX - 1 ;
}
void empiler(Pile *p , produit x ) {
    if (!estPleine(p)){
        p->tab[++p->sommet] = x;
    }
}
produit depiler(Pile *p) {
    produit tmp ;
    if(!estVide(p)) {
        tmp= p->tab [p->sommet-- ];
    } else {
        printf("La pile est vide \n");
    }
    return tmp;
}
produit sommet(const Pile* p, produit *x) {
    if (!estVide(p)) {
        *x = p->tab [p->sommet];
    } else {
            printf("La pile est vide \n") ;
    }
}

void init(stock* adr_st){
    // initialise le stock *adr_st à vide
}
void entree(produit pr, stock* adr_st){
    //entre le produit pr dans le stock *adr_st
}
void sortie(stock* adr_st, int dateJ){
    //sort du stock *adr_st un ou des produit(s) connaissant la date du jour dateJ
}