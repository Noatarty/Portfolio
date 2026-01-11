<?php
    require_once "db_connection.php";
?>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Affichage détaillé</title>
        <link rel="stylesheet" href="style.css">
        <link rel="icon" href="images/logo.png">
    </head>
    <body>
        <header>
            <a href="accueil.php">
                <img src="./images/logo.png" alt="PACT Logo">
            </a>
            <div class="recherche_boite">
                <input type="text" placeholder="Rechercher une offre">
                <button class="recherche_btn">
                    <img src="./images/loupe.png" alt="Search">
                </button>
            </div>
            
            <div class="dropdown">
                <button class="bloc-top">
                    <img src="./images/compte.png" alt="User Icon">
                    <span>Se connecter</span>
                </button>
                <div class="bloc-links">
                    <ul>
                        <li>
                            <a href="#">Mon compte</a>
                        </li>
                        <li>
                            <a href="page_connexion.php">Se connecter</a>
                        </li>
                    </ul>
                </div>
            </div>
        </header>
        <main>
            <section id="section-infos"> <!--Infos générales de l'offre-->
                <article>
                    <div>
                        <div class="ensemble">
                            <a href="https://guthib.com"><img src="images/retour.png" alt="retour" id="retour"></a>
                            <h4><?php echo $offre->typeRepas; ?></h4> 
                        </div>
                    </div>
                    <div>
                        <div id="titre">
                            <h4><?php echo $offre->nom; ?></h4> 
                            <p><?php echo $offre->denominationPro; ?></p>
                        </div>
                        <div class="ensemble">
                            <img src="images/clockrouge.png" alt="clockrouge" class="logo"> <p id="etat"><?php echo $offre->etat; ?></p>
                        </div>
                        <div>
                        <p><?php echo $offre->cuisine; ?></p>
                        </div>
                    </div>
                    <div class="ensemble">
                        <img src="images/etoile.png" alt="etoile" class="logo">
                        <p><?php echo $offre->note; ?> (<?php echo $offre->nbAvis; ?> avis) | <?php echo $offre->classement; ?> sur <?php echo $offre->nbResto; ?> restaurants à <?php echo $offre->ville; ?> | <?php echo $offre->prix; ?>, <?php echo $offre->cuisine; ?>, <?php echo $offre->typeCuisine; ?></p>
                    </div>
                    <div class="ensemble">
                        <img src="images/localisateur.png" alt="localisateur" class="logo">
                        <p><?php echo $offre->adresse; ?> <?php echo $offre->codePostal; ?> <?php echo $offre->ville; ?> France</p>
                    </div>
                    <div id="liens">
                        <div class="ensemble">
                            <img src="images/telephone.png" alt="telephone" class="logo">
                            <p><u><?php echo $offre->telephone; ?></u></p>
                        </div>
                        <div class="ensemble">
                            <img src="images/email.png" alt="email" class="logo">
                            <p><u><?php echo $offre->email; ?></u></p>
                        </div>
                        <div class="ensemble">
                            <img src="images/web.png" alt="web" class="logo">
                            <p><u><?php echo $offre->siteWeb; ?></u></p>
                        </div>
                    </div>
                </article>
                <article>
                    <figure>
                        <img src="images/apercu.png" alt="aperçu">
                    </figure>
                </article>
                <article>
                    <p><strong><?php echo $offre->nom; ?></strong>, en plein cœur du <?php echo $offre->region; ?>, non loin de la <?php echo $offre->cote; ?> vous accueille pour le plaisir des papilles.</p>
                    <br>
                    <p>Ce petit corps de ferme repris par la famille <?php echo $offre->nomFamille; ?> est devenu au fil du temps une Maison de renom. D’aventures en aventures, la passion de cette cuisine s’est maintenant transmise, des souvenirs et des moments se sont déroulés dans cette Maison symbolique de <?php echo $offre->region; ?>. Gorgé d’histoire, venez continuer de l’écrire avec <?php echo $offre->prenom; ?> et <?php echo $offre->nom; ?>.</p>
                </article>
            </section>
            <div>
                <section class="bloc"> <!--Emplacement et coordonnées-->
                    <div>
                        <h4>Emplacement et coordonnées</h4>
                    </div>
                    <figure>
                        <img src="images/carte.png" alt="carte">
                    </figure>
                    <div class="ensemble">
                        <img src="images/localisateur.png" alt="localisateur" class="logo">
                        <p><?php echo $offre->adresse; ?> <?php echo $offre->codePostal; ?> <?php echo $offre->ville; ?> France</p>
                    </div>
                    <div>
                        <div class="ensemble">
                            <img src="images/telephone.png" alt="telephone" class="logo">
                            <p><u><?php echo $offre->telephone; ?></u></p>
                        </div>
                        <div class="ensemble">
                            <img src="images/email.png" alt="email" class="logo">
                            <p><u><?php echo $offre->email; ?></u></p>
                        </div>
                        <div class="ensemble">
                            <img src="images/web.png" alt="web" class="logo">
                            <p><u><?php echo $offre->siteWeb; ?></u></p>
                        </div>
                    </div>
                </section>
                <section class="petit-bloc"> <!--Détails-->
                    <div>
                        <h4>Détails</h4>
                    </div>
                    <div id="details">
                        <div class="ensemble">
                            <h3>Fourchette des prix</h3>
                            <p><?php echo $offre->prixMin; ?>-<?php echo $offre ->prixMax; ?> €</p>
                        </div>
                        <div class="ensemble">
                            <h3>Cuisine</h3>
                            <p><?php echo $offre->cuisine; ?>, <?php echo $offre->typeCuisine; ?></p>
                        </div>
                        <div class="ensemble">
                            <h3>Repas</h3>
                            <p><?php echo $offre->repas; ?></p>
                        </div>
                    </div>
                </section>
                <section class="petit-bloc"> <!--Horaires-->
                    <div>
                        <h4>Horaires</h4>
                    </div>
                    <table>
                        <tr>
                            <td>Mercredi</td>
                            <td><?php echo $offre->heureOuvertureMercredi; ?>-<?php echo $offre->heureFermetureMercredi; ?></td>
                        </tr>
                        <tr>
                            <td>Jeudi</td>
                            <td><?php echo $offre->heureOuvertureJeudi; ?>-<?php echo $offre->heureFermetureJeudi; ?></td>
                        </tr>
                        <tr>
                            <td>Vendredi</td>
                            <td><?php echo $offre->heureOuvertureVendredi; ?>-<?php echo $offre->heureFermetureVendredi; ?></td>
                        </tr>
                        <tr>
                            <td>Samedi</td>
                            <td><?php echo $offre->heureOuvertureSamedi; ?>-<?php echo $offre->heureFermetureSamedi; ?></td>
                        </tr>
                        <tr>
                            <td>Dimanche</td>
                            <td><?php echo $offre->heureOuvertureDimanche; ?>-<?php echo $offre->heureFermetureDimanche; ?></td>
                        </tr>
                    </table>
                </section>
            </div>
        </main>
        <footer>
            <div class="footer_container">
                <div class="footer_logo">
                    <img src="./images/logo.png" alt="PACT Logo" class="footer-logo">
                </div>
                
                <div class="contact_info">
                    <h3>Nous contacter</h3>
                    <p>Rue Edouard Branly, 22300<br>Lannion</p>
                    <p>02 96 48 36 57</p>
                    <a href="mailto:tripenarvor@outlook.fr">tripenarvor@outlook.fr</a>
                </div>
    
                <div class="footer_right">
                    <h3>Informations légales</h3>
                    <ul>
                        <li><a href="#">Mentions légales</a></li>
                        <li><a href="#">Conditions générales de ventes</a></li>
                        <li><a href="#">Données personnelles</a></li>
                        <li><a href="#">Gestions des cookies</a></li>
                    </ul>
                </div>
            </div>
        </footer>
    <script src="menu.js"></script>
    </body>
</html>