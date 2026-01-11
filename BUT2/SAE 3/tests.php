
<?php
// Connexion à la base de données PostgreSQL
$dbconn = pg_connect("host=localhost dbname=nom_de_votre_base user=votre_utilisateur password=votre_mot_de_passe");

if (!$dbconn) {
    die("Erreur de connexion à la base de données");
}

//Exemple de Requête pour récupérer les données d'un restaurant
$query = "SELECT * FROM restaurants WHERE id = 1"; // Supposons que l'ID du restaurant est 1
$result = pg_query($dbconn, $query);

if (!$result) {
    die("Erreur lors de l'exécution de la requête");
}

$restaurant = pg_fetch_assoc($result);

// Fermeture de la connexion
pg_close($dbconn);
?>

<?php
// Connexion à la base de données
$host = 'localhost';
$dbname = 'nom_de_la_base_de_donnees';
$user = 'nom_utilisateur';
$password = 'mot_de_passe';

try {
    $pdo = new PDO("pgsql:host=$host;dbname=$dbname", $user, $password);
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
} catch (PDOException $e) {
    echo 'Erreur de connexion à la base de données : ' . $e->getMessage();
    exit();
}

// Récupération des données de la base de données
$requete = $pdo->prepare('SELECT * FROM ');
$requete->execute();
$informations_legales = $requete->fetch();

$requete = $pdo->prepare('SELECT * FROM ');
$requete->execute();
$coordonnees = $requete->fetch();

$requete = $pdo->prepare('SELECT * FROM '); 
$requete->execute();
$horaires = $requete->fetchAll();

$requete = $pdo->prepare('SELECT * FROM ');
$requete->execute();
$details = $requete->fetch();

?>