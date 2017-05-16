package ServiceInterfaces;

import java.rmi.server.UnicastRemoteObject;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import BeanSantigao.PileTuilePlantation;
import BeanSantigao.PlantationTuiles;
import BeanSantigao.PlateauSantiago;
import BeanSantigao.Players;
import BeanSantigao.ProposMise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Service  extends UnicastRemoteObject  implements FonctionnaliteInterface {
	
	private ArrayList<Players> PlayerList =null ;
	
	private int idPartie;
	private int tour;
	private int phase;
	private PlateauSantiago plateau;
	private ArrayList<Players> listepalyers= null;
	private boolean start;
	private int max_tour;
	private ArrayList<PileTuilePlantation> listepiles=null;
	private ArrayList<ProposMise> encheres_courantes;
	
	private ArrayList<String> couleurs = new ArrayList<String>();

	
	//private ArrayList<PropositionSoudoiement> soudoiments ;
	
	public Service() throws RemoteException, UnknownHostException {
		this.idPartie=(int)(Math.random()*(1000000000-0));
		this.listepalyers=new ArrayList<Players>();
		this.Listfonctionnalite=new ArrayList<FonctionnaliteInterface>();
		this.couleurs.add("Noir");
		this.couleurs.add("Gris");
		this.couleurs.add("Violet");
		this.couleurs.add("Beige");
		this.couleurs.add("Rouge");
		this.start=false;
		this.tour=1;
		this.phase=0;

		//this.liste_piles=new ArrayList<PileTuile>();
		//this.encheres_courantes=new ArrayList<ProposerMise>();
	}
	
	
	

	
	public ArrayList<Players> getPlayerList() {
		return this.listepalyers ;
	}

	public Service(int idPartie, int tour, int phase, PlateauSantiago plateau, ArrayList<Players> listepalyers,
			boolean start, int max_tour, ArrayList<PileTuilePlantation> listepiles,
			ArrayList<ProposMise> encheres_courantes, ArrayList<FonctionnaliteInterface> listfonctionnalite)
			throws RemoteException {
		super();
		this.idPartie = idPartie;
		this.tour = tour;
		this.phase = phase;
		this.plateau = plateau;
		this.listepalyers = listepalyers;
		this.start = start;
		this.max_tour = max_tour;
		this.listepiles = listepiles;
		this.encheres_courantes = encheres_courantes;
		Listfonctionnalite = listfonctionnalite;
	}

	public void setPlayerList(ArrayList<Players> playerList) {
		listepalyers = playerList;
	}

	public int getIdPartie() {
		return idPartie;
	}

	public void setIdPartie(int idPartie) {
		this.idPartie = idPartie;
	}

	public ArrayList<String> getCouleurs() {
		return couleurs;
	}

	public void setCouleurs(ArrayList<String> couleurs) {
		this.couleurs = couleurs;
	}

	public ArrayList<Players> getListepalyers() {
		return listepalyers;
	}

	public void setListepalyers(ArrayList<Players> listepalyers) {
		this.listepalyers = listepalyers;
	}

	public ArrayList<FonctionnaliteInterface> getListfonctionnalite() {
		return Listfonctionnalite;
	}

	public void setListfonctionnalite(ArrayList<FonctionnaliteInterface> listfonctionnalite) {
		Listfonctionnalite = listfonctionnalite;
	}

	public void setTour(int tour) {
		this.tour = tour;
	}

	public void setPhase(int phase) {
		this.phase = phase;
	}

	public void setPlateau(PlateauSantiago plateau) {
		this.plateau = plateau;
	}

	public void setStart(boolean start) {
		this.start = start;
	}

	private ArrayList<FonctionnaliteInterface> Listfonctionnalite=null;
	
	
	
	
	

	public Service(int idPartie, int tour, int phase, PlateauSantiago plateau, ArrayList<Players> listepalyers,
			boolean start, int max_tour, ArrayList<ProposMise> encheres_courantes, ArrayList<String> couleurs,
			ArrayList<PileTuilePlantation> listepiles, ArrayList<FonctionnaliteInterface> listfonctionnalite)
			throws RemoteException {
		super();
		this.idPartie = idPartie;
		this.tour = tour;
		this.phase = phase;
		this.plateau = plateau;
		this.listepalyers = listepalyers;
		this.start = start;
		this.max_tour = max_tour;
		this.encheres_courantes = encheres_courantes;
		this.couleurs.add("Noir");
		this.couleurs.add("Gris");
		this.couleurs.add("Violet");
		this.couleurs.add("Beige");
		this.couleurs.add("Rouge");
		this.listepiles = listepiles;
		Listfonctionnalite = listfonctionnalite;
	}

	@Override
	public void setClient(FonctionnaliteInterface client) throws RemoteException {
		//this.client=client;
				if(this.Listfonctionnalite.size()<5){
					this.Listfonctionnalite.add(client);
					System.out.println("Nouveau joueur. "+this.Listfonctionnalite.size()+" joueur(s) au total");
					if(this.Listfonctionnalite.size()==5){
						System.out.println("add bon");
						this.start=true;
						System.out.println(start);
					}
				}
				else{
					System.out.println("Dï¿½jï¿½ 5 joueurs connectï¿½s dsl");
				}
		
	}

	@Override
	public ArrayList<FonctionnaliteInterface> getClient() throws RemoteException {
		// TODO Auto-generated method stub
		return this.Listfonctionnalite;
	}

	@Override
	public PlateauSantiago getPlateau() throws RemoteException {
		// TODO Auto-generated method stub
		return plateau;
	}

	@Override
	public int getTour() throws RemoteException {
		// TODO Auto-generated method stub
		return this.tour;
	}

	@Override
	public int getPhase() throws RemoteException {
		// TODO Auto-generated method stub
		return this.phase;
	}

	@Override
	public boolean getStart() throws RemoteException {
		// TODO Auto-generated method stub
		return this.start;
	}

	@Override
	public String getCouleur(int i) throws RemoteException {
	
		return this.couleurs.get(i);
	}

	@Override
	public void addPlayer(Players p) throws RemoteException {
		this.listepalyers.add(p);
		
		
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Players> getPlayers() throws RemoteException {
		// TODO Auto-generated method stub
		return this.listepalyers ;
	}
// cette m"thode permet de lancer la partie si 3 joueurs minimum sont inscrit
	@Override
	public void RunPart() throws RemoteException {
		if(this.listepalyers.size()>=3|| this.Listfonctionnalite.size()>=3){
			this.start=true;
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	// cette methode permet de d�buter la partie de chaque jouer
	public void phaseDedut() throws RemoteException {
		/**
		 * PHASE 0 : INITIALISATION DU JEU
		 * 1)Initialiser le tableau
		 * 	a)initialiser les parcelles
		 * 	b)initialiser les fossï¿½es
		 * 2)Initialiser les piles
		 * 	a)Initialiser les tuiles
		 * 	b)distribuer les tuiles
		 * 3)Initialiser le nombre de Tours
		 * 4)Choisisir le constucteur de canal
		 * 5)Dï¿½finir le nouvel Ordre de jeu
		 * Phase suivante
		 */
		   //On crï¿½e le tableau de la partie
			int x=(int)(Math.random()*(3-0));
			int y=(int)(Math.random()*(3-0));
			plateau=new PlateauSantiago(1,5,6);
			//System.out.println("CrÃ©ation Tableau");
			plateau.initparcelleplateau();// tableau de parcelle 8X6
			//System.out.println("Initialisation parcelles");
			this.plateau.initfosseplateau();//tableau de fosses 16 premier verticaux, 16 d'apres horizontaux
			System.out.println("Initialisation fossÃ©s");
			
			//initialisation de la Banque
			//this.banque=new Banque();
			//On gï¿½re les tuiles de plantations
			
				//CREATION DES TUILES
			ArrayList<PlantationTuiles> toutesLesTuiles=new ArrayList<PlantationTuiles>();
			for(int id1=1 ;id1<=5; id1++){
				toutesLesTuiles.add(new PlantationTuiles(id1,"piment",1,1));
			}
			for(int id11=6 ;id11<=9; id11++){
				toutesLesTuiles.add(new PlantationTuiles(id11,"piment",2,1));
			}
			for(int id2=10 ;id2<=14; id2++){
				toutesLesTuiles.add(new PlantationTuiles(id2,"banane",1,1));
			}
			for(int id21=15 ;id21<=18; id21++){
				toutesLesTuiles.add(new PlantationTuiles(id21,"banane",2,1));
			}
			for(int id3=19 ;id3<=23; id3++){
				toutesLesTuiles.add(new PlantationTuiles(id3,"patate",1,1));
			}
			for(int id31=24 ;id31<=27; id31++){
				toutesLesTuiles.add(new PlantationTuiles(id31,"patate",2,1));
			}
			for(int id4=28 ;id4<=33; id4++){
				toutesLesTuiles.add(new PlantationTuiles(id4,"haricot",1,1));
			}
			for(int id41=34 ;id41<=36; id41++){
				toutesLesTuiles.add(new PlantationTuiles(id41,"haricot",2,1));
			}
			for(int id5=37 ;id5<=41; id5++){
				toutesLesTuiles.add(new PlantationTuiles(id5,"canne",1,1));
			}
			for(int id51=42 ;id51<=45; id51++){
				toutesLesTuiles.add(new PlantationTuiles(id51,"canne",2,1));
			}
			
				//Creation des piles
			if(this.listepalyers.size()==5){
				this.listepiles=new ArrayList<PileTuilePlantation>(5);
				PileTuilePlantation pile1,pile2,pile3,pile4,pile5;
				
					pile1=new PileTuilePlantation(1);
					for(int indicePile1=1;indicePile1<=9;indicePile1++){
						int indice1=(int)Math.random()*(toutesLesTuiles.size()-0);
						pile1.getTuiles().add(toutesLesTuiles.get(indice1));
						toutesLesTuiles.remove(indice1);
						
					} this.listepiles.add(pile1);
					pile2=new PileTuilePlantation(2);
					for(int indicePile2=1;indicePile2<=9;indicePile2++){
						int indice2=(int)(Math.random()*(toutesLesTuiles.size()-0));
						pile2.getTuiles().add(toutesLesTuiles.get(indice2));
						toutesLesTuiles.remove(indice2);
					}this.listepiles.add(pile2);
					
					pile3=new PileTuilePlantation(3);
					for(int indicePile3=1;indicePile3<=9;indicePile3++){
						int indice3=(int)(Math.random()*(toutesLesTuiles.size()-0));
						pile3.getTuiles().add(toutesLesTuiles.get(indice3));
						toutesLesTuiles.remove(indice3);
						
					}this.listepiles.add(pile3);
					pile4=new PileTuilePlantation(4);
					for(int indicePile4=1;indicePile4<=9;indicePile4++){
						int indice4=(int)(Math.random()*(toutesLesTuiles.size()-0));
						pile4.getTuiles().add(toutesLesTuiles.get(indice4));
						toutesLesTuiles.remove(indice4);
						
					}
					this.listepiles.add(pile4);
					pile5=new PileTuilePlantation(5);
					pile5.getTuiles().addAll(toutesLesTuiles);
					this.listepiles.add(pile5);
					//INIT CONSTRUCTEUR
					int constructeur=(int)(Math.random()*(listepalyers.size()-0));
					listepalyers.get(constructeur).setEst_constructeurdecanal(true);
					System.out.println("Le joueur "+listepalyers.get(constructeur).getNomJoueurs()+" est constructeur de canal");
		
					//RORGANISER l'ordre de passage par rapport au constructeur de canal
					//this.resetOrdre(listepalyers.get(constructeur).getIdjoueur());
					
			}
			else{
				this.listepiles=new ArrayList<PileTuilePlantation>(4);
				PileTuilePlantation pile1,pile2,pile3,pile4;


				Random r2 = new Random();
				int tuileAsupprimer= r2.nextInt(45);
				toutesLesTuiles.remove(tuileAsupprimer);
					pile1=new PileTuilePlantation(1);
					for(int indicePile1=1;indicePile1<=11;indicePile1++){
						int indice1=(int)(Math.random()*(toutesLesTuiles.size()-0));
						pile1.getTuiles().add(toutesLesTuiles.get(indice1));
						toutesLesTuiles.remove(indice1);
						
					} this.listepiles.add(pile1);
					pile2=new PileTuilePlantation(2);
					for(int indicePile2=1;indicePile2<=11;indicePile2++){
						int indice2=(int)(Math.random()*(toutesLesTuiles.size()-0));
						pile2.getTuiles().add(toutesLesTuiles.get(indice2));
						toutesLesTuiles.remove(indice2);
					}this.listepiles.add(pile2);
					
					pile3=new PileTuilePlantation(3);
					for(int indicePile3=1;indicePile3<=11;indicePile3++){
						int indice3=(int)(Math.random()*(toutesLesTuiles.size()-0));
						pile3.getTuiles().add(toutesLesTuiles.get(indice3));
						toutesLesTuiles.remove(indice3);
					}this.listepiles.add(pile3);
					
					pile4=new PileTuilePlantation(4);
					pile4.getTuiles().addAll(toutesLesTuiles);
					this.listepiles.add(pile4);
					
					//Choisir en Random le constructeur de Canal
					int constructeur=(int)(Math.random()*(listepalyers.size()-0));
					listepalyers.get(constructeur).setEst_constructeurdecanal(true);
					System.out.println("Le joueur "+listepalyers.get(constructeur).getNomJoueurs()+" est constructeur de canal");
		
					
					//RORGANISER l'ordre de passage par rapport au constructeur de canal
					//this.resetOrdre(listepalyers.get(constructeur).getIdjoueur());
					
					}
		phaseApr�s();
		}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public void playphase() throws RemoteException {
		
	switch (this.phase){
		
		case 4:
		this.phase4();
			break;
		case 5:
	case 0: //INITIALISATION, une seule fois
			this.phaseDedut();
		break;
		default:
			System.out.println("Erreur .....");
		}
//		// TODO Auto-generated method stub
		
	}

	@Override
	public Players getConstructeur() throws RemoteException {
		for(int i=0;i<this.listepalyers.size();i++){
			if(this.listepalyers.get(i).getConstructeur())
				return this.listepalyers.get(i);
		}return null;
	}

	@Override
	public ArrayList<ProposMise> getEncheresCourantes() throws RemoteException {
		// TODO Auto-generated method stub
		return this.encheres_courantes;
	}

	@Override
	public int getTourMaxr() throws RemoteException {
		// TODO Auto-generated method stub
		return this.max_tour;
	}

	@Override
	public ArrayList<PileTuilePlantation> getListpilesplantation() throws RemoteException {
		// TODO Auto-generated method stub
		return this.listepiles;
	}

	

	
	@Override
	public void phaseApr�s() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tourAfter() throws RemoteException {
		this.tour++;
		this.phase=1;
		this.playphase();
		
	}

	

	@Override
	public void phase0() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void phase4() throws RemoteException {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void passerMise(Players p) throws RemoteException {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void miser(Players p, int montant) throws RemoteException {
		// TODO Auto-generated method stub
		
	}





	@Override
	public ArrayList<PlantationTuiles> phase6() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public void setTourMax(int maxTour) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
 
}
