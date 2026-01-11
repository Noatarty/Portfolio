SET SCHEMA 'enfants';

START TRANSACTION ;

ALTER TABLE enfant ADD COLUMN nom VARCHAR(20);

UPDATE enfant SET nom = 'Dupont' WHERE nopers = 1 ;

ROLLBACK ;
