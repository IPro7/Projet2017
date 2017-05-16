package ReseauClient_Serveur;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.Enumeration;
import ServiceInterfaces.*;

public class Serveur {
String host ;
	
	public static  InetAddress getAddress() throws Exception {
		 Enumeration<NetworkInterface> networkInterfaces = NetworkInterface
                       .getNetworkInterfaces();
               while (networkInterfaces.hasMoreElements()) {
                   NetworkInterface ni = (NetworkInterface) networkInterfaces
                           .nextElement();
                   Enumeration<InetAddress> nias = ni.getInetAddresses();
                   while(nias.hasMoreElements()) {
                       InetAddress ia= (InetAddress) nias.nextElement();
                       if (!ia.isLinkLocalAddress() 
                        && !ia.isLoopbackAddress()
                        && ia instanceof Inet4Address) {
                           return ia;
                       }
                   }
               }
		return null;
	}

	public static void initServeur()  throws Exception{
		;
		String host = getAddress().getHostAddress();
		
        System.out.println("[SERVEUR : "+host+"]");
       LocateRegistry.createRegistry(45000);
       
       
     

        System.setProperty("java.rmi.server.hostname",host);
        //
        System.setProperty("java.secutity.policy", "file:/C:\\Users\\mohamad\\workspace\\JeuSantiago-master\\JeuSantiago\\lib\\file.policy");
     
        System.setSecurityManager(new SecurityManager());
      
        
        Service server=new Service();
        
        Naming.rebind("rmi://"+host+":45000/santiago",server);

        System.out.println("La partie est automatiquement lancée si 5 joueurs sont connectés. Sinon, vous pouvez jouer à partir de trois joueurs en utilisant la commande GO");

        int i=0;
        while(true){ // ON COMMENCE MAINTENANT LA PARTIE
        if(server.getStart()==false){
        	i++; 
        	if(i==1000000000){System.out.println("GAMER PLEASE !!");}
        }
        if(server.getStart()){
        	if(server.getTourMaxr()==0){
        		if(server.getClient().size()==5){
        			server.setTourMax(11);
        		}
        		else{
        			server.setTourMax(9);
        		}
        	}
	        	if(server.getPhase()==1){
	        		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-\nTour \n=-=-=-=-=-=-=-=-=-="+server.getTour());
	        		System.out.println("===============\nPhase 1: Mise aux enchï¿½res des tuiles de plantation \n===============");
	        		//RETOURNER PILE
	        		for(int p=0; p<server.getListpilesplantation().size();p++){
	        			server.getListpilesplantation().get(p).getTuiles().get(0).setVisible(true);
	        		}
	        			
	        		
	        		int j=0;
	        		while(true){
	        				j++;
	        				if(j==1000000000){System.out.println("En attente d'enchere...");
	        			if(server.getEncheresCourantes().size()==server.getListepalyers().size()){
	        				System.out.println("toutes les encheres recue");
	        				server.phaseAprés();
	        				break;
	        				}
	        			}
	        	}
        	}
	        	if(server.getPhase()==2){
	        		server.playphase();
	        		server.phaseAprés();
	        		break;
	        	}
	        	
	        	if(server.getPhase()==4){
	        		//controller, changer les constructeur et ejt canaux
	        		server.playphase();
	        		break;
	        	}
	        	
	        	if(server.getPhase()==5){
	        		server.playphase();
	        		break;
	        	}
	        	
        }
	        	}
	        	
       
       
	}
}


