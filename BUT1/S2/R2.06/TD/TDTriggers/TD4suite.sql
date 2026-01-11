set schema 'td4r206';

-- 1. Type de niveau ligne (n-uplet)
-- 2. INSERT ou UPDATE
-- 3. Avant insertion ou MAJ

create or replace function ftg_majuscules() returns trigger as $ftg_majuscules$
begin
    new.nom_e = upper(new.nom_e);
    return new;
end;
$ftg_majuscules$ language 'plpgsql';

create trigger tg_majuscules
before insert or update
on _personnel
for each row
execute procedure ftg_majuscules();

update _personnel set nom_e='dupont' where nom_e='LEROY';

insert into _personnel (matr, nom_e, sal, date_emb, comm, no_dept) values (1234,'Quiniou',150000, '2015-09-01', 0, 10);

create or replace function mise_a_jour_sal() returns trigger as $mise_a_jour_sal$
begin
    update _employe
    set sal = sal * 1.05
    where matr = new.matr;
    return new;
end;
$mise_a_jour_sal$ language 'plpgsql';

create trigger tg_salaire
before update
on _employe
for each row
when (new.poste='DIRECTEUR')
execute procedure mise_a_jour_sal();

create or replace function td4r206.ajout_emp() returns trigger as $ajout_emp$
declare
v_nodept integer;
begin
if NEW.poste='DIRECTEUR' then
perform * from _employe
where poste='DIRECTEUR' and nodept=NEW.nodept;
if found then
raise exception 'directeur deja présnet dans le dept no %', NEW.nodept;
end if;
select matr into v_nodept from td4r206._president;
else
select no_dept into v_nodept from td4r206.employe
where matr=NEW.sup;
if NEW.no_dept != v_nodept then
raise exception 'nodept incompatible avec sup';
end if;
end if;
insert into td4r206._personnel values(NEW.matr,NEW.nom_e,NEW.sal,current_date,0,NEW.no_dept);
insert into td4r206._employe values(NEW.matr,NEW.poste,NEW.sup);
return new;
end;
$ajout_emp$ language plpgsql;

create trigger ajout_emp
instead of insert on td4r206.employe
for each row execute procedure td4r206.ajout_emp();

drop trigger if exists ajout_emp on td4r206.employe;

insert into td4r206.employe (matr,nom_e,poste,sal,no_dept,sup)
values (1234,'Dupont','TECHNICIEN',20000.00,20,7788);