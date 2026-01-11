<?php
    $info = $_FILES['photo'];
    if ($info && $info['error']===0)//excistence de $info
    //pas d'erreur
    {
        $nomfic = time();
        $err = false;
        $suffix = "";
        if ($info['type']==='image/png') {
            $suffix = '.png';
        }
        else if ($info['type']=='image/jpg'){
            $suffix='.jpg';
        }
        else if ($info['type']==='image/webp') {
            $suffix='.webp';
        }
        else if ($info['type']==='image/gif') {
            $suffix='.gif';
        }
        else {
            $suffix = null;
            $err = true;
        }
    }
    if ($suffix) {
        if (move_uploaded_file($info['tmp_name'], 'avatars/'.$nomfic.$suffix))//deplacement vers le dossier "avatars"
        {
            $str = @file_get_contents('data');
            $data=unserialize($str);
            if (!$data){$data=[];}
            $data[$nomfic]=[
                'nom' => $_POST['nom'],
                'prenom' => $_POST['prenom'],
                'email' => $_POST['email'],
                'suffix' => $suffix,
            ];
            file_put_contents('data', serialize($data)); //écrire dans le fichier
        } else {
            $err=true;
        }
    }
    if ($err) {
        header('location:echec.html');
    } else {
        header('location:success.html');
    }