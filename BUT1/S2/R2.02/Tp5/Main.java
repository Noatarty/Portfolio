package controleur;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modele.Donnees;
import modele.Employe;
import vue.FenListeEmployes;
import vue.FenModifierEmploye;
import vue.FenNouvelEmploye;

public class Main extends Application {
	static private FenListeEmployes fListe;
	static private FenNouvelEmploye fNouvel;
	static private FenModifierEmploye fModifier;

	@Override
	public void start(Stage primaryStage) throws Exception {
		Donnees.chargementDonnees();
		fListe = new FenListeEmployes();
		fNouvel = new FenNouvelEmploye();
		fModifier = new FenModifierEmploye();
		fListe.show();
	}
	
	//////////////////////////////////////////////////////////
	// Gestion des fenêtres
	//////////////////////////////////////////////////////////
	static public void ouvrirNouvelEmploye() {

	}
	
	static public void ouvrirModifierEmploye(Employe e) {

	}
	
	static public void fermerNouvelEmploye() {

	}
	
	static public void fermerModifierEmploye() {

	}
	
	static public void fermerAppli() {

	}
	
	//////////////////////////////////////////////////////////
	// Mise à jour des données
	//////////////////////////////////////////////////////////
	static public void supprimerEmploye(Employe e) {
		// enregistrer la suppression
		

	}
	static public void validerNouvelEmploye(int mat, String nom, String poste, int sup, int annee, int mois, int jour, float sal, float prime, int dpt) {
    	String date = annee+"/"+mois+"/"+jour;
    	
    }
	
	static public void validerModifierEmploye(int mat, String nom, String poste, int sup, int annee, int mois, int jour, float sal, float prime, int dpt) {
    	String date = annee+"/"+mois+"/"+jour;
    	
    }

	
	
//	static public void enregistrerNouvelEmploye(Employe e) {	
//		Donnees.ajouterEmploye(e);
//		fNouvel.close();
//	}
	
	static public void modifierEmploye(Employe e) {	
		Donnees.modifierEmploye(e);
		fModifier.close();
	}
	
	
	public static void main(String[] args) {
		Application.launch(args);

	}
}
