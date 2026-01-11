import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from sklearn.preprocessing import StandardScaler
from sklearn.cluster import KMeans

# Charger le jeu de données iris
data = pd.read_csv('iris.csv')

# Extraire les caractéristiques (features) et les labels
X = data.iloc[:, :-1].values  # Toutes les colonnes sauf la dernière
y = data.iloc[:, -1].values   # La dernière colonne (variety)

# Garder seulement la longueur et largeur des pétales (colonnes 2 et 3)
X = X[:, 2:]

# Standardiser les données
scaler = StandardScaler()
X_scaled = scaler.fit_transform(X)

# Exercice 3: Méthode du coude pour déterminer le nombre optimal de clusters
print("Exercice 3: Méthode du coude")
print("===========================")

# Calculer l'inertie pour différents nombres de clusters (2 à 10)
k_range = range(2, 11)
inertias = []

for k in k_range:
    kmeans = KMeans(n_clusters=k, random_state=42)
    kmeans.fit(X_scaled)
    inertias.append(kmeans.inertia_)
    print(f"K = {k}: Inertie = {kmeans.inertia_:.4f}")

# Afficher la courbe du coude
plt.figure(figsize=(10, 6))
plt.plot(k_range, inertias, 'bo-', linewidth=2, markersize=8)
plt.xlabel('Nombre de clusters (K)')
plt.ylabel('Inertie totale')
plt.title('Méthode du coude - Inertie en fonction du nombre de clusters')
plt.grid(True, alpha=0.3)

# Marquer le point K=3 (nombre réel de classes)
k_real = 3
inertia_k3 = inertias[k_real - 2]  # Index ajusté car on commence à k=2
plt.plot(k_real, inertia_k3, 'ro', markersize=12, 
         label=f'K=3 (nombre réel de classes)')

plt.legend()
plt.tight_layout()
plt.show()

# Calculer les réductions d'inertie entre k et k+1
print("\nRéduction d'inertie:")
print("===================")
reductions = []
for i in range(len(inertias)-1):
    reduction = inertias[i] - inertias[i+1]
    percentage = (reduction / inertias[i]) * 100
    reductions.append(reduction)
    k_current = k_range[i]
    k_next = k_range[i+1]
    print(f"K={k_current} → K={k_next}: Réduction = {reduction:.4f} ({percentage:.1f}%)")

# Afficher le graphique des réductions
plt.figure(figsize=(10, 6))
k_reductions = list(k_range)[:-1]  # Exclure le dernier k
plt.plot(k_reductions, reductions, 'go-', linewidth=2, markersize=8)
plt.xlabel('Nombre de clusters initial (K)')
plt.ylabel('Réduction d\'inertie (K → K+1)')
plt.title('Réduction d\'inertie entre clusters consécutifs')
plt.grid(True, alpha=0.3)

# Marquer le point où la réduction diminue le plus (coude)
max_reduction_idx = np.argmax(reductions)
optimal_k = k_reductions[max_reduction_idx]
plt.plot(optimal_k, reductions[max_reduction_idx], 'ro', markersize=12, 
         label=f'Plus grande réduction: K={optimal_k}→{optimal_k+1}')

plt.legend()
plt.tight_layout()
plt.show()

# Analyse du coude
print(f"\nAnalyse de la méthode du coude:")
print(f"===============================")
print(f"Nombre réel de classes dans iris: 3")
print(f"Plus grande réduction d'inertie: K={optimal_k} → K={optimal_k+1}")

# Calculer les ratios de réduction pour identifier le coude plus précisément
print(f"\nRapports des réductions successives:")
for i in range(len(reductions)-1):
    if reductions[i+1] > 0:
        ratio = reductions[i] / reductions[i+1]
        k_val = k_reductions[i]
        print(f"Réduction(K={k_val}→{k_val+1}) / Réduction(K={k_val+1}→{k_val+2}) = {ratio:.2f}")

# Conclusion
print(f"\nConclusion:")
print(f"===========")
if optimal_k + 1 == 3:
    print("✓ La méthode du coude suggère K=3, ce qui correspond au nombre réel de classes.")
else:
    print(f"⚠ La méthode du coude suggère K={optimal_k+1}, différent du nombre réel (3).")

print("La méthode du coude permet d'identifier un nombre optimal de clusters")
print("en cherchant le point où l'amélioration de l'inertie devient marginale.")
