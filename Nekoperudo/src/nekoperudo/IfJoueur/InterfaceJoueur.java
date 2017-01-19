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

public interface InterfaceJoueur extends Remote {
    public void lancerDice(int NbDice) throws RemoteException;
}