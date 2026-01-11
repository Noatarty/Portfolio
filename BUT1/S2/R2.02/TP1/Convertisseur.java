import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.application.Application;
 	  
public class Convertisseur extends Application {
	private final double tauxDeChange 		= 1.13;
	private ArrayList<KeyCode> carAutorises = new ArrayList<KeyCode>();
	
	private VBox 		racine 			= new VBox();
	private HBox 		haut 			= new HBox();
	private TextField 	txtEuros 		= new TextField();
	private TextField 	txtDollar		= new TextField();
	private Label 		symboleEuro 	= new Label("€");
	private Label 		symboleDollar	= new Label("$");
	private Label 		message			= new Label();
	private Button 		bnConvertir 	= new Button("Convertir >");
	
	public void start(Stage fenetre){ 
		// liste des caractères autorisés
		carAutorises.add(KeyCode.DIGIT0);
		carAutorises.add(KeyCode.DIGIT1);
		carAutorises.add(KeyCode.DIGIT2);
		carAutorises.add(KeyCode.DIGIT3);
		carAutorises.add(KeyCode.DIGIT4);
		carAutorises.add(KeyCode.DIGIT5);
		carAutorises.add(KeyCode.DIGIT6);
		carAutorises.add(KeyCode.DIGIT7);
		carAutorises.add(KeyCode.DIGIT8);
		carAutorises.add(KeyCode.DIGIT9);
		carAutorises.add(KeyCode.NUMPAD0);
		carAutorises.add(KeyCode.NUMPAD1);
		carAutorises.add(KeyCode.NUMPAD2);
		carAutorises.add(KeyCode.NUMPAD3);
		carAutorises.add(KeyCode.NUMPAD4);
		carAutorises.add(KeyCode.NUMPAD5);
		carAutorises.add(KeyCode.NUMPAD6);
		carAutorises.add(KeyCode.NUMPAD7);
		carAutorises.add(KeyCode.NUMPAD8);
		carAutorises.add(KeyCode.NUMPAD9);
		carAutorises.add(KeyCode.PERIOD);
		carAutorises.add(KeyCode.BACK_SPACE);
		carAutorises.add(KeyCode.SHIFT);
		carAutorises.add(KeyCode.DELETE);
		
		fenetre.setTitle("Convertisseur"); 
		fenetre.setResizable(false);
		Scene laScene = new Scene(creerSceneGraph());
		fenetre.setScene(laScene);
		fenetre.sizeToScene();
		fenetre.show();
	}
	
	private Pane creerSceneGraph(){
		txtDollar.setEditable(false);
		message.setTextFill(Color.RED);
			
		haut.setSpacing(10);
		haut.setPadding(new Insets(10));
		haut.setAlignment(Pos.CENTER);
		haut.getChildren().addAll(txtEuros, symboleEuro,bnConvertir, txtDollar, symboleDollar);
		
		racine.setPadding(new Insets(10));
		racine.getChildren().addAll(haut, message);
		racine.setAlignment(Pos.CENTER);
	
		return racine;
	}
	
	
	
	
	
	private boolean isNumeric(String str) {
		// renvoie true si la chaine str correspond à un nombre, éventuellement à virgule
		return str.matches("\\d+(\\.\\d+)?");  //match a number with optional decimal.
	}
	
	static public void main(String args[]) {
		Application.launch();
	}
}