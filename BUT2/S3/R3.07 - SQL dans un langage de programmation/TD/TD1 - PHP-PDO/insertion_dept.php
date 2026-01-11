<?php
// Connexion à la base de données
$servername = "localhost";
$username = "votre_nom_utilisateur";
$password = "votre_mot_de_passe";
$dbname = "distribill_s3";

$conn = new mysqli($servername, $username, $password, $dbname);

// Vérification de la connexion
if ($conn->connect_error) {
    die("La connexion a échoué : " . $conn->connect_error);
}

// Vérification si le formulaire a été soumis
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // Récupération des données du formulaire
    $nom_dept = $_POST['nom_dept'];
    $description = $_POST['description'];

    // Préparation de la requête SQL
    $sql = "INSERT INTO departements (nom_dept, description) VALUES (?, ?)";
    
    // Préparation de la déclaration
    $stmt = $conn->prepare($sql);
    
    // Liaison des paramètres
    $stmt->bind_param("ss", $nom_dept, $description);
    
    // Exécution de la requête
    if ($stmt->execute()) {
        echo "Nouveau département inséré avec succès";
    } else {
        echo "Erreur : " . $stmt->error;
    }

    // Fermeture de la déclaration
    $stmt->close();
}

// Fermeture de la connexion
$conn->close();
?>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajouter un nouveau département</title>
</head>
<body>
    <h2>Ajouter un nouveau département</h2>
    <form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">
        <label for="nom_dept">Nom du département:</label><br>
        <input type="text" id="nom_dept" name="nom_dept" required><br>
        <label for="description">Description:</label><br>
        <textarea id="description" name="description" rows="4" cols="50"></textarea><br>
        <input type="submit" value="Ajouter le département">
    </form>
</body>
</html>
