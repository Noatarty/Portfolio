CREATE KEYSPACE IF NOT EXISTS movies WITH REPLICATION = {'class' : 'SimpleStrategy', 'replication_factor': 1};
USE movies;

DROP TABLE IF EXISTS movie; CREATE TABLE movie(idimdb text, title text, release text, runtime int, budget int, revenue int, poster text, rating float, PRIMARY KEY (idimdb, runtime));

COPY movie (idimdb, title, release, runtime, budget, revenue, poster, rating) FROM '/tmp/movies.csv' WITH DELIMITER=',';
