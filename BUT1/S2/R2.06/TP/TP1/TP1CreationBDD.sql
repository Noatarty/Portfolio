drop schema if exists tp1 cascade;
create schema tp1;
set schema 'tp1';

create table DEPT
(
    nodept integer primary key,
    nomDept varchar(50) not null,
    lieu varchar(50) not null
);

create table EMP
(
    matr integer primary key,
    nomE varchar(50) not null,
    sal numeric(10,2) not null,
    poste varchar(50) not null,
    dateEmb date not null,
    comm numeric(10,2) not null,
    nodept integer not null,
    constraint DEPT_FK foreign key(nodept) references DEPT(nodept)
);

create table dirige
(
  sup integer not null,
  sub integer not null,
  constraint dirige_pk primary key(sup, sub),
  constraint sup_fk foreign key(sup) references EMP(matr),
  constraint sub_fk foreign key(sub) references EMP(matr)
);

INSERT INTO tp1.dept(nodept,nomdept,lieu)
VALUES (10,'FINANCES','PARIS'),
       (20,'RECHERCHES','GRENOBLE'),
       (30,'VENTES','LYON'),
       (40,'FABRICATION','ROUEN');

insert into dirige values(7839,7566);
insert into dirige values(7839,7698);
insert into dirige values(7839,7782);

insert into dirige values(7566,7788);
insert into dirige values(7566,7902);

insert into dirige values(7788,7876);
insert into dirige values(7902,7369);

insert into dirige values(7698,7499);
insert into dirige values(7698,7521);
insert into dirige values(7698,7844);
insert into dirige values(7698,7654);
insert into dirige values(7698,7900);

insert into dirige values(7782,7934);
