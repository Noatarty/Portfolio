create schema td4r206;


CREATE TABLE td4r206._dept
(
  nodept integer NOT NULL,
  nomdept varchar(12) NOT NULL,
  lieu varchar(10) NOT NULL,
  CONSTRAINT dept_pk PRIMARY KEY (nodept ));

CREATE TABLE td4r206._personnel
(
  matr integer NOT NULL,
  nome varchar(10) NOT NULL,
  sal numeric(10,2) NOT NULL,
  datemb date NOT NULL,
  comm numeric(10,2) NOT NULL,
  nodept integer NOT NULL,
  CONSTRAINT _personnel_pk PRIMARY KEY (matr ),
  CONSTRAINT personnel_travaille FOREIGN KEY (nodept)
      REFERENCES td4r206._dept (nodept));

CREATE TABLE td4r206._president
(
  matr integer NOT NULL,
  CONSTRAINT president_pk PRIMARY KEY (matr ),
  CONSTRAINT president_is_personnel FOREIGN KEY (matr)
      REFERENCES td4r206._personnel (matr));

CREATE TABLE td4r206._employe
(
  matr integer NOT NULL,
  poste varchar(10) NOT NULL,
  sup integer NOT NULL,
  CONSTRAINT _employe_pk PRIMARY KEY (matr ),
  CONSTRAINT employe_dirige FOREIGN KEY (sup)
      REFERENCES td4r206._personnel (matr),
  CONSTRAINT employe_is_personnel FOREIGN KEY (matr)
      REFERENCES td4r206._personnel (matr));

-- PERSONNEL

create or replace view td4r206.personnel as
with recursive subordonnes(sub,sup) as(
   select matr,sup
   from td4r206._employe
   union
   select e.matr,s.sup
   from subordonnes s inner join td4r206._employe e on e.sup=s.sub)
select matr , nome, sal, round(sal*0.05*count(sub),2) as prime_enc, datemb, comm, nodept
from subordonnes s right join td4r206._personnel p on s.sup=p.matr
group by matr, nome, sal, datemb, comm, nodept;

-- EMPLOYE

create or replace view td4r206.employe as
select * 
from td4r206.personnel natural join td4r206._employe;

-- PRESIDENT

create or replace view td4r206.president as
select * 
from td4r206.personnel natural join td4r206._president;

