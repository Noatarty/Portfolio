## Q1

A:Une ligne spéciale tout en haut du script
Comment la nomme-t-on ?
R: le $shebang

Quel est son rôle ?
R: indique le programme à exécuter

Donner cette ligne dans le cas de PHP
R: #!/usr/bin/php

B:Des droits particuliers sur le script
Quels sont-ils ?
R: 0711
Comment les positionne-t-on ?
R: chmod 0711

## Q2

Écrivez un script autonome qui affiche ceci à l’écran (rappel : l’instruction PHP echo
ache ce qui est placé derrière elle). Testez-le dans votre Terminal, en prenant soin
d’appliquer les exigences de la Question 1, bien entendu !
Note : proposez 2 façons de produire ce résultat:
"
Bonjour tout le monde.
Une valeur approchée de PI vaut 3.1428
"
La valeur 3.1428 doit être calculée dans le script par la division de 22 par 7. Vous aurez
sans doute plus de chires derrière la virgule mais ce n’est pas important, vous pouvez
les laisser s’acher.

#!/usr/bin/php
<?php
echo "V1\n";
echo "Bonjour tout le monde.\n";
echo "Une valeur approchée de PI vaut " . (22/7) . "\n";
echo "V2\n";
$pi = 22/7;
echo "Une valeur approchée de PI vaut $pi\n";
?>
