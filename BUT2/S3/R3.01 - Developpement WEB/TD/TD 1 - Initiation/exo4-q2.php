<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>exo4 q1</title>
</head>
<body>

    <?php 
        $data = file_get_contents('data');
        $clear_data = unserialize($data);
        $clear_data[2014] = [
            'artiste' => 'Christine and the Queens',
            'album' => 'Chaleur Humaine',
            'ventes' => 850000
        ];

        print_r($clear_data);

        $ser_data = serialize($clear_data);
        file_put_contents('data.new', $ser_data);
    ?>

</body>
</html>