#!/usr/bin/python3
# -*- coding: utf-8 -*-

# ce script python lit un fichier CSV sur stdin et produit un fichier NDJSON pour Elasticsearch sur stdout
# @author Pierre Nerzic - pierre.nerzic@univ-rennes1.fr  mars 2019

# usage: csv2ndjson.py [-h] -i INDEX -t TYPE csvfilename
#
# lecture CSV et transformation en NDJSON pour Elasticsearch
#
# positional arguments:
#   csvfilename             nom du fichier CSV à lire, stdin si absent
#
# optional arguments:
#   -h, --help              show this help message and exit
#   -i INDEX, --index INDEX nom de l'index Elasticsearch à créer
#   -t TYPE, --type TYPE    type des documents Elasticsearch à créer


import sys
import json
import argparse


# paramètres
parser = argparse.ArgumentParser(description='lecture CSV et transformation en NDJSON pour Elasticsearch')
parser.add_argument('-i', '--index', required=True,  help="nom de l'index Elasticsearch à créer")
parser.add_argument('csvfilename', nargs='?', default=sys.stdin, help="nom du fichier CSV à lire, stdin si absent")
args = parser.parse_args()


# essaie de voir de quel type est la colonne : entier, float, structure, chaîne
def convert(colonne):
    colonne = colonne.strip()
    try:
        return int(colonne)
    except:
        pass
    try:
        return float(colonne)
    except:
        pass
    if colonne.startswith('{') and colonne.endswith('}'):
        return eval(colonne)
    if colonne.startswith('[') and colonne.endswith(']'):
        return eval(colonne)
    if colonne.startswith('(') and colonne.endswith(')'):
        return eval(colonne)
    return colonne


# traiter le fichier d'entrée (sys.stdin si aucun fourni)
with open(args.csvfilename, 'rt') as entree:

    # récupérer la ligne des titres = noms des colonnes
    ligne = entree.readline()
    titres = ligne.strip()
    noms = list(map(str.lower, titres.split(";")))

    # traiter les lignes suivantes
    id = 1
    for ligne in entree:

        # JSON des métadonnées : index, type et identifiant
        meta = {"index":{"_index":"%s"%args.index,"_id":"%d"%id}}
        print(json.dumps(meta))

        # JSON des données : colonnes
        record = dict(zip(noms, map(convert, ligne.strip().split(';'))))
        record_ok = {k: v for k, v in record.items() if v != ""}
        print(json.dumps(record_ok))
        id += 1