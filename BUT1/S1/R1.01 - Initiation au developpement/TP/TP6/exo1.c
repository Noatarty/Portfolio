#include <stdlib.h>
#include <stdio.h>
#include <math.h>

float fcalcul(int v1, int v2);
void test();

int main() {
    int v1, v2;
    float resultat;
    test();
    printf("Veuillez saisir la valeur du premier cote: ");
    scanf("%d", &v1);

    printf("Veuillez saisir la valeur du deuxieme cote: ");
    scanf("%d", &v2);

    resultat = fcalcul(v1, v2);

    printf("L'hypotenuse est : %.2f\n", resultat);

    return EXIT_SUCCESS;
}

float fcalcul(int v1, int v2) {
    float hypothenuse;

    hypothenuse = sqrtf(v1 * v1 + v2 * v2);

    return hypothenuse;
}

void test(){
    printf("valeur attendue : %.3f     valeur obtenue : %.3f\n",5.0,fcalcul(3,4));
    printf("valeur attendue : %.3f     valeur obtenue : %.3f\n",1.414,fcalcul(1,1));
    printf("valeur attendue : %.3f     valeur obtenue : %.3f\n",0.0,fcalcul(0,0));
    printf("valeur attendue : %.3f     valeur obtenue : %.3f\n",3.606,fcalcul(2,3));
    printf("valeur attendue : %.3f     valeur obtenue : %.3f\n",10.630,fcalcul(7,8));
}