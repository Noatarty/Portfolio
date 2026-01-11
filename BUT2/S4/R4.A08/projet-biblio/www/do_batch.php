<?php
$pdo = new PDO("mysql:host=mysql;dbname=biblio", "user", "password");

$lines = file("mvt", FILE_IGNORE_NEW_LINES);
foreach ($lines as $line) {
    list($id, $action, $nom, $auteur, $qte) = explode(":", $line);

    switch ($action) {
        case "OUT":
            $pdo->exec("UPDATE livres SET pret = pret + 1 WHERE id = $id AND total > pret");
            break;
        case "IN":
            $pdo->exec("UPDATE livres SET pret = pret - 1 WHERE id = $id AND pret > 0");
            break;
        case "ADD":
            $pdo->prepare("INSERT INTO livres (nom, auteur, total, pret) VALUES (?, ?, ?, 0)")
                ->execute([$nom, $auteur, $qte]);
            break;
        case "DEL":
            $pdo->exec("UPDATE livres SET total = total - $qte WHERE id = $id AND total >= $qte");
            break;
    }
}

echo "Traitement terminé.";
?>
