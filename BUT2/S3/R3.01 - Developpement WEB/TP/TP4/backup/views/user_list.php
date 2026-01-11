<?php if (!empty($_users_)) { ?>
    <table>
        <tr>
            <th>Code</th>
            <th>Nom</th>
            <th>Pseudos</th>
            <th>Email</th>
            <th>Voyages</th>
        </tr>
<?php foreach ($_users_ as $user) { ?>
        <tr>
            <td><?php echo htmlentities($user['id']); ?></td>
            <td><?php echo htmlentities($user['nom']); ?></td>
            <td><?php echo htmlentities($user['pseudo']); ?></td>
            <td><?php echo htmlentities($user['email']); ?></td>
            <td><a href=<?php echo "index.php?action=listTripsByUser&user_id=" .$user['id'] ?>></a>Ses Voyages...</td>
        </tr>
<?php } ?>
    </table>
<?php } else { ?>
    <p>Aucun utilisateur</p>
<?php } ?>