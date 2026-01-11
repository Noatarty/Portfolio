#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <arpa/inet.h>
#include <libpq-fe.h>

#define PORT 8080
#define MAX_CLIENTS 10
#define BUFFER_SIZE 1024
#define MAX_MESSAGE_LENGTH 1000

// Fonction pour gérer les erreurs
void error(const char *msg) {
    perror(msg);
    exit(EXIT_FAILURE);
}

// Fonction pour interagir avec la base de données PostgreSQL
PGconn* connect_to_db() {
    const char *conninfo = "host=postgresdb dbname=sae user=sae password=cab4nes-gr0sse-KNights";
    PGconn *conn = PQconnectdb(conninfo);

    if (PQstatus(conn) != CONNECTION_OK) {
        fprintf(stderr, "Erreur de connexion à la base de données : %s", PQerrorMessage(conn));
        PQfinish(conn);
        exit(EXIT_FAILURE);
    }

    printf("Connexion à la base de données réussie.\n");
    return conn;
}

// Fonction pour envoyer un message
void send_message(PGconn *conn, int client_socket, const char *token, const char *destinataire, const char *message) {
    char query[512];
    snprintf(query, sizeof(query),
             "INSERT INTO messages (id_emetteur, id_destinataire, contenu) "
             "SELECT id_utilisateur, (SELECT id_utilisateur FROM utilisateurs WHERE nom_utilisateur = '%s'), '%s' "
             "FROM utilisateurs WHERE cle_api = '%s';",
             destinataire, message, token);

    PGresult *res = PQexec(conn, query);

    if (PQresultStatus(res) != PGRES_COMMAND_OK) {
        fprintf(stderr, "Erreur lors de l'envoi du message : %s", PQerrorMessage(conn));
        write(client_socket, "416/MISFMT:Erreur lors de l'envoi du message\n", 44);
    } else {
        write(client_socket, "200/OK:Message envoyé\n", 22);
    }

    PQclear(res);
}

// Fonction pour récupérer les messages non lus
void get_unread_messages(PGconn *conn, int client_socket, const char *token) {
    char query[512];
    snprintf(query, sizeof(query),
             "SELECT id_message, id_emetteur, contenu, date_creation "
             "FROM messages "
             "WHERE id_destinataire = (SELECT id_utilisateur FROM utilisateurs WHERE cle_api = '%s') "
             "AND est_supprime = FALSE "
             "ORDER BY date_creation ASC;",
             token);

    PGresult *res = PQexec(conn, query);

    if (PQresultStatus(res) != PGRES_TUPLES_OK) {
        fprintf(stderr, "Erreur lors de la récupération des messages non lus : %s", PQerrorMessage(conn));
        write(client_socket, "500/INTERNAL_ERROR:Erreur serveur\n", 35);
    } else {
        int ntuples = PQntuples(res);
        if (ntuples == 0) {
            write(client_socket, "204/NO_CONTENT:Aucun message non lu\n", 36);
        } else {
            char response[BUFFER_SIZE];
            snprintf(response, sizeof(response), "200/OK:%d messages\n", ntuples);
            write(client_socket, response, strlen(response));

            for (int i = 0; i < ntuples; i++) {
                snprintf(response, sizeof(response), "Message %d: %s\n", i + 1, PQgetvalue(res, i, 2));
                write(client_socket, response, strlen(response));
            }
        }
    }

    PQclear(res);
}

// Fonction pour traiter les requêtes des clients
void handle_client(int client_socket, PGconn *conn) {
    char buffer[BUFFER_SIZE];
    int n;

    while (1) {
        // Réception des données du client
        bzero(buffer, BUFFER_SIZE);
        n = read(client_socket, buffer, BUFFER_SIZE - 1);
        if (n < 0) error("Erreur de lecture du socket");

        // Affichage de la requête reçue
        printf("Requête reçue : %s\n", buffer);

        // Traitement de la requête
        if (strncmp(buffer, "LOGIN::", 7) == 0) {
            // Authentification
            char *cle_api = buffer + 7;
            char query[256];
            snprintf(query, sizeof(query), "SELECT id_utilisateur FROM utilisateurs WHERE cle_api = '%s';", cle_api);
            PGresult *res = PQexec(conn, query);

            if (PQresultStatus(res) != PGRES_TUPLES_OK) {
                fprintf(stderr, "Erreur lors de l'exécution de la requête : %s", PQerrorMessage(conn));
                PQclear(res);
                continue;
            }

            if (PQntuples(res) == 1) {
                // Authentification réussie
                char *id_utilisateur = PQgetvalue(res, 0, 0);
                printf("Utilisateur authentifié : %s\n", id_utilisateur);
                write(client_socket, "200/OK:Connexion réussie\n", 24);
            } else {
                // Authentification échouée
                write(client_socket, "403/DENIED:Clé API invalide\n", 28);
            }

            PQclear(res);
        } else if (strncmp(buffer, "MSG::", 5) == 0) {
            // Envoi d'un message
            char *token = strtok(buffer + 5, ",");
            char *destinataire = strtok(NULL, ",");
            char *message = strtok(NULL, ",");

            if (token && destinataire && message) {
                send_message(conn, client_socket, token, destinataire, message);
            } else {
                write(client_socket, "416/MISFMT:Format de message incorrect\n", 39);
            }
        } else if (strncmp(buffer, "UNREAD::", 8) == 0) {
            // Récupération des messages non lus
            char *token = buffer + 8;
            get_unread_messages(conn, client_socket, token);
        } else {
            // Réponse par défaut pour les requêtes non reconnues
            write(client_socket, "400/BAD_REQUEST:Requête non reconnue\n", 37);
        }
    }

    close(client_socket);
}

int main() {
    int server_socket, client_socket;
    struct sockaddr_in server_addr, client_addr;
    socklen_t client_len = sizeof(client_addr);
    PGconn *conn;

    // Connexion à la base de données
    conn = connect_to_db();

    // Création du socket serveur
    server_socket = socket(AF_INET, SOCK_STREAM, 0);
    if (server_socket < 0) error("Erreur lors de la création du socket");

    // Configuration de l'adresse du serveur
    bzero((char *)&server_addr, sizeof(server_addr));
    server_addr.sin_family = AF_INET;
    server_addr.sin_addr.s_addr = INADDR_ANY;
    server_addr.sin_port = htons(PORT);

    // Liaison du socket à l'adresse
    if (bind(server_socket, (struct sockaddr *)&server_addr, sizeof(server_addr)) < 0)
        error("Erreur lors de la liaison du socket");

    // Mise en écoute du socket
    listen(server_socket, MAX_CLIENTS);
    printf("Serveur en écoute sur le port %d...\n", PORT);

    // Boucle principale pour accepter les connexions clients
    while (1) {
        client_socket = accept(server_socket, (struct sockaddr *)&client_addr, &client_len);
        if (client_socket < 0) error("Erreur lors de l'acceptation de la connexion");

        printf("Nouveau client connecté.\n");

        // Gestion du client dans une fonction séparée
        handle_client(client_socket, conn);
    }

    // Fermeture du socket serveur
    close(server_socket);
    PQfinish(conn);
    return 0;
}