# 1.1.2. Exercices

## i. Calculer (101011)₂ − (11101)₂

Alignez les nombres et effectuez la soustraction binaire :

```c
   101011
-   11101
-----------
```

Commencez par les chiffres les plus à droite :

```c
   101011
-   11101
-----------
        0   (1 - 1)
```

Passez à la colonne suivante :

```c
   101011
-   11101
-----------
       10   (1 - 0)
```

Colonnes suivantes :

```c
   101011
-   11101
-----------
      010   (0 + (10)₂ - 1)
```

Continuez avec les colonnes restantes :

```c
   101011
-   11101
-----------
    11010   (1 + (10)₂ - (1 + 1))
```

Donc, (101011)₂ − (11101)₂ = (11010)₂.

### ii. Calculer (100000)₂ − (10101)₂

Alignez les nombres et effectuez la soustraction binaire :

```c
   100000
-   10101
-----------
```

Commencez par les chiffres les plus à droite :

```c
   100000
-   10101
-----------
        1   (0 - 1 avec une retenue de 1)
```

Passez à la colonne suivante :

```c
   100000
-   10101
-----------
      110   (1 + (10)₂ - 1)
```

Continuez avec les colonnes restantes :

```c
   100000
-   10101
-----------
    11111   (1 + (10)₂ - (1 + 1))
```

Donc, (100000)₂ − (10101)₂ = (11111)₂.

### iii. Calculer (101101)₂ − (10110)₂

Alignez les nombres et effectuez la soustraction binaire :

```c
   101101
-   10110
-----------
```

Start with the rightmost digits:

```c
   101101
-   10110
-----------
        1   (1 - 0)
```

Continue with the remaining columns:

```c
   101101
-   10110
-----------
      011   (1 + (10)₂ - 0)
```

Continuez avec les colonnes restantes :

```c
   101101
-   10110
-----------
    01011   (1 + (10)₂ - (1 + 1))
```

So, (101101)₂ − (10110)₂ = (01011)₂.

## 1.2. Soustractions en tant qu’additions avec l’opposé

### a. i. Calculer (101011)₂ − (11101)₂ sur 6 bits

1. Mettez les deux nombres sur 6 bits : (101011)₂ et (011101)₂.

```c
   101011
+  100011   (l'opposé de 011101')
-----------
```

## 2. Additionnez le premier nombre avec l'opposé' du second

```c
   101011
+  100011   (l'opposé' de 011101)
-----------
  101110   (ignorer le bit de débordement)
```

## 3. Tronquez la somme à 6 bits et comparez avec le résultat obtenu précédemment

### b. i. Calculer (100000)₂ − (10101)₂ sur 6 bits

1. Mettez les deux nombres sur 6 bits :

```c
   100000
+  110011   (l'opposé' de 00101)
-----------
```

## 2. Additionnez le premier nombre avec l'opposé' du second bis

```c
   100000
+  110011   (l'opposé' de 00101)
-----------
  010011   (ignorer le bit de débordement)
```

## 3. Tronquez la somme à 6 bits et comparez avec le résultat obtenu précédemment bis

### c. i. Calculez −5 − 2 sur 4 bits avec cette méthode

1. Écrivez les deux nombres à soustraire sur 4 bits :

```c
   -0101
+  -0010   (l'opposé' de 0010')
-----------
```

## 2. Additionnez le premier nombre avec l'opposé' du second ter

```c
   -0101
+  -0010   (l'opposé de 0010')
-----------
  -0111   (ignorer le bit de débordement)
```

## 3. Tronquez la somme à 4 bits et vérifiez le résultat ter

## 2. Opérateurs logiques

### i. Calculer NON(0101) ET 0110

```c
NON(0101) = 1010
1010 ET 0110 = 0010
```

### ii. Calculer 1011 OUX (1010 ET 0111)

```c
1010 ET 0111 = 0010
1011 OUX 0010 = 1001
```

### iii. Calculer NON(0101) OU NON(1101)

```c
NON(0101) = 1010
NON(1101) = 0010
1010 OU 0010 = 1010
```

## 3. Décalages et rotations

### i. Calculer la rotation à droite de (10011101)₂

```c
Rotation à droite de 1 bit :
11001110
```

### ii. Calculer la rotation à gauche de (10011101)₂

```c
Rotation à gauche de 1 bit :
00111011
```

### iii. Écrire 50 en base 2 sur 1 octet, puis le décaler logiquement à droite, enfin convertir le résultat en base 10

```c
En base 2 : 00110010
Décalage logique à droite de 1 bit : 00011001
En base 10 : 25
```

### iv. Écrire 17 en base 2 sur 1 octet, puis le décaler logiquement à gauche, enfin convertir le résultat en base 10

```c
En base 2 : 00010001
Décalage logique à gauche de 1 bit : 00001010
En base 10 : 10
```

### v. Écrire -24 en C₂⁸, puis le décaler arithmétiquement à droite, enfin convertir le résultat en base 10 signée

```c
En C₂⁸ : 11101000
Décalage arithmétique à droite de 1 bit : 11110100
En base 10 signée : -20
```

### vi. Écrire -13 en C₂⁸, puis le décaler arithmétiquement à gauche, enfin convertir le résultat en base 10 signée

```c
En C₂⁸ : 11110011
Décalage arithmétique à gauche de 1 bit : 11100110
En base 10 signée : -26
```
