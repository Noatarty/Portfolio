import matplotlib.pyplot as plt
import numpy as np
from random import*

# nombre d'itérations :
nbpoints=10000

#point de départ :
p=np.zeros((2,1))
r=0.75
c=0.255
q=0.625
o1=-np.pi/8
o2=np.pi/5
 
def transformation1(p):
    # Prend en parametre d’entree un point p de coordonnees x, y et retourne les coordonnees x1, y1 de son image par f1.
    return np.dot(np.array([[0,0],[0,0.255]]),p) + np.array([[0.5],[0]])
    
     
def transformation2(p):
    # Prend en parametre d’entree un point p de coordonnees x, y et retourne les coordonnees x2,y2 de son image par f2.
    return np.dot(np.array([[(r*np.cos(o1)),((-r)*np.sin(o1))],[(r*np.sin(o1)),(r*np.cos(o1))]]),p) + np.array([[(0.5-(0.5*r*np.cos(o1)))],[(c-(0.5*r*np.sin(o1)))]])
    
def transformation3(p):
    return np.dot(np.array([[(q*np.cos(o2)),((-r)*np.sin(o2))],[(q*np.sin(o2)),(r*np.cos(o2))]]),p) + np.array([[(0.5-(0.5*q*np.cos(o2)))],[((0.6*c)-(0.5*q*np.sin(o2)))]])

def transforme(p):
    # Choix aléatoire (avec équiprobabilité) entre les 2 transformations de fonctions
    tirage=random()
    if tirage <1/3 :
        res = transformation1(p)
    elif tirage <2/3 :
        res = transformation2(p)
    else :
        res = transformation3(p)
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
    plt.title('Arbre')
    plt.show()
    
construction(p,nbpoints)