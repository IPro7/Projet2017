package BeanSantigao;

public class ParcellesPlateau {
	private int idParcelle;
	private int parcelleX;// coordonnée abscisse du plateau
	private int pacelleY; // coordonnée ordonnée du plateau
	private boolean palmier;
	private boolean occupee;
	public int getIdParcelle() {
		return idParcelle;
	}
	
	
	public void setIdParcelle(int idParcelle) {
		this.idParcelle = idParcelle;
	}
	public ParcellesPlateau(int idParcelle, int parcelleX, int pacelleY, boolean palmier) {
		super();
		this.idParcelle = idParcelle;
		this.parcelleX = parcelleX;
		this.pacelleY = pacelleY;
		this.palmier = palmier;
	}

	public boolean getOccupee() {
		return occupee;
	}


	public int getParcelleX() {
		return parcelleX;
	}
	public void setParcelleX(int parcelleX) {
		this.parcelleX = parcelleX;
	}
	public int getPacelleY() {
		return pacelleY;
	}
	public void setPacelleY(int pacelleY) {
		this.pacelleY = pacelleY;
	}
	public boolean isPalmier() {
		return palmier;
	}
	public void setPalmier(boolean palmier) {
		this.palmier = palmier;
	}
	public boolean isOccupee() {
		return occupee;
	}
	public void setOccupee(boolean occupee) {
		this.occupee = occupee;
	}
	public ParcellesPlateau(int idParcelle, int parcelleX, int pacelleY, boolean palmier, boolean occupee) {
		super();
		this.idParcelle = idParcelle;
		this.parcelleX = parcelleX;
		this.pacelleY = pacelleY;
		this.palmier = palmier;
		this.occupee = occupee;
	}
	
	
	
	
	
	
	
	

}
