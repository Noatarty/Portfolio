unemployment_rates = [7.9, 9.4, 11.7, 9.3, 8.1, 8.8, 7.8, 8.8, 8.3, 8.1, 11, 10.8, 9.9]

def Moyenne(Serie):
    total = 0
    for value in Serie:
        total+= value
    return total / len(Serie)

print("Moyenne chomage:", Moyenne(unemployment_rates))

def Variance(Serie):
    mean = Moyenne(Serie)
    total = 0
    for value in Serie:
        total += (value - mean) ** 2
    return total / len(Serie)

print("Variance chomage:", Variance(unemployment_rates))

from math import sqrt

def Ecart_type(Serie):
    return sqrt(Variance(Serie))

print("ecart type chomage:", Ecart_type(unemployment_rates))