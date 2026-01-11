#include <stdio.h>
#include <stdlib.h>

typedef char chaine20[20];
typedef struct
{
    chaine20 nom;
    chaine20 prenom;
    int age;
}t_etudiant;

void affiche (t_etudiant e);
void saisir (t_etudiant *e);
int compare(t_etudiant e1,t_etudiant e2);


int main() {
    t_etudiant etud1, etud2;
    int choix;
    do
    {
        printf("\n\nMenu:\n");
        printf("1: Ajouter un etudiant.\n");
        printf("2: Afficher des informations sur un etudiant.\n");
        printf("3: Comparer deux etudiants.\n");
        printf("4: Quitter.\n");
        printf("Votre choix ? ");
        printf("\n");
        scanf("%d",&choix);
        switch(choix)
        {
            case 1:
                saisir(&etud1);
                printf("\n");
                break;
            case 2:
                affiche(etud1);
                printf("\n");
                break;
            case 3:
                printf("\nETUDIANT 1 : \n");
                affiche(etud1);
                printf("\n");
                printf("\nETUDIANT 2 : \n");
                saisir(&etud2);
                printf("\n");
                printf("%d",compare(etud1,etud2));
                printf("\n");
                break;
        }
    } while (choix != 4);
    return EXIT_SUCCESS;
}

void affiche (t_etudiant e){
    printf("Etudiant : %s %s, %d ans.",e.prenom, e.nom, e.age);
}

void saisir (t_etudiant *e){
    printf("\nEntrez le nom de l'etudiant : ");
    scanf("%s", e->nom);
    printf("Entrez le prenom de l'etudiant : ");
    scanf("%s", e->prenom);
    printf("Entrez l'age de l'etudiant : ");
    scanf("%d",&(e->age));
}

int compare(t_etudiant e1,t_etudiant e2){
    //1 si e1 est plus vieux que e2
    if (e1.age > e2.age) {
        return 1;
    }
    //-1 si e2 est plus vieux que e1
    else if (e1.age<e2.age) {
        return -1;
    }
    //0 si les deux étudiants ont le même âge
    else{
        return 0;
    }
}