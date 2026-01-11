<?php
    class User {
        private $conn;
        private $table_name = "users";
    
        public function __construct($db) {
            $this->conn = $db;
        }
    
        public function readAll() {
            $query = "SELECT id, nom, pseudo, email FROM " . $this->table_name;
            $stmt = $this->conn->prepare($query);
            $stmt->execute();
            return $stmt->fetchAll(PDO::FETCH_ASSOC);
        }
    
        public function addUser ($nom, $pseudo, $email, $password) {
            $query = "INSERT INTO " . $this->table_name . " (nom, pseudo, email, password) VALUES (?, ?, ?, ?)";
            $stmt = $this->conn->prepare($query);
            $stmt->execute([$nom, $pseudo, $email, password_hash($password, PASSWORD_BCRYPT)]);
            return $this->conn->lastInsertId();
        }
    
        public function alterUser ($id, $nom, $pseudo, $email) {
            $query = "UPDATE " . $this->table_name . " SET nom = ?, pseudo = ?, email = ? WHERE id = ?";
            $stmt = $this->conn->prepare($query);
            $stmt->execute([$nom, $pseudo, $email, $id]);
            return $this->readById($id);
        }
    
        public function deleteUser ($id) {
            $query = "DELETE FROM " . $this->table_name . " WHERE id = ?";
            $stmt = $this->conn->prepare($query);
            return $stmt->execute([$id]);
        }
    
        public function readById($id) {
            $query = "SELECT * FROM " . $this->table_name . " WHERE id = ?";
            $stmt = $this->conn->prepare($query);
            $stmt->execute([$id]);
            return $stmt->fetch(PDO::FETCH_ASSOC);
        }
    }
?>