#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>


int main() {
    int loop;
    for (loop = 0; loop < 600; loop++) {
        printf("PID %d - Passage %d\n", getpid(), loop);
        sleep(1);
    }
    return EXIT_SUCCESS;
}