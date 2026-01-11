#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX 100

typedef char t_chaine50[51] ;
typedef char t_chaine10[11] ;

typedef struct{ 
    t_chaine50 c_nom;   // nom de l’abonne
    t_chaine10 c_num; // numero de cet abonne
    int c_duree; // duree pour laquelle il est abonne
   } t_abonne ;

typedef t_abonne t_tabAbo[MAX];

void creer(char nomFic[]);
void lister(char nomFic[]);
void ajouter(char nomFic[]);
void afficher_menu();
int copierFichierDansTableau(char nomFichier[], t_tabAbo t);
void permuter(t_abonne* a1, t_abonne* a2);
void maintientTrie(t_tabAbo t, int i);
void copierTableauDansFichier(char nomFic[], t_tabAbo t, int nb);

int main() {
    int choix;
    char nomFic[51];
    t_tabAbo t;
    int i,nb;
    i = 0;
    nb = 0;
    while(1) {
        afficher_menu();
        printf("Entrez votre choix: ");
        scanf("%d", &choix);
        printf("\n");
        switch(choix) {
            case 1:
                printf("Entrez le nom du fichier: ");
                scanf("%s", nomFic);
                creer(nomFic);
                printf("\n");
                break;
            case 2:
                printf("Entrez le nom du fichier: ");
                scanf("%s", nomFic);
                lister(nomFic);
                printf("\n");
                break;
            case 3:
                printf("Entrez le nom du fichier: ");
                scanf("%s", nomFic);
                ajouter(nomFic);
                printf("\n");
                break;
            case 4:
                printf("Entrez le nom du fichier a trier: ");
                scanf("%s", nomFic);
                // Copier le fichier dans le tableau
                nb = copierFichierDansTableau(nomFic, t);
                // Si le nombre d'abonnes est superieur a 0, effectuer le tri
                if (nb > 0) {
                    for (i = 1; i < nb; i++) {
                        maintientTrie(t, i);
                    }
                    // Copier le tableau trie dans le fichier
                    copierTableauDansFichier(nomFic, t, nb);
                    printf("Le fichier a ete trie avec succès.\n");
                } else {
                    printf("Le fichier est vide ou n'a pas pu être ouvert.\n");
                }

                printf("\n");
                break;
            case 0:
                return EXIT_SUCCESS;
            default:
                printf("Choix incorrect\n");
        }
    }
    return EXIT_SUCCESS;
}

void creer(char nomFic[]) {   // creation d'un fichier contenant les renseignements sur les abonnes
    FILE * f = fopen(nomFic, "w");
    t_abonne a;
    char rep[51];
    if(f == NULL) {
        printf("Erreur lors de la creation du fichier\n");
        exit(EXIT_FAILURE);
    }
    do {
        printf("Entrez le nom de l'abonne, le numero, la duree de l'abonnement, et entrez '*' pour terminer\n");
        scanf("%s %s %d", a.c_nom, a.c_num, &a.c_duree);
        fwrite(&a, sizeof(t_abonne), 1, f);
        printf("Voulez-vous ajouter un autre abonne ? (oui/non)\n");
        scanf("%s", rep);
    } while(strcmp(rep, "oui") == 0);
    fclose(f);
}

void lister(char nomFic[]) {   // liste le contenu du fichier de
                              //nom nomFic
    FILE * f = fopen(nomFic, "r");
    t_abonne a;
    if(f == NULL) {
        printf("Erreur lors de l'ouverture du fichier\n");
        return;
    }
    while(fread(&a, sizeof(t_abonne), 1, f) == 1) {
        printf("Nom: %-9s Numero: %s Duree: %d mois\n", a.c_nom, a.c_num, a.c_duree);
    }
    fclose(f);
}

void ajouter(char nomFic[]) {   // ajoute de nouveaux abonnes a la fin du fichier
    FILE * f = fopen(nomFic, "a");
    t_abonne a;
    if(f == NULL) {
        printf("Erreur lors de l'ouverture du fichier\n");
        return;
    }
    printf("Entrez le nom de l'abonne, le numero, la duree de l'abonnement\n");
    scanf("%s %s %d", a.c_nom, a.c_num, &a.c_duree);
    fwrite(&a, sizeof(t_abonne), 1, f);
    fclose(f);
}

void afficher_menu() {
    printf("1. Creer un fichier\n");
    printf("2. Lister un fichier\n");
    printf("3. Ajouter a un fichier\n");
    printf("\n");
    printf("A FAIRE\n");
    printf("4. Trier un fichier\n");
    printf("5. Afficher le numero d'un abonne\n");
    printf("6. Prolonger l'abonnement\n");
    printf("7. Prolonger l'abonnement d'un abonne\n");
    printf("8. Supprimer un abonne\n");
    printf("0. Quitter\n");
}


int copierFichierDansTableau(char nomFichier[], t_tabAbo t) {
    FILE* f = fopen(nomFichier, "r");
    t_abonne a;
    int nb = 0;

    if (f == NULL) {
        printf("Erreur lors de l'ouverture du fichier\n");
        return 0;
    }

    while (fread(&a, sizeof(t_abonne), 1, f) == 1) {
        t[nb] = a;
        nb++;
    }

    fclose(f);
    return nb;
}

void permuter(t_abonne* a1, t_abonne* a2) {
    t_abonne temp = *a1;
    *a1 = *a2;
    *a2 = temp;
}

void maintientTrie(t_tabAbo t, int i) {
    int j = i;
    while (j > 0 && strcmp(t[j].c_nom, t[j - 1].c_nom) < 0) {
        permuter(&t[j], &t[j - 1]);
        j--;
    }
}

void copierTableauDansFichier(char nomFic[], t_tabAbo t, int nb) {
    FILE* f = fopen(nomFic, "w");

    if (f == NULL) {
        printf("Erreur lors de l'ouverture du fichier\n");
        exit(EXIT_FAILURE);
    }

    for (int i = 0; i < nb; i++) {
        fwrite(&t[i], sizeof(t_abonne), 1, f);
    }

    fclose(f);
}