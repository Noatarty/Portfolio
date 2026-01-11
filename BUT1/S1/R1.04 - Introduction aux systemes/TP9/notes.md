entête nom php :
#!/usr/bin/php
<?php
    /*code*/
?>
compiler du php :
chmod +x hello.php // seulement la première fois
./hello.php

Pour expérimenter tout ce qui va suivre sans créer un script à chaque fois, vous allez lancer php en mode Shell Interactif et un peu comme dans un bash, vous pourrez taper directement les instructions PHP qui vont suivre et observer immédiatement le résultat.
Pour lancer un php en Shell Interactif : php -a
Pour le quitter une fois tout terminé tapez la combinaison de touches CTRL+D ou exit
Si vous êtes bloqué dans une commande, tapez CTRL+C et relancez un php -a

Types de données
Voici quelques types de données (de variables) que nous allons utiliser :
● Entiers : 123
● Flottants : 123.456
● Chaînes de caractères : "ABC" ou aussi 'ABC'
● Booléens : true et false
● Tableaux : voir plus loin

Variables

Affectation
$nom = "Sarah Connor";
$salaire = 2500;
le nom de la variable à aecter doit être préfixé d’un $
La variable est créée uniquement au moment de son aectation

Lecture
L’utilisation du contenu d’une variable se fait simplement en utilisant $variable dans
l’expression. Exemples :
echo $nom;
echo $salaire * 12;
$annee = $salaire * 12;
echo $annee;

Opérateurs

Arithmétiques
+ - * / % (modulo euclidien) ** (exponentiation)
Exemples :
$val1 = 5;
$val2 = 8;
echo 7 * 12 + $val1 / $val2;
Pré et Post-(in|dé)crémentation
++ --
Exemples :
$val=10;
echo ++$val;
echo $val;
echo $val--;
echo $val;
Opérateur logiques
&& || !
Exemples : voir le paragraphe sur les comparaisons.
Opérateur de chaîne
. (point, c’est une concaténation)
Exemples :
echo $nom;
echo "Mme " . $nom;

Opérateur avec réaectation
+= -= *= /= %= .=
Exemples :
echo $val;
$val += 12;
echo $val;
$val /= 5;
echo $val;
$ville = "Lannion";
$ville .= " (France)";
echo $ville;

Structures de Contrôle
if (condition) {
...
} else if (condition2) {
...
} else {
...
}
Le if est obligatoire mais le ou les else if et le else sont facultatifs.
Un else if peut aussi s’écrire elseif

Boucles for
for ($boucle = 1; $boucle < 10; $boucle++) {
echo $boucle . "\n";
}

Boucles while et do... while
(Exemples de syntaxe, ne pas tester dans le Shell Interactif PHP)
while (condition) {
...
}
do {
...
} while (condition);

Conditions et comparaisons

Opérateurs de comparaison
== != <= >= < >

Sur une chaîne de caractères, un == est la même chose en PHP qu’un strcmp() en C, ce
qui est plutôt sympathique. Dans ce cas un <= ou un >=, qui permettent habituellement de classer des valeurs numériques, sauront classer des chaînes de caractères entre elles, par ordre alphabétique pour établir laquelle et la plus petite par exemple.

Mixage des types
Les expressions font entrer en jeu des variables ou des expressions qui peuvent être :
● Numériques
● Chaînes de caractères
● Booléennes

Par exemple, on peut comparer des chaînes de caractères avec des valeurs numériques,
sans avoir besoin de transformer les types de données. Ainsi :
if ((4 * 3) == "12") {
echo "OK";
}
compare un résultat d’une expression numérique (4 * 3) avec une chaîne de
caractères, sans que ça lui pose de problèmes.
Il transforme la chaîne "12" en une valeur numérique (12), puis il fait le test d’égalité
avec le résultat de 4 * 3, c'est-à-dire la valeur numérique 12, aboutissant à évaluer à
true.
A noter que ceci :
if ((4 * 3) == "00012ABC") {
echo "OK";
}
fonctionne aussi et est aussi évalué à true.
Attention, il y a quelques caractères autres que des chires qui sont acceptables dans
une chaîne :
echo 10 * "1e2"; // Affiche 1000
echo 2 + "+1e-2"; // Affiche 2.01
echo 5 / ".1"; // Affiche 50
car 1e2 est une écriture de 100 en notation scientifique, +1e-2 est une écriture de 0.01 et
.1 est une écriture de 0.1

Comparaisons strictes
Tout ceci est assez séduisant mais provoque un eet de bord qu’il est important de bien
comprendre.
Comme PHP est souple et convertit les types pour que les comparaisons se fassent
d’une façon ou d’une autre, on aboutit alors à ce que les valeurs :
0 0.0 false ""
sont toutes considérées comme égales par PHP. Ainsi :
if ("" == false) {
echo "OK";
}
est vrai (c’est à dire qu’une chaîne vide vaut bien false), comme ceci est vrai aussi :
if (0 == "") {
echo "OK";
}

0" == 0
est vrai,
"" == 0
est vrai, on peut donc en déduire que, logiquement,
"0" == ""
est faux car les deux chaines sont diff

L’opérateur d’égalité stricte est : ===
L’opérateur de diérence stricte est : !==
Ainsi (ne rien saisir) :
"10" === 10
0.0 === 0
0 === false

Tableaux

Déclaration
Le plus simple est donc de toujours définir une variable de type tableau avant de l’utiliser :
$tablo = array();
$tablo2 = [];
sont deux syntaxes pour définir un tableau vide. La seconde est la plus moderne et on
retiendra celle-là désormais.

Aectation
En même temps qu’on déclare un tableau, on peut lui aecter un contenu de la façon
suivante :
$depts = [
22 => "Côtes d’Armor",
29 => "Finistère",
35 => "Ille-et-Vilaine",
56 => "Morbihan",
];

affichage : print_r($depts);

Ajout/Remplacement
Ajouter une cellule à un tableau associatif se fait simplement comme l’aectation d’une
variable.
Si la cellule existe déjà (si la clé existe déjà), la valeur de la cellule est remplacée :
$depts[22] = "Aodou An Arvor";
print_r($depts);
Si la cellule n’existe pas encore (si la clé n’existe pas), la valeur de la cellule est créée, le
tableau est agrandi :
$depts[44] = "Loire Atlantique";
print_r($depts);

Parcours
Il a été dit précédemment que les tableaux sont des éléments de PHP.
Les tableaux viennent avec une structure de contrôle qui leur est dédiée : foreach
Voici sa syntaxe :
foreach ($depts as $num => $nom) {
    echo "Le département " . $num . " s’appelle " . $nom . "\n";
}
Si la clé ne vous est d’aucune utilité, une forme raccourcie peut alors être :
foreach ($depts as $nom) {
    echo $nom . "\n";
}

Doc fonctions : https://www.php.net/manual/fr/funcref.php
