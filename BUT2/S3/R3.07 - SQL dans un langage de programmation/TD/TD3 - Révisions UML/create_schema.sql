drop schema if exists natation cascade;
create schema natation;
set schema 'natation';

create table competition(
  num_compet  serial,
  date_compet date      not null,
  constraint competition_pk primary key (num_compet)
);

create table competiteur(
  idcompetiteur   serial,
  num_compet      integer   not null,
  constraint competiteur_pk 
      primary key (idcompetiteur,num_compet),
  constraint competiteur_fk_compet
      foreign key (num_compet) 
      references competition(num_compet));

create table epreuve(
  num_epreuve   serial,
  num_compet    integer,
  heure_epr     time      not null,
  constraint epreuve_pk 
      primary key (nume_epreuve,num_compet),
  constraint epreuve_fk_compet
      foreign key (num_compet) 
      references competition(num_compet)); 

create table ligne_eau(
  no_ligne    integer   primary key);
  
create table participe(
  num_epreuve   integer,
  idcompetiteur integer,
  num_compet    integer,
  no_ligne      integer,
  constraint participe_pk
    primary key (num_epreuve, idcompetiteur, num_compet),
  constraint participe_uk
    unique (num_epreuve, no_ligne, num_compet),
  constraint participe_fk_competiteur
    foreign key (num_compet, idcompetiteur) 
    references competiteur(num_compet, idcompetiteur),
  constraint participe_fk_epreuve
    foreign key (num_epreuve, num_compet)
    references epreuve(num_epreuve, num_compet)
);

create table gagne (
  num_epreuve   integer,
  idcompetiteur integer,
  num_compet    integer,
  chrono        time,
  constraint gagne_pk
    primary key(num_epreuve, num_compet),
  constraint gagne_fk_participe
    foreign key(num_epreuve, idcompetiteur, num_compet)
    references participe(num_epreuve, idcompetiteur, num_compet)
);
