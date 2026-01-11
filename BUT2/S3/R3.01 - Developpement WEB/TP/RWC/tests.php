project-root/
├── config.php               # Fichier de configuration de la base de données
├── create_tables.php        # Script pour créer les tables nécessaires
├── filldb.php               # Script pour remplir la base de données
├── cleardb.php              # Script pour vider la base de données
├── fill_stage.php           # Script pour remplir les phases finales
├── index.php                # Point d'entrée principal pour les routes
├── tableau.php              # Affichage du tableau des phases finales
├── /views                   # Dossier contenant les fichiers de vues HTML
│   ├── home.php             # Page d'accueil
│   ├── matches.php          # Page pour afficher les matches de poules
│   └── team_result.php      # Page pour afficher les résultats d'une équipe
└── /data                    # Dossier contenant les fichiers de données
    ├── EQUIPES              # Fichier texte des équipes par poule
    └── MATCHES              # Fichier texte des matches de poules


// === config.php ===
// Configuration de la connexion à la base de données
<?php
$host = 'localhost';
$dbname = 'rwc2023';
$user = 'root';
$password = '';

try {
    $pdo = new PDO("mysql:host=$host;dbname=$dbname", $user, $password);
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
} catch (PDOException $e) {
    die("Erreur de connexion à la base de données : " . $e->getMessage());
}
?>

// === create_tables.php ===
// Création des tables nécessaires
<?php
require 'config.php';

$queries = [
    // Table des équipes
    "CREATE TABLE IF NOT EXISTS teams (
        id INT AUTO_INCREMENT PRIMARY KEY,
        code VARCHAR(3) NOT NULL UNIQUE,
        name VARCHAR(100) NOT NULL,
        pool VARCHAR(1) NOT NULL
    )",

    // Table des matches de poules
    "CREATE TABLE IF NOT EXISTS pool_matches (
        id INT AUTO_INCREMENT PRIMARY KEY,
        team1_code VARCHAR(3) NOT NULL,
        team2_code VARCHAR(3) NOT NULL,
        match_date DATE NOT NULL,
        score_team1 INT DEFAULT 0,
        score_team2 INT DEFAULT 0,
        points_team1 INT DEFAULT 0,
        points_team2 INT DEFAULT 0,
        FOREIGN KEY (team1_code) REFERENCES teams(code),
        FOREIGN KEY (team2_code) REFERENCES teams(code)
    )",

    // Table des matches de phases finales
    "CREATE TABLE IF NOT EXISTS final_matches (
        id INT AUTO_INCREMENT PRIMARY KEY,
        stage VARCHAR(2) NOT NULL,
        team1_code VARCHAR(3) NOT NULL,
        team2_code VARCHAR(3) NOT NULL,
        match_date DATE NOT NULL,
        score_team1 INT DEFAULT 0,
        score_team2 INT DEFAULT 0,
        FOREIGN KEY (team1_code) REFERENCES teams(code),
        FOREIGN KEY (team2_code) REFERENCES teams(code)
    )"
];

foreach ($queries as $query) {
    $pdo->exec($query);
}

echo "Tables créées avec succès.\n";
?>

// === filldb.php ===
// Script pour remplir la BDD avec les fichiers fournis
<?php
require 'config.php';

// Chargement des équipes à partir du fichier EQUIPES
echo "Chargement des données à partir du fichier EQUIPES...\n";
$filePathEquipes = '/path/to/EQUIPES';
if (!file_exists($filePathEquipes)) {
    die("Fichier EQUIPES introuvable. Assurez-vous qu'il est dans le chemin spécifié.\n");
}

$contentEquipes = file_get_contents($filePathEquipes);
pools = explode("\n", $contentEquipes);
$pdo->exec("TRUNCATE TABLE teams");

foreach ($pools as $poolLine) {
    list($pool, $teams) = explode('=', $poolLine);
    $pool = str_replace('POULE_', '', $pool);
    $teams = explode(',', $teams);

    foreach ($teams as $team) {
        list($code, $name) = explode('/', $team);
        $stmt = $pdo->prepare("INSERT INTO teams (code, name, pool) VALUES (?, ?, ?)");
        $stmt->execute([$code, $name, $pool]);
    }
}

echo "Base de données remplie avec les équipes avec succès.\n";

// Chargement des matches à partir du fichier MATCHES
echo "Chargement des données à partir du fichier MATCHES...\n";
$filePathMatches = '/path/to/MATCHES';
if (!file_exists($filePathMatches)) {
    die("Fichier MATCHES introuvable. Assurez-vous qu'il est dans le chemin spécifié.\n");
}

$contentMatches = file_get_contents($filePathMatches);
$matches = explode("\n", $contentMatches);
$pdo->exec("TRUNCATE TABLE pool_matches");

foreach ($matches as $matchLine) {
    list($teams, $details) = explode('=', $matchLine);
    list($team1, $team2) = explode('-', $teams);
    list($date, $scores, $points) = explode(',', $details);
    list($score1, $score2) = explode('-', $scores);
    list($points1, $points2) = explode('-', $points);

    $stmt = $pdo->prepare("INSERT INTO pool_matches (team1_code, team2_code, match_date, score_team1, score_team2, points_team1, points_team2) VALUES (?, ?, ?, ?, ?, ?, ?)");
    $stmt->execute([$team1, $team2, $date, $score1, $score2, $points1, $points2]);
}

echo "Base de données remplie avec les matches avec succès.\n";

// === cleardb.php ===
// Script pour vider toutes les tables
<?php
require 'config.php';

echo "Vidage de la base de données...\n";
$pdo->exec("TRUNCATE TABLE pool_matches");
$pdo->exec("TRUNCATE TABLE teams");
$pdo->exec("TRUNCATE TABLE final_matches");
echo "Base de données vidée avec succès.\n";

// === fill_stage.php ===
// Remplir les phases finales
<?php
require 'config.php';

$tour = $_GET['tour'] ?? '';
if (!in_array($tour, ['Q', 'D', 'F', 'P'])) {
    die("Tour invalide. Utilisez Q, D, F ou P.\n");
}

// Vérification si le tour est déjà rempli
$stmt = $pdo->prepare("SELECT COUNT(*) FROM final_matches WHERE stage = ?");
$stmt->execute([$tour]);
if ($stmt->fetchColumn() > 0) {
    die("Le tour $tour est déjà rempli.\n");
}

// Génération dynamique des équipes
function getTeamFromPoolPosition($pdo, $pool, $position) {
    $stmt = $pdo->prepare("SELECT code FROM teams WHERE pool = ? ORDER BY id ASC LIMIT 1 OFFSET ?");
    $stmt->execute([$pool, $position - 1]);
    return $stmt->fetchColumn();
}

switch ($tour) {
    case 'Q':
        $matches = [
            [getTeamFromPoolPosition($pdo, 'C', 1), getTeamFromPoolPosition($pdo, 'D', 2)],
            [getTeamFromPoolPosition($pdo, 'B', 1), getTeamFromPoolPosition($pdo, 'A', 2)],
            [getTeamFromPoolPosition($pdo, 'D', 1), getTeamFromPoolPosition($pdo, 'C', 2)],
            [getTeamFromPoolPosition($pdo, 'A', 1), getTeamFromPoolPosition($pdo, 'B', 2)]
        ];
        break;
    case 'D':
        $matches = [
            ['Q1_WINNER', 'Q2_WINNER'],
            ['Q3_WINNER', 'Q4_WINNER']
        ];
        break;
    case 'F':
        $matches = [['D1_WINNER', 'D2_WINNER']];
        break;
    case 'P':
        $matches = [['D1_LOSER', 'D2_LOSER']];
        break;
}

foreach ($matches as $match) {
    $stmt = $pdo->prepare("INSERT INTO final_matches (stage, team1_code, team2_code, match_date) VALUES (?, ?, ?, NOW())");
    $stmt->execute([$tour, $match[0], $match[1]]);
}

echo "Tour $tour rempli avec succès.\n";

// === tableau.php ===
// Affichage du tableau des phases finales
<?php
require 'config.php';

$stmt = $pdo->query("SELECT * FROM final_matches ORDER BY stage ASC, match_date ASC");
$matches = $stmt->fetchAll(PDO::FETCH_ASSOC);
?>
<!DOCTYPE html>
<html>
<head>
    <title>Tableau des phases finales</title>
</head>
<body>
    <h1>Tableau des phases finales</h1>
    <ul>
        <?php foreach ($matches as $match): ?>
            <li>
                <a href="?action=team-result&code=<?= htmlspecialchars($match['team1_code']) ?>">
                    <?= htmlspecialchars($match['team1_code']) ?>
                </a>
                vs
                <a href="?action=team-result&code=<?= htmlspecialchars($match['team2_code']) ?>">
                    <?= htmlspecialchars($match['team2_code']) ?>
                </a>
                (<?= htmlspecialchars($match['stage']) ?>)
            </li>
        <?php endforeach; ?>
    </ul>
</body>
</html>