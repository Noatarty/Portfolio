<?php

$file = file_get_contents('data.csv');
$data = unserialize($file);

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $selectedClass = $_POST['classe'];
} else {
    $selectedClass = '';
}

?>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des classes</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
        img {
            max-width: 100px;
            max-height: 100px;
        }
    </style>
</head>
<body>
    <h1>Liste des classes</h1>
    
    <form method="post">
        <label for="classe">Choisissez une classe :</label>
        <select name="classe" id="classe">
            <option value="">Sélectionnez une classe</option>
            <?php foreach ($data as $student): ?>
                <option value="<?php echo htmlspecialchars($student['classe']); ?>"><?php echo htmlspecialchars($student['classe']); ?></option>
            <?php endforeach; ?>
        </select>
        <input type="submit" value="Afficher">
    </form>

    <?php if ($selectedClass): ?>
        <h2>Classe de <?php echo htmlspecialchars($selectedClass); ?></h2>
        <table>
            <tr>
                <th>H/F</th>
                <th>NOM</th>
                <th>Prénom</th>
                <th>Email</th>
                <th>Photo</th>
            </tr>
            <?php foreach ($data as $student): ?>
                <?php if ($student['classe'] === $selectedClass): ?>
                    <tr>
                        <td><?php echo htmlspecialchars($student['Sexe']); ?></td>
                        <td><?php echo htmlspecialchars($student['Nom']); ?></td>
                        <td><?php echo htmlspecialchars($student['Prenom']); ?></td>
                        <td><?php echo htmlspecialchars($student['Email']); ?></td>
                        <td><img src="<?php echo htmlspecialchars($student['Photo']); ?>" alt="Photo de l'élève"></td>
                    </tr>
                <?php endif; ?>
            <?php endforeach; ?>
        </table>
    <?php endif; ?>
</body>
</html>