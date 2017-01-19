/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nekoperudo.IfJoueur;
import nekoperudo.MJcentral.InterfaceJoueur;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author Pascal
 */
public class MainJoueur {
    public static void main(String[] argv) {
        try {
        	// 10000 est le port sur lequel sera publié le service. Nous devons le préciser à la fois sur le registry et à la fois à la création du stub.
            InterfaceJoueur skeleton = (InterfaceJoueur) UnicastRemoteObject.exportObject(new Joueur(), 12345); // Génère un stub vers notre service.
            Registry registry = LocateRegistry.createRegistry(12345);
            registry.rebind("lancerDice", skeleton); // publie notre instance sous le nom "Add"
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}