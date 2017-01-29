/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nekoperudo.MJcentral;

import static java.lang.Thread.sleep;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import nekoperudo.IfJoueur.JoueurNotificationImpl;
import nekoperudo.IfJoueur.Nekoperudo;

/**
 *
 * @author Rémi
 */
public class MainServeurImpl extends UnicastRemoteObject implements Nekoperudo {

    List<Joueur> listeJoueurs = new ArrayList<Joueur>();

    public MainServeurImpl() throws RemoteException {
        super();
    }

    public static void main(String[] argv) throws Exception {

        LocateRegistry.createRegistry(1099);
        Naming.rebind("MJ", new MainServeurImpl());
        System.out.println("MJ est enregistré");

        /*  
        int i;
        int nbJoueur = 3;
        int gobelet[] = new int[5];
        Mise m = new Mise(0, 2);
        List<Joueur> listeJoueurs = new ArrayList<Joueur>();
        Joueur j = new Joueur(5, "MJ", gobelet);
        boolean finManche = false;

        listeJoueurs = proxy.initialiserPartie(nbJoueur);

        proxy.jetterDes(listeJoueurs);

        do {
            for (i = 0; i < nbJoueur; i++) {

                finManche = listeJoueurs.get(i).jouerTour(listeJoueurs, m, i);
                // Joueur valide fin de son tour

                if (finManche = true) {
                    break;
                }
            }
        } while (finManche == false);
    }*/
    }

    public synchronized void afficherMsg(String id, int somme) throws RemoteException {

    }

    public synchronized void enregistrerNotification(String id, JoueurNotification b) throws RemoteException {
        Joueur cpt = new Joueur();
        cpt.setNotification(b);
    }


    public void letest(String id) throws RemoteException {
       /* Joueur cptttt = new Joueur();
        int i =2;
        cptttt.afficherMsg(i);*/
        System.out.println(id + " est aware");
    }

}
