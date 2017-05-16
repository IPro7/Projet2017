package BeanSantigao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import ServiceInterfaces.FonctionnaliteInterface;



public class PlateauSantiago implements Serializable {
	private int idPlateau;
	private int pointX;
	private int pointY;
	private List<ParcellesPlateau> listparcelleplateau;
	private List<FossePlateau> listfosseplateau;
	
	
	//  1er contriucteur du plateau
	
	public PlateauSantiago(int idPlateau, int pointX, int pointY) {
		super();
		this.idPlateau = idPlateau;
		this.pointX = pointX;
		this.pointY = pointY;
		this.listparcelleplateau = new ArrayList<ParcellesPlateau>();
		this.listfosseplateau = new ArrayList<FossePlateau>();
	}


	public PlateauSantiago(int idPlateau, int pointX, int pointY, List<ParcellesPlateau> listparcelleplateau,
			List<FossePlateau> listfosseplateau) {
		super();
		this.idPlateau = idPlateau;
		this.pointX = pointX;
		this.pointY = pointY;
		this.listparcelleplateau = listparcelleplateau;
		this.listfosseplateau = listfosseplateau;
	}
	
	/**
	 cette methode permet de savoir les fossees du plateau au tour d'une parcelle 
	 elle retourne liste des des fosse du plateau
	
	 */
	public ArrayList<FossePlateau> getFossesAdjacents( ParcellesPlateau parcelle){
		
		ArrayList<FossePlateau> fosses= new ArrayList<FossePlateau>();
		int x;
		int y;
		
		if((parcelle.getParcelleX()%2==1) ){
			x=parcelle.getParcelleX()/2+1;
		}
		else
			x=parcelle.getParcelleX()/2;
		
		fosses.add(this.getFosse(x,parcelle.getPacelleY()/2,"H"));
		
		if((parcelle.getPacelleY()%2==1) ){
			y=parcelle.getPacelleY()/2+1;
		}
		else
			y=parcelle.getPacelleY();
		
		fosses.add(this.getFosse(parcelle.getParcelleX()/2,y,"V"));
		return fosses;
	}
	//  cette methode Permet de trouver un fosse du plateau avec un coordonné x y en parametre 
	 
public FossePlateau getFosse(int x,int y,String sens){

	switch (sens){
	case "H":
		for(int i=0;i<16;i++){
			
			if((listfosseplateau.get(i).getCoorabsX()==y) && (listfosseplateau.get(i).getCoorordY()==x)){
				//System.out.println("H :"+x+","+y+" id: "+liste_fosses.get(i).getIdFosse());
				return listfosseplateau.get(i);
			}
			
		}
		break;
	case "V":
		for(int j=16;j<listfosseplateau.size();j++){
			if((listfosseplateau.get(j).getCoorabsX()==x) && (listfosseplateau.get(j).getCoorordY()==y))
			{
				//System.out.println("V :"+x+","+y+""+liste_fosses.get(j).getIdFosse());return liste_fosses.get(j);
			}
				
		}
		break;
	}
		return null;
	}
// cette methode permet de trouver une parcelle du plateau par ces coordonnee qui retourne sur une parcelle

public ParcellesPlateau get(int x,int y){
	for(ParcellesPlateau p:this.listparcelleplateau){
		if(p.getParcelleX()==x && p.getPacelleY()==y)
			return p;
		
	}
	return null;
}

// cette methode permet d'initiliser tous les fossee dans tous les sens(horizontal et vetical)


public void initfosseplateau()
{
	int id=1;
	//16 fossï¿½s horizontaux
	
	for(int i=0;i<4;i++){
		for(int j=0;j<4;j++){
		this.listfosseplateau.add(new FossePlateau(id,j,i,false,"H"));
		System.out.println(id+":"+i+" "+j);id++;
		
		
		}
	}
	//15 fossï¿½s verticau
	id=1;
	for(int k=0;k<3;k++){
		for(int l=0;l<5;l++){
		this.listfosseplateau.add(new FossePlateau(id,k,l,false,"V"));
		id++;
		}
	}	
}


 // Permet d'initialiser le tableau et d'instensier toutes les listes parcelle du plateau prÃ©sentes dessus.
// un tableau 1D de 6X8 parcelle
 
public void initparcelleplateau(){
	int id=1;
	for(int i=0;i<6;i++){
		for(int j=0;j<8;j++){
		this.listparcelleplateau.add(new ParcellesPlateau(id++, i, j, false));
		}
	}
}
}
