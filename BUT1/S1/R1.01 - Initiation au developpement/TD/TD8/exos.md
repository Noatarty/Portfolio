# Exos

## Ex 1

```c
//Définir le type t_Candidat, regroupant dans une structure le nom, l’âge et le nombre de voix d’un candidat.
type t_candidat = structure
debut
    c_nom: chaine(30);
    c_age: chaine(30);
    c_nb_voix: int

fin

fonction saisie() délivre t_candidat c'est '
//Écrire une fonction saisie() permettant de lire au clavier le nom, le nombre de voix et l’âge d’un candidat et de délivrer ces informations au programme appelant.
Debut
    c:t_candidat
    Ecrire("Entrez le nom du candidat: ");
    lire(c.c_nom);
    Ecrire("Entrez l'age du candidat: ");
    lire(c.c_age);
    Ecrire("Entrez le nombre de voix du candidat: ");
    lire(c.c_voix);

    retourne t_candidat;
Fin

fonction compare(entF c1:t_candidat,entF c2:t_candidat) délivre entier
//Ecrire une fonction compare(entF c1 : t_candidat, entF c2 : t_candidat) délivre entier, qui délivre la valeur -1 si c1 est moins bien placé que c2, la valeur 1 si c1 est mieux placé que c2, la valeur 0 s’ils sont à égalité. Appliquer un raisonnement par actions.
Debut
    gagnant: entier;
    gangnant:=1
    si(c1.c_voix < c2.c_voix OU (c1.c_age < c2.c_age ET c1.c_voix == c2.c_voix)) alors
        gagnant:= -1;
    sinon si (c1.c_voix == c2.c_voix ET c1.c_age == c2.c_age)
        gagnant: =0;
    finsi
    retourne gagnant
Fin

programme main c'est '
//Écrire un programme, utilisant les fonctions précédentes, qui lit au clavier les informations de 2 candidats, et qui affiche à l’écran le nom du candidat élu, ou un message annonçant l’égalité. Utiliser une structure de choix multiples.
debut
    resultat: entier;
    candidat1: t_candidat;
    candidat2: t_candidat;
    candidat1:= saisie();
    candidat2:= saisie();
    resultat:=compare(candidat1,candidat2);
    selon resultat c'est '
        quand 1 : Ecrire("Le premier candidat est plus fort");
        quand -1 : Ecrire("le second candidat est plus fort");
        quand 0 : Ecrire("les deux candidats sont égaux");
    Finselon
fin
```

## Exo 2

```c
constante entier MAXL := 50 000; 

type t_livre = structure
debut
    c_ref : entier;
    c_titre : chaine(30) ;
    c_auteur : chaine(30) ;
    c_present : booléen ; {Faux si emprunté}
fin

type t_TabLivres = tableau [MAXL] de t_livre;

type t_bib = structure
debut
    c_contenu : t_TabLivres ;
    c_nbre : entier ;
fin

procédure afficher_un_livre(entF livre:t_livre)
debut
    Ecrire ("Référence du livre : ",livre.c_ref,"\n Titre : ",livre.c_titre);
    Ecrire ("Auteur : \n",livre.c_auteur,);
    si (livre.c_present == Vrai) faire
        Ecrire ("Ce livre est disponible.\n")
    sinon
        Ecrire ("Ce livre a été prêté et n'est pas disponible.\n")
    FinSi
fin

fonction saisir_livre()
debut
    variable livre : t_livre;
    Ecrire ("Saisie de la ref d'un livre ");
    lecture (livre.c_ref);
    Ecrire ("Saisie du titre d'un livre ");
    Lecture (livre.c_titre);
    Ecrire ("Saisie de l'auteur d'un livre ");
    Lecture (livre.c_auteur);
    c.c_present:=vrai;
    return livre;
fin

procedure inserer_livre(entF/sortF bibliotheque:t_bib;livre:t_livre)
debut
    si (bibliotheque.c_nbre < MAXL) alors
        bibliotheque.c_nbre:= bibliotheque.c_nbre+1
        bibliotheque.c_contenu[bibliotheque.c_nbre]:=livre;
    sinon
        Ecrire("La bibliothèque est pleine");
    Fin Si
fin

procedure afficher_bibliotheque(entF bibliotheque:t_bib)
debut
    i:entier
    pour (i de 1 a bibliotheque.c_nbre) faire
        afficher_un_livre(entE bibliotheque.c_contenu[i]);
    finpour
fin

procedure emprunter(entF/sortF bibliotheque:t_bib)
début
    ref: entier;
    i:entier;
    ecrire("référence du livre");
    lire(ref);
    Pour (i de 1 à bibliotheque.c_nbre) faire
        si (bibliotheque.c_contenu[i].c_ref = ref) et (bibliotheque.c_contenu[i] c_present = faux) alors
            bibliotheque.c_contenu[i].c_present := vrai;
        Finsi
    Finpour
Fin

```
