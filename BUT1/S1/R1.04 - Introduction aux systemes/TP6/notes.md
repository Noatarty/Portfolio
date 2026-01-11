Q.1 Affichez les lignes qui contiennent la chaîne blanche dans le fichier prod
egrep blanche < TP5/prod

Q.2 Achez les lignes qui contiennent la chaîne blan dans le fichier prod. Avez-vous le
même résultat ?
OUI
Conclusion : il n’est pas nécessaire de rechercher des mots complets. On peut parfois se
satisfaire de parties de mots.

Q.3 Achez les lignes qui contiennent la chaîne lan dans le fichier prod. Avez-vous le même
résultat ? Pourquoi ?

Nan car nzelande contient également les trois lettres 'lan'

Q.4 Achez les lignes de prod qui contiennent un chire entre 7 et 9
egrep [7-9] < TP5/prod

Q.5 Achez les lignes de prod qui NE contiennent PAS un chire entre 7 et 9 (piège, vérifiez
bien qu’aucun 7, 8 ou 9 ne s’ache !).
egrep -v  [7-9] < TP5/prod

Q.6 Achez les lignes de prod qui contiennent une voyelle.
egrep [aeiouy] < TP5/prod

Q.7 Achez les lignes de prod qui contiennent consécutivement deux voyelles quelconques.
egrep -e [aeiouy][aeiouy] < TP5/prod

Q.8 Achez les lignes de prod qui NE contiennent PAS consécutivement deux voyelles
quelconques. Vous devez avoir réussi la Q.5 pour réussir celle-ci. Si ce n’est pas le cas,
appelez votre enseignant.e.
egrep -v -e [aeiouy][aeiouy] < TP5/prod

Q.9 Achez les lignes de depts qui contiennent au moins soit un A majuscule, soit un - (tiret),
soit un Y majuscule. (piège)
egrep [AY\-] < TP5/depts

Q.10 Achez les lignes de depts qui contiennent un 9 suivi de 3 caractères quelconques,
suivis d’un C majuscule.
egrep 9...C < TP5/depts

Q.11 Achez les lignes de murphy qui contiennent un a suivi d’un e deux positions plus loin.
(Piège, il en a 5 seulement)
egrep a.e < TP5/murphy

Q.12 Pour faire figurer le caractère . (point) dans le motif, il sut de le préfixer d’un \
(backslash). On en reparlera à la fin de ce TP.
Achez les lignes de murphy qui contiennent ... (3 points de suspension). Faites-vous
aider si ça ne marche pas bien.
egrep [\.][\.][\.] < TP5/murphy

Q.13 Achez les lignes de lang qui contiennent machine virtuelle          
egrep "machine virtuelle" < TP5/lang

Q.14 Achez les lignes de prod qui contiennent un b suivi d’un nombre quelconque de
minuscules, suivi d’un e
egrep b[a-z]*e < TP5/prod

Q.15 Même question que Q.14 mais le e doit être suivi d’un : (deux-points)
egrep b[a-z]*e: < TP5/prod

Q.16 Saurez-vous acher les lignes de depts qui contiennent au moins deux - (tirets) dans         
leur nom ?
egrep [\-\-]* < TP5/depts

Q.17 Achez les lignes de depts qui contiennent une voyelle suivie d’au moins un l suivi d’un 7 e. (3 lignes).
egrep [aeiouy]l+e < TP5/depts

Q.18 Achez les lignes de lang qui contiennent un 9 suivi éventuellement d’un 7 et suivi (obligatoirement) d’un 0
egrep 97*0+ < TP5/lang

Q.19 Achez les lignes de murphy qui contiennent un mot finissant par un t. Aide : un mot est suivi d’un espace, mais il y a parfois une virgule avant l’espace. Il y a 12 lignes qui matchent.
egrep t,?" " < murphy

Q.20 Achez les lignes de depts qui contiennent exactement 2 r consécutifs, suivis d’un i
egrep r{2}i < depts

Q.21 Achez les lignes de depts qui contiennent 2 n consécutifs immédiatement après un e.
egrep en{2} < depts

Q.22 Achez les lignes de murphy qui commencent par un L majuscule.
egrep ^L < murphy

Q.23 Achez les lignes de murphy qui se terminent par un . (point). Attention au piège.
egrep "\."$ < murphy

Q.24 Achez les lignes de depts qui contiennent autre chose que des minuscules, des majuscules, des chires, des espaces et des : (deux-points). (41 lignes)
egrep [^a-zA-Z0-9: ] < depts

Q.25 Avec un groupage, achez les lignes de prod qui contiennent an au moins deux fois de suite.
egrep \(an\){2} < prod
