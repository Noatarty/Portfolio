import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns
from statsmodels.tsa.holtwinters import ExponentialSmoothing
import warnings

warnings.filterwarnings('ignore')

df = pd.read_csv('train.csv')

# Conversion des dates
df['Order Date'] = pd.to_datetime(df['Order Date'], dayfirst=True, errors='coerce')
df.sort_values('Order Date', inplace=True)

# Verification qualite
print(f"Periode d'analyse : {df['Order Date'].min()} à {df['Order Date'].max()}")
print(f"Nombre de doublons : {df.duplicated().sum()}")


# MODELE A : Analyse ABC
# On regroupe par produit
product_stats = df.groupby('Product Name')['Sales'].sum().reset_index()
product_stats.sort_values('Sales', ascending=False, inplace=True)

# Calculs cumulés et pourcentages
total_sales = product_stats['Sales'].sum()
product_stats['Cumulative Sales'] = product_stats['Sales'].cumsum()
product_stats['Cumulative %'] = 100 * product_stats['Cumulative Sales'] / total_sales

# Segmentation
def get_abc_category(perc):
    if perc <= 80: return 'A'
    elif perc <= 95: return 'B'
    else: return 'C'

product_stats['Category'] = product_stats['Cumulative %'].apply(get_abc_category)

# Resumé pour l'affichage
abc_summary = product_stats.groupby('Category').agg({
    'Product Name': 'count',
    'Sales': 'sum'
})
abc_summary['% Products'] = (abc_summary['Product Name'] / len(product_stats)) * 100
abc_summary['% Sales'] = (abc_summary['Sales'] / total_sales) * 100

print("\n--- RÉSULTATS ANALYSE ABC ---")
print(abc_summary)

# MODELE B : Prévision (Holt-Winters)
# On regroupe les ventes par mois
monthly_sales = df.set_index('Order Date').resample('M')['Sales'].sum()

# Séparation Entrainement / Test (On garde les 12 derniers mois pour tester la précision)
train = monthly_sales.iloc[:-12]
test = monthly_sales.iloc[-12:]

# Création du modèle (Tendance additive + Saisonnalité additive sur 12 mois)
# On choisi 'additive' plutot que 'multiplicative' au cas ou les données contiennent des zéros ou valeurs faibles
model = ExponentialSmoothing(train, trend='add', seasonal='add', seasonal_periods=12).fit()

# Prévision sur la période de test
forecast = model.forecast(steps=12)

# Affichage des résultats
plt.figure(figsize=(16, 10))

# Graphique 1 : ABC
plt.subplot(2, 2, 1)
colors = {'A': '#2ecc71', 'B': '#f1c40f', 'C': '#e74c3c'}
sns.barplot(x=abc_summary.index, y=abc_summary['% Sales'], palette=colors)
plt.title("Répartition du Chiffre d'Affaires par Classe (ABC)", fontsize=14)
plt.ylabel("% du CA Global")
plt.xlabel("Catégorie")
# Ajout des étiquettes
for i, row in enumerate(abc_summary.itertuples()):
    plt.text(i, row._4 + 1, f"{row._4:.1f}% CA\n({row._3:.1f}% des Ref)", ha='center', fontweight='bold')

# Graphique 2 : Tendance Globale
plt.subplot(2, 2, 2)
plt.plot(monthly_sales.index, monthly_sales.values, label='Ventes Historiques', color='#34495e')
plt.title("Historique des Ventes Mensuelles (2015-2018)", fontsize=14)
plt.grid(True, alpha=0.3)
plt.xticks(rotation=45)

# Graphique 3 : Comparaison Prévision vs Réalité
plt.subplot(2, 1, 2)
plt.plot(train.index, train.values, label='Données d\'Entraînement', color='gray', alpha=0.6)
plt.plot(test.index, test.values, label='Réalité (2018)', color='green', linewidth=2)
plt.plot(test.index, forecast.values, label='Prévision Modèle (Holt-Winters)', color='red', linestyle='--', linewidth=2)
plt.title("Validation du Modèle de Prévision : Prédictions vs Réalité", fontsize=14)
plt.legend()
plt.grid(True, alpha=0.3)

plt.tight_layout()
plt.show()