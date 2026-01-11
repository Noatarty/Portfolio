# TP4 - Elastic Search

## 4 Activities

### 4.1 URL

#### 1. 82 minutes movies

*Request*

http://localhost:9200/ariane-movies/_search?q=runtime:82&pretty

*Result*
```json
{
  "took" : 77,
  "timed_out" : false,
  "_shards" : {
    "total" : 1,
    "successful" : 1,
    "skipped" : 0,
    "failed" : 0
  },
  "hits" : {
    "total" : {
      "value" : 7,
      "relation" : "eq"
    },
    "max_score" : 1.0,
    "hits" : [
      {
        "_index" : "ariane-movies",
        "_id" : "18",
        "_score" : 1.0,
        "_source" : {
          "idimdb" : "tt0072901",
          "title" : "Les 12 travaux d'Astérix",
          "release" : "1976-06-26",
          "runtime" : 82,
          "budget" : 0,
          "revenue" : 0,
          "poster" : "https://image.tmdb.org/t/p/original/7cZQZOYZFJcLjZnxWjO5PcUtmDZ.jpg",
          "rating" : 7.7
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "216",
        "_score" : 1.0,
        "_source" : {
          "idimdb" : "tt1239462",
          "title" : "La véritable histoire du Chat Botté",
          "release" : "2009-04-01",
          "runtime" : 82,
          "budget" : 0,
          "revenue" : 0,
          "poster" : "https://image.tmdb.org/t/p/original/va4tC2RBC0uwpmq0cctruJmZgFs.jpg",
          "rating" : 3
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "217",
        "_score" : 1.0,
        "_source" : {
          "idimdb" : "tt12441478",
          "title" : "アーヤと魔女",
          "release" : "2021-01-27",
          "runtime" : 82,
          "budget" : 0,
          "revenue" : 384659,
          "poster" : "https://image.tmdb.org/t/p/original/86jyzdxtAX8p956rVQDKwGbrYh2.jpg",
          "rating" : 4.7
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "226",
        "_score" : 1.0,
        "_source" : {
          "idimdb" : "tt1287468",
          "title" : "Cats & Dogs: The Revenge of Kitty Galore",
          "release" : "2010-07-28",
          "runtime" : 82,
          "budget" : 85000000,
          "revenue" : 112483764,
          "poster" : "https://image.tmdb.org/t/p/original/nTsZT66I4U3aS9ezLdOKacfvo8T.jpg",
          "rating" : 4.4
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "342",
        "_score" : 1.0,
        "_source" : {
          "idimdb" : "tt3332410",
          "title" : "L'Apprenti Père Noël et le flocon magique",
          "release" : "2013-11-20",
          "runtime" : 82,
          "budget" : 10000000,
          "revenue" : 78,
          "poster" : "https://image.tmdb.org/t/p/original/fV6pwW85sg40NDk7c72AgZt0t88.jpg",
          "rating" : 6.3
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "380",
        "_score" : 1.0,
        "_source" : {
          "idimdb" : "tt4940416",
          "title" : "Duck Duck Goose",
          "release" : "2018-03-09",
          "runtime" : 82,
          "budget" : 0,
          "revenue" : 0,
          "poster" : "https://image.tmdb.org/t/p/original/7XURM64DYa9DpS70I2rM4suvq1s.jpg",
          "rating" : 5.8
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "398",
        "_score" : 1.0,
        "_source" : {
          "idimdb" : "tt5790684",
          "title" : "Mia and Me: The Hero of Centopia",
          "release" : "2022-05-26",
          "runtime" : 82,
          "budget" : 0,
          "revenue" : 0,
          "poster" : "https://image.tmdb.org/t/p/original/qwlMyrQ84FwYtTTZ8iZinSYVghy.jpg",
          "rating" : -1
        }
      }
    ]
  }
}
```

#### 2. Movies which title contains christmas

*Request*

http://localhost:9200/ariane-movies/_search?q=title:christmas&pretty

*Result*
```json
{
  "took" : 10,
  "timed_out" : false,
  "_shards" : {
    "total" : 1,
    "successful" : 1,
    "skipped" : 0,
    "failed" : 0
  },
  "hits" : {
    "total" : {
      "value" : 18,
      "relation" : "eq"
    },
    "max_score" : 3.8824062,
    "hits" : [
      {
        "_index" : "ariane-movies",
        "_id" : "239",
        "_score" : 3.8824062,
        "_source" : {
          "idimdb" : "tt1430607",
          "title" : "Arthur Christmas",
          "release" : "2011-11-10",
          "runtime" : 97,
          "budget" : 10000000,
          "revenue" : 0,
          "poster" : "https://image.tmdb.org/t/p/original/sPCrGLdTMn0ud3oAJG37VDxpQfZ.jpg",
          "rating" : 7.1
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "248",
        "_score" : 3.3965616,
        "_source" : {
          "idimdb" : "tt14715170",
          "title" : "Falling for Christmas",
          "release" : "2022-11-10",
          "runtime" : 95,
          "budget" : 0,
          "revenue" : 0,
          "poster" : "https://image.tmdb.org/t/p/original/xs2S7EnrKHVW2DYoGSZfpvOZrF5.jpg",
          "rating" : 5.4
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "264",
        "_score" : 3.3965616,
        "_source" : {
          "idimdb" : "tt15979222",
          "title" : "A Kindhearted Christmas",
          "release" : "2021-11-20",
          "runtime" : 84,
          "budget" : 0,
          "revenue" : 0,
          "poster" : "https://image.tmdb.org/t/p/original/rNvfIcaYjQjczvW6o3qdB7W4vz.jpg",
          "rating" : 7
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "334",
        "_score" : 3.3965616,
        "_source" : {
          "idimdb" : "tt2990140",
          "title" : "The Christmas Chronicles",
          "release" : "2018-11-22",
          "runtime" : 104,
          "budget" : 0,
          "revenue" : 0,
          "poster" : "https://image.tmdb.org/t/p/original/5Il2EMSF2KecrUKZPuen6BZmaCP.jpg",
          "rating" : 7
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "429",
        "_score" : 3.3965616,
        "_source" : {
          "idimdb" : "tt7422638",
          "title" : "48 Christmas Wishes",
          "release" : "2017-12-01",
          "runtime" : 84,
          "budget" : 0,
          "revenue" : 0,
          "poster" : "https://image.tmdb.org/t/p/original/mrcA62O9j8y4gsSpftMKVcvrzCI.jpg",
          "rating" : 4
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "433",
        "_score" : 3.3965616,
        "_source" : {
          "idimdb" : "tt7608418",
          "title" : "A Christmas Prince",
          "release" : "2017-11-17",
          "runtime" : 92,
          "budget" : 0,
          "revenue" : 0,
          "poster" : "https://image.tmdb.org/t/p/original/x0IGQsMzVbsF7noj5cCfEk1GU7s.jpg",
          "rating" : 5.8
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "452",
        "_score" : 3.3965616,
        "_source" : {
          "idimdb" : "tt8861786",
          "title" : "Puppy Star Christmas",
          "release" : "2018-11-20",
          "runtime" : 90,
          "budget" : 0,
          "revenue" : 0,
          "poster" : "https://image.tmdb.org/t/p/original/ztmVR4XlmAWtHFjDBWh2VyYcyuC.jpg",
          "rating" : 4
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "176",
        "_score" : 3.0187898,
        "_source" : {
          "idimdb" : "tt10060094",
          "title" : "The Knight Before Christmas",
          "release" : "2019-11-21",
          "runtime" : 92,
          "budget" : 0,
          "revenue" : 0,
          "poster" : "https://image.tmdb.org/t/p/original/ivymBQYzYqZoLhvgYg77gSzXKsA.jpg",
          "rating" : 5.6
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "229",
        "_score" : 3.0187898,
        "_source" : {
          "idimdb" : "tt13103340",
          "title" : "Father Christmas Is Back",
          "release" : "2021-11-07",
          "runtime" : 105,
          "budget" : 0,
          "revenue" : 0,
          "poster" : "https://image.tmdb.org/t/p/original/mI6mFCO3lrJ4ovzwfmoLs58uhlK.jpg",
          "rating" : 4.5
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "291",
        "_score" : 3.0187898,
        "_source" : {
          "idimdb" : "tt20561114",
          "title" : "Christmas on Mistletoe Farm",
          "release" : "2022-11-23",
          "runtime" : 104,
          "budget" : 0,
          "revenue" : 0,
          "poster" : "https://image.tmdb.org/t/p/original/rGCwI76dylPViDF9VXFY0ORRhls.jpg",
          "rating" : -1
        }
      }
    ]
  }
}

```

#### 3. Movies which title contains christmas or prince

*Request*

http://localhost:9200/ariane-movies/_search?q=title:(christmas%20OR%20prince)&pretty
*Result*
```json
{
  "took" : 11,
  "timed_out" : false,
  "_shards" : {
    "total" : 1,
    "successful" : 1,
    "skipped" : 0,
    "failed" : 0
  },
  "hits" : {
    "total" : {
      "value" : 19,
      "relation" : "eq"
    },
    "max_score" : 8.287371,
    "hits" : [
      {
        "_index" : "ariane-movies",
        "_id" : "433",
        "_score" : 8.287371,
        "_source" : {
          "idimdb" : "tt7608418",
          "title" : "A Christmas Prince",
          "release" : "2017-11-17",
          "runtime" : 92,
          "budget" : 0,
          "revenue" : 0,
          "poster" : "https://image.tmdb.org/t/p/original/x0IGQsMzVbsF7noj5cCfEk1GU7s.jpg",
          "rating" : 5.8
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "174",
        "_score" : 6.0253363,
        "_source" : {
          "idimdb" : "tt10006006",
          "title" : "A Christmas Prince: The Royal Baby",
          "release" : "2019-12-05",
          "runtime" : 84,
          "budget" : 0,
          "revenue" : 0,
          "poster" : "https://image.tmdb.org/t/p/original/4RErLw0APt8qQiee0d8VCKasWwl.jpg",
          "rating" : 5.4
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "449",
        "_score" : 6.0253363,
        "_source" : {
          "idimdb" : "tt8709036",
          "title" : "A Christmas Prince: The Royal Wedding",
          "release" : "2018-11-30",
          "runtime" : 92,
          "budget" : 0,
          "revenue" : 0,
          "poster" : "https://image.tmdb.org/t/p/original/2bLQTbFWrsunSVQsvOWZAAGACbf.jpg",
          "rating" : 5.3
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "68",
        "_score" : 4.346844,
        "_source" : {
          "idimdb" : "tt0120794",
          "title" : "The Prince of Egypt",
          "release" : "1998-12-16",
          "runtime" : 99,
          "budget" : 70000000,
          "revenue" : 218613188,
          "poster" : "https://image.tmdb.org/t/p/original/2xUjYwL6Ol7TLJPPKs7sYW5PWLX.jpg",
          "rating" : 7.1
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "239",
        "_score" : 3.8824062,
        "_source" : {
          "idimdb" : "tt1430607",
          "title" : "Arthur Christmas",
          "release" : "2011-11-10",
          "runtime" : 97,
          "budget" : 10000000,
          "revenue" : 0,
          "poster" : "https://image.tmdb.org/t/p/original/sPCrGLdTMn0ud3oAJG37VDxpQfZ.jpg",
          "rating" : 7.1
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "248",
        "_score" : 3.3965616,
        "_source" : {
          "idimdb" : "tt14715170",
          "title" : "Falling for Christmas",
          "release" : "2022-11-10",
          "runtime" : 95,
          "budget" : 0,
          "revenue" : 0,
          "poster" : "https://image.tmdb.org/t/p/original/xs2S7EnrKHVW2DYoGSZfpvOZrF5.jpg",
          "rating" : 5.4
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "264",
        "_score" : 3.3965616,
        "_source" : {
          "idimdb" : "tt15979222",
          "title" : "A Kindhearted Christmas",
          "release" : "2021-11-20",
          "runtime" : 84,
          "budget" : 0,
          "revenue" : 0,
          "poster" : "https://image.tmdb.org/t/p/original/rNvfIcaYjQjczvW6o3qdB7W4vz.jpg",
          "rating" : 7
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "334",
        "_score" : 3.3965616,
        "_source" : {
          "idimdb" : "tt2990140",
          "title" : "The Christmas Chronicles",
          "release" : "2018-11-22",
          "runtime" : 104,
          "budget" : 0,
          "revenue" : 0,
          "poster" : "https://image.tmdb.org/t/p/original/5Il2EMSF2KecrUKZPuen6BZmaCP.jpg",
          "rating" : 7
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "429",
        "_score" : 3.3965616,
        "_source" : {
          "idimdb" : "tt7422638",
          "title" : "48 Christmas Wishes",
          "release" : "2017-12-01",
          "runtime" : 84,
          "budget" : 0,
          "revenue" : 0,
          "poster" : "https://image.tmdb.org/t/p/original/mrcA62O9j8y4gsSpftMKVcvrzCI.jpg",
          "rating" : 4
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "452",
        "_score" : 3.3965616,
        "_source" : {
          "idimdb" : "tt8861786",
          "title" : "Puppy Star Christmas",
          "release" : "2018-11-20",
          "runtime" : 90,
          "budget" : 0,
          "revenue" : 0,
          "poster" : "https://image.tmdb.org/t/p/original/ztmVR4XlmAWtHFjDBWh2VyYcyuC.jpg",
          "rating" : 4
        }
      }
    ]
  }
}

```

#### 4. Movies which title contains christmas and prince

*Request*

http://localhost:9200/ariane-movies/_search?q=title:(christmas%20AND%20prince)&pretty


*Result*
```json
{
  "took" : 4,
  "timed_out" : false,
  "_shards" : {
    "total" : 1,
    "successful" : 1,
    "skipped" : 0,
    "failed" : 0
  },
  "hits" : {
    "total" : {
      "value" : 3,
      "relation" : "eq"
    },
    "max_score" : 8.287371,
    "hits" : [
      {
        "_index" : "ariane-movies",
        "_id" : "433",
        "_score" : 8.287371,
        "_source" : {
          "idimdb" : "tt7608418",
          "title" : "A Christmas Prince",
          "release" : "2017-11-17",
          "runtime" : 92,
          "budget" : 0,
          "revenue" : 0,
          "poster" : "https://image.tmdb.org/t/p/original/x0IGQsMzVbsF7noj5cCfEk1GU7s.jpg",
          "rating" : 5.8
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "174",
        "_score" : 6.0253363,
        "_source" : {
          "idimdb" : "tt10006006",
          "title" : "A Christmas Prince: The Royal Baby",
          "release" : "2019-12-05",
          "runtime" : 84,
          "budget" : 0,
          "revenue" : 0,
          "poster" : "https://image.tmdb.org/t/p/original/4RErLw0APt8qQiee0d8VCKasWwl.jpg",
          "rating" : 5.4
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "449",
        "_score" : 6.0253363,
        "_source" : {
          "idimdb" : "tt8709036",
          "title" : "A Christmas Prince: The Royal Wedding",
          "release" : "2018-11-30",
          "runtime" : 92,
          "budget" : 0,
          "revenue" : 0,
          "poster" : "https://image.tmdb.org/t/p/original/2bLQTbFWrsunSVQsvOWZAAGACbf.jpg",
          "rating" : 5.3
        }
      }
    ]
  }
```

#### 5. Movies which budget greater than 250000000

*Request*

http://localhost:9200/ariane-movies/_search?q=budget:%3E250000000&pretty

http://localhost:9200/ariane-movies/_search?q=runtime:(%3E=65%20AND%20%3C=75)&pretty

*Result*
```json
{
  "took" : 6,
  "timed_out" : false,
  "_shards" : {
    "total" : 1,
    "successful" : 1,
    "skipped" : 0,
    "failed" : 0
  },
  "hits" : {
    "total" : {
      "value" : 4,
      "relation" : "eq"
    },
    "max_score" : 1.0,
    "hits" : [
      {
        "_index" : "ariane-movies",
        "_id" : "131",
        "_score" : 1.0,
        "_source" : {
          "idimdb" : "tt0398286",
          "title" : "Tangled",
          "release" : "2010-11-24",
          "runtime" : 100,
          "budget" : 260000000,
          "revenue" : 592461732,
          "poster" : "https://image.tmdb.org/t/p/original/ym7Kst6a4uodryxqbGOxmewF235.jpg",
          "rating" : 7.7
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "172",
        "_score" : 1.0,
        "_source" : {
          "idimdb" : "tt0974015",
          "title" : "Justice League",
          "release" : "2017-11-15",
          "runtime" : 120,
          "budget" : 300000000,
          "revenue" : 657926987,
          "poster" : "https://image.tmdb.org/t/p/original/eifGNCSDuxJeS1loAXil5bIGgvC.jpg",
          "rating" : 6.1
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "268",
        "_score" : 1.0,
        "_source" : {
          "idimdb" : "tt1630029",
          "title" : "Avatar: The Way of Water",
          "release" : "2022-12-14",
          "runtime" : 192,
          "budget" : 460000000,
          "revenue" : 1397417914,
          "poster" : "https://image.tmdb.org/t/p/original/t6HIqrRAclMCA60NsSmeqe9RmNV.jpg",
          "rating" : 7.9
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "364",
        "_score" : 1.0,
        "_source" : {
          "idimdb" : "tt4154756",
          "title" : "Avengers: Infinity War",
          "release" : "2018-04-25",
          "runtime" : 149,
          "budget" : 300000000,
          "revenue" : 2046239637,
          "poster" : "https://image.tmdb.org/t/p/original/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
          "rating" : 8.4
        }
      }
    ]
  }
}
```

#### 6. Movies which runtime is between 65 and 75 (2 versions)

*Request*

http://localhost:9200/ariane-movies/_search?q=runtime:[65%20TO%2075]&pretty

http://localhost:9200/ariane-movies/_search?q=runtime:(%3E=65%20AND%20%3C=75)&pretty

*Result*
```json
{
  "took" : 3,
  "timed_out" : false,
  "_shards" : {
    "total" : 1,
    "successful" : 1,
    "skipped" : 0,
    "failed" : 0
  },
  "hits" : {
    "total" : {
      "value" : 27,
      "relation" : "eq"
    },
    "max_score" : 1.0,
    "hits" : [
      {
        "_index" : "ariane-movies",
        "_id" : "4",
        "_score" : 1.0,
        "_source" : {
          "idimdb" : "tt0034492",
          "title" : "Bambi",
          "release" : "1942-08-14",
          "runtime" : 70,
          "budget" : 858000,
          "revenue" : 267447150,
          "poster" : "https://image.tmdb.org/t/p/original/wV9e2y4myJ4KMFsyFfWYcUOawyK.jpg",
          "rating" : 7.3
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "5",
        "_score" : 1.0,
        "_source" : {
          "idimdb" : "tt0042332",
          "title" : "Cinderella",
          "release" : "1950-02-22",
          "runtime" : 74,
          "budget" : 2900000,
          "revenue" : 263591415,
          "poster" : "https://image.tmdb.org/t/p/original/4nssBcQUBadCTBjrAkX46mVEKts.jpg",
          "rating" : 7.3
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "8",
        "_score" : 1.0,
        "_source" : {
          "idimdb" : "tt0053285",
          "title" : "Sleeping Beauty",
          "release" : "1959-02-17",
          "runtime" : 75,
          "budget" : 6000000,
          "revenue" : 51600000,
          "poster" : "https://image.tmdb.org/t/p/original/j2mTyUukcLwDIeQohyZUVKfqdlB.jpg",
          "rating" : 7.2
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "13",
        "_score" : 1.0,
        "_source" : {
          "idimdb" : "tt0062687",
          "title" : "Astérix et Cléopâtre",
          "release" : "1968-12-16",
          "runtime" : 72,
          "budget" : 0,
          "revenue" : 0,
          "poster" : "https://image.tmdb.org/t/p/original/gNpKAmWFsCiWKKx39Ap8pF7EWQg.jpg",
          "rating" : 7.2
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "26",
        "_score" : 1.0,
        "_source" : {
          "idimdb" : "tt0095489",
          "title" : "The Land Before Time",
          "release" : "1988-11-18",
          "runtime" : 69,
          "budget" : 12500000,
          "revenue" : 84460846,
          "poster" : "https://image.tmdb.org/t/p/original/wSC2wxFj3ZgrIHlIaePeuHN4igo.jpg",
          "rating" : 7.4
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "32",
        "_score" : 1.0,
        "_source" : {
          "idimdb" : "tt0099472",
          "title" : "DuckTales: The Movie - Treasure of the Lost Lamp",
          "release" : "1990-08-03",
          "runtime" : 74,
          "budget" : 0,
          "revenue" : 18115724,
          "poster" : "https://image.tmdb.org/t/p/original/qGbB0PtHq63FACIbVORvWvUKtbL.jpg",
          "rating" : 6.9
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "80",
        "_score" : 1.0,
        "_source" : {
          "idimdb" : "tt0181627",
          "title" : "Kirikou et la sorcière",
          "release" : "1998-12-09",
          "runtime" : 70,
          "budget" : 4495000,
          "revenue" : 0,
          "poster" : "https://image.tmdb.org/t/p/original/9RNrozaagFmpm6m0CP7q4XDcIXj.jpg",
          "rating" : 7.5
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "87",
        "_score" : 1.0,
        "_source" : {
          "idimdb" : "tt0249677",
          "title" : "Lady and the Tramp II: Scamp's Adventure",
          "release" : "2001-02-18",
          "runtime" : 69,
          "budget" : 0,
          "revenue" : 0,
          "poster" : "https://image.tmdb.org/t/p/original/nS3nhUZUSY8dWEsRmKILfiOC3F0.jpg",
          "rating" : 5.9
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "93",
        "_score" : 1.0,
        "_source" : {
          "idimdb" : "tt0283426",
          "title" : "The Jungle Book 2",
          "release" : "2003-02-07",
          "runtime" : 72,
          "budget" : 20000000,
          "revenue" : 135680000,
          "poster" : "https://image.tmdb.org/t/p/original/DhuskQc9lSjPiYKr9hy0AZ7uiC.jpg",
          "rating" : 5.4
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "105",
        "_score" : 1.0,
        "_source" : {
          "idimdb" : "tt0324941",
          "title" : "101 Dalmatians II: Patch's London Adventure",
          "release" : "2003-03-02",
          "runtime" : 74,
          "budget" : 0,
          "revenue" : 0,
          "poster" : "https://image.tmdb.org/t/p/original/mcl56J7tDPjzEesgpX4UPgAdbvf.jpg",
          "rating" : 5.8
        }
      }
    ]
  }
}
```

#### 7. Movies which title contains prince, limited to 2 results

*Request*

http://localhost:9200/ariane-movies/_search?q=title:prince&size=2&pretty

*Result*
```json
{
  "took" : 2,
  "timed_out" : false,
  "_shards" : {
    "total" : 1,
    "successful" : 1,
    "skipped" : 0,
    "failed" : 0
  },
  "hits" : {
    "total" : {
      "value" : 4,
      "relation" : "eq"
    },
    "max_score" : 4.890809,
    "hits" : [
      {
        "_index" : "ariane-movies",
        "_id" : "433",
        "_score" : 4.890809,
        "_source" : {
          "idimdb" : "tt7608418",
          "title" : "A Christmas Prince",
          "release" : "2017-11-17",
          "runtime" : 92,
          "budget" : 0,
          "revenue" : 0,
          "poster" : "https://image.tmdb.org/t/p/original/x0IGQsMzVbsF7noj5cCfEk1GU7s.jpg",
          "rating" : 5.8
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "68",
        "_score" : 4.346844,
        "_source" : {
          "idimdb" : "tt0120794",
          "title" : "The Prince of Egypt",
          "release" : "1998-12-16",
          "runtime" : 99,
          "budget" : 70000000,
          "revenue" : 218613188,
          "poster" : "https://image.tmdb.org/t/p/original/2xUjYwL6Ol7TLJPPKs7sYW5PWLX.jpg",
          "rating" : 7.1
        }
      }
    ]
  }
}
```

#### 8. Movies which title contains star but not wars

*Request*

http://localhost:9200/ariane-movies/_search?q=title:(star%20NOT%20wars)&pretty

*Result*
```json
{
  "took" : 9,
  "timed_out" : false,
  "_shards" : {
    "total" : 1,
    "successful" : 1,
    "skipped" : 0,
    "failed" : 0
  },
  "hits" : {
    "total" : {
      "value" : 4,
      "relation" : "eq"
    },
    "max_score" : 4.5667095,
    "hits" : [
      {
        "_index" : "ariane-movies",
        "_id" : "372",
        "_score" : 4.5667095,
        "_source" : {
          "idimdb" : "tt4587656",
          "title" : "The Star",
          "release" : "2017-11-15",
          "runtime" : 86,
          "budget" : 10000000,
          "revenue" : 0,
          "poster" : "https://image.tmdb.org/t/p/original/tEbDvivUfsCupngKIfMJJ725eAD.jpg",
          "rating" : 6.3
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "452",
        "_score" : 3.9952312,
        "_source" : {
          "idimdb" : "tt8861786",
          "title" : "Puppy Star Christmas",
          "release" : "2018-11-20",
          "runtime" : 90,
          "budget" : 0,
          "revenue" : 0,
          "poster" : "https://image.tmdb.org/t/p/original/ztmVR4XlmAWtHFjDBWh2VyYcyuC.jpg",
          "rating" : 4
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "256",
        "_score" : 3.5508742,
        "_source" : {
          "idimdb" : "tt1517451",
          "title" : "A Star Is Born",
          "release" : "2018-10-03",
          "runtime" : 136,
          "budget" : 36000000,
          "revenue" : 433888866,
          "poster" : "https://image.tmdb.org/t/p/original/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg",
          "rating" : 7.6
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "249",
        "_score" : 2.6624928,
        "_source" : {
          "idimdb" : "tt14731142",
          "title" : "The Princess Switch 3: Romancing the Star",
          "release" : "2021-11-18",
          "runtime" : 106,
          "budget" : 0,
          "revenue" : 0,
          "poster" : "https://image.tmdb.org/t/p/original/bknLygnlfMjiLahnAncvKFXXRMs.jpg",
          "rating" : 5.5
        }
      }
    ]
  }
}
```

#### 9. Movies which title is star wars

*Request*

http://localhost:9200/ariane-movies/_search?q=title:(star%20AND%20wars)&pretty

*Result*
```json
{
  "took" : 3,
  "timed_out" : false,
  "_shards" : {
    "total" : 1,
    "successful" : 1,
    "skipped" : 0,
    "failed" : 0
  },
  "hits" : {
    "total" : {
      "value" : 6,
      "relation" : "eq"
    },
    "max_score" : 9.712826,
    "hits" : [
      {
        "_index" : "ariane-movies",
        "_id" : "20",
        "_score" : 9.712826,
        "_source" : {
          "idimdb" : "tt0076759",
          "title" : "Star Wars",
          "release" : "1977-05-25",
          "runtime" : 121,
          "budget" : 11000000,
          "revenue" : 775398007,
          "poster" : "https://image.tmdb.org/t/p/original/6FfCtAuVAW8XJjZ7eWeLibRLWTw.jpg",
          "rating" : 8.6
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "321",
        "_score" : 6.1780105,
        "_source" : {
          "idimdb" : "tt2527338",
          "title" : "Star Wars: The Rise of Skywalker",
          "release" : "2019-12-18",
          "runtime" : 142,
          "budget" : 250000000,
          "revenue" : 1074144248,
          "poster" : "https://image.tmdb.org/t/p/original/db32LaOibwEliAmSL2jjDF6oDdj.jpg",
          "rating" : 6.5
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "356",
        "_score" : 6.1780105,
        "_source" : {
          "idimdb" : "tt3748528",
          "title" : "Rogue One: A Star Wars Story",
          "release" : "2016-12-14",
          "runtime" : 133,
          "budget" : 200000000,
          "revenue" : 1056057273,
          "poster" : "https://image.tmdb.org/t/p/original/i0yw1mFbB7sNGHCs7EXZPzFkdA1.jpg",
          "rating" : 7.8
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "70",
        "_score" : 5.662792,
        "_source" : {
          "idimdb" : "tt0120915",
          "title" : "Star Wars: Episode I - The Phantom Menace",
          "release" : "1999-05-19",
          "runtime" : 136,
          "budget" : 115000000,
          "revenue" : 924317558,
          "poster" : "https://image.tmdb.org/t/p/original/6wkfovpn7Eq8dYNKaG5PY3q2oq6.jpg",
          "rating" : 6.5
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "72",
        "_score" : 5.2268925,
        "_source" : {
          "idimdb" : "tt0121765",
          "title" : "Star Wars: Episode II - Attack of the Clones",
          "release" : "2002-05-15",
          "runtime" : 142,
          "budget" : 120000000,
          "revenue" : 649398328,
          "poster" : "https://image.tmdb.org/t/p/original/oZNPzxqM2s5DyVWab09NTQScDQt.jpg",
          "rating" : 6.5
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "73",
        "_score" : 5.2268925,
        "_source" : {
          "idimdb" : "tt0121766",
          "title" : "Star Wars: Episode III - Revenge of the Sith",
          "release" : "2005-05-17",
          "runtime" : 140,
          "budget" : 113000000,
          "revenue" : 850000000,
          "poster" : "https://image.tmdb.org/t/p/original/xfSAoBEm9MNBjmlNcDYLvLSMlnq.jpg",
          "rating" : 7.5
        }
      }
    ]
  }
}
```

#### 10. One 90-minute movie

*Request*

http://localhost:9200/ariane-movies/_search?q=runtime:90&size=1&pretty

*Result*
```json
{
  "took" : 2,
  "timed_out" : false,
  "_shards" : {
    "total" : 1,
    "successful" : 1,
    "skipped" : 0,
    "failed" : 0
  },
  "hits" : {
    "total" : {
      "value" : 15,
      "relation" : "eq"
    },
    "max_score" : 1.0,
    "hits" : [
      {
        "_index" : "ariane-movies",
        "_id" : "34",
        "_score" : 1.0,
        "_source" : {
          "idimdb" : "tt0103639",
          "title" : "Aladdin",
          "release" : "1992-11-25",
          "runtime" : 90,
          "budget" : 28000000,
          "revenue" : 504050219,
          "poster" : "https://image.tmdb.org/t/p/original/oakAd8syy7jNQ4ZoaAGCQkTqcOV.jpg",
          "rating" : 8
        }
      }
    ]
  }
}
```

#### 11. 95-minute movies which title does not contain 2 and a budget greater than or equal to $150000000

*Request*

http://localhost:9200/ariane-movies/_search?q=runtime:95%20AND%20title:(NOT%202)%20AND%20budget:%3E=150000000&pretty

*Result*
```json
{
  "took" : 6,
  "timed_out" : false,
  "_shards" : {
    "total" : 1,
    "successful" : 1,
    "skipped" : 0,
    "failed" : 0
  },
  "hits" : {
    "total" : {
      "value" : 3,
      "relation" : "eq"
    },
    "max_score" : 2.0,
    "hits" : [
      {
        "_index" : "ariane-movies",
        "_id" : "129",
        "_score" : 2.0,
        "_source" : {
          "idimdb" : "tt0396555",
          "title" : "Meet the Robinsons",
          "release" : "2007-03-23",
          "runtime" : 95,
          "budget" : 150000000,
          "revenue" : 169332978,
          "poster" : "https://image.tmdb.org/t/p/original/swsjj0jZtsx53Yp9zBORPwsmGWj.jpg",
          "rating" : 6.8
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "224",
        "_score" : 2.0,
        "_source" : {
          "idimdb" : "tt12801262",
          "title" : "Luca",
          "release" : "2021-06-17",
          "runtime" : 95,
          "budget" : 200000000,
          "revenue" : 49010641,
          "poster" : "https://image.tmdb.org/t/p/original/jTswp6KyDYKtvC52GbHagrZbGvD.jpg",
          "rating" : 7.5
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "296",
        "_score" : 2.0,
        "_source" : {
          "idimdb" : "tt2096673",
          "title" : "Inside Out",
          "release" : "2015-06-09",
          "runtime" : 95,
          "budget" : 175000000,
          "revenue" : 857611174,
          "poster" : "https://image.tmdb.org/t/p/original/lRHE0vzf3oYJrhbsHXjIkF4Tl5A.jpg",
          "rating" : 8.1
        }
      }
    ]
  }
}
```

#### 12. Shortest movie

*Request*

http://localhost:9200/ariane-movies/_search?q=*&sort=runtime:asc&size=1&pretty

*Result*
```json
{
  "took" : 10,
  "timed_out" : false,
  "_shards" : {
    "total" : 1,
    "successful" : 1,
    "skipped" : 0,
    "failed" : 0
  },
  "hits" : {
    "total" : {
      "value" : 459,
      "relation" : "eq"
    },
    "max_score" : null,
    "hits" : [
      {
        "_index" : "ariane-movies",
        "_id" : "312",
        "_score" : null,
        "_source" : {
          "idimdb" : "tt23623604",
          "title" : "L.O.L. Surprise! Winter Fashion Show",
          "release" : "2022-10-24",
          "runtime" : 0,
          "budget" : 0,
          "revenue" : 0,
          "poster" : "https://image.tmdb.org/t/p/original/ik65OsEXbik1I0Di7SX9Sqv04e9.jpg",
          "rating" : -1
        },
        "sort" : [
          0
        ]
      }
    ]
  }
}
```

### 4.2 DSL

#### 1. Longer than 170 minutes movies

*Request*
```bash
curl -X GET "http://localhost:9200/ariane-movies/_search?pretty" -H 'Content-Type: application/json' -d'
{
  "query": {
    "range": {
      "runtime": { "gt": 170 }
    }
  }
}
'
{
  "took" : 2,
  "timed_out" : false,
  "_shards" : {
    "total" : 1,
    "successful" : 1,
    "skipped" : 0,
    "failed" : 0
  },
  "hits" : {
    "total" : {
      "value" : 3,
      "relation" : "eq"
    },
    "max_score" : 1.0,
    "hits" : [
      {
        "_index" : "ariane-movies",
        "_id" : "15",
        "_score" : 1.0,
        "_source" : {
          "idimdb" : "tt0068646",
          "title" : "The Godfather",
          "release" : "1972-03-14",
          "runtime" : 175,
          "budget" : 6000000,
          "revenue" : 245066411,
          "poster" : "https://image.tmdb.org/t/p/original/3bhkrj58Vtu7enYsRolD1fZdja1.jpg",
          "rating" : 9.2
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "65",
        "_score" : 1.0,
        "_source" : {
          "idimdb" : "tt0120689",
          "title" : "The Green Mile",
          "release" : "1999-12-10",
          "runtime" : 189,
          "budget" : 60000000,
          "revenue" : 286801374,
          "poster" : "https://image.tmdb.org/t/p/original/velWPhVMQeQKcxggNEU8YmIo52R.jpg",
          "rating" : 8.6
        }
      },
      {
        "_index" : "ariane-movies",
        "_id" : "268",
        "_score" : 1.0,
        "_source" : {
          "idimdb" : "tt1630029",
          "title" : "Avatar: The Way of Water",
          "release" : "2022-12-14",
          "runtime" : 192,
          "budget" : 460000000,
          "revenue" : 1397417914,
          "poster" : "https://image.tmdb.org/t/p/original/t6HIqrRAclMCA60NsSmeqe9RmNV.jpg",
          "rating" : 7.9
        }
      }
    ]
  }
}
```

#### 2. Movies which title contains star

*Request*
```bash
curl -X GET "http://localhost:9200/ariane-movies/_search?pretty" -H 'Content-Type: application/json' -d'
{
  "query": {
    "match": { "title": "star" }
  }
}
'
```

#### 3. Movies which title is Aladdin

*Request*
```bash
curl -X GET "http://localhost:9200/ariane-movies/_search?pretty" -H 'Content-Type: application/json' -d'
{
  "query": {
    "term": { "title.keyword": "Aladdin" }
  }
}
'
```

#### 4. Movies which title contains star or wars

*Request*
```bash
curl -X GET "http://localhost:9200/ariane-movies/_search?pretty" -H 'Content-Type: application/json' -d'
{
  "query": {
    "bool": {
      "should": [
        { "match": { "title": "star" }},
        { "match": { "title": "wars" }}
      ]
    }
  }
}
'
```

#### 5. Movies which title contains star and not wars

*Request*
```bash
curl -X GET "http://localhost:9200/ariane-movies/_search?pretty" -H 'Content-Type: application/json' -d'
{
  "query": {
    "bool": {
      "must": [
        { "match": { "title": "star" }}
      ],
      "must_not": [
        { "match": { "title": "wars" }}
      ]
    }
  }
}
'
```

#### 6. Movies which title contains star and wars (both of them)

*Request*
```bash
curl -X GET "http://localhost:9200/ariane-movies/_search?pretty" -H 'Content-Type: application/json' -d'
{
  "query": {
    "bool": {
      "must": [
        { "match": { "title": "star" }},
        { "match": { "title": "wars" }}
      ]
    }
  }
}
'
```

#### 7. 136 minute movies which title contains star

*Request*
```bash
curl -X GET "http://localhost:9200/ariane-movies/_search?pretty" -H 'Content-Type: application/json' -d'
{
  "query": {
    "bool": {
      "must": [
        { "match": { "title": "star" }},
        { "term": { "runtime": 136 }}
      ]
    }
  }
}
'
```

#### 8. 136 or 60 minute movies

*Request*
```bash
curl -X GET "http://localhost:9200/ariane-movies/_search?pretty" -H 'Content-Type: application/json' -d'
{
  "query": {
    "bool": {
      "should": [
        { "term": { "runtime": 136 }},
        { "term": { "runtime": 60 }}
      ]
    }
  }
}
'
```

#### 9. Average runtime

*Request*
```bash
curl -X GET "http://localhost:9200/ariane-movies/_search?pretty" -H 'Content-Type: application/json' -d'
{
  "size": 0,
  "aggs": {
    "average_runtime": {
      "avg": { "field": "runtime" }
    }
  }
}
'
```

#### 10. Budget of the most expensive movie

*Request*
```bash
curl -X GET "http://localhost:9200/ariane-movies/_search?pretty" -H 'Content-Type: application/json' -d'
{
  "size": 1,
  "sort": [
    { "budget": { "order": "desc" } }
  ],
  "_source": ["title", "budget"]
}
'
```

#### 11. Movies sorted per revenue

*Request*
```bash
curl -X GET "http://localhost:9200/ariane-movies/_search?pretty" -H 'Content-Type: application/json' -d'
{
  "sort": [
    { "revenue": { "order": "desc" } }
  ],
  "query": {
    "match_all": {}
  }
}
'
```

#### 12. Distinct runtimes

*Request*
```bash
curl -X GET "http://localhost:9200/ariane-movies/_search?pretty" -H 'Content-Type: application/json' -d'
{
  "size": 0,
  "aggs": {
    "distinct_runtimes": {
      "terms": { "field": "runtime" }
    }
  }
}
'
```


### 4.3 More queries

#### 1. Movie with a runtime equal to 90 or 120 and a budget different than 28000000 which title contains Pussor Panda but not Romeo (2 versions in URL and at least one with + or -)

*Request*

*Result*

#### 2. Average runtime of the movie with a budget greater than 1000000.

*Request*

*Result*