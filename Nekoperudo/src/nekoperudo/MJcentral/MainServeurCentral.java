/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nekoperudo.MJcentral;
import nekoperudo.IfJoueur.InterfaceJoueur;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


/**
 *
 * @author Pascal
 */
public class MainServeurCentral {
    public static void main(String[] argv) {
        try {
            Registry registre = LocateRegistry.getRegistry(12345);
            InterfaceJoueur stub = (InterfaceJoueur) registre.lookup("lancerDice");
            System.out.println("Retour : " + stub.lancerDice(3));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}
