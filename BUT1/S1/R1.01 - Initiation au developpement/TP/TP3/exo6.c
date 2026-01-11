/**
 *@brief programme qui calcule et affiche le salaire net en fonction du salaire brut pour autant de personnes qu'on le souhaite, puis le salaire net moyen
*/
#include <stdio.h>
#include <stdlib.h>

int main() {
    char nom[20];
    double salaireBrut, salaireNetTotal = 0.0;
    int nombrePersonnes = 0;

    printf("Entrez le nom et le salaire brut pour chaque personne (tapez * pour terminer) :\n");

    while (1) {
        printf("Nom : ");
        scanf("%s", nom);

        if (nom[0] == '*') {
            break; // Sort de la boucle lorsque * est saisi comme nom
        }

        printf("Salaire brut pour %s : ", nom);
        scanf("%lf", &salaireBrut);

        double taux = 0.20; // Exemple de taux de charges
        double salaireNet = salaireBrut * (1 - taux);
        printf("Salaire net pour %s : %.2lf\n", nom, salaireNet);

        salaireNetTotal += salaireNet;
        nombrePersonnes++;
    }

    if (nombrePersonnes > 0) {
        double salaireNetMoyen = salaireNetTotal / nombrePersonnes;
        printf("Salaire net moyen : %.2lf\n", salaireNetMoyen);
    } else {
        printf("Aucune donnée saisie, impossible de calculer le salaire net moyen.\n");
    }

    return EXIT_SUCCESS;
}