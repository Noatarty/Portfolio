<?php
$pdo = new PDO("mysql:host=mysql;dbname=biblio", "user", "password");

$backup_file = "backup_" . date("Ymd_His");
$backup_data = "";

$query = $pdo->query("SELECT * FROM livres");
while ($row = $query->fetch(PDO::FETCH_ASSOC)) {
    $backup_data .= "{$row['id']}:ADD:{$row['nom']}:{$row['auteur']}:{$row['total']}\n";
}

file_put_contents($backup_file, $backup_data);

$ftp_server = "ftp_server";
$ftp_user = "bibliotekr";
$ftp_pass = "poipoi";
$conn_id = ftp_connect($ftp_server);

if ($conn_id && ftp_login($conn_id, $ftp_user, $ftp_pass)) {
    ftp_pasv($conn_id, true);
    ftp_put($conn_id, "backups/$backup_file", $backup_file, FTP_BINARY);
    ftp_close($conn_id);
}

unlink($backup_file);
echo "Backup terminé.";
?>
