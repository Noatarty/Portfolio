#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>
#include <time.h>

typedef struct {
    float latitude;
    float longitude;
    float elevation;
} pointGPS;

void afficherPoint(pointGPS p){
    printf("%.3f    %.3f    %.3f\n", p.latitude, p.longitude, p.elevation);
}

void lister(char nomFic[]) {
    FILE* fichier;
    pointGPS p;
    int i;
    i = 0;

    printf("Nom du fichier ? ");
    scanf("%s", nomFic);

    fichier = fopen(nomFic, "rb");
    if (fichier == NULL) {
        printf("Erreur d'ouverture du fichier\n");
        exit(EXIT_FAILURE);
    }
    printf("                    Lat.    Long.   Alt.\n");
    while (fread(&p, sizeof(pointGPS), 1, fichier) == 1) {
        printf("Point %d :          ",i+1);
        afficherPoint(p); 
        i++;
    }
    fclose(fichier);
}

float sommet(char nomFic[]) {
    FILE* fichier;
    printf("Nom du fichier ? ");
    scanf("%s", nomFic);
    fichier = fopen(nomFic, "rb");
    if (fichier == NULL) {
        printf("Erreur d'ouverture du fichier\n");
        exit(EXIT_FAILURE); 
    }

    pointGPS p;
    float maxElevation = 0;

    while (fread(&p, sizeof(pointGPS), 1, fichier) == 1) {
        if (p.elevation > maxElevation) {
            maxElevation = p.elevation;
        }
    }

    fclose(fichier);
    return maxElevation;
}

void departEtArrivee(char nomFic[]) {
  FILE* fichier;
  pointGPS deb, fin;

  printf("Nom du fichier ? ");
  scanf("%s", nomFic);

  fichier = fopen(nomFic, "rb");
  if (fichier == NULL) {
    printf("Erreur d'ouverture du fichier\n");
    exit(EXIT_FAILURE);
  }

  if(fread(&deb, sizeof(pointGPS), 1, fichier) != 1) {
    printf("Fichier vide\n");
    return;
  }

  while(fread(&fin, sizeof(pointGPS), 1, fichier) == 1);

  printf("Premier point : \n");
  afficherPoint(deb);

  printf("Dernier point : \n");
  afficherPoint(fin);

  fclose(fichier);
}

void ajouterPoint(char nomFic[]) {
    FILE* fichier;
    printf("Nom du fichier ? ");
    scanf("%s", nomFic);
    fichier = fopen(nomFic, "ab");
    if (fichier == NULL) {
        printf("Erreur d'ouverture du fichier\n");
        exit(EXIT_FAILURE);
    }
    pointGPS p;
    printf("Latitude ? ");
    scanf("%f", &p.latitude);
    printf("Longitude? ");
    scanf("%f", &p.longitude);
    printf("Altitude ? ");
    scanf("%f", &p.elevation);
    fwrite(&p, sizeof(pointGPS), 1, fichier);
    fclose(fichier);
}

void fusionner(char nomFic1[], char nomFic2[],char nomFic3[]) {
    FILE* fichier1, *fichier2, *fichier3;
    printf("Nom du fichier 1? ");
    scanf("%s", nomFic1);
    fichier1 = fopen(nomFic1, "rb");
    if (fichier1 == NULL) {
        printf("Erreur d'ouverture du fichier\n");
        exit(EXIT_FAILURE);
    }
    printf("Nom du fichier 2? ");
    scanf("%s", nomFic2);
    fichier2 = fopen(nomFic2, "rb");
    if (fichier2 == NULL) {
        printf("Erreur d'ouverture du fichier\n");
        exit(EXIT_FAILURE);
    }
    printf("Nom du fichier 3? ");
    scanf("%s", nomFic3);
    fichier3 = fopen(nomFic3, "wb");
    if (fichier3 == NULL) {
        printf("Erreur d'ouverture du fichier\n");
        exit(EXIT_FAILURE);
    }
    pointGPS p1, p2;
    while (fread(&p1, sizeof(pointGPS), 1, fichier1) == 1) {
        fwrite(&p1, sizeof(pointGPS), 1, fichier3);
        while (fread(&p2, sizeof(pointGPS), 1, fichier2) == 1) {
            if (p1.latitude == p2.latitude && p1.longitude == p2.longitude) {
                fwrite(&p2, sizeof(pointGPS), 1, fichier3);
            }
        }
    }
    fclose(fichier1);
    fclose(fichier2);
    fclose(fichier3);
    printf("Fichiers fusionnés\n");
    return EXIT_SUCCESS;
}

int main(){
    char nomListe[30];
    float maxElevation;
    //Tests
    pointGPS p1 = {48.8582, 2.2945, 100.0};
    afficherPoint(p1);
    //Appel lister
    lister(nomListe);
    //Appel sommet
    maxElevation = sommet(nomListe);
    printf("La hauteur du plus haut point est de %.3f\n", maxElevation);
    //Appel depart et arrivee
    departEtArrivee(nomListe);
    //Appel ajouterpoint
    ajouterPoint(nomListe);
    lister(nomListe);
    return EXIT_SUCCESS;
}