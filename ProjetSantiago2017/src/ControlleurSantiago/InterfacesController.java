package ControlleurSantiago;
import BeanSantigao.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class InterfacesController implements Initializable {

	protected Stage box;
	protected Parent root;
	protected JeuSantiago jeuSantiago;
	
	public void setOwner(Stage owner) {
		box.initOwner(owner);
	}
	public void setTitle(String title) {
		box.setTitle(title);
	}
	public void setRoot(Parent root) {
		this.root = root;
	}

	public void setLogicController(JeuSantiago vr) {
		this.jeuSantiago = vr;
	}
	public void showAndWait() {
		box.setScene(new Scene(root));
		box.showAndWait();
	}

	@FXML
	public void initialize(){
		setLogicController(JeuSantiago.getSantiago());
	}

	public static <T extends InterfacesController> T initDialog(String urlView,Class<T> controlClass, Stage
			owner)
	{
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(InterfacesController.class.getResource(urlView));
		T controller = null;

		try {
			Parent root =fxmlLoader.load();
			controller = fxmlLoader.getController();
			controller.setRoot(root);
			controller.setOwner(owner);
			
		} catch (NullPointerException | IOException e) {
			e.printStackTrace();
		}
		return controller;
	}

	

}
