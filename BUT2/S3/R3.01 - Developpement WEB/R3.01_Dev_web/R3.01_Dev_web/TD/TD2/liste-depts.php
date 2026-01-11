<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
    </head>
    <body>
        <?php print_r($_GET[0]);?>
        <h1>Liste des départements</h1>
        <ul>
        <?php 
        require_once("./depts-fix.php");
        require_once("./regions.php");
        if ($_GET[1] == null) {
            foreach ($depts as $key => $values) {
                ?>
                <li><?php echo $values[0]?></li>
                <li><?php echo $values[1]?></li>
                <?php
            }
        } else {
            
            foreach ($depts as $key => $values) {
                if (strcmp($values,$_GET[0])) {
                    ?>
                    <li><?php echo $values[0]?></li>
                    <li><?php echo $values[1]?></li>
                    <?php
                } else {?>
                    <li><?php echo $values[0]?></li>
                    <li><?php echo $values[1]?></li> <?php
                }
            }
        }
        ?>
        </ul>
    </body>
</html>