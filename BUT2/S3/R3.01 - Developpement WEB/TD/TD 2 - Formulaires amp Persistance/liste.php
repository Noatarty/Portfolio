<?php
$data_file = 'data.txt';
$data = unserialize(file_get_contents($data_file));
?>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Liste des individus</title>
</head>
<body>
    <table border="1">
        <tr>
            <th>Nom</th>
            <th>Prénom</th>
            <th>Email</th>
            <th>Avatar</th>
        </tr>
        <?php foreach ($data as $id => $person): ?>
        <tr>
            <td><?= htmlspecialchars($person['nom']) ?></td>
            <td><?= htmlspecialchars($person['prenom']) ?></td>
            <td><?= htmlspecialchars($person['email']) ?></td>
            <td><img src="avatars/<?= $id ?>.png" alt="Avatar" width="50"></td>
        </tr>
        <?php endforeach; ?>
    </table>
</body>
</html>