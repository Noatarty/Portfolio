-- Etape 1
CREATE SCHEMA service_clients;
CREATE SCHEMA service_commandes;

CREATE TABLE service_clients.clients (
   id SERIAL PRIMARY KEY,
   nom TEXT NOT NULL,
   email TEXT UNIQUE,
   ville TEXT
);

CREATE TABLE service_commandes.commandes (
   id SERIAL PRIMARY KEY,
   date_commande DATE NOT NULL,
   montant NUMERIC(10,2),
   id_client INTEGER NOT NULL
);

INSERT INTO service_clients.clients (nom, email, ville) VALUES
('Alice Dupont', 'alice@example.com', 'Lannion'),
('Bob Martin', 'bob@example.com', 'Brest'),
('Claire Bernard', 'claire@example.com', 'Rennes');

INSERT INTO service_commandes.commandes (date_commande, montant, id_client) VALUES
('2025-09-01', 120.50, 1),
('2025-09-10', 89.99, 1),
('2025-09-15', 45.00, 2),
('2025-09-17', 32.00, 2),
('2025-09-20', 250.00, 3);

-- Etape 2
SELECT c.nom, c.ville, co.date_commande, co.montant
FROM service_clients.clients c
JOIN service_commandes.commandes co ON c.id = co.id_client;

CREATE VIEW vue_clients_commandes AS
SELECT c.nom, COUNT(co.id) AS nb_commandes, SUM(co.montant) AS total
FROM service_clients.clients c
LEFT JOIN service_commandes.commandes co ON c.id = co.id_client
GROUP BY c.nom;

SELECT * FROM vue_clients_commandes;

-- Bonus
CREATE MATERIALIZED VIEW vue_materialisee_clients_commandes AS
SELECT c.nom, COUNT(co.id) AS nb_commandes, SUM(co.montant) AS total
FROM service_clients.clients c
LEFT JOIN service_commandes.commandes co ON c.id = co.id_client
GROUP BY c.nom;

INSERT INTO service_commandes.commandes (date_commande, montant, id_client) VALUES
('2025-09-25', 100.00, 999);

SELECT * FROM vue_clients_commandes;