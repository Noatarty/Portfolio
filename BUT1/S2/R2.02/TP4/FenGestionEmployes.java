import javafx.beans.binding.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.application.Application;

public class FenGestionEmployes extends Application {
	// les données
	ObservableList<Employe> liste = FXCollections.observableArrayList();
	
	// les composants de la fenÃªtre
	private VBox				racine			= new VBox();
	private GridPane			zoneDetail		= new GridPane();
	private AnchorPane  		zoneTable		= new AnchorPane();
	private TableView<Employe> 	tableEmployes	= new TableView<Employe>();
	private Button 				bnAjouter 		= new Button("Ajouter");
	private Button 				bnSupprimer 	= new Button("Supprimer");
	private Button 				bnFermer 		= new Button("Fermer");
	private Label 				lblMatricule	= new Label("Matricule (*) :");
	private Label 				lblNom			= new Label("Nom employé (*) :");
	private Label 				lblPoste		= new Label("Poste :");
	private Label 				lblDepartement	= new Label("Département (*) :");
	private TextField			txtMatricule	= new TextField();
	private TextField			txtNom			= new TextField();
	private TextField			txtPoste		= new TextField();
	private TextField			txtDepartement	= new TextField();
	
	// constructeur : initialisation de la fenetre et des données
	public void start(Stage f){
		liste.add(new Employe(7369,"LECLERC","SECRETAIRE", 20) );
		liste.add(new Employe(7499,"BIRAUD","COMMERCIAL", 30) );
		liste.add(new Employe(7521,"BERGER","COMMERCIAL", 30) );
		liste.add(new Employe(7566,"MERCIER","DIRECTEUR", 20) );
		liste.add(new Employe(7654,"MARTIN","COMMERCIAL", 30) );
		liste.add(new Employe(7698,"NOIRET","DIRECTEUR", 30) );
		liste.add(new Employe(7782,"LESAGE","DIRECTEUR", 10) );
		
		f.setTitle("Liste des employés");
		f.sizeToScene();
		f.setResizable(true);
		f.setScene(new Scene(creerSceneGraph()));
		f.show();
	}
	
	private Pane creerSceneGraph() {
		tableEmployes.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
							
		// A FAIRE : associer la liste au TableView
		
		
		// creation du TableView : 4 colonnes
		TableColumn<Employe,Integer> colonne1 = new TableColumn<Employe,Integer>("Matricule");
		colonne1.setCellValueFactory(new PropertyValueFactory<Employe,Integer>("matricule"));
		tableEmployes.getColumns().add(colonne1);		
		TableColumn<Employe, String> colonne2 = new TableColumn<Employe,String>("Nom");
		colonne2.setCellValueFactory(new PropertyValueFactory<Employe, String>("nom"));
		tableEmployes.getColumns().add(colonne2);
		TableColumn<Employe, String> colonne3 = new TableColumn<Employe,String>("Poste");
		colonne3.setCellValueFactory(new PropertyValueFactory<Employe, String>("poste"));
		tableEmployes.getColumns().add(colonne3);
		TableColumn<Employe,Integer> colonne4 = new TableColumn<Employe,Integer>("Dépt");
		tableEmployes.getColumns().add(colonne4);
		
		// A FAIRE : en cas de changement d'élément sélectionné dans la table (clic sur le
		// TableView) actualiser les 4 champs de la zone "Detail"
		tableEmployes.setOnMouseClicked(e -> {
			
			
			
		});
		
		bnAjouter.setPrefWidth(100);
		
		// clic sur le bouton Ajouter
		bnAjouter.setOnAction(e -> liste.add(new Employe(
				Integer.parseInt(txtMatricule.getText()), 
				txtNom.getText(), 
				txtPoste.getText(), 
				Integer.parseInt(txtDepartement.getText())) )
		);
		
		// A FAIRE : griser le bouton Ajouter s'il manque une donnée obligatoire
		
		
		
		bnSupprimer.setPrefWidth(100);
		
		// A FAIRE : programmer le clic sur le bouton Supprimer
		
		
		
		
		// A FAIRE : griser le bouton Supprimer si aucune sélection
		
		
		
		
		// clic sur le bouton Fermer
		bnFermer.setPrefWidth(100);
		bnFermer.setOnAction(e -> System.exit(0)); 
		
		// creation du Scene graph
		AnchorPane.setTopAnchor(tableEmployes, 10.0);
		AnchorPane.setLeftAnchor(tableEmployes, 10.0);
		AnchorPane.setRightAnchor(tableEmployes, 40.0);
		AnchorPane.setBottomAnchor(tableEmployes, 10.0);
		zoneTable.getChildren().add(tableEmployes);
		zoneDetail.addRow(0,  lblMatricule, txtMatricule, bnAjouter);
		zoneDetail.addRow(1,  lblNom, txtNom, bnSupprimer);
		zoneDetail.addRow(2,  lblPoste, txtPoste);
		zoneDetail.addRow(3,  lblDepartement, txtDepartement, bnFermer);
		zoneDetail.setHgap(10);
		zoneDetail.setVgap(10);
		zoneDetail.setPadding(new Insets(10));
		racine.getChildren().addAll(zoneTable, zoneDetail);
		return racine;
	}
	
	
	static public void main(String args[]) {
		Application.launch();
	}
}
