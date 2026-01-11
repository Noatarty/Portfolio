<?php include('includes/header.php'); ?>
<div class="content">
    <h1>Bienvenue sur notre site</h1>
    <p>Nous sommes le <?php echo date('l, d F Y'); ?>.</p>
    <p>Votre adresse IP est : <?php echo $_SERVER['REMOTE_ADDR']; ?></p>
    <p>Vous utilisez un terminal de type : <?php echo (preg_match('/mobile/i', $_SERVER['HTTP_USER_AGENT'])) ? 'Mobile' : 'PC'; ?></p>
</div>
<?php include('includes/footer.php'); ?>
