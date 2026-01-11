#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

int main(int argc, char *argv[]) {
    const char *fifoPath = "mon_tube"; // Nom du tube nommé
    FILE *fifo;

    // Ouvrir le tube nommé en écriture
    fifo = fopen(fifoPath, "w");
    if (fifo == NULL) {
        perror("Erreur d'ouverture du tube nommé");
        return EXIT_FAILURE;
    }

    // Détournement du signal SIGPIPE
    signal(SIGPIPE, SIG_IGN);

    // Envoyer chaque argument au tube nommé
    for (int i = 1; i < argc; i++) {
        sleep(1); // Assurer que le lecteur a eu le temps de fermer le tube
        if (fprintf(fifo, "%s\n", argv[i]) < 0) {
            perror("Erreur lors de l'écriture dans le tube nommé");
            break;
        }
    }

    // Fermer le tube nommé
    fclose(fifo);
    return EXIT_SUCCESS;
}  
