package BeanSantigao;
import  BeanSantigao.*;
import ReseauClient_Serveur.*;

public class JeuSantiago {
	private static JeuSantiago INSTANCE = new JeuSantiago();
	private Serveur serveur;
	private  Clients client;

	public JeuSantiago(){
		this.serveur=new Serveur();
		this.client=null;
	}

	public static JeuSantiago getSantiago() {
		return INSTANCE;
	}

	public void demarrerServeur(){
		try {
			this.serveur.initServeur();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static JeuSantiago getINSTANCE() {
		return INSTANCE;
	}

	public static void setINSTANCE(JeuSantiago iNSTANCE) {
		INSTANCE = iNSTANCE;
	}

	public Serveur getServeur() {
		return serveur;
	}

	public void setServeur(Serveur serveur) {
		this.serveur = serveur;
	}

	public Clients getClient() {
		return client;
	}

	public void setClient(Clients client2) {
		this.client=client2;
		
	}


}




