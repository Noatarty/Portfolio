<?php
// Fonction pour extraire les commentaires spécifiés
function extractComments($content) {
    $pattern = '/\/\*\*(.*?)\*\//s'; // Expression régulière pour les commentaires
    preg_match_all($pattern, $content, $matches);
    return $matches[0];
}

// Fonction pour générer la documentation HTML
function generateDocumentation($files, $version) {
    $defines = [];
    $structures = [];
    $globals = [];
    $functions = [];

    foreach ($files as $file) {
        $content = file_get_contents($file);

        // Extraire les commentaires et organiser les informations
        $comments = extractComments($content);

        foreach ($comments as $comment) {
            // Détecter et classifier les commentaires en fonction des catégories (Defines, Structures, Variables globales, Fonctions)
            if (strpos($comment, '#define') !== false) {
                $defines[] = $comment;
            } elseif (strpos($comment, 'typedef struct') !== false) {
                $structures[] = $comment;
            } elseif (strpos($comment, 'int ') !== false || strpos($comment, 'char ') !== false) {
                $globals[] = $comment;
            } elseif (strpos($comment, '/**') !== false) {
                $functions[] = $comment;
            }
        }
    }

    // Générer le contenu HTML avec les informations extraites
    $htmlContent = '<!DOCTYPE html><html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr"><head><meta charset="utf-8"><title>Documentation technique</title>';
    $htmlContent .= '</head><body><h1>Documentation technique</h1>';

    // Ajouter les Defines à la documentation
    if (!empty($defines)) {
        $htmlContent .= '<h3>Defines</h3>';
        foreach ($defines as $define) {
            $htmlContent .= '<table><thead><tr><th>nom variable</th><th>valeur</th></tr></thead><tr><td>Lorem ipsum dolor sit amet</td><td>consectetur adipiscing elit</td>'</tr>
            <tr>
                <td>Lorem ipsum dolor sit amet</td>
                <td>consectetur adipiscing elit</td>
            </tr>
            <tr>
                <td>Lorem ipsum dolor sit amet</td>
                <td>consectetur adipiscing elit</td>
            </tr>
            <tr>
                <td>Lorem ipsum dolor sit amet</td>
                <td>consectetur adipiscing elit</td>
            </tr>
        </table>';
        }
    }

    // Ajouter les Structures à la documentation
    if (!empty($structures)) {
        $htmlContent .= '<h3>Structures</h3>';
        foreach ($structures as $structure) {
            $htmlContent .= '<div>' . $structure . '</div>';
        }
    }

    // Ajouter les Variables globales à la documentation
    if (!empty($globals)) {
        $htmlContent .= '<h3>Variables globales</h3>';
        foreach ($globals as $global) {
            $htmlContent .= '<div>' . $global . '</div>';
        }
    }

    // Ajouter les Fonctions à la documentation
    if (!empty($functions)) {
        $htmlContent .= '<h3>Fonctions</h3>';
        foreach ($functions as $function) {
            $htmlContent .= '<div>' . $function . '</div>';
        }
    }

    $htmlContent .= '</body></html>';

    // Enregistrer le fichier HTML
    $fileName = "doc-tech-$version.html";
    file_put_contents($fileName, $htmlContent);
}

// Récupérer les fichiers .c du répertoire courant
$files = glob("*.c");
$version = isset($argv[1]) ? $argv[1] : '1.0'; // Récupérer la version du document

if (!empty($files)) {
    generateDocumentation($files, $version);
} else {
    echo "Aucun fichier .c trouvé dans le répertoire actuel.";
}
?>
