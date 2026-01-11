```Schéma 1``` 
sql
CREATE TABLE centre (
    nom_centre VARCHAR(30),
    capacite_centre INTEGER,
    nom_pays VARCHAR(30),
    CONSTRAINT centre_pk
        PRIMARY KEY (nom_centre)
);

CREATE TABLE semaine (
    no_semaine INTEGER,
    CONSTRAINT semaine_pk
        PRIMARY KEY (no_semaine)
);

CREATE TABLE activite (
    cod_act VARCHAR(30),
    lib_act VARCHAR(30),
    CONSTRAINT activite_pk
        PRIMARY KEY (cod_act)
);

CREATE TABLE stage (
    no_stage INTEGER,
    niveau_stage VARCHAR(30),
    nom_centre VARCHAR(30),
    no_semaine INTEGER,
    code_act VARCHAR(30),
    CONSTRAINT stage_pk
        PRIMARY KEY (no_stage),
    CONSTRAINT stage_fk1
        FOREIGN KEY (nom_centre) REFERENCES centre(nom_centre),
    CONSTRAINT stage_fk2
        FOREIGN KEY (no_semaine) REFERENCES semaine(no_semaine),
    CONSTRAINT stage_fk3
        FOREIGN KEY (code_act) REFERENCES activite(cod_act)
);

CREATE TABLE encadre (
    nom_resp VARCHAR(30),
    no_stage INTEGER,
    CONSTRAINT encadre_pk
        PRIMARY KEY (no_stage),
    CONSTRAINT encadre_fk1
        FOREIGN KEY (no_stage) REFERENCES stage(no_stage)
);

CREATE TABLE client (
    no_client INTEGER,
    nom VARCHAR(30),
    prenom VARCHAR(30),
    adresse VARCHAR(30),
    code_postal VARCHAR(30),
    ville VARCHAR(30),
    tel_client VARCHAR(30),
    CONSTRAINT client_pk
        PRIMARY KEY (no_client)
);

CREATE TABLE inscription (
    no_client INTEGER,
    no_stage INTEGER,
    date_inscription VARCHAR(30),
    CONSTRAINT inscription_pk
        PRIMARY KEY (no_client, no_stage),
    CONSTRAINT inscription_fk1
        FOREIGN KEY (no_client) REFERENCES client(no_client),
    CONSTRAINT inscription_fk2
        FOREIGN KEY (no_stage) REFERENCES stage(no_stage)
);

```Schéma 2``` 

sql
CREATE TABLE ville (
    nom_v CHAR,
    nb_habit INTEGER,
    nom_p CHAR,
    CONSTRAINT ville_pk
        PRIMARY KEY (nom_v)
);

CREATE TABLE pays (
    nom_p CHAR,
    superficie INTEGER,
    popul INTEGER,
    capitale CHAR,
    CONSTRAINT pays_pk
        PRIMARY KEY (nom_p),
    CONSTRAINT pays_pk
        PRIMARY KEY (capitale),
    CONSTRAINT pays_fk1
        FOREIGN KEY (capitale) REFERENCES ville(nom_v)
);
ALTER TABLE ville
ADD CONSTRAINT ville_fk1
        FOREIGN KEY (nom_p) REFERENCES pays(nom_p);
