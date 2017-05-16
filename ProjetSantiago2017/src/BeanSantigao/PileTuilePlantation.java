package BeanSantigao;

import java.io.Serializable;
import java.util.ArrayList;

public class PileTuilePlantation implements Serializable {
	
	private int idPiletuile;
	// liste des tuiles de plantation 
	private ArrayList<PlantationTuiles> tuiles;
	
	
	public PileTuilePlantation(int idPiletuile){
		
	 this.idPiletuile=idPiletuile;
	 this.tuiles=new ArrayList<PlantationTuiles>();
	 
	}
	public PileTuilePlantation(int idPiletuile, ArrayList<PlantationTuiles> listetuiles){
		
		 this.idPiletuile=idPiletuile;
		 this.tuiles=listetuiles;
		 
		}
	public int getIdPiletuile() {
		return idPiletuile;
	}

	public void setIdPiletuile(int idPiletuile) {
		this.idPiletuile = idPiletuile;
	}

	public ArrayList<PlantationTuiles> getTuiles() {
		return tuiles;
	}

	public void setTuiles(ArrayList<PlantationTuiles> tuiles) {
		this.tuiles = tuiles;
	}

	public void add(PlantationTuiles t){
		this.tuiles.add(t);
	}
	public void addAll(ArrayList<PlantationTuiles> l){
		this.tuiles.addAll(l);
	}

	public PlantationTuiles retirerTuile(){
		PlantationTuiles t=this.tuiles.get(0);
		this.tuiles.remove(0);
		return t;
	}

}
