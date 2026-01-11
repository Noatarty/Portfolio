<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
    </head>
    <body>
        <h1>Liste des départements</h1>
        <a href="form-reg.php">Retour !</a>
        <?php
        require_once("regions.php");
        require_once("depts-fix.php");
        $region = trim($_GET('region'));
        if (!empty($region)) {
            $filtre_depts = $regions[$region];
        } else {
            $filtre_depts = array_keys($depts);
        }
        ?>
        <ul>
            <?php
            $nom = trim($_GET['nom-dept']);
            foreach ($filtre_depts as $un_dept) {
                $nom_dept = $depts[$un_dept] [0];
                if (empty($nom) || strstr($nom_dept, $nom)) { ?>
                    <li><?php echo htmlentities($nom_depts)?></li>
                <?php
                }
            }
            ?>
        </ul>
    </body>
</html>