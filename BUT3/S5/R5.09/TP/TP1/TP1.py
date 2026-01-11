import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns
import scipy.stats as stats
# 1. Importation: pd est l’alias standard
data = {
    'Nom': ['Alice', 'Bob', 'Charlie', 'Diana'],
    'Filiere': ['IA', 'Big Data', 'IA', 'Big Data'],
    'Note_Stats': [16.5, 12.0, 18.0, 14.5]
}
df_etudiants = pd.DataFrame(data)
# Affichage des 5 premieres lignes
print(df_etudiants.head())
# Information sur le DataFrame
print(df_etudiants.info())

# Enregistrement pour la simulation
df_etudiants.to_csv('grades.csv', index=False)
# Lecture du fichier
df = pd.read_csv('grades.csv')
print("\nDataFrame charge a partir du CSV:")
print(df.head())

# 1. Selection d’une colonne (retourne une Serie)
notes = df['Note_Stats']
print("\nSerie des notes:\n", notes)
# 2. Selection par position (slice)
lignes_specifiques = df[1:3]
print("\nLignes 1 et 2:\n", lignes_specifiques)
# 3. Selection par position (.iloc[ligne, colonne])
note_charlie = df.iloc[2, 2]
print(f"\nNote de Charlie (index 2, colonne 2): {note_charlie}")

# 1. Filtre simple
df_ia = df[df['Filiere'] == 'IA']
print("\nEtudiants de la filiere IA:\n", df_ia)
# 2. Filtre compose (necessite & pour AND, et les parentheses)
df_ia_top = df[(df['Filiere'] == 'IA') & (df['Note_Stats'] > 15)]
print("\nEtudiants IA ayant plus de 15:\n", df_ia_top)

# 1. Resume global
print("\nResume statistique complet:\n", df.describe())
# 2. Statistiques par colonne
moyenne_notes = df['Note_Stats'].mean()
std_notes = df['Note_Stats'].std()
print(f"\nMoyenne generale: {moyenne_notes:.2f}, Ecart-type: {std_notes:.2f}")
# 3. Statistiques par groupe (methode GROUP BY)
moyenne_par_filiere = df.groupby('Filiere')['Note_Stats'].mean()
print("\nMoyenne des notes par filiere:\n", moyenne_par_filiere)

# Application : Analyse de logs
np.random.seed(42)
N = 1000

df_logs = pd.DataFrame({
    'Latence_ms': np.random.normal(50, 10, N),
    'Taux_Erreur': np.random.uniform(0.01, 0.10, N),
    'Type_Modele': np.random.choice(['Classification', 'Régression', 'Génératif'], N, p=[0.6, 0.3, 0.1]),
    'Memoire_Go': np.random.randint(2, 17, N)
})

df_alertes = df_logs[df_logs['Latence_ms'] > 65]
print(len(df_alertes))

pourcentage_alertes = len(df_alertes) / len(df_logs) * 100
print(pourcentage_alertes)

perf = df_logs.groupby('Type_Modele').agg({
    'Latence_ms': 'mean',
    'Taux_Erreur': 'std'
})
print(perf)

plt.figure(figsize=(10, 5))
sns.histplot(df_logs['Latence_ms'], kde=True)
plt.title("distribution de la latence ms")
plt.show()

plt.figure(figsize=(8, 6))
corr = df_logs.select_dtypes(include=np.number).corr()
sns.heatmap(corr, annot=True, cmap='coolwarm')
plt.title("matrice de correlation")
plt.show()

stat, p_value = stats.shapiro(df_logs['Latence_ms'])
print(f"\nShapiro-Wilk: {stat}, {p_value}")
if p_value < 0.05:
    print("pas une loi Normale")
else:
    print("loi Normale")

confidence = 0.99
data_erreur = df_logs['Taux_Erreur']
mean_err = np.mean(data_erreur)
sem_err = stats.sem(data_erreur)
intervalle = stats.t.interval(confidence, len(data_erreur)-1, loc=mean_err, scale=sem_err)
print(f"\nTaux erreur: {intervalle}")


df_logs['Version_Modele'] = np.random.choice(['V1', 'V2'], N)
df_logs.loc[df_logs['Version_Modele'] == 'V2', 'Taux_Erreur'] *= 0.8 

plt.figure(figsize=(8, 6))
sns.boxplot(x='Version_Modele', y='Taux_Erreur', data=df_logs)
plt.title("Comparaison taux erreur V1 et V2")
plt.show()

v1 = df_logs[df_logs['Version_Modele'] == 'V1']['Taux_Erreur']
v2 = df_logs[df_logs['Version_Modele'] == 'V2']['Taux_Erreur']

t_stat, p_val_ttest = stats.ttest_ind(v1, v2)
print(f"\nTest de student: {t_stat}, {p_val_ttest}")