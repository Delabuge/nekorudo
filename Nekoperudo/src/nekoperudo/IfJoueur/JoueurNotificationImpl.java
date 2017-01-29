/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nekoperudo.IfJoueur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import nekoperudo.IfJoueur.Nekoperudo.JoueurNotification;

/**
 *
 * @author Pascal
 */
public class JoueurNotificationImpl extends UnicastRemoteObject
        implements JoueurNotification {

    private String id;

    public JoueurNotificationImpl(String id) throws RemoteException {
        super();
        this.id = id;
    }

    public void test(String text) throws RemoteException {
        System.out.println(text + " Joueur Notif");
    }

}