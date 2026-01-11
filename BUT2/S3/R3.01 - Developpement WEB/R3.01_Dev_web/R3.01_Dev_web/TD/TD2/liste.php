<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="UTF-8" />
      <meta name="viewport" content="width=device-width, initial-scale=1.0" />
      <title>Envoi de fichier</title>
   </head>
   <body>
    <a href="fiche.html">retour au formulaire</a>
    <?php
        $str=@file_get_contents('data');
        $data = unserialize($str);
        if($data) { ?>
            <table>
                <tr>
                    <th>nom</th>
                    <th>prenom</th>
                    <th>email</th>
                    <th>photo</th>
                </tr>
                <tbody>
                    <?php
                    foreach ($data as $id => $un_individu){ ?>
                        <tr>
                            <th><?php echo htmlentities($un_individu['nom'])?></th>
                            <th><?php echo htmlentities($un_individu['prenom'])?></th>
                            <th><?php echo htmlentities($un_individu['email'])?></th>
                            <th><img src="avatars/<?php echo $id.$un_individu['suffixe']?>" width="200"></th>                            
                    </tr>
                    <?php
                    }
                ?>
                </tbody>
            </table>
        <?php
        } else { ?>
            <p>liste vide</p>
        <?php
        }
        ?>
   </body>