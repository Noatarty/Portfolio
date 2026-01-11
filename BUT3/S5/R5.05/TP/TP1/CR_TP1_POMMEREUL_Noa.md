# CR TP1 Redis

## 3 Commands

### 3.1 Basic commands

#### 1. Store and then retrieve a string ”Aldo Maccione” associated to the key ”actor:1”

R: SET actor:1 "Aldo Maccione" et GET actor:1 et les retours sont respectivement OK et "Aldo Maccione".

##### 2. Store in a list ”movies:sw”the movies ”The phantom menace”and ”Attack of the Clones"

R: LPUSH movies:sw "The phantom menace" et LPUSH movies:sw "Attack of the Clones" et les retours sont respectivement (integer) 1 et (integer) 2.

#### 3. Return the length of the list ”movies:sw”

R: LLEN movies:sw et le retour est (integer) 2.

#### 4. Return (and remove) the element from the head of the list ”movies:sw”

R: LPOP movies:sw et le retour est "The phantom menace".

### 3.2 Queues and stacks

#### 1. Implement a queue (FIFO) using a list (for example with values 1, 2, 3, 4 and 5) using LPUSH. In particular how to design ”enqueue” and ”dequeue”

R: LPUSH fifo 1 ou 2 ou 3 ou 4 ou 5 pour enqueue et RPOP fifo pour dequeue. Les retours sont (integer) 1, (integer) 2, (integer) 3, (integer) 4, (integer) 5 et "1" pour dequeue.

#### 2. Implement a queue using RPUSH

R: RPUSH fifo 1 ou 2 ou 3 ou 4 ou 5 pour enqueue et LPOP fifo pour dequeue. On fait juste l'inverse de LPUSH et RPOP.

#### 3. Implement a stack (LIFO) using a list (for example with values 1, 2, 3, 4 and 5) using LPUSH. In particular how to design ”push” and ”pop”

R: LPUSH stack 1 ou 2 ou 3 ou 4 ou 5 pour push et LPOP stack pour pop. Les retours sont (integer) 1, (integer) 2, (integer) 3, (integer) 4, (integer) 5 et "5" pour pop.

#### 4. Implement a stack using RPUSH

R: RPUSH stack 1 ou 2 ou 3 ou 4 ou 5 pour push et RPOP stack pour pop. On fait juste l'inverse de LPUSH et RPOP.

## 4 Data caching

### 4.3 Validation

#### 4.3.1 Full result caching / Query caching

Let the query ```SELECT * FROM MOVIE WHERE RUNTIME=143``` associated to the following records:

```sql
tt0325980,Pirates of the Caribbean: The Curse of the Black Pearl,2003-07-09,143,140000000,655011224,<https://image.tmdb.org/t/p/original/z8onk7LV9Mmw6zKz4hT6pzzvmvl.jpg,8>

tt1477834,Aquaman,2018-07-06,143,160000000,1148461807,<https://image.tmdb.org/t/p/original/xLPffWMhMj1l5>
```

##### 1. Store the previous query as a string in the CSV format

```sql
SET "SELECT * FROM MOVIE WHERE RUNTIME=143" "tt0325980,Pirates of the Caribbean: The Curse of the Black Pearl,2003-07-09,143,140000000,655011224,<https://image.tmdb.org/t/p/original/z8onk7LV9Mmw6zKz4hT6pzzvmvl.jpg>\ntt1477834,Aquaman,2018-07-06,143,160000000,1148461807,<https://image.tmdb.org/t/p/original/xLPffWMhMj1l5>"
```

R: OK

##### 2. Store the previous query as a string in the JSON format

```sql
SET "SELECT * FROM MOVIE WHERE RUNTIME=143" '[{
      "idmdb": "tt0325980",
      "title": "Pirates of the Caribbean: The Curse of the Black Pearl",
      "release": "2003-07-09",
      "runtime": 143,
      "budget": 140000000,
      "revenue": 655011224,
      "poster": "<https://image.tmdb.org/t/p/original/z8onk7LV9Mmw6zKz4hT6pzzvmvl.jpg>",
      "overview": "",
      "rating": "",
      "last_update": ""
    },{
      "idmdb": "tt1477834",
      "title": "Aquaman",
      "release": "2018-07-06",
      "runtime": 143,
      "budget": 160000000,
      "revenue": 1148461807,
      "poster": "<https://image.tmdb.org/t/p/original/xLPffWMhMj1l5>",
      "overview": "",
      "rating": "",
      "last_update": ""
    }]'
```

#### 4.3.2 Individual result caching / Tuple caching

Let the 83 minute movie ’Snow White and the Seven Dwarfs’, released on 1937-12-21, associated with the id tt0029583. Its budget was 1488423$, its revenue is 184925486 $ and its rating is 7.6. Its cover can be seen at <https://image.tmdb.org/t/p/original/1P9eGGlT7eV7kAAvvSh9jfygr1C.jpg>.

##### 1. Store ’Snow White and the Seven Dwarfs’ as a CSV string

```sql
SET "tt0029583" 'tt0029583,Snow White and the Seven Dwarfs,1937-12-21,83,1488423,184925486,<https://image.tmdb.org/t/p/original/1P9eGGlT7eV7kAAvvSh9jfygr1C.jpg>'
```

##### 2. Retrieve the size of this CSV like entry (memory size)

R: la commande est MEMORY USAGE "tt0029583" et le résultat est (integer) 176

##### 3. Store ’Snow White and the Seven Dwarfs’ as a hash

```sql
HSET tt0029583 idmb tt0029583 title "Snow White and the Seven Dwarfs" release "1937-12-21" runtime 83 budget 1488423 revenue 184925486 poster '<https://image.tmdb.org/t/p/original/1P9eGGlT7eV7kAAvvSh9jfygr1C.jpg>'
```

##### 4. Retrieve the size of this hash entry

R: la commande est MEMORY USAGE tt0029583 et le résultat est (integer) 534
