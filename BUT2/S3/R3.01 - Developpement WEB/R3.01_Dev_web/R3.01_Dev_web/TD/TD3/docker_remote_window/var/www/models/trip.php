<?php
class Trip {
    private $conn;
    private $table_name = "trips";

    public $id;
    public $name;
    public $description;
    public $user_id;
    public $complete;

    public function __construct($db) {
        $this->conn = $db;
    }

    // Méthode pour créer un nouveau voyage
    public function create() {
        $query = "INSERT INTO " . $this->table_name . " (name, description, user_id) VALUES (:name, :description, :user_id)";
        $stmt = $this->conn->prepare($query);

        // Nettoyage des données
        $this->name = htmlspecialchars(strip_tags($this->name));
        $this->description = htmlspecialchars(strip_tags($this->description));
        $this->user_id = htmlspecialchars(strip_tags($this->user_id));

        // Liaison des paramètres
        $stmt->bindParam(':name', $this->name);
        $stmt->bindParam(':description', $this->description);
        $stmt->bindParam(':user_id', $this->user_id);

        // Exécution de la requête
        if ($stmt->execute()) {
            return true;
        }
        return false;
    }

    // Méthode pour récupérer tous les voyages
    public function read() {
        $query = "SELECT * FROM " . $this->table_name;
        $stmt = $this->conn->prepare($query);
        $stmt->execute();
        return $stmt;
    }

    // Méthode pour mettre à jour un voyage
    public function update() {
        $query = "UPDATE " . $this->table_name . " SET name = :name, description = :description, complete = :complete WHERE id = :id";
        $stmt = $this->conn->prepare($query);

        // Nettoyage des données
        $this->name = htmlspecialchars(strip_tags($this->name));
        $this->description = htmlspecialchars(strip_tags($this->description));
        $this->complete = htmlspecialchars(strip_tags($this->complete));
        $this->id = htmlspecialchars(strip_tags($this->id));

        // Liaison des paramètres
        $stmt->bindParam(':name', $this->name);
        $stmt->bindParam(':description', $this->description);
        $stmt->bindParam(':complete', $this->complete);
        $stmt->bindParam(':id', $this->id);

        // Exécution de la requête
        if ($stmt->execute()) {
            return true;
        }
        return false;
    }

    // Méthode pour supprimer un voyage
    public function delete() {
        $query = "DELETE FROM " . $this->table_name . " WHERE id = :id";
        $stmt = $this->conn->prepare($query);

        // Nettoyage des données
        $this->id = htmlspecialchars(strip_tags($this->id));

        // Liaison des paramètres
        $stmt->bindParam(':id', $this->id);

        // Exécution de la requête
        if ($stmt->execute()) {
            return true;
        }
        return false;
    }
}
?>