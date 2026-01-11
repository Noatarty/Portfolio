<html>
<body>
<?php
echo '<p>Bonjour '.$_POST['uname'].', ton mot de passe est "'.$_POST['psw'].'".</p>'.PHP_EOL;
if ($_POST['remember'] == 'on') echo '<p>Je ne t\'oublierai pas.</p>';
?>
</body>
</html>
