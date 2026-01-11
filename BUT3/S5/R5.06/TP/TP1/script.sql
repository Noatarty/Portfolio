CREATE schema "TP1-R5-06";
set schema 'TP1-R5-06';

-- Création de la table "livres"
CREATE TABLE livres (
    id_livre SERIAL PRIMARY KEY,
    titre VARCHAR(255) NOT NULL,
    auteur VARCHAR(255) NOT NULL,
    annee_publication INTEGER NOT NULL,
    prix NUMERIC(8, 2) NOT NULL
);

-- Insertion des données dans la table "livres"
INSERT INTO livres (titre, auteur, annee_publication, prix)
VALUES
    ('Harry Potter à l''école des sorciers', 'J.K. Rowling', 1997, 20.00),
    ('Le Seigneur des Anneaux - La Communauté de l''Anneau', 'J.R.R. Tolkien', 1954, 25.00),
    ('Da Vinci Code', 'Dan Brown', 2003, 18.00),
    ('Les Misérables', 'Victor Hugo', 1862, 15.00),
    ('Orgueil et Préjugés', 'Jane Austen', 1813, 12.00),
    ('1984', 'George Orwell', 1949, 16.00),
    ('Le Petit Prince', 'Antoine de Saint-Exupéry', 1943, 10.00),
    ('The Catcher in the Rye (L''Attrape-cœurs)', 'J.D. Salinger', 1951, 14.00),
    ('Moby Dick', 'Herman Melville', 1851, 22.00),
    ('Le Grand Gatsby', 'F. Scott Fitzgerald', 1925, 17.00),
    ('Guerre et Paix', 'Léon Tolstoï', 1869, 30.00),
    ('Crime et Châtiment', 'Fiodor Dostoïevski', 1866, 19.00),
    ('Cien Años de Soledad', 'Gabriel García Márquez', 1967, 21.00),
    ('La Peste', 'Albert Camus', 1947, 16.00),
    ('Le Petit Prince', 'Antoine de Saint-Exupéry', 1943, 10.00);

-- Création de la table "clients"
CREATE TABLE clients (
    id_client SERIAL PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL,
    telephone VARCHAR(20) NOT NULL
);

-- Insertion des données dans la table "clients"
INSERT INTO clients (nom, prenom, email, telephone)
VALUES
    ('Dupuis', 'Jean', 'jean.dupuis@example.com', '123-456-7890'),
    ('Martin', 'Marie', 'marie.martin@example.com', '987-654-3210'),
    ('Durand', 'Pierre', 'pierre.durand@example.com', '555-123-4567'),
    ('Dubois', 'Emma', 'emma.dubois@example.com', '111-222-3333'),
    ('Moreau', 'Louis', 'louis.moreau@example.com', '444-555-6666'),
    ('Lefebvre', 'Sophie', 'sophie.lefebvre@example.com', '333-444-5555'),
    ('Morel', 'François', 'francois.morel@example.com', '666-777-8888'),
    ('Giraud', 'Lucie', 'lucie.giraud@example.com', '999-888-7777'),
    ('Henry', 'Paul', 'paul.henry@example.com', '222-333-4444'),
    ('Girard', 'Clara', 'clara.girard@example.com', '555-111-2222');

-- Création de la table "emprunts"
CREATE TABLE emprunts (
    id_emprunt SERIAL PRIMARY KEY,
    id_client INTEGER NOT NULL REFERENCES clients(id_client),
    id_livre INTEGER NOT NULL REFERENCES livres(id_livre),
    date_emprunt DATE NOT NULL,
    date_retour DATE NOT NULL
);

-- Insertion des données dans la table "emprunts"
INSERT INTO emprunts (id_client, id_livre, date_emprunt, date_retour)
VALUES
    (1, 2, '2023-07-15', '2023-07-22'),
    (2, 4, '2023-07-16', '2023-07-23'),
    (3, 6, '2023-07-18', '2023-07-25'),
    (1, 1, '2023-07-20', '2023-07-27'),
    (4, 3, '2023-07-21', '2023-07-28'),
    (2, 5, '2023-07-24', '2023-07-31'),
    (3, 8, '2023-07-26', '2023-08-02'),
    (5, 7, '2023-08-01', '2023-08-08'),
    (6, 9, '2023-08-03', '2023-08-10'),
    (7, 10, '2023-08-05', '2023-08-12'),
    (8, 11, '2023-08-07', '2023-08-14'),
    (9, 12, '2023-08-09', '2023-08-16'),
    (5, 4, '2023-08-11', '2023-08-18'),
    (6, 3, '2023-08-13', '2023-08-20'),
    (7, 1, '2023-08-15', '2023-08-22'),

SELECT * FROM livres;

SELECT * FROM clients;

SELECT * FROM emprunts;

SELECT * FROM livres WHERE annee_publication > 2000;

SELECT * FROM clients WHERE nom LIKE 'Dupuis%';

CREATE OR REPLACE FUNCTION livres_empruntes_par_client(nom_client TEXT, prenom_client TEXT)
RETURNS TABLE(titre VARCHAR, auteur VARCHAR, annee_publication INT) AS $$
BEGIN
    RETURN QUERY
    SELECT l.titre, l.auteur, l.annee_publication
    FROM livres l
    JOIN emprunts e ON l.id_livre = e.id_livre
    JOIN clients c ON e.id_client = c.id_client
    WHERE c.nom = nom_client AND c.prenom = prenom_client;
END;
$$ LANGUAGE plpgsql;

SELECT * FROM livres_empruntes_par_client('Dupuis', 'Jean');

SELECT * FROM clients c LEFT JOIN emprunts e ON c.id_client = e.id_client WHERE e.id_client IS NULL;

SELECT COUNT(*) AS total_livres FROM livres;

SELECT COUNT(*) AS total_clients FROM clients;

SELECT COUNT(*) AS total_emprunts FROM emprunts;

CREATE TABLE livres_partitionnes (
    id_livre SERIAL,
    titre VARCHAR(255) NOT NULL,
    auteur VARCHAR(255) NOT NULL,
    annee_publication INT NOT NULL,
    PRIMARY KEY (annee_publication, id_livre)
) PARTITION BY RANGE (annee_publication);

CREATE TABLE livres_avant_2000 PARTITION OF livres_partitionnes FOR VALUES FROM (0) TO (2000);

CREATE TABLE livres_2000_2010 PARTITION OF livres_partitionnes FOR VALUES FROM (2000) TO (2010);

CREATE TABLE livres_apres_2010 PARTITION OF livres_partitionnes FOR VALUES FROM (2010) TO (2025);

INSERT INTO livres_partitionnes (id_livre, titre, auteur, annee_publication)

SELECT id_livre, titre, auteur, annee_publication FROM livres;

INSERT INTO livres_partitionnes (titre, auteur, annee_publication) VALUES ('Nouveau Livre', 'Nouvel Auteur', 2015);

SELECT * FROM livres_apres_2010;