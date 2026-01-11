<?php

function generateDocumentation($files)
{
    $documentation = "<!DOCTYPE html>\n<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"fr\" lang=\"fr\">\n<head>\n<meta charset=\"utf-8\">\n<title>Documentation technique</title>\n</head>\n<body>\n<h1>Documentation technique</h1>\n";

    foreach ($files as $file) {
        $content = file_get_contents($file);

        // En-tête de code
        preg_match("/\/\*\*(.*?)\*\//s", $content, $headerMatches);
        $documentation .= "<h2>Programme " . pathinfo($file, PATHINFO_FILENAME) . "</h2>";
        $documentation .= "<h3>En-tête de code</h3>";
        $documentation .= "<p>" . trim($headerMatches[1]) . "</p>";

        // Variables globales
        preg_match_all("/\/\*\*(.*?)\*\/\s*(\w+\s+\w+)\s*;/s", $content, $globalMatches, PREG_SET_ORDER);
        $documentation .= "<h3>Variables globales</h3>";
        $documentation .= "<table>\n<thead>\n<tr>\n<th>nom variable</th>\n<th>valeur</th>\n</tr>\n</thead>\n";
        foreach ($globalMatches as $match) {
            $documentation .= "<tr>\n<td>" . trim(strip_tags($match[1])) . "</td>\n<td>" . trim($match[2]) . "</td>\n</tr>\n";
        }
        $documentation .= "</table>";

        // Defines
        preg_match_all("/#define\s+(\w+)\s+(.*?)\n/", $content, $defineMatches, PREG_SET_ORDER);
        $documentation .= "<h3>Defines</h3>";
        $documentation .= "<table>\n<thead>\n<tr>\n<th>nom variable</th>\n<th>valeur</th>\n</tr>\n</thead>\n";
        foreach ($defineMatches as $match) {
            $documentation .= "<tr>\n<td>" . $match[1] . "</td>\n<td>" . $match[2] . "</td>\n</tr>\n";
        }
        $documentation .= "</table>";

        // Structures
        preg_match_all("/\/\*\*(.*?)\*\/\s*(typedef\s+struct\s*{.*?}.*?;)/s", $content, $structureMatches, PREG_SET_ORDER);
        $documentation .= "<h3>Structures</h3>";
        $documentation .= "<ul>\n";
        foreach ($structureMatches as $match) {
            $documentation .= "<li>\n" . trim($match[1]) . "\n<ul>\n";
            preg_match_all("/\*\/\s*(\w+\s+\w+);/s", $match[2], $structureFields);
            foreach ($structureFields[1] as $field) {
                $documentation .= "<li>\n" . trim($field) . "\n</li>\n";
            }
            $documentation .= "</ul>\n</li>\n";
        }
        $documentation .= "</ul>";
    }

    $documentation .= "</body>\n</html>";

    file_put_contents('doc-tech.html', $documentation);
}

// Fichiers à traiter
$files = ['src1.c', 'src2.c', 'src3.c'];

// Générer la documentation
generateDocumentation($files);
?>