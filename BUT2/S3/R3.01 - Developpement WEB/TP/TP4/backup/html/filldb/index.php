<pre>
    <?php
        $tabEquipes=file('EQUIPES');
        foreach ($tabEquipes as $key => $value){
            $poule = explode("=", $tabEquipes[$key]);
            print_r($poule);
            $pays = explode(",", $poule[2]);
            print_r($pays);
        }s
        
    ?>
</pre>