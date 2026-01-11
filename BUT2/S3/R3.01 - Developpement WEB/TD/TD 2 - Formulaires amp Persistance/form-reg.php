<?php
require_once 'regions.php';
require_once 'depts-fix.php';
?>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sélecteur de région</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
        }
        label {
            display: block;
            margin-top: 10px;
        }
        input, select {
            width: 100%;
            padding: 5px;
            margin-top: 5px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px 20px;
            margin-top: 20px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1>Sélecteur de région</h1>
    <form action="liste-depts.php" method="GET">
        <label for="nom_dept">Nom département :</label>
        <input type="text" id="nom_dept" name="nom_dept">

        <label for="region">Région :</label>
        <select id="region" name="region">
            <option value="">Choisissez une région</option>
            <?php foreach ($regions as $code => $nom) {
                echo '<option value="' . $code . '">' . $code . '</option>';
            } ?>
        </select>
        <input type="submit" value="Rechercher">
    </form>
</body>
</html>