import numpy as np
# Q1
'''Une matrice A ∈ Mn,p(R)  ́etant donn ́ee, on appelle mineur d’indice i,j de A la
matrice Ai,j obtenue a partir de A en supprimant la ligne i et la colonne j de A.'''
def mineur(A,i,j):
    # Suppression de la ligne i
    A = np.delete(A, i-1, 0)
    # Suppression de la colonne j
    A = np.delete(A, j-1, 1)
    return A

#Test
A = np.array([[-1,1,3],[2,3,2],[0,4,2],[2,1,2]])
print(mineur(A,2,2))

#Q2
'''On a vu dans le cours que l’on pouvait d ́efinir le d ́eterminant d’une matrice carr ́ee de
dimension 2 par la formule :
det M = ad-bc si M = ( a b )
                     ( c d )
'''
def det2(A):
    '''Ecrire une fonction det2 qui prend en parametres d’entr ́ee une matrice
A de dimension 2 et retourne la valeur de son d ́eterminant calcul ́e a l’aide de la formule
pr ́ec ́edente'''
    if len(A) != 2:
        print("La matrice doit être de dimension 2")
        return None
    else:
        a = A[0][0]
        b = A[0][1]
        c = A[1][0]
        d = A[1][1]
        return a*d - b*c
# Test
B = np.array([[2,4],[4,8]])
print(det2(B))

''' ́Ecrire une fonction colonne qui prend en parametres d’entr ́ee une ma-
trice carr ́ee A et retourne la matrice  ̃A obtenue a partir de A par combinaisons lin eaires
de ses lignes et dont les termes de la premiere colonne sont nuls a l’exception du premier
terme a1,1 (le cas ou il serait nul n’est pas a prendre en compte)'''

def colonne(A):
    if len(A.shape) != 2 or A.shape[0] != A.shape[1]:
        print("La matrice doit être carrée")
        return None
    else:
        # On récupère la dimension de la matrice
        n = A.shape[0]
        # On initialise la matrice de sortie
        Ã = np.copy(A)
        # On parcourt les lignes de 2 à n
        for i in range(1,n):
            # On calcule la valeur de la i-ème ligne de la matrice de sortie
            Ã[i][0] = A[i][0] - A[i][i]*A[0][0]
            # On parcourt les colonnes de 2 à n
            for j in range(1,n):
                # On calcule la valeur de la j-ème colonne de la matrice de sortie
                Ã[i][j] = A[i][j] - A[i][i]*A[0][j]
    return Ã