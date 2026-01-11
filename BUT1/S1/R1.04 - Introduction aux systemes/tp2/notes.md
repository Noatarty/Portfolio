1. `more f1` : Peut fonctionner dans le répertoire d7 où se trouve le fichier f1.

2. `more d8/f2` : Peut fonctionner dans le répertoire d1 où vous pouvez accéder à d8/f2.

3. `more ../d9/f9` : Peut fonctionner dans le répertoire d1 où vous pouvez accéder à ../d9/f9.

4. `mv ./f6 ../..` : Peut fonctionner dans le répertoire d1 où vous pouvez accéder au fichier f6.

   Effet : Le fichier f6 sera déplacé vers le répertoire racine (au même niveau que d1).

5. `rm ../f1 f7` : Peut fonctionner dans le répertoire d1 où vous pouvez accéder à ../f1 et dans le répertoire d7 où vous pouvez accéder à f7.

   Effet : Les fichiers f1 (dans le répertoire racine) et f7 (dans le répertoire d7) seront supprimés.

6. `mv d6/f6 .` : Peut fonctionner dans le répertoire d1 où vous pouvez accéder à d6/f6.

   Effet : Le fichier f6 sera déplacé dans le répertoire courant (dans ce cas, d1).

7. `cp ../f3 d8/f3` : Peut fonctionner dans le répertoire d1 où vous pouvez accéder à ../f3 et dans le répertoire d8 où vous pouvez accéder à d8/f3.

   Effet : Le fichier f3 sera copié dans d8 sous le nom d3/f3.

8. `cp ../d2/f5 d3` : Peut fonctionner dans le répertoire d1 où vous pouvez accéder à ../d2/f5 et dans le répertoire d3 où vous pouvez accéder à d3.

   Effet : Le fichier f5 sera copié dans d3 sous le nom d3/f5.

9. `mkdir d8` : Peut fonctionner dans le répertoire parent de d1 où vous pouvez créer un nouveau répertoire d8.

   Effet : Un nouveau répertoire nommé d8 sera créé dans le répertoire parent de d1.

10. `mkdir d6/d11` : Peut fonctionner dans le répertoire d1 où vous pouvez créer un nouveau répertoire d6/d11.

    Effet : Un nouveau répertoire nommé d11 sera créé dans le répertoire d6.

## Jokers
### Définition

Dans un jeu de cartes, un
Joker est une carte qui remplace n’importe quelle autre carte.
Le
Shell (chez nous il s’appelle Bash) utilise aussi ce principe de Jokers dans le ciblage
des objets (noms et chemins). Il peut être utile de cibler tous les fichiers dont les noms
suivent un modèle de nommage. Par exemple : tous les fichiers dont l’extension est .c ou
encore tous les dossiers dont les noms contiennent 2019.
C’est là que les Jokers entrent en jeu. Comme une carte Joker peut remplacer n’importe
quelle autre carte, un Joker Shell peut remplacer un ou plusieurs caractères dans la
description du nom. Ainsi, on peut globaliser la cible en une seule écriture générique du
nom. Au lieu de dire :
Je cible les fichiers nommés exo1.c, exo2.c, exo3.c et exo4.c, on dit Je cible les fichiers nommés quelque chose terminé par .c
Le quelque chose, c’est ce qu’on appelle unJoker.