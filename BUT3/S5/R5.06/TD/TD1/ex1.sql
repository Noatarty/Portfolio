-- counts
SELECT 'clients_raw' AS table_name, count(*) FROM clients_raw;
SELECT 'ventes_raw'  AS table_name, count(*) FROM ventes_raw;

-- valeurs distinctes / nulls
SELECT count(DISTINCT id) AS clients_distinct FROM clients_raw;
SELECT count(*) FILTER (WHERE adresse IS NULL OR trim(adresse) = '') AS clients_adresse_vide FROM clients_raw;
SELECT count(*) FILTER (WHERE montant IS NULL OR montant = '') AS ventes_montant_non_saisi FROM ventes_raw;

-- 1) Clients ayant acheté dans les 6 derniers mois
SELECT DISTINCT c.id, c.nom, c.adresse, c.numero_telephone
FROM clients_clean c
JOIN ventes_clean v ON c.id = v.id_client
WHERE v.date_vente >= current_date - INTERVAL '6 months';

-- 2) Clients avec au moins deux achats > 1000 €
SELECT c.id, c.nom, COUNT(*) AS nb_achats
FROM clients_clean c
JOIN ventes_clean v ON c.id = v.id_client
WHERE v.montant > 1000
GROUP BY c.id, c.nom
HAVING COUNT(*) >= 2;

-- 3) Clients n'ayant jamais acheté
SELECT c.*
FROM clients_clean c
LEFT JOIN ventes_clean v ON c.id = v.id_client
WHERE v.id_client IS NULL;

-- 4) Montant total des ventes par client
SELECT c.id, c.nom, COALESCE(SUM(v.montant),0) AS total_ventes
FROM clients_clean c
LEFT JOIN ventes_clean v ON c.id = v.id_client
GROUP BY c.id, c.nom
ORDER BY total_ventes DESC;
