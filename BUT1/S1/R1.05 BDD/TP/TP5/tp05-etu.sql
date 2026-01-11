---
--- TP 5 - LMD - Client - Commande - Stock
---

-- Q1 tous les articles
select * from stock;
-- Q2 tous les clients
select * from client;
-- Q3 toutes les commandes
select * from commande;
-- Q4 le nom de chaque article
select nom_art from stock;
-- Q5 le nom et l'adresse de chaque client
select nom_cli, adresse_cli from client;
-- Q6 le nom et le numero des clients dont l'adresse n'est pas connue
select nom_cli, num_cli from client where adresse_cli is null;
-- Q7 les articles de type Philosophie
select * from stock where type_art = 'Philosophie';
-- Q8 nom et type des article de type  Philosophie ou Litterature
select nom_art, type_art from stock where type_art = 'Philosophie' or type_art = 'Litterature';
-- Q9 nom et type des articles dont la quantite en stock est >=100
select nom_art, type_art from stock where quantite_art >= 100;
-- Q10 articles de type Sciences dont la quantite en stock
-- est inferieure a 100
select * from stock where type_art = 'Sciences' and quantite_art < 100;
-- Q11 nom des articles de type Sciences dont la quantite en stock
-- est inferieure a 100
select nom_art from stock where type_art = 'Sciences' and quantite_art < 100;
-- Q12 nom des articles dont la valeur du stock est > 1000
select nom_art from stock where prix_art * quantite_art > 1000;
-- Q13 nom et type des articles qui sont en rupture de stock
select nom_art, type_art from stock where quantite_art = 0;
-- Q14 nom et type des articles qui sont approvisionnés
select nom_art, type_art from stock where quantite_art > 0;
-- Q15  nom des articles commandés
select distinct nom_art from stock  inner join commande on num_art = num_art_c;
-- Q16 nom des clients ayant commandé
select distinct nom_cli from client inner join commande on num_cli = num_cli_c;
-- Q17 numéro des clients n'ayant jamais commandé
select num_cli from client except num_cli_c from commande;
-- Q18 commandes qui concernent des articles qui ne sont pas de type
-- 'Philosophie'
select * from commande inner join stock on num_art = num_art_c where type_art <> 'Philosophie';
-- Q19 nom des articles de type Sciences dont au moins une commande 
-- a un montant >800
select nom_art_c from commande inner join stock on num_art = num_art_c where type_art = 'Sciences' and quantite_art_c * prix_art > 800;
-- Q20 Valeur du stock
select sum(prix_art * quantite_art) from stock;
-- Q21 Somme des montants des commandes
select sum(prix_art_c * quantite_art) from stock inner join commande on num_art = num_art_c;
-- Q22 nom des clients ayant commande(au moins un) article de type Philosophie
select distinct nom_cli from client inner join commande on num_cli = num_cli_c inner join stock on num_art = num_art_c where type_art = 'Philosophie';
-- Q23 numéro des articles sujets a au moins deux commandes
-- (qu'est ce qui identifie une commande) ?
select distinct c1.num_art_c from commande c1 inner join commande c2 on c1.num_art_c = c2.num_art_c where c1.num_cli_c <> c2.num_cli_c;
-- Q24 Couples de  numero de clients (n1,n2) tels que les clients soient differents
-- et aient meme adresse
select distinct c1.num_cli, c2.num_cli from client c1 inner join client c2 on c1.adresse_cli = c2.adresse_cli where c1.num_cli < c2.num_cli;
-- Q25 nombre de clients
select count(*) from client;
-- Q26 quantité minimale en stock
select min(quantite_art) from stock;
-- Q27 Quantite maximale en stock des articles de type Philosophie
select max(quantite_art) from stock where type_art = 'Philosophie';
-- Q28 moyenne des quantites en stock
select avg(quantite_art) from stock;
-- Q39 nombre de commandes du client numero 1
select count(*) from commande where num_cli_c = 1;
-- Q30 nom des articles commandes par les clients no 4 ou  no 2 

-- Q31 nom des articles non commandes par les clients no 4 ou no 2

-- Q32 nom des articles tels qu'il existe au moins une commande de quantite
-- supérieure à celle en stock

-- Q33 numéro des articles qui ne sont commandés qu'une seule fois

-- Q34 la moyenne des quantites commandees des articles
-- de type Litterature

-- Q36 Numéros des clients et  des articles commandés par 
-- ce client. Les numéros des clients n'ayant rien commandé devront apparaitre
