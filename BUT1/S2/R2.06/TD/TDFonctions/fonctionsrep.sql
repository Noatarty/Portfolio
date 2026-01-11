set schema 'td4r206';

drop function if exists anciennete(ma_date date);
CREATE FUNCTION anciennete(ma_date date) returns integer as $anciennete$
declare
  nb_annees integer;
begin
  select (extract(year from current_date) - extract(year from ma_date)) into nb_annees;
  return nb_annees;
end;
$anciennete$ language 'plpgsql';

select anciennete('06/06/1984');

drop function if exists nbdepts(deptnom varchar(12));
create or replace function nbdepts(deptnom varchar(12)) returns integer as $nbdepts$
declare
  n integer;
begin
  select count(*) into n from _dept where nom_dept=deptnom;
  return n;
end;
$nbdepts$ language 'plpgsql';

select nbdepts('Astronomie');

drop function if exists propIng();
create or replace function propIng() returns numeric as $propIng$
declare
  nb_tuples numeric;
  nb_employe numeric;
begin
  select count(*) into nb_tuples from _employe;
  select count(*) into nb_employe from _employe where poste='INGENIEUR';
  return (nb_employe/nb_tuples)*100;
 end;
 $propIng$ language 'plpgsql';
 
select propIng();

-- fonction popIng mais qui renvoie NULL si la table est vide
drop function if exists propIng2();
create or replace function propIng2() returns numeric as $propIng2$
declare
  nb_tuples numeric;
  nb_employe numeric;
begin
  select count(*) into nb_tuples from _employe;
  /*if nb_tuples=0 then
    return null;
  else
  */
    select count(*) into nb_employe from _employe where poste='INGENIEUR';
    return (nb_employe/nb_tuples)*100;
  -- end if;
  exception
    when division_by_zero then
      return null;
  end;
  $propIng2$ language 'plpgsql';

  select propIng2();

drop function if exists nbsup(superieur integer);
create or replace function nbsup(superieur integer) returns integer as $nbsup$
declare 
  nbsuperieur integer;
begin
  select count(*) into nbsuperieur from _employe where sup=superieur;
  return nbsuperieur;
end;
$nbsup$ language 'plpgsql';

select nbsup(7839);

drop function if exists nbsup(superieur integer);
create or replace function nbsup(superieur integer) returns integer as $nbsup$
declare 
  nbsuperieur integer;
begin
  with recursive subordonnes(matr) as (select matr from _employe where sup=superieur union select e.matr from _employe e inner join subordonnes s on e.sup=s.matr)
  select count(*) into nbsuperieur from subordonnes;
  return nbsuperieur;
end;
$nbsup$ language 'plpgsql';

select nbsup(7839);

drop function if exists subordination(chef integer);
create or replace function subordination(chef integer) returns table(sup integer, sub integer) as $subordination$
  with recursive hierarchie(sup, sub) as (
    select sup, matr from _employe where sup=chef union select chef, e.matr from _employe e inner join hierarchie h on e.sup=h.sub
  )
  select * from hierarchie;
$subordination$ language 'sql';

select * from subordination(7698);
