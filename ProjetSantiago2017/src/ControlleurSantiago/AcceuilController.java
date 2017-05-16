package ControlleurSantiago;
import BeanSantigao.*;
import java.net.MalformedURLException;

import java.net.URL;
import java.rmi.Naming;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;
import ControlleurSantiago.*;
import ServiceInterfaces.FonctionnaliteInterface;
import BeanSantigao.Players;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AcceuilController extends InterfacesController {
	
	 static final String PLATEAU="../VueSantiago/Plateau.fxml";
	private static final String COMMENCER="../VueSantiago/DebuterJeu.fxml";
	private static final String INSCRIPTION="../VueSantiago/Connexion.fxml";
	

	private Stage primaryStage;
	private ConnexionController connexion;
	private PlateauController plateau;
	private DebuterJeuController debuter;
	
	@FXML 
	private Button play;
	
	 Players player;
	
	@FXML
	void exit(ActionEvent event) {
		Platform.exit();
	}
	
	public void initialize(URL location, ResourceBundle resources) {
		jeuSantiago = JeuSantiago.getSantiago();
		box = new Stage(StageStyle.DECORATED);
		box.initModality(Modality.WINDOW_MODAL);
		box.setTitle("ACCEUIL");			
					
					play.setOnAction(event->{
						
						if(jeuSantiago.getClient()==null){
		
							connexion = InterfacesController.initDialog(
								INSCRIPTION, ConnexionController.class,
								primaryStage);
						connexion.showAndWait();
						}
						else if(jeuSantiago.getClient()!=null){
							
							String host=jeuSantiago.getClient().getHost();
							FonctionnaliteInterface server;
							try {
								server = (FonctionnaliteInterface)Naming.lookup("rmi://"+host+":45000/santiago");
							boolean commence=server.getStart();
							int tour=server.getTour();
							int phase=server.getPhase();
								
							if(commence && jeuSantiago.getClient().getPlayer().isOnline()){
							plateau = InterfacesController.initDialog(PLATEAU, PlateauController.class,primaryStage);
							box.close();
							plateau.showAndWait();
						}
							else if(!commence){
								debuter = DebuterJeuController.initDialog(
										COMMENCER, DebuterJeuController.class,
										primaryStage);
								debuter.showAndWait();
						}
							else{
								plateau = InterfacesController.initDialog(PLATEAU, PlateauController.class,primaryStage);
								box.close();
								plateau.showAndWait();
						}	
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						}
						
					});
			
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

}
