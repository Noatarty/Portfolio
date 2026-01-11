<?php
// Supposons que $trips soit un tableau d'objets Trip passé à cette vue
if (!empty($trips)) { ?>
    <h1>Liste des Voyages</h1>
    <table>
        <tr>
            <th>Titre</th>
            <th>Description</th>
            <th>Localisation</th>
            <th>Date de Publication</th>
        </tr>
        <?php foreach ($trips as $trip) { ?>
            <tr>
                <td><?php echo htmlentities($trip->titre); ?></td>
                <td><?php echo htmlentities($trip->description); ?></td>
                <td><?php echo htmlentities($trip->localisation); ?></td>
                <td><?php echo htmlentities($trip->date_post); ?></td>
            </tr>
        <?php } ?>
    </table>
<?php } else { ?>
    <p>Aucun voyage trouvé pour cet utilisateur.</p>
<?php } ?>