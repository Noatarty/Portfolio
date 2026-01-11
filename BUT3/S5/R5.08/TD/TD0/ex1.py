import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from sklearn.preprocessing import StandardScaler

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

# Créer le nuage de points
plt.figure(figsize=(10, 8))

# Couleurs pour chaque classe
colors = ['red', 'blue', 'green']
classes = np.unique(y)

for i, classe in enumerate(classes):
    mask = y == classe
    plt.scatter(X_scaled[mask, 0], X_scaled[mask, 1], 
               c=colors[i], label=classe, alpha=0.7)

plt.xlabel('Longueur des pétales (standardisée)')
plt.ylabel('Largeur des pétales (standardisée)')
plt.title('Nuage de points - Longueur vs Largeur des pétales (iris)')
plt.legend()
plt.grid(True, alpha=0.3)
plt.show()

# Afficher quelques statistiques
print("Forme des données:", X.shape)
print("Classes:", classes)
print("\nDonnées originales - Moyennes par classe:")
for classe in classes:
    mask = y == classe
    print(f"{classe}: Longueur={X[mask, 0].mean():.2f}, Largeur={X[mask, 1].mean():.2f}")
