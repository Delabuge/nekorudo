/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nekoperudo.IfJoueur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import nekoperudo.IHM.ChoixAction;
import nekoperudo.IHM.FileAttente;
import nekoperudo.IfJoueur.Nekoperudo.JoueurNotification;
import nekoperudo.MJcentral.Joueur;

/**
 *
 * @author Pascal
 */
public class JoueurNotificationImpl extends UnicastRemoteObject
        implements JoueurNotification {

    private String id;
    FileAttente fAttente;
    ChoixAction chAction;
    Joueur objetJoueur;

    public JoueurNotificationImpl(String id) throws RemoteException {
        super();
        this.id = id;
    }

    public void test(String text) throws RemoteException {
        System.out.println(text + " Joueur Notif");
    }

    public String initialiserPartie(String pAToiDeJouer) throws RemoteException {
        try {

            fAttente.frameInitialiserPartie(pAToiDeJouer);
        } catch (InterruptedException ex) {
            Logger.getLogger(JoueurNotificationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "";
    }

    public String prochainTour(String pAToiDeJouer) throws RemoteException {
        try {

            fAttente.frameInitialiserPartie(pAToiDeJouer);
        } catch (InterruptedException ex) {
            Logger.getLogger(JoueurNotificationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "";
    }

    public String nouveauTour(boolean pAToiDeJouer) throws RemoteException {
        chAction.setaToiDeJouer(pAToiDeJouer);
        return "";
    }

    public String nouvelleManche(String pAToiDeJouer) throws RemoteException {
        chAction.frameNouvelleManche(pAToiDeJouer);
        return "";
    }

    public void setFileAttente(FileAttente pFa) {
        this.fAttente = pFa;
    }

    public void setChoixAction(ChoixAction pCA) {
        this.chAction = pCA;
    }

    public void actualiserJoueur() {
        //
    }

    public void setaToiDeJouer(boolean b) {
        chAction.setaToiDeJouer(b);
    }

    public String notifSurencherNbr(String nbrDice) throws RemoteException {

        try {
            chAction.frameNotifSurencherNbr(nbrDice);

        } catch (InterruptedException ex) {
            Logger.getLogger(JoueurNotificationImpl.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public String notifVictoire(String fddds) throws RemoteException {

        chAction.frameNotifVictoire(fddds);

        return "";
    }

    public String notifLoose(String dsg) throws RemoteException {
        chAction.frameNotifLoose(dsg);

        return "";
    }

}
