#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>
#include <sys/wait.h>

pid_t pid_enfant = 0;

void gerer_sigchld(int sig) {
    int statut;
    waitpid(-1, &statut, 0);
    printf("Processus enfant termine. Redemarrage...\n");
    
    pid_enfant = fork();
    if (pid_enfant == 0) {
        execl("/usr/bin/xeyes", "xeyes", NULL);
        perror("execl a echoue");
        exit(1);
    }
}

void gerer_sigusr1(int sig) {
    printf("SIGUSR1 reçu. Arret de l'enfant et sortie...\n");
    if (pid_enfant > 0) {
        kill(pid_enfant, SIGTERM);
    }
    exit(0);
}

int main() {
    struct sigaction sa_enfant, sa_usr1;
    
    // Configuration du gestionnaire SIGCHLD
    sa_enfant.sa_handler = gerer_sigchld;
    sigemptyset(&sa_enfant.sa_mask);
    sa_enfant.sa_flags = SA_RESTART;
    sigaction(SIGCHLD, &sa_enfant, NULL);
    
    // Configuration du gestionnaire SIGUSR1
    sa_usr1.sa_handler = gerer_sigusr1;
    sigemptyset(&sa_usr1.sa_mask);
    sa_usr1.sa_flags = SA_RESTART;
    sigaction(SIGUSR1, &sa_usr1, NULL);
    
    pid_enfant = fork();
    
    if (pid_enfant < 0) {
        perror("fork a echoue");
        exit(1);
    }
    
    if (pid_enfant == 0) {
        // Processus enfant
        execl("/usr/bin/xeyes", "xeyes", NULL);
        perror("execl a echoue");
        exit(1);
    } else {
        // Processus parent
        int compteur = 0;
        while (1) {
            printf("Passage num %d\n", compteur++);
            sleep(60);
        }
    }
    
    return EXIT_SUCCESS;
}
