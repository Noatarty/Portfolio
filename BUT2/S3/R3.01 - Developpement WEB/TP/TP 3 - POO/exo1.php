<?php
    class Horodateur {
        public $maintenant;
        public $label;
        
        function __construct() {
            $this->maintenant = time();
        }

        function __destruct() {
            echo "Au revoir " . $this->label . "\n";
        }
        
        function fmtDate() {
            return date("Y-m-d", $this->maintenant);
        }
        
        function fmtHeure() {
            return date("H:i:s", $this->maintenant);
        }
        
        function difference($dt) {
            return $this->maintenant - $dt;
        }

        function estFuture($dt) {
            return $this->maintenant > $dt;
        }
    }

    $horodateur1 = new Horodateur();
    $horodateur1->label = "Horodateur 1";

    $horodateur2 = new Horodateur();
    $horodateur2->label = "Horodateur 2";

    $timestamp1 = 1664524330;
    $timestamp2 = 2074751530;

    echo $horodateur1->label . " - Différence avec " . $timestamp1 . " : " . $horodateur1->difference($timestamp1) . " secondes\n";
    echo $horodateur2->label . " - Différence avec " . $timestamp2 . " : " . $horodateur2->difference($timestamp2) . " secondes\n";
    echo $horodateur1->label . " - Est futur ? " . ($horodateur1->estFuture($timestamp1) ? "Oui" : "Non") . "\n";
    echo $horodateur2->label . " - Est futur ? " . ($horodateur2->estFuture($timestamp2) ? "Oui" : "Non") . "\n";
?>