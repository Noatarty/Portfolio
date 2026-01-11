<?php
class Equipe {
    private $conn;
    private $table_name = "equipes";

    public $id;
    public $code;
    public $nom;
    public $poule;

    public function __construct($db) {
        $this->conn = $db;
    }

    // Créer une nouvelle équipe
    public function create() {
        $query = "INSERT INTO " . $this->table_name . " (code, nom, poule) VALUES (:code, :nom, :poule)";
        $stmt = $this->conn->prepare($query);

        // Nettoyage des données
        $this->code = htmlspecialchars(strip_tags($this->code));
        $this->nom = htmlspecialchars(strip_tags($this->nom));
        $this->poule = htmlspecialchars(strip_tags($this->poule));

        // Liaison des paramètres
        $stmt->bindParam(':code', $this->code);
        $stmt->bindParam(':nom', $this->nom);
        $stmt->bindParam(':poule', $this->poule);

        return $stmt->execute();
    }

    // Lire toutes les équipes
    public function read() {
        $query = "SELECT * FROM " . $this->table_name;
        $stmt = $this->conn->prepare($query);
        $stmt->execute();
        return $stmt;
    }
}
?>
