<?php
// Supposons que $users soit un tableau d'objets User passé à cette vue
if (!empty($users)) { ?>
    <h1>Liste des Utilisateurs</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Pseudo</th>
            <th>Email</th>
            <th>Voyages</th>
        </tr>
        <?php foreach ($users as $user) { ?>
            <tr>
                <td><?php echo htmlentities($user->id); ?></td>
                <td><?php echo htmlentities($user->nom); ?></td>
                <td><?php echo htmlentities($user->pseudo); ?></td>
                <td><?php echo htmlentities($user->email); ?></td>
                <td><a href="trip_list.php?user_id=<?php echo htmlentities($user->id); ?>">Voir les Voyages</a></td>
            </tr>
        <?php } ?>
    </table>
<?php } else { ?>
    <p>Aucun utilisateur trouvé.</p>
<?php } ?>