import pandas as pd
import matplotlib.pyplot as plt

#1. Charger le jeu de données dans une structure de données Pandas (DataFrame).
df = pd.read_csv('ventes_mensuelles.csv')

#2. Afficher les premières lignes du DataFrame pour inspecter les données.
print(df.head())

#3. Combien de lignes et de colonnes contient le DataFrame ?
print(df.shape[0])
print(df.shape[1])

#4. Vérifier s'il y a des valeurs manquantes dans le jeu de données et traiter ces valeurs le cas échéant.
print(df.isnull().sum())
df = df.dropna()

#5. Calculer le chiffre d'affaires total réalisé par l'entreprise sur l'ensemble du jeu de données.
ca_total = df['chiffre_affaires'].sum()
print(ca_total)

#6. Quel est le produit le plus vendu ? Combien d'unités ont été vendues ?
produit_plus_vendu = df.groupby('nom_produit')['quantite_vendue'].sum().idxmax()
quantite_max = df.groupby('nom_produit')['quantite_vendue'].sum().max()
print(produit_plus_vendu)
print(quantite_max)

#7. Créer une nouvelle colonne "Mois" dérivée de la colonne de dates et regrouper les données par mois. Calculer le chiffre d'affaires moyen par mois.
df['date_vente'] = pd.to_datetime(df['date_vente'])
df['Mois'] = df['date_vente'].dt.to_period('M')
ca_moyen_mois = df.groupby('Mois')['chiffre_affaires'].mean()
print(ca_moyen_mois)

#8. Afficher les ventes mensuelles moyennes pour chaque produit sous forme de graphique.
ventes_mensuelles = df.groupby(['Mois', 'nom_produit'])['quantite_vendue'].mean().unstack()
ventes_mensuelles.plot(kind='bar', figsize=(16,9))
plt.title('ventes mensuelles moyennes par produit')
plt.ylabel('quantitée vendue(moyenne)')
plt.xlabel('Mois')
plt.tight_layout()
plt.show()

#9. Trouver les dates où le chiffre d'affaires est supérieur à la moyenne mensuelle et les afficher.
ca_mensuel = df.groupby('Mois')['chiffre_affaires'].transform('mean')
dates_sup_moyenne = df[df['chiffre_affaires'] > ca_mensuel]['date_vente']
print(dates_sup_moyenne.unique())

#10. Exporter le DataFrame nettoyé dans un nouveau fichier CSV.
df.to_csv('ventes_mensuelles_nettoye.csv', index=False)