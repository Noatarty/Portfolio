# TP5

## Tubes
Sur le même principe que les redirections, on peut brancher les canaux STDIN et
STDOUT, non plus avec des fichiers mais avec des canaux d’autres processus.
On branche alors la sortie de l’un avec l’entrée d’un autre, comme on le ferait avec un
tuyau. On appelle d’ailleurs cela un tube (pipe en anglais).
La syntaxe d’un tube est la suivante :
une_commande | une_autre_commande
Le STDOUT de une_commande alimente le STDIN de une_autre_commande.
Évidemment, une_autre_commande, comme tout processus, a aussi son propre STDOUT.
Dans l’exemple précédent, il s’agit de l’écran (canal par défaut), mais rien n’empêche de
rediriger son STDOUT vers un fichier, de cette façon :
une_commande | une_autre_commande > un_fichier
ou vers une autre commande, de cette façon :
une_commande | une_autre_commande | une_troisieme_commande
Vous l’aurez compris, ce chaînage peut être poursuivi autant de fois que nécessaire,
chaque commande venant s’alimenter de ce que la précédente lui donne.
C’est ce mécanisme qui est la base du sujet de ce TP : les filtres.
IMPORTANT :
• Seule la 1ère commande peut avoir une redirection entrante de la forme : <
• Seule la dernière commande peut avoir une redirection sortante de la forme : >
Ainsi, ceci est autorisé :
cmd1 < source | cmd2 | cmd3 | cmd4 > resultat
Ceci est incohérent et donc interdit :
cmd1 > dest | cmd2 | cmd3 | cmd43
cmd1 | cmd2 | cmd3 | cmd4 < source4
cmd1 | cmd2 < source | cmd3 | cmd45
cmd1 | cmd2 | cmd3 > dest | cmd46
Il est interdit d’écrire ces choses mais si vous le faites, vous n’aurez pas de message
d’erreur , juste un comportement bizarre, qui peut aller jusqu’au blocage apparent de la7
commande, dont vous vous sortirez généralement par un CTRL+C

## Filtres
Nous allons détailler chaque filtre avant de passer à des exercices de mise en pratique.

### Principe de fonctionnement 

ce qu’est un filtre et comment il fonctionne.
Un filtre reçoit des données (du texte généralement) sur son STDIN et leur applique une éventuelle transformation pour produire, sur son STDOUT, le résultat de sa transformation(aussi du texte généralement).
STDIN, STDOUT, vous l’avez compris, les filtres s’utilisent au moyen de tubes.
Un filtre ne modifie JAMAIS la source de données. Il produit sur son STDOUT une version
(éventuellement) modifiée de ce qui lui a été donné sur son STDIN.
IMPORTANT : Ne pas confondre filtrer et trier !
• Un filtre réduit (éventuellement) un ensemble de données en un sous-ensemble suivant
des critères indiqués. En outre, les données qui en ressortent peuvent être modifiées par
rapport à celles qui sont entrées.
• Un tri ordonne un ensemble de données suivant des critères indiqués. La quantité de
données reste la même en sortie.
Notez que les filtres s’utilisent généralement avec des tubes, donc sous cette forme :
une_commande | un_filtre
Mais il faut savoir que tous les filtres peuvent aussi s’utiliser seuls, de cette façon :
un_filtre < un_fichier
ou encore en passant juste un nom de fichier en paramètre :
un_filtre un_fichier

### Pourquoi des filtres

Plus on rend une compétence spécifique, plus on restreint le champ des possibilités.
Il est plus intéressant de se cantonner à des compétences très basiques mais qu’on peut
combiner entre elles.
Il en va de même pour les filtres Unix.
On aurait pu écrire des commandes très spécifiques pour réaliser des tâches spécifiques
mais il aurait alors fallu multiplier ces commandes pour remplir tous les besoins
communs. Et encore, on aurait obligatoirement fait des choix sur ce qui est utile et
commun et ce qui relève d’un besoin plus rare, créant forcément des manques qu’il
faudrait combler ponctuellement par le développement de nouvelles commandes. C’est
sans fin !
Ces filtres ont des fonctions (des compétences) très basiques et c’est la combinaison des
filtres entre eux qui rend le mécanisme très puissant et polyvalent.

### Tests

Fichiers “au kilomètre”

Ce sont des fichiers de texte brut, comme peut l’être ce document que vous êtes en train
de lire : des paragraphes de texte dont la longueur, le nombre et la structure sont
quelconques et impossibles à prévoir.
Exemples : les fichiers murphy et lorem.

Fichiers structurés

Ce sont des fichiers de texte qui suivent un formatage homogène.

1. Exemple 1 - Voici un extrait du fichier prod :

pomme:2:rouge:1,35:nzelande
cerise:6:rouge:3,25:france

Chaque ligne correspond à un produit. On appelle cela un Enregistrement.
Chaque enregistrement est composé de Champs séparés par un Séparateur . Si on a
deux séparateurs consécutifs (ici ce serait ::), le champ est donc vide.
Voici les champs du fichier prod :
● Nom du produit
● Quantité
● Couleur
● Prix (numérique)
● Provenance

2. Exemple 2 - Voici un extrait du fichier lang :
C++ 1983 compilécode natif
Forth 1978 compilémachine virtuelle

Chaque enregistrement est composé de Champs mais ici il n’y a pas de séparateur. Les
champs sont à des positions fixes :
● Les 11 premiers caractères = nom du langage (10 symboles et 1 espace)
● Les 5 suivants = date de création (4 chires et 1 espace)
● Les 11 suivants = type de langage, compilé ou interprété, (10 lettres et 1 espace)
● Et enfin, le reste de la ligne est le mode d’exécution, code natif ou machine
virtuelle.
Les champs dont le contenu est plus court que l’espace qui leur est alloué sont
complétés par des espaces. Par exemple, le 1er champ du 1er enregistrement de lang vaut
C++(et 8 espaces)

## Les exos

### wc Compter

wc - Compter12
Cette commande compte des... mots, oui, mais pas que des mots ! Elle permet aussi de13
compter des lignes et des caractères.
On a déjà eu l’occasion de l’utiliser dans un TP précédent.
Syntaxe
wc -l Compte les lignes (l = lines )14
wc -c Compte les caractères (c = characters)
wc -w Compte les mots (w = words)

cat lang prod | wc -l : Compte le nombre total de la globalité des lignes des fichiers
lang et prod : cat lang prod permettant d’envoyer sur son
STDOUT le contenu des fichiers lang et prod qui est ensuite
consommé par wc sur son STDIN, pour produire finalement le
résultat de son comptage (de lignes) sur son STDOUT

Q1) cat lang prod | wc -c
Q2)cat lang prod | wc -w

### sort - Trier 

Cette commande trie des lignes de texte suivant des critères passés en option.

Syntaxe

sort -t <sep> -k <champ_deb,champ_fin>

Trie les lignes (enregistrements) sur les valeurs du ou des
champs dont les numéros vont de champ_deb à champ_fin.
Le séparateur de champs est sep. Si -t <sep> n’est pas
spécifié, chaque bloc de caractères blancs est un
séparateur. Bloc = si on rencontre plusieurs blancs
consécutifs, ils seront globalement pris comme un unique
séparateur entre deux champs.

Options utiles

-r Tri inversé
-n Tri numérique

Par défaut, les champs sont considérés
comme du texte. Ainsi 10 arrive avant 2 car le caractère 1
est avant le caractère 2 , comme Andromaque arrive avant16
Belphégor. Avec cette option, les champs sont considérés
comme numériques et 10 arrivera alors après 2 dans ce cas.

-u Ne produit que des lignes uniques, les autres lignes en
double sur les valeurs de leurs champs de tri sont omises.

Exemples

sort -t':' -k 3 < prod Trie ce qui arrive sur STDIN (ici le fichier prod) et envoie sur
STDOUT le résultat du tri en utilisant le caractère : comme
séparateur de champ et en triant sur le 3ème champ (la
couleur) et les suivants.

## A savoir
Le separateur doit être un caractère unique, pas une séquence, pas un mot.
Le separateur peut être collé au -t. Exemple : -t':' et -t ':' sont équivalents.
Il n’est pas nécessaire de placer le separateur entre apostrophes mais c’est conseillé.
Il est absolument nécessaire de placer le separateur entre apostrophes s’il s’agit d’un
caractère blanc. Exemple : -t ' '
Si on ne spécifie aucune option -k, alors les lignes sont triées sur le contenu intégral de
chaque ligne.
Si on ne spécifie pas de champ_fin, alors le tri se fait en utilisant tous les champs à partir
de champ_deb.
Le tri peut se faire sur plusieurs champs : d’abord 1er champ puis, si égalité entre deux
enregistrements sur le 1er champ, on utilise le 2ème champ pour les départager etc. La
syntaxe est alors de faire figurer plusieurs options -k. Exemple : -k3,3 -k1,1 permet de
trier sur le champ 3 et ensuite sur le champ 1.
Lors de l’utilisation du -u (unique), seuls les champs impliqués dans le tri sont pris en17
considération pour déterminer l’unicité. Ainsi, même si les autres champs sont diérents,
ils n’entrent pas en compte dans l’élimination des doublons.

Q.3 Quelle commande vous permet de trier prod sur la provenance ?
sort -t':' -k 5 < prod
Q.4 Quelle commande vous permet de trier prod sur la provenance et ensuite sur le nom ?
sort -t':' -k 5,5 -k 1,1 < prod
Q.5 Quelle commande vous permet de trier prod sur la quantité ? (Attention, piège)
sort -t':' -n -k 2 < prod
Q.6 Quelle commande vous permet de trnier prod sur la provenance en ne gardant qu’une
seule ligne par pays ?
sort -t':' -k 5 < prod

### uniq - Dédoublonner 

Cette commande produit en sortie ce qui lui est donné en entrée mais en omettant les
lignes qui seraient en double .18
Attention, cette commande ne fonctionne que sur une source déjà triée.
Par défaut, lors du traitement d’unicité, les lignes sont prises dans leur intégralité, il n’y a
pas de notion de champ pour cette commande.19
Syntaxe
uniq On ne peut pas faire plus simple !
Options utiles
-i Minuscules et majuscules sont équivalentes
-d Fait l’inverse : produit en sortie uniquement les lignes qui
apparaissent plusieurs fois .20
Exemples
uniq < depts Élimine en sortie les lignes en double
uniq -d < depts Ache en sortie uniquement les lignes en double, mais 1 seul
exemplaire par doublon, peu importe le nombre de fois où le
doublon est présent.
A savoir
Comme uniq nécessite une source de données triée, il est fréquent de préparer la
source à l’aide d’un sort. Or, sort possède aussi une option (-u) qui permet de ne
conserver qu’un exemplaire de chaque ligne en doublon. Du coup, uniq est d’une utilité
relative. Elle n’est utile que si on a déjà la certitude absolue que la source est triée.
Q.7 En vous aidant du manuel, quelle commande vous permet d’acher les lignes uniques du
fichier depts en achant devant chacune le nombre de fois où elle apparaît dans le
fichier ?
uniq -d -c < depts

### colrm - Supprimer des colonnes

Cette commande est utile principalement sur des fichiers textes avec des champs à
positions fixes, comme le fichier lang.
Elle permet de supprimer des colonnes de caractères dans ce qui est produit en sortie.22
Syntaxe
colrm col1 [col2] Omet en sortie, tout ce qui est situé entre les colonnes col1
et col2. Si col2 n’est pas spécifié, elle omet tout entre col1
et la fin de chaque ligne.
Exemples
colrm 12 16 < lang Omet en sortie la partie date du fichier lang
A savoir
La 1ère colonne est numérotée 1.
Q.8 Quelle commande permet d’acher la liste des départements du fichier depts, sans les
numéros, en ne gardant juste que les noms ?
colrm 1 5 < depts

### cut - Couper des champs

Cette commande est un faux-ami de la précédente. Il ne faut pas les confondre.
Elle permet, non pas de supprimer (omettre) des parties de lignes mais de couper les23
champs qu’on souhaite conserver dans ce qui est produit en sortie.
Les champs qui ne sont pas coupés sont simplement omis du résultat produit en sortie,
sur STDOUT.
Contrairement à colrm qui travaille sur des fichiers à champs fixes, cut travaille, comme
sort, sur des fichiers avec des champs séparés par des séparateurs. Le fichier prod est
un exemple de ce type de fichiers.
Attention au piège : même si cut et sort utilisent tous deux des champs pour travailler,
les options de ces deux commandes sont diérentes. Il est facile et fréquent de les
confondre, donc notez bien cela dans votre fiche de synthèse !

Syntaxe
cut -d <sep> -f <champs>
Extrait de chaque ligne (enregistrements) les valeurs du ou
des champs dont les numéros sont donnés par champs. Le
séparateur de champs est sep. Si -d <sep> n’est pas
spécifié, la tabulation (\t) est le séparateur.
Exemples
cut -d':' -f 3 < prod Extrait de ce qui arrive sur STDIN (ici le fichier prod)
uniquement le champ 3 (la couleur) et envoie cet unique
donnée restante sur STDOUT, en utilisant le caractère :
comme séparateur de champs.
cut -d':' -f 3- < prod Extrait les champs à partir du 3ème (la couleur et ceux qui
suivent)
A savoir
Le separateur doit être un caractère unique, pas une séquence, pas un mot.
Les champs peuvent être spécifiés sous diérentes formes :
● N : Le Nème
● N- : Le Nème et les suivants
● N,M : Les Nème et Mème (on peut en ajouter d’autres séparés par des virgules)
● N-M : Du Nème au Mème (inclus)
● N-M,X-Y : Du Nème au Mème et du Xème au Yème (et ainsi de suite)
Q.9 Quelle commande permet d’extraire du 1er au 3ème champ dans le fichier prod ?
cut -d: -f 1,4 < prod
Q.10 Quelle commande permet d’extraire le nom du département dans le fichier depts ?
(Attention au piège)
