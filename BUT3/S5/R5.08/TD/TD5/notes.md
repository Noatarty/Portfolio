# TD1 Graphs

## Ex1

Etats : Ville + Visitées(Ville1, ...) *liste des villes visitées sans doublon*  
Etat initial : Ville de départ.  
Actions : Se déplacer dans une ville voisine non visitée.  
Transitions : Changement de ville.  
Test de but : Ville + Visite = La liste de toute les villes  
Coût de 1 chemin(déplacement) : distance entre les villes  

## Ex2

Etats : Configuration de la grille (position des chiffres 1 à 8 et de la case vide).  
Etat initial : La grille dans son état de départ mélangé.  
Actions : Déplacer un chiffre vers une case adjacente (et donc la case vide).  
Transitions : Échange de place entre la case vide et le chiffre choisi.  
Test de but : Grille ordonnée (1 à 8) avec la case vide en bas à droite.  
Coût du chemin : 1  

## Ex3

Etats : Configuration de l'échiquier avec entre 0 et 8 reines placées.  
Etat initial : Un échiquier vide.  
Actions : Placer une reine sur une case libre qui n'est pas menacée par les reines déjà présentes.  
Transitions : Ajout d'une reine sur l'échiquier dans une nouvelle position.  
Test de but : 8 reines sont placées sur l'échiquier sans qu'aucune reine ne partage la même rangée, colonne ou diagonale.  
Coût du chemin : 1 (placement de une reine)  

## Ex4

Etats : (cg,mg,barque)
Etat initial : (3,3,gauche)
Actions :  tg(xc,xm et td(xc,xm))
Transitions : déplacement d'individus (1 ou 2)
Test de but :  (0,0,droite)
Coût du chemin : 1  

```pseudocode

```