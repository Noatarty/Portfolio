<?php
$articles = json_decode(file_get_contents(__DIR__ . '/data.json'), true);

function save($data) {
    file_put_contents(__DIR__ . '/data.json', json_encode($data, JSON_PRETTY_PRINT));
}

function Reponse($reponse, $data, $status = 200) {
    return $reponse->withJson($data)->withStatus($status);
}

$app->get('/', function($req, $rep) {
    return Reponse($rep, ['message' => 'API operationnelle']);
});

$app->get('/articles', function($req, $rep) {
    global $articles;

    $retour = [];
    foreach ($articles as $id => $article) {
        $article['id'] = $id;
        $retour[] = $article;
    }
    return Reponse($rep, $retour);
});

$app->get('/articles/{id}', function($req, $rep, $arguments) {
    global $articles;

    $id = $arguments['id'];
    if (!isset($articles[$id])) {
        return Reponse($rep, ['error' => 'Article inconnu'], 404);
    }

    $article = $articles[$id];
    $article['id'] = $id;
    return Reponse($rep, $article);
});

$app->post('/articles', function($req, $rep) {
    global $articles;

    $parametres = $req->getParsedBody();
    if (empty($parametres['nom']) || !isset($parametres['qte']) || !isset($parametres['prix'])) {
        return Reponse($rep, ['error' => 'Parametres manquants'], 400);
    }

    $id = count($articles) + 1;
    $articles[$id] = [
        'nom' => $parametres['nom'],
        'qte' => (int)$parametres['qte'],
        'prix' => (float)$parametres['prix']
    ];
    save($articles);

    return Reponse($rep, ['message' => 'Article cree', 'id' => $id], 201);
});

$app->put('/articles/{id}', function($req, $rep, $arguments) {
    global $articles;

    $id = $arguments['id'];
    if (!isset($articles[$id])) {
        return Reponse($rep, ['error' => 'Article inconnu'], 404);
    }

    $parametres = $req->getParsedBody();
    if (empty($parametres['nom']) || !isset($parametres['qte']) || !isset($parametres['prix'])) {
        return Reponse($rep, ['error' => 'Parametres manquants'], 400);
    }

    $articles[$id] = [
        'nom' => $parametres['nom'],
        'qte' => (int)$parametres['qte'],
        'prix' => (float)$parametres['prix']
    ];
    save($articles);

    return Reponse($rep, ['message' => 'Article mis a jour']);
});

$app->patch('/articles/{id}', function($req, $rep, $arguments) {
    global $articles;

    $id = $arguments['id'];
    if (!isset($articles[$id])) {
        return Reponse($rep, ['error' => 'Article inconnu'], 404);
    }

    $parametres = $req->getParsedBody();
    $article = &$articles[$id];

    if (isset($parametres['nom'])) $article['nom'] = $parametres['nom'];
    if (isset($parametres['qte'])) $article['qte'] = (int)$parametres['qte'];
    if (isset($parametres['prix'])) $article['prix'] = (float)$parametres['prix'];

    save($articles);
    return Reponse($rep, ['message' => 'Article partiellement mis a jour']);
});

$app->delete('/articles/{id}', function($req, $rep, $arguments) {
    global $articles;

    $id = $arguments['id'];
    if (!isset($articles[$id])) {
        return Reponse($rep, ['error' => 'Article inconnu'], 404);
    }

    unset($articles[$id]);
    save($articles);

    return Reponse($rep, ['message' => 'Article supprime']);
});

$app->addBodyParsingMiddleware();
$app->run();
