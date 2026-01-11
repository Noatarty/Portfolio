<?php
require_once __DIR__ . '/../models/match_finale.php';

class MatchFinaleController {
    private $db;

    public function __construct($db) {
        $this->db = $db;
    }

    // Lister tous les matchs de la phase finale
    public function listMatchsFinale() {
        $match = new MatchFinale($this->db);
        return $match->read();
    }

    // Ajouter un match de la phase finale
    public function addMatchFinale($code_equipe_1, $code_equipe_2, $date_match, $score_equipe_1, $score_equipe_2) {
        $match = new MatchFinale($this->db);
        $match->code_equipe_1 = $code_equipe_1;
        $match->code_equipe_2 = $code_equipe_2;
        $match->date_match = $date_match;
        $match->score_equipe_1 = $score_equipe_1;
        $match->score_equipe_2 = $score_equipe_2;
        return $match->create();
    }

    // Modifier un match de la phase finale
    public function alterMatchFinale($id, $code_equipe_1, $code_equipe_2, $date_match, $score_equipe_1, $score_equipe_2) {
        $match = new MatchFinale($this->db);
        $match->id = $id;
        $match->code_equipe_1 = $code_equipe_1;
        $match->code_equipe_2 = $code_equipe_2;
        $match->date_match = $date_match;
        $match->score_equipe_1 = $score_equipe_1;
        $match->score_equipe_2 = $score_equipe_2;
        return $match->update();
    }

    // Supprimer un match de la phase finale
    public function deleteMatchFinale($id) {
        $match = new MatchFinale($this->db);
        $match->id = $id;
        return $match->delete();
    }
}
?>
