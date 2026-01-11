import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from sklearn.decomposition import PCA
import seaborn as sns

csv_path = "insurance.csv"

# Chargement
data = pd.read_csv(
    csv_path,
    low_memory=False,
)

# Nettoyage
data = data.dropna(axis=1, how="all")
thresh = int(0.5 * len(data))
data = data.dropna(axis=1, thresh=thresh)

# Variables numériques
num_df = data.select_dtypes(include=[np.number]).copy()
num_df = num_df.loc[:, num_df.std(skipna=True) > 0]
num_df = num_df.fillna(num_df.mean())

# Standardisation
x_scaled = (num_df - num_df.mean()) / num_df.std(ddof=0)

# PCA
n_comp = min(5, x_scaled.shape[1])
pca = PCA(n_components=n_comp)
pca_res = pca.fit_transform(x_scaled)


# --- 2. Nuage de points (projection individus avec couleurs et labels) ---
plt.figure(figsize=(8, 6))

# Choisir variable pour couleurs
color_var = "smoker"
shape_var = "sex"

if color_var in data.columns:
    labels_color = data[color_var].astype(str).values
    unique_colors = np.unique(labels_color)
    palette = sns.color_palette("Set2", len(unique_colors))

    labels_shape = data[shape_var].astype(str).values if shape_var in data.columns else None
    markers = ["o", "s", "D", "^", "v"]  # formes possibles

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

plt.xlabel(f"Charges ({pca.explained_variance_ratio_[0]*100:.1f}%)")
plt.ylabel(f"Age ({pca.explained_variance_ratio_[1]*100:.1f}%)")
plt.title("Projection des individus")
plt.legend()
plt.grid(True)
plt.show()
