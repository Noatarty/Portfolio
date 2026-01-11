DROP SCHEMA IF EXISTS td4r206 CASCADE;
CREATE SCHEMA td4r206;
SET SCHEMA 'td4r206';


CREATE TABLE _dept
(
  no_dept integer NOT NULL,
  nom_dept varchar(12) NOT NULL,
  lieu varchar(10) NOT NULL,
  CONSTRAINT dept_pk PRIMARY KEY (no_dept ));

INSERT INTO _dept(no_dept,nom_dept,lieu) VALUES (10,'FINANCES','PARIS');
INSERT INTO _dept(no_dept,nom_dept,lieu) VALUES (20,'RECHERCHES','GRENOBLE');
INSERT INTO _dept(no_dept,nom_dept,lieu) VALUES (30,'VENTES','LYON');
INSERT INTO _dept(no_dept,nom_dept,lieu) VALUES (40,'FABRICATION','ROUEN');


CREATE TABLE _personnel
(
  matr integer NOT NULL,
  nom_e varchar(10) NOT NULL,
  sal numeric(10,2) NOT NULL,
  date_emb date NOT NULL,
  comm numeric(10,2) NOT NULL,
  no_dept integer NOT NULL,
  CONSTRAINT _personnel_pk PRIMARY KEY (matr),
  CONSTRAINT personnel_travaille FOREIGN KEY (no_dept)
      REFERENCES _dept (no_dept));

INSERT INTO _personnel(matr,nom_e,sal,date_emb,comm,no_dept) VALUES(7499,'BIRAUD',12800.00,'1991-02-20',2400.00,30);
INSERT INTO _personnel(matr,nom_e,sal,date_emb,comm,no_dept) VALUES(7521,'BERGER',10000.00,'1991-10-22',4000.00,30);
INSERT INTO _personnel(matr,nom_e,sal,date_emb,comm,no_dept) VALUES(7654,'MARTIN',10000.00,'1991-05-28',11200.00,30);
INSERT INTO _personnel(matr,nom_e,sal,date_emb,comm,no_dept) VALUES(7844,'BENAIN',12000.00,'1991-05-08',0.00,30);
INSERT INTO _personnel(matr,nom_e,sal,date_emb,comm,no_dept) VALUES(7900,'FREMONT',7600.00,'1991-12-03',0.00,30);
INSERT INTO _personnel(matr,nom_e,sal,date_emb,comm,no_dept) VALUES(7934,'VILLARD',10400.00,'2008-01-22',0.00,10);
INSERT INTO _personnel(matr,nom_e,sal,date_emb,comm,no_dept) VALUES(7698,'NOIRET',22800.00,'1991-05-01',0.00,30);
INSERT INTO _personnel(matr,nom_e,sal,date_emb,comm,no_dept) VALUES(7839,'LEROY',40000.00,'1991-11-17',0.00,10);
INSERT INTO _personnel(matr,nom_e,sal,date_emb,comm,no_dept) VALUES(7782,'LESAGE',19600.00,'1991-06-09',0.00,10);
INSERT INTO _personnel(matr,nom_e,sal,date_emb,comm,no_dept) VALUES(7902,'CHATEL',28290.00,'1991-12-17',0.00,20);
INSERT INTO _personnel(matr,nom_e,sal,date_emb,comm,no_dept) VALUES(7876,'CLEMENT',10373.00,'1995-05-10',0.00,20);
INSERT INTO _personnel(matr,nom_e,sal,date_emb,comm,no_dept) VALUES(7566,'MERCIER',27111.25,'1991-03-02',0.00,20);
INSERT INTO _personnel(matr,nom_e,sal,date_emb,comm,no_dept) VALUES(7788,'DUBOIS',28290.00,'1995-04-14',0.00,20);
INSERT INTO _personnel(matr,nom_e,sal,date_emb,comm,no_dept) VALUES(7369,'LECLERC',7544.00,'1990-12-02',0.00,20);


CREATE TABLE _president
(
  matr integer NOT NULL,
  CONSTRAINT president_pk PRIMARY KEY (matr ),
  CONSTRAINT president_is_personnel FOREIGN KEY (matr)
      REFERENCES _personnel (matr));
INSERT INTO _president(matr) VALUES(7839);

CREATE TABLE _employe
(
  matr integer NOT NULL,
  poste varchar(10) NOT NULL,
  sup integer NOT NULL,
  CONSTRAINT _employe_pk PRIMARY KEY (matr ),
  CONSTRAINT employe_dirige FOREIGN KEY (sup)
      REFERENCES _personnel (matr),
  CONSTRAINT employe_is_personnel FOREIGN KEY (matr)
      REFERENCES _personnel (matr));


INSERT INTO _employe(matr,poste,sup) VALUES(7566,'DIRECTEUR',7839);
INSERT INTO _employe(matr,poste,sup) VALUES(7698,'DIRECTEUR',7839);
INSERT INTO _employe(matr,poste,sup) VALUES(7782,'DIRECTEUR',7839);
INSERT INTO _employe(matr,poste,sup) VALUES(7788,'INGENIEUR',7566);
INSERT INTO _employe(matr,poste,sup) VALUES(7902,'INGENIEUR',7566);
INSERT INTO _employe(matr,poste,sup) VALUES(7499,'COMMERCIAL',7698);
INSERT INTO _employe(matr,poste,sup) VALUES(7521,'COMMERCIAL',7698);
INSERT INTO _employe(matr,poste,sup) VALUES(7844,'COMMERCIAL',7698);
INSERT INTO _employe(matr,poste,sup) VALUES(7654,'COMMERCIAL',7698);
INSERT INTO _employe(matr,poste,sup) VALUES(7900,'SECRETAIRE',7698);
INSERT INTO _employe(matr,poste,sup) VALUES(7934,'SECRETAIRE',7782);
INSERT INTO _employe(matr,poste,sup) VALUES(7876,'SECRETAIRE',7788);
INSERT INTO _employe(matr,poste,sup) VALUES(7369,'SECRETAIRE',7902);

-- PERSONNEL

create or replace view personnel as
with recursive subordonnes(sub,sup) as(
   select matr,sup
   from _employe
   union
   select e.matr,s.sup
   from subordonnes s inner join _employe e on e.sup=s.sub)
select matr , nom_e, sal, round(sal*0.05*count(sub),2) as prime_enc, date_emb, comm, no_dept
from subordonnes s right join _personnel p on s.sup=p.matr
group by matr, nom_e, sal, date_emb, comm, no_dept;

-- EMPLOYE

create or replace view employe as
select * 
from personnel natural join _employe;

-- PRESIDENT

create or replace view president as
select * 
from personnel natural join _president;

