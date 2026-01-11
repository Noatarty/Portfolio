#include <stdio.h>
#include <stdlib.h>
#include <sys/ipc.h>
#include <sys/sem.h>
#include <unistd.h>

void create_semaphore() {
    key_t key = ftok("test_sempahores.c", 65);
    int semid = semget(key, 1, 0666 | IPC_CREAT);
    semctl(semid, 0, SETVAL, 1);
    printf("Semaphore created with ID: %d\n", semid);
}

void consume_semaphore(int semid) {
    struct sembuf sb;
    while (1) {
        printf("Avant conso\n");
        sb.sem_num = 0;
        sb.sem_op = -1; // Wait (P operation)
        sb.sem_flg = 0;
        semop(semid, &sb, 1);

        printf("Après conso\n");
        printf("Prêt à libérer ? (appuyez sur Entrée)\n");
        getchar(); // Read response

        printf("Avant libération\n");
        sb.sem_op = 1; // Signal (V operation)
        semop(semid, &sb, 1);
        printf("Après libération\n");
    }
}

int main() {
    create_semaphore();
    return 0;
}
