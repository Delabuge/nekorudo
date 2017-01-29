/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nekoperudo.IfJoueur;

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

    public void letest(String id) throws java.rmi.RemoteException;

    
    
    public void enregistrerNotification(String id, JoueurNotification b) throws java.rmi.RemoteException;

    public interface JoueurNotification extends Remote {

        public void test(String texte)
                throws RemoteException;

    }
}
