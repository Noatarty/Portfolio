<?php
// Check if the form has been submitted
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // Process the form data
    if (isset($_FILES["csv_file"]) && $_FILES["csv_file"]["error"] == 0) {
        // Open the uploaded file
        $file = file($_FILES["csv_file"]["tmp_name"], FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);
        
        // Read the file line by line
        foreach ($file as $line) {
            // Extract the data from the line using explode()
            $line_data = explode(",", $line);
            
            // Validate the data
            $insee = $line_data[0];
            $nom = $line_data[1];
            $prenom = $line_data[2];
            $email = $line_data[3];
            $sexe = $line_data[4];
            $classe = $line_data[5];
            
            // Validate the data
            // Validate the INSEE number
            if (!preg_match("/^[0-9]{13}$/", $insee)) {
                echo "Invalid INSEE number";
                continue;
            }

            // Validate the name
            if (!preg_match("/^[a-zA-Z '-]{1,40}$/", $nom)) {
                echo "Invalid name";
                continue;
            }

            // Validate the email
            if (!preg_match("/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/", $email)) {
                echo "Invalid email";
                continue;
            }

            // Validate the sexe
            if (!in_array($sexe, array("H", "F"))) {
                echo "Invalid sexe";
                continue;
            }

            // Validate the classe
            if (!in_array($classe, array("6ème", "5ème", "4ème", "3ème", "2nde", "1ère", "Terminale"))) {
                echo "Invalid classe";
                continue;
            }
            
            // Add the data to the `data.csv` file
            $fp = fopen("data.csv", "a");
            if ($fp) {
                fputcsv($fp, array($insee, $nom, $prenom, $email, $sexe, $classe));
                fclose($fp);
            } else {
                echo "Erreur lors de l'ouverture du fichier data.csv";
            }
        }
    } else {
        // Display an error message if the file upload failed
        echo "Error uploading file";
    }
} else { 
    // Display the form ?>
    <form method="post" enctype="multipart/form-data">
        <input type="file" name="csv_file" />
        <input type="submit" value="Import" />
    </form>
    <?php
}
?>