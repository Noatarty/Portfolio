
import javafx.application.Application;
import javafx.beans.binding.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class FenTableEmployes extends Application {
	// les données
	ObservableList<Employe> liste = FXCollections.observableArrayList();
	
	// les composants de la fenÃªtre
	private AnchorPane  		racine	= new AnchorPane();
	private TableView<Employe> 	tableEmployes= new TableView<Employe>();
	private Button 				bnAjouter 	= new Button("Ajouter");
	private Button 				bnSupprimer = new Button("Supprimer");

	// constructeur : initialisation de la fenetre
	public void start(Stage f){
		
		liste.add(new Employe(7369,"LECLERC","SECRETAIRE", 20) );
		liste.add(new Employe(7499,"BIRAUD","COMMERCIAL", 30) );
		liste.add(new Employe(7521,"BERGER","COMMERCIAL", 30) );
		liste.add(new Employe(7566,"MERCIER","DIRECTEUR", 20) );
		liste.add(new Employe(7654,"MARTIN","COMMERCIAL", 30) );
		liste.add(new Employe(7698,"NOIRET","DIRECTEUR", 30) );
		liste.add(new Employe(7782,"LESAGE","DIRECTEUR", 10) );
		
		f.setTitle("Liste des employés");
		f.setMinWidth(300);
		f.setMinHeight(300);
		f.setResizable(true);
		f.setScene(new Scene(creerSceneGraph()));
		f.show();
	}
	
	private Pane creerSceneGraph() {
		// création des colonnes
		TableColumn<Employe,Integer> colonne1 = new TableColumn<Employe,Integer>("Matricule");
		colonne1.setCellValueFactory(new PropertyValueFactory<Employe,Integer>("matricule"));
		tableEmployes.getColumns().add(colonne1);
		
		// A FAIRE : creer les trois autres colonnes du TableView
		
		
		
		
		// A FAIRE : lier le TableView a la liste observable "liste"
		
		
		
		
		tableEmployes.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		
		// detection et traitement des evenements
		bnAjouter.setPrefWidth(100);
		bnAjouter.setOnAction(e -> liste.add(new Employe(111, "Clint Eastwood", "INGENIEUR", 10)));
		
		bnSupprimer.setPrefWidth(100);
		bnSupprimer.setOnAction(e -> liste.remove(tableEmployes.getSelectionModel().getSelectedIndex() ));
			
		// creation du Scene graph
		AnchorPane.setTopAnchor(bnAjouter, 10.0);
		AnchorPane.setRightAnchor(bnAjouter, 10.0);
		AnchorPane.setTopAnchor(bnSupprimer, 50.0);
		AnchorPane.setRightAnchor(bnSupprimer, 10.0);
		AnchorPane.setTopAnchor(tableEmployes, 10.0);
		AnchorPane.setLeftAnchor(tableEmployes, 10.0);
		AnchorPane.setRightAnchor(tableEmployes, 150.0);
		AnchorPane.setBottomAnchor(tableEmployes, 10.0);	
		racine.getChildren().addAll(tableEmployes, bnAjouter, bnSupprimer);
		return racine;
	}
	
	
	static public void main(String args[]) {
		Application.launch();
	}
}
