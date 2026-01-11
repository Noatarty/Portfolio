
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.application.Application;

public class Calculette extends Application{
	private final String lesLibelles[] 	= {"7","8","9","+","4","5","6","-","1","2","3","x","C","0","=","/"};
	private Button 		 lesBoutons[]	= new Button[lesLibelles.length];
	private TextField 	 ecran 			= new TextField("0");

	public void start(Stage fenetre){ 
		fenetre.setTitle("Calculette"); 
		fenetre.setResizable(true);
		fenetre.setMinWidth(200);
		fenetre.setMinHeight(200);
		Scene laScene = new Scene(creerSceneGraph());
		fenetre.setScene(laScene);
		fenetre.sizeToScene();
		fenetre.show();
	}
	
	public Pane creerSceneGraph(){
		VBox root = new VBox();					// racine du Scene Graph : 2 parties (écran et clavier) "empilées" l'une sur l'autre
		HBox partieHaute = new HBox();			// la zone de l'écran de la calculette
		GridPane partieBasse = new GridPane();	// la zone du "clavier" de la calculette
		
		// réalisation de l'écran:  un TextField dans une HBox pour bien gérer son redimensionnement
		partieHaute.setPadding(new Insets(10));
		ecran.setPrefWidth(210);
		ecran.setAlignment(Pos.CENTER_RIGHT);
		ecran.setEditable(false);
		partieHaute.setAlignment(Pos.CENTER);
		HBox.setHgrow(ecran, Priority.ALWAYS);
		partieHaute.getChildren().add(ecran);
		
		// réalisation du clavier : 16 boutons en mosaïque 4x4
		partieBasse.setHgap(10);
		partieBasse.setVgap(10);
		for(int i = 0; i<lesBoutons.length ; i++){
			lesBoutons[i] = new Button(lesLibelles[i]);
			lesBoutons[i].setMaxWidth(Double.MAX_VALUE);
			lesBoutons[i].setMaxHeight(Double.MAX_VALUE);
			GridPane.setHgrow(lesBoutons[i], Priority.ALWAYS);
			GridPane.setVgrow(lesBoutons[i], Priority.ALWAYS);
			partieBasse.add(lesBoutons[i], i%4, i/4 );		
		}
		VBox.setVgrow(partieBasse, Priority.ALWAYS);
		
		root.setPadding(new Insets(10));
		root.getChildren().add(partieHaute);
		root.getChildren().add(partieBasse);

		return root;
	}
	
	static public void main(String args[]) {
		Application.launch();
	}
	
}