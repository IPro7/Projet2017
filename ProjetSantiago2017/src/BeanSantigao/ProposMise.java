package BeanSantigao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

public class ProposMise implements Comparable<ProposMise>, Serializable {
	
	private int idMise;
	private Players players;
	private int montant;
	
	public ProposMise(int idMise,Players players, int montant){
		this.players=players;
		this.idMise=idMise;
		this.montant=montant;
	}
	
	public ProposMise(int idMise,Players players){
		this.players=players;
		this.idMise=idMise;
		this.montant=0;
	}
	
	public ProposMise(int idMise, int montant,int idjoueur, ArrayList<Players> listPlayer){
		this.idMise=idMise;
		this.montant=montant;
		for(Players p:listPlayer){
			if(p.getIdjoueur()==idjoueur){
				this.players=p;
			}
		}
	}

	public int getIdMise() {
		return idMise;
	}

	public void setIdMise(int idMise) {
		this.idMise = idMise;
	}

	public Players getPlayer() {
		return players;
	}

	public void setJoueur(Players joueur) {  // set joueur _> setplayer
		this.players = players;
	}

	public int getMontant() {
		return montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}
	
	/**********************COMPARATOR************************************/

	 public static class Comparators {

		 public static final Comparator<ProposMise> MONTANT = (ProposMise o1, ProposMise o2) -> Integer.compare(o1.getMontant(), o2.getMontant());
	        
	    }

	@Override
	public int compareTo(ProposMise arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
