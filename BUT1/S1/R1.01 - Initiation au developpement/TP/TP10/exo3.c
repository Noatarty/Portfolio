#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX 198 // 22 équipes de 9 coureurs = 198 coureurs
typedef struct{
    int c_numero;
    int c_temps;
}t_concurrent;
typedef t_concurrent t_tabconc[MAX];

void insere( t_concurrent c, t_tabconc tc, int n );
void permuter(t_concurrent* c1, t_concurrent* c2);

int main(){
    return EXIT_SUCCESS;
}

void insere( t_concurrent c, t_tabconc tc, int n ){
    //insère le concurrent c à sa « vraie place » dans le tableau tc  déjà rempli de n concurrents 
    //déjà classés. Pour cela, vous placerez c dans tc[n], puis vous le ferez « remonter » à sa vraie 
    //place (méthode par permutation).Pour permuter tc[j] et tc[j-1], vous utiliserez la procédure permuter
    //qui est définie ci-dessous.La fonction ne doit pas modifier l’argument c.
    int i=0;
    if(tc[i].c_numero > c.c_numero) {
        tc[i]=c;
        while((i<n) && (tc[i+1].c_numero < c.c_numero)) {
            tc[i+1]=tc[i];
            i++;
        }
        tc[i]=c;
    } else {
        printf("Erreur d'insertion\n");
    }
}
void permuter(t_concurrent* c1, t_concurrent* c2){
    //permute les concurrents *c1 et  *c2. Notez bien que la permutation se fait globalement, et non pas champ par champ
    
}