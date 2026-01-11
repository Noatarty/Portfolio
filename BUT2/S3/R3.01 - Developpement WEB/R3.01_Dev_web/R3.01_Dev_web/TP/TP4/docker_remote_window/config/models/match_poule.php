<?php
class MatchPoule {
    private $conn;
    private $table_name = "matches_poules";

    public $id;
    public $code_equipe_1;
    public $code_equipe_2;
    public $date_match;
    public $score_equipe_1;
    public $score_equipe_2;
    public $points_equipe_1;
    public $points_equipe_2;

    public function __construct($db) {
        $this->conn = $db;
    }

    // Créer un nouveau match de poule
    public function create() {
        $query = "INSERT INTO " . $this->table_name . " 
                  (code_equipe_1, code_equipe_2, date_match, score_equipe_1, score_equipe_2, points_equipe_1, points_equipe_2) 
                  VALUES (:code_equipe_1, :code_equipe_2, :date_match, :score_equipe_1, :score_equipe_2, :points_equipe_1, :points_equipe_2)";
        $stmt = $this->conn->prepare($query);

        // Nettoyage des données
        $this->code_equipe_1 = htmlspecialchars(strip_tags($this->code_equipe_1));
        $this->code_equipe_2 = htmlspecialchars(strip_tags($this->code_equipe_2));
        $this->date_match = htmlspecialchars(strip_tags($this->date_match));
        $this->score_equipe_1 = htmlspecialchars(strip_tags($this->score_equipe_1));
        $this->score_equipe_2 = htmlspecialchars(strip_tags($this->score_equipe_2));
        $this->points_equipe_1 = htmlspecialchars(strip_tags($this->points_equipe_1));
        $this->points_equipe_2 = htmlspecialchars(strip_tags($this->points_equipe_2));

        // Liaison des paramètres
        $stmt->bindParam(':code_equipe_1', $this->code_equipe_1);
        $stmt->bindParam(':code_equipe_2', $this->code_equipe_2);
        $stmt->bindParam(':date_match', $this->date_match);
        $stmt->bindParam(':score_equipe_1', $this->score_equipe_1);
        $stmt->bindParam(':score_equipe_2', $this->score_equipe_2);
        $stmt->bindParam(':points_equipe_1', $this->points_equipe_1);
        $stmt->bindParam(':points_equipe_2', $this->points_equipe_2);

        return $stmt->execute();
    }
}
?>
