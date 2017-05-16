package ControlleurSantiago;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import BeanSantigao.JeuSantiago;
import BeanSantigao.ParcellesPlateau;
import BeanSantigao.PileTuilePlantation;
import BeanSantigao.PlantationTuiles;
import BeanSantigao.Players;
import BeanSantigao.ProposMise;
import ControlleurSantiago.*;
import ServiceInterfaces.FonctionnaliteInterface;

public class PlateauController   extends InterfacesController{

	private Stage primaryStage;
	@FXML
	private ImageView C1;
	@FXML
	private ImageView C2;
	@FXML
	private ImageView C3;
	@FXML
	private ImageView C4;
	@FXML
	private ImageView C5;
	@FXML
	private ImageView C6;
	@FXML
	private ImageView C7;
	@FXML
	private ImageView C8;
	@FXML
	private ImageView C9;
	@FXML
	private ImageView C10;
	@FXML
	private ImageView C11;
	@FXML
	private ImageView C12;
	@FXML
	private ImageView C13;
	@FXML
	private ImageView C14;
	@FXML
	private ImageView C15;
	@FXML
	private ImageView C16;
	@FXML
	private ImageView C17;
	@FXML
	private ImageView C18;
	@FXML
	private ImageView C19;
	@FXML
	private ImageView C20;
	@FXML
	private ImageView C21;
	@FXML
	private ImageView C22;
	@FXML
	private ImageView C23;
	@FXML
	private ImageView C24;
	@FXML
	private ImageView C25;
	@FXML
	private ImageView C26;
	@FXML
	private ImageView C28;
	@FXML
	private ImageView C27;
	@FXML
	private ImageView C29;
	@FXML
	private ImageView C30;
	@FXML
	private ImageView C31;
	@FXML
	private ImageView C32;
	@FXML
	private ImageView C33;
	@FXML
	private ImageView C34;
	@FXML
	private ImageView C35;
	@FXML
	private ImageView C36;
	@FXML
	private ImageView C37;
	@FXML
	private ImageView C38;
	@FXML
	private ImageView C39;
	@FXML
	private ImageView C40;
	@FXML
	private ImageView C41;
	@FXML
	private ImageView C42;
	@FXML
	private ImageView C43;
	@FXML
	private ImageView C44;
	@FXML
	private ImageView C45;
	@FXML
	private ImageView C46;
	@FXML
	private ImageView C47;
	@FXML
	private ImageView C48;

	@FXML
	private ImageView constructeur;
	
	@FXML
	private ImageView travailleur;
	@FXML
	private ImageView canalBleu;
	@FXML
	private ImageView canalConstruction;
	@FXML
	private ImageView pile1;
	@FXML
	private ImageView pile2;
	@FXML
	private ImageView pile3;
	@FXML
	private ImageView pile4;
	@FXML
	private ImageView pile5;
	//LABEL
	@FXML
	private Label Name;
	@FXML
	private Label montantCagnotte;
	@FXML
	private Label numPhase;
	@FXML
	private Label numTour;
	@FXML
	private Label nbConstructeurs;
	@FXML
	private Label nbCanaux;
	@FXML
	private Label consigne;
	@FXML
	private TextField montantaMiser;
	@FXML
	private TextField soudoiement;
	@FXML
	private TextField message;
	@FXML
	private HBox listePiles;
	@FXML
	private HBox tag1;
	@FXML
	private Label nomCons;
	
	private HBox puces;
	@FXML
	private RadioButton p1;
	@FXML
	private RadioButton p2;
	@FXML
	private RadioButton p3;
	@FXML
	private RadioButton p4; 
	@FXML
	private RadioButton p5;
	
	private Players players;
	
	
	// cette méthode permet  d'initialiser le plateau et distribue les touile au joueurs
	// début de la phase 1
	public void initJeusantago(){
		String host=jeuSantiago.getClient().getHost();
		FonctionnaliteInterface server;
		try {
			server = (FonctionnaliteInterface)Naming.lookup("rmi://"+host+":45000/santiago");
		
		numTour.setText(server.getTour()+" / "+String.valueOf(server.getTourMaxr()));
		numPhase.setText(String.valueOf(server.getPhase()));
		Name.setText(server.getConstructeur().getNomJoueurs());
		for(Players p : server.getPlayers()){
			if(p.getNomJoueurs().equals(jeuSantiago.getClient().getPlayer().getNomJoueurs()))
				players=p;
		}
		
		 PileTuilePlantation pilep;
		 String plante;
		 int nbtag;
		 Image image;
		 ImageView pile;
		
		// phase1 et ditribution des tuiles aux joueurs du joueurs 			
			Name.setText(players.getNomJoueurs());
			montantCagnotte.setText(String.valueOf(players.getCagnotte())+"escudos");
			nbConstructeurs.setText(String.valueOf(players.getNbTag()));
			//partieMise.setDisable(false);
			if(players.getBluecanal()){
				nbCanaux.setText(String.valueOf(1));
			}		
			else
				canalBleu.setVisible(false);

			if(!players.getEst_constructeurdecanal())
				constructeur.setVisible(false);
			ArrayList<PileTuilePlantation>piles=server.getListpilesplantation();
			if(piles.size()==4){
				pile5.setVisible(false);
				//p5.setVisible(false);
			}
			
			
			for(int i=0;i<piles.size();i++)
			{
				
				pilep=piles.get(i);
				plante=pilep.getTuiles().get(0).getPlante();
				nbtag=pilep.getTuiles().get(0).getTag_necessaires();
				if(!pilep.getTuiles().get(0).getVisible()){
				pile=(ImageView) listePiles.getChildren().get(i);
				image=new Image("@../img/DosTuiles.png",50,47,false,false);
				pile.setImage(image);
				}
				else{
				pile=(ImageView) listePiles.getChildren().get(i);
				
				switch (plante){
					case "piment":
						
						if(nbtag==2){
							image=new Image("@../img/TuPiment1.png",50,47,false,false);
						}
						else{
							image=new Image("@../img/TuPiment2.png",50,47,false,false);
						}
						pile.setImage(image);
						break;
				case "banane":
						if(nbtag==2){
							image=new Image("@../img/TuBanane1.png",50,47,false,false);
						
					}
					else{
						image=new Image("@../img/TuBanane2.png",50,47,false,false);
							
						}
						pile.setImage(image);
						break;
					case "patate":
					if(nbtag==2){
							image=new Image("@../img/TuPDT1.png",50,47,false,false);
							
						}
						else{
							image=new Image("@../img/TuPDT2.png",50,47,false,false);
							
						}pile.setImage(image);
					break;
					case "haricot":
						if(nbtag==2){
							image=new Image("@../img/TuHaricots2.png",50,47,false,false);
							
						}
						else{
							image=new Image("@../img/TuHaricots1.png",50,47,false,false);
						}
					case "canne":
						if(nbtag==2){
							image=new Image("@../img/TuCanne2.png",50,47,false,false);
							
						}
						else{
							image=new Image("@../img/TuCanne1.png",50,47,false,false);
							
						}pile.setImage(image);
						break;
						}
				}}
			
			remplirCase(C1,0,0);
			remplirCase(C2,0,1);
			remplirCase(C3,0,2);
			remplirCase(C4,0,3);
			remplirCase(C5,0,4);
			remplirCase(C6,0,5);
			remplirCase(C7,0,6);
			remplirCase(C8,0,7);
			remplirCase(C9,1,0);
			remplirCase(C10,1,1);
			remplirCase(C11,1,2);
			remplirCase(C12,1,3);
			remplirCase(C13,1,4);
			remplirCase(C14,1,5);
			remplirCase(C15,1,6);
			remplirCase(C16,1,7);
			remplirCase(C17,2,0);
			remplirCase(C18,2,1);
			remplirCase(C19,2,2);
			remplirCase(C20,2,3);
			remplirCase(C21,2,4);
			remplirCase(C22,2,5);
			remplirCase(C23,2,6);
			remplirCase(C24,2,7);
			remplirCase(C25,3,0);
			remplirCase(C26,3,1);
			remplirCase(C27,3,2);
			remplirCase(C28,3,3);
			remplirCase(C29,3,4);
			remplirCase(C30,3,5);
			remplirCase(C31,3,6);
			remplirCase(C32,3,7);
			remplirCase(C33,4,0);
			remplirCase(C34,4,1);
			remplirCase(C35,4,2);
			remplirCase(C36,4,3);
			remplirCase(C37,4,4);
			remplirCase(C38,4,5);
			remplirCase(C39,4,6);
			remplirCase(C40,4,7);
			remplirCase(C41,5,0);
			remplirCase(C42,5,1);
			remplirCase(C43,5,2);
			remplirCase(C44,5,3);
			remplirCase(C45,5,4);
			remplirCase(C46,5,5);
			remplirCase(C47,5,6);
			remplirCase(C48,5,7);
			
			
		} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NotBoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}
	// cette méthode permet DE FAIRE BOUGER LES TUILES DANS LE PARCELLE 
	public void bouger1(ImageView tuile, ImageView parcelle){
		
		Image img=tuile.getImage();
		parcelle.setImage(img);
}
	// c'est la  phase 2
	public void phase2(){
		String host=jeuSantiago.getClient().getHost();
		FonctionnaliteInterface server;
			try {
			server = (FonctionnaliteInterface)Naming.lookup("rmi://"+host+":45000/jeu");
			server.playphase();
			numPhase.setText(String.valueOf(server.getPhase()));
			for(Players p : server.getPlayers()){
				if(p.getNomJoueurs().equals(jeuSantiago.getClient().getPlayer().getNomJoueurs()))
					players=p;
			}
			if(!players.getEst_constructeurdecanal())
					constructeur.setVisible(false);
			nomCons.setText(server.getConstructeur().getNomJoueurs());
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	public void initialize(URL location, ResourceBundle resources) {
		jeuSantiago = JeuSantiago.getSantiago();
		box = new Stage(StageStyle.DECORATED);
		box.initModality(Modality.WINDOW_MODAL);
		box.setTitle("PLATEAU: SANTIAGO");
		
				try {
		
					String host=jeuSantiago.getClient().getHost();
					FonctionnaliteInterface server = (FonctionnaliteInterface)Naming.lookup("rmi://"+host+":45000/santiago");
					//initJeusantago();
					
					ColorAdjust colorAdjust=new ColorAdjust();
					colorAdjust.setBrightness(-0.5);
					// phase
					placerPile(C1,0,0);;
					placerPile(C2,0,1);
					placerPile(C3,0,2);
					placerPile(C4,0,3);
					placerPile(C5,0,4);
					placerPile(C6,0,5);
					placerPile(C7,0,6);
					placerPile(C8,0,7);
					placerPile(C9,1,0);
					placerPile(C10,1,1);
					placerPile(C11,1,2);
					placerPile(C12,1,3);
					placerPile(C13,1,4);
					placerPile(C14,1,5);
					placerPile(C15,1,6);
					placerPile(C16,1,7);
					placerPile(C17,2,0);
					placerPile(C18,2,1);
					placerPile(C19,2,2);
					placerPile(C20,2,3);
					placerPile(C21,2,4);
					placerPile(C22,2,5);
					placerPile(C23,2,6);
					placerPile(C24,2,7);
					placerPile(C25,3,0);
					placerPile(C26,3,1);
					placerPile(C27,3,2);
					placerPile(C28,3,3);
					placerPile(C29,3,4);
					placerPile(C30,3,5);
					placerPile(C31,3,6);
					placerPile(C32,3,7);
					placerPile(C33,4,0);
					placerPile(C34,4,1);
					placerPile(C35,4,2);
					placerPile(C36,4,3);
					placerPile(C37,4,4);
					placerPile(C38,4,5);
					placerPile(C39,4,6);
					placerPile(C40,4,7);
					placerPile(C41,5,0);
					placerPile(C42,5,1);
					placerPile(C43,5,2);
					placerPile(C44,5,3);
					placerPile(C45,5,4);
					placerPile(C46,5,5);
					placerPile(C47,5,6);
					placerPile(C48,5,7);	
						} catch (MalformedURLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (NotBoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}catch (RemoteException e) {
							e.printStackTrace();
						}
		}
	
	public boolean verifEnchere(int montant)throws RemoteException{
		jeuSantiago = JeuSantiago.getSantiago();
		FonctionnaliteInterface server;
		try {
			String host=jeuSantiago.getClient().getHost();
			server = (FonctionnaliteInterface)Naming.lookup("rmi://"+host+":45000/santiago");
			for(int i=0;i<server.getEncheresCourantes().size();i++)
		{
			if(server.getEncheresCourantes().get(i).getMontant()==montant)
					return false;
			}
			return true;
		} catch (MalformedURLException | NotBoundException e) {
			// TODO Auto-generated catch block
 			return false;
		}	
	}
	

	public void bouger(ImageView tuile, ImageView parcelle){
		
		Image img=tuile.getImage();
		parcelle.setImage(img);
	}	
public void placerPile(ImageView C1,int x,int y){
			
			String host=jeuSantiago.getClient().getHost();
			FonctionnaliteInterface server;
			try {
				server = (FonctionnaliteInterface)Naming.lookup("rmi://"+host+":45000/santiago");
				
				ColorAdjust colorAdjust=new ColorAdjust();
				colorAdjust.setBrightness(-0.5);
				
				C1.addEventFilter(MouseEvent.MOUSE_CLICKED, e->{
					C1.setEffect(colorAdjust);
			try {
				if(server.getPhase()==3)
				{
					// plcer les piles 
					if((p1.isSelected()&& !p2.isSelected() && !p3.isSelected() && !p4.isSelected())
							||(!p1.isSelected()&& p2.isSelected() && !p3.isSelected() && !p4.isSelected())
							||(!p1.isSelected()&& !p2.isSelected() && p3.isSelected() && !p4.isSelected())
							||(!p1.isSelected()&& !p2.isSelected() && !p3.isSelected()&& p4.isSelected())
							||(!p1.isSelected()&& !p2.isSelected() && !p3.isSelected()&& p4.isSelected()))
							{
						try {
							players.setCagnotte(players.getCagnotte()-server.getEncheresCourantes().get(players.getRang()-1).getMontant());
							if (server.getPlateau().get(0,0).getOccupee())
								JOptionPane.showMessageDialog(null, "Parcelle occcupï¿½e, choisir une autre parcelle");
							else if(p1.isSelected() && !server.getPlateau().get(0,0).getOccupee()&& server.getListpilesplantation().get(0).getTuiles().get(0).getVisible()){
								PlantationTuiles tuile = server.getListpilesplantation().get(0).getTuiles().get(0);
								server.getListpilesplantation().get(0).getTuiles().remove(0);
								players.getTuiles_joueur().add(tuile);
								int tag;
								if(server.getEncheresCourantes().get(players.getRang()-1).getMontant()!=0){
									tag=tuile.getTag_necessaires()-tuile.getTag_presents();
								}else{
									tag=tuile.getTag_necessaires()-tuile.getTag_presents()-1;
								}
								if(players.getNbTag()-tag>0){
									
									players.setNbTag(players.getNbTag()-tag);
									tuile.setTag_presents(tag);
									tuile.setSourceX(x);
									tuile.setSourceY(y);
									server.getPlateau().get(x,y).setOccupee(true);
									nbConstructeurs.setText(String.valueOf(players.getNbTag()-tag));
									
										
								}
								
								bouger1(pile1,C1);
								pile1.setImage(new Image("@../img/DosTuiles.png",50,47,false,false));
								
								if(server.getPlayers().size()==3 && players.equals(server.getPlayers().get(0))){
									JOptionPane.showMessageDialog(null, "Vous avez eu la plus grosse mise, placer la derniï¿½re tuile");	
								}
								else
									puces.setDisable(true);
							}
							//p2
							else if(p2.isSelected() && !server.getPlateau().get(0,1).getOccupee()&& server.getListpilesplantation().get(0).getTuiles().get(0).getVisible()){
								PlantationTuiles tuile = server.getListpilesplantation().get(1).getTuiles().get(0);
								server.getListpilesplantation().get(1).getTuiles().remove(0);
								players.getTuiles_joueur().add(tuile);
								int tag;
								if(server.getEncheresCourantes().get(players.getRang()-1).getMontant()!=0){
									tag=tuile.getTag_necessaires()-tuile.getTag_presents();
								}else{
									tag=tuile.getTag_necessaires()-tuile.getTag_presents()-1;
								}
								if(players.getNbTag()-tag>0){
									
									players.setNbTag(players.getNbTag()-tag);
									tuile.setTag_presents(tag);
									tuile.setSourceX(x);
									tuile.setSourceY(y);
									server.getPlateau().get(x,y).setOccupee(true);
									
									nbConstructeurs.setText(String.valueOf(players.getNbTag()-tag));
									
									
										//tag1.getChildren().add(img.setImage(travailleur.getImage()));
								}
								
								bouger1(pile2,C1);
								pile2.setImage(new Image("@../img/DosTuiles.png",50,47,false,false));
								
								if(server.getPlayers().size()==3 && players.equals(server.getPlayers().get(0))){
									JOptionPane.showMessageDialog(null, "Vous avez eu la plus grosse mise, placer la derniï¿½re tuile");	
								}
								else
									puces.setDisable(true);
							}
							//p3
							else if(p3.isSelected() && !server.getPlateau().get(0,2).getOccupee()&& server.getListpilesplantation().get(0).getTuiles().get(0).getVisible()){
								PlantationTuiles tuile = server.getListpilesplantation().get(2).getTuiles().get(0);
								server.getListpilesplantation().get(2).getTuiles().remove(0);
								players.getTuiles_joueur().add(tuile);
								int tag;
								if(server.getEncheresCourantes().get(players.getRang()-1).getMontant()!=0){
									tag=tuile.getTag_necessaires()-tuile.getTag_presents();
								}else{
									tag=tuile.getTag_necessaires()-tuile.getTag_presents()-1;
								}
								if(players.getNbTag()-tag>0){
									
									players.setNbTag(players.getNbTag()-tag);
									tuile.setTag_presents(tag);
									tuile.setSourceX(x);
									tuile.setSourceY(y);
									server.getPlateau().get(x,y).setOccupee(true);
									server.phaseAprés();
									
									nbConstructeurs.setText(String.valueOf(players.getNbTag()-tag));
								
								}
								
								bouger1(pile3,C1);
								pile3.setImage(new Image("@../img/DosTuiles.png",50,47,false,false));
								
								if(server.getPlayers().size()==3 && players.equals(server.getPlayers().get(0))){
									JOptionPane.showMessageDialog(null, "Vous avez eu la plus grosse mise, placer la derniï¿½re tuile");	
								}
								else
									puces.setDisable(true);
							}
							
							//p4
							else if(p4.isSelected() && !server.getPlateau().get(0,3).getOccupee()&& server.getListpilesplantation().get(0).getTuiles().get(0).getVisible()){
								PlantationTuiles tuile = server.getListpilesplantation().get(3).getTuiles().get(0);
								server.getListpilesplantation().get(3).getTuiles().remove(0);
								players.getTuiles_joueur().add(tuile);
								int tag;
								if(server.getEncheresCourantes().get(players.getRang()-1).getMontant()!=0){
									tag=tuile.getTag_necessaires()-tuile.getTag_presents();
								}else{
									tag=tuile.getTag_necessaires()-tuile.getTag_presents()-1;
								}
								if(players.getNbTag()-tag>0){
									
									players.setNbTag(players.getNbTag()-tag);
									tuile.setTag_presents(tag);
									tuile.setSourceX(x);
									tuile.setSourceY(y);
									server.getPlateau().get(x,y).setOccupee(true);
									server.phaseAprés();
									
									nbConstructeurs.setText(String.valueOf(players.getNbTag()-tag));
									
									
										//tag1.getChildren().add(img.setImage(travailleur.getImage()));
								}
								
								bouger1(pile4,C1);
								pile4.setImage(new Image("@../img/DosTuiles.png",50,47,false,false));
								
								if(server.getPlayers().size()==3 && players.equals(server.getPlayers().get(0))){
									JOptionPane.showMessageDialog(null, "Vous avez eu la plus grosse mise, placer la derniï¿½re tuile");	
								}
								else
									puces.setDisable(true);
							}
							//p4
							else if(p5.isSelected() && !server.getPlateau().get(0,4).getOccupee()&& server.getListpilesplantation().get(0).getTuiles().get(0).getVisible()){
								PlantationTuiles tuile = server.getListpilesplantation().get(4).getTuiles().get(0);
								server.getListpilesplantation().get(4).getTuiles().remove(0);
								players.getTuiles_joueur().add(tuile);
								int tag;
								if(server.getEncheresCourantes().get(players.getRang()-1).getMontant()!=0){
									tag=tuile.getTag_necessaires()-tuile.getTag_presents();
								}else{
									tag=tuile.getTag_necessaires()-tuile.getTag_presents()-1;
								}
								if(players.getNbTag()-tag>0){
									
									players.setNbTag(players.getNbTag()-tag);
									tuile.setTag_presents(tag);
									tuile.setSourceX(x);
									tuile.setSourceY(y);
									server.getPlateau().get(x,y).setOccupee(true);
									
									nbConstructeurs.setText(String.valueOf(players.getNbTag()-tag));
									
									
										//tag1.getChildren().add(img.setImage(travailleur.getImage()));
								}
								
								bouger1(pile5,C1);
								pile5.setImage(new Image("@../img/DosTuiles.png",50,47,false,false));
								
								if(server.getPlayers().size()==3 && players.equals(server.getPlayers().get(0))){
									JOptionPane.showMessageDialog(null, "Vous avez eu la plus grosse mise, placer la derniï¿½re tuile");	
								}
								else
									puces.setDisable(true);
							}
							
							else{
								JOptionPane.showMessageDialog(null, "La tuile n'a pas encore ï¿½tï¿½ retournï¿½e"+server.getListpilesplantation().get(0).getTuiles().get(0).getVisible());
								if(server.getPlayers().size()==3 && players.equals(server.getPlayers().get(0))){
									puces.setDisable(true);
									}
							}
							
							
							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
					else{
						JOptionPane.showMessageDialog(null, "Selectioner qu'une seule pile");
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Attendre la phase 3");
				}
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
					
			});
				
			} catch (MalformedURLException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			} catch (RemoteException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			} catch (NotBoundException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
	
		}
		public void mettreFossee(Separator s){
			s.setStyle("-fx-background-color: #409CC8; -fx-translate-y: 3;");
			
			
		}
		
		public void remplirCase(ImageView c,int x,int y){
			String host=jeuSantiago.getClient().getHost();
			FonctionnaliteInterface server;
			Image image;
			
			try {
				server = (FonctionnaliteInterface)Naming.lookup("rmi://"+host+":45000/jeu");
				for(Players p:server.getPlayers()){
					
					for(int i=0; i<p.getTuiles_joueur().size();i++){
						int nbtag=p.getTuiles_joueur().get(i).getTag_necessaires();
						String plante=p.getTuiles_joueur().get(i).getPlante();
						switch(plante){
						case "piment":
							
							if(nbtag==2){
								image=new Image("@../img/TuPiment1.png",50,47,false,false);
							}
							else{
								image=new Image("@../img/TuPiment2.png",50,47,false,false);
							}
							c.setImage(image);
							break;
						case "banane":
							if(nbtag==2){
								image=new Image("@../img/TuBanane1.png",50,47,false,false);
								
							}
							else{
								image=new Image("@../img/TuBanane2.png",50,47,false,false);
								
							}
							c.setImage(image);
							break;
						case "patate":
							if(nbtag==2){
								image=new Image("@../img/TuPDT1.png",50,47,false,false);
								
							}
							else{
								image=new Image("@../img/TuPDT2.png",50,47,false,false);
								
							}c.setImage(image);
							break;
						case "haricot":
							if(nbtag==2){
								image=new Image("@../img/TuHaricots2.png",50,47,false,false);
								
							}
							else{
								image=new Image("@../img/TuHaricots1.png",50,47,false,false);
							}
							case "canne":
							if(nbtag==2){
								image=new Image("@../img/TuCanne2.png",50,47,false,false);
								
							}
							else{
								image=new Image("@../img/TuCanne1.png",50,47,false,false);
								
							}c.setImage(image);
							break;
							
						}
					}
				}
				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	
	
}
