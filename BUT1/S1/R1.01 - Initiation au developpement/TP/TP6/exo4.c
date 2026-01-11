#include <stdlib.h>
#include <stdio.h>

float somme(float a, float b);
float soustraire(float a, float b);
float multiplication(float a, float b);
float division(float a, float b);
void test(float v);

int main() {
    float resultat;
    resultat = somme(4.2, multiplication(5.3, somme(division(somme(4.5, 1.3), 2.0), 1.1)) );
    resultat = soustraire(resultat, 1.0);
    test(resultat);
    printf("Resultat: %.2f\n", resultat);
    return EXIT_SUCCESS;
}

float somme(float a, float b) {
    return a + b;
}
float soustraire(float a, float b) {
    return a - b;
}
float multiplication(float a, float b) {
    return a * b;
}
float division(float a, float b) {
    return a / b;
}

void test(float v){
    printf("valeur attendue : %.3f     valeur obtenue : %.3f\n",24.4,v);
}
