#!usr/bin/php
<!DOCTYPE HTML>
<html>
    <head>
        <meta charset='utf-8'>
    </head>
    <body>
        <?php
        /*Lire le contenu du fichier articles. Conseil : utilisez file() pour charger votre
fichier dans un tableau et parcourez ensuite votre tableau. Chaque cellule du
tableau = un produit. A vous de découper les informations (explode() est
peut-être utile pour ça).*/
            $articles = file("./articles");
            foreach($articles as $produit => $article) {
                $article = explode(",", $article);
                $produit = array (
                    "code" => $article[0],
                    "lib" => $article[1],
                    "prixHT" => $article[2],
                    "tauxTVA"=> $article[3],
                    //rajouter les champs stock et vendu qui ne font pas partie des données et qui doivent être initialisé à 0
                    "stock" => 0,
                    "vendu" => 0
                );
                echo $produit["tauxTVA"];
            }

            // serializé le tableau dans un fichier data
            $data = serialize($articles);
            file_put_contents("data", $data);

        ?>
    </body>
</html>