#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

const float MAXI = 20.00;
const float MINI = 0.00;
//le concours peut acceuiller jusu'a 1000 candidats
#define MAX 1000
typedef float tabNotes[MAX];

//proto
void init(tabNotes t);
void saisirNotes(tabNotes t,int * nbInscrits);
void bonus(tabNotes t, int nbInscrits,int indice,int bonus);
float moyenne(tabNotes t,int nbInscrits);
void testeMoyenne();
bool rechercher(tabNotes t,int nbInscrits,int note);
void supprimerNote(tabNotes t,int nbInscrits,int indice);
void repartition(tabNotes t,int nbInscrits);

//Q9
int main(){
    //initialise un tab de notes
    tabNotes t;
    int nbInscrits=0;
    init(t);
    //execute testeMoyenne
    testeMoyenne();
    //execute saisirNotes
    printf("Saisie des notes:\n");
    saisirNotes(t,&nbInscrits);
    //supprime la note du candidat 0
    supprimerNote(t,nbInscrits,-1);
    //ajoute un bonus de 2 points au candidat 1
    bonus(t,nbInscrits,1,2);
    //indique si un candidat a eu 20
    if (rechercher(t,nbInscrits,20)) {
        printf("Un candidat a obtenu 20\n");
    }else {
        printf("Aucun candidat ne l'a obtenu.\n");
    }
    //affiche la moyenne
    printf("\nLa moyenne est %f",moyenne(t,nbInscrits));
    //affiche la répartition des notes
    repartition(t,nbInscrits);
    return EXIT_SUCCESS;
}


//Q1
void init(tabNotes t){
    int i;
    for (i = 0 ; i<MAX ; i++) {
        t[i] = -1;
    }
}

//Q2
void saisirNotes(tabNotes t,int * nbInscrits){
    //saisit le nombre d'inscrits puis la note de chaque candidat (-1 si il est absent), les notes seront a stockés dans le tableau t
    //la procédure vérifie que la note est comprise entre 0.00 et 20.00 (ou égale a -1) et redemandera la saisie en cas d'erreur
    printf("Saisir le nombre d'inscrits : ");
    scanf("%d", nbInscrits);

    for(int i = 0; i < *nbInscrits; i++){
        bool validNote = false;

        while(!validNote){
            printf("Saisir la note du candidat %d : ", i+1);
            scanf("%f", &t[i]);

            if(t[i] >= MINI && t[i] <= MAXI){
                validNote = true;
            } else if(t[i] == -1){
                validNote = true;
            } else {
                printf("Note invalide, elle doit etre comprise entre %f et %f (ou -1 pour absent).\n", MINI, MAXI);
            }
        }
    }
}

//Q3
void bonus(tabNotes t, int nbInscrits,int indice,int bonus){
    if(indice<0 || indice >=nbInscrits){
        printf("Erreur: L'indice est invalide.\n");
        return;
    }
    if(t[indice] == -1){
        printf("Erreur: Le candidat n'a pas de note.\n");
        return;
    }
    t[indice] += bonus;
    if(t[indice] > MAXI){
        t[indice] = MAXI;
    }
}

//Q4
float moyenne(tabNotes t,int nbInscrits){
    float somme = 0;
    int nbNotesValides = 0;
    for(int i = 0; i < nbInscrits;i++){
        if(t[i] != -1){
            somme+=t[i];
            nbNotesValides++;
        }
    }
    if(nbNotesValides < nbInscrits){
        return -1.00;
    }
    float moy = 0.0;
    moy = somme/nbNotesValides;
    return moy;
}

//Q5
void testeMoyenne(){
    int nbInscrits = 0;
    tabNotes t1 ={};
    printf("Test1 valeur attendue -1.00 \n valeur obtenue");
    moyenne(t1,nbInscrits);
    
    nbInscrits = 1;
    tabNotes t2 ={4.0};
    printf("Test2 valeur attendue 4.00 \n valeur obtenue");
    moyenne(t2,nbInscrits);

    nbInscrits = 3;
    tabNotes t3 ={15.8,-1,5.2};
    printf("Test3 valeur attendue 10.50 \n valeur obtenue");
    moyenne(t3,nbInscrits);

    nbInscrits = 4;
    tabNotes t4 ={11.0,12.0,13.0,14.0};
    printf("Test3 valeur attendue 12.50 \n valeur obtenue");
    moyenne(t4,nbInscrits);
}

//Q6
bool rechercher(tabNotes t,int nbInscrits,int note){
    for(int i = 0; i < nbInscrits;i){
        if(t[i] == note){
            return true;
        }
        else{
            i++;
        }
    }
}

//Q7
void supprimerNote(tabNotes t,int nbInscrits,int indice){
    if(indice >= 0 && indice <= nbInscrits-1){
        t[indice] = -1;
    }else {
        printf("Erreur, indice invalide");
    }
}

//Q8
void repartition(tabNotes t,int nbInscrits){
    int nb0a5 = 0;
    int nb5a10 = 0;
    int nb10a15 = 0;
    int nb15a20 = 0;
    for(int i=0; i<nbInscrits ; i++){
        if(t[i] >= 0 && t[i] <= 5){
            nb0a5++;
        }else if(t[i] > 5 && t[i] <= 10){
            nb5a10++;
        }else if(t[i] > 10 && t[i] <=15){
            nb10a15++;
        }else if(t[i] > 15 && t[i] <= 20){
            nb15a20++;
        }
    }
    printf("\nrepartition des notes (%d inscrits,%d notes saisies)\n",nbInscrits,nbInscrits);
    printf("[ 0, 5] : %*s\n",nb0a5,'*');
    printf("[ 5, 10] : %*s\n",nb5a10,'*');
    printf("[ 10, 15] : %*s\n",nb10a15,'*');
    printf("[ 15, 20] : %*s\n",nb15a20,'*');
}