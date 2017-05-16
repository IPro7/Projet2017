package BeanSantigao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;



public class Players   implements Comparable<Players>,Serializable {
	
	private int idjoueur ;
	private String NomJoueurs ;
	private String couleurs ;
	private int rang;
	private int canal_perso;
	private boolean canal_bleu;
	private int cagnotte;
	private int NbTag ;
	private boolean est_construitcanal;
	private List<PlantationTuiles> tuiles_joueur;
	private boolean enligne;
	
	
	private boolean online;


	private boolean bluecanal;
	
	// constructeur 
	public Players(int idjoueur, String nomJoueurs, String couleurs, int rang) {
		super();
		this.idjoueur = idjoueur;
		NomJoueurs = nomJoueurs;
		this.couleurs = couleurs;
		this.rang = rang;
		this.canal_perso = 1;
		this.canal_bleu = true;
		this.cagnotte = 10;
		this.NbTag =22;
		this.est_construitcanal = false;
	
		this.tuiles_joueur = new ArrayList<PlantationTuiles>();
		this.enligne=true;
		
	}
	
// constructeur
	
	public Players(int idjoueur, String nomJoueurs, String couleurs, int rang, int canal_perso, boolean canal_bleu,
			int cagnotte, int nbTag) {
		super();
		this.idjoueur = idjoueur;
		NomJoueurs = nomJoueurs;
		this.couleurs = couleurs;
		this.rang = rang;
		this.canal_perso = canal_perso;
		this.canal_bleu = true;
		this.cagnotte = cagnotte;
		NbTag = nbTag;
		
		this.cagnotte=10;
		this.NbTag=22;
		this.rang=rang;
		this.est_construitcanal = false;
	
		this.tuiles_joueur=new ArrayList<PlantationTuiles>();
	}
	
public Players(int idJoueur, String nomJoueurs, int rang, String couleur){
		
		this.idjoueur = idJoueur;
		this.NomJoueurs = nomJoueurs;
		this.rang = rang;
		this.couleurs = couleur;
		this.canal_perso =1 ;
		this.canal_bleu = true ;
		this.cagnotte=5;
		this.NbTag=10;
		this.rang=rang;
		this.est_construitcanal=false;
	
	}
	// constructeur et initialisation des variables 
	public Players(int idjoueur, String nomJoueurs, String couleurs, int rang, int canal_perso, boolean canal_bleu,
			int cagnotte, int nbTag, boolean est_construitcanal, boolean montour,
			List<PlantationTuiles> tuiles_joueur) {
		super();
		this.idjoueur = idjoueur;
		NomJoueurs = nomJoueurs;
		this.couleurs = couleurs;
		this.rang = rang;
		this.canal_perso = canal_perso;
		this.canal_bleu = canal_bleu;
		this.cagnotte = cagnotte;
		NbTag = nbTag;
		this.est_construitcanal = est_construitcanal;
	
		this.tuiles_joueur = tuiles_joueur;
	}
	public void setEst_constructeurdecanal(boolean estConstructeurdecanal) {
		this.est_construitcanal = estConstructeurdecanal;
	}


	public int getRang() {
		return rang;
	}

	public void setRang(int rang) {
		this.rang = rang;
	}

	public List<PlantationTuiles> getTuiles_joueur() {
		return tuiles_joueur;
	}
	
	public boolean getConstructeur(){
		return this.est_construitcanal;
	}
	
	
	public boolean getBluecanal() {
		return bluecanal;
	}
	
	
	public int getNbTag() {
		return NbTag;
	}


	public void setNbTag(int nbTag) {
		NbTag = nbTag;
	}


	public boolean getEst_constructeurdecanal() {
		return est_construitcanal;
	}
	
	
	public int getCagnotte() {
		return cagnotte;
	}
	public void setCagnotte(int cagnotte) {
		this.cagnotte = cagnotte;
	}
	public void setOnline(boolean online) {
		this.online = online;
	}
	public Players(int idjoueur, String nomJoueurs, String couleurs) {
		super();
		this.idjoueur = idjoueur;
		NomJoueurs = nomJoueurs;
		this.couleurs = couleurs;
	}
	public int getIdjoueur() {
		return idjoueur;
	}
	public void setIdjoueur(int idjoueur) {
		this.idjoueur = idjoueur;
	}
	public String getNomJoueurs() {
		return NomJoueurs;
	}
	public void setNomJoueurs(String nomJoueurs) {
		NomJoueurs = nomJoueurs;
	}
	public String getCouleurs() {
		return couleurs;
	}
	public void setCouleurs(String couleurs) {
		this.couleurs = couleurs;
	}
	
	public boolean isOnline() {
		return online;
	}

	@Override
	public int compareTo(Players o) {
		
		// TODO Auto-generated method stub
		return 0;
	}

	 public static class Comparators {
      
	    }
	
	
	
	
	

}
