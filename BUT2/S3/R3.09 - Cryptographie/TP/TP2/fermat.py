def fermat_test(n, a):
    """Vérifie si n est probablement premier en utilisant le test de Fermat avec la base a."""
    if n <= 1:
        return False
    if n == 2:
        return True
    if n % 2 == 0:
        return False
    # Calculer a^(n-1) mod n
    return pow(a, n - 1, n) == 1

def is_probably_prime(n):
    """Teste si n est probablement premier avec les bases 2, 3, 5 et 7."""
    bases = [2, 3, 5, 7]
    for a in bases:
        if not fermat_test(n, a):
            return False
    return True

def find_pseudoprimes(limit):
    """Trouve les grands nombres pseudo-premiers jusqu'à la limite spécifiée."""
    pseudoprimes = []
    for i in range(2, limit):
        if is_probably_prime(i):
            pseudoprimes.append(i)
    return pseudoprimes

def euler_polynomial_pseudoprimes(limit):
    """Calcule les pourcentages de nombres pseudo-premiers obtenus à l'aide des polynômes d'Euler."""
    pseudoprimes = find_pseudoprimes(limit)
    total_numbers = limit - 2  # Exclure 0 et 1
    percentage = (len(pseudoprimes) / total_numbers) * 100 if total_numbers > 0 else 0
    return percentage

# Exemple d'utilisation
limit = 100000
print("Pourcentage de nombres pseudo-premiers:", euler_polynomial_pseudoprimes(limit))