### **Protocole Tchatator (Mis à jour)**

#### **1. Authentification (LOGIN)**
- **Commande** :  
  `LOGIN::<clé_api>`

- **Réponses possibles** :  
  - `200/OK:<token_de_connexion>` : Authentification réussie. Le serveur retourne un token de connexion unique.  
  - `403/DENIED` : Accès refusé (clé API invalide ou expirée).  
  - `429/TOO_MANY_REQUESTS` : Trop de tentatives de connexion (limite de requêtes dépassée).  

- **Comportement** :  
  - Le token de connexion est valide jusqu'à ce que le client se déconnecte explicitement ou que la session expire (par exemple, après une période d'inactivité).  
  - Les limites de requêtes (12 par minute et 90 par heure) s'appliquent **par client individuellement**.

---

#### **2. Envoi d'un message (MSG)**
- **Commande** :  
  `MSG:<token_de_connexion>,<destinataire_id>,<longueur_du_message>,<message>`

- **Réponses possibles** :  
  - `200/OK` : Message envoyé avec succès.  
  - `401/UNAUTH` : Token de connexion invalide ou expiré.  
  - `416/MISFMT` : Message mal formaté (longueur incorrecte ou destinataire invalide).  
  - `426/TOO_MRQ` : Trop de messages envoyés (limite de requêtes dépassée).  
  - `403/DENIED` : Destinataire bloqué ou banni.  

---

#### **3. Réception des messages non lus (UNREAD)**
- **Commande** :  
  `UNREAD:<token_de_connexion>`

- **Réponses possibles** :  
  - `200/OK:<nombre_de_messages>,<message1>,<message2>,...` : Liste des messages non lus.  
  - `401/UNAUTH` : Token de connexion invalide ou expiré.  
  - `204/NO_CONTENT` : Aucun message non lu.  

---

#### **4. Réception de l'historique des messages (HISTORY)**
- **Commande** :  
  `HISTORY:<token_de_connexion>,<message_id>,<nombre_de_messages>`

- **Réponses possibles** :  
  - `200/OK:<nombre_de_messages>,<message1>,<message2>,...` : Liste des messages historiques.  
  - `401/UNAUTH` : Token de connexion invalide ou expiré.  
  - `404/NOT_FOUND` : Aucun message trouvé pour l'identifiant donné.  

---

#### **5. Modification d'un message (EDIT)**
- **Commande** :  
  `EDIT:<token_de_connexion>,<message_id>,<longueur_du_message>,<nouveau_message>`

- **Réponses possibles** :  
  - `200/OK` : Message modifié avec succès.  
  - `401/UNAUTH` : Token de connexion invalide ou expiré.  
  - `404/NOT_FOUND` : Message introuvable.  
  - `403/DENIED` : Le message ne peut pas être modifié (trop ancien ou supprimé).  

---

#### **6. Suppression d'un message (DELETE)**
- **Commande** :  
  `DELETE:<token_de_connexion>,<message_id>`

- **Réponses possibles** :  
  - `200/OK` : Message supprimé avec succès.  
  - `401/UNAUTH` : Token de connexion invalide ou expiré.  
  - `404/NOT_FOUND` : Message introuvable.  
  - `403/DENIED` : Le message ne peut pas être supprimé (trop ancien ou déjà supprimé).  

---

#### **7. Blocage d'un client (BLOCK)**
- **Commande** :  
  `BLOCK:<token_de_connexion>,<client_id>,<durée_en_heures>`

- **Réponses possibles** :  
  - `200/OK` : Client bloqué avec succès.  
  - `401/UNAUTH` : Token de connexion invalide ou expiré.  
  - `403/DENIED` : Droits insuffisants pour bloquer ce client.  
  - `404/NOT_FOUND` : Client introuvable.  

---

#### **8. Bannissement d'un client (BAN)**
- **Commande** :  
  `BAN:<token_de_connexion>,<client_id>`

- **Réponses possibles** :  
  - `200/OK` : Client banni avec succès.  
  - `401/UNAUTH` : Token de connexion invalide ou expiré.  
  - `403/DENIED` : Droits insuffisants pour bannir ce client.  
  - `404/NOT_FOUND` : Client introuvable.  

---

#### **9. Déblocage ou débannissement (UNBLOCK/UNBAN)**
- **Commande** :  
  `UNBLOCK:<token_de_connexion>,<client_id>`  
  `UNBAN:<token_de_connexion>,<client_id>`

- **Réponses possibles** :  
  - `200/OK` : Blocage ou bannissement levé avec succès.  
  - `401/UNAUTH` : Token de connexion invalide ou expiré.  
  - `403/DENIED` : Droits insuffisants pour effectuer cette action.  
  - `404/NOT_FOUND` : Client introuvable.  

---

#### **10. Gestion des erreurs**
- **Codes d'erreur supplémentaires** :  
  - `400/BAD_REQUEST` : Requête mal formatée.  
  - `500/INTERNAL_ERROR` : Erreur interne du serveur.  
  - `503/SERVICE_UNAVAILABLE` : Service temporairement indisponible.  

---

