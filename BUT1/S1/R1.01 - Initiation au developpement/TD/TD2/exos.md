# TD 3
## Exo 2
### Question 2 :
```
programme prime_action c'est 
    //constante
    constante entier PRIME_1:=1000;
    constante entier PRIME_2:=2000;
debut
    //declaration variables
    prime,anciennete,salaire:entier;
    nom:chr;
    //initialisation variables
    //saisie des donnees
    ecrireEcran("Quel est votre nom ?);
    lireClavier(nom);
    ecrireEcran("Quel est votre salaire?);
    lireClavier(salaire);
    ecrireEcran("Quel est votre anciennete?);
    lireClavier(anciennete);
    //traitement des donnees
    Si (salaire<10000) et (anciennete>=10) alors
        prime:=PRIME_2;
    sinon
        prime:=PRIME_1;
    finsi
    //affichage resultat
    ecrireEcran("Vous avez",prime,"euros de prime.")
fin
```
### Question 1 :
```
programme prime_condition c'est 
    //constante
    constante entier PRIME_1:=1000;
    constante entier PRIME_2:=2000;
debut
    //declaration variables
    prime,anciennete,salaire:entier;
    nom:chr;
    //initialisation variables
    //saisie des donnees
    ecrireEcran("Quel est votre nom ?);
    lireClavier(nom);
    ecrireEcran("Quel est votre salaire?);
    lireClavier(salaire);
    ecrireEcran("Quel est votre anciennete?);
    lireClavier(anciennete);
    //traitement des donnees
    Si anciennete<10 alors
        prime:=PRIME_1;
    sinon
        si salaire >=10000 alors
            prime:=PRIME_1;
        sinon
            prime:=PRIME_2;
    finsi
    //affichage resultat
    ecrireEcran("Vous avez",prime,"euros de prime.")
fin
```
## Exo 3
### Question 1 :
```
programme minmax c'est
debut
    //Déclaration des variables
    a,b,c:entier;
    d:real;
    //Initialisation des variables
    ecrireEcran("Saisissez un nombre");
    lireEntier(a);
    ecrireEcran("Saisissez un autre nombre");
    lireEntier(b);
    ecrireEcran("Saisissez encore un nombre");
    lireEntier(c);
    //Traitement des données
    Si (a>b and a > c )alors
    ecrireEcran(a);
    Sinon
    si ((b>a)and(b>c))alors
    ecrireEcran(b);
    sinon
    ecrireEcran(c);
    finsi
    //Affichage du résultat sur l'écran
    ecrireEcran("Le plus petit nombre est ",min);
fin
```
## Exo 4
```
```