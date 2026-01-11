<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>exo3 regions</title>
</head>
<body>
    
    <?php
        require_once('regions.php');
        define('TAILLE_PG', 5);
    ?>
    <ul>
        <?php 
            $page = $_GET['page'];
            $first_page = false;
            $last_page = false;

            if (!$page) {
                $page = 1;
            }

            if ($page == 1) {
                $first_page = true;
            }
            elseif (($page * TAILLE_PG) >= count($regions)) {
                $last_page = true;
            }
            
            $current_reg = array_slice($regions, ($page - 1) * TAILLE_PG, TAILLE_PG);

            foreach ($current_reg as $nom => $_) {
        ?>
                <li>
                    <a href="./exo3-regions-detail.php?region=<?php echo urlencode($nom) ?>">
                        <?php echo $nom; ?>
                    </a>
                </li>
        <?php 
            }
        ?>
    </ul>
    <?php 
        if (!$first_page) {
    ?>
            <a href="?page=<?php echo $page - 1 ?>">Previous</a>
    <?php 
        }
        if (!$last_page) {
    ?>
            <a href="?page=<?php echo $page + 1 ?>">Next</a>
    <?php 
        }
    ?>

</body>
</html>