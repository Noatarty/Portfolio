create table equipes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    code VARCHAR(3) UNIQUE NOT NULL,
    nom VARCHAR(50) NOT NULL,
    poule INT NOT NULL
);

create table matches_poules (
    id INT PRIMARY KEY AUTO_INCREMENT,
    code_equipe_1 VARCHAR(3) UNIQUE NOT NULL,
    code_equipe_1 VARCHAR(3) UNIQUE NOT NULL,
    date_match DATE NOT NULL,
    score_equipe_1 INT DEFAULT 0,
    score_equipe_2 INT DEFAULT 0,
    points_equipe_1 INT DEFAULT 0,
    points_equipe_2 INT DEFAULT 0,
    FOREIGN KEY (code_equipe_1) REFERENCES equipes(code),
    FOREIGN KEY (code_equipe_2) REFERENCES equipes(code),
)

create table matches_finale (
    id INT PRIMARY KEY AUTO_INCREMENT,
    code_equipe_1 VARCHAR(3) UNIQUE NOT NULL,
    code_equipe_1 VARCHAR(3) UNIQUE NOT NULL,
    date_match DATE NOT NULL,
    score_equipe_1 INT DEFAULT 0,
    score_equipe_2 INT DEFAULT 0,
    points_equipe_1 INT DEFAULT 0,
    points_equipe_2 INT DEFAULT 0,
    FOREIGN KEY (code_equipe_1) REFERENCES equipes(code),
    FOREIGN KEY (code_equipe_2) REFERENCES equipes(code),
)