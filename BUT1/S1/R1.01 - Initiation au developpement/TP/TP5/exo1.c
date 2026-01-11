#include <stdio.h>
#include <stdlib.h>

void division(int a,int b, int *adr_q,int *adr_r);

int main() {
    int a = 13,b =5,q,r;
    division(a,b,&q,&r);
    printf("%d / %d = %d x %d + %d",a,b,b,q,r);
    return EXIT_SUCCESS;
}

void division(int a,int b, int *adr_q,int *adr_r){
    *adr_r = a % b;
    *adr_q = a / b;
}