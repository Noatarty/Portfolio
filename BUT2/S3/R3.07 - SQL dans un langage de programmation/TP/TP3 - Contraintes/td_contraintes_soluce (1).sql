-- Exclusion et totalité = partition
-- Cas classique de l'héritage
-- Sujet sur les blogs/forums : un post n'est pas un comment, un comment
-- n'est pas un post et réunis, ils forment l'ensemble des documents.

-- VERSION SQL : schéma forum 1
set schema 'forum1';

create or replace view document_exclusion as
    select iddoc
    from _post 
    intersect
    select iddoc
    from _comment;

create or replace view document_totalite as 
    select iddoc from _document
    except
    (   select iddoc from _post
        union
        select iddoc from _comment);

create or replace function ftg_document_totalite() 
  returns trigger as $$
begin
  perform * from document_totalite;
  if found then
    raise exception 'Vous devez créer un post ou un commentaire, pas un document seul !';
  end if;
  return null;
end;
$$ language plpgsql;

DROP TRIGGER if exists tg_document_totalite ON forum1._document CASCADE;
create trigger tg_document_totalite
after insert
on _document for each row
execute procedure ftg_document_totalite();


---- TESTS 
select setval('_document_iddoc_seq',14);
start transaction;
insert into forum1._document (content, author)
    values ('Test1 : doc sans post ni comment','Alex');
insert into forum1._post values(14);
commit;
-- Meme avec une transaction, ça ne passe pas : faire un trigger contrainte DEFERRABLE



DROP TRIGGER if exists tg_document_totalite 
ON forum1._document CASCADE;
create CONSTRAINT trigger tg_document_totalite
after insert
on _document 
DEFERRABLE INITIALLY DEFERRED
for each row
execute procedure ftg_document_totalite();


-- Nouveau test avec un document "orphelin"
begin;
insert into forum1._document (content, author)
    values ('Test1 : doc sans post ni comment','Alex');
commit; -- Ca provoque l'erreur ici seulement : parfait !

select setval('_document_iddoc_seq',14);
begin;
insert into forum1._document (content, author)
    values ('Test1 : doc sans post ni comment','Alex');
select iddoc from _document; -- petite verif du iddoc à insérer dans _post
insert into forum1._post values(16);
commit; -- Et ici ça passe




select currval('_document_iddoc_seq');
select setval('_document_iddoc_seq', 14);





