#!usr/bin/php
<!DOCTYPE HTML>
<html>
    <head>
        <meta charset='utf-8'>
    </head>
    <body>
        <?php
        /* afficher les articles dans une table avec les colonnes : ● Code (centré)
                                                                    ● Libellé (cadré à gauche)
                                                                    ● Prix HT (cadré à droite)
                                                                    ● Taux TVA (cadré à droite)
                                                                    ● Montant TVA (cadré à droite)
                                                                    ● Prix TTC (cadré à droite)
                                                                    ● Stock (centré)
                                                                    ● Quantité vendue (centré)
            
                                                                    Avoir des en-tê^tes et être un minimum stylée (CSS:padding, borders etc)
            liste doit être paginée par 8 articles par page avec 2 lien de navigation (précedent, suivant) et doit savoir détecter le début et la 
            fin de pagination (pas de possibilité d’aller plus loin en amont ou en aval)
            
            Sous la table doivent s'afficher :
                ● La valeur totale HT du stock
                ● La quantité totale d’articles en stock (tous articles confondus)
                ● La valeur totale TTC des produits déjà vendus
                ● La quantité totale d’articles vendus (tous articles confondus)*/
            // 1. Récupérer les données dans le fichier data
            $data = file_get_contents("data");
            $produits = unserialize($data);
            //pagination par 8 articles 
            //exemple
            /*
            define("TAILLE_PG", 5);//definir la constante "TAILLE_PG"=elements contenu dans 1 page = 5
            $page = $_GET['page'];//recuperer le numero de page
            if (!$page) { //$page = 1 par défaut
                $page = 1;
            }
            if (count($regions) <= ($page*TAILLE_PG)) { // detecter la derniere page
                $derniere_page = true;
            }
            else {
                $derniere_page = false;
            }

            $arr_regions = array_slice($regions, ($page-1)*TAILLE_PG, TAILLE_PG, true); // ($page-1)*TAILLE_PG) = offset

            foreach($arr_regions as $nom => $info) { ?>
                <li><?php echo htmlentities($nom)?></li>
            <?php } ?>
        </ul>
            <?php
            if ($page > 1) {?>
                <a href="?page=<?php echo($page-1)?>">page précedente</a>
                <?php
                } else { ?>
                    pas de page précedente
                <?php
                }
                if (!$derniere_page) {?>
                    <a href="?page=<?php echo($page+1)?>">page suivante</a>
                <?php
                } else { ?>
                    pas de page suivante
                <?php
                }
                ?>
        */
            //print_r($produits);
            // faire la table
        ?>
        
        <table border="1">
            <thead>
                <tr>
                    <th>Code</th>
                    <th>Libellé</th>
                    <th>Prix HT</th>
                    <th>Taux TVA</th>
                    <th>Montant TVA</th>
                    <th>Prix TTC</th>
                    <th>Stock</th>
                    <th>Quantité vendue</th>
                </tr>
            </thead>
            <tbody>
                <?php
                foreach ($produits as $article => $produit) {
                    echo "<tr>";
                    echo "<td>" . $produit["code"] . "</td>";
                    echo "<td>" . $produit["libelle"] . "</td>";
                    echo "<td>" . $produit["prixHT"] . "</td>";
                    echo "<td>" . $produit["tauxTVA"] . "</td>";
                    echo "<td>" . $produit["montantTVA"] . "</td>";
                    echo "<td>" . $produit["prixHT"]-$produit["produitHT"]*$produit["tauxTVA"] / 100 . "</td>";
                    echo "<td>" . $produit["stock"] . "</td>";
                    echo "<td>" . $produit["vendu"] . "</td>";
                    echo "</tr>";
                
                }
                ?>
            </tbody>
        </table>
        
        <?php //somme de tout les prixHT en fonction du stock ?>
        <p>Valeur totale HT du stock : <?php foreach ($produits as $article => $produit) {
            $sommeprod = 0;
            $sommeprod += $produit["prixHT"];
        } echo $sommeprod ?></p>
        <p>Quantité totale d’articles en stock : <?php foreach ($produits as $article => $produit) {
            $sommestock = 0;
            $sommestock += $produit["stock"];
            } echo $sommestock ?></p>
        <p>Valeur totale TTC des produits déjà vendus : <?php foreach ($produits as $article => $produit) {
            $sommeproven = 0;
            $sommeproven += ($produit["prixHT"]-$produit["produitHT"]*$produit["tauxTVA"] / 100) * $produit["vendu"];
            } echo $sommeproven ?></p>
        <p>Quantité totale d’articles vendus : <?php foreach ($produits as $article => $produit) {
            $sommeartven = 0;
            if ($produit["vendu"] > 0) {
                $sommeartven++;
            }
            } echo $sommeartven ?></p>
    </body>
</html>
