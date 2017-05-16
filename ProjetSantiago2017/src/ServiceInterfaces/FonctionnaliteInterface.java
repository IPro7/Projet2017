package ServiceInterfaces;

import java.rmi.RemoteException;
import java.util.ArrayList;

import BeanSantigao.PileTuilePlantation;
import BeanSantigao.PlantationTuiles;
import BeanSantigao.PlateauSantiago;
import BeanSantigao.Players;
import BeanSantigao.ProposMise;


public interface FonctionnaliteInterface extends java.rmi.Remote {

	public void setClient(FonctionnaliteInterface client) throws RemoteException;
	
	public ArrayList<FonctionnaliteInterface> getClient() throws RemoteException;
	
	public PlateauSantiago getPlateau()throws RemoteException ;
	
	public int getTour() throws RemoteException; // les tours du jeu 
	
	public int getPhase() throws RemoteException; // les differents phase du jeu

	public boolean getStart() throws RemoteException; // permet de lancer le jeu
	
	public String getCouleur(int i) throws RemoteException;
	
	public void addPlayer(Players p) throws RemoteException; // permet de rajouter les joueurs dans le jeu 
	
	public ArrayList<Players> getPlayers() throws RemoteException; 
	
	public Players getConstructeur()throws RemoteException;//permet aux joueurs de construire leur canal
	
	public void RunPart() throws RemoteException; // cette méthode permet de lancer une partie du jeu
	
	public ArrayList<ProposMise> getEncheresCourantes() throws RemoteException; // permiser au joueur de miser les enchers 
	
	public int getTourMaxr() throws RemoteException; // p
	
	public ArrayList<PileTuilePlantation> getListpilesplantation() throws RemoteException; // la liste des tuiles que reçcoivent chaque joueur 
	
	
	public void passerMise(Players p) throws RemoteException;// permet au joueur de passer sa parti et donne la mains au autre 
	
	public void miser(Players p, int montant)throws RemoteException;
	
	public void phase0() throws RemoteException;
	public void phase4() throws RemoteException;
	
	public void phaseDedut() throws RemoteException;
	public void playphase() throws RemoteException;

	public void phaseAprés() throws RemoteException;// phase suivant
	public void tourAfter() throws RemoteException;// tour suivant
	public ArrayList<PlantationTuiles> phase6() throws RemoteException;
	
	public void setTourMax(int maxTour) throws RemoteException;// setMaxtour
	
}
