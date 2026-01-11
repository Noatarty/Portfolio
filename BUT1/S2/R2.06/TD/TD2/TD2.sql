/* Exercice 1 */

CREATE TABLE COMPETENCE(
	code_comp VARCHAR(10) PRIMARY KEY,
	libel_comp VARCHAR(40) NOT NULL
);

CREATE TABLE EMPLOYE(
	matricule_emp VARCHAR(10) PRIMARY KEY,
	nomp_emp VARCHAR(50) NOT NULL,
	prenom_emp VARCHAR(50) NOT NULL
);

CREATE TABLE possede(
	code_comp VARCHAR(10),
	matricule_emp VARCHAR(10),

	CONSTRAINT possede_pk PRIMARY KEY (code_comp, matricule_emp),
	CONSTRAINT possede_fk1 FOREIGN KEY (code_comp) REFERENCES COMPETENCE(code_comp),
	CONSTRAINT possede_fk2 FOREIGN KEY (matricule_emp) REFERENCES EMPLOYE(matricule_emp)
);

CREATE TABLE AFFAIRE(
	no_affaire INT PRIMARY KEY
);

CREATE TABLE intervenir(
	code_comp VARCHAR(10),
	matricule_emp VARCHAR(10),
	no_affaire INT,

	CONSTRAINT intervenir_pk PRIMARY KEY (code_comp, matricule_emp, no_affaire),
	CONSTRAINT intervenir_fk1 FOREIGN KEY (code_comp, matricule_emp) REFERENCES possede(code_comp, matricule_emp),
	CONSTRAINT intervenir_fk1 FOREIGN KEY (no_affaire) REFERENCES AFFAIRE(no_affaire)
);

/* Exercice 2 */

