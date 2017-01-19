/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nekoperudo.IfJoueur;

/**
 *
 * @author Remi
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

    public void lancerDice(int NbDice) {
        int i;

        Dice d1 = new Dice(couleurJoueur);

        for (i = 0; i < nbDice; i++) {
            gobelet[i] = d1.rollTheDice();
        }
    }

    public void actionJoueur(int choixJoueur) {

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

    public void terminerManche(int choixJoueur) {

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
