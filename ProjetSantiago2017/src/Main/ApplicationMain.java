package Main;
import java.io.IOException;
import java.net.URL;
import ControlleurSantiago.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import BeanSantigao.*;


public class ApplicationMain extends Application{
	
	

	private Stage primaryStage;
	private AnchorPane rootLayout;
	private AcceuilController controller;

	public static void main(String[] args) {
		JeuSantiago jeuSantiago=new JeuSantiago();
		launch(args);
		jeuSantiago.demarrerServeur();
		
	}
	
	@Override
	public void start(Stage primaryStage) {

		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("SANTIAGO");
		initRootLayout();
	}
// cette méthode permet de lancer le jeu 
	public void initRootLayout() {
		try {
		
			FXMLLoader loader = new FXMLLoader();
			URL url =ApplicationMain.class.getResource("../VueSantiago/Acceuil.fxml");
			loader.setLocation(url);
			rootLayout = (AnchorPane) loader.load();
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
			controller = loader.getController();
			controller.setPrimaryStage(primaryStage);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
