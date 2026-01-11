import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns
from sklearn.decomposition import PCA
import prince 


# --- Fonctions utilitaires ---
def count_pieces_moves(moves_str):
    if not moves_str:
        return 0, 0, 0, 0

    moves = re.split(r"\d+\.\s*", moves_str)
    moves = [m.strip() for m in moves if m.strip()]

    white_king = black_king = white_queen = black_queen = 0

    for move in moves:
        parts = move.split()
        if len(parts) >= 1:
            w = parts[0]
            if w.startswith("K") or w.startswith("O-"):
                white_king += 1
            if w.startswith("Q"):
                white_queen += 1
        if len(parts) >= 2:
            b = parts[1]
            if b.startswith("K") or b.startswith("O-"):
                black_king += 1
            if b.startswith("Q"):
                black_queen += 1

    return white_king, black_king, white_queen, black_queen


# --- Lecture du CSV et extraction des variables ---
results = []

with open("chessData.csv", encoding="utf-8") as f:
    reader = csv.DictReader(f)
    for row in reader:
        if not row.get("AN"):
            continue

        wk, bk, wq, bq = count_pieces_moves(row["AN"])

        results.append({
            "Event": row["Event"].strip(),
            "Result": row["Result"],
            "Opening": row["Opening"],
            "Termination": row["Termination"],
            "WhiteElo": row["WhiteElo"],
            "BlackElo": row["BlackElo"],
            "WhiteKingMoves": wk,
            "BlackKingMoves": bk,
            "WhiteQueenMoves": wq,
            "BlackQueenMoves": bq
        })


# --- 1. Création du DataFrame quantitatif ---
varQuant = {key: [dic[key] for dic in results] for key in [
    "WhiteElo", "BlackElo", "WhiteKingMoves", "BlackKingMoves", "WhiteQueenMoves", "BlackQueenMoves"
]}

df = pd.DataFrame(varQuant)
df["WhiteElo"] = df["WhiteElo"].astype(float)
df["BlackElo"] = df["BlackElo"].astype(float)


# --- 2. Standardisation ---
x_scaled = (df - df.mean()) / df.std()


# --- 3. ACP ---
pca = PCA(n_components=3)
pca_res = pca.fit_transform(x_scaled)

eig = pd.DataFrame({
    "Dimension": ["Dim"+str(x+1) for x in range(3)],
    "Valeur_propre": pca.explained_variance_,
    "%Valeur_propre": np.round(pca.explained_variance_ratio_*100,2),
    "%Cum_val_propre": np.round(np.cumsum(pca.explained_variance_ratio_)*100,2)
})

print(eig)


# --- 4. Graphique des valeurs propres ---
plt.figure(figsize=(6,4))
plt.bar(range(3), pca.explained_variance_ratio_*100)
plt.xticks(range(3), ["Dim1","Dim2","Dim3"])
plt.ylabel("% Valeur propre")
plt.xlabel("Composantes principales")
plt.title("Variance expliquée par composante")
plt.show()


# --- 5. Cercle des corrélations ---
plt.figure(figsize=(6,6))
plt.axhline(0, color='gray', lw=1)
plt.axvline(0, color='gray', lw=1)

loadings = pca.components_.T[:, :2]
texts = []

for i, var in enumerate(df.columns):
    x, y = loadings[i,0], loadings[i,1]
    plt.arrow(0, 0, x, y, color='r', alpha=0.7, head_width=0.05)
    texts.append(plt.text(x, y, var, color='b'))

adjust_text(texts)

plt.gca().add_artist(plt.Circle((0,0), 1, color='gray', fill=False, linestyle='--'))
plt.xlim(-1.1, 1.1)
plt.ylim(-1.1, 1.1)
plt.xlabel('PC1')
plt.ylabel('PC2')
plt.title('Cercle des corrélations')
plt.grid()
plt.show()


# --- 6. Projection des individus ---
pcadf = pd.DataFrame({"Dim1": pca_res[:,0], "Dim2": pca_res[:,1]})
pcadf["Event"] = [dic["Event"] for dic in results]
pcadf["Tournament"] = pcadf["Event"].apply(lambda e: "Competition" if "tournament" in e.lower() else "Non Competition")

def simplify_event(event):
    event = event.lower()
    if "blitz" in event:
        return "Blitz"
    elif "bullet" in event:
        return "Bullet"
    elif "classical" in event:
        return "Classique"
    else:
        return "Autres"

pcadf["EventType"] = pcadf["Event"].apply(simplify_event)
pc1_var = round(pca.explained_variance_ratio_[0]*100, 2)
pc2_var = round(pca.explained_variance_ratio_[1]*100, 2)


# Points moyens - Tournament
mean_points = pcadf.groupby("Tournament")[["Dim1","Dim2"]].mean().reset_index()

plt.figure(figsize=(7,7))
sns.scatterplot(data=mean_points, x="Dim1", y="Dim2", hue="Tournament", s=100, palette="Set2")

for i, row in mean_points.iterrows():
    plt.text(row["Dim1"]+0.02, row["Dim2"]+0.02, row["Tournament"], fontsize=12)

plt.xlabel(f'Dimension 1 ({pc1_var}%)')
plt.ylabel(f'Dimension 2 ({pc2_var}%)')
plt.title("Projection ACP - Moyenne Competition vs Non Competition")
plt.legend(title="Competition")
plt.grid()
plt.show()


# Points moyens - EventType
mean_points_type = pcadf.groupby("EventType")[["Dim1","Dim2"]].mean().reset_index()

plt.figure(figsize=(7,7))
sns.scatterplot(data=mean_points_type, x="Dim1", y="Dim2", hue="EventType", s=100, palette="Set1")

for i, row in mean_points_type.iterrows():
    plt.text(row["Dim1"]+0.02, row["Dim2"]+0.02, row["EventType"], fontsize=12)

plt.xlabel(f'Dimension 1 ({pc1_var}%)')
plt.ylabel(f'Dimension 2 ({pc2_var}%)')
plt.title("Projection ACP - Moyenne Types de parties")
plt.legend(title="Type de partie")
plt.grid()
plt.show()


# --- AFC : Top 10 Ouverture vs Résultat ---
pcadf["Opening"] = [dic["Opening"] for dic in results]
pcadf["Result"] = [dic["Result"] for dic in results]

top_openings = pcadf["Opening"].value_counts().head(10).index
afc_data = pcadf[pcadf["Opening"].isin(top_openings)][["Opening","Result"]]

contingency = pd.crosstab(afc_data["Opening"], afc_data["Result"])
print("Tableau de contingence :\n", contingency)

n_components_max = min(contingency.shape[0]-1, contingency.shape[1]-1)
afc = prince.CA(n_components=min(2,n_components_max), n_iter=10, copy=True, check_input=True, engine='sklearn')
afc = afc.fit(contingency)

rows = afc.row_coordinates(contingency)
cols = afc.column_coordinates(contingency)

plt.figure(figsize=(10,8))
plt.scatter(rows.iloc[:,0], rows.iloc[:,1], color='red', s=100, label='Openings')
plt.scatter(cols.iloc[:,0], cols.iloc[:,1], color='blue', s=100, label='Results')

for i, txt in enumerate(rows.index):
    plt.text(rows.iloc[i,0]+0.005, rows.iloc[i,1]+0.005, txt, color='red', fontsize=9, rotation=30)

for i, txt in enumerate(cols.index):
    plt.text(cols.iloc[i,0]+0.005, cols.iloc[i,1]+0.005, txt, color='blue', fontsize=12)

plt.xlabel('Dimension 1')
plt.ylabel('Dimension 2')
plt.title("AFC : Top 10 Ouverture vs Résultat")
plt.legend()
plt.grid()
plt.show()

inertia = afc.eigenvalues_ / afc.eigenvalues_.sum() * 100
print("\nInertie expliquée par chaque dimension (%):")
print(inertia)


# --- AFC : Event vs Termination | Result ---
pcadf["Termination"] = [dic["Termination"] for dic in results]

top_events = pcadf["Event"].value_counts().head(10).index
afc_data = pcadf[pcadf["Event"].isin(top_events)][["Event","Termination","Result"]]
afc_data["Term_Result"] = afc_data["Termination"] + " | " + afc_data["Result"]

contingency = pd.crosstab(afc_data["Event"], afc_data["Term_Result"])
print("Tableau de contingence :\n", contingency)

n_components_max = min(contingency.shape[0]-1, contingency.shape[1]-1)
afc = prince.CA(n_components=min(2,n_components_max), n_iter=10, copy=True, check_input=True, engine='sklearn')
afc = afc.fit(contingency)

rows = afc.row_coordinates(contingency)
cols = afc.column_coordinates(contingency)

plt.figure(figsize=(12,8))
plt.scatter(rows.iloc[:,0], rows.iloc[:,1], color='red', s=100, label='Events')
plt.scatter(cols.iloc[:,0], cols.iloc[:,1], color='blue', s=100, label='Termination | Result')

for i, txt in enumerate(rows.index):
    plt.text(rows.iloc[i,0]+0.01, rows.iloc[i,1]+0.01, txt, color='red', fontsize=9, rotation=30)

for i, txt in enumerate(cols.index):
    plt.text(cols.iloc[i,0]+0.01, cols.iloc[i,1]+0.01, txt, color='blue', fontsize=9, rotation=45)

plt.xlabel('Dimension 1')
plt.ylabel('Dimension 2')
plt.title("AFC : type de partie vs Termination | Result")
plt.legend()
plt.grid()
plt.show()

inertia = afc.eigenvalues_ / afc.eigenvalues_.sum() * 100
print("\nInertie expliquée par chaque dimension (%):")
print(inertia)
