<?php
// Charger les données du fichier
$data = unserialize(file_get_contents('data'));

// Vérifier si les paramètres sont présents
if (isset($_GET['code']) && isset($_GET['qte'])) {
    $code = $_GET['code'];
    $qte = intval($_GET['qte']);

    // Vérifier si l'article existe
        if ($qte > 0) {
            // Réassort d'article
            $data[$code]['stock'] += $qte;
            $message = "Réassort de $qte unités effectué pour l'article $code.";
        } elseif ($qte < 0) {
            // Vente d'article
            if ($data[$code]['stock'] >= abs($qte)) {
                $data[$code]['stock'] += $qte; // Retirer du stock
                $data[$code]['vendu'] -= $qte; // Ajouter aux ventes (on soustrait car $qte est négatif)
                $message = "Vente de " . abs($qte) . " unités effectuée pour l'article $code.";
            } else {
                $message = "Stock insuffisant pour l'article $code.";
            }
        } else {
            $message = "Aucune modification du stock pour l'article $code.";
        }
    } else {
        $message = "L'article $code n'existe pas.";
    }

    // Sauvegarder les modifications
    file_put_contents('data', serialize($data));

?>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestion du stock</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
        }
        .centrer { text-align: center; }
        .gauche { text-align: left; }
        .droite { text-align: right; }
        .pagination {
            margin-top: 20px;
            text-align: center;
        }
        a {
            padding: 5px 10px;
            text-decoration: none;
            background-color: #f2f2f2;
            color: black;
            border: 1px solid #ddd;
        }
        .pagination a.desactiver {
            pointer-events: none;
            color: #ccc;
        }
    </style>
</head>
<body>
    <h1>Gestion du stock</h1>
    <p><?php echo $message; ?></p>
    <a href="liste.php">Retour à la liste des articles</a>
</body>
</html>
