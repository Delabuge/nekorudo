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

/**La classe InterfaceJoueur définit les méthodes accessibles par RMI*/
public interface InterfaceJoueur extends Remote {
    public void Joueur(int pNbDice, String pCouleurJoueur) throws RemoteException;
    public int lancerDice(int NbDice) throws RemoteException;
    public void actionJoueur(int choixJoueur) throws RemoteException;
    public void surencherir(int pNbDiceParier, int pValDice) throws RemoteException;
    public void terminerManche(int choixJoueur) throws RemoteException;
}