<!DOCTYPE HTML>
<html>
    <head>
        <meta charset='utf-8'>
    </head>
    <body>
        <ul>
            <?php
            require_once('./regions.php');//inclure le fichier "regions.php
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
                <li><a href="http://localhost:8888/exo3-regions-detail.php?region=<?php echo urlencode($nom) ?>&depts[<?php urlencode($nom)?>]=<?php echo urlencode($info)?>"><?php echo htmlentities($nom)?></a></li>
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
    </body>
</html>

                

