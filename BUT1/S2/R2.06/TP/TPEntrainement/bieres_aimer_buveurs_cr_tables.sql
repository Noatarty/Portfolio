DROP SCHEMA IF EXISTS bieres CASCADE;

CREATE SCHEMA bieres;
SET SCHEMA 'bieres';

/* Creation de tables */
create table bieres.buveur
(
		idbuveur integer,
		nomb varchar(50) 	NOT NULL,
		prenomb varchar(50)	NOT NULL,
		constraint buveur_pk primary key(idbuveur)
);

create table bieres.biere
(
		idbiere integer,
		nombiere varchar(50) 	NOT NULL,
		degre integer			NOT NULL,
		typebiere varchar(50)	NOT NULL,
		constraint biere_pk	primary key(idbiere)
);

create table bieres.aimer
(
		idbuveur integer,
		idbiere integer,
		constraint aim_pk primary key(idbuveur, idbiere),
		constraint aim_buveur_key foreign key(idbuveur) references bieres.buveur(idbuveur),
		--constraint aim_biere_key foreign key(idbiere) references bieres.biere(idbiere)
);

alter table aimer add constraint aim_biere_key foreign key (idbiere) references biere(idbiere);

/* Remplissage des tables */
insert into buveur(idbuveur, nomb, prenomb) values(1,'Eastwood', 'Clint');
insert into buveur(idbuveur, nomb, prenomb) values(2, 'Abitbol', 'Georges');
insert into buveur(idbuveur, nomb, prenomb) values(3, 'DeNice', 'Brice');
insert into buveur(idbuveur, nomb, prenomb) values(4, 'Bricot', 'Juda');
insert into buveur(idbuveur, nomb, prenomb) values(5, 'Meurdesoif', 'Jean');
insert into buveur(idbuveur, nomb, prenomb) values(6, 'Kollyck', 'Al');

insert into biere(idbiere,nombiere,degre,typebiere) values(1, 'kronembourg', 4, 'pils');
insert into biere(idbiere,nombiere,degre,typebiere) values(2, 'pilsener', 3, 'pils');
insert into biere(idbiere,nombiere,degre,typebiere) values(3, 'heinecken', 4, 'pils');
insert into biere(idbiere,nombiere,degre,typebiere) values(4, 'leffe', 6, 'triple');
insert into biere(idbiere,nombiere,degre,typebiere) values(5, 'smirnoff', 4, 'arromatisee');
insert into biere(idbiere,nombiere,degre,typebiere) values(6, 'dremmwel', 6,' al');

insert into aimer(idbuveur, idbiere) values(1, 2);
insert into aimer(idbuveur, idbiere) values(1, 3);
insert into aimer(idbuveur, idbiere) values(2, 3);
insert into aimer(idbuveur, idbiere) values(3, 1);
insert into aimer(idbuveur, idbiere) values(3, 2);
insert into aimer(idbuveur, idbiere) values(3, 3);
insert into aimer(idbuveur, idbiere) values(3, 4);
insert into aimer(idbuveur, idbiere) values(3, 5);
insert into aimer(idbuveur, idbiere) values(3, 6);
insert into aimer(idbuveur, idbiere) values(4, 1);
insert into aimer(idbuveur, idbiere) values(6, 1);
insert into aimer(idbuveur, idbiere) values(6, 3);
insert into aimer(idbuveur, idbiere) values(6, 5);

insert into aimer(idbuveur, idbiere) values(1, 4);
insert into biere(idbiere,nombiere,degre,typebiere) values(7, 'unebiere', 6,' al');
update aimer set idbiere=7 where idbuveur=6 and idbiere=3;
drop table aimer cascade;
drop table biere cascade;
drop table buveur cascade;

-- Requetes
select distinct nomb from aimer inner join biere on aimer.idbiere=biere.idbiere inner join buveur on aimer.idbuveur=buveur.idbuveur where typebiere='pils';
select buveur.idbuveur, nomb, prenomb, count(idbiere) as nbaimerbiere from buveur inner join aimer on buveur.idbuveur=aimer.idbuveur group by buveur.idbuveur, buveur.nomb, buveur.prenomb;
