import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns
from sklearn.decomposition import PCA
from sklearn.preprocessing import StandardScaler
import prince

# Chargement des données
df = pd.read_csv("insurance.csv")

# Encodage des variables qualitatives
df['sex'] = df['sex'].astype('category')
df['smoker'] = df['smoker'].astype('category')
df['region'] = df['region'].astype('category')

# Mapper les valeurs numériques aux labels
df['sex_label'] = df['sex'].map({0: 'Female', 1: 'Male'})
df['smoker_label'] = df['smoker'].map({0: 'No', 1: 'Yes'})
df['region_label'] = df['region'].map({0: 'Southwest', 1: 'Southeast', 2: 'Northwest', 3: 'Northeast', 4: 'Other'})

# Corrélations
corr_matrix = df[['age', 'bmi', 'children', 'charges']].corr()
plt.figure(figsize=(8, 6))
sns.heatmap(corr_matrix, annot=True, cmap='coolwarm', center=0)
plt.title('Matrice de corrélation des variables quantitatives')
plt.tight_layout()
plt.show()

# Sélection des variables quantitatives
X_quant = df[['age', 'bmi', 'children', 'charges']]

# Standardisation
scaler = StandardScaler()
X_scaled = scaler.fit_transform(X_quant)

# ACP
pca = PCA()
pca_res = pca.fit_transform(X_scaled)

# Valeurs propres et variance expliquée
eigenvalues = pca.explained_variance_
variance_ratio = pca.explained_variance_ratio_ * 100
cumulative_variance = np.cumsum(variance_ratio)

eig_df = pd.DataFrame({
    'Dimension': [f'Dim{i+1}' for i in range(len(eigenvalues))],
    'Valeur_propre': eigenvalues,
    '%_Variance': np.round(variance_ratio, 2),
    '%_Variance_Cumulative': np.round(cumulative_variance, 2)
})

# Graphique des valeurs propres (Scree plot)
plt.figure(figsize=(8, 5))
plt.bar(range(len(variance_ratio)), variance_ratio, alpha=0.8, color='steelblue')
plt.plot(range(len(variance_ratio)), variance_ratio, 'ro-', linewidth=2)
plt.xlabel('Composantes principales')
plt.ylabel('% Variance expliquée')
plt.title('Scree Plot - Variance expliquée par composante')
plt.xticks(range(len(variance_ratio)), [f'Dim{i+1}' for i in range(len(variance_ratio))])
plt.grid(axis='y', alpha=0.3)
plt.tight_layout()
plt.show()

# Cercle des corrélations
fig, ax = plt.subplots(figsize=(8, 8))
ax.axhline(0, color='gray', lw=1)
ax.axvline(0, color='gray', lw=1)

# Calcul des corrélations variables-composantes
loadings = pca.components_.T * np.sqrt(pca.explained_variance_)
texts = []

for i, var in enumerate(X_quant.columns):
    x, y = loadings[i, 0], loadings[i, 1]
    ax.arrow(0, 0, x, y, color='red', alpha=0.7, head_width=0.05, head_length=0.05, lw=2)
    texts.append(ax.text(x * 1.15, y * 1.15, var, color='darkblue', fontsize=12, fontweight='bold'))

circle = plt.Circle((0, 0), 1, color='gray', fill=False, linestyle='--', lw=2)
ax.add_artist(circle)
ax.set_xlim(-1.2, 1.2)
ax.set_ylim(-1.2, 1.2)
ax.set_xlabel(f'PC1 ({variance_ratio[0]:.2f}%)', fontsize=12)
ax.set_ylabel(f'PC2 ({variance_ratio[1]:.2f}%)', fontsize=12)
ax.set_title('Cercle des corrélations', fontsize=14, fontweight='bold')
ax.grid(alpha=0.3)
ax.set_aspect('equal')
plt.tight_layout()
plt.show()

# Contributions des variables
contributions = (loadings ** 2) / pca.explained_variance_
contributions_pct = contributions * 100

contrib_df = pd.DataFrame(
    contributions_pct[:, :2],
    columns=['Contrib_Dim1(%)', 'Contrib_Dim2(%)'],
    index=X_quant.columns
)

# Projection des individus
plt.figure(figsize=(8, 6))

color_var = "smoker"
shape_var = "sex"

if color_var in df.columns:
    labels_color = df[color_var].astype(str).values
    unique_colors = np.unique(labels_color)
    palette = sns.color_palette("Set2", len(unique_colors))

    labels_shape = df[shape_var].astype(str).values if shape_var in df.columns else None
    markers = ["o", "s", "D", "^", "v"]

    for i, color_label in enumerate(unique_colors):
        mask_color = labels_color == color_label
        if labels_shape is not None:
            unique_shapes = np.unique(labels_shape)
            for j, shape_label in enumerate(unique_shapes):
                mask = mask_color & (labels_shape == shape_label)
                plt.scatter(
                    pca_res[mask, 0],
                    pca_res[mask, 1],
                    alpha=0.7,
                    s=60,
                    color=palette[i],
                    marker=markers[j % len(markers)],
                    label=f"{color_var}={color_label}, {shape_var}={shape_label}"
                )
        else:
            plt.scatter(
                pca_res[mask_color, 0],
                pca_res[mask_color, 1],
                alpha=0.7,
                s=60,
                color=palette[i],
                label=f"{color_var}={color_label}"
            )

plt.xlabel(f"PC1 ({variance_ratio[0]:.2f}%)")
plt.ylabel(f"PC2 ({variance_ratio[1]:.2f}%)")
plt.title("Projection des individus — ACP")
plt.legend()
plt.grid(True)
plt.tight_layout()
plt.show()

# AFC 1: Smoker vs Region
contingency_1 = pd.crosstab(df['smoker_label'], df['region_label'])

# AFC avec prince
ca_1 = prince.CA(n_components=2, n_iter=10, copy=True, engine='sklearn')
ca_1 = ca_1.fit(contingency_1)

rows_1 = ca_1.row_coordinates(contingency_1)
cols_1 = ca_1.column_coordinates(contingency_1)

# Inertie expliquée
inertia_1 = ca_1.eigenvalues_ / ca_1.eigenvalues_.sum() * 100

# Plan factoriel
if len(inertia_1) > 1 and rows_1.shape[1] > 1:
    fig, ax = plt.subplots(figsize=(10, 8))
    ax.scatter(rows_1.iloc[:, 0], rows_1.iloc[:, 1], color='red', s=200, 
               label='Smoker', marker='o', edgecolors='darkred', linewidths=2)
    ax.scatter(cols_1.iloc[:, 0], cols_1.iloc[:, 1], color='blue', s=200, 
               label='Region', marker='s', edgecolors='darkblue', linewidths=2)
    
    for i, txt in enumerate(rows_1.index):
        ax.text(rows_1.iloc[i, 0] * 1.1, rows_1.iloc[i, 1] * 1.1, txt, 
                color='darkred', fontsize=12, fontweight='bold', ha='center')
    
    for i, txt in enumerate(cols_1.index):
        ax.text(cols_1.iloc[i, 0] * 1.1, cols_1.iloc[i, 1] * 1.1, txt, 
                color='darkblue', fontsize=11, fontweight='bold', ha='center')
    
    ax.axhline(0, color='gray', lw=1, linestyle='--')
    ax.axvline(0, color='gray', lw=1, linestyle='--')
    ax.set_xlabel(f'Dimension 1 ({inertia_1[0]:.2f}%)', fontsize=12)
    ax.set_ylabel(f'Dimension 2 ({inertia_1[1]:.2f}%)', fontsize=12)
    ax.set_title('AFC: Smoker x Region', fontsize=14, fontweight='bold')
    ax.legend()
    ax.grid(alpha=0.3)
    plt.tight_layout()
    plt.show()
else:
    fig, ax = plt.subplots(figsize=(10, 6))
    ax.scatter(rows_1.iloc[:, 0], [0] * len(rows_1), color='red', s=200, 
               label='Smoker', marker='o', edgecolors='darkred', linewidths=2)
    ax.scatter(cols_1.iloc[:, 0], [0] * len(cols_1), color='blue', s=200, 
               label='Region', marker='s', edgecolors='darkblue', linewidths=2)
    
    for i, txt in enumerate(rows_1.index):
        ax.text(rows_1.iloc[i, 0], 0.02, txt, color='darkred', 
                fontsize=12, fontweight='bold', ha='center')
    
    for i, txt in enumerate(cols_1.index):
        ax.text(cols_1.iloc[i, 0], -0.02, txt, color='darkblue', 
                fontsize=11, fontweight='bold', ha='center')
    
    ax.axhline(0, color='gray', lw=1, linestyle='--')
    ax.axvline(0, color='gray', lw=1, linestyle='--')
    ax.set_xlabel(f'Dimension 1 ({inertia_1[0]:.2f}%)', fontsize=12)
    ax.set_ylim(-0.1, 0.1)
    ax.set_title('AFC: Smoker x Region', fontsize=14, fontweight='bold')
    ax.legend()
    ax.grid(alpha=0.3)
    plt.tight_layout()
    plt.show()

# AFC 2: Sex vs Smoker
contingency_2 = pd.crosstab(df['sex_label'], df['smoker_label'])

ca_2 = prince.CA(n_components=1, n_iter=10, copy=True, engine='sklearn')
ca_2 = ca_2.fit(contingency_2)

rows_2 = ca_2.row_coordinates(contingency_2)
cols_2 = ca_2.column_coordinates(contingency_2)

inertia_2 = ca_2.eigenvalues_ / ca_2.eigenvalues_.sum() * 100

fig, ax = plt.subplots(figsize=(10, 6))
ax.scatter(rows_2.iloc[:, 0], [0] * len(rows_2), color='red', s=200, 
           label='Sex', marker='o', edgecolors='darkred', linewidths=2)
ax.scatter(cols_2.iloc[:, 0], [0] * len(cols_2), color='blue', s=200, 
           label='Smoker', marker='s', edgecolors='darkblue', linewidths=2)

for i, txt in enumerate(rows_2.index):
    ax.text(rows_2.iloc[i, 0], 0.02, txt, color='darkred', 
            fontsize=12, fontweight='bold', ha='center')

for i, txt in enumerate(cols_2.index):
    ax.text(cols_2.iloc[i, 0], -0.02, txt, color='darkblue', 
            fontsize=12, fontweight='bold', ha='center')

ax.axhline(0, color='gray', lw=1, linestyle='--')
ax.axvline(0, color='gray', lw=1, linestyle='--')
ax.set_xlabel(f'Dimension 1 ({inertia_2[0]:.2f}%)', fontsize=12)
ax.set_ylim(-0.1, 0.1)
ax.set_title('AFC: Sex x Smoker', fontsize=14, fontweight='bold')
ax.legend()
ax.grid(alpha=0.3)
plt.tight_layout()
plt.show()

# Discrétisation de l'âge pour AFC supplémentaire
df['age_class'] = pd.cut(df['age'], bins=[0, 30, 40, 50, 60, 100], 
                          labels=['18-29', '30-39', '40-49', '50-59', '60+'])

contingency_3 = pd.crosstab(df['age_class'], df['smoker_label'])

ca_3 = prince.CA(n_components=2, n_iter=10, copy=True, engine='sklearn')
ca_3 = ca_3.fit(contingency_3)

rows_3 = ca_3.row_coordinates(contingency_3)
cols_3 = ca_3.column_coordinates(contingency_3)

inertia_3 = ca_3.eigenvalues_ / ca_3.eigenvalues_.sum() * 100

# Plan factoriel
if len(inertia_3) > 1 and rows_3.shape[1] > 1:
    fig, ax = plt.subplots(figsize=(10, 8))
    ax.scatter(rows_3.iloc[:, 0], rows_3.iloc[:, 1], color='red', s=200, 
               label='Age Class', marker='o', edgecolors='darkred', linewidths=2)
    ax.scatter(cols_3.iloc[:, 0], cols_3.iloc[:, 1], color='blue', s=200, 
               label='Smoker', marker='s', edgecolors='darkblue', linewidths=2)
    
    for i, txt in enumerate(rows_3.index):
        ax.text(rows_3.iloc[i, 0] * 1.1, rows_3.iloc[i, 1] * 1.1, txt, 
                color='darkred', fontsize=12, fontweight='bold', ha='center')
    
    for i, txt in enumerate(cols_3.index):
        ax.text(cols_3.iloc[i, 0] * 1.1, cols_3.iloc[i, 1] * 1.1, txt, 
                color='darkblue', fontsize=12, fontweight='bold', ha='center')
    
    ax.axhline(0, color='gray', lw=1, linestyle='--')
    ax.axvline(0, color='gray', lw=1, linestyle='--')
    ax.set_xlabel(f'Dimension 1 ({inertia_3[0]:.2f}%)', fontsize=12)
    ax.set_ylabel(f'Dimension 2 ({inertia_3[1]:.2f}%)', fontsize=12)
    ax.set_title('AFC: Age Class x Smoker', fontsize=14, fontweight='bold')
    ax.legend()
    ax.grid(alpha=0.3)
    plt.tight_layout()
    plt.savefig('afc_age_smoker.png', dpi=300)
    plt.show()
else:
    fig, ax = plt.subplots(figsize=(10, 6))
    ax.scatter(rows_3.iloc[:, 0], [0] * len(rows_3), color='red', s=200, 
               label='Age Class', marker='o', edgecolors='darkred', linewidths=2)
    ax.scatter(cols_3.iloc[:, 0], [0] * len(cols_3), color='blue', s=200, 
               label='Smoker', marker='s', edgecolors='darkblue', linewidths=2)
    
    for i, txt in enumerate(rows_3.index):
        ax.text(rows_3.iloc[i, 0], 0.02, txt, color='darkred', 
                fontsize=12, fontweight='bold', ha='center')
    
    for i, txt in enumerate(cols_3.index):
        ax.text(cols_3.iloc[i, 0], -0.02, txt, color='darkblue', 
                fontsize=12, fontweight='bold', ha='center')
    
    ax.axhline(0, color='gray', lw=1, linestyle='--')
    ax.axvline(0, color='gray', lw=1, linestyle='--')
    ax.set_xlabel(f'Dimension 1 ({inertia_3[0]:.2f}%)', fontsize=12)
    ax.set_ylim(-0.1, 0.1)
    ax.set_title('AFC: Age Class x Smoker', fontsize=14, fontweight='bold')
    ax.legend()
    ax.grid(alpha=0.3)
    plt.tight_layout()
    plt.show()
