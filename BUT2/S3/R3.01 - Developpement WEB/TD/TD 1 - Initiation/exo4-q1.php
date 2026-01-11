<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>exo4 q1</title>
</head>
<body>
    
    <?php 
        require_once('serial.php');
    ?>

    <p><?php echo serialize($ser_var1)?></p>
    <p><?php echo serialize($ser_var2)?></p>
    <p><?php echo serialize($ser_var3)?></p>
    <p><?php echo serialize($ser_var4)?></p>
    <p><?php echo serialize($ser_var5)?></p>

</body>
</html>