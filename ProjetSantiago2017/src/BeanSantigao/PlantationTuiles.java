package BeanSantigao;

import java.io.Serializable;

public class PlantationTuiles  implements Serializable {
	
	
	public int getIdPlantation() {
		return idPlantation;
	}
	public void setIdPlantation(int idPlantation) {
		this.idPlantation = idPlantation;
	}
	public int getSourceX() {
		return SourceX;
	}
	public void setSourceX(int sourceX) {
		SourceX = sourceX;
	}
	public int getSourceY() {
		return SourceY;
	}
	public void setSourceY(int sourceY) {
		SourceY = sourceY;
	}
	public boolean isDesert() {
		return desert;
	}
	public void setDesert(boolean desert) {
		this.desert = desert;
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public String getPlante() {
		return plante;
	}
	public void setPlante(String plante) {
		this.plante = plante;
	}
	public int getTag_necessaires() {
		return tag_necessaires;
	}
	public void setTag_necessaires(int tag_necessaires) {
		this.tag_necessaires = tag_necessaires;
	}
	public int getTag_presents() {
		return tag_presents;
	}
	public void setTag_presents(int tag_presents) {
		this.tag_presents = tag_presents;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public boolean getVisible() {
		return visible;
	}
	private int idPlantation;
	private String plante;
	private int tag_necessaires;
	private int SourceX;
	private int SourceY;
	private boolean desert;
	private boolean visible;
	
	private int tag_presents;
	private int prix;
	public PlantationTuiles(int idPlantation, String plante, int tag_necessaires) {
		super();
		this.idPlantation = idPlantation;
		this.plante = plante;
		this.tag_necessaires = tag_necessaires;
	}
	public PlantationTuiles(int idPlantation, String plante, int tag_necessaires, int prix) {
		super();
		this.idPlantation = idPlantation;
		this.plante = plante;
		this.tag_necessaires = tag_necessaires;
		this.prix = prix;
	}
	
	
	
	

}


