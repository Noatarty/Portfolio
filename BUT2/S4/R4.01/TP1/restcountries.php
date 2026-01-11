<?php
    // limiter à l'europe pour le foreach sinon trop de requêtes
    $pays = file_get_contents('https://restcountries.com/v3.1/region/europe?fields=name,cca3,capital,flags,currencies,languages');
    $pays = json_decode($pays, true);


    $taillePage = 10;
    $pageActuelle = $_GET['page'] ? (int)$_GET['page'] : 1;
    $index = ($pageActuelle - 1) * $taillePage;

    if ($_GET['pays'] && !empty($_GET['pays'])) {
        $recherche = strtolower($_GET['pays']);
        $pays = array_filter($pays, function($f) use ($recherche) {
            return str_contains(strtolower($f['name']['common']), $recherche);
        }
    );

    } elseif ($_GET['langue'] && !empty($_GET['langue'])) {
        $recherche = strtolower($_GET['langue']);
        $pays = array_filter($pays, function($f) use ($recherche) {
            return $f['languages'] && in_array($recherche, array_map('strtolower', $f['languages']));
        }
    );

    } elseif ($_GET['devise'] && !empty($_GET['devise'])) {
        $recherche = strtolower($_GET['devise']);
        $pays = array_filter($pays, function($f) use ($recherche) {
            return $f['currencies'] && array_key_exists(strtoupper($recherche), $f['currencies']);
        }
    );
    }

    // pages
    $totalPays = count($pays);
    $pays = array_slice($pays, $index, $taillePage);
?>

<html>
    <head>
        <title>Liste des Pays</title>
    </head>
    <body>
        <form method="GET" action="">
            <label for="pays">Nom du pays :</label>
            <input type="text" name="pays" id="pays">

            <label for="langue">Langue :</label>
            <input type="text" name="langue" id="langue">

            <label for="devise">Devise :</label>
            <input type="text" name="devise" id="devise">

            <button type="submit">Filtrer</button>
        </form>

        <table border="1">
            <tr>
                <th>Nom</th>
                <th>Code</th>
                <th>Capitale</th>
                <th>Langues</th>
                <th>Devises</th>
                <th>Drapeau</th>
            </tr>
            <?php foreach($pays as $countrie) : ?>
                <tr>
                    <td><?= $countrie['name']['common'] ?></td>
                    <td><?= $countrie['cca3'] ?></td>
                    <td><?= $countrie['capital'][0] ? $countrie['capital'][0] : 'N/A' ?></td>
                    <td>
                        <?= $countrie['languages'] ? implode(', ', $countrie['languages']) : 'N/A' ?>
                    </td>
                    <td>
                        <?= $countrie['currencies'] ? implode(', ', array_keys($countrie['currencies'])) : 'N/A' ?>
                    </td>
                    <td><img src="<?= $countrie['flags']['png'] ?>" alt="<?= $countrie['name']['common'] ?>" width="50"></td>
                </tr>
            <?php endforeach; ?>
        </table>

        <div>
            <?php if ($pageActuelle > 1): ?>
                <a href="?page=<?= $pageActuelle - 1 ?>&<?= http_build_query(array_diff_key($_GET, ['page' => ''])) ?>">Précédent</a>
            <?php endif; ?>
            <?php if ($index + $taillePage < $totalPays): ?>
                <a href="?page=<?= $pageActuelle + 1 ?>&<?= http_build_query(array_diff_key($_GET, ['page' => ''])) ?>">Suivant</a>
            <?php endif; ?>
        </div>
    </body>
</html>
