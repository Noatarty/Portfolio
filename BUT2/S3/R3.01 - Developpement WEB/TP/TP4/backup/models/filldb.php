<?php
    class Filldb {
        private $conn;
        private $table_name1 = "equipes";
        private $table_name2 = "matchs";
    
        public function __construct($db) {
            $this->conn = $db;
        }
    
        public function addEquipe ($code_pays, $nom_pays, $poule) {
            $query = "INSERT INTO " . $this->table_name1 . " (code_pays, nom_pays, poule) VALUES (?, ?, ?)";
            $stmt = $this->conn->prepare($query);
            $stmt->execute([$code_pays, $nom_pays, $poule]);
            return $this->conn->lastInsertId();
        }
    }
?>