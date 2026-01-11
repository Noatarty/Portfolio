<?php
require_once __DIR__ . '/../config/database.php';
require_once __DIR__ . '/../models/user.php';

class UserController {
    private $conn;

    public function __construct() {
        $database = new Database();
        $this->conn = $database->getConnection();
    }

    public function listUsers() {
        $user = new User($this->conn);
        return $user->readAll();
    }

    public function createUser ($nom, $pseudo, $email, $password) {
        $user = new User($this->conn);
        return $user->addUser ($nom, $pseudo, $email, $password);
    }

    public function updateUser ($id, $nom, $pseudo, $email) {
        $user = new User($this->conn);
        return $user->alterUser ($id, $nom, $pseudo, $email);
    }

    public function deleteUser ($id) {
        $user = new User($this->conn);
        return $user->deleteUser ($id);
    }
}
?>