import numpy as np
import numpy.random as rd
import matplotlib.pyplot as plt
import random

Lieux1=['Paris','Lyon','Nice','Nantes','Strasbourg','Montpellier','Lille',
        'Rennes','Reims','Saint-Étienne','Angers','Grenoble','Nîmes',
        'Aix-en-Provence','Brest']

Carte0=np.array([[  0 ,210,95,180],
                 [210,  0 ,126,53],
                 [95 ,126,  0 ,113],
                 [180,53 ,113,  0 ]])

Carte1=np.array([[  0 ,462,931,380,488,746,219,348,143,522,293,575,710,759,589],
                [462,  0 ,472,681,494,302,689,718,487, 62,594,107,251,299,970],
                [930,471, 0,1143,790,326,1157,1186,955,490,1062,465,279,176,1440],
                [380,682,1145,  0 ,860,824,597,107,515,662,  88,786,874,972,296],
                [487,491,788,860, 0  ,791,549,827,347,550,773,533,739,787,1069],
                [746,303,327,823,791, 0  ,963,895,787,322,771,297,56,154,1120],
                [217,690,1159,598,522,963, 0 ,572,199,749,511,803,938,986,759],
                [347,718,1186,106,827,894,572, 0 ,483,699,126,823,948,1013,241],
                [143,487,955,516,347,786,198,483, 0  ,546,429,600,735,783,725],
                [523, 64,491,661,552,322,750,698,548, 0  ,574,155,271,319,950],
                [293,595,1062,88,773,770,511,128,429,576, 0  ,700,824,890,377],
                [574,106,466,786,534,296,801,823,599,155,699, 0  ,245,293,1075],
                [711,252,281,872,740, 55,938,949,736,271,825,246, 0  ,108,1169],
                [757,298,178,970,786,153,984,1013,781,317,889,291,106, 0 ,1267],
                [590,971,1441,298,1070,1121,760,241,725,952,378,1076,1171,1269,0]])

def TrajetAlea(n):
    trajet = rd.permutation(np.arange(1, n))  #melange des villes sauf 0
    return np.concatenate(([0], trajet, [0]))  #ajout de la ville 0 au debut et a la fin

def PopAlea(n, p):
    return np.array([TrajetAlea(n) for _ in range(p)])

def LTrajet(t, Carte):
    return sum(Carte[t[i], t[i+1]] for i in range(len(t)-1))

def LPop(P, Carte):
    return np.array([LTrajet(trajet, Carte) for trajet in P])

def Selection(P, Carte):
    longueurs = LPop(P, Carte)
    indices = np.argsort(longueurs)[:(len(P)//2)*2]
    return P[indices]

def Croisement(Parent1, Parent2):
    n = len(Parent1)
    i = rd.randint(1, n-1)
    enfant = list(Parent1[:i])
    for ville in Parent2:
        if ville not in enfant:
            enfant.append(ville)
    return np.array(enfant)

def PopCroisement(P):
    rd.shuffle(P)
    enfants = [Croisement(P[i], P[i+1]) for i in range(0, len(P), 2)]
    enfants += [Croisement(P[i+1], P[i]) for i in range(0, len(P), 2)]
    return np.array(enfants)

#Facultatif
def Croisement2(Parent1, Parent2):
    n = len(Parent1)
    i = rd.randint(1, n-2)
    j = rd.randint(i+1, n-1)
    Enfant1, Enfant2 = Parent1.copy(), Parent2.copy()
    Enfant1[i:j], Enfant2[i:j] = Enfant2[i:j], Enfant1[i:j]
    
    def corriger_doublons(Enfant, Parent):
        villes_manquantes = [v for v in Parent if v not in Enfant]
        vus = set()
        for idx in range(n):
            if Enfant[idx] in vus:
                Enfant[idx] = villes_manquantes.pop(0)
            vus.add(Enfant[idx])
        return Enfant
    
    return corriger_doublons(Enfant1, Parent1), corriger_doublons(Enfant2, Parent2)

def Mutation(trajet):
    if len(trajet) > 2:
        i, j = random.sample(range(1, len(trajet)), 2)
        trajet[i], trajet[j] = trajet[j], trajet[i]
    return trajet

def PopMutation(P, r):
    n_mutants = round(r * len(P))
    individus_a_muter = random.sample(P, n_mutants)
    for ind in individus_a_muter:
        Mutation(ind)
    return P

def Genetique(Carte, p, g, r):
    population = [random.sample(range(len(Carte)), len(Carte)) for _ in range(p)]
    meilleurs_trajets = []
    
    for generation in range(g):
        population.sort(key=lambda trajet: calculer_distance(Carte, trajet))
        meilleurs_trajets.append((generation, calculer_distance(Carte, population[0])))
        population = population[:p//2] + [Mutation(trajet[:]) for trajet in population[:p//2]]
        PopMutation(population, r)
    
    affichage_evolution(meilleurs_trajets)
    return population[0]

def calculer_distance(Carte, trajet):
    return sum(((Carte[trajet[i]][0] - Carte[trajet[i+1]][0])**2 + (Carte[trajet[i]][1] - Carte[trajet[i+1]][1])**2) ** 0.5
               for i in range(len(trajet) - 1))

def affichage_evolution(meilleurs_trajets):
    generations, distances = zip(*meilleurs_trajets)
    plt.plot(generations, distances, marker='o')
    plt.xlabel('Générations')
    plt.ylabel('Distance du meilleur trajet')
    plt.title('Évolution de la meilleure solution')
    plt.show()

#tests

def test_genetique():
    Carte = {i: (random.randint(0, 100), random.randint(0, 100)) for i in range(5)}
    best_trajet = Genetique(Carte, p=10, g=5, r=0.3)
    assert isinstance(best_trajet, list), "Genetique doit renvoyer une liste"
    assert all(isinstance(v, int) for v in best_trajet), "Le trajet doit être une liste d'entiers"


test_genetique()
