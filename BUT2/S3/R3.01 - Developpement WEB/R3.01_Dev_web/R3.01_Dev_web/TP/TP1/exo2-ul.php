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
