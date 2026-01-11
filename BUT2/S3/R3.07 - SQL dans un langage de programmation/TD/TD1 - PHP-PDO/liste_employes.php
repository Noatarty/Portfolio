
<?php
// Requête pour récupérer tous les employés
$sql = "SELECT * FROM employes";
$result = $conn->query($sql);

// Affichage des employés
if ($result->num_rows > 0) {
    echo "<table border='1'>
    <tr>
    <th>ID</th>
    <th>Nom</th>
    <th>Prénom</th>
    <th>Email</th>
    <th>Poste</th>
    </tr>";

    while($row = $result->fetch_assoc()) {
        echo "<tr>";
        echo "<td>" . $row["id"] . "</td>";
        echo "<td>" . $row["nom"] . "</td>";
        echo "<td>" . $row["prenom"] . "</td>";
        echo "<td>" . $row["email"] . "</td>";
        echo "<td>" . $row["poste"] . "</td>";
        echo "</tr>";
    }
    echo "</table>";
} else {
    echo "Aucun employé trouvé.";
}

// Fermeture de la connexion
$conn->close();
?>
