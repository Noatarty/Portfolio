<?php
class Horodateur {
    public $label;
    public $maintenant;
    function setNow() {
        $this->maintenant = time();
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
}
$now = new Horodateur();
$now->setNow();
echo "Objet créé le " . $now->fmtDate() . " à " . $now->fmtHeure() . "\n";

//creer deux objets
$h1 = new Horodateur();
$h1->setNow();

$h2 = new Horodateur();
$h2->setNow();

// affecter des labels
$h1->label = "Horodateur 1";
$h2->label = "Horodateur 2";

//afficher difference avec 1664524330 et 2074751530
echo "\nDifférence " . $h1->label . " :\nDate : " . $h1->fmtDate() . " avec " . date("Y-m-d", 1664524330) . " = " . $h1->difference(1664524330);
echo "\nDifférence " . $h2->label . " :\nDate : " . $h2->fmtDate() . " avec " . date("Y-m-d", 1664524330) . " = " . $h2->difference(1664524330);
echo "\nDifférence " . $h1->label . " :\nDate : " . $h1->fmtDate() . " avec " . date("Y-m-d", 2074751530) . " = " . $h1->difference(2074751530);
echo "\nDifférence " . $h2->label . " :\nDate : " . $h2->fmtDate() . " avec " . date("Y-m-d", 2074751530) . " = " . $h2->difference(2074751530);