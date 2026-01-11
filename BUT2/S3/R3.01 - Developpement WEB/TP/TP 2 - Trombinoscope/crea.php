<?php
// Fonction de validation du numéro INSEE
function validerINSEE($numINSEEComplet) {
    $parts = explode(' / ', $numINSEEComplet);
    if (count($parts) != 2 || !preg_match('/^\d{13}$/', $parts[0]) || !preg_match('/^\d{2}$/', $parts[1])) {
        return false;
    }
    $numINSEE = $parts[0];
    $cle = $parts[1];
}

// Vérifie si le formulaire est soumis
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $nom = strtoupper(trim($_POST['nom']));
    $prenom = ucfirst(strtolower(trim($_POST['prenom'])));
    $email = trim($_POST['email']);
    $numINSEEComplet = trim($_POST['num_insee']);
    $classe = trim($_POST['classe']);
    $sexe = trim($_POST['sexe']);
    $photo = $_FILES['photo'];

    // Si pas d'erreurs, enregistre la fiche
    if (empty($errors)) {
        // Sauvegarde des informations dans data.csv
        $ligne = "$nom,$prenom,$email,$numINSEEComplet,$classe,$sexe\n";
        file_put_contents('data.csv', $ligne, FILE_APPEND);
        
        // Sauvegarde la photo avec le numéro INSEE comme nom de fichier
        move_uploaded_file($photo['tmp_name'], "photos/" . str_replace(' / ', '_', $numINSEEComplet) . ".jpg");
        
        echo "<p>Fiche créée avec succès.</p>";
    } else {
        foreach ($errors as $error) {
            echo "<p>$error</p>";
        }
    }
}
?>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Création de fiche</title>
</head>
<body>
    <h1>Créer une nouvelle fiche</h1>
    <form action="crea.php" method="post" enctype="multipart/form-data">
        <label>Nom:</label>
        <input type="text" name="nom" required><br>
        <label>Prénom:</label>
        <input type="text" name="prenom" required><br>
        <label>Email:</label>
        <input type="email" name="email" required><br>
        <label>Numéro INSEE:</label>
        <input type="text" name="num_insee" required><br>
        <label>Classe:</label>
        <select name="classe" required>
            <option value="6">6ème</option>
            <option value="5">5ème</option>
            <option value="4">4ème</option>
            <option value="3">3ème</option>
            <option value="2">2nd</option>
            <option value="1">1ère</option>
            <option value="T">Terminale</option>
        </select><br>
        <label>Sexe:</label>
        <input type="radio" name="sexe" value="H" required> Homme
        <input type="radio" name="sexe" value="F" required> Femme
        <br>
        <label>Photo (JPEG max 200 Ko):</label>
        <input type="file" name="photo" required>
        <br>
        <button type="submit">Créer la fiche</button>
    </form>
</body>
</html>