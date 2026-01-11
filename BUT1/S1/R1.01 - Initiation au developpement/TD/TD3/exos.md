# TD 3

## Exo 1

``` c
programme boucle c'est '
//Declaration des constantes
constante entier VAL:=10;
debut
    //Declaration des variables
    nb,resultat,compteur : entier;
    //Initialisation des variables
    //Saisie des donnees
    lireClavier(nb);
    //Traitement
    resulat:=0;
    compteur:=1;
    tant que (compteur <= nb) faire
        resulat:=resulat + VAL;
        compteur:=compteur: + 1
    finfaire 
    ecrireEcran(resultat);
fin
```

## Exo 2

``` c
programme 1_a_49 c'est '
//Declaration des constantes
constante entier VAL:=10;
constante entier SEUIL_INF:=1;
constante entier SEUIL_SUP:=49;
debut
    //Declaration des variables
    //Initialisation des variables
    //Saisie des donnees
    //Traitement
    tant que (SEUIL_INF > VAL ou SEUIL_SUP < VAL) faire
        Si (VAL<SEUIL_INF) faire
            ecrireEcran("Plus grand !");
        Sinon
            ecrireEcran("Plus petit !");
        finsi
    finfaire 
    ecrireEcran(VAL);
fin
```

## Exo 3

``` c
programme suite c'est '
//Declaration des constantes
constante entier FIN:=-1;
debut
    //Declaration des variables
    valeur,somme,compteur : entier;
    //Initialisation des variables
    compteur :=0;
    //Saisie des donnees
    ecrireEcran("Donnez votre suite de nb :");
    lireClavier(nb);
    //Traitement
    tant que (valeur != FIN) faire
        Si (valeur < FIN ) faire
            ecrireEcran("Erreur nb negatif");
        Sinon
            somme := somme + valeur;
            compteur := compteur + 1; 
        finsi
        lireClavier(valeur)
    finfaire 
    ecrireEcran("Votre suite de",valeur"nombres a pour somme :",somme );
fin
```

## Exo 4

``` c
programme suite c'est '
//Declaration des constantes
debut
    //Declaration des variables
    a,b,invit,gateaux : entier;
    //Initialisation des variables
    invit :=0;
    gateaux :=0;
    //Saisie des donnees
    ecrireEcran("Donnez le nombre de gateaux :");
    lireClavier(gateaux);
    ecrireEcran("Donnez le nombre de invités :");
    lireClavier(invit);
    //Traitement
    tant que (b>a) faire
        a:=a-b;
        invit:=invit+1;
    fin tant que
    Si (b=a) alors
        a:=a-b;
        invit:=invit+1;
    finsi
    gateaux:=a
    ecrireEcran("Il y a pour",invit" personnes et il restera :",gateaux,"gateaux" );
fin
```
