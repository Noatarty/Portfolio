<?php
class Coureur {
    private $numero;
    private $nom;
    private $abandon = false;

    public function __construct($numero, $nom) {
        $this->numero = $numero;
        $this->nom = $nom;
    }

    public function getNom() {
        return $this->nom;
    }

    public function getNumero() {
        return $this->numero;
    }

    public function abandonner() {
        $this->abandon = true;
    }

    public function aAbandonne() {
        return $this->abandon;
    }
}

class Equipe {
    private $numero;
    private $nom;
    private $coureurs = [];
    private $forfait = false;

    public function __construct($numero, $nom) {
        $this->numero = $numero;
        $this->nom = $nom;
    }

    public function getNom() {
        return $this->nom;
    }

    public function getNumero() {
        return $this->numero;
    }

    public function getCoureurs() {
        return $this->coureurs;
    }

    public function remplirListeCoureurs() {
        $filename = str_replace(' ', '_', $this->nom);
        if (file_exists($filename)) {
            $lines = file($filename);
            array_shift($lines);
            foreach ($lines as $line) {
                $data = explode(' ', trim($line), 2);
                if (count($data) == 2) {
                    $numero = (int)$data[0];
                    $nom = $data[1];
                    $this->coureurs[$numero] = new Coureur($numero, $nom);
                }
            }
        }
    }

    public function declarareForfait() {
        $this->forfait = true;
    }

    public function aForfait() {
        return $this->forfait;
    }
}

$equipes = [];
$teamsFile = file('./TDF_2023/EQUIPES_TDF_2023');
foreach ($teamsFile as $line) {
    $data = explode(' ', trim($line), 2);
    if (count($data) == 2) {
        $numero = (int)$data[0];
        $nom = $data[1];
        $equipe = new Equipe($numero, $nom);
        $equipe->remplirListeCoureurs();
        $equipes[$numero] = $equipe;
    }
}

foreach ($equipes as $equipe) {
    if (!$equipe->aForfait()) {
        echo "<h2>{$equipe->getNom()}</h2>\n";
        echo "<p>Équipe numéro {$equipe->getNumero()}</p>\n";
        echo "<ul>\n";
        foreach ($equipe->getCoureurs() as $coureur) {
            if (!$coureur->aAbandonne()) {
                echo "<li>{$coureur->getNumero()} {$coureur->getNom()}</li>\n";
            }
        }
        echo "</ul>\n";
    }
}
?>
