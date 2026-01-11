
<html>
    <body>
        <pre>
            <?php
                $info = file_get_contents('data');
                $albums = unserialize($info);
                $albums[2014] = [
                    'Artiste' => 'Christine and the Queens',
                    'Album' => 'Chaleur Humaine',
                    'Ventes' => 850000
                ];
                print_r($albums);
                $newinfo = serialize($albums);
                file_put_contents('data.new', $newinfo);
            ?>
        </pre>
    </body>
</html>