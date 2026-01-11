# Application de Gestion de Personnel d'Entreprise

Application Spring Boot pour la gestion du personnel et des départements d'une entreprise.

## Technologies utilisées

- Spring Boot 3.1.4
- Spring Data JPA
- H2 Database (base de données en mémoire)
- Maven
- HTML/CSS/JavaScript

## Structure du projet

```
src/
├── main/
│   ├── java/com/iut/collaborateurs/
│   │   ├── entity/
│   │   │   ├── Departement.java
│   │   │   └── Collaborateur.java
│   │   ├── repository/
│   │   │   ├── DepartementRepository.java
│   │   │   └── CollaborateurRepository.java
│   │   ├── service/
│   │   │   ├── DepartementService.java
│   │   │   └── CollaborateurService.java
│   │   ├── controller/
│   │   │   ├── DepartementController.java
│   │   │   └── CollaborateurController.java
│   │   └── CollaborateursApplication.java
│   └── resources/
│       ├── application.properties
│       └── static/
│           ├── index.html
│           └── app.js
```

## Endpoints de l'API

### Départements

| Méthode | URL | Description |
|---------|-----|-------------|
| GET | `/api/departements` | Liste tous les départements |
| GET | `/api/departements/{id}` | Récupère un département par ID |
| POST | `/api/departements/create` | Crée un nouveau département |
| PUT | `/api/departements/{id}` | Met à jour un département |
| DELETE | `/api/departements/{id}` | Supprime un département |

### Collaborateurs

| Méthode | URL | Description |
|---------|-----|-------------|
| GET | `/api/collaborateurs` | Liste tous les collaborateurs |
| GET | `/api/collaborateurs/departement/{id}` | Liste les collaborateurs d'un département |
| GET | `/api/collaborateurs/{matricule}` | Récupère un collaborateur par matricule |
| GET | `/api/collaborateurs/nom/{nom}` | Recherche des collaborateurs par nom |
| POST | `/api/collaborateurs/create` | Crée un nouveau collaborateur |
| PUT | `/api/collaborateurs/{matricule}` | Met à jour un collaborateur |
| DELETE | `/api/collaborateurs/delete/{matricule}` | Supprime un collaborateur |

## Installation et lancement

### Prérequis

- Java 17 ou supérieur
- Maven 3.6 ou supérieur

### Étapes

1. Cloner ou extraire le projet

2. Se placer dans le répertoire du projet :
```bash
cd TP3
```

3. Compiler et lancer l'application avec Maven :
```bash
mvn spring-boot:run
```

Ou bien compiler puis lancer :
```bash
mvn clean install
java -jar target/collaborateurs-0.0.1-SNAPSHOT.jar
```

4. L'application démarre sur http://localhost:8080

## Utilisation

### Interface Web

Ouvrir un navigateur et accéder à : http://localhost:8080

L'interface permet de :
- Créer, lister et supprimer des départements
- Créer, lister et supprimer des collaborateurs
- Rechercher des collaborateurs par nom
- Assigner des collaborateurs à des départements

### Console H2

Pour accéder à la console de la base de données H2 :
- URL : http://localhost:8080/h2-console
- JDBC URL : `jdbc:h2:mem:collaborateurs`
- Username : `sa`
- Password : (laisser vide)

### Tester l'API avec cURL ou Postman

#### Créer un département :
```bash
curl -X POST http://localhost:8080/api/departements/create \
  -H "Content-Type: application/json" \
  -d '{"nom":"Informatique","localisation":"Bâtiment A"}'
```

#### Créer un collaborateur :
```bash
curl -X POST http://localhost:8080/api/collaborateurs/create \
  -H "Content-Type: application/json" \
  -d '{"matricule":"EMP001","nom":"Dupont","prenom":"Jean","email":"jean.dupont@entreprise.com","telephone":"0123456789","departement":{"id":1}}'
```

#### Lister tous les départements :
```bash
curl http://localhost:8080/api/departements
```

#### Lister tous les collaborateurs :
```bash
curl http://localhost:8080/api/collaborateurs
```

## Modèle de données

### Departement
- `id` : Long (généré automatiquement)
- `nom` : String (obligatoire)
- `localisation` : String
- `collaborateurs` : List<Collaborateur> (relation OneToMany)

### Collaborateur
- `matricule` : String (clé primaire)
- `nom` : String (obligatoire)
- `prenom` : String (obligatoire)
- `email` : String
- `telephone` : String
- `departement` : Departement (relation ManyToOne)

## Notes

- La base de données H2 est en mémoire, les données sont perdues à chaque redémarrage
- CORS est activé pour permettre les requêtes depuis n'importe quelle origine
- Le mode `ddl-auto` est configuré sur `create-drop`, les tables sont recréées à chaque démarrage
