<?php
require_once __DIR__ . '/../config/database.php';

class User {
    private $conn;
    private $table_name = "users";
    
    public $id;
    public $nom;
    public $pseudo;
    public $email;

    public function __construct($db) {
        $this->conn = $db;
    }

    public function getAllUsers() : array {
        $query = "SELECT * FROM " . $this->table_name;
        $stmt = $this->conn->prepare($query);
        $stmt->execute();
        return $stmt->fetchAll(PDO::FETCH_CLASS, 'User ');
    }

    public function addUser ($nom, $pseudo, $email) : User {
        $query = "INSERT INTO " . $this->table_name . " (nom, pseudo, email) VALUES (:nom, :pseudo, :email)";
        $stmt = $this->conn->prepare($query);

        $stmt->bindParam(':nom', $nom);
        $stmt->bindParam(':pseudo', $pseudo);
        $stmt->bindParam(':email', $email);

        if ($stmt->execute()) {
            $this->id = $this->conn->lastInsertId();
            $this->nom = $nom;
            $this->pseudo = $pseudo;
            $this->email = $email;
            return $this;
        }

        return null;
    }

    public function alterUser ($id, $nom, $pseudo, $email) : User {
        $query = "UPDATE " . $this->table_name . " SET nom = :nom, pseudo = :pseudo, email = :email WHERE id = :id";
        $stmt = $this->conn->prepare($query);

        $stmt->bindParam(':id', $id);
        $stmt->bindParam(':nom', $nom);
        $stmt->bindParam(':pseudo', $pseudo);
        $stmt->bindParam(':email', $email);

        if ($stmt->execute()) {
            $this->id = $id;
            $this->nom = $nom;
            $this->pseudo = $pseudo;
            $this->email = $email;
            return $this;
        }

        return null;
    }

    public function deleteUser ($id) : bool {
        $query = "DELETE FROM " . $this->table_name . " WHERE id = :id";
        $stmt = $this->conn->prepare($query);
        $stmt->bindParam(':id', $id);
        return $stmt->execute();
    }
}
?>