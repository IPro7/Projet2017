package ControlleurSantiago;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

import BeanSantigao.JeuSantiago;
import BeanSantigao.Players;
import ServiceInterfaces.FonctionnaliteInterface;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DebuterJeuController extends InterfacesController {
	
private static final String PLATEAU="../VueSantiago/Plateau.fxml";
	
	private Stage primaryStage;
	
	private PlateauController plateau;
	
	@FXML
	private Button commencer;
	
	@FXML
	private Label instruction;
	
	@FXML
	private ImageView a1,a2,a3,a4,a5;
	
	Players player;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		jeuSantiago = JeuSantiago.getSantiago();
		box = new Stage(StageStyle.DECORATED);
		box.initModality(Modality.WINDOW_MODAL);
		box.setTitle("COMMENCER LA PARTIE");
		
	
		try {
			String host=jeuSantiago.getClient().getHost();
			FonctionnaliteInterface server=(FonctionnaliteInterface)Naming.lookup("rmi://"+host+":45000/santiago");
			for(Players p : server.getPlayers()){
			if(p.getNomJoueurs().equals(jeuSantiago.getClient().getPlayer().getNomJoueurs()))
				player=p;
			
			int taille=server.getClient().size();
			if(3>taille){
				commencer.setDisable(true);
				instruction.setText("Il n'y a pas assez de joueurs connectés pour lancer une partie");

			}
			else if(5>taille && taille>=3){

				box.close();
				commencer.setDisable(false);
				instruction.setText("Il y a assez de joueurs connectés pour commencer à jouer.\n Après 5 connections la  partie se lancera automatiquement ");
				
			}
			else if(taille==5){
				box.close();
				plateau = InterfacesController.initDialog(PLATEAU, PlateauController.class,primaryStage);
				box.close();
				plateau.showAndWait();
			}
		}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (RemoteException e) {
			e.printStackTrace();
		} 
		
		commencer.setOnAction(event->{
			try {
				String host=jeuSantiago.getClient().getHost();
				FonctionnaliteInterface server=(FonctionnaliteInterface)Naming.lookup("rmi://"+host+":45000/santiago");
				if (!server.getStart())
				{
					server.RunPart();
					server.phaseDedut();
					server.playphase();;
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			plateau = InterfacesController.initDialog(PLATEAU, PlateauController.class,primaryStage);
			box.close();
			plateau.showAndWait();});
	}

	
	
}
