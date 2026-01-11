# TD Systeme de recommandation
## 1 Preliminaires : vecteurs d’attributs

Produit R: {hobbit, magicien, voyage, aventure, fantastique, trésor, montagne, dragon}

Produit J: {dragon, aventure, guerrier, magicien, jeu, imagination, fantastique, monde}

R U J: {hobbit, magicien, voyage, aventure, fantastique, trésor, montagne, dragon, guerrier, jeu, imagination, monde}

vR: {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}

vJ: {0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1}




V1= [1, 1, 1, 1, 0, 0, 0]
V2= [2, 0, 1, 0, 1, 0, 0]
V3= [3, 1, 0, 0, 0, 1, 1]
V4= [2, 1, 0, 1, 1, 0, 0]

Sin c (V4,V1) = 0,75
Sin c (V4,V2) = 0,77
Sin c (V4,V3) = 0,7

## 3 Des systemes de recommandation basiques

### 3.2 Item based

