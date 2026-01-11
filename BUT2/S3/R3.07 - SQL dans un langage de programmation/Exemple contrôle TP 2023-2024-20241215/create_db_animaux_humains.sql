drop schema if exists tpnote cascade;

create schema tpnote;
set schema 'tpnote';


create table _personne (
  idnational    serial,
  nom           varchar(50)         not null,
  prenom        varchar(50)         not null,
  datenaissance date default now()  not null,
  constraint _personne_pk primary key (idnational),
  constraint _personne_uk unique(nom, prenom, datenaissance)
);

create table _certificat (
  idcertificat    serial,
  type            varchar(255)  not null,
  idnational      integer       not null,
  constraint _certificat_pk primary key (idcertificat),
  constraint _certificat_fk_personne -- a reçu
    foreign key(idnational) references _personne(idnational)
);
 
create table _animal (
  id              SERIAL,
  nom             varchar(50)   not null,
  anneenaissance  integer       not null,
  race            varchar(255)  not null,
  constraint _animal_pk primary key (id)
);

create table _nac(
  id  integer 
    primary key references _animal(id)
);


create table _chat(
  id    integer
    primary key references _animal(id),
  lof   boolean   not null  default false
);


create table _chien(
  id        integer   primary key references _animal(id),
  lof       boolean   not null  default false  
);

Create table _est_proprietaire_de(
  id          int primary key references _animal(id),
  idnational  int not null references _personne(idnational)
);

Create table _travail_avec(
  id          int primary key references _chien(id),
  idnational  int not null    references _personne(idnational)
);

-- Peuplement

-- Insertion des personnes
-- DELETE FROM _personne;
INSERT INTO _personne (idnational, nom,  prenom,  datenaissance) VALUES
    (1,'Patrick', 'Honattanpa', '1970-11-23'),
    (2,'Bertrand', 'Plastic', '1960-05-12'),
    (3,'Eastwood', 'Clint', '1930-05-31'),
    (4,'Christensen', 'Hayden', '1981-04-19'),
    (5,'Chalamet', 'Thimothée', '1995-12-27'),
    (6,'Chan', 'Jackie', '1954-04-07');
SELECT setval('_personne_idnational_seq',6);

-- DELETE FROM _certificat;
INSERT INTO _certificat (idnational, type) VALUES
    (1,'ACACED'),
    (1,'AAC12C'),
    (1,'Certificat de formation professionnelle'),
    (2,'ACACED'),
    (2,'Certificat de formation professionnelle'),
    (3,'ACACED'),
    (4,'ACACED'),
    (5,'ACACED'),
    (6,'ACACED'),
    (6,'AAC12C')
;

-- DELETE from _animal;
INSERT INTO _animal (id, nom, anneeNaissance ,  race) VALUES  
    (1, 'Tic','2021','Écureuil'),
    (2, 'Tac','2021','Écureuil'),
    (3, 'Marie', '2000', 'Angora turc' ), -- Pas LOF
    (4, 'Berlioz', '2000', 'Angora turc' ), -- Pas LOF
    (5, 'Toulouz', '2000', 'Angora turc' ), -- Pas LOF
    (6, 'Duchesse', '1995', 'Angora turc' ), -- Pas LOF
    (7, 'Si', '2018', 'Siamois' ),  -- Pas LOF
    (8, 'Am', '2018', 'Siamois' ),  -- Pas LOF
    (9, 'Oliver', '2000', 'Européen' ), -- Pas LOF
    (10,'Pongo', '2012', 'Dalmatien' ),
    (11,'Perdita', '1998', 'Dalmatien' ),
    (12,'Rouky', '2000', 'Fox terrier' ),
    (13,'Alpha', '2008', 'Doberman' ),
    (14,'Bêta', '2008', 'Rottweiler' ),
    (15,'Gamma', '2008', 'Bouledogue Anglais' ),
    (16,'Nana', '2020', 'Saint-Bernard' ),
    (17,'Clochard', '1995', 'Griffon x Terrier' ),
    (18,'Lady', '1995', 'Cocker espagnol' ),
    (19,'Scamp','2001','Cocker x Griffon'),
    (20,'Ouragan','1987','Berger Allemand'),
    (21,'Thor', '2022', 'Mastiff'),
    (22,'Ultron', '2023', 'Staffordshire Terrier'), -- LOF
    (23,'Anastasia', '2023', 'Staffordshire Terrier'), -- pas LOF
    (24,'Toussa', '2024', 'Tosa'), -- LOF
    (25,'Tensoon','2021','Berger Belge Groenendael '); -- pas LOF
SELECT setval('_animal_id_seq', 25);

-- DELETE FROM _chat;
INSERT INTO _chat (id,lof) VALUES
  (3, false), (4, false), (5, false), (6, false), (7, false), (8, false), (9, false);

-- DELETE FROM _nac;
INSERT INTO _nac (id) VALUES (1), (2);

-- DELETE FROM _chien;
INSERT INTO _chien (id,lof) VALUES
  (10,false), (11, false), (12, true), (13, false), (14,false),
  (15,false), (16, false), (17, false), (18, false), (19,false),
  (20,false), (21, true), (22,true), (23,false), (24,true),(25,false);

-- DELETE FROM _travail_avec;
INSERT INTO  _travail_avec(id, idnational) VALUES
(24,1),
(25,2);


-- DELETE FROM _est_proprietaire_de;
INSERT INTO _est_proprietaire_de (id, idnational) VALUES
(1,1),
(2,1),
(3,6),
(4,6),
(5,6),
(6,6),
(7,2),
(8,2),
(10,4),
(11,5),
(12,3),
(24,1),
(16,5),
(22,6),
(23,6);

-- commit; -- n'oubliez pas de cocher autocommit

-- 1. Fonction `calc_lettre_lof()`
--La fonction calcule l'initiale d'un nom pour un chien en fonction de son année de naissance. Basée sur la vue donnée : 

CREATE OR REPLACE FUNCTION calc_lettre_lof(annee_naissance INTEGER) RETURNS CHAR AS $$
DECLARE
    lettre CHAR;
BEGIN
    SELECT RIGHT(
        LEFT(REPEAT('abcdefghijlmnoprstuv', 2), annee_naissance - 1985 + 1), 1
    ) INTO lettre;
    RETURN lettre;
END;
$$ LANGUAGE plpgsql;


-- ### 2. Vues pour les NAC, les chiens et les chats
-- #### Vue pour les NAC
CREATE OR REPLACE VIEW vue_nac AS
SELECT a.id, a.nom, a.anneenaissance, a.race
FROM _nac n
JOIN _animal a ON n.id = a.id;


-- #### Vue pour les chiens
-- On utilise une fonction `calc_categorie(race VARCHAR, lof BOOLEAN)` supposée existante.

CREATE OR REPLACE VIEW vue_chien AS
SELECT a.id, a.nom, a.anneenaissance, a.race, c.lof, calc_categorie(a.race, c.lof) AS categorie
FROM _chien c
JOIN _animal a ON c.id = a.id;


-- #### Vue pour les chats

CREATE OR REPLACE VIEW vue_chat AS
SELECT a.id, a.nom, a.anneenaissance, a.race, c.lof
FROM _chat c
JOIN _animal a ON c.id = a.id;


-- ### 3. Création d’un NAC

DO $$
DECLARE
    id_animal INTEGER;
BEGIN
    -- Création de l'animal dans la table _animal
    INSERT INTO _animal (nom, anneenaissance, race) VALUES ('NOM_NAC', 2022, 'Race_NAC') RETURNING id INTO id_animal;
    
    -- Ajout dans la table _nac
    INSERT INTO _nac (id) VALUES (id_animal);
END;
$$;


-- ### 4. Suppression d’un chat à partir de son `idNational`

DO $$
DECLARE
    id_chat INTEGER;
BEGIN
    -- Récupération de l'ID de l'animal correspondant
    SELECT c.id INTO id_chat
    FROM _chat c
    JOIN _est_proprietaire_de ep ON c.id = ep.id
    WHERE ep.idnational = 123; -- Remplacer 123 par l'idNational concerné
    
    -- Suppression de l'entrée dans _chat
    DELETE FROM _chat WHERE id = id_chat;
    
    -- Suppression de l'animal dans _animal
    DELETE FROM _animal WHERE id = id_chat;
END;
$$;


-- ### 5. Vue `proprio_et_ses_animaux`

CREATE OR REPLACE VIEW proprio_et_ses_animaux AS
SELECT p.idnational, p.nom, p.prenom, a.nom AS animal_nom, 
       CASE
           WHEN n.id IS NOT NULL THEN 'NAC'
           WHEN ch.id IS NOT NULL THEN 'Chien'
           WHEN ca.id IS NOT NULL THEN 'Chat'
       END AS espece
FROM _personne p
JOIN _est_proprietaire_de ep ON p.idnational = ep.idnational
JOIN _animal a ON ep.id = a.id
LEFT JOIN _nac n ON a.id = n.id
LEFT JOIN _chien ch ON a.id = ch.id
LEFT JOIN _chat ca ON a.id = ca.id;


-- ### 6. Vue `proprio_chats_de_même_race`

CREATE OR REPLACE VIEW proprio_chats_de_même_race AS
SELECT DISTINCT p1.idnational AS id1, p1.nom AS nom1, p1.prenom AS prenom1, 
                p2.idnational AS id2, p2.nom AS nom2, p2.prenom AS prenom2, 
                a.race
FROM _personne p1
JOIN _est_proprietaire_de ep1 ON p1.idnational = ep1.idnational
JOIN _animal a ON ep1.id = a.id
JOIN _chat c ON a.id = c.id
JOIN _est_proprietaire_de ep2 ON a.id = ep2.id
JOIN _personne p2 ON ep2.idnational = p2.idnational
WHERE p1.idnational <> p2.idnational;
