<?php
require_once __DIR__ . '/../models/user.php';

class UserController {
    private $db;

    public function __construct($db) {
        $this->db = $db;
    }

    public function listUsers() {
        $user = new User($this->db);
        return $user->getAllUsers();
    }

    public function addUser ($nom, $pseudo, $email) {
        $user = new User($this->db);
        return $user->addUser ($nom, $pseudo, $email);
    }

    public function alterUser ($id, $nom, $pseudo, $email) {
        $user = new User($this->db);
        return $user->alterUser ($id, $nom, $pseudo, $email);
    }

    public function deleteUser ($id) {
        $user = new User($this->db);
        return $user->deleteUser ($id);
    }
}
?>