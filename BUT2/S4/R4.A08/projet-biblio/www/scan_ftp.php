<?php
$ftp_server = "ftp_server";
$ftp_user = "bibliotekr";
$ftp_pass = "poipoi";
$conn_id = ftp_connect($ftp_server);

if ($conn_id && ftp_login($conn_id, $ftp_user, $ftp_pass)) {
    ftp_pasv($conn_id, true);
    $files = ftp_nlist($conn_id, ".");

    foreach ($files as $file) {
        if ($file !== "backups") {
            ftp_get($conn_id, $file, $file, FTP_BINARY);
            include "do_batch.php";
            ftp_delete($conn_id, $file);
        }
    }
    ftp_close($conn_id);
}

sleep(30);
?>
