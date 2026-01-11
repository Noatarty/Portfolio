import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.application.Application;

public class Couleur extends Application{
	private Label		message				= new Label("Choisissez une couleur :");
	private RadioButton	rbBleu				= new RadioButton("Bleu");
	private RadioButton	rbVert				= new RadioButton("Vert");
	private RadioButton	rbJaune				= new RadioButton("Jaune");
	private RadioButton	rbOrange			= new RadioButton("Orange");
	private Rectangle	rectangle			= new Rectangle();
	private Button		bnOK				= new Button("OK");
	private Button		bnAnnuler			= new Button("Annuler");
	private BorderPane 	racine 				= new BorderPane();
	private VBox 		zoneBoutonsRadio 	= new VBox();
	private HBox 		zoneBoutons 		= new HBox();
	private ToggleGroup groupe 				= new ToggleGroup();
	
	public void start(Stage fenetre){ 
		fenetre.setTitle("Choix d'une couleur");
		fenetre.setResizable(false);
		fenetre.setWidth(280);
		fenetre.setHeight(250);
		
		Scene laScene = new Scene(creerSceneGraph());
		fenetre.setScene(laScene);
		fenetre.show();
	}
		
	private Parent creerSceneGraph(){	
		groupe.getToggles().addAll(rbBleu, rbVert, rbJaune, rbOrange);
		groupe.selectToggle(rbBleu);   //ou bien rbBleu.setSelected(true);
		zoneBoutonsRadio.setPadding(new Insets(10));
		zoneBoutonsRadio.setSpacing(20);
		zoneBoutonsRadio.getChildren().addAll(rbBleu, rbVert, rbJaune, rbOrange);
		
		rectangle.setWidth(120);
		rectangle.setHeight(120);
		rectangle.setFill(Color.BLUE);
		
		bnAnnuler.setPrefWidth(80);
		bnOK.setPrefWidth(80);
		
		zoneBoutons.setPadding(new Insets(10));
		zoneBoutons.setSpacing(10);
		zoneBoutons.setAlignment(Pos.CENTER_RIGHT);
		zoneBoutons.getChildren().addAll(bnOK, bnAnnuler);
		
		racine.setPadding(new Insets(10));
		racine.setTop(message);
		racine.setLeft(zoneBoutonsRadio);
		racine.setCenter(rectangle);
		racine.setBottom(zoneBoutons);
		return racine;								
	}
	
	static public void main(String args[]) {
		Application.launch();
	}
}
