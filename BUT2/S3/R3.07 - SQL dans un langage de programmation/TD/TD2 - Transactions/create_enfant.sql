CREATE TABLE IF NOT EXISTS enfant
(
   nopers  integer       NOT NULL,
   prenom  varchar(20)   NOT NULL,
   points  integer       NOT NULL,
   classe  varchar(10)   NOT NULL
);

ALTER TABLE enfant
   ADD CONSTRAINT enfant_pk
   PRIMARY KEY (nopers);


INSERT INTO enfant (nopers,prenom,points,classe) 
VALUES
  (1,'Jean',10,'CM1_1'),
  (3,'Alfred',15,'CE1_2'),
  (4,'Aline',9,'CE2_2'),
  (2,'Pierre',33,'CE1_2');

COMMIT;
