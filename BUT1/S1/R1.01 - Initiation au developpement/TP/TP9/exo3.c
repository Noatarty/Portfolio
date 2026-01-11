#include <stdio.h>
#include <stdlib.h>

#define NbCat 6
#define NbTr 5

char saisir (){
    //saisir les données de chaque personne interrogée. Une étoile "*" à la place du nom
    //signale la fin des données (nom,a catégorie socioprofessionnelle, sa tranche
    //d’âge, et le nombre de films qu’elle a vus)
    char nom,cat,nb_films;
    int tr;
    int i=0;
    while(i<NbCat*NbTr){
        printf("Entrez le nom ou une * pour terminer : ");
        scanf("%c",&nom);
        if(nom=='*'){
            return '*';
        }
        else {
            printf("\nChoix de la catégorie socioprofessionnelle\n");
            scanf("%s",&cat);
            printf("\nTranche d\'âge\n");
            scanf("%d",&tr);
            printf("\nNombre de films vus par %s dans la catégorie %s\n",nom,cat);
            scanf("%d",&nb_films);
            i++;
        }
    }
}

int nbSpectateurs(){
    
}