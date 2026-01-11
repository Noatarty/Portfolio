<?php
require_once __DIR__ . '/../config/database.php';
require_once __DIR__ . '/../models/filldb.php';

class FilldbController {
    private $conn;

    public function __construct() {
        $database = new Database();
        $this->conn = $database->getConnection();
    }

    public function createEquipe($code_pays, $nom_pays, $poule) {
        $trip = new Filldb($this->conn);
        return $trip->addEquipe($code_pays, $nom_pays, $poule);
    }

}
?>