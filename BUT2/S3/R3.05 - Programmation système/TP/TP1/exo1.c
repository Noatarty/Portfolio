#include <fcntl.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

#define BUFFER_SIZE 4096

int main() {
    int fd_orig, fd_old, nb_lu;
    char buffer[BUFFER_SIZE];
    fd_orig = open("ORIG", O_RDONLY);
    if (fd_orig == -1) {
        perror("Erreur ouverture ORIG");
        exit(1);
    }

    fd_old = open("OLD", O_WRONLY | O_CREAT, 0644);
    if (fd_old == -1) {
        perror("Erreur ouverture/creation OLD");
        close(fd_orig);
        exit(1);
    }

    nb_lu = read(fd_orig, buffer, BUFFER_SIZE);
    write(fd_old, buffer, nb_lu);


    close(fd_orig);
    close(fd_old);

    printf("fichier copier.\n");
    return 0;
}