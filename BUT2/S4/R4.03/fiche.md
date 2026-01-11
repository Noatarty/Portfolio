# 📌 **Fiche de Révision – Bases de Données & MongoDB**  

## 🔹 **1. Dépendances Fonctionnelles (FD) et Normalisation**  
### 🔸 **Définitions et concepts clés**  
- **Dépendance fonctionnelle (FD)** : \( A \to B \) signifie que si deux tuples ont la même valeur pour \( A \), ils ont aussi la même valeur pour \( B \).
- **FD triviale** : \( A, B \to A \) (B est inclus dans A).
- **FD non triviale** : \( A \to B \), où \( B \) n'est pas inclus dans \( A \).
- **Fermeture d'un ensemble d'attributs** (\( A^+ \)) : Ensemble d'attributs déterminés par \( A \) selon un ensemble de FD.

### 🔸 **Règles importantes**  
- **Règle de séparation** : \( A \to BC \Rightarrow A \to B \) et \( A \to C \).
- **Règle de combinaison** : \( A \to B \) et \( A \to C \Rightarrow A \to BC \).
- **Transitivité** : \( A \to B \) et \( B \to C \Rightarrow A \to C \).

### 🔸 **Formes Normales**  
| Norme | Condition |
|--------|----------|
| **1NF** | Pas d’attribut multivalué ou composite |
| **2NF** | 1NF + pas de dépendance partielle (une partie de la clé ne détermine pas un attribut non-clé) |
| **3NF** | 2NF + pas de dépendance transitive (un attribut non-clé ne dépend pas d’un autre attribut non-clé) |
| **BCNF** | 3NF + chaque FD a un attribut clé comme déterminant |

---

## 🔹 **2. Modélisation Relationnelle et Schémas de BD**  
### 🔸 **Problèmes des bases non normalisées**  
- **Redondance** (répétition inutile d’informations).  
- **Anomalies de mise à jour** (une modification n’est pas propagée correctement).  
- **Anomalies de suppression** (perte d’informations lorsqu’on supprime une ligne).  

### 🔸 **Décomposition des bases**  
- **Objectif** : Diviser une table pour éliminer les anomalies sans perdre d’informations.  
- **Méthode** : Identifier les FD, déterminer les clés et appliquer la normalisation.  

---

## 🔹 **3. MongoDB : Langage et Commandes**  
### 🔸 **DDL – Data Definition Language** (Création et gestion des bases)  
| Commande | Description |
|----------|------------|
| `db` | Affiche la BD courante |
| `use <db>` | Change la BD active |
| `show dbs` | Liste les BD |
| `db.dropDatabase()` | Supprime la BD courante |
| `db.createCollection("nom")` | Crée une collection |
| `db.collection.drop()` | Supprime une collection |

### 🔸 **DML – Data Manipulation Language** (Manipulation des données)  
| Commande | Description |
|----------|------------|
| `db.collection.insert({})` | Ajoute un document |
| `db.collection.remove({})` | Supprime un document |
| `db.collection.update({}, {$set: {}})` | Met à jour un document |

### 🔸 **Requêtes avec `find()`**  
| Syntaxe | Description |
|---------|------------|
| `db.collection.find({})` | Sélectionne tous les documents |
| `db.collection.find({clé: valeur})` | Filtre selon une condition |
| `db.collection.find({clé: {$gt: valeur}})` | Filtre avec `>`, `<`, `>=`, `<=`, `!=` |
| `db.collection.find({$or: [{clé1: valeur1}, {clé2: valeur2}]})` | Condition OU |
| `db.collection.find({clé: valeur}, {projection: 1})` | Sélectionne uniquement certains champs |
| `db.collection.find().limit(n)` | Limite le nombre de résultats |
| `db.collection.distinct("clé")` | Retourne les valeurs uniques d’un champ |

### 🔸 **Agrégation en MongoDB**  
| Étape | Fonction |
|-------|---------|
| `$match` | Filtre les documents |
| `$group` | Agrège selon une clé |
| `$sort` | Trie les documents |
| `$project` | Sélectionne des champs spécifiques |

**Exemple d’agrégation** : Trier les étudiants par nom  
```js
db.student.aggregate([
   { $sort : { lastname : -1 } }
])
```

---