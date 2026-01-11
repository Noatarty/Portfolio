#!usr/bin/php
<!DOCTYPE HTML>
<html>
    <head>
        <meta charset='utf-8'>
    </head>
    <body>
        <?php
            $article = file("./articles");
            foreach ($lines as $numline => $line) {
                echo $line;
            }
        ?>
    </body>
</html>