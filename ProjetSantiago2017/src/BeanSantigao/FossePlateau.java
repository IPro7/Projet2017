package BeanSantigao;

import java.io.Serializable;

public class FossePlateau implements Serializable {
	// identifiant des fossees du plateau
	private int idFosse;
	// coordonnee de l'abscisse des fosses
	private int coorabsX;  
	//coordonnee ordonne des fosses
	private int coorordY ;
	private boolean irrigue;
	// le sens des Fossee (horizontale || vertical)
	
	// GETTER AND SETTER
	private String sens;
	public int getIdFosse() {
		return idFosse;
	}
	public void setIdFosse(int idFosse) {
		this.idFosse = idFosse;
	}
	public int getCoorabsX() {
		return coorabsX;
	}
	public void setCoorabsX(int coorabsX) {
		this.coorabsX = coorabsX;
	}
	public int getCoorordY() {
		return coorordY;
	}
	public void setCoorordY(int coorordY) {
		this.coorordY = coorordY;
	}
	public boolean isIrrigue() {
		return irrigue;
	}
	public void setIrrigue(boolean irrigue) {
		this.irrigue = irrigue;
	}
	public String getSens() {
		return sens;
	}
	public void setSens(String sens) {
		this.sens = sens;
	}
	
		// constructeur de la classse
	
	public FossePlateau(int idFosse, int coorabsX, int coorordY, boolean irrigue, String sens) {
		super();
		this.idFosse = idFosse;
		this.coorabsX = coorabsX;
		this.coorordY = coorordY;
		this.irrigue = irrigue;
		this.sens = sens;
	} 
	
	
	
	
	
	
	

}
