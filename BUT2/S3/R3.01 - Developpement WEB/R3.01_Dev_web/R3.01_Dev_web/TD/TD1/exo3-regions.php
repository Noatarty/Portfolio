#!usr/bin/php

<!DOCTYPE>
<html>
    <head>
        <meta charset="utf-8">
    </head>
    <body>
        <h1>Liste des régions</h1>
        <ul>
            <?php
                require_once("./regions.php");
                $nb = 0;
                $ind =0;
                $first = false;
                $nbregions = 0;
                $nbpages = 1;
                $nbfin = 5;
                $nbdebut = 0
                ?>
                <ul>
                    <?php
                        foreach ($regions as $key => $values) {
                            $nbregions++;
                            if ($nb==5) {
                                
                                $id = "http://localhost:8888/exo3-regions.php?page=" . $ind;
                                $_GET['page'] -> $nbpages;
                                $nbpages++;
                                echo "<p id=$id>\npage" . $_GET['page'] . "\n</p>";
                                $ind++;
                                $nb=0;
                            }
                        
                            
                            echo "<li>$key</li>\n";
                            
                            
                            if ($first == false) {
                                $ref = "http://localhost:8888/exo3-regions.php?page=" . $ind++;
                                echo "<a href=$ref>page suivante</a>\n";
                                if ($nbdebut==5) {
                                    $first = true;
                                }
                                $nbdebut++;
                            }
                            else if ($nbregions == count($regions)-$nbfin) {
                                $ref2 = "http://localhost:8888/exo3-regions.php?page=" . $ind--;
                                echo "<a href=$ref2>page précedente</a>\n";
                                $nbfin--;
                            }
                            else {
                                $ref3 = "http://localhost:8888/exo3-regions".$ind--."php?page=" ;
                                $ref4 = "http://localhost:8888/exo3-regions.php?page=" . $ind++;
                                echo "<a href=$ref3>page précedente</a>\n";
                                echo "<a href=$ref4>page suivante</a>\n";
                                
                            }
                            $nb++;
                            
                        }