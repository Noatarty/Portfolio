<?php
$articles = file('articles', FILE_IGNORE_NEW_LINES );
$tabArticles = [];
foreach ($articles as $article) {
    $champ = explode(',', $article);
    $code =  $champ[0];
    $tabArticles[$code] = [
        'code' => $code,
        'libelle' => $champ[1],
        'prix_ht' => $champ[2],
        'taux_tva' => $champ[3],
        'stock' => 0,
        'vendu' => 0
        ];
}
$serialiser = serialize($tabArticles);
file_put_contents('data', $serialiser);
if (file_exists('data')) {
    echo "Le fichier 'data' a été créé avec succès.";
} else {
    echo "Erreur lors de la création du fichier 'data'.";
}
?>
