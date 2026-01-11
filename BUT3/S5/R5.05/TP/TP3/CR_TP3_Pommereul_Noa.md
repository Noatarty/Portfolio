# TD3 - Cassandra

## 5 Activities on querying and data models

### 5.1 Queries (in CQL)

#### 1. All movies

**Requete :**

```sql
SELECT * FROM movie;
```

**Retour :**

```md
 idimdb     | budget    | poster                                                              | rating | release    | revenue    | runtime | title
------------+-----------+---------------------------------------------------------------------+--------+------------+------------+---------+-----------------------------
  tt5715410 |  30000000 | https://image.tmdb.org/t/p/original/5yCQvhFuFPY0pACxoUpLUlYCxop.jpg |    6.2 | 2017-07-26 |   46372519 |      92 |The Son of Bigfoot
 tt12441478 |         0 | https://image.tmdb.org/t/p/original/86jyzdxtAX8p956rVQDKwGbrYh2.jpg |    4.7 | 2021-01-27 |     384659 |      82 |アーヤと 魔女
  tt0266543 |  94000000 | https://image.tmdb.org/t/p/original/eHuGQ10FUzK1mdOY69wF5pGgEf5.jpg |    8.1 | 2003-05-30 |  940335536 |     100 |Finding Nemo
  tt0126029 |  60000000 | https://image.tmdb.org/t/p/original/iB64vpL3dIObOtMZgX3RqdVdQDc.jpg |    7.9 | 2001-05-18 |  487853320 |      90 |Shrek
  tt1453405 | 200000000 | https://image.tmdb.org/t/p/original/upaMBEonGeZGQc3xtUVZOfe1lGl.jpg |    7.2 | 2013-06-19 |  743559607 |     104 |Monsters University
  tt6718170 | 100000000 | https://image.tmdb.org/t/p/original/qNBAXBIQlnOThrVvA6mA2B5ggV6.jpg |    7.4 | 2023-04-05 |  677959700 |      92 |The Super Mario Bros. Movie
  tt0413267 | 160000000 | https://image.tmdb.org/t/p/original/n4SexGGQzI26E269tfpa80MZaGV.jpg |    6.1 | 2007-05-17 |  813367380 |      93 |Shrek the Third
  tt1754455 |         0 | https://image.tmdb.org/t/p/original/ot2u06E1TjVCXkcoAEPSE1hHuTi.jpg |    6.4 | 2010-11-24 |          0 |      80 |L'apprenti Père Noël
  tt0448115 |  80000000 | https://image.tmdb.org/t/p/original/xnopI5Xtky18MPhK40cZAGAOVeV.jpg |      7 | 2019-03-29 |  365971656 |     132 |Shazam!
  tt0317219 | 120000000 | https://image.tmdb.org/t/p/original/qa6HCwP4Z15l3hpsASz3auugEW6.jpg |    7.1 | 2006-06-08 |  461983149 |     117 |Cars
```

#### 2. Title and runtime of movies

**Requete :**

```sql
SELECT title, runtime FROM movie;
```

**Retour :**

```md
title                                                  | runtime
-------------------------------------------------------+---------
                                    The Son of Bigfoot |      92
                                           アーヤと魔女 |      82
                                           Finding Nemo|     100
                                                  Shrek|      90
                                    Monsters University|     104
                            The Super Mario Bros. Movie|      92
                                        Shrek the Third|      93
                                   L'apprenti Père Noël|      80
                                                Shazam!|     132
                                                   Cars|     117
```

#### 3. 81 minutes movies

**Requete :**

```sql
SELECT * FROM movie WHERE runtime = 81 ALLOW FILTERING;
```

**Retour :**

```md
 idimdb    | budget   | poster                                                              | rating | release    | revenue   | runtime | title
-----------+----------+---------------------------------------------------------------------+--------+------------+-----------+---------+-----------------------------------
 tt0096842 |        0 | https://image.tmdb.org/t/p/original/rcFi9JvJMjwxp4lK66v4KueqglW.jpg |    6.4 | 1989-10-04 |         0 |      81 |      Astérix et le coup du menhir
 tt0115491 |        0 | https://image.tmdb.org/t/p/original/kTH7qEyvdDYMoQraQZm3LFKCge3.jpg |    6.4 | 1996-05-20 |         0 |      81 |   Aladdin and the King of Thieves
 tt1216516 |        0 | https://image.tmdb.org/t/p/original/hg1959yuBkHb4BKbIvETQSfxGCT.jpg |    6.7 | 2009-09-03 |         0 |      81 | Tinker Bell and the Lost Treasure
 tt7367960 |        0 | https://image.tmdb.org/t/p/original/dzN5xbp73TI7pjEqZ66ECNxdWJl.jpg |    7.2 | 2018-12-25 |         0 |      81 |                      Ternet Ninja
 tt0114709 | 30000000 | https://image.tmdb.org/t/p/original/uXDfjJbdP4ijW5hWSBrPrlKpxab.jpg |    8.3 | 1995-10-30 | 373554033 |      81 |                         Toy Story
 tt0268380 | 59000000 | https://image.tmdb.org/t/p/original/gLhHHZUzeseRXShoDyC4VqLgsNv.jpg |    7.5 | 2002-03-10 | 383257136 |      81 |                           Ice Age
```

#### 4. Movies which runtime is between 60 minutes and 80 minutes

**Requete :**

```sql
SELECT * FROM movie WHERE runtime  >= 60 AND runtime <= 80 ALLOW FILTERING;
```

**Retour :**

```md
 idimdb     | budget    | poster                                                              | rating | release    | revenue   | runtime | title
------------+-----------+---------------------------------------------------------------------+--------+------------+-----------+---------+---------------------------------------------------
  tt1754455 |         0 | https://image.tmdb.org/t/p/original/ot2u06E1TjVCXkcoAEPSE1hHuTi.jpg |    6.4 | 2010-11-24 |         0 |      80 |                              L'apprenti Père Noël
 tt10635042 |         0 |  https://image.tmdb.org/t/p/original/aHMhFF7mT9tWyqBqeXBicjoYNS.jpg |    7.1 | 2021-01-08 |         0 |      80 |       劇場版 美少女戦士セーラームーンEternal 前編
  tt0371823 |         0 | https://image.tmdb.org/t/p/original/23bvOwfOS9fw347Yc68yPpkmd8i.jpg |    6.4 | 2004-08-04 |         0 |      68 |       Mickey, Donald, Goofy: The Three Musketeers
  tt0243585 | 120000000 | https://image.tmdb.org/t/p/original/hjfeMLWqJY44mqqJKZSa6jx4Y1j.jpg |    5.5 | 2002-07-19 | 169956806 |      78 |                                   Stuart Little 2
  tt0288441 |         0 | https://image.tmdb.org/t/p/original/eIkXJggVmzN4MyPgJ2kDjOy9lmQ.jpg |    6.3 | 2001-09-30 |         0 |      76 |                          Barbie in the Nutcracker
  tt0450982 |         0 | https://image.tmdb.org/t/p/original/a0VPQHpLNCWWmiXwjD7aJVRaH78.jpg |      6 | 2005-03-08 |         0 |      70 |                                Barbie: Fairytopia
  tt0283426 |  20000000 |  https://image.tmdb.org/t/p/original/DhuskQc9lSjPiYKr9hy0AZ7uiC.jpg |    5.4 | 2003-02-07 | 135680000 |      72 |                                 The Jungle Book 2
  tt5042436 |         0 | https://image.tmdb.org/t/p/original/uxdvJHE5V844dTlK2EmqRQCTYDb.jpg |    5.7 | 2016-01-15 |         0 |      75 |                                 Barbie: Spy Squad
 tt12767498 |         0 | https://image.tmdb.org/t/p/original/AwkmMTKJBAatbeAVhTwhcU3Pyp4.jpg |    5.6 | 2020-09-01 |         0 |      72 |                        Barbie: Princess Adventure
  tt0033563 |    812000 | https://image.tmdb.org/t/p/original/hKDdllslMtsU9JixAv5HR9biXlp.jpg |    7.2 | 1941-10-31 |   1600000 |      64 |                                             Dumbo
```

#### 5. Number of movies

**Requete :**

```sql
SELECT count(*) FROM movie;
```

**Retour :**

```md
count
-------
   463
```

#### 6. Number of movies per runtime

**Prérequis :**

Je dois changer la primary key pour que la runtime soit une colonne

```sql
DROP TABLE IF EXISTS movie; 
CREATE TABLE movie(
    idimdb text,
    title text,
    release text, 
    runtime int, 
    budget int, 
    revenue int, 
    poster text, 
    rating float, 
    PRIMARY KEY (runtime, idimdb)
    );
```

**Requete :**

```sql
SELECT runtime, count(*) FROM movie GROUP BY runtime;
```

**Retour :**

```md
 runtime | count
---------+-------
     114 |     3
     110 |     2
      91 |    13
     128 |     1
     117 |     6
     120 |     2
     140 |     4
     129 |     2
     132 |     1
     105 |    11
```

#### 7. Average budget

**Requete :**

```sql
SELECT avg(budget) FROM movie;
```

**Retour :**

```md
system.avg(budget)
--------------------
           57077875
```

#### 8. Most expensive movie

**Requete :**

```sql
SELECT idimdb, title, MAX(budget) FROM movie;
```

**Retour :**

```md
 idimdb    | title         | system.max(budget)
-----------+---------------+--------------------
 tt1133985 | Green Lantern |          460000000
```

#### 9. Titles of movies ordered in decreasing order by runtime

**Prérequis :**
Avoir une clé de clustering commun or dans la table il n'y a pas d'élément commun a tous les films donc c'est pas possible.

**Requete :**

**Retour :**

#### 10. Title of three movies that are longer than 140 minutes

**Requete :**

```sql
SELECT title FROM movie WHERE runtime > 140 LIMIT 3 ALLOW FILTERING;
```

**Retour :**

```md
title
--------------------------------------------------------
             Pirates of the Caribbean: Dead Man's Chest
 Pirates of the Caribbean: The Curse of the Black Pearl
                                                Aquaman
```

### 5.2 Models

#### 1. Genders with a set of movies that fit within the gender

```sql
CREATE TABLE gender (
    idgender text,
    name text,
    movies set<text>,
    PRIMARY KEY (idgender)
);
```

#### 2. Movies with a set of actors

```sql
CREATE TABLE movie_with_actors (
    idmovie text,
    title text,
    actors set<text>,
    PRIMARY KEY (idmovie)
);
```

#### 3. Studios with a set of movies that have been produced

```sql
CREATE TABLE studio (
    idstudio text,
    name text,
    movies set<text>,
    PRIMARY KEY (idstudio)
);
```

#### 4. Movies with all the elements (actors, studios and genders)

```sql
CREATE TABLE movie (
    idmovie text,
    title text,
    release text, 
    runtime int, 
    budget int, 
    revenue int, 
    poster text, 
    rating float,
    actors set<text>,
    studios set<text>,
    genders set<text>,
    PRIMARY KEY (idmovie)
);
```
