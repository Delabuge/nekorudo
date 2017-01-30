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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import nekoperudo.IfJoueur.JoueurNotificationImpl;
import nekoperudo.IfJoueur.Nekoperudo;

/**
 *
 * @author Rémi
 */
public class MainServeurImpl extends UnicastRemoteObject implements Nekoperudo {

    Map<String, JoueurNotification> listeCoJoueurs = new HashMap<String, JoueurNotification>(6);
    Map<String, Joueur> listeJoueurs = new HashMap<String, Joueur>(6);

    //List<Joueur> listeJoueurs = new ArrayList<Joueur>();
    String[] couleurJoueur = {"Blanc", "Bleu", "Jaune", "Noir", "Rouge", "Vert"};
    int gob[] = new int[5];

    public MainServeurImpl() throws RemoteException {
        super();
    }

    public static void main(String[] argv) throws Exception {

        LocateRegistry.createRegistry(1099);
        Naming.rebind("MJ", new MainServeurImpl());
        System.out.println("Registre RMI OK");

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

    public boolean rejoindrePartie(String pPseudo, JoueurNotification pNotif) throws RemoteException {
        boolean joueurAjouteOk = false;
        Mise miseJ = new Mise(0, 2);

        if (listeJoueurs.size() < 6) {
            if (listeJoueurs.isEmpty()) {
                listeJoueurs.put(pPseudo, new Joueur(5, couleurJoueur[1], gob, pPseudo, false, pNotif, miseJ, false));
                listeCoJoueurs.put(pPseudo, pNotif);
                System.out.println("Joueur " + pPseudo + " créé");
                joueurAjouteOk = true;
            } else {
                listeJoueurs.put(pPseudo, new Joueur(5, couleurJoueur[listeJoueurs.size() + 1], gob, pPseudo, false, pNotif, miseJ, false));
                listeCoJoueurs.put(pPseudo, pNotif);
                System.out.println("Joueur " + pPseudo + " créé");
                joueurAjouteOk = true;
            }
        }
        return joueurAjouteOk;
    }

    public boolean JoueurPret(String pPseudo, JoueurNotification pNotif) throws RemoteException {
        boolean JoueurPretOk = false;
        int i;
        int nbrJoueurPret = 0;
        NotifInitialisation ntfI = new NotifInitialisation("", false);

        if (listeJoueurs.containsKey(pPseudo)) {
            listeJoueurs.get(pPseudo).JoueurPret = true;
            JoueurPretOk = true;
        }

        for (i = 0; i < listeJoueurs.size(); i++) {
            if (listeJoueurs.get(i).JoueurPret = true) {
                nbrJoueurPret = nbrJoueurPret + 1;
            }
        }

        if (nbrJoueurPret == listeJoueurs.size()) {

            Random joueurRandom = new Random();
            int numJoueurRandom = joueurRandom.nextInt(listeJoueurs.size()) + 1;
            
            listeJoueurs.get(numJoueurRandom).AToiDeJouer = true;
            
            for (i = 0; i < listeJoueurs.size(); i++){
                listeCoJoueurs.get(i).initialiserPartie("");
            }            
        }

        return JoueurPretOk;
    }

}
