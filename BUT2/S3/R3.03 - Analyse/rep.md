## Exo1

### Q1
Question 1 
Indiquer dans le diagramme de classes les contraintes liées au nombre d’habitants des métropoles et 
des communes.

Rep : dans la classe métropole,on ajoute une contrainte qui dit que le nombre d'habitants doit être supérieur à 200.000 pour qu'une ville soit une métropole. {nbhab >= 200.000}.et le reste des villes seront des communes {nbhab < 200.000}

### Q2
Question 2 
Ajouter les contraintes suivantes : un électeur doit être majeur et son numéro ne peut être modifié.

Rep : numE {frozen} et dateN{today - dateN > 18}

### Q3
Question 3 
Les administrateurs et co-administrateurs doivent habiter dans la circonscription qu’ils administrent 
et une personne ne peut à la fois être administrateur et co-administrateur.

Rep : 

## Exercice 2 – Identifiants  
Rappel : Chaque instance de classe ou d’association possède un identifiant unique, noté à l’aide 
de  la  contrainte  {id}.  Il  est  constitué  d’un  attribut  ou  de  plusieurs  attributs.  Les  identifiants  des 
associations sont constitués de l’union des identifiants des classes qu’elles mettent en relation. 
Les types des attributs sont nécessairement des types de base (Integer, Boolean, Double, String...). 
 
Le diagramme suivant est envisagé pour modéliser le parcours d’un élève dans un collège. 
 
  
### Question 1 
Quel est l’identifiant de chacune des classes et de la relation Appartenir ? Indiquez- les sur le 
diagramme.

Rep : numElev / codeClasse / (codeClasse / numElev)

### Question 2 
La modélisation actuelle ne permet pas à un élève de redoubler dans la même classe. Pourquoi ? 

### Question 3 

Modifier  le  diagramme  pour  corriger  ce  problème.  Préciser  l’identifiant  de  la  nouvelle  association Appartenir.