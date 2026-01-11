#include <stdio.h>

void ligne(int m, int j);

int main() {
    int m;
    int j;
    j = 1;
    m = 0;
    while (m<10)
    {
        ligne(m, j);
        m++;
        j++;
    }
    
    return 0;
}

void ligne(int m, int j) {
    int i = 0;
    while (i<j)
    {
        printf("%d\t ", m * i);
        i++;
    }
    printf("\n");
}