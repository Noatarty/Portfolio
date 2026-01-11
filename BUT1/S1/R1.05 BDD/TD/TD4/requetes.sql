1. Quels sont les noms des produits commercialisés par l’entreprise ?

SELECT nomp FROM produit;

2. Quels sont les produits originaires de ’Dijon’ ?

SELECT * FROM produit WHERE origine = 'Dijon';

3. Quels sont les noms des produits originaires de ’Dijon’ ?

SELECT nomp FROM produit WHERE origine = 'Dijon';

4. Quels sont les numéros des fournisseurs qui fournissent quelque chose ?

SELECT DISTINCT nofour FROM fourniture;

5. Quels sont les numéros des fournisseurs qui ne fournissent rien ?

SELECT nofour FROM fournisseur WHERE nofour NOT IN (SELECT DISTINCT nofour FROM fourniture);

6. Quels sont les numéros des fournisseurs qui fournissent au moins le produit ’P6’ ?

SELECT nofour FROM fourniture WHERE noproduit = 'P6';


7. Quels sont les numéros des fournisseurs qui fournissent quelque chose d’autre que ’P6’ ?

SELECT DISTINCT nofour FROM fourniture WHERE noproduit <> 'P6';


8. Quels sont les numéros des fournisseurs qui ne fournissent pas ’P6’ ?

SELECT DISTINCT nofour FROM fourniture WHERE nofour NOT IN (SELECT nofour FROM fourniture WHERE noproduit = 'P6');


9. Quels sont les numéros des fournisseurs qui fournissent quelque chose mais pas ’P6’ ?

SELECT DISTINCT nofour FROM fourniture WHERE nofour NOT IN (SELECT nofour FROM fourniture WHERE noproduit = 'P6')
AND nofour IN (SELECT DISTINCT nofour FROM fourniture);


10. Quels sont les numéros des Fournisseurs qui ne fournissent que ’P6’ ?

SELECT nofour FROM fourniture WHERE noproduit = 'P6' AND nofour NOT IN (SELECT nofour FROM fourniture WHERE noproduit <> 'P6');


11. Quels sont les numéros des fournisseurs qui fournissent ’P4’ ou ’P6’ ?

SELECT DISTINCT nofour FROM fourniture WHERE noproduit IN ('P4', 'P6');


12. Quels sont les numéros des fournisseurs qui fournissent ’P4’ et ’P6’ ?

SELECT nofour FROM fourniture WHERE noproduit IN ('P4', 'P6') GROUP BY nofour HAVING COUNT(DISTINCT noproduit) = 2;


13. Quels sont les numéros des fournisseurs qui ne fournissent ni ’P4’ ni ’P6’ ?

SELECT DISTINCT nofour FROM fourniture WHERE nofour NOT IN (SELECT nofour FROM fourniture WHERE noproduit IN ('P4', 'P6'));


14. Quels sont les numéros et noms des fournisseurs qui fournissent ’P6’ ?

SELECT f.nofour, f.nomf FROM fournisseur f INNER JOIN fourniture ft ON f.nofour = ft.nofour WHERE ft.noproduit = 'P6';


15. Quels sont les numéros et noms des fournisseurs qui ne fournissent ni ’P4’ ni ’P6’ ?




































SELECT f.nofour, f.nomf FROM fournisseur f WHERE f.nofour NOT IN (SELECT nofour FROM fourniture WHERE noproduit IN ('P4', 'P6'));

16. Quels sont les numéros, noms et villes des fournisseurs qui fournissent au moins un produit originaire de leur ville ?

SELECT f.nofour, f.nomf, f.ville FROM fournisseur f INNER JOIN produit p ON f.ville = p.origine INNER JOIN fourniture ft ON f.nofour = ft.nofour AND p.noproduit = ft.noproduit;

17. Quels sont les produits qui sont de même couleur ? Le résultat sera présenté par des couples de numéros de produits.

SELECT p1.noproduit, p2.noproduit FROM produit p1, produit p2 WHERE p1.noproduit < p2.noproduit AND p1.couleur = p2.couleur;

18. Quels sont les produits de même couleur que la salade ?

SELECT p2.noproduit FROM produit p1 JOIN produit p2 ON p1.couleur = p2.couleur AND p1.noproduit <> p2.noproduit WHERE p1.noproduit = 'P5';

19. Quels sont les numéros des fournisseurs qui fournissent des produits verts ou rouges ?

SELECT DISTINCT f.nofour FROM fournisseur f JOIN fourniture ft ON f.nofour = ft.nofour JOIN produit p ON ft.noproduit = p.noproduit WHERE p.couleur IN ('Vert', 'Rouge');


20. Quels sont les numéros des fournisseurs qui fournissent des produits verts et rouges ?

SELECT f.nofour FROM fournisseur f JOIN fourniture ft ON f.nofour = ft.nofour JOIN produit p ON ft.noproduit = p.noproduit WHERE p.couleur IN ('Vert', 'Rouge') GROUP BY f.nofour HAVING COUNT(DISTINCT p.couleur) = 2;


21. Quels sont les numéros et noms des fournisseurs qui ne fournissent pas de produit vert ?

SELECT f.nofour, f.nomf
FROM fournisseur f
WHERE f.nofour NOT IN (
    SELECT ft.nofour
    FROM fourniture ft
    JOIN produit p ON ft.noproduit = p.noproduit
    WHERE p.couleur = 'Vert'
);


22. Quels sont les numéros et noms des fournisseurs qui ne fournissent que des produits verts ?

SELECT f.nofour, f.nomf
FROM fournisseur f
WHERE f.nofour NOT IN (
    SELECT ft.nofour
    FROM fourniture ft
    JOIN produit p ON ft.noproduit = p.noproduit
    WHERE p.couleur <> 'Vert'
) AND f.nofour IN (
    SELECT ft.nofour
    FROM fourniture ft
    JOIN produit p ON ft.noproduit = p.noproduit
    WHERE p.couleur = 'Vert'
);
