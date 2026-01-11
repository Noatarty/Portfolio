<?php
require_once __DIR__ . '/../models/trip.php';

class TripController {
    private $db;

    public function __construct($db) {
        $this->db = $db;
    }

    public function listTripsByUser ($user_id) {
        $trip = new Trip($this->db);
        return $trip->getByUser ($user_id);
    }

    public function addTrip($titre, $description, $localisation, $user_id) {
        $trip = new Trip($this->db);
        return $trip->addTrip($titre, $description, $localisation, $user_id);
    }

    public function alterTrip($id, $titre, $description, $localisation) {
        $trip = new Trip($this->db);
        return $trip->alterTrip($id, $titre, $description, $localisation);
    }

    public function deleteTrip($id) {
        $trip = new Trip($this->db);
        return $trip->deleteTrip($id);
    }
}
?>