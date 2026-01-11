1. Diagramme des cas d'utilisation du logiciel Puissance 4

Le diagramme des cas d'utilisation pourrait inclure les cas suivants :

- Démarrer partie
- Jouer pion
- Déplacer pion (gauche ou droite au-dessus de la colonne)
- Afficher grille
- Sauvegarder partie
- Charger partie
- Quitter partie

Chaque cas d'utilisation sera relié à l’acteur Joueur (qui représente l’utilisateur) et Ordinateur. L’action Afficher grille sera utilisée chaque fois que l’état de la grille change.

---

2. Description du cas d'utilisation : Démarrer partie

Nom du cas : Démarrer partie

Acteurs : Joueur

Préconditions : 
- Aucune partie n’est en cours, ou le joueur souhaite abandonner la partie en cours.
- Si une partie est en cours, l’utilisateur est invité à sauvegarder avant de démarrer une nouvelle partie.

Scénario nominal :
1. L’utilisateur choisit de démarrer une nouvelle partie.
2. Si une partie est en cours, un message demande à l’utilisateur s’il souhaite sauvegarder cette partie.
3. Une nouvelle grille vide est affichée.
4. Un tirage au sort est effectué pour décider quel joueur commence.
5. La partie est prête pour le premier tour.

Postconditions :
- Une nouvelle partie est en cours, avec une grille initialisée vide.
- Le joueur ou l'ordinateur est désigné pour commencer selon le tirage au sort.

---

3. Description du cas d'utilisation : Jouer pion

Nom du cas : Jouer pion

Acteurs : Joueur, Ordinateur

Préconditions : 
- Une partie est en cours.
- C'est le tour du joueur de jouer.

Scénario nominal :
1. Le joueur choisit la colonne où il veut jouer en déplaçant son pion au-dessus de la colonne souhaitée (via l'interface de déplacement du pion).
2. Le joueur fait tomber son pion dans cette colonne.
3. Le pion tombe jusqu’à la position la plus basse disponible dans cette colonne.
4. La grille est mise à jour et affichée.
5. Le programme vérifie si le joueur a aligné quatre pions. Si c'est le cas, le joueur gagne la partie.
6. Si le joueur n’a pas gagné, l’ordinateur effectue un mouvement en suivant ses propres règles de jeu :
   - L’ordinateur sélectionne une colonne pour son pion.
   - Le pion de l’ordinateur tombe dans la colonne choisie jusqu’à la position la plus basse disponible.
7. La grille est mise à jour et affichée.
8. Le programme vérifie si l’ordinateur a aligné quatre pions. Si c'est le cas, l'ordinateur gagne la partie.
9. Si ni le joueur ni l'ordinateur n’ont gagné et que la grille n'est pas pleine, le tour passe au joueur.

Scénario alternatif :
- Si la grille est pleine et qu’aucun des joueurs n’a aligné quatre pions, la partie se termine en match nul.

Postconditions :
- Le pion du joueur a été ajouté à la grille.
- Le pion de l'ordinateur a été ajouté à la grille (si le joueur n’a pas gagné).
- La grille est mise à jour et affichée.
- Si une condition de victoire ou de match nul est atteinte, la partie se termine.