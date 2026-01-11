<?php
print_r($_FILES);
$types_autorisees = ['image/png', 'image/gif', 'image/jpeg', 'image/webp'];
$avatar_dir = 'avatars/';
if (
    isset($_FILES['avatar']) && $_FILES['avatar']['error'] == 0) {
    if (in_array($_FILES['avatar']['type'], $types_autorisees)) {
        $extension = pathinfo($_FILES['avatar']['name'], PATHINFO_EXTENSION);
        $nouveau_nom = time() . '.' . $extension;
        
        if (move_uploaded_file($_FILES['avatar']['tmp_name'], $avatar_dir . $nouveau_nom)) {
            echo "Avatar enregistré.";
        } else {
            echo "Erreur lors de l'enregistrement de l'avatar.";
        }
    } else {
        echo "Type de fichier non autorisé.";
    }
} else {
    echo "Pas de fichier envoyé.";
}
$fichier = 'data.txt';
$data = [];
if (file_exists($fichier)) {
    $data = unserialize(file_get_contents($fichier));
}
$donnees = [
    'nom' => $_POST['nom'],
    'prenom' => $_POST['prenom'],
    'email' => $_POST['email']
];
$data[time()] = $donnees;
file_put_contents($fichier, serialize($data));
?>