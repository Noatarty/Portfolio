#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>

int main() {
    int fd;
    char c;
    fd = open("mon_tube", O_RDONLY);
    if (fd == -1) {
        perror("Erreur d'ouverture du tube");
        exit(EXIT_FAILURE);
    }
    close(fd);
    return 0;
}