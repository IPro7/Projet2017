package ReseauClient_Serveur;

import java.rmi.Naming;

import BeanSantigao.Players;

import ServiceInterfaces.FonctionnaliteInterface;
import ServiceInterfaces.Service;

public class Clients {
	
	private String host;
	private String nom;
	private Players player;
	
	
	
	public Clients(String host, String nom) {
		super();
		this.host = host;
		this.nom = nom;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Players getPlayer() {
		return player;
	}
	public void setPlayer(Players player) {
		this.player = player;
	}
	
	// cette méhode permet de crer un client au serveur 
	public void ConnexionClient () throws Exception{
	
	String myHost= this.host;
	System.setProperty("java.rmi.server.hostname",myHost);
	System.out.println("[players]");
	System.setSecurityManager(new SecurityManager());
    FonctionnaliteInterface client=new Service();
 
    FonctionnaliteInterface server=(FonctionnaliteInterface)Naming.lookup("rmi://"+host+":45000/santiago");
    System.out.println("Connection du Serveur");
    server.setClient(client); 
    int nbJoueurs=server.getClient().size();
    if(nbJoueurs<=5){ 
		System.out.println("Votre couleur sera le "+server.getCouleur(nbJoueurs-1));
		this.player=new Players(nbJoueurs,this.nom,server.getCouleur(nbJoueurs-1));
		server.addPlayer(this.player); // cette methode ajout un j
	

		
		
    }
    
    

}

}
