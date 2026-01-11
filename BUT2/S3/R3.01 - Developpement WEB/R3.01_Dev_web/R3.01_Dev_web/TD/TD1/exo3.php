<!DOCTYPE>
<html>
    <head>
        <meta charset="utf-8">
    </head>
    <body>
        <pre>
            <?php
                foreach ($_GET as $key => $value) {
                    print_r("$value\n");
                }
            ?>    
        </pre>
    </body>
</html>