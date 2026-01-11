-- 4.1 table parent partitionnée
CREATE TABLE ventes_partitionnees (
    id INT NOT NULL,
    id_client INT REFERENCES clients_clean(id),
    id_produit INT,
    date_vente DATE NOT NULL,
    montant NUMERIC(12,2),
    PRIMARY KEY (id, date_vente)
) PARTITION BY RANGE (date_vente);

-- 4.2 partitions pour 2023, 2024, future
CREATE TABLE ventes_2023 PARTITION OF ventes_partitionnees
    FOR VALUES FROM ('2023-01-01') TO ('2024-01-01');

CREATE TABLE ventes_2024 PARTITION OF ventes_partitionnees
    FOR VALUES FROM ('2024-01-01') TO ('2025-01-01');

CREATE TABLE ventes_future PARTITION OF ventes_partitionnees
    FOR VALUES FROM ('2025-01-01') TO (MAXVALUE);


-- 4.3 charger depuis ventes_clean
INSERT INTO ventes_partitionnees (id, id_client, id_produit, date_vente, montant)
SELECT v.id, v.id_client, v.id_produit, v.date_vente, v.montant
FROM ventes_clean v
JOIN clients_clean c ON v.id_client = c.id;

SELECT tableoid::regclass AS partition, COUNT(*) AS nb_lignes
FROM ventes_partitionnees
GROUP BY partition;



