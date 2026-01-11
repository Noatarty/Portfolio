<?php
/* 
// Connexion à la base de données
$host = 'localhost';
$dbname = 'nom_de_la_base_de_donnees';
$user = 'nom_utilisateur';
$password = 'mot_de_passe';

try {
    $pdo = new PDO("pgsql:host=$host;dbname=$dbname", $user, $password);
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
} catch (PDOException $e) {
    echo 'Erreur de connexion à la base de données : ' . $e->getMessage();
    exit();
}

// Récupération des données de la base de données
$requete = $pdo->prepare('SELECT * FROM ');
$requete->execute();
$informations_legales = $requete->fetch();

$requete = $pdo->prepare('SELECT * FROM ');
$requete->execute();
$coordonnees = $requete->fetch();

$requete = $pdo->prepare('SELECT * FROM '); 
$requete->execute();
$horaires = $requete->fetchAll();

$requete = $pdo->prepare('SELECT * FROM ');
$requete->execute();
$details = $requete->fetch();
 */
?>

<!--Structure HTML, à changer toutes les valeurs en PHP quand BDD disponible (voir PDO de Noa)-->
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
                
            <div class="login_btn">
                <a href="page_connexion.php">
                    <p><img src="./images/compte.png" alt="User Icon">Se connecter</p>
                </a>
            </div>
        </header>
        <main>
            <section id="section-infos"> <!--Infos générales de l'offre-->
                <article>
                    <div>
                        <div class="ensemble">
                            <a href="https://guthib.com"><img src="images/retour.png" alt="retour" id="retour"></a>
                            <h4>Restaurant</h4>
                        </div>
                    </div>
                    <div>
                        <div id="titre">
                            <h4>La Ville Blanche</h4>
                            <p>Grand Groupe</p>
                        </div>
                        <div class="ensemble">
                            <img src="images/clockrouge.png" alt="clockrouge" class="logo">
                            <p id="etat">Fermé</p>
                        </div>
                        <div>
                        <p>Française, Gastronomique</p>
                        </div>
                    </div>
                    <div class="ensemble">
                        <img src="images/etoile.png" alt="etoile" class="logo">
                        <p>4,5 (753 avis) | <u>N°1 sur 3 restaurants à Rospez</u> | <u>€€€</u>, <u>Française</u>, <u>Européenne</u></p>
                    </div>
                    <div class="ensemble">
                        <img src="images/localisateur.png" alt="localisateur" class="logo">
                        <p>29 Route de Tréguier, 22300 Rospez France</p>
                    </div>
                    <div id="liens">
                        <div class="ensemble">
                            <img src="images/telephone.png" alt="telephone" class="logo">
                            <p><u>+33 2 96 37 04 28</u></p>
                        </div>
                        <div class="ensemble">
                            <img src="images/email.png" alt="email" class="logo">
                            <p><u>E-mail</u></p>
                        </div>
                        <div class="ensemble">
                            <img src="images/web.png" alt="web" class="logo">
                            <p><u>Site Web</u></p>
                        </div>
                    </div>
                </article>
                <article>
                    <figure>
                        <img src="images/apercu.png" alt="aperçu">
                    </figure>
                </article>
                <article>
                    <p><strong>La Ville Blanche</strong>, en plein cœur du Trégor, non loin de la côte de Granit Rose vous accueille pour le plaisir des papilles.</p>
                    <br>
                    <p>Ce petit corps de ferme repris par la famille Jaguin est devenu au fil du temps une Maison de renom. D’aventures en aventures, la passion de cette cuisine s’est maintenant transmise, des souvenirs et des moments se sont déroulés dans cette Maison symbolique de Bretagne. Gorgé d’histoire, venez continuer de l’écrire avec Maud et Yvan Guglielmetti.</p>
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
                        <p>29 Route de Tréguier, 22300 Rospez France</p>
                    </div>
                    <div>
                        <div class="ensemble">
                            <img src="images/telephone.png" alt="telephone" class="logo">
                            <p><u>+33 2 96 37 04 28</u></p>
                        </div>
                        <div class="ensemble">
                            <img src="images/email.png" alt="email" class="logo">
                            <p><u>E-mail</u></p>
                        </div>
                        <div class="ensemble">
                            <img src="images/web.png" alt="web" class="logo">
                            <p><u>Site Web</u></p>
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
                            <p>26,00 €-94,00 €</p>
                        </div>
                        <div class="ensemble">
                            <h3>Cuisine</h3>
                            <p>Française, Européenne</p>
                        </div>
                        <div class="ensemble">
                            <h3>Repas</h3>
                            <p>Déjeuner, Dîner, Boissons</p>
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
                            <td>12:00 - 13:30</td>
                        </tr>
                        <tr>
                            <td>Jeudi</td>
                            <td>12:00 - 13:30<br>19:30 - 21:00</td>
                        </tr>
                        <tr>
                            <td>Vendredi</td>
                            <td>12:00 - 13:30<br>19:30 - 21:00</td>
                        </tr>
                        <tr>
                            <td>Samedi</td>
                            <td>12:00 - 13:30<br>19:30 - 21:00</td>
                        </tr>
                        <tr>
                            <td>Dimanche</td>
                            <td>12:00 - 13:30<br>19:30 - 21:00</td>
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
    </body>
</html>
