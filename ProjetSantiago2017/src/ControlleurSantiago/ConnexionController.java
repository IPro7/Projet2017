package ControlleurSantiago;
import ServiceInterfaces.*;

import java.net.URL;
import java.rmi.Naming;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;
import BeanSantigao.*;
import ReseauClient_Serveur.*;
import ServiceInterfaces.FonctionnaliteInterface;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ReseauClient_Serveur.*;



public class ConnexionController extends InterfacesController {
	private Stage primaryStage;
	private static final String DEBUTER="../VueSantiago/DebuterJeu.fxml";
	private DebuterJeuController Debuter;
	
	@FXML
	private Button joindre;
	@FXML
	private Button annuler;
	
	@FXML
	private TextField pseudo;
	
	@FXML
	private TextField adresse;
	
	@FXML
	private ChoiceBox<String> couleur;
	
	Clients client;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		jeuSantiago = JeuSantiago.getSantiago();
		
		box = new Stage(StageStyle.DECORATED);
		box.initModality(Modality.WINDOW_MODAL);
		box.setTitle("LOGIN PLAYERS");
		// cette action permet aux joueurs de rejoindre leurs adversaire 
		joindre.setOnAction(event -> {
			
			if (adresse.getText().isEmpty()&& pseudo.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "Veuillez remplir Tous les champs");	
			}
			else if (pseudo.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "Entrer votre pseudo");
			}
			else if (adresse.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "Entrer l'adresse de votre serveur");	
			}
			else if(pseudo !=null && adresse !=null){
				// Si  le joueur est deja connecté
					try {
						if(jeuSantiago.getClient()!=null){
							String host=jeuSantiago.getClient().getHost();
							FonctionnaliteInterface server = (FonctionnaliteInterface)Naming.lookup("rmi://"+host+":45000/santiago");
							boolean commence=server.getStart();
							if(commence){
								JOptionPane.showMessageDialog(null, "Impossible de vous connecter la partie sur ce réseau à déjà commencé");
								}
							else if(server.getClient().size()==5){
								JOptionPane.showMessageDialog(null, "Il y a déja assez de joueurs pouur cette partie");
								
							}
						else{
								box.close();
								Debuter = DebuterJeuController.initDialog(
								DEBUTER, DebuterJeuController.class,
									primaryStage);
								Debuter.showAndWait();}
								
							}
						//==null
						else{
						client= new Clients(adresse.getText(),pseudo.getText());
						client.ConnexionClient();
						jeuSantiago.setClient(client);
						box.close();
						String host=jeuSantiago.getClient().getHost();
						FonctionnaliteInterface server = (FonctionnaliteInterface)Naming.lookup("rmi://"+host+":45000/santiago");
						boolean commence=server.getStart();
						if(commence){
							JOptionPane.showMessageDialog(null, "Impossible de vous connecter la partie sur ce réseau à déjà commencé");
							}
						else if(server.getClient().size()==5){
							JOptionPane.showMessageDialog(null, "Il y a déja assez de joueurs pouur cette partie");
							
						}
			else{
						box.close();							
						Debuter = DebuterJeuController.initDialog(DEBUTER, DebuterJeuController.class,
								primaryStage);
						Debuter.showAndWait();
						}
							
						}
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
				
				
			});
	}


}
