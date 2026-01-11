#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h> 

// déclaration des constantes symboliques
#define MAX_MESSAGES 20
#define MAX_CAR 80
// définition des types
typedef char t_message[MAX_CAR];
/*
b. Vous définirez 3 types utilisateurs :
•t_message : tableau de MAX_CAR caractères
•t_element :  une structure comportant UN message de type t_message (mais pas de date à ce 
stade)
•t_file : une structure comportant 2 champs :
tabElt : un tableau de t_element
nb : le nombre d’éléments valides du tableau.
c. Vous définirez une constante appelée ELTVIDE correspondant à un élément vide.
•Par exemple, l’élément comprend le message suivant : "------ce message est vide-------"*/
// definition des constantes
// prototypes des fonctions
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
bool estVide(t_file f) {
    return (f.nb == 0);_
}

bool estPleine(t_file f) {
    return (f.nb == MAX_MESSAGES);
}








vodi lectureFichier(t_file *adrFile,char nomFichier[]){
    
}