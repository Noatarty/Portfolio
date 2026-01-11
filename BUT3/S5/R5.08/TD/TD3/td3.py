import numpy as np
import sklearn
from sklearn.datasets import load_iris

# Exercice 1
# Programmez une méthode distance(x1, x2) qui calcule et retourne la distance euclidienne entre deux vecteurs x1 et x2 de taille n. 

def distance(x1, x2):
    return sum((x1[i] - x2[i])**2 for i in range(len(x1)))**0.5

# Exercice 2
# Programmez une m ́ethode voisins(x, dataset) qui calcul la distance entre x
# et les vecteurs de dataset et qui retourne la liste tri ́ee des indices de dataset,
# du plus proche au plus  ́eloign ́e de x. Vous pouvez tester votre m ́ethode :
# voisin(np.array([1, 2], np.array([[1, 1], [3, 7], [2, 2]]) doit retourner : [0, 2, 1]

def voisins(x, dataset):
    return sorted(range(len(dataset)), key=lambda i: distance(x, dataset[i]))

print(voisins(np.array([1, 2]), np.array([[1, 1], [3, 7], [2, 2]])))

# Exercice 3
# Chargez le jeu de donn ́ees IRIS dans une seule variable dataset. D ́ecrivez
# chacune des variables, pour ce faire indiquez son nom, son type, s’il s’agit d’une
# variable quantitative indiquez sa moyenne et ses valeurs min et max, s’il s’agit
# d’une variable quantitative indiquez toutes les valeurs possible ou une description si le nombre de valeurs est trop grand. Chargez cette fois le jeu de donn ́ees
# dans deux numpy.array, X et y.
# Verifiez les distributions de votre jeu de donn ́ees, la valeur de retour pour
# X doit ˆetre (150, 4), soit 150 observatcopions sur 4 variables, et celle de y doit ˆetre
# (150), soit 150 observation pour une seule variable.

# Charger IRIS (pour description)
dataset = load_iris()
# Charger IRIS (pour manipuation)
X, y = load_iris(return_X_y=True)
print(dataset.DESCR)

print(X.shape)
print(y.shape)

# Exercice 4
# D ́ecoupez votre jeu de donn ́ees en un jeu d’entraˆınement et un jeu de test.
# Programmez une m ́ethode vote(K, voisins, y) qui prend en param`etre un nom-
# bre de voisins de K, une liste d’indices (la sortie de la m ́ethode voisins) et
# les vraies classes des observations y. La m ́ethode vote doit retourner la classe
# retenue apr`es vote majoritaire des K plus proches voisins.

# Importer le découpage
from sklearn.model_selection import train_test_split
# Découper le jeu en train/test
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2)
# Importer la standardisation
from sklearn.preprocessing import StandardScaler
# Standardisation
X = StandardScaler().fit_transform(X)

def vote(K, voisins, y):
    MV = {}
    for i in range(K):
        if y[voisins[i]] in MV:
            MV[y[voisins[i]]] += 1
        else:
            MV[y[voisins[i]]] = 1
    return max(MV, key=MV.get)

