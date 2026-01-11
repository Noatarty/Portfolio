# TD 5

## Exo 1

``` c
programme moyenne c'est '
//Declaration des constantes
// entete procédure (Q1)
procédure afficheMoy2Notes(entF note1 : réel, entF note2 : réel);
//programme principal (Q2)
debut
    //Declaration des variables
    note1,note2:entier
    //Initialisation des variables
    note1 := 1;
    note2 := 1;
    //Saisie des donnees
    ecrire("entrez la premiere note");
    lire(note1);
    ecrire("entrez la deuxieme note");
    lire(note2);
    //Traitement
    //appel procédure
    afficheMoy2Notes(entF note1,entF note2);
fin
//procédures
procédure afficheMoy2Notes(entF note1 : réel, entF note2 : réel) c'est '
début
    moyenne : réel
    moyenne := (note1+note2)/2
fin
```

Q4 Tableau :
| Instructions | algo1 | algo2 | note1 | note2 | moyenne | commentaire |
| :----------: |:-----:| :----:|:-----:|:-----:|:-------:|:-----------:|
|              |   NI  |   NI  |   ND  |  ND   |   ND    |             |
|              |  10,5 |       |       |       |         |             |
|              |       |  12,5 |       |       |         |             |
|              |       |       |       |       |         |             |
|              |  ND   |  ND   |  10,5 | 12,5  |   NI    |             |
|              |       |       |       |       |   11,5  |             |
|              |       |       |       |       |         |             |
|              |  10,5 |  12,5 |  ND   |  ND   |   ND    |             |

## Exo 2

``` c
programme rectangle c'est '
//Declaration des constantes
// entete procédure (Q1)
procédure afficheRectangle(entF nbCol : entier, entF nbLig : entier);
procédure afficheLigne(entF nbCol : entier);
//programme principal (Q2)
debut
    nbCol,nbLig:entier;
    ecrire("Entrez la longeur :");
    lire(nbLig);
    ecrire("Entrez la largeur:");
    lire(nbCol);
    afficheRectangle(entF nbCol,entF nbLig);
procédure afficheLigne(entF nbCol : entier) c'est '
début
    c : entier;
    c:=0;
    tant que (c < nbCol) faire
        ecrire("*");
        c:=c + 1;
    finfaire;
fin
procédure afficheRectangle(entF nbCol : entier, entF nbLig : entier) c'est '
début
    l : entier;
    l:=0;
    tant que (l < nbLig) faire
        afficheLigne(entF nbLig)
        ecrire("\n");
        l:=l + 1;
    finfaire;
fin
```

## Exo 3

``` c
procédure serieAdditionsRapports(entF n:entier)
```
