/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nekoperudo.IfJoueur;
import nekoperudo.MJcentral.InterfaceJoueur;
import java.rmi.RemoteException;
/**
 *
 * @author Remi
 */

/**La classe Joueur contient l'implémentation des méthodes du Joueur*/
public class Joueur implements InterfaceJoueur{

    public int nbDice;
    public String couleurJoueur;
    int gobelet[] = new int[5];
    int nbDiceParier = 0;
    int valDiceParier = 0;

    public void Joueur(int pNbDice, String pCouleurJoueur) throws RemoteException{
        nbDice = pNbDice;
        couleurJoueur = pCouleurJoueur;
    }

    
    //PROBLEME ICI : on lors de l'appel du serveur central on ne parcourt pas le tableau gobelet
    //RQ : retourner au serveur le contenu du tableau lui permettrait d'avoir une vue globale sur 
    //la partie, ce qui explique pourquoi les dés ont une couleur. 
    //Donc le gobelet serait plutot du type Dice.
    public int lancerDice(int NbDice) throws RemoteException{
        int i;
        
        
        Dice d1 = new Dice(couleurJoueur);
        
        for (i = 0; i < NbDice; i++) {
            gobelet[i] = d1.rollTheDice();
        }
        return 0;
    }

    public int actionJoueur(int choixJoueur) throws RemoteException{

        switch (choixJoueur) {

            case 1:
                terminerManche(choixJoueur);
                break;

            case 2:
                terminerManche(choixJoueur);
                break;

            case 3:
                surencherir(nbDiceParier, valDiceParier);
                break;

            default:
                System.out.println("Erreur dans le choix de l'action du joueur");
        }
        return 0;
    }

    public void surencherir(int pNbDiceParier, int pValDice) {
        int nbDiceParier=0;
        int valDice=0;

        
        if (nbDiceParier > pNbDiceParier || valDice > pValDice){
            //Mise1.setNbDiceParier(nbDiceParier);
            //Mise1.setValDice(valDice);
        }
        else {
            //Erreur : recommencer la saisie ou retourner à la selection de choix
        }
        
    }

    public void terminerManche(int choixJoueur) throws RemoteException{

        switch (choixJoueur) {

            //Annonce Menteur
            case 1:

                break;

            //Annonce Tout-pile
            case 2:

                break;

            default:
                System.out.println("Erreur dans le choix de l'action du joueur");
        }

    }

}
