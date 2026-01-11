<?php
// Connexion à la base de données
$host = "localhost";
$dbname = "distribill_s3";
$user = "votre_utilisateur";
$pass = "votre_mot_de_passe";

try {
    $pdo = new PDO("mysql:host=$host;dbname=$dbname", $user, $pass);
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
} catch(PDOException $e) {
    die("Erreur de connexion : " . $e->getMessage());
}

// Récupération des données de la table _dept
$query = "SELECT * FROM _dept";
$stmt = $pdo->query($query);

// Stockage des données dans un tableau associatif à deux dimensions
$departments = array();

while ($row = $stmt->fetch(PDO::FETCH_ASSOC)) {
    $deptno = $row['deptno'];
    $departments[$deptno] = $row;
}

// Affichage du tableau pour vérification (à supprimer en production)
echo "<pre>";
print_r($departments);
echo "</pre>";

// Fermeture de la connexion
$pdo = null;
?>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tableau des départements</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
            max-width: 800px;
            margin: 20px auto;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
            font-weight: bold;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        tr:hover {
            background-color: #f5f5f5;
        }
    </style>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>Deptno</th>
                <th>Dname</th>
                <th>Loc</th>
            </tr>
        </thead>
        <tbody>
            <?php foreach ($departments as $dept): ?>
            <tr>
                <td><?php echo htmlspecialchars($dept['deptno']); ?></td>
                <td><?php echo htmlspecialchars($dept['dname']); ?></td>
                <td><?php echo htmlspecialchars($dept['loc']); ?></td>
            </tr>
            <?php endforeach; ?>
        </tbody>
    </table>
</body>
</html>
