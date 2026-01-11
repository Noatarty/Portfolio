import numpy as np

def tirage_de():
    return np.random.randint(1, 7)

def tirages_des(N):
    return [tirage_de() for _ in range(N)]

Serie100 = tirages_des(100)

def Moyenne(Serie):
    total = 0
    for value in Serie:
        total += value
    return total / len(Serie)

print("Serie100:", Moyenne(Serie100))

def Variance(Serie):
    mean = Moyenne(Serie)
    total = 0
    for value in Serie:
        total += (value - mean) ** 2
    return total / len(Serie)

print("Variance Serie100:", Variance(Serie100))

def effectif(Serie, Val):
    return sum(value == Val for value in Serie)

print("Nombre de 4 dans la Serie100:", effectif(Serie100, 4))