#!/bin/bash

# ce script permet de lancer des requêtes sur Elasticsearch

## Configuration générale

# configuration
HOST=localhost
SERVEUR=http://$HOST:9200
INDEX="${SERVEUR}/${LOGNAME}-movies"

# alias et fonctions diverses
shopt -s expand_aliases
alias curljson='curl -H "Content-Type: application/json" -d @-'
function titre() {
    echo -e "\n$(tput bold)$*$(tput sgr0)"
}

titre "URL de base de cet index: ${INDEX}"



#"idimdb","title","release","runtime","budget","revenue","poster","rating"
function schema() {
    titre "création de l'index ${INDEX}"
    curljson -X PUT "${INDEX}&pretty" <<JSON
    {
        "settings": {
            "number_of_shards": 1,
            "number_of_replicas": 0
        },
        "mappings": {

                "properties": {
                    "idimdb":            { "type": "text" },
                    "title":       {"type": "text","fields": {"keyword": { "type": "keyword" }}},
                    "release":            { "type": "date" },
                    "runtime":          { "type": "integer" },
                    "budget":          { "type": "integer" },
                    "revenue":          { "type": "integer" },
                    "poster":          { "type": "text" },
                    "rating":          { "type": "float" }
                }
        }
    }
JSON
    titre "Ouvrir l'URL ${INDEX}?pretty pour vérifier le schéma"
}


## Définitions des fonctions

function donnees() {
    titre "ajout des données dans l'index"
    ./csv2ndjson.py -i "${LOGNAME}-movies" movies.csv | curl -H "Content-Type: application/x-ndjson" -XPOST "${SERVEUR}/_bulk?pretty" --data-binary @-
    titre "Ouvrir l'URL ${INDEX}/_search?pretty pour vérifier les données"
}

function deleteall() {
    titre "suppression de l'index ${LOGNAME}-movies"
    curl -X DELETE "${INDEX}?pretty"
}

## URL

function ex_0() {
    titre "60 minutes movies"
    Q='runtime:60'
    curl --get "${INDEX}/_search" --data-urlencode "q=${Q}" --data-urlencode "pretty"
    titre "Ouvrir l'URL ${INDEX}/_search?pretty&q=${Q}"
}

function ex_dsl_0() {
    titre "Less than 70 minutes movies"
    curljson -X GET "${INDEX}/_search?pretty" <<JSON
    {
      "query": {
        "range": {
            "runtime": { "lt": 70}
        }
      }
    }
JSON
}


## Appels des fonctions voulues

# commenter les fonctions qu'il ne faut pas appeler, selon ce que vous faites

# créer le schéma et les données
#deleteall
schema
#donnees

#ex_0

#ex_dsl_0