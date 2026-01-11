<?php
// Inclusion des fichiers nécessaires
require_once __DIR__ . '/../config/database.php';
require_once __DIR__ . '/../controllers/user_controller.php';
require_once __DIR__ . '/../controllers/trip_controller.php';

// Initialisation de la base de données et des contrôleurs
$database = new Database();
$db = $database->getConnection();
$userController = new UserController($db);
$tripController = new TripController($db);

// Vérification de l'action à réaliser
$action = isset($_GET['action']) ? $_GET['action'] : 'list_users';

switch ($action) {
    case 'list_users':
        // Récupération de la liste des utilisateurs
        $stmt = $userController->listUsers();
        $users = [];
        while ($row = $stmt->fetch(PDO::FETCH_ASSOC)) {
            $users[] = $row;
        }
        require_once __DIR__ . '/views/user_list.php';
        break;

    case 'list_trips':
        // Récupération de l'ID de l'utilisateur
        $user_id = isset($_GET['user_id']) ? $_GET['user_id'] : null;
        if ($user_id) {
            $trips = $tripController->listTripsByUser ($user_id);
            require_once __DIR__ . '/views/trip_list.php';
        } else {
            echo "Aucun utilisateur spécifié.";
        }
        break;

    default:
        echo "Action non reconnue.";
        break;
}
?>

<!-- Navigation -->
<nav>
    <ul>
        <li><a href="index.php?action=list_users">Liste des Utilisateurs</a></li>
    </ul>
</nav>