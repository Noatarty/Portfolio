<?php
// Fonction de validation du numéro INSEE
function validerINSEE($numINSEEComplet) {
    // Séparation du numéro INSEE et de la clé avec "/"
    $parts = explode(' / ', $numINSEEComplet);
    
    // Si le format n'est pas valide (pas de clé ou mauvais format)
    if (count($parts) != 2 || !preg_match('/^\d{13}$/', $parts[0]) || !preg_match('/^\d{2}$/', $parts[1])) {
        return false;
    }
    
    $numINSEE = $parts[0];  // Les 13 chiffres
    $cle = $parts[1];  // Les 2 chiffres de la clé
}

// Vérifie si le formulaire est soumis
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_FILES['csv_file'])) {
    $file = $_FILES['csv_file']['tmp_name'];
    $handle = fopen($file, 'r');
    $errors = [];

    if ($handle !== FALSE) {
        // Parcours du fichier CSV ligne par ligne
        while (($data = fgetcsv($handle, 1000, ";")) !== FALSE) {
            // Extraction des champs du fichier CSV
            $nom = strtoupper(trim($data[0]));  // Nom en majuscules
            $prenom = ucfirst(strtolower(trim($data[1])));  // Prénom avec capitalisation
            $email = trim($data[2]);  // Email
            $numINSEEComplet = trim($data[3]);  // Numéro INSEE complet avec clé
            $classe = trim($data[4]);  // Classe
            $sexe = trim($data[5]);  // Sexe

            // Validation du numéro INSEE
            if (validerINSEE($numINSEEComplet)) {
                // Ajoute la ligne dans data.csv si valide
                $ligne = "$nom,$prenom,$email,$numINSEEComplet,$classe,$sexe\n";
                file_put_contents('data.csv', $ligne, FILE_APPEND);
            }
        }
        fclose($handle);
    }
}
?>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Importation CSV</title>
</head>
<body>
    <h1>Importer un fichier CSV</h1>
    <form action="import.php" method="post" enctype="multipart/form-data">
        <input type="file" name="csv_file" required>
        <button type="submit">Importer</button>
    </form>
</body>
</html>
