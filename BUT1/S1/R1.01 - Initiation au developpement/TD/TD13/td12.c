#include <stdio.h>
#include <stdlib.h>
#include <string.h> 
#include<stdbool.h>

// déclaration des constantes symboliques
#define MAX_MESSAGES 20
#define MAR_CAR 80 
// définition des types
typedef char t_message[MAR_CAR];

typedef struct 
{
    t_message message;
}t_element;

typedef struct
{
    t_element tabELT[MAX_MESSAGES];
    int nb;
}t_file;

// definition des constantes

const t_element ELTVIDE = {"----MESSAGE VIDE --------"};
// prototypes des fonctions
void afficheTous(t_file f);
t_file initialiser();
bool estVide(t_file f);
bool estPleine(t_file f);
void enfile(t_file *f,t_element elt);
// programme principal
int main(){
    // Declaration des variables
    t_file maFile;
    t_element elt;
    t_message msg;
    int choix;
    // initialisation
    maFile = initialiser();
    // ajouter quelques elements
    for (int i = 0 ; i<4 ; i++){
        sprintf(elt.message,"message %d", i);
        enfiler(&maFile, elt);
    }
    do{ // menu
        printf("----------------------------------------------------\n");
        printf("0 : quitter\n");
        printf("1 : afficher le nombre d'elements dans la file ?\n");
        printf("2 : ajouter un element a la file\n");
        printf("3 : retirer un element et afficher le message \n");
        printf("4 : afficher le message de la tete de file\n");
        printf("5 : vider la file\n");
        printf("6 : la file est-elle vide ?\n");
        printf("7 : la file est-elle pleine ?\n");
        printf("8 : supprimer les messages trop anciens\n");
        printf("9 : sauvegarde dans un fichier texte et vider\n");
        printf("10: lecture des messages du fichier texte\n");
        printf("votre choix : ");
        scanf("%d", &choix);
        printf("----------------------------------------------------\n");
        // traitement
        switch(choix){
            case -1 :   afficheTous(maFile);
            case 0:     break;
            case 1:     // afficher le nombre d'elements dans la file
                        break;
            case 2:     // ajouter un element (à donner aux étudiants)
                        break;
            case 3:    // retirer un element et afficher le message
                        break;
            case 4:    // afficher le message de la tete de file
                        break; 
            case 5:    // vider la file
                        break;
            case 6:    // la file est-elle vide ?
                         break;
            case 7:    // la file est-elle pleine ?
                        break;
            case 8:     // supprimer les messages trop anciens
                        break;
            case 9:     //sauvegarde dans un fichier texte et vider
                        break;
            case 10:    //lecture des messages du fichier texte
                        break;
            default :   printf("erreur de saisie\n");
        }
    }while(choix != 0);
    return EXIT_SUCCESS;
}
// Definitions des fonctions

void afficheTous(t_file f){
    for (int i = 0; i < f.nb; i++)
    {
        printf("%d\t%s\n",i,f.tabELT[i].message);
    }
    
}
t_file initialiser(){
    t_file f;
    for (int i = 0; i < MAX_MESSAGES; i++)
    {
        f.tabELT[i]=ELTVIDE;
    }
    f.nb=0;
    return f;
}
bool estVide(t_file f){
    return (f.nb==0);
}
bool estPleine(t_file f){
    return (f.nb==0);
}

void enfile(t_file *f, t_element elt){
    for (int i = 0; i < MAX_MESSAGES; i++)
    {
        if (estPleine(*f))
        {
            printf("file pleine");
        } else
        {
            f->tabELT[(*f).nb]=elt;
            f->nb++;
        }
        
    }
}

t_element defiler(t_file *f){
    t_element elt;

    if (estVide(*f))
    {
        printf("file vide");
        elt=ELTVIDE;
    }else
    {
        elt = f->tabELT[0];
        for (int i = 0; i < f->nb; i++)
        {
            f->tabELT[i] = f->tabELT[i+1];
        }
        f->tabELT[f->nb-1]=ELTVIDE;
        f->nb--;
    }
    return elt;
    
}