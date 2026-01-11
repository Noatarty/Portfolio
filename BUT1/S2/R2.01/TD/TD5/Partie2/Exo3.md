+---------------------------+      1..*        +---------------------------------+
|       Vehicule            |<-----------------|            Entreprise           |
+---------------------------+                  +---------------------------------+
| - immatriculation: string |                  | - siret: string                 |
| - marque: string          |                  | - nom: string                   |
| - entreprise: Entreprise  |<---------------->| - vehicules: Vehicule[]         |
+---------------------------+                  +---------------------------------+
| + obtenirImmatriculation()|                  | + ajouterVehicule(v: Vehicule)  |
| + obtenirMarque()         |                  | + supprimerVehicule(v: Vehicule)|
+---------------------------+                  | + attribuerVehiculeFonction(v:  |
                                               |Voiture, employe: Employe,       |
                                               |dateAttribution: Date)           |
                                               | + retirerAttributionVehicule-   |
                                               |   -Fonction(v: Voiture)         |
                                               +---------------------------------+

                                   +----------------------------+
                                   |        Voiture             |
                                   +----------------------------+
                                   | - nombrePortes: int        |
                                   | - employeAttribue: Employe |
                                   +----------------------------+
                                   | + obtenirNombrePortes()    |
                                   +----------------------------+

                                   +---------------------------+
                                   |       Camion              |
                                   +---------------------------+
                                   | - chargeMaximale: float   |
                                   +---------------------------+
                                   | + obtenirChargeMaximale() |
                                   | + chargerMarchandises()   |
                                   | + dechargerMarchandises() |
                                   +---------------------------+

                                   +----------------------+
                                   |       Employe        |
                                   +----------------------+
                                   | - identifiant: int   |
                                   | - nom: string        |
                                   | - prenom: string     |
                                   +----------------------+
                                   | +obtenirIdentifiant()|
                                   | + obtenirNom()       |
                                   | + obtenirPrenom()    |
                                   +----------------------+
