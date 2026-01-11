
IUT Lannion - R3.01 - TD 1 - Initiation 2024-25
# R3.01 - ProgWeb
## TD 1 - Initiation
### Introduction
Dans certains exercices vous verrez apparaître :
- 🚫→ Vous ne devez pas utiliser ces mots-clés ou ces fonctions !
- 🛠→ Fonctions ou mots-clés suggérés. Consultez le site php.net. Pas d’obligation
de les utiliser si vous (et pas Google) trouvez une autre façon de faire.
### Exercice 1 - Script autonome
Vous devez vous rappeler avoir appris en R1.04 à écrire quelques scripts d’administration
système. Nous avions utilisé Bash mais aussi PHP qui, même s’il est connoté “Web”, est
parfaitement adapté pour réaliser de tels scripts d’automatisation et d’administration.
Nous n’allons pas vraiment utiliser PHP pour écrire de tels scripts autonomes en R3.01,
mais il est bien de rappeler que PHP peut aussi être utilisé dans ce cadre.
Voici donc un exercice pour vous remettre les idées au clair sur ce mode.
#### Question 1
Pour qu’un script quelconque puisse être autonome et exécutable en ligne de
commande, comme on le fait avec d’autres commandes système, il lui faut deux choses :
- Une ligne spéciale tout en haut du script
Comment la nomme-t-on ?
Quel est son rôle ?
Donner cette ligne dans le cas de PHP
- Des droits particuliers sur le script
Quels sont-ils ?
Comment les positionne-t-on ?
#### Question 2
Écrivez un script autonome qui ache ceci à l’écran (rappel : l’instruction PHP echo
ache ce qui est placé derrière elle). Testez-le dans votre Terminal, en prenant soin
d’appliquer les exigences de la Question 1, bien entendu !
Note : proposez 2 façons de produire ce résultat.
Bonjour tout le monde.
Une valeur approchée de PI vaut 3.1428
La valeur 3.1428 doit être calculée dans le script par la division de 22 par 7. Vous aurez
sans doute plus de chires derrière la virgule mais ce n’est pas important, vous pouvez
les laisser s’acher.
Pages Web
A partir de maintenant, nous n’allons plus écrire que des scripts pour le Web.
Il faudrait donc un serveur Web pour servir des pages Web, mais pour du test on peut
utiliser le serveur Web intégré au programme php. C’est ainsi que vous procéderez pour
les TD/TP :
- Dans un Terminal, placez-vous dans le dossier contenant vos scripts
- Lancez l’interpréteur php en mode “Serveur Web” (-S) de la manière suivante :
php -S localhost:8888
- Ouvrez un navigateur Web et entrez l’URL (adapter <nom de votre script>) :
http://localhost:8888/<nom de votre script>
© Gildas Quiniou - Révision 10 - 09-2024 2/8
IUT Lannion - R3.01 - TD 1 - Initiation 2024-25
### Exercice 2 - Structures de contrôle
Vous avez à disposition, sur Moodle, un fichier PHP depts-exo2.php (ne vous trompez
pas de fichier) qui contient la déclaration et l’initialisation d’un tableau nommé $depts
composé de la liste des départements de France métropolitaine.
#### Question 1
Dupliquez ce fichier depts-exo2.php en un script exo2-ul.php et complétez-le pour
acher les départements sous forme d’une liste HTML (<ul>).
🚫foreach()
🛠count(), sizeof(), htmlentities()

```php
#!usr/bin/php

<!DOCTYPE html>
<html lang="fr">
   <head>
      <meta charset="utf-8" />
   </head>
   <body>
   # question 1
   <?php
               
      $depts = [
         'Ain',
         'Aisne',
         'Allier',
         'Alpes-de-Haute-Provence',
         'Hautes-Alpes',
         'Alpes-Maritimes',
         'Ardèche',
         'Ardennes',
         'Ariège',
         'Aube',
         'Aude',
         'Aveyron',
         'Bouches-du-Rhône',
         'Calvados',
         'Cantal',
         'Charente',
         'Charente-Maritime',
         'Cher',
         'Corrèze',
         'Corse-du-Sud',
         'Haute-Corse',
         'Côte-d\'Or',
         'Côtes-d\'Armor',
         'Creuse',
         'Dordogne',
         'Doubs',
         'Drôme',
         'Eure',
         'Eure-et-Loir',
         'Finistère',
         'Gard',
         'Haute-Garonne',
         'Gers',
         'Gironde',
         'Hérault',
         'Ille-et-Vilaine',
         'Indre',
         'Indre-et-Loire',
         'Isère',
         'Jura',
         'Landes',
         'Loir-et-Cher',
         'Loire',
         'Haute-Loire',
         'Loire-Atlantique',
         'Loiret',
         'Lot',
         'Lot-et-Garonne',
         'Lozère',
         'Maine-et-Loire',
         'Manche',
         'Marne',
         'Haute-Marne',
         'Mayenne',
         'Meurthe-et-Moselle',
         'Meuse',
         'Morbihan',
         'Moselle',
         'Nièvre',
         'Nord',
         'Oise',
         'Orne',
         'Pas-de-Calais',
         'Puy-de-Dôme',
         'Pyrénées-Atlantiques',
         'Hautes-Pyrénées',
         'Pyrénées-Orientales',
         'Bas-Rhin',
         'Haut-Rhin',
         'Rhône',
         'Haute-Saône',
         'Saône-et-Loire',
         'Sarthe',
         'Savoie',
         'Haute-Savoie',
         'Paris',
         'Seine-Maritime',
         'Seine-et-Marne',
         'Yvelines',
         'Deux-Sèvres',
         'Somme',
         'Tarn',
         'Tarn-et-Garonne',
         'Var',
         'Vaucluse',
         'Vendée',
         'Vienne',
         'Haute-Vienne',
         'Vosges',
         'Yonne',
         'Territoire de Belfort',
         'Essonne',
         'Hauts-de-Seine',
         'Seine-Saint-Denis',
         'Val-de-Marne',
         'Val-d\'Oise',
      ];

         for ($boucle=0; $boucle < count($depts); $boucle++) {
      ?>
            <li><?php echo htmlentities($depts[$boucle])?>
      <?php
         }
      ?>
      <table border = 1>
         <thead>
            <tr>
               <th>Numéro de département</th>
               <th>Nom département</th>
            </tr>
         </thead>
         <tbody>
            <?php
            # question 2
            $nbdepts = count($depts);
            $nb = 1;
            for ($row = 0; $row<=$nbdepts; $row++) {
               $bool = false;
               if ($depts[$row]=="Corse-du-Sud") {
                  echo "<tr><td>2A</td><td>$depts[$row]</td></tr>";
                  
               }
               else if ( $depts[$row]=="Haute-Corse") {
                  echo "<tr><td>2B</td><td>$depts[$row]</td></tr>";
                  $bool = true;
                  
               }
               else {
                  if ($bool == true) {
                     $nb = $nb-2;
                  }
                  else {
                     $nb++;
                  }
                  echo "<tr><td>$nb</td><td>$depts[$row]</td></tr>\n";
               }
            }
            ?>
         </tbody>
         </table>
   </body>   
</html>
```

#### Question 2
Dupliquez votre script exo2-ul.php en exo2-table.php et modifiez votre code pour
acher cette liste dans une table HTML (<table>) avec une colonne pour le numéro de
département et une autre colonne pour le nom. Prévoyez aussi des entêtes de colonnes.
Êtes-vous satisfait·e du résultat ?
Pourquoi ?

```php
#!usr/bin/php

<!DOCTYPE html>
<html lang="fr">
   <head>
      <meta charset="utf-8" />
   </head>
   <body>
    <table border = 1>
        <thead>
            <tr>
               <th>Numéro de département</th>
               <th>Nom département</th>
            </tr>
        </thead>
        <tbody>
            <?php
                $depts = [
                    'Ain',
                    'Aisne',
                    'Allier',
                    'Alpes-de-Haute-Provence',
                    'Hautes-Alpes',
                    'Alpes-Maritimes',
                    'Ardèche',
                    'Ardennes',
                    'Ariège',
                    'Aube',
                    'Aude',
                    'Aveyron',
                    'Bouches-du-Rhône',
                    'Calvados',
                    'Cantal',
                    'Charente',
                    'Charente-Maritime',
                    'Cher',
                    'Corrèze',
                    'Corse-du-Sud',
                    'Haute-Corse',
                    'Côte-d\'Or',
                    'Côtes-d\'Armor',
                    'Creuse',
                    'Dordogne',
                    'Doubs',
                    'Drôme',
                    'Eure',
                    'Eure-et-Loir',
                    'Finistère',
                    'Gard',
                    'Haute-Garonne',
                    'Gers',
                    'Gironde',
                    'Hérault',
                    'Ille-et-Vilaine',
                    'Indre',
                    'Indre-et-Loire',
                    'Isère',
                    'Jura',
                    'Landes',
                    'Loir-et-Cher',
                    'Loire',
                    'Haute-Loire',
                    'Loire-Atlantique',
                    'Loiret',
                    'Lot',
                    'Lot-et-Garonne',
                    'Lozère',
                    'Maine-et-Loire',
                    'Manche',
                    'Marne',
                    'Haute-Marne',
                    'Mayenne',
                    'Meurthe-et-Moselle',
                    'Meuse',
                    'Morbihan',
                    'Moselle',
                    'Nièvre',
                    'Nord',
                    'Oise',
                    'Orne',
                    'Pas-de-Calais',
                    'Puy-de-Dôme',
                    'Pyrénées-Atlantiques',
                    'Hautes-Pyrénées',
                    'Pyrénées-Orientales',
                    'Bas-Rhin',
                    'Haut-Rhin',
                    'Rhône',
                    'Haute-Saône',
                    'Saône-et-Loire',
                    'Sarthe',
                    'Savoie',
                    'Haute-Savoie',
                    'Paris',
                    'Seine-Maritime',
                    'Seine-et-Marne',
                    'Yvelines',
                    'Deux-Sèvres',
                    'Somme',
                    'Tarn',
                    'Tarn-et-Garonne',
                    'Var',
                    'Vaucluse',
                    'Vendée',
                    'Vienne',
                    'Haute-Vienne',
                    'Vosges',
                    'Yonne',
                    'Territoire de Belfort',
                    'Essonne',
                    'Hauts-de-Seine',
                    'Seine-Saint-Denis',
                    'Val-de-Marne',
                    'Val-d\'Oise',
                ];
                # question 2
                $nbdepts = count($depts);
                $nb = 1;
                for ($row = 0; $row<=$nbdepts; $row++) {
                   $bool = false;
                   if ($depts[$row]=="Corse-du-Sud") {
                      echo "<tr><td>2A</td><td>$depts[$row]</td></tr>";
                      
                   }
                   else if ( $depts[$row]=="Haute-Corse") {
                      echo "<tr><td>2B</td><td>$depts[$row]</td></tr>";
                      $bool = true;
                      
                   }
                   else {
                      if ($bool == true) {
                         $nb = $nb-2;
                      }
                      else {
                         $nb++;
                      }
                      echo "<tr><td>$nb</td><td>$depts[$row]</td></tr>\n";
                   }
                }
                ?>
         </tbody>
         </table>
   </body>   
</html>
```

#### Question 3
Comme vous n’êtes pas entièrement satisfait·e du résultat de la Question 2, refaites le
même exercice mais en utilisant le fichier depts-fix.php comme point de départ et en
adaptant le code en fonction de la nouvelle définition du tableau $depts.
Profitez-en pour acher aussi le nom de la préfecture dans une 3ème colonne.
🛠foreach()

```php
#!usr/bin/php

<!DOCTYPE html>
<html lang="fr">
   <head>
      <meta charset="utf-8" />
   </head>
   <body>
      <table border = 1>
         <thead>
            <tr>
               <th>Numéro de département</th>
               <th>Nom département</th>
               <th>Nom préfecture</th>
            </tr>
         </thead>
         <tbody>
            # question 1
            <?php
               $depts = [
                  '01' => ['Ain', 'Bourg-en-Bresse'],
                  '02' => ['Aisne', 'Laon'],
                  '03' => ['Allier', 'Moulins'],
                  '04' => ['Alpes-de-Haute-Provence', 'Digne-les-Bains'],
                  '05' => ['Hautes-Alpes', 'Gap'],
                  '06' => ['Alpes-Maritimes', 'Nice'],
                  '07' => ['Ardèche', 'Privas'],
                  '08' => ['Ardennes', 'Charleville-Mézières'],
                  '09' => ['Ariège', 'Foix'],
                  '10' => ['Aube', 'Troyes'],
                  '11' => ['Aude', 'Carcassonne'],
                  '12' => ['Aveyron', 'Rodez'],
                  '13' => ['Bouches-du-Rhône', 'Marseille'],
                  '14' => ['Calvados', 'Caen'],
                  '15' => ['Cantal', 'Aurillac'],
                  '16' => ['Charente', 'Angoulême'],
                  '17' => ['Charente-Maritime', 'La Rochelle'],
                  '18' => ['Cher', 'Bourges'],
                  '19' => ['Corrèze', 'Tulle'],
                  '2A' => ['Corse-du-Sud', 'Ajaccio'],
                  '2B' => ['Haute-Corse', 'Bastia'],
                  '21' => ['Côte-d\'Or', 'Dijon'],
                  '22' => ['Côtes-d\'Armor', 'Saint-Brieuc'],
                  '23' => ['Creuse', 'Guéret'],
                  '24' => ['Dordogne', 'Périgueux'],
                  '25' => ['Doubs', 'Besançon'],
                  '26' => ['Drôme', 'Valence'],
                  '27' => ['Eure', 'Évreux'],
                  '28' => ['Eure-et-Loir', 'Chartres'],
                  '29' => ['Finistère', 'Quimper'],
                  '30' => ['Gard', 'Nîmes'],
                  '31' => ['Haute-Garonne', 'Toulouse'],
                  '32' => ['Gers', 'Auch'],
                  '33' => ['Gironde', 'Bordeaux'],
                  '34' => ['Hérault', 'Montpellier'],
                  '35' => ['Ille-et-Vilaine', 'Rennes'],
                  '36' => ['Indre', 'Châteauroux'],
                  '37' => ['Indre-et-Loire', 'Tours'],
                  '38' => ['Isère', 'Grenoble'],
                  '39' => ['Jura', 'Lons-le-Saunier'],
                  '40' => ['Landes', 'Mont-de-Marsan'],
                  '41' => ['Loir-et-Cher', 'Blois'],
                  '42' => ['Loire', 'Saint-Étienne'],
                  '43' => ['Haute-Loire', 'Le Puy-en-Velay'],
                  '44' => ['Loire-Atlantique', 'Nantes'],
                  '45' => ['Loiret', 'Orléans'],
                  '46' => ['Lot', 'Cahors'],
                  '47' => ['Lot-et-Garonne', 'Agen'],
                  '48' => ['Lozère', 'Mende'],
                  '49' => ['Maine-et-Loire', 'Angers'],
                  '50' => ['Manche', 'Saint-Lô'],
                  '51' => ['Marne', 'Châlons-en-Champagne'],
                  '52' => ['Haute-Marne', 'Chaumont'],
                  '53' => ['Mayenne', 'Laval'],
                  '54' => ['Meurthe-et-Moselle', 'Nancy'],
                  '55' => ['Meuse', 'Bar-le-Duc'],
                  '56' => ['Morbihan', 'Vannes'],
                  '57' => ['Moselle', 'Metz'],
                  '58' => ['Nièvre', 'Nevers'],
                  '59' => ['Nord', 'Lille'],
                  '60' => ['Oise', 'Beauvais'],
                  '61' => ['Orne', 'Alençon'],
                  '62' => ['Pas-de-Calais', 'Arras'],
                  '63' => ['Puy-de-Dôme', 'Clermont-Ferrand'],
                  '64' => ['Pyrénées-Atlantiques', 'Pau'],
                  '65' => ['Hautes-Pyrénées', 'Tarbes'],
                  '66' => ['Pyrénées-Orientales', 'Perpignan'],
                  '67' => ['Bas-Rhin', 'Strasbourg'],
                  '68' => ['Haut-Rhin', 'Colmar'],
                  '69' => ['Rhône', 'Lyon'],
                  '70' => ['Haute-Saône', 'Vesoul'],
                  '71' => ['Saône-et-Loire', 'Mâcon'],
                  '72' => ['Sarthe', 'Le Mans'],
                  '73' => ['Savoie', 'Chambéry'],
                  '74' => ['Haute-Savoie', 'Annecy'],
                  '75' => ['Paris', 'Paris'],
                  '76' => ['Seine-Maritime', 'Rouen'],
                  '77' => ['Seine-et-Marne', 'Melun'],
                  '78' => ['Yvelines', 'Versailles'],
                  '79' => ['Deux-Sèvres', 'Niort'],
                  '80' => ['Somme', 'Amiens'],
                  '81' => ['Tarn', 'Albi'],
                  '82' => ['Tarn-et-Garonne', 'Montauban'],
                  '83' => ['Var', 'Toulon'],
                  '84' => ['Vaucluse', 'Avignon'],
                  '85' => ['Vendée', 'La Roche-sur-Yon'],
                  '86' => ['Vienne', 'Poitiers'],
                  '87' => ['Haute-Vienne', 'Limoges'],
                  '88' => ['Vosges', 'Épinal'],
                  '89' => ['Yonne', 'Auxerre'],
                  '90' => ['Territoire de Belfort', 'Belfort'],
                  '91' => ['Essonne', 'Évry-Courcouronnes'],
                  '92' => ['Hauts-de-Seine', 'Nanterre'],
                  '93' => ['Seine-Saint-Denis', 'Bobigny'],
                  '94' => ['Val-de-Marne', 'Créteil'],
                  '95' => ['Val-d\'Oise', 'Cergy'],
               ];
               foreach($depts as $key => $values) {
                  echo "<tr><td>$key</td><td>$values[0]</td><td>$values[1]</td></tr>\n";
               }
            ?>
         </tbody>
      </table>
   </body>   
</html>
```

Question 4
On souhaite maintenant ajouter le nom de la région, en information complémentaire
entre (), juste derrière le nom du département.
Pour ce faire, vous disposez d’un fichier regions.php contenant un tableau $regions, qui
associe le nom d’une région avec la liste (tableau) des codes des départements qui la
constitue.
Sur la base de la Question 3, dupliquez votre script en un exo2-regions.php.
Cette fois-ci vous devez :
- Inclure, à l’exécution, le contenu du fichier regions.php.
© Gildas Quiniou - Révision 10 - 09-2024 3/8
IUT Lannion - R3.01 - TD 1 - Initiation 2024-25
- Ecrire une fonction trouve_region($code) qui renvoie le nom de la région du
département dont on passe le code en paramètre
- Adaptez ensuite votre code pour acher le nom de la région entre ()pour
chaque département.
🚫de coller le contenu de regions.php dans votre script
🛠require_once(), in_array(), foreach(), global
Exercice 3 - Paramètres d’URL
Vous savez certainement qu’une URL peut contenir des paramètres.
Si vous ne le saviez pas, voici un exemple :
http://localhost:8888/ajout_panier.php?produit=XYZ&qte=20
Explication des parties de cette URL :
- http : protocole utilisé. En local du HTTP c’est OK, sur un serveur public ce sera
certainement du HTTPS.
- localhost:8888 : adresse du serveur + éventuellement le port utilisé, ici 8888. On
verra ça en détail en R3.06
Sur un serveur public le port sera sans doute absent. Ce sera alors le port par
défaut en fonction du protocole : 80 pour HTTP, c’est de plus en plus rare, et 443
pour du HTTPS.
- ajout_panier.php : nom du script PHP qui construit la page Web
- ? : séparateur indiquant que ce qui suit ce sont les paramètres du script.
- produit=XYZ : un paramètre (produit) et sa valeur (XYZ)
- & : séparateur entre chaque paire (nom, valeur) de paramètres
Côté serveur, le script (ici ajout_panier.php) reçoit ses paramètres dans la
superglobale (voir cette notion à la fin du CM) qui s’appelle $_GET. C’est un tableau.
Question 1
Créez un script exo3.php qui ache le contenu du tableau $_GET, et testez avec l’ URL :
http://localhost:8888/exo3.php?nom=ochon&prenom=paul
🛠_GET, print_r(), <pre>...</pre>
Question 2
Créez un script exo3-regions.php qui ache la liste des régions (juste les noms) issues
du tableau $regions du fichier regions.php, mais en respectant les contraintes
suivantes :
© Gildas Quiniou - Révision 10 - 09-2024 4/8
