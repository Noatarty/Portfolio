Question 1
Illustration des trois définitions avec un diagramme de Venn :

Totalité :

A = {1, 2}
B = {3, 4}
C = {1, 2, 3, 4}
Diagramme : Les cercles A et B couvrent entièrement C.
Exclusion :

A = {1, 2}
B = {3, 4}
C = {1, 2, 3, 4}
Diagramme : Les cercles A et B ne se chevauchent pas (intersection vide).
Partition :

A = {1, 2}
B = {3, 4}
C = {1, 2, 3, 4}
Diagramme : Les cercles A et B couvrent C sans chevauchement, respectant les propriétés de totalité et d’exclusion.
Question 2
Exemples illustrant les définitions :

Totalité :

A = {1, 2}, B = {3, 4}
C = {1, 2, 3, 4} ; A ∪ B = C
Exclusion :

A = {1, 2}, B = {3, 4}
C = {1, 2, 3, 4} ; A ∩ B = ∅
Partition :

A = {1, 2}, B = {3, 4}
C = {1, 2, 3, 4} ; A ∪ B = C et A ∩ B = ∅

Question 3
Contrainte existante entre les ensembles de valeurs de iddoc de _document, _post, et _comment :

La contrainte existante est que les valeurs de iddoc dans _document, _post, et _comment doivent être uniques et ne doivent pas se chevaucher, ce qui implique qu'il ne doit pas y avoir de valeur iddoc partagée entre ces trois ensembles.

Question 4
Expression de la contrainte en Tutorial D :
```{sql}
IS_EMPTY (_comment{iddoc} INTERSECT _post{iddoc})
AND
(_comment{iddoc} UNION _post{iddoc} = _document{iddoc})
```