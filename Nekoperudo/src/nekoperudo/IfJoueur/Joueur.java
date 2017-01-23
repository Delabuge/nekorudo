/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nekoperudo.IfJoueur;

import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import nekoperudo.IfJoueur.Mise;

/**
 *
 * @author Remi
 */
/**
 * La classe Joueur contient l'implémentation des méthodes du Joueur
 */
public class Joueur {

    public int nbDice;
    public String couleurJoueur;
    int gobelet[] = new int[5];
    int nbDiceParier = 0;
    int valDiceParier = 0;

    public Joueur(int pNbDice, String pCouleurJoueur) {
        nbDice = pNbDice;
        couleurJoueur = pCouleurJoueur;
    }

    //PROBLEME ICI : on lors de l'appel du serveur central on ne parcourt pas le tableau gobelet
    //RQ : retourner au serveur le contenu du tableau lui permettrait d'avoir une vue globale sur 
    //la partie, ce qui explique pourquoi les dés ont une couleur. 
    //Donc le gobelet serait plutot du type Dice.
    public int lancerDice(int NbDice) {
        int i;

        Dice d1 = new Dice(couleurJoueur);

        for (i = 0; i < NbDice; i++) {
            gobelet[i] = d1.rollTheDice();
        }
        return 0;
    }

    public int actionJoueur(int choixJoueur, Mise m)  {

        switch (choixJoueur) {

            case 1:
                terminerManche(choixJoueur);
                break;

            case 2:
                terminerManche(choixJoueur);
                break;

            case 3:
                surencherir(m);
                break;

            default:
                System.out.println("Erreur dans le choix de l'action du joueur");
        }
        return choixJoueur;
    }

    public void surencherir(Mise m) {
        int nbDiceParier = 4;
        int valDice = 5;

        // Condition ok pour la surenchere :  soit en augmentant le nombre de dés, soit en augmentant la valeur ou bien les deux
        if (nbDiceParier > m.getNbDiceParier() || valDice > m.getValDice()) {
            m.setNbDiceParier(nbDiceParier);
            m.setValDice(valDice);
            
        } else {
            // Erreur : recommencer la saisie ou retourner à la selection de choix
        }
        
    }

    public void terminerManche(int choixJoueur)  {

        
        switch (choixJoueur) {

            // Annonce Menteur
            case 1:

                break;

            // Annonce Tout-pile
            case 2:

                break;
                
            // Annonce Surenchere
            case 3:

                break;

            default:
                System.out.println("Erreur dans le choix de l'action du joueur");
        }

    }

    private void terminerTour() {
         
    }
}
