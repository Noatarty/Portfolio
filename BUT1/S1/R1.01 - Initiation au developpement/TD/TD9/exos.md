# Exos

## Exo 1

``` c
constante entier NB_LIG := 5 ;
constante entier NB_COL := 10;
type t_tablo = tableau [NB_LIG,NB_COL] de entier ;

procédure saisir(sortF tab:t_tablo) c'est '
    l,c:entier;
    pour l allant de 1 a NB_LIG faire
        pour c allant de 1 a NB_COL faire
            ecrire("Rentrer une valeur a la position ",l,c);
            lire(x);
            tab[l,c]:=x;
        finpour;
    finpour;
fin;

procédure affiche (entF tab:t_tablo) c'est'
    l,c:entier;
    pour l allant de 1 a NB_LIG faire
        pour c allant de 1 a NB_COL faire
            ecrire(" ",tab[l,c]);
        finpour;
        ecrire("\n");
    finpour;
    ecrire("\n");
fin;

programme test c'est '
procédure saisir(sortF tab:t_tablo);
procédure affiche (entF tab:t_tablo);
debut
    tableau:t_tablo;
    saisir(tableau);
    affiche(tableau);
fin;
```

## Exo 2

``` c
constante entier NB := 10;
type t_matrice_carree = tableau [NB,NB] de entier ;

fonction sommeDiagonale(entF tab:t_matrice_carree) délivre entier c'est'
debut
    lc,resulat:entier;
    resultat:=0;
    pour lc allant de 1 à NB faire
        resultat:=resultat+tab[lc,lc];
    finpour;
    retourne résultat;
fin;

procedure afficherTriangleSupGauche(entF mat:t_matrice_carree);
début
lr,lrmax:entier;
    lrmax:=mini(NB,NB-1);
    pour lr allant de 1 à lrmax faire
        pour lc allant de 1 à lr faire
            écrire(mat[lr,lc]," ");
        finpour;
        écrire("\n");
    finpour;
fin;

procedure echanger(entF/sortF tab:matrice_carree,entF lig:entier,entf col:entier)c'est '
début
    entier temp;
    temp:=tab[lig,col];
    tab[lig,col]:=tab[lig,col+1];
    tab[lig,col+1]:=temp;
fin;

procedure transpose(entF/sortF mat:t_matrice_carree) c'est'
// Proposez une procédure pour transposer une matrice contenue dans un tableau de type t_matrice_carree (sans utiliser d’autres tableaux)
début
    lig,col:entier;
    pour(lig de 2 a NB)faire
        pour(col de 1 a lig-1)faire
            echanger(mat,lig,col);
        finpour;
    finpour;
fin;
```

## Exo 3

``` c
constante entier NB_LIG := 3 ;
constante entier NB_COL := 4 ;
type t_ligne = tableau[NB_LIG] de entier ;
type t_colonne = tableau[NB_COL] de entier ;
type t_matrice = tableau[NB_LIG, NB_COL] de entier ;

procédure sommeLigneColonne(entF m : matrice, sortF sL : t_ligne, sortF sC :t_colonne) c'est '
début
    entier i, j;
    pour (i de 1 a NB_LIG) faire
        sL[i] := 0;
        sC[i] := 0;
    finpour;
    pour (j de 1 a NB_COL) faire
        pour (i de 1 a NB_LIG) faire
            sL[i] += m[i][j];
            sC[j] += m[i][j];
        finpour;
    finpour;
fin;
```

## Exo 4

``` c

```
