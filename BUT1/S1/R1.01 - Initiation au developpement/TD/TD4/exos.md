# TD 3

## Exo 1

``` c
programme puissance c'est '
//Declaration des constantes
debut
    //Declaration des variables
    n,i : entier;
    x,resultat : reel;
    //Initialisation des variables
    resultat := 1;
    i := 1;
    //Saisie des donnees
    ecrireEcran("Entrez la valeur de x : ");
    lireClavier(x);
    faire
        ecrireEcran("Entrez la valeur de n : ");
        lireClavier(n);
    tant que (n<0);
    //Traitement
    tant que (i <= n) faire
        resultat = resultat * x;
        i:=i+1;
    finfaire 
    ecrireEcran("Le résultat de x**n est : ", resultat);
fin
```

## Exo 2

``` c
programme rectangle c'est '
//Declaration des constantes
debut
    //Declaration des variables
    nbLig,nbCol,l,c : entier;
    //Initialisation des variables
    l:=0;
    c:=0;
    //Saisie des donnees
    faire
        ecrireEcran("Entrez le nombre de lignes : ");
        lireClavier(nbLig);
    tant que (nbLig<0);
    faire
        ecrireEcran("Entrez le nombre de colonnes : ");
        lireClavier(nbCol);
    tant que (nbCol<0);
    ecrireEcran("Entrez la valeur de x : ");
    lireClavier(x);
    ecrireEcran("Entrez la valeur de n : ");
    lireClavier(n);
    //Traitement
    tant que (l <= nbLig) faire
        tant que (c <= nbCol) faire
            ecrireEcran("*");
            l:=l+1;
        finfaire
        ecrireEcran("\n");
        c:=c+1;
    finfaire 
fin
```

## Exo 3

### Exo 3.1

``` c
programme multiplication c'est '
//Declaration des constantes
debut
    //Declaration des variables
    n,resultat,i : entier;
    //Initialisation des variables
    i := 0;
    //Saisie des donnees
    faire
        ecrireEcran("Entrez un entier entre 0 et 9 : ");
        lireClavier(n);
    tant que (n<0 OU n > 9);
    //Traitement
    tant que (i < 10) faire
        resultat = n * 1;
        i:=i+1;
        ecrireEcran(resultat,"\t");
    finfaire 
fin
```

### Exo 3.2

``` c
programme table c'est '
//Declaration des constantes
debut
    //Declaration des variables
    nbMulti,nbEntierMin,nbEntierMax,resultat : entier;
    //Initialisation des variables
    i := 0;
    nbMulti := 0;
    //Saisie des donnees
    ecrireEcran("Valeur minimale entiere: ");
    lireClavier(nbEntierMin);
    faire
        ecrireEcran("Valeur maximum entiere: ");
        lireClavier(nbEntierMax);
    tant que (nbEntierMax<nbEntierMin);
    //Traitement
    tant que (nbEntierMin <= nbEntierMax) faire
        tant que (nbMulti <= 9) faire
            resultat := nbEntierMin * nbMulti;
            ecrireEcran(resultat,"\t");
            nbMulti:=nbMulti+1;
            finfaire
        nbEntierMin:=nbEntierMin+1;
    finfaire
fin
```

## Exo 4

``` c
programme moyenne c'est '
//Declaration des constantes
debut
    //Declaration des variables
    //Initialisation des variables
    //Saisie des donnees
    //Traitement
    
fin
```
