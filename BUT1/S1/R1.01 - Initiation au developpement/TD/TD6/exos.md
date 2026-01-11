# TD 6

## Exo 1

```c
procedure pSomme(entF borne1:entier, entF borne2:entier, sortF res :entier) c’est
debut
    i ,som : entier ;
    som := 0 ;
    i := borne1 ;
    tant que (i <= borne2) faire
        som := som+i;
        i:=i+1 ;
    finfaire
    resultat := som ;
fin

fonction pSomme(entF borne1:entier, entF borne2:entier, sortF resultat :entier) délivre entier c’est
debut
    i ,som : entier ;
    som := 0 ;
    i := borne1 ;
    tant que (i <= borne2) faire
        som := som+i;
        i:=i+1 ;
    finfaire
    resultat := som ;
    retourne resultat
fin

programme somme c'est '
debut
    res,borne1,borne2 : entier;
    borne1 := 3;
    borne1 := 7;
    //fonction
    res := pSomme(entE borne1,entE borne2);
    //procédure
    res := pSomme(entE borne1,entE borne2,sortE res);
    ecrire(res);
fin
```

## Exo 2

```c
fonction fMoyenne(entF note1:entier, entF note2:entier) délivre réel c’est
debut
    moyenne : réel;
    moyenne := (note1+note2)/2.0;
    retourne moyenne
fin

promgramme moyenne c'est '
debut
    moyenne : réel;
    note1,note2 : entier;
    ecrire("note1");
    lire("note1");
    ecrire("note2");
    lire("note2");
    moyenne:=fMoyenne(entE note1, entE note2);
    ecrire(moyenne);
```

## Exo 4

```c

```
