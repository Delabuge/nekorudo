/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nekoperudo.Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Pascal
 */
/**
 * La classe InterfaceJoueur définit les méthodes accessibles par RMI
 */
public interface Nekoperudo extends java.rmi.Remote {

    public boolean rejoindrePartie(String pseudo, JoueurNotification b, int pChoixPartie) throws java.rmi.RemoteException;

    public boolean JoueurPret(String pseudo, JoueurNotification b, int pChoixPartie) throws java.rmi.RemoteException;

    public void enregistrerNotification(String id, JoueurNotification b) throws java.rmi.RemoteException;

    public void actionJoueur(int choix, String pseudo, int pChoixPartie) throws java.rmi.RemoteException;

    public void surencherJoueur(int chiffre, int quantite, int pChoixPartie) throws java.rmi.RemoteException;
    
    public boolean selectionnerPartie(String pPseudo, int pChoixPartie, JoueurNotification pNotif)  throws java.rmi.RemoteException;

    public interface JoueurNotification extends Remote {

        public String initialiserPartie(String pAtoiDeJouer) throws RemoteException;

        public String notifVictoire(String pVictoire) throws RemoteException;
        
        public String notifLoose(String pLoose) throws RemoteException;

        public String prochainTour(String pAtoiDeJouer) throws RemoteException;

        public String nouveauTour(boolean pAtoiDeJouer) throws RemoteException;

        public String notifSurencherNbr(String nbrDice) throws RemoteException;
        
         public String notifTropDeJoueur(String pTropJoueur) throws RemoteException;

        //  public String notifSurencherVal(int valDice) throws RemoteException;
        public String nouvelleManche(String pAtoiDeJouer) throws RemoteException;       
    }
}
