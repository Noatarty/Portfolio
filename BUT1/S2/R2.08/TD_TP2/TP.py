import numpy as np
import matplotlib.pyplot as plt

# Exercice 3
X = [8, 9, 10, 7, 8, 12, 11, 9, 10, 8] 

def Moyenne(X):
    return sum(X) / len(X)

def Variance(X):
    moy = Moyenne(X)
    return sum((x - moy)**2 for x in X) / len(X)

print(Moyenne(X)) 
print(Variance(X))

plt.hist(X, density=True)
plt.show()

plt.boxplot(X)
plt.show()

# Exercice 4
Serie100 = [3, 5, 4, 4, 6, 3, 3, 4, 5, 2, 
            5, 3, 5, 4, 6, 5, 3, 1, 5, 5, 
            2, 4, 3, 5, 2, 1, 1, 5, 3, 4, 
            3, 5, 1, 1, 2, 3, 3, 4, 1, 6,
            2, 6, 1, 3, 2, 1, 2, 3, 2, 4,
            2, 6, 2, 3, 3, 4, 6, 2, 3, 4]

Vals = [1, 2, 3, 4, 5, 6]
plt.hist(Serie100, Vals, histtype='bar', align='left', rwidth=0.1)
plt.show()

# Exercice 5
import random

def Moy100():
    lancers = [random.randint(1, 6) for _ in range(100)]
    return sum(lancers) / len(lancers)

def TabMoy100(N):
    return [Moy100() for _ in range(N)]

Tab50 = TabMoy100(50)
print(sum(Tab50)/len(Tab50)) 

Tab10000 = TabMoy100(10000)
plt.hist(Tab10000, bins=list(range(1, 7)), rwidth=0.8)
plt.show()
