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
                System.out.println("Surencherir");
                break;

            case 2:
                System.out.println("Menteur!");
                break;

            case 3:
                System.out.println("Tout-pile");
                break;

            default:
                System.out.println("Erreur de choix");
        }

    }

}
