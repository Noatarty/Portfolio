# Étape 3 - Analyse et réflexion
## Répondez aux questions suivantes dans un fichier  .txt  ou  .md  et remettez-le avec votre TP :

### 1. En quoi cette architecture simule-t-elle une fédération de données ?

En répartissant les informations dans des schémas indépendant représentant un service chacun. Elle permet d’interroger et d’intégrer des données provenant de sources hétérogènes, tout en conservant l’autonomie de chaque source.

### 2. Quels sont les avantages de cette approche (séparation des données dans des schémas distincts) ?
Cette séparation offre :
- Que chaque schéma peut évoluer indépendamment.
- Que les droits d’accès peuvent être gérés par schéma.
- Une gestion facilitée des responsabilités et de la maintenance.
- La possibilité d’intégrer facilement de nouvelles sources ou services.

### 3. Quels sont les défis et limites d'une telle approche si les données étaient réellement sur des serveurs physiques différents ?

Les défis incluent :
- La gestion de la synchronisation des données entre serveurs.
- La complexité des transactions distribuées.
- Les problèmes de performance et de latence réseau.
- La nécessité de protocoles et d’outils spécifiques.

### 4. Quels outils ou techniques pouvez-vous proposer pour gérer une vraie fédération de bases de données dans un environnement distribué ?

Le cours cite plusieurs solutions :
- Les middleware de fédération
- Les protocoles d’intégration comme ODBC/JDBC, ou les API REST/GraphQL
- Les systèmes de gestion de transactions distribuées.
- Les outils de monitoring et de synchronisation pour garantir la cohérence et la disponibilité.

## BONUS
## 3. Quelle serait l'issue de cette erreur pour la vue  vue_clients_commandes  ?

Cette commande n'est pas prise en compte comme on peut le constater avec le resultat rendu par le script sql.