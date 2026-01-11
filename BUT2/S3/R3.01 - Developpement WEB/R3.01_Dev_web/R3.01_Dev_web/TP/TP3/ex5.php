<?php

class Coureur {
    public $num;
    public $prenom;
    public $nom;

    public $abandon;

    public function __construct($num, $prenom, $nom) {
        $this->num = $num;
        $this->prenom = $prenom;
        $this->nom = $nom;
        $this->abandon = false;
    }

    public function abandonner() {
        $this->abandon = true;
    }
}

class Equipe {
    public $num;
    public $nom;
    public $listeCoureurs = [];

    public function __construct($num, $nom) {
        $this->num = $num;
        $this->nom = $nom;
    }

    public function remplirListeCoureurs($dossier) {
        $fichierCoureurs = $dossier . '/' . $this->nom;
        $cpt1 = 0;
        if (file_exists($fichierCoureurs)) {
            $lines = file($fichierCoureurs);
            // sauter première ligne
            $lines = array_slice($lines, 1);
            foreach ($lines as $line) {
                list($num, $prenom, $nom) = explode(' ', trim($line), 3);
                $this->listeCoureurs[$cpt1] = new Coureur($num, $prenom, $nom);
                $cpt1++;
            }
        }
    }
}

$equipes = [];
$cpt = 0;

if ($dossier = opendir('./TDF_2023')) {
    while (($fichier = readdir($dossier))) {
        if ($fichier != '.' && $fichier != '' && $fichier != ".." && $fichier != ".DS_Store" && $fichier != "EQUIPES_TDF_2023") {
            $nomEquipe = pathinfo($fichier, PATHINFO_FILENAME);
            $equipes[$cpt] = new Equipe($cpt + 1, $nomEquipe); // Assigne un numéro d'équipe
            $cpt++;
        }
    }
    closedir($dossier);
}

// Remplir les listes de coureurs pour chaque équipe
foreach ($equipes as $equipe) {
    $equipe->remplirListeCoureurs('./TDF_2023');
}

?>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta lang="fr">
</head>
<body>
<h1>EQUIPES TDF 2023</h1>
<table border="1">
    <?php foreach ($equipes as $equipe): ?>
        <tr>
            <td colspan="3"><?php echo str_replace("_", " ", $equipe->nom); ?></td>
        </tr>
        <tr>

            <td rowspan="<?php echo count($equipe->listeCoureurs) + 1; ?>"><?php echo $equipe->num?></td>
            <?php foreach ($equipe->listeCoureurs as $coureur): ?>
            <tr>
            <td><?php echo $coureur->num?></td>
            <td><?php echo $coureur->prenom . " " . $coureur->nom?></td>
            </tr>
            
            
                
            <?php endforeach; ?>
        </tr>
    <?php endforeach; ?>
</table>
</body>
</html>