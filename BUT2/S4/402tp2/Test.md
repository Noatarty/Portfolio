## 4. Exercices

### Après cet inventaire d’AssertJ, on revient à l’écriture de tests unitaires.

- Téléchargez `TestsAssertions.java` et mettez-le à la place de `TestsAssertions.java` côté tests. C’est un fichier que vous devez compléter.
- **ATTENTION** : veillez à ne pas changer les noms des packages, des classes et des méthodes. Tout travail de refactoring que vous imposez en ne respectant pas les consignes vous coûtera des points.

### 4.1. Assertions sur des nombres

- **testEntierM2013negatif** : vérifie que −2013 est négatif. Comprendre que c’est le nombre retourné par `DataProvider.getMoinsDeuxMilleTreize()` et que lors de la correction, ce nombre sera changé en différentes valeurs pour vérifier que votre test échoue quand il le faut.
- **testEntierM2013proche** : vérifie que −2013 est proche de −2000 à 20 près.
- **testEntierM2013multiple11** : vérifie que −2013 est multiple de 11 à l’aide d’un prédicat.
  - Comment faire ? Il faut penser à la division euclidienne (entière) de 2013 par 11, et regarder si le reste est nul. Le reste d’une division par 11 est obtenu directement par `n % 11`. Donc le prédicat s’écrit `n -> n % 11 == 0`.
- **testEntierM2013dansListe** : vérifie que −2013 fait partie de la liste `{ 137, 2, 1000, 13, 2014, −2013, −2 }`.
- **testReelM271valide** : vérifie que −2.71 est un nombre valide : ni `NaN` qui veut dire "not a number", ni l’infini.
- **testReelM271entreM2etM3** : vérifie que −2.71 est compris entre −2 et −3 (piège).
- **testReelM271nonEntier** : vérifie que −2.71 est un nombre non entier.
  - Comment faire ce dernier test ? Un nombre réel comme `2.0` possède une partie entière égale à lui-même. La partie entière de `n` est `Math.floor(n)`. Il suffit donc de comparer `n` et sa partie entière pour savoir si `n` est non-entier. On peut aussi extraire la partie fractionnaire et regarder si elle est nulle.
- **testInfini** : vérifie que le nombre est infini.

### 4.2. Assertions sur des chaînes

- **testGouvernailsLongueur11** : vérifie que la chaîne a une longueur de 11.
- **testGouvernailsFinitParS** : vérifie que la chaîne finit par un `s` minuscule.
- **testGouvernailsContientGou** : vérifie que la chaîne contient `"gou"` sans tenir compte de la casse (`A=a`).
- **testGouvernailsContientAilMaisPasVers** : vérifie que la chaîne contient `"ail"` mais pas `"vers"`, peut-être avec deux assertions à la suite.
- **testGouvernailsContientLettresARES** : vérifie que la chaîne contient les lettres `a, r, e, s` dans n’importe quel ordre.
  - Pensez à traiter la chaîne comme une collection car il y a des assertions qui peuvent faire le travail.
- **testGouvernailsContientMajusculesEtMinuscules** : vérifie que la chaîne contient à la fois des minuscules et des majuscules.
  - Cherchez dans la documentation la méthode qui exprime cela.
- **testGouvernailsContientAucunChiffre** : vérifie que la chaîne ne contient pas de chiffres.
  - Peut-être en traitant la chaîne comme une collection, car on peut alors vérifier qu’il n’y a aucun de certains caractères dedans.
- **testGouvernailsCommenceMajuscule** : vérifie que la chaîne commence par une majuscule.
  - Il faut regarder si la chaîne correspond à l’expression régulière `"^[A-Z].*"`.
  - **ATTENTION** : retapez ce motif de zéro, ne le copiez pas du PDF, car le caractère `^` d’impression est différent.
- **testGouvernailsContientUniquementDesCaracteresUniques** : vérifie que la chaîne ne contient que des caractères uniques, comme dans "oiseaux", aucune lettre n’est répétée.
  - Comment faire ? Comment traduire "doublon" en anglais ? Cherchez une assertion dans les collections qui détecte et refuse les doublons (documentation).

### 4.3. Assertions sur des objets

- **testVehiculeV1classe** : vérifie que la variable `v1` est une instance de `Vehicule` ou d’une sous-classe.
- **testVehiculeV1classeStricte** : vérifie que la variable `v1` est une instance de `Vehicule` mais pas d’une sous-classe.
- **testVehiculeV2classeVeloStricte** : vérifie que la variable `v1` est une instance de `Velo` mais pas d’une sous-classe ou superclasse.
- **testVehiculeV1pasNull** : vérifie que la variable `v1` ne vaut pas `null`.
- **testVehiculeV2diffV3** : vérifie que la variable `v2` n’est pas égale, en tant qu’objet, à `v3`.
- **testVehiculeV2commeV3** : vérifie que la variable `v2` possède les mêmes valeurs de champs (variables membres) que `v3`.
  - Il faut utiliser une comparaison récursive.
- **testVehiculeV3commeV4saufPrix** : vérifie que les variables `v3` et `v4` représentent la même chose si on considère leurs variables membres sauf le prix.
- **testVehiculeV5commeV1saufNulls** : vérifie que `v5` et `v1` représentent la même chose si on considère leurs variables membres qui ne sont pas nulles.

### 4.4. Assertions sur des collections

- **testListeNonVide** : vérifie que la liste n’est pas vide.
- **testListeContientTout** : vérifie que la liste contient la chaîne "tout".
- **testListe4eElement** : vérifie que le 4e élément de la liste est la chaîne "tout".
- **testListeContientExactementUnNull** : vérifie que la liste contient une et une seule valeur `null`.
- **testListeNeContientPasChaineVide** : vérifie que la liste ne contient pas de chaîne vide.
- **testListeNeContientPasQueNull** : vérifie que la liste ne contient pas que des `null`.
- **testListeChainesToutesEntre1et6Chars** : vérifie que les chaînes de la liste ne sont pas vides et ont au maximum 6 caractères.
- **testListeContientUniquementDesStrings** : vérifie que la liste ne contient que des instances de `String` ou `null`.
- **testListeNeContientPasDeChainesEnDouble** : vérifie que la liste ne contient pas d’éléments en double.
- **testListeElementsParmi** : vérifie que la liste est uniquement composée d’éléments parmi `{“ici”, “le”, “groupe”, “a”, 17, “me”, “dit”, 23, “salut”, “tout”, “le”, “temps”, null}`.

### 4.5. Assertions sur des fichiers

- **testFichierExtensionTXT** : vérifie que le nom du fichier se termine par `.txt`.
- **testFichierEstUnFichierLisible** : vérifie que le fichier est bien un fichier et qu’il est lisible.
- **testFichierPasVide** : vérifie que le fichier n’est pas vide.
- **testFichierContientEntre3et6lignes** : vérifie que le fichier contient entre 3 et 6 lignes.

