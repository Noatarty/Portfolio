<?php
require_once __DIR__ . '/../models/match_poule.php';

class MatchPouleController {
    private $db;

    public function __construct($db) {
        $this->db = $db;
    }

    // Lister tous les matchs de poule
    public function listMatchsPoules() {
        $match = new MatchPoule($this->db);
        return $match->read();
    }

    // Ajouter un match de poule
    public function addMatchPoule($code_equipe_1, $code_equipe_2, $date_match, $score_equipe_1, $score_equipe_2, $points_equipe_1, $points_equipe_2) {
        $match = new MatchPoule($this->db);
        $match->code_equipe_1 = $code_equipe_1;
        $match->code_equipe_2 = $code_equipe_2;
        $match->date_match = $date_match;
        $match->score_equipe_1 = $score_equipe_1;
        $match->score_equipe_2 = $score_equipe_2;
        $match->points_equipe_1 = $points_equipe_1;
        $match->points_equipe_2 = $points_equipe_2;
        return $match->create();
    }

    // Modifier un match de poule
    public function alterMatchPoule($id, $code_equipe_1, $code_equipe_2, $date_match, $score_equipe_1, $score_equipe_2, $points_equipe_1, $points_equipe_2) {
        $match = new MatchPoule($this->db);
        $match->id = $id;
        $match->code_equipe_1 = $code_equipe_1;
        $match->code_equipe_2 = $code_equipe_2;
        $match->date_match = $date_match;
        $match->score_equipe_1 = $score_equipe_1;
        $match->score_equipe_2 = $score_equipe_2;
        $match->points_equipe_1 = $points_equipe_1;
        $match->points_equipe_2 = $points_equipe_2;
        return $match->update();
    }

    // Supprimer un match de poule
    public function deleteMatchPoule($id) {
        $match = new MatchPoule($this->db);
        $match->id = $id;
        return $match->delete();
    }
}
?>
