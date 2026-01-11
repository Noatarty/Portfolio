<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>exo3 regions detail</title>
</head>
<body>
    
    <?php 
        $region = $_GET["region"];
        require_once('regions.php');
        $depts = $regions[$region];
    ?>
    
    <h1><?php echo $region;?></h1>

    <ul>
        <?php 
            foreach ($depts as $num) {
        ?>
                <li><?php echo $num;?></li>
        <?php 
            }
        ?>
    </ul>

    <a href="./exo3-regions-q3.php">Retourner sur la page des regions</a>

</body>
</html>