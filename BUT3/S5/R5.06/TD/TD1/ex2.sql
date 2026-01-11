CREATE OR REPLACE FUNCTION normalize_fr_phone(txt TEXT) RETURNS TEXT AS $$
DECLARE s TEXT;
BEGIN
  IF txt IS NULL THEN RETURN NULL; END IF;
  -- enlever espaces, parenthèses, tirets, etc.
  s := regexp_replace(txt, '[^0-9+]', '', 'g');

  -- format +33XXXXXXXXX
  IF s ~ '^\+33[0-9]{9}$' THEN
    RETURN s;
  ELSIF s ~ '^0033[0-9]{9}$' THEN
    RETURN '+' || substring(s FROM 3);
  ELSIF s ~ '^0[0-9]{9}$' THEN
    RETURN '+33' || substring(s FROM 2);
  ELSE
    RETURN NULL;
  END IF;
END;
$$ LANGUAGE plpgsql IMMUTABLE;

-- clients_clean
CREATE TABLE IF NOT EXISTS clients_clean (
  id INTEGER PRIMARY KEY,
  nom TEXT,
  adresse TEXT,
  numero_telephone TEXT
);

-- ventes_clean
CREATE TABLE IF NOT EXISTS ventes_clean (
  id SERIAL PRIMARY KEY,
  id_client INTEGER NOT NULL,
  id_produit INTEGER,
  date_vente DATE,
  montant NUMERIC(12,2)
);

WITH parsed AS (
  SELECT
    CASE WHEN id ~ '^\d+$' THEN id::int END AS id_i,
    nom,
    NULLIF(trim(adresse),'') AS adresse_norm,
    normalize_fr_phone(numero_telephone) AS tel_norm
  FROM clients_raw
)
INSERT INTO clients_clean (id, nom, adresse, numero_telephone)
SELECT DISTINCT ON (id_i) id_i, nom, adresse_norm, tel_norm
FROM parsed
WHERE id_i IS NOT NULL
  AND adresse_norm IS NOT NULL
ORDER BY id_i;
-- Si clients_clean a déjà des PK existants et tu veux écraser ou merger, utilise:
-- ON CONFLICT (id) DO UPDATE SET nom = EXCLUDED.nom, adresse = EXCLUDED.adresse, numero_telephone = EXCLUDED.numero_telephone;

WITH parsed AS (
  SELECT
    CASE WHEN id_client ~ '^\d+$' THEN id_client::int ELSE NULL END AS id_client_i,
    CASE WHEN id_produit ~ '^\d+$' THEN id_produit::int ELSE NULL END AS id_produit_i,
    CASE WHEN date_vente ~ '^\d{4}-\d{2}-\d{2}$' THEN date_vente::date ELSE NULL END AS date_vente_d,
    -- nettoyer montant, convertir en numérique ; si non numérique -> 0 ; puis remplacer négatifs par 0
    GREATEST(
      COALESCE(NULLIF(regexp_replace(montant, '[^0-9.-]', '', 'g'), '')::numeric, 0)
    , 0) AS montant_n
  FROM ventes_raw
)
INSERT INTO ventes_clean (id_client, id_produit, date_vente, montant)
SELECT DISTINCT ON (id_client_i, id_produit_i, date_vente_d, montant_n)
       id_client_i, id_produit_i, date_vente_d, montant_n
FROM parsed
WHERE id_client_i IS NOT NULL
  AND date_vente_d IS NOT NULL
  AND date_vente_d <= current_date  -- filtre ventes dans le futur (ex. 2099)
ORDER BY id_client_i, id_produit_i, date_vente_d, montant_n;