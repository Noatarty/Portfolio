<?php
require_once __DIR__ . '/../models/equipe.php';

class EquipeController {
    private $db;

    public function __construct($db) {
        $this->db = $db;
    }

    // Lister toutes les équipes
    public function listEquipes() {
        $equipe = new Equipe($this->db);
        return $equipe->read();
    }

    // Ajouter une équipe
    public function addEquipe($code, $nom, $poule) {
        $equipe = new Equipe($this->db);
        $equipe->code = $code;
        $equipe->nom = $nom;
        $equipe->poule = $poule;
        return $equipe->create();
    }

    // Modifier une équipe
    public function alterEquipe($id, $code, $nom, $poule) {
        $equipe = new Equipe($this->db);
        $equipe->id = $id;
        $equipe->code = $code;
        $equipe->nom = $nom;
        $equipe->poule = $poule;
        return $equipe->update();
    }

    // Supprimer une équipe
    public function deleteEquipe($id) {
        $equipe = new Equipe($this->db);
        $equipe->id = $id;
        return $equipe->delete();
    }
}
?>
