# Notes

## Exo 1

``` c
procédure tableMultiplication(entF n:entier) c'est '
    Debut
        i:entier;
        pour (i de 0 à 9 [pas de 1]) faire
            Ecrire(i * n);
        Finfaire
    Fin
programme Multplication c'est '
procédure tableMultiplaction(entF n:entier)
debut
    n:entier
    ecrire("Quelle table voulez-vous ?")
    lire(n)
    tableMultiplication(entF n)
fin
```

## Exo 2

```c
procédure remplirTableau(sortF tab:tableau[] de entier) c'est'
debut
    i:entier;
    valeur:entier;
    pour (i de 0 à MAX) faire
        ecrire("entrez la valeur"+i+"du tableau");
        lire(tab[i]);
    finfaire
fin
procédure afficheTableau(entF tab:tableau[] de entier,entF nbElt: entier) c'est'
début
    i:entier;
    pour (i de 1 a nbElt) faire
        ecrire(tab[i]," ");
    finfaire
fin
programme Tableaux c'est'
procédure afficheTableau(entF tab:tableau[] de entier,entF nbElt: entier);
debut
    nbelt:entier;
    tab:tableau;
    ecrire("Combien de valeurs voulez vous ?");
    lire(nbelt);
    afficheTableau(entE nbElt,entE tab);
fin
Procédure remplace(entF tab:tableau[] de entier,entF nbelt:entier,entF n:entier)c'est '
début
    compteur=0 entier;
    i:entier;
    pour (i de 0 à nbelt - 1) faire
        si(tab[i]==0)alors
            tab[i]=1
        finsi
    finpour
fin

```
