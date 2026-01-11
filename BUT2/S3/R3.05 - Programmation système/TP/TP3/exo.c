
#include <sys/types.h>
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <signal.h>
#include <sys/wait.h>
#include <errno.h>

void handler_sigchld(int sig) {
    wait(NULL);
}

int main() {
    pid_t pid;
    int val = 10;
    struct sigaction sa;

    // Configure signal handler
    sa.sa_handler = handler_sigchld;
    sigemptyset(&sa.sa_mask);
    sa.sa_flags = 0;
    sigaction(SIGCHLD, &sa, NULL);

    printf("Avant fork(), je suis PID %d", getpid());
    printf(" et val = %d\n", val);

    pid = fork();
    
    if (pid == -1) {
        perror("Erreur lors du fork");
        exit(EXIT_FAILURE);
    }
    
    if (pid == 0) { // Fils
        sleep(1);
        printf("Je suis le fils, mon PID est %d et mon pere a le PID %d\n", getpid(), getppid());
        printf("Chez le fils, val = %d\n", val);
        val = 20;
        _exit(EXIT_SUCCESS);
    } else { // Pere
        printf("Je suis le pere, mon PID est %d et je viens de creer un fils de PID %d\n", getpid(), pid);
        printf("Chez le père, val = %d\n", val);
        
        for (int i = 1; i <= 300; i++) {
            printf("Passage %d\n", i);
            sleep(1);
        }
    }

    printf("Je suis PID %d et val = %d\n", getpid(), val);
    return EXIT_SUCCESS;
}
