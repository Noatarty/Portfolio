--Question 5
CREATE TABLE forum1.document (
    iddoc SERIAL PRIMARY KEY,
    content TEXT,
    create_date DATE
);

CREATE TABLE forum1.post (
    iddoc SERIAL PRIMARY KEY,
    content TEXT,
    create_date DATE
);

CREATE TABLE forum1.comment (
    iddoc SERIAL PRIMARY KEY,
    content TEXT,
    create_date DATE
);

-- Contrainte pour assurer que les iddoc sont uniques dans les trois tables
ALTER TABLE forum1.document ADD CONSTRAINT unique_iddoc UNIQUE (iddoc);
ALTER TABLE forum1.post ADD CONSTRAINT unique_iddoc UNIQUE (iddoc);
ALTER TABLE forum1.comment ADD CONSTRAINT unique_iddoc UNIQUE (iddoc);