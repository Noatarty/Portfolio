# CR TP2 MapReduce

## 4 Activities

### 4.1 Number of companies per city

**Map**

```javascript
var map=function() {
    if (this.city && this.city !== null){
        emit(this.city, 1);
    }
}
```

**Reduce**

```javascript
var reduce=function(city, nb) {
    return Array.sum(nb);
}
```

**Execution**

```javascript
db.company.mapReduce(map, reduce, {out: "nbEntrepriseParVille"});
db.nbEntrepriseParVille.find();
```

**Résultat (extrait)**

```javascript
[
  { _id: 'Albany', value: 1 },
  { _id: 'Manhattan Beach', value: 1 },
  { _id: 'Chiyoda-ku', value: 1 },
  { _id: 'Torrance', value: 4 },
  { _id: 'Copenhagen', value: 1 },
  { _id: 'West Los Angeles', value: 1 },
  { _id: 'Santa Monica', value: 6 },
  { _id: 'Alameda', value: 1 },
  { _id: 'Portsmouth', value: 1 },
  { _id: 'Shinagawa-ku', value: 1 },
  { _id: 'Wimbledon, London', value: 1 },
  { _id: 'Oxford', value: 1 },
  { _id: "St. John's", value: 1 },
  { _id: 'Valencia', value: 1 },
  { _id: 'Edinburgh', value: 1 },
  { _id: 'Seoul', value: 1 },
  { _id: 'Manchester', value: 3 },
  { _id: 'Chapel Hill', value: 1 },
  { _id: 'Shinjuku, Tokyo', value: 1 },
  { _id: 'Meguro', value: 1 }
]
```

### 4.2 Names of the companies

**Map**

```javascript
var map = function() {
    emit(this.id, this.name);
}
```

**Reduce**

```javascript
var reduce = function(id, names) {
    return names;
}
```

**Execution**

```javascript
db.company.mapReduce(map, reduce, {out: "nomsEntreprises"});
db.nomsEntreprises.find();
```

**Résultat (extrait)**

```javascript
[
  { _id: '8585', value: 'AMI Co., Ltd.' },
  { _id: '4211', value: 'Vanillaware Ltd.' },
  { _id: '5188', value: 'MaxFive' },
  { _id: '10321', value: 'Square Visual Works' },
  { _id: '245', value: 'Ubisoft Paris Studios' },
  { _id: '111', value: 'Crave Entertainment' },
  { _id: '1515', value: 'Overworks' },
  { _id: '742', value: 'Delphine Software International' },
  { _id: '2267', value: 'Climax Studios' },
  { _id: '3377', value: 'Soft-World' },
  { _id: '3954', value: 'Sumo Digital Ltd.' },
  { _id: '4415', value: 'Unexpected Development' },
  { _id: '491', value: 'Codemasters' },
  { _id: '9451', value: 'Nintendo SPD Group No.4' },
  { _id: '8917', value: 'Pencil Test Studios' },
  { _id: '739', value: 'Nokia' },
  { _id: '3409', value: 'Beam Software' },
  { _id: '10362', value: 'Grove Street Games' },
  { _id: '22805', value: 'Gonzo K.K.' },
  { _id: '8310', value: 'SCE XDev Studio' }
]
```

### 4.3 Companies where country is France

**Map**

```javascript
var map = function() {
    if (this.country === "France") {
        emit(this.id, this.name);
    }
}
```

**Reduce**

```javascript
var reduce = function(id, names) {
    return names;
}
```

**Execution**

```javascript
    db.company.mapReduce(map, reduce, {out: "entrepriseEnFrance"});
    db.entrepriseEnFrance.find();
```

**Résultat (extrait)**

```javascript
[
  { _id: '720', value: 'Focus Entertainment' },
  { _id: '3846', value: 'Adeline Software International' },
  { _id: '5834', value: 'Ubisoft S.A.' },
  { _id: '7701', value: 'DotEmu' },
  { _id: '9341', value: 'VD-Dev' },
  { _id: '3553', value: 'Eden Games S.A.S.' },
  { _id: '82', value: 'Ubisoft Entertainment' },
  { _id: '742', value: 'Delphine Software International' },
  { _id: '1937', value: 'Foxy Soft' },
  { _id: '245', value: 'Ubisoft Paris Studios' },
  { _id: '571', value: 'Ubisoft Annecy Studios' },
  { _id: '165', value: 'Titus Interactive, S.A.' },
  { _id: '1179', value: 'Loriciel' },
  { _id: '800', value: 'Microïds' },
  { _id: '217', value: 'Cryo Interactive Entertainment' },
  { _id: '246', value: 'Kalisto Entertainment SA' },
  { _id: '548', value: 'Atari SA' },
  { _id: '3911', value: 'Ubisoft Montpellier Studios' },
  { _id: '894', value: 'Amazing Studio' },
  { _id: '743', value: 'Gameloft S.A.' }
]
```

### 4.4 Most expensive platform per company

**Map**

```javascript
var map = function() {
    if (this.price && this.company !== null) {
        emit(this.company, {price: parseFloat(this.price), name: this.name});
    }
}
```

**Reduce**

```javascript
var reduce = function(company, platforms) {
    var priMax = 0;
    var plusChereConsole = "";
    
    for (var i = 0; i < platforms.length; i++) {
        if (platforms[i].price > priMax) {
            priMax = platforms[i].price;
            plusChereConsole = platforms[i].name;
        }
    }
    
    return {price: priMax, name: plusChereConsole};
}
```

**Execution**

```javascript
db.platform.mapReduce(map, reduce, {out: "plusChereConsoleParEntreprise"});
db.plusChereConsoleParEntreprise.find();
```

**Résultat (extrait)**

```javascript
[
  { _id: '938', value: { price: 249, name: 'ZX Spectrum' } },
  { _id: '62', value: { price: 399, name: 'Saturn' } },
  { _id: '48', value: { price: 700, name: 'CD-i' } },
  { _id: '4956', value: { price: 1499, name: 'Acorn Archimedes' } },
  { _id: '3223', value: { price: 500, name: 'PlayStation 5' } },
  { _id: '2000', value: { price: 595, name: 'Commodore 64' } },
  { _id: '3924', value: { price: 800, name: 'Amstrad CPC' } },
  { _id: '1715', value: { price: 70, name: 'Game.Com' } },
  { _id: '7173', value: { price: 280, name: 'Zeebo' } },
  { _id: '548', value: { price: 190, name: 'Atari Lynx' } },
  { _id: '995', value: { price: 599, name: 'PlayStation 3' } },
  { _id: '340', value: { price: 499.99, name: 'Xbox Series X|S' } },
  { _id: '6509', value: { price: 3000, name: 'Sharp X68000' } },
  { _id: '2025', value: { price: 525, name: 'TI-99/4A' } },
  { _id: '460', value: { price: 299, name: 'Intellivision' } },
  { _id: '90', value: { price: 299, name: 'Nintendo Switch' } },
  { _id: '763', value: { price: 299, name: 'Zodiac' } },
  { _id: '1602', value: { price: 600, name: 'TRS-80' } },
  { _id: '5815', value: { price: 2495, name: 'Mac' } },
  { _id: '1483', value: { price: 1285, name: 'Amiga' } }
]
```

### 4.5 Oldest company

**Map**

```javascript
var map = function() {
    if (this.creation && this.creation !== null) {
        emit("plusAncienne", {creation: this.creation, name: this.name, company: this});
    }
}
```

**Reduce**

```javascript
var reduce = function(key, companies) {
    var plusAncienne = companies[0];
    
    for (var i = 1; i < companies.length; i++) {
        if (companies[i].creation < plusAncienne.creation) {
            plusAncienne = companies[i];
        }
    }
    
    return plusAncienne;
}
```

**Execution**

```javascript
db.company.mapReduce(map, reduce, {out: "PlusVielleCompagnie"});
db.PlusVielleCompagnie.find();
```

**Résultat (extrait)**

```javascript
[
  {
    _id: 'plusAncienne',
    value: {
      creation: '1883-01-01',
      name: 'Parker Brothers',
      company: {
        _id: ObjectId('68d654c29f3c792b58854ad2'),
        id: '801',
        guid: '3010-801',
        name: 'Parker Brothers',
        abbreviation: null,
        description: 'Primarily known for publishing popular family board games, Parker also released quite a few computer games between the early 1980s and early 1990s. ',
        creation: '1883-01-01',
        city: 'Salem',
        state: 'Massachusetts',
        country: 'United States',
        image: 'https://www.giantbomb.com/a/uploads/scale_medium/0/3161/298811-parkerbrothers.gif'
      }
    }
  }
]
```
