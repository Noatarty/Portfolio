# TD3

## 2 Data representation and hashing

### 2.1 Exercise 1

```python
Rio: 82+105+111 = 298
Home: 72+111+109+101 = 393
Soul: 83+111+117+108 = 419
Cars: 67+97+114+115 = 393
Luca: 76+117+99+97 = 389
Wish: 87+105+115+104 = 411
Sing: 83+105+110+103 = 401
Bolt: 66+111+108+116 = 401
Dune: 68+117+110+101 = 396
Vivo: 86+105+118+111 = 420
Coco: 67+111+99+111 = 388
Dumbo: 68+117+109+98+111 = 503
Brave: 66+114+97+118+101 = 496
Se7en: 83+101+55+101+110 = 450
Mulan: 77+117+108+97+110 = 509
Shrek: 83+104+114+101+107 = 509
```

## 3 Distributed hash table

### 3.1 Exercise 2

#### 1. Distribution with mod 3 S

Server A (mod 3 = 0): Home, Cars, Wish, Dune, Vivo, Se7en
Server B (mod 3 = 1): Rio, Coco, Brave
Server C (mod 3 = 2): Soul, Luca, Sing, Bolt, Dumbo, Mulan, Shrek

#### 2. Server C leaves (mod 2)

Server A (mod 2 = 0): Rio, Dune, Vivo, Coco, Brave, Se7en
Server B (mod 2 = 1): Home, Soul, Cars, Luca, Wish, Sing, Bolt, Dumbo, Mulan, Shrek
Modifications: 13 sur les 16 films

#### 3. Server D joins (mod 4)

Server A (mod 4 = 0): Dune, Vivo, Coco, Brave
Server B (mod 4 = 1): Home, Cars, Luca, Sing, Bolt, Mulan, Shrek
Server C (mod 4 = 2): Rio, Se7en
Server D (mod 4 = 3): Soul, Wish, Dumbo
Modifications: 14 sur les 16 films

## 4 (Simple) Consistent hashing

### 4.1 Exercise 4

First, mapping movies to the ring (hash % 360):

Coco: 28, Luca: 29, Home/Cars: 33, Dune: 36, Sing/Bolt: 41, Wish: 51, Soul: 59, Vivo: 60, Se7en: 90, Brave: 136, Dumbo: 143, Mulan/Shrek: 149, Rio: 298

#### 1. Simple consistent hashing (A:120, B:240, C:360)

Server A (0→120): Coco, Luca, Home, Cars, Dune, Sing, Bolt, Wish, Soul, Vivo, Se7en
Server B (121→240): Brave, Dumbo, Mulan, Shrek
Server C (241→360): Rio

#### 2. Server C leaves

Server A: All previous + Rio
Server B: Unchanged
Modifications: 1 movie (Rio)

#### 3. Virtual nodes distribution

Movies go to next virtual node clockwise.

Server A: Luca(29→A1:36), Dune(36→A1:36), Se7en(90→A3:108), Brave(136→A4:144), Mulan/Shrek(149→A5:180), Rio(298→A8:324)
Server B: Coco(28→B1:48), Home/Cars(33→B1:48), Sing/Bolt/Wish(→B1:48), Soul(59→B2:84), Dumbo(143→B4:156)
Server C: Vivo(60→C1:60)

#### 4. C leaves: C's movies redistribute to next available nodes (A or B)

#### 5. D joins: Movies redistribute based on new D virtual nodes positions

#### 6-8. Randomized strategy: Similar logic with interleaved virtual nodes minimizing redistribution
