import numpy as np

def multiplication_reel(M, i, k):
    M[i] = M[i] * k

def elimination(M, i, j, k):
    M[j] = M[j] - k * M[i]

def GaussJordan(M):
    n = len(M)
    #np.identity(n) crée une matrice identité de longueur n
    inverse = np.identity(n)

    for i in range(n):
        if M[i, i] == 0:
            return None
        
        inverse[i] = inverse[i] / M[i, i]
        M[i] = M[i] / M[i, i]

        for j in range(n):
            if i != j:
                coeff = M[j, i]
                elimination(M, i, j, coeff)
                inverse[j] = inverse[j] - coeff * inverse[i]

    return inverse

M = np.array([[1, -1, -4],
               [2, -3, 4],
               [0, 2, 8]])

inverse_M = GaussJordan(M)
print("Inverse de M :\n", inverse_M)

M2 = np.array([[-1, 2, 4],
               [1, 0, -2],
               [-2, 2, 5]],)

inverse_M2 = GaussJordan(M2)
print("Inverse de M2 :\n", inverse_M2)
