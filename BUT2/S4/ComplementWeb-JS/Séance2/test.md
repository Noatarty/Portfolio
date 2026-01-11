### Compte Rendu : Travaux Pratiques sur les Dépendances Fonctionnelles

---

#### **1. Exercice : Création et Manipulation de la Table `test_df`**

**1.1 Création de la Table `test_df`**

La table `test_df` est créée avec les colonnes `A`, `B`, `C`, et `D`. La colonne `A` est définie comme clé primaire.

```sql
CREATE TABLE test_df (
    A INT,
    B INT,
    C INT,
    D INT,
    PRIMARY KEY (A)
);
```

**1.2 Peuplement de la Table pour les Tests**

Pour tester les requêtes, nous allons peupler la table avec des données fictives :

```sql
INSERT INTO test_df (A, B, C, D) VALUES
(1, 10, 100, 1000),
(2, 20, 200, 2000),
(3, 30, 100, 3000),
(4, 40, 200, 4000),
(5, 50, 300, 5000);
```

**1.3 Requête pour Compter le Nombre de Valeurs de `D` par Valeur de `C`**

La requête suivante compte le nombre de valeurs de `D` pour chaque valeur de `C` :

```sql
SELECT C, COUNT(D) 
FROM test_df 
GROUP BY C;
```

**Résultat attendu :**
- Pour `C = 100`, `COUNT(D) = 2`
- Pour `C = 200`, `COUNT(D) = 2`
- Pour `C = 300`, `COUNT(D) = 1`

**1.4 Vérification de la Dépendance Fonctionnelle `A → B`**

Pour vérifier que `A → B`, on utilise la requête suivante :

```sql
SELECT A, COUNT(DISTINCT B) 
FROM test_df 
GROUP BY A 
HAVING COUNT(DISTINCT B) > 1;
```

**Résultat attendu :**
- Aucune ligne ne doit être retournée, car `A` détermine uniquement une valeur de `B`.

**1.5 Lister les Violations de la Dépendance Fonctionnelle `B, C → D`**

Pour lister les violations de la dépendance fonctionnelle `B, C → D`, on utilise la requête suivante :

```sql
SELECT B, C, COUNT(DISTINCT D) 
FROM test_df 
GROUP BY B, C 
HAVING COUNT(DISTINCT D) > 1;
```

**Résultat attendu :**
- Aucune ligne ne doit être retournée, car `B` et `C` déterminent uniquement une valeur de `D`.

**1.6 Compter le Nombre d'Enregistrements Concernés par la Violation de `B, C → D`**

Pour compter le nombre d'enregistrements concernés par la violation de `B, C → D`, on utilise la requête suivante :

```sql
SELECT COUNT(*) 
FROM (
    SELECT B, C 
    FROM test_df 
    GROUP BY B, C 
    HAVING COUNT(DISTINCT D) > 1
) AS violations;
```

**Résultat attendu :**
- `COUNT(*) = 0`, car il n'y a pas de violation.

---

#### **2. Exercice : Base de Données sur les Pokémon**

**2.1 Identification des Dépendances Fonctionnelles**

Dans la relation "Pokémon", les dépendances fonctionnelles suivantes sont identifiées :

- `NumPokémon → Nom, Type, Niveau, Attaque, PV, Dresseur`
- `Nom → NumPokémon, Type, Niveau, Attaque, PV, Dresseur`

**2.2 Montrer que `NumPokémon` est une Clé**

Pour montrer que `NumPokémon` est une clé, on utilise les requêtes suivantes :

1. Vérifier que `NumPokémon` est unique :

```sql
SELECT NumPokémon, COUNT(*) 
FROM Pokémon 
GROUP BY NumPokémon 
HAVING COUNT(*) > 1;
```

2. Vérifier que `NumPokémon` détermine tous les autres attributs :

```sql
SELECT NumPokémon, COUNT(DISTINCT Nom), COUNT(DISTINCT Type), COUNT(DISTINCT Niveau), COUNT(DISTINCT Attaque), COUNT(DISTINCT PV), COUNT(DISTINCT Dresseur) 
FROM Pokémon 
GROUP BY NumPokémon 
HAVING COUNT(DISTINCT Nom) > 1 
   OR COUNT(DISTINCT Type) > 1 
   OR COUNT(DISTINCT Niveau) > 1 
   OR COUNT(DISTINCT Attaque) > 1 
   OR COUNT(DISTINCT PV) > 1 
   OR COUNT(DISTINCT Dresseur) > 1;
```

**Résultat attendu :**
- Aucune ligne ne doit être retournée, car `NumPokémon` est une clé.

**2.3 Décomposition en Plusieurs Relations**

Pour supprimer les anomalies de conception, on propose la décomposition suivante :

1. **Pokémon_Info** (NumPokémon, Nom, Type, Niveau, Attaque, PV)
2. **Dresseur** (Dresseur, NumPokémon)

**Création des Tables :**

```sql
CREATE TABLE Pokémon_Info (
    NumPokémon INT PRIMARY KEY,
    Nom VARCHAR(50),
    Type VARCHAR(50),
    Niveau INT,
    Attaque VARCHAR(50),
    PV INT
);

CREATE TABLE Dresseur (
    Dresseur VARCHAR(50),
    NumPokémon INT,
    FOREIGN KEY (NumPokémon) REFERENCES Pokémon_Info(NumPokémon)
);
```

**Peuplement des Tables :**

```sql
INSERT INTO Pokémon_Info (NumPokémon, Nom, Type, Niveau, Attaque, PV) VALUES
(1, 'Bulbasaur', 'Grass', 10, 'Tackle', 45),
(2, 'Charmander', 'Fire', 8, 'Ember', 39),
(3, 'Squirtle', 'Water', 9, 'Water Gun', 44);

INSERT INTO Dresseur (Dresseur, NumPokémon) VALUES
('Ash Ketchum', 1),
('Gary Oak', 2),
('Misty', 3);
```

---

#### **3. Exercice : Base de Données sur les Pokémon (Deuxième Exemple)**

**3.1 Identification des Dépendances Fonctionnelles**

Dans cette base de données, les dépendances fonctionnelles suivantes sont identifiées :

- `Name → Type, Level, Move, Power, Trainer, Location`
- `Trainer → Location`

**3.2 Décomposition BCNF**

Pour obtenir une décomposition BCNF, on propose les relations suivantes :

1. **Pokémon** (Name, Type, Level, Move, Power, Trainer)
2. **Trainer_Location** (Trainer, Location)

**Création des Tables :**

```sql
CREATE TABLE Pokémon (
    Name VARCHAR(50) PRIMARY KEY,
    Type VARCHAR(50),
    Level INT,
    Move VARCHAR(50),
    Power INT,
    Trainer VARCHAR(50)
);

CREATE TABLE Trainer_Location (
    Trainer VARCHAR(50) PRIMARY KEY,
    Location VARCHAR(50)
);
```

**Peuplement des Tables :**

```sql
INSERT INTO Pokémon (Name, Type, Level, Move, Power, Trainer) VALUES
('Pikachu', 'Electric', 12, 'ThunderShock', 40, 'Ash Ketchum'),
('Jigglypuff', 'Normal', 15, 'Sing', 50, 'Misty'),
('Geodude', 'Rock', 10, 'Rock Throw', 30, 'Brock');

INSERT INTO Trainer_Location (Trainer, Location) VALUES
('Ash Ketchum', 'Viridian Forest'),
('Misty', 'Mr. Moon'),
('Brock', 'Mr. Moon');
```

