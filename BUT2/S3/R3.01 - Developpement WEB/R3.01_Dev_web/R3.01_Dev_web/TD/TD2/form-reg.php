<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Selecteur de régions</title>
    </head>
    <body>
        <form name="selecteur-region" method="get" action="liste-depts.php">
            <label for="nom-dept">Nom dép.</label>
            <input type=text id="nom-dept" name="saisie-nom-dept"/>
            <label for="nom-reg">Région</label>
            <select name="region" id="nom-reg">
                <option value="null">Choisissez une région</option>
                <?php
                require_once("regions.php");
                $nb = 1;
                foreach($regions as $key => $values) {
                    ?>
                    <option value="<?php echo htmlentities($key)?>"><?php echo htmlentities($key)?></option>
                    <?php
                }
                ?>
            </select>
            <button type="submit">Envoyer</button>
        </form>
    </body>
</html>