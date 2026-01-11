# Exos

## Exo 1

```tutoriald
VAR centre BASE RELATION {
    nom_centre CHARACTER,
    capacite_centre INT,
    nom_pays CHARACTER
}
KEY {nom_centre} ;

VAR semaine BASE RELATION {
    no_semaine INT
}
KEY {no_semaine};

VAR activite BASE RELATION {
    cod_act INT,
    lib_act CHARACTER
}
KEY {cod_act};

VAR stage BASE RELATION {
    no_stage CHARACTER,
    niveau_stage INT,
    nom_centre CHARACTER,
    no_semaine INT,
    cod_act INT
}
KEY {no_stage};

CONSTRAINT stage_fk1
    stage {nom_centre} <= centre {nom_centre};
CONSTRAINT stage_fk2
    stage {no_semaine} <= semaine {no_semaine};
CONSTRAINT stage_fk3
    stage {cod_act} <= activite {cod_act};

VAR responsable BASE RELATION {
    nom_responsable CHARACTER
}KEY {nom_responsable} ;

VAR encadre BASE RELATION {
    no_stage CHARACTER,
    nom_responsable CHARACTER
}
KEY {no_stage};
CONSTRAINT encadre_fk1
    encadre {no_stage} <= stage {no_stage};
CONSTRAINT encadre_fk2
    encadre {nom_responsable} <= responsable {nom_responsable};

VAR client BASE RELATION {
    no_client INT,
    nom CHARACTER,
    prenom CHARACTER,
    adresse CHARACTER,
    code_postal INT,
    ville CHARACTER,
    tel_client INT
}
KEY {no_client} ;

VAR inscriptions BASE RELATION {
    date_inscription INT,
    no_client INT,
    no_stage CHARACTER
}
KEY {no_client,no_stage};

CONSTRAINT inscriptions_fk1
    inscriptions {no_client} = client {no_client};
    
CONSTRAINT inscriptions_fk2
    inscriptions {no_stage} <= stage {no_stage};
```

## Exo 2

```tutoriald
VAR ville BASE RELATION {
    nom_v CHARACTER,
    nb_habit INT,
    nom_p CHARACTER
}
KEY {nom_v};

VAR pays BASE RELATION {
    nom_p CHARACTER,
    superficie INT,
    popul INT
}
KEY {nom_p};

CONSTRAINT ville_fk1
    ville {nom_p} <= pays {nom_p};
```

## Exo 3

```tutoriald
VAR ville BASE RELATION {
    nom_v CHARACTER,
    nb_habit INT,
    nom_p CHARACTER
}
KEY {nom_v};

VAR pays BASE RELATION {
    nom_p CHARACTER,
    superficie INT,
    popul INT,
    capitale CHAR
}
KEY {nom_p};
KEY {capitale};

CONSTRAINT ville_fk1
    ville {nom_p} <= pays {nom_p};

```

## Exo 4

```tutoriald
VAR couleur BASE RELATION {
    couleur_fl CHARACTER
}
KEY {couleur_fl};

VAR fleur BASE RELATION {
    designation CHARACTER,
    couleur_fl CHARACTER,
    prix_vente INT
}
KEY {designation};

VAR couleur_de_fleur BASE RELATION {
    designation CHARACTER,
    couleur_fl CHARACTER,
    qte_stock INT
}
KEY {designation,couleur_fl};
CONSTRAINT couleur_de_fleur_fk1
    couleur_de_fleur {couleur_fl} <= couleur {couleur_fl};
CONSTRAINT couleur_de_fleur_fk2
    couleur_de_fleur {designation} = fleur {designation};

VAR client BASE RELATION {
    no_client INT,
    prenom CHARACTER,
    nom CHARACTER,
    adresse1 CHARACTER,
    complement_adresse1 CHARACTER,
    complement_adresse2 CHARACTER,
    code_postal CHARACTER,
    ville CHARACTER,
    CA INT
}
KEY {no_client};

VAR vente BASE RELATION{
    no_client INT,
    designation CHARACTER,
    qte_achetee INT
}
KEY {no_client,designation};
CONSTRAINT vente_fk1
    vente {no_client} <= client {no_client};
CONSTRAINT vente_fk2
    vente {designation} <= fleur {designation};
```

## Exo 5

```tutoriald
VAR dotation BASE RELATION {
    no_fournisseur INT,
    no_projet INT,
    no_article INT,
    quantite_dot INT
}
KEY {no_fournisseur,no_projet,no_article};

CONSTRAINT dotation_fk1
    dotation {no_fournisseur} <= fournisseur {no_fournisseur};
CONSTRAINT dotation_fk2
    dotation {no_projet} <= projet {no_projet};
CONSTRAINT dotation_fk3
    dotation {no_article} <= article {no_article};

VAR nomenclature BASE RELATION {
    no_composant INT,
    no_compose INT
}
KEY {no_composant,no_compose};
CONSTRAINT nomenclature_fk1
    nomenclature {no_composant} <= article {no_article};
RENAME {no_article AS no_composant};
CONSTRAINT nomenclature_fk2
    nomenclature {no_compose} <= article {no_article};
RENAME {no_article AS no_compose};
```

## Exo 6

```tutoriald
VAR eleve BASE RELATION {
    no_eleve INT,
    nom_eleve CHAR,
    prenom_eleve CHAR,
    code_classe CHAR
}
KEY {no_eleve};

VAR classe BASE RELATION {
    code_classe CHAR,
    lib_classe CHAR
}
KEY {code_classe};

CONSTRAINT eleve_fk1
    eleve {code_classe} <= classe {code_classe};

VAR delegue BASE RELATION {
    no_eleve INT,
    code_classe CHAR
}
KEY {no_eleve,code_classe};
CONSTRAINT delegue_fk1
    delegue {no_eleve} <= eleve {no_eleve};
CONSTRAINT delegue_fk2
    delegue {code_classe} <= classe {code_classe};

VAR matiere BASE RELATION {
    code_matiere CHAR,
    lib_matiere CHAR
}
KEY {code_matiere};

VAR programme BASE RELATION {
    nb_heures_hebdo INT,
    code_matiere CHAR,
    code_classe CHAR
}
KEY {code_matiere,code_classe};
CONSTRAINT programme_fk1
    programme {code_matiere} <= matiere {code_matiere};
CONSTRAINT programme_fk2
    programme {code_classe} <= classe {code_classe};

VAR enseignant BASE RELATION {
    id_enseignant INT,
    nom_ens CHAR,
    prenom_ens CHAR,
}
KEY {id_enseignant};

VAR enseigne BASE RELATION {
    id_enseignant INT,
    code_matiere CHAR,
    code_classe CHAR
}
KEY {id_enseignant,code_matiere,code_classe};
    CONSTRAINT enseigne_fk1
enseigne {id_enseignant} <= enseignant {id_enseignant};
    CONSTRAINT enseigne_fk2
enseigne {code_matiere} <= matiere {code_matiere};
    CONSTRAINT enseigne_fk3
enseigne {code_classe} <= classe {code_classe};

```

## Exo 7

```tutoriald
VAR candidat BASE RELATION {
    no_candidat INT,
    nom_candidat CHAR,
    prenom_candidat CHAR,
    adresse_classe CHAR,
    date_naissance DATE,
    lib_formation CHAR
}
KEY {no_candidat};

VAR formation BASE RELATION {
    lib_formation CHAR
}
KEY {lib_formation};

CONSTRAINT candidat_fk1
    candidat {code_formation} <= formation {lib_formation};


```
