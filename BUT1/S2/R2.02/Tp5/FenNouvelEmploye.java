package vue;

import java.io.IOException;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


public class FenNouvelEmploye extends Stage {
	
	private CtrlNouvelEmploye ctrl;

	public FenNouvelEmploye() throws IOException {
		this.setTitle("Nouvel employé");
		this.setResizable(false);
		Scene laScene = new Scene(creerSceneGraph());
		this.setScene(laScene);
	}

	private Pane creerSceneGraph() throws IOException {
     	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("nouvelEmploye.fxml"));
        Pane root = loader.load();
        ctrl = loader.getController();
     	return root;
	}
	
	public void effacer() {
		ctrl.effacer();
	}

}

