# include <stdio.h>
# include <stdlib.h>
# include <string.h>

// les constantes symboliques
#define MAX_ANNONCES 3000 //taille maximale du tableau des annonces automobiles
#define MAX_LIGNES 200 //taille maximale d’une ligne lors de la lecture du fichier texte
#define MAX_CHAMP 100 //taille maximale des champs de données
// les types
typedef char t_lignes[MAX_LIGNES];
typedef char t_champ[MAX_CHAMP];
typedef struct {
    int id;
    t_champ marque;
    t_champ designation;
    int annee;
    int km;
    int prix;
} t_annonce;
typedef struct {
    t_annonce tab_annonces[MAX_ANNONCES];
    int nb;
} t_stock;
// les prototypes des fonctions
void initStock(t_stock *adr_stock); //Initialisation du stock (toutes les annonces seront initialisées)
void lectureTexte1(t_stock *adr_stock,char nomFichier[]); //Lecture du fichier texte avec suppression des caractères espace dans les champs
void lectureTexte2(t_stock *adr_stock,char nomFichier[]); //Lecture du fichier texte sans suppression des caractères espace dans les champs
void lectureTexte3(t_stock *adr_stock,char nomFichier[]); //Lecture du fichier texte avec définition de variables locales pour le tableau des annonces
void afficheAnnonces(const t_stock *adr_stock); //Affichage des annonces
void afficheAnnoncesMarque(const t_stock *adr_stock, const char *marque); //Affichage des annonces d’une marque spécifique
void sauvegardeBinaire(const t_stock *adr_stock, const char *nomFichier); //Sauvegarde des annonces dans un fichier binaire
void lectureBinaire(t_stock *adr_stock, const char *nomFichier); //Lecture des annonces depuis le fichier binaire
void saisieAnnonce(t_annonce *a); //Saisie d’une nouvelle annonce
void ajoutAnnonceFichierBinaire(const t_annonce *a, const char *nomFichier); //Ajout une nouvelle annonce dans le fichier binaire
// les constantes
t_annonce ANNONCE_VIDE = {-1,"sans_marque","sans_designation",-1,0,0};
// le programme principal
int main(){
    t_stock stock_auto;
    t_annonce annonce;
    int choix = -1;
    // initialisation des structures
    initStock(&stock_auto);
    // menu
    while(choix != 0){
        printf("---------------------------------------------------------------------\n");
        printf("1 : lire le fichier texte des annonces (pas d'espace dans les champs)\n");
        printf("2 : lire le fichier texte des annonces \n");
        printf("3 : lire le fichier texte des annonces (variables locales)\n");
        printf("4 : afficher les annonces\n");
        printf("5 : afficher les annonces d'une marque\n");
        printf("6 : sauvegarder les annonces dans un fichier binaire\n");
        printf("7 : lire le fichier binaire des annonces\n");
        printf("8 : ajouter une annonce dans le fichier binaire\n");
        printf("9 : supprimer une annonce\n");
        printf("votre choix :");
        scanf("%d", &choix);
        switch(choix){
            case 0: break;
            case 1: 
                    break;
            case 2: 
                    break;
            case 3: 
                    break;
            case 4: 
                    break;
            case 5: 
                    break;
            case 6: 
                    break;
            case 7: 
                    break;
            case 8: 
                    
                    break;
            default: printf("erreur de choix\n");
        }
    }
    return EXIT_SUCCESS;
}

void initStock(t_stock *adr_stock){
    adr_stock->nb = 0;
    for (int i = 0; i < MAX_ANNONCES; i++){
        adr_stock->tab_annonces[i] = ANNONCE_VIDE;
    }
}

void lectureTexte1(t_stock *adr_stock,char nomFichier[]){
    FILE* fich_annonces;
    char ligne[512];

    fich_annonces = fopen(nomFichier, "r");
    fgets(ligne,MAX_LIGNES,fich_annonces); //lecture première ligne

    while (! feof(fich_annonces)){
        //remplacer les epaces par _
        sscanf(ligne,"%d %s %s %d %d %d",...);
    }
    
}