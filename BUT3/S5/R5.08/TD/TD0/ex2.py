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

# Initialiser et entraîner le modèle K-moyennes avec K=3
kmeans = KMeans(n_clusters=3, random_state=42)
y_pred = kmeans.fit_predict(X_scaled)

# Créer deux graphiques côte à côte pour comparer
fig, (ax1, ax2) = plt.subplots(1, 2, figsize=(15, 6))

# Graphique 1: Vraies classes
colors = ['red', 'blue', 'green']
classes = np.unique(y)

for i, classe in enumerate(classes):
    mask = y == classe
    ax1.scatter(X_scaled[mask, 0], X_scaled[mask, 1], 
               c=colors[i], label=classe, alpha=0.7)

ax1.set_xlabel('Longueur des pétales (standardisée)')
ax1.set_ylabel('Largeur des pétales (standardisée)')
ax1.set_title('Vraies classes')
ax1.legend()
ax1.grid(True, alpha=0.3)

# Graphique 2: Prédictions K-moyennes
for i in range(3):
    mask = y_pred == i
    ax2.scatter(X_scaled[mask, 0], X_scaled[mask, 1], 
               c=colors[i], label=f'Cluster {i}', alpha=0.7)

# Afficher les centres des clusters
centers = kmeans.cluster_centers_
ax2.scatter(centers[:, 0], centers[:, 1], 
           c='black', marker='x', s=200, linewidths=3, label='Centres')

ax2.set_xlabel('Longueur des pétales (standardisée)')
ax2.set_ylabel('Largeur des pétales (standardisée)')
ax2.set_title('Prédictions K-moyennes (K=3)')
ax2.legend()
ax2.grid(True, alpha=0.3)

plt.tight_layout()
plt.show()

# Analyser la correspondance entre clusters et vraies classes
print("Analyse des clusters:")
print("===================")

# Créer une matrice de confusion informelle
for i in range(3):
    cluster_mask = y_pred == i
    print(f"\nCluster {i}:")
    for classe in classes:
        count = np.sum((y == classe) & cluster_mask)
        total_cluster = np.sum(cluster_mask)
        percentage = (count / total_cluster) * 100 if total_cluster > 0 else 0
        print(f"  {classe}: {count}/{total_cluster} ({percentage:.1f}%)")

# Calculer la pureté de chaque cluster
print("\nPureté des clusters:")
for i in range(3):
    cluster_mask = y_pred == i
    if np.sum(cluster_mask) > 0:
        classes_in_cluster = y[cluster_mask]
        most_common_class = np.bincount([list(classes).index(c) for c in classes_in_cluster]).argmax()
        purity = np.mean(classes_in_cluster == classes[most_common_class])
        print(f"Cluster {i}: {purity:.2f} (classe dominante: {classes[most_common_class]})")

print(f"\nNombre total d'observations: {len(y)}")
print(f"Centres des clusters:\n{centers}")
