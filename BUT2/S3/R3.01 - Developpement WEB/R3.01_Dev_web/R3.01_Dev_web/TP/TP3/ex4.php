<?php
class Horodateur {
    public $label;
    public $maintenant;

    public function __construct($maintenant = null) {
        $this->maintenant = $maintenant ?? time();
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

    function estFutur($dt) {
        $bool = false;
        if ($this->difference($dt) < 0) {
            $bool = true;
        }
        return $bool;
    }

    function __destruct() {
        echo "Au revoir " . $this->label ." !\n"; //suprime en cascade :  du dernier au premier
    }
}

//creer deux objets
$h1 = new Horodateur();

$h2 = new Horodateur();

// affecter des labels
$h1->label = "Horodateur 1";
$h2->label = "Horodateur 2";

//afficher difference avec 1664524330 et 2074751530
echo "\nDifférence " . $h1->label . " :\nDate : " . $h1->fmtDate() . " avec " . date("Y-m-d", 1664524330) . " = " . $h1->difference(1664524330) . " est dans le futur : " . ($h1->estFutur(1664524330) == True ? 'Vrai' : 'Faux') . "\n";
echo "\nDifférence " . $h2->label . " :\nDate : " . $h2->fmtDate() . " avec " . date("Y-m-d", 1664524330) . " = " . $h2->difference(1664524330) . " est dans le futur : " . ($h2->estFutur(1664524330) == True ? 'Vrai' : 'Faux') . "\n";
echo "\nDifférence " . $h1->label . " :\nDate : " . $h1->fmtDate() . " avec " . date("Y-m-d", 2074751530) . " = " . $h1->difference(2074751530) . " est dans le futur : " . ($h1->estFutur(2074751530) == True ? 'Vrai' : 'Faux') . "\n";
echo "\nDifférence " . $h2->label . " :\nDate : " . $h2->fmtDate() . " avec " . date("Y-m-d", 2074751530) . " = " . $h2->difference(2074751530) . " est dans le futur : " . ($h2->estFutur(2074751530) == True ? 'Vrai' : 'Faux') . "\n\n";