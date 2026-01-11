#include <stdio.h>
#include <stdlib.h>
int main() // Un essai de programme
{
// les variables du programme
char n[50], pr[50]; // au plus 50 caract`eres
printf("Votre nom : ");
scanf("%s",n); // l’utilisateur donne un nom
// mis dans la variable n
printf("Votre pr´enom : ");
scanf("%s",pr); // l’utilisateur donne un pr´enom
// mis dans la variable pr
printf("bonjour %s %s", pr, n);
return 0;
}