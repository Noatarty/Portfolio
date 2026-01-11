import matplotlib.pyplot as plt
import numpy as np
from random import*

# nombre d'itérations :
nbpoints=10000

#point de départ :
p=np.zeros((2,1))
 
def transformation1(p):
    # Prend en parametre d’entree un point p de coordonnees x, y et retourne les coordonnees x1, y1 de son image par f1.
    return np.dot(np.array([[0.5,-0.5],[0.5,0.5]]),p) + np.array([[0],[0]])
    
     
def transformation2(p):
    # Prend en parametre d’entree un point p de coordonnees x, y et retourne les coordonnees x2,y2 de son image par f2.
    return np.dot(np.array([[-0.5,-0.5],[0.5,-0.5]]),p) + np.array([[1],[0]])
    

def transforme(p):
    # Choix aléatoire (avec équiprobabilité) entre les 2 transformations de fonctions
    tirage=random()
    if tirage <1/2 :
        res = transformation1(p)
    else :
        res = transformation2(p)
    return res

def construction(p, nbpoints):
    x = [p[0,0]]
    y = [p[1,0]]
    for i in range(nbpoints):
        p = transforme(p)
        x.append(p[0,0])
        y.append(p[1,0])
    
# Représentation graphique
    plt.plot(x, y, 'o')
    plt.title('Dragon de Heighway')
    plt.show()
    
construction(p,nbpoints)
