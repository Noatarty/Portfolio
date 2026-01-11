#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define NM 12
typedef char t_chaine9[10];
typedef  struct{
    t_chaine9 c_nom;
    int      c_nbJours;
} t_mois;
typedef  t_mois t_tabMois[NM];
const t_tabMois  tMois= { {"janvier",31},
                          {"fevrier",28},
                          {"mars",31},
                          {"avril",30},
                          {"mai",31},
                          {"juin",30},
                          {"juillet",31},
                          {"aout",31},
                          {"septembre",30},
                          {"octobre",31},
                          {"novembre",30},
                          {"decembre", 31}
};

void nomMois31j();
int nombreJours(t_chaine9 nomMois);

int main(){;
    nomMois31j();
    printf("\n");
    //Demande à l'utilisateur du programme le nom d’un mois
    //affiche le nombre de jours de ce mois si la chaîne tapée par l’utilisateur est bien un nom de mois, et un message d’erreur sinon
    printf("Entrez un nom de mois : ");
    t_chaine9 nomMois ;
    scanf("%s" , nomMois) ;
    printf("\nLe nombre de jours pour %s est de %d\n" , nomMois, nombreJours(nomMois));
    return EXIT_SUCCESS;
}

void nomMois31j(){
    //procédure qui affiche le nom des mois de 31 jours
    printf("Liste des mois de 31 jours :\n");
    for (int i = 0 ; i<NM ;i++){
        if (tMois[i].c_nbJours==31){
            printf("%s ",tMois[i].c_nom);
        }
    }
}

int nombreJours(t_chaine9 nomMois) {
    //fonction qui délivre le nombre de jours du mois nomMois si nomMois est présent dans tMois et  -1 sinon
    int nb=-1;
    for (int i = 0 ; i<NM && nb ==-1; i++){
        if (strcmp(tMois[i].c_nom,nomMois)==0){
            nb=tMois[i].c_nbJours;
        }
    }
    return nb;
}