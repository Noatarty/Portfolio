<?php
$pdo = new PDO("mysql:host=mysql;dbname=biblio", "user", "password", array(PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8"));

$query = $pdo->query("SELECT * FROM livres");
$livres = $query->fetchAll(PDO::FETCH_ASSOC);
?>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Liste des Livres</title>
</head>
<body>
    <h1>Liste des Livres</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Auteur</th>
            <th>Total</th>
            <th>Prêtés</th>
        </tr>
        <?php foreach ($livres as $livre): ?>
            <tr>
                <td><?= $livre["id"] ?></td>
                <td><?= $livre["nom"] ?></td>
                <td><?= $livre["auteur"] ?></td>
                <td><?= $livre["total"] ?></td>
                <td><?= $livre["pret"] ?></td>
            </tr>
        <?php endforeach; ?>
    </table>
</body>
</html>
