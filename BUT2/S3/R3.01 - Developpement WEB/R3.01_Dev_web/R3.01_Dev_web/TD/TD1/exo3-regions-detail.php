<!DOCTYPE HTML>
<html>
    <head>
        <meta charset="utf-8">
    </head>
    <body>
        <h1><?php echo $_GET['region'] ?></h1>
        
        <ul>
            <?php
            
            $values = $_GET['arr_regions'];
            for ($boucle = 0; $boucle < count($values); $boucle++) { ?>
                <li><?php echo $values[$boucle]?></li>    <?php
            } 
            
        ?>

        </ul>
        <a href="http://localhost:8888/exo3-regions-q3.php">page des régions</a>
    </body>
</html>
