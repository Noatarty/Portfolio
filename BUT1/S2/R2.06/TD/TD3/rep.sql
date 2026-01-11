set schema 'TdVues';

CREATE OR REPLACE VIEW BigBrother1 AS
select produit.* from produit
inner join producteur on raison_sociale = produit_par
inner join consommateur on consomme_par_login = login and consomme_par_email = email
where producteur.ville=consommateur.ville;

-- insertion impossible sur une vue qui lit plusieurs tables
insert into BigBrother1
values ('3', 'Banane', 'Duhamel', 'jdurand', 'jules.durand@gcris.fr');

-- update
update BigBrother1
set description = 'Clémentine'
where id=1;

-- Produits non consommés
CREATE OR REPLACE VIEW BigBrother2 AS
select from produit
where consomme_par_login is NULL or consomme_par_email is NULL
with check option;

-- nombre de produits produits par chaque producteur
CREATE OR REPLACE VIEW BigBrother3 AS
select producteur.*, count(*) as nb_produits from producteur
inner join produit on raison_sociale=produit_par
group by raison_sociale;
