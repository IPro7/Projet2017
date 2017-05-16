package TestsSantiago;

import static org.junit.Assert.*;

import java.net.UnknownHostException;
import java.rmi.RemoteException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import BeanSantigao.FossePlateau;
import BeanSantigao.PlateauSantiago;
import ServiceInterfaces.*;

public class TestPlateau { 



@Before
public void setUp() {
}

@After
public void tearDown() {
}

// TODO add test methods here.
// The methods must be annotated with annotation @Test. For example:
//
// @Test
// public void hello() {}

@Test  // verifie la mise en place des ID des parcelle
public  void  testIDParFos() throws RemoteException, UnknownHostException {
	PlateauSantiago pl = new PlateauSantiago(1,0,0);
	pl.initparcelleplateau();
            
            assertEquals(1,pl.get(0, 0).getIdParcelle());
	assertEquals(3,pl.get(0, 2).getIdParcelle());
	assertEquals(16,pl.get(1, 7).getIdParcelle());
}
    
@Test  // verifie le nombre de parcelle 
public  void  testNbparcelle() throws RemoteException, UnknownHostException {
	PlateauSantiago pl = new PlateauSantiago(1,0,0);
	pl.initparcelleplateau();
	assertNull(pl.get(5, 8));
	assertNull(pl.get(6, 1));
	assertNotNull(pl.get(5, 7));			
}
    
    
    @Test // Verifie le lancement automatique de la partie quand il y a 5 joueurs 
 public void test5Joueurs() throws RemoteException, UnknownHostException {
     
	Service Cinqjoueurs=new Service();
    
    
	FonctionnaliteInterface J1=new Service();
	FonctionnaliteInterface J2=new Service();
	FonctionnaliteInterface J3=new Service();
	FonctionnaliteInterface J4=new Service();
	FonctionnaliteInterface J5=new Service();
	Cinqjoueurs.setClient(J1);
	Cinqjoueurs.setClient(J2);
	Cinqjoueurs.setClient(J3);
	Cinqjoueurs.setClient(J4);
	Cinqjoueurs.setClient(J5);
    
	assertEquals(true, Cinqjoueurs.getStart()); 
 }

 @Test // Verifie le lancement possible de la partie à 3 joueurs et non à moins de 3 joueurs
public void test3joueurs() throws RemoteException, UnknownHostException {
    
	Service MoinDetroisJoueur=new Service();
    Service TroisJoueurs=new Service();
    Service QuatreJoueur=new Service();
    
	FonctionnaliteInterface J1=new Service();
	FonctionnaliteInterface J2=new Service();
	FonctionnaliteInterface J3=new Service();
    FonctionnaliteInterface J4=new Service();
    MoinDetroisJoueur.setClient(J1);
    MoinDetroisJoueur.RunPart();
	TroisJoueurs.setClient(J1);
	TroisJoueurs.setClient(J2);
	TroisJoueurs.setClient(J3);
	TroisJoueurs.RunPart();
    QuatreJoueur.setClient(J1);
	QuatreJoueur.setClient(J2);
    QuatreJoueur.setClient(J3);
    QuatreJoueur.setClient(J4);
    QuatreJoueur.RunPart();
   
    assertEquals(false, MoinDetroisJoueur.getStart()); 
	assertEquals(true, TroisJoueurs.getStart()); 
	assertEquals(true, QuatreJoueur.getStart()); 
}}


