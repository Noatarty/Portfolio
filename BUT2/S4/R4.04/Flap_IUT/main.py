import random

###### LA GENESE ######

def __main__():

    # Lance le jeu
    #jeu = True

    # Lance le jeu avec l'intelligence artificielle
    jeu = False

    return jeu, NOMBRE_POPULATION, POURCENTAGE_RENOUVELLEMENT



###### LA CREATION ######

# Population (entre 1 et 100)
NOMBRE_POPULATION = 100

# Quantité de Frames à attendre 
#jusqu'au prochain saut (60 Frames 
#en 1 sec)
def attente_saut():
    return 30




###### LA SELECTION ######

# Quantité d'individus renouvelés 
#(en %)
POURCENTAGE_RENOUVELLEMENT = 20



###### LA NOUVELLE GENERATION ######

# Génération des sauts du nouveau macareux à partir de ceux d'un parent
# In : Liste de 5 sauts (4 derniers sauts + 1 prochain saut) du parent
# Out : Liste des 5 sauts du macareux mutant
# Variable Bonus : le variable tuyau indique si le macareux parent s'est 
# cogné sur un tuyau du haut, ou un tuyau du bas (True = haut, False = bas)
def nouveau_macareux(liste_sauts, tuyau):
    liste_sauts[2]=random.random()*60
    return liste_sauts
