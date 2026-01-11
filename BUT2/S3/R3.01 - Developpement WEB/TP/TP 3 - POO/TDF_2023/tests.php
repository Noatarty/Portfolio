<?php
    class Coureur {
        private $numero;
        private $nom;
        private $abandon = false;

        public function __construct($numero, $nom) {
            $this->numero = $numero;
            $this->nom = $nom;
        }

        public function abandonner() {
            $this->abandon = true;
        }

        public function aAbandonne() {
            return $this->abandon;
        }

        public function getNom() {
            return $this->nom;
        }

        public function getNumero() {
            return $this->numero;
        }
    }

    class Equipe {
        private static $equipes = [];
        private $nom;
        private $numero;
        private $coureurs = [];

        public function __construct($nom, $numero) {
            $this->nom = $nom;
            $this->numero = $numero;
            self::$equipes[$numero] = $this;
        }

        public static function getEquipes() {
            return self::$equipes;
        }

        public function remplirListeCoureurs() {
            $nomFichier = str_replace(' ', '_', $this->nom);
            if (file_exists($nomFichier)) {
                $lines = file($nomFichier);
                array_shift($lines);
                foreach ($lines as $line) {
                    $line = trim($line);
                    if (!empty($line)) {
                        $numero = substr($line, 0, 2);
                        $nom = trim(substr($line, 3));
                        $this->coureurs[$numero] = new Coureur($numero, $nom);
                    }
                }
            }
        }

        public function forfait() {
            foreach ($this->coureurs as $coureur) {
                $coureur->abandonner();
            }
        }

        public static function trouveEquipe($nom) {
            foreach (self::$equipes as $equipe) {
                if ($equipe->nom === $nom) {
                    return $equipe;
                }
            }
            return false;
        }

        public static function trouveDossard($num) {
            foreach (self::$equipes as $equipe) {
                foreach ($equipe->coureurs as $coureur) {
                    if ($coureur->getNumero() == $num) {
                        return [$equipe, $coureur];
                    }
                }
            }
            return false;
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
    }

    function chargerEquipes() {
        $numero = 1;
        $lines = file('EQUIPES_TDF_2023');
        foreach ($lines as $line) {
            $nom = trim($line);
            if (!empty($nom)) {
                $equipe = new Equipe($nom, $numero);
                $equipe->remplirListeCoureurs();
                $numero++;
            }
        }
    }

    function afficherEquipes() {
        echo "<table border='1'>";
        foreach (Equipe::getEquipes() as $equipe) {
            echo "<tr>
                    <th colspan='2'>{$equipe->getNom()}</th>
                    <th>{$equipe->getNumero()}</th>
                  </tr>";
            
            foreach ($equipe->getCoureurs() as $coureur) {
                $style = $coureur->aAbandonne() ? "style='color: red;'" : "";
                echo "<tr>
                        <td>{$coureur->getNumero()}</td>
                        <td {$style}>{$coureur->getNom()}</td>
                        <td></td>
                      </tr>";
            }
        }
        echo "</table>";
    }

    // Exécution du programme
    chargerEquipes();

    // Test d'abandon et forfait
    $equipe = Equipe::trouveEquipe("COFIDIS");
    if ($equipe) {
        $equipe->forfait();
    }

    // Test d'abandon d'un coureur spécifique
    $resultat = Equipe::trouveDossard(31);
    if ($resultat) {
        $resultat[1]->abandonner();
    }

    // Affichage des résultats
    echo "<h2>Liste des équipes et coureurs</h2>";
    afficherEquipes();

    // Tests de recherche
    echo "<h2>Tests de recherche</h2>";
    echo "<pre>";
    echo "Recherche équipe COFIDIS:\n";
    var_dump(Equipe::trouveEquipe("COFIDIS"));
    echo "\nRecherche équipe BILOUTE:\n";
    var_dump(Equipe::trouveEquipe("BILOUTE"));
    echo "\nRecherche dossard 31:\n";
    var_dump(Equipe::trouveDossard(31));
    echo "\nRecherche dossard 3212:\n";
    var_dump(Equipe::trouveDossard(3212));
    echo "</pre>";
?>