<?php
$donnees = unserialize(file_get_contents('data'));

// Pagination
$items_par_page = 8;
$items = count($donnees);
$pages = ceil($items / $items_par_page);
$page = isset($_GET['page']) ? max(1, min($pages, intval($_GET['page']))) : 1;
$nb = ($page - 1) * $items_par_page;

$donnee = array_slice($donnees, $nb, $items_par_page);

$total_ht_stocker = 0;
$total_quantite_stocker = 0;
$total_ttc_vendue = 0;
$total_quantite_vendue = 0;

foreach ($donnees as $item) {
    $total_ht_stocker += $item['prix_ht'] * $item['stock'];
    $total_quantite_stocker += $item['stock'];
    $total_ttc_vendue += $item['prix_ht'] * (1 + $item['taux_tva'] / 100) * $item['vendu'];
    $total_quantite_vendue += $item['vendu'];
}

?>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des articles</title>
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
    <table>
        <thead>
            <tr>
                <th>Code</th>
                <th>Libellé</th>
                <th>Prix HT</th>
                <th>Taux TVA</th>
                <th>Montant TVA</th>
                <th>Prix TTC</th>
                <th>Stock</th>
                <th>Quantité vendue</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <?php foreach ($donnee as $item){ ?>
            <tr>
                <td class="centrer"><?= htmlspecialchars($item['code']) ?></td>
                <td class="gauche"><?= htmlspecialchars($item['libelle']) ?></td>
                <td class="droite"><?= number_format($item['prix_ht'], 2, ',', ' ') ?> €</td>
                <td class="droite"><?= number_format($item['taux_tva'], 2, ',', ' ') ?> %</td>
                <td class="droite"><?= number_format($item['prix_ht'] * $item['taux_tva'] / 100, 2, ',', ' ') ?> €</td>
                <td class="droite"><?= number_format($item['prix_ht'] * (1 + $item['taux_tva'] / 100), 2, ',', ' ') ?> €</td>
                <td class="centrer"><?= $item['stock'] ?></td>
                <td class="centrer"><?= $item['vendu'] ?></td>
                <td><a href="stock.php?code=<?= $item['code'] ?>&qte=10">+10</a>
                <a href="stock.php?code=<?= $item['code'] ?>?qte=-1">Vente</a></td>
            <?php } ?>
            </tr>
                
        </tbody>
    </table>

    <div class="pagination">
        <a href="?page=<?= $page - 1 ?>" <?= $page <= 1 ? 'class="desactiver"' : '' ?>>Précédent</a>
        <a href="?page=<?= $page + 1 ?>" <?= $page >= $pages ? 'class="desactiver"' : '' ?>>Suivant</a>
    </div>

    <h2>Totaux</h2>
    <p>Valeur totale HT du stock : <?= number_format($total_ht_stocker, 2, ',', ' ') ?> €</p>
    <p>Quantité totale d'articles en stock : <?= $total_quantite_stocker ?></p>
    <p>Valeur totale TTC des produits vendus : <?= number_format($total_ttc_vendue, 2, ',', ' ') ?> €</p>
    <p>Quantité totale d'articles vendus : <?= $total_quantite_vendue ?></p>
</body>
</html>
